package com.mylabs.pds.service;

import com.itextpdf.text.DocumentException;
import com.mylabs.pds.model.Tarea;
import com.mylabs.pds.repository.ConfiguracionRepository;
import com.mylabs.pds.utils.GitHubContent;
import com.mylabs.pds.utils.IClassGenerator;
import com.mylabs.pds.utils.PdfUtil;
import com.mylabs.pds.utils.ZipUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class GitHubApiRestAccessService {
    private static final String GITHUB_API_URL = "https://api.github.com";
    private static final String GITLAB_API_URL = "https://giss.gitlab.repo...elque sea";
    private static final String INIT_BASE_DIR = "/src/main/java";
    private static final String INIT_BASE_TEST_DIR = "/src/test/java";
    private static final String BRANCH_NAME = "develop";

    @Autowired
    private ConfiguracionRepository configRepository;
    private RestTemplate restTemplate;
    private IClassGenerator classGenerator;
    private String owner;
    private String repositoryName;

    public GitHubApiRestAccessService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
    private String accessGitLab(final HttpHeaders headers) {
        String token = this.configRepository.findById(2L).isPresent()
                ? this.configRepository.findById(2L).get().getCodigo() : "unknown";
        String baseUriPattern = GITLAB_API_URL + "/projects/%s/%s/repository/tree?ref=%s";
        headers.set("PRIVATE-TOKEN", token); // Use "PRIVATE-TOKEN" header for GitLab
        return String.format(baseUriPattern, this.owner, this.repositoryName, INIT_BASE_DIR, BRANCH_NAME);
    }
    private String accessGitHub(final HttpHeaders headers) {
        String token = this.configRepository.findById(1L).isPresent()
                ? this.configRepository.findById(1L).get().getCodigo() : "unknown";
        String baseUriPattern = GITHUB_API_URL + "/repos/%s/%s/contents%s?ref=%s";
        headers.set("Authorization", "token " + token);
        return String.format(baseUriPattern, this.owner, this.repositoryName, INIT_BASE_DIR , BRANCH_NAME);
    }
    public final List<Tarea> scanRepository(final String owner, final String repositoryName,
                                      final IClassGenerator classGenerator) {

        this.classGenerator = classGenerator;
        this.repositoryName = repositoryName;
        this.owner = owner;
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        String newGitApiUrl = accessGitHub(headers);
        //String newGitApiUrl = accessGitLab(headers);

        String baseUriPattern = GITHUB_API_URL + "/repos/%s/%s/contents%s?ref=%s";
        //String baseUriPattern = GITLAB_API_URL + "/repos/%s/%s/contents%s?ref=%s";

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<GitHubContent[]> responseInner = restTemplate.exchange(newGitApiUrl, HttpMethod.GET, entity,
                GitHubContent[].class);
        GitHubContent[] contentsInner = responseInner.getBody();
        List<Tarea> tareas = new ArrayList<>();
        Long idInitial = 1L;
        int i = 0;
        for (GitHubContent contentItem : contentsInner) {
            // llamada recursiva para descubrir los fuentes java
            tareas.add(scanDir(idInitial + (i++), contentItem, baseUriPattern, INIT_BASE_DIR, BRANCH_NAME,
                    entity));
        }
        byte[] bytesOfZipped = new ZipUtil().generarZipDesdeTareas(tareas);
        //tareas = this.tareaRepository.saveAll(tareas);
        return tareas;
    }
    private Tarea scanDir(final Long idAssigned, final GitHubContent content, final String baseUriPattern,
                          final String initDirBase, final String branch, final HttpEntity<String> entity) {
        Tarea tarea;
        if (content.getType().equals("file") && content.getName().endsWith(".java")) {
            // El archivo es un archivo Java, lee su contenido
            String fileContentUrl = content.getDownload_url();
            ResponseEntity<String> fileResponse = restTemplate.exchange(fileContentUrl,
                    HttpMethod.GET, entity, String.class);
            String javaFileContent = fileResponse.getBody();
            //System.out.println("Contenido del archivo " + content.getName() + ":\n" + javaFileContent);
            tarea = this.classGenerator.generateTestClassForJavaFile(idAssigned, javaFileContent);
            if (tarea != null) {
                tarea.setSourceScanned(initDirBase); //baseDir
            }
        } else {
            // me creo y creo una lista de hijos que lleno con llamadas recursivas de cada uno
            tarea = new Tarea();
            tarea.setId(idAssigned);
            tarea.setSourceScanned(initDirBase + "/" + content.getName()); //baseDir
            tarea.setType("FOLDER");
            tarea.setTestName(content.getName());
            tarea.setChildren(new ArrayList<>());
            //tarea = this.tareaRepository.save(tarea);
            System.out.println("el archivo "+  content.getName() + " es un " + content.getType()
                    + "...lanzo una llamada recursiva");
            String newGithubApiUrl = String.format(baseUriPattern, this.owner, this.repositoryName,
                    initDirBase + "/" + content.getName(), branch);
            ResponseEntity<GitHubContent[]> responseInner = restTemplate.exchange(newGithubApiUrl,
                    HttpMethod.GET, entity, GitHubContent[].class);
            GitHubContent[] contentsInner = responseInner.getBody();
            if (contentsInner != null) {
                long idNewAssigned = idAssigned * 10;
                for (GitHubContent contentItem : contentsInner) {
                    Tarea tareaChild = scanDir(idNewAssigned++, contentItem, baseUriPattern,
                            initDirBase + "/" + content.getName(), branch, entity);
                    if (tareaChild != null) {
                        tareaChild.setParentId(idAssigned);
                        tarea.getChildren().add(tareaChild);
                    }
                }
            }
        }
        return tarea;
    }


    public final Tarea scanTestCobertura(final String owner, final String repositoryName, final List<Tarea> metodos,
                                      final IClassGenerator classGenerator) {

        this.classGenerator = classGenerator;
        this.repositoryName = repositoryName;
        this.owner = owner;
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        String newGitApiUrl = accessGitHub(headers);
        String baseUriPattern = GITHUB_API_URL + "/repos/%s/%s/contents%s?ref=%s";

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<GitHubContent[]> responseInner = restTemplate.exchange(newGitApiUrl, HttpMethod.GET, entity,
                GitHubContent[].class);
        GitHubContent[] contentsInner = responseInner.getBody();
        List<Tarea> testMetodos = new ArrayList<>();
        long idInitial = 1L;
        int i = 0;
        for (GitHubContent contentItem : contentsInner) {
            // recursive-call para descubrir la lista de test-methods, y como children, los métodos de /main invocados
            scanTestDir(idInitial + (i++), contentItem, baseUriPattern, INIT_BASE_TEST_DIR,
                    BRANCH_NAME, entity, testMetodos);
        }
        Tarea tarea = new Tarea();
        tarea.setId(1L);
        return tarea;
    }
    private void scanTestDir(final Long idAssigned, final GitHubContent content, final String baseUriPattern,
                          final String initDirBase, final String branch, final HttpEntity<String> entity,
                              final List<Tarea> tareasAcumuladas) {

        if (content.getType().equals("file") && content.getName().endsWith(".java")) {
            String fileContentUrl = content.getDownload_url();
            ResponseEntity<String> fileResponse = restTemplate.exchange(fileContentUrl,
                    HttpMethod.GET, entity, String.class);
            String javaFileContent = fileResponse.getBody();
            List<Tarea> tareasTestMethods = this.classGenerator.generateTestMethods(idAssigned, javaFileContent);
            if (tareasTestMethods != null && !tareasTestMethods.isEmpty()) {
                tareasAcumuladas.addAll(tareasTestMethods);
            }
        } else {
            // hago llamada recursiva hasta que encuentre una clase .java
            String newGithubApiUrl = String.format(baseUriPattern, this.owner, this.repositoryName,
                    initDirBase + "/" + content.getName(), branch);
            ResponseEntity<GitHubContent[]> responseInner = restTemplate.exchange(newGithubApiUrl,
                    HttpMethod.GET, entity, GitHubContent[].class);
            GitHubContent[] contentsInner = responseInner.getBody();
            if (contentsInner != null) {
                long idNewAssigned = idAssigned * 10;
                for (GitHubContent contentItem : contentsInner) {
                    scanTestDir(idNewAssigned++, contentItem, baseUriPattern,
                            initDirBase + "/" + content.getName(), branch, entity, tareasAcumuladas);
                }
            }
        }
    }

    public Tarea getMethodsWithCoverage(final Tarea metodosRoot, final Tarea testMetodosRoot)
            throws DocumentException, IOException {
        // recorremos la lista de metodos; para cada uno, vemos si tiene o no aparición en el conjunto de test-methods
        List<Tarea> metodos = metodosRoot.getChildren();
        List<Tarea> testMetodos = testMetodosRoot.getChildren();
        metodos.forEach((metodo) -> {
            boolean esInvocadoAlMenosUnaVez = false;
            int j = 0;
            while (!esInvocadoAlMenosUnaVez && j < testMetodos.size()) {
                Tarea testMethod = testMetodos.get(j++);
                String qName = metodo.getqName();
                String[] splitterOfQName = qName.split("\\.");
                String methodName = splitterOfQName[splitterOfQName.length - 1];
                metodo.setMethodName(methodName);
                String classOfMethod = splitterOfQName[splitterOfQName.length - 2];
                metodo.setClassName(classOfMethod);
                String packageOfMethod = qName.replaceAll("."+ classOfMethod + "." + methodName, "");
                metodo.setPackageName(packageOfMethod);
                if (testMethod.getContents().indexOf(packageOfMethod) != -1
                        && testMethod.getContents().indexOf(classOfMethod) != -1
                        && (testMethod.getContents().indexOf(methodName + " (") != -1
                        || testMethod.getContents().indexOf(methodName + "(") != -1)) {
                    esInvocadoAlMenosUnaVez = true;
                }
            }
            metodo.setCoverage(esInvocadoAlMenosUnaVez);
        });
        Tarea tarea = new Tarea();
        tarea.setId(1L);
        tarea.setArrayOfBytes(new PdfUtil().getJavaMethodsCoverageReport(metodos));
        return tarea;
    }


}
