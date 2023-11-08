package com.mylabs.pds.service;

import com.mylabs.pds.model.Tarea;
import com.mylabs.pds.repository.ConfiguracionRepository;
import com.mylabs.pds.repository.TareaRepository;
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
    private List<Tarea> tareas;

    @Autowired
    private TareaRepository tareaRepository;

    @Autowired
    private ConfiguracionRepository configRepository;

    public GitHubViaApiRest(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public List<Tarea> scanRepository(String owner, String repo) {
        String token = this.configRepository.findById(1L).isPresent()
                ? this.configRepository.findById(1L).get().getCodigo() : "unknown";
        String url2 = GITHUB_API_URL + "/repos/" + owner + "/" + repo;

        String url = GITHUB_API_URL + "/repos/" + owner + "/" + repo + "/contents?ref=develop";

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", "token " + token);

        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        this.tareas = new ArrayList<>();

        ResponseEntity<String> response =  restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        // Procesa la respuesta
        String responseBody = response.getBody();

        System.out.println("responseBody: " + responseBody);

        return this.tareas;
    }
}
