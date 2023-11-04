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
            scanMainDir("src/", repository, this.tareas);
            this.bytesOfZipped = ZipUtil.generarZipDesdeTareas(tareas);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void scanMainDir(final String baseDir,
                             final GHRepository repository, final List<Tarea> tareas) throws IOException {
        JavaParserService javaParserService = new JavaParserService();
        List<GHContent> ghDirContent = repository.getDirectoryContent(baseDir);
        ghDirContent.forEach((ghContent -> {
            try {
                if (ghContent.isFile() && ghContent.getName().endsWith("java")) {
                    Tarea tarea = javaParserService.generateTestClassForJavaFile(ghContent.read());
                    tareas.add(tarea);
                } else if (ghContent.isDirectory()) {
                    scanMainDir(baseDir.concat("/").concat(ghContent.getName()), repository, tareas);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }));
    }

    private void scanDir(final GHContent item, final List<GHContent> lista) {
        if (item.isDirectory()) {
            scanDir(null, lista);
        } else if (item.isFile() && item.getName().endsWith("java")) {
            lista.add(item);
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