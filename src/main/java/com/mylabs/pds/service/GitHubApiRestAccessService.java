package com.mylabs.pds.service;

import com.mylabs.pds.model.Tarea;
import com.mylabs.pds.repository.ConfiguracionRepository;
import com.mylabs.pds.repository.TareaRepository;
import com.mylabs.pds.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class GitHubApiRestAccessService {

    private static final String GITHUB_API_URL = "https://api.github.com";
    private static final String INIT_BASE_DIR = "/src/main/java";
    private RestTemplate restTemplate;

    @Autowired
    private TareaRepository tareaRepository;

    @Autowired
    private ConfiguracionRepository configRepository;

    private IClassGenerator classGenerator;

    public GitHubApiRestAccessService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public List<Tarea> scanRepository(final String owner, final String repository,
                                      final IClassGenerator classGenerator) {
        this.classGenerator = classGenerator;
        String token = this.configRepository.findById(1L).isPresent()
                ? this.configRepository.findById(1L).get().getCodigo() : "unknown";

        String baseUriPattern = GITHUB_API_URL + "/repos/%s/%s/contents%s?ref=%s";
        String initDirBase = INIT_BASE_DIR;
        String branch = "develop";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", "token " + token);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        String newGithubApiUrl = String.format(baseUriPattern, owner, repository, initDirBase , branch);
        ResponseEntity<GitHubContent[]> responseInner = restTemplate.exchange(newGithubApiUrl,
                HttpMethod.GET, entity, GitHubContent[].class);
        GitHubContent[] contentsInner = responseInner.getBody();
        List<Tarea> tareas = new ArrayList<>();
        for (GitHubContent contentItem : contentsInner) {
            // llamada recursiva para descubrir los fuentes java
            tareas.add(scanDir(contentItem, baseUriPattern, owner, repository, initDirBase, branch, entity));
        }
        byte[] bytesOfZipped = new ZipUtil().generarZipDesdeTareas(tareas);
        tareas = this.tareaRepository.saveAll(tareas);
        return tareas;
    }

    private Tarea scanDir(final GitHubContent content, final String baseUriPattern,
                         final String owner, final String repository,
            final String initDirBase, final String branch, final HttpEntity<String> entity) {
        if (content.getType().equals("file") && content.getName().endsWith(".java")) {
            // El archivo es un archivo Java, lee su contenido
            String fileContentUrl = content.getDownload_url();
            ResponseEntity<String> fileResponse = restTemplate.exchange(fileContentUrl,
                    HttpMethod.GET, entity, String.class);
            String javaFileContent = fileResponse.getBody();
            //System.out.println("Contenido del archivo " + content.getName() + ":\n" + javaFileContent);
            return this.classGenerator.generateTestClassForJavaFile(javaFileContent);

        } else {
            // me creo y creo una lista de hijos que lleno con llamadas recursivas de cada uno
            Tarea tareaFolder = new Tarea();
            tareaFolder.setOriginPathToTest(initDirBase + "/" + content.getName()); //baseDir parent
            tareaFolder.setType("FOLDER");
            tareaFolder.setTestName(content.getName());
            tareaFolder.setChildrenTasks(new ArrayList<>());
            tareaFolder = this.tareaRepository.save(tareaFolder);
            System.out.println("el archivo "+  content.getName() + " es un " + content.getType()
                    + "...lanzo una llamada recursiva");
            String newGithubApiUrl = String.format(baseUriPattern, owner, repository,
                    initDirBase + "/" + content.getName(), branch);
            ResponseEntity<GitHubContent[]> responseInner = restTemplate.exchange(newGithubApiUrl,
                    HttpMethod.GET, entity, GitHubContent[].class);
            GitHubContent[] contentsInner = responseInner.getBody();
            for (GitHubContent contentItem : contentsInner) {
                Tarea tareaChild = scanDir(contentItem, baseUriPattern, owner, repository,
                        initDirBase  + "/" + content.getName(), branch, entity);
                if (tareaChild != null) {
                    tareaFolder.getChildrenTasks().add(tareaChild);
                }
            }
            return tareaFolder;
        }
    }

}