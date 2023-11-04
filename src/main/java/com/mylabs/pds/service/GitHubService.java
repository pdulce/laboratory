package com.mylabs.pds.service;

import org.kohsuke.github.GitHub;

import java.io.IOException;

public class GitHubService {

    private GitHub github;
    private static final String token = "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";
    public GitHubService(String token) {
        try {
            github = GitHub.connectUsingOAuth(token);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Implementa métodos para acceder a repositorios y archivos en GitHub.

}