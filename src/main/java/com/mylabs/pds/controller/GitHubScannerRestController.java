package com.mylabs.pds.controller;

import com.mylabs.pds.model.Tarea;
import com.mylabs.pds.service.GitHubService;
import com.mylabs.pds.service.GitHubViaApiRest;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/scanner")
public class GitHubScannerRestController {

    @Autowired
    private GitHubViaApiRest gitHubViaApiRest;


    @GetMapping("/scanGitRepo")
    public ResponseEntity<String> scanGitRepo() {
        return gitHubViaApiRest.scanRepository("pdulce", "laboratory");
    }




}