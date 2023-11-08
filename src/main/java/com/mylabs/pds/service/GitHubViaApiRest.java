package com.mylabs.pds.service;

import com.mylabs.pds.model.Tarea;
import com.mylabs.pds.repository.ConfiguracionRepository;
import com.mylabs.pds.repository.TareaRepository;
import com.mylabs.pds.utils.GitHubContent;
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
public class GitHubViaApiRest {

    private static final String GITHUB_API_URL = "https://api.github.com";
    private RestTemplate restTemplate;
    private byte[] bytesOfZipped;

    @Autowired
    private TareaRepository tareaRepository;

    @Autowired
    private ConfiguracionRepository configRepository;

    public GitHubViaApiRest(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public List<Tarea> scanRepository(String owner, String repository) {
        String token = this.configRepository.findById(1L).isPresent()
                ? this.configRepository.findById(1L).get().getCodigo() : "unknown";

        String baseUriPattern = "https://api.github.com/repos/%s/%s/contents%s?ref=%s";
        String initDirBase = "/src/main/java";
        String branch = "develop";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", "token " + token);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        String newGithubApiUrl = String.format(baseUriPattern, owner, repository, initDirBase , branch);
        ResponseEntity<GitHubContent[]> responseInner = restTemplate.exchange(newGithubApiUrl,
                HttpMethod.GET, entity, GitHubContent[].class);
        GitHubContent[] contentsInner = responseInner.getBody();
        for (GitHubContent contentItem : contentsInner) {
            // llamada recursiva para descubrir los fuentes java
            scanDir(contentItem, baseUriPattern, owner, repository, initDirBase, branch, entity);
        }

        List<Tarea> tareas = new ArrayList<>();
        //meter logica que ya tienes hecha en otras clases
        return tareas;
    }

    private void scanDir(final GitHubContent content, final String baseUriPattern,
                         final String owner, final String repository,
            final String initDirBase, final String branch, final HttpEntity<String> entity) {

        if (content.getType().equals("file") && content.getName().endsWith(".java")) {
            // El archivo es un archivo Java, lee su contenido
            String fileContentUrl = content.getDownload_url();
            ResponseEntity<String> fileResponse = restTemplate.exchange(fileContentUrl,
                    HttpMethod.GET, entity, String.class);
            String javaFileContent = fileResponse.getBody();
            System.out.println("Contenido del archivo " + content.getName() + ":\n" + javaFileContent);
        } else {
            //RestTemplate restTemplate = new RestTemplate();
            System.out.println("el archivo "+  content.getName() + " es un " + content.getType()
                    + "...lanzo una llamada recursiva");
            String newGithubApiUrl = String.format(baseUriPattern, owner, repository,
                    initDirBase + "/" + content.getName(), branch);
            ResponseEntity<GitHubContent[]> responseInner = restTemplate.exchange(newGithubApiUrl,
                    HttpMethod.GET, entity, GitHubContent[].class);
            GitHubContent[] contentsInner = responseInner.getBody();
            for (GitHubContent contentItem : contentsInner) {
                scanDir(contentItem, baseUriPattern, owner, repository,
                        initDirBase  + "/" + content.getName(), branch, entity);
            }
        }
    }

}
