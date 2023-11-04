package com.mylabs.pds.service;

import com.mylabs.pds.model.Tarea;
import com.mylabs.pds.utils.ZipUtil;
import org.kohsuke.github.GHContent;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GitHubService {
    private byte[] bytesOfZipped;
    private List<Tarea> tareas;
    private static final String token = "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";
    public GitHubService() {
        try {
            GitHub github = GitHub.connectUsingOAuth(token);
            GHRepository repository = github.getUser("pdulce").getRepository("laboratory");
            if (repository == null) {
                System.out.println("Error al acceder al repositorio");
                return;
            }
            this.tareas = new ArrayList<>();
            JavaParserService javaParserService = new JavaParserService();
            List<GHContent> ghDirContent = repository.getDirectoryContent("src/");
            ghDirContent.forEach((ghContent -> {
                try {
                    Tarea tarea = javaParserService.generateTestClassForJavaFile(ghContent.read());
                    tareas.add(tarea);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }));
            this.bytesOfZipped = ZipUtil.generarZipDesdeTareas(tareas);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Implementa métodos para acceder a repositorios y archivos en GitHub.

    public List<Tarea> getListOfTasks() {
        return this.tareas;
    }

    public byte[] getZipOfTests() {
        return this.bytesOfZipped;
    }

}