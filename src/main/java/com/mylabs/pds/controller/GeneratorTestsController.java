package com.mylabs.pds.controller;

import com.mylabs.pds.model.Tarea;
import com.mylabs.pds.service.GitHubLibraryAccessService;
import com.mylabs.pds.service.GitHubApiRestAccessService;
import com.mylabs.pds.utils.GeneratorWithGitHubParser;
import com.mylabs.pds.utils.GeneratorWithJavaAssist;
import com.mylabs.pds.utils.SimpleClassGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scanner")
public class GeneratorTestsController {

    @Autowired
    private GitHubApiRestAccessService gitHubViaApiRest;
    @Autowired
    private GitHubLibraryAccessService gitHubService;

    @GetMapping("/scanGitRepoWithHubParserAndAccessViaLibraryHub")
    public List<Tarea> scanGitRepoWithHubParserAndAccessViaLibraryHub() {
        return gitHubService.scanRepository("pdulce", "laboratory", new GeneratorWithGitHubParser());
    }

    @GetMapping("/scanGitRepoWithJavaAssistAndAccessViaLibraryHub")
    public List<Tarea> scanGitRepoWithJavaAssistAndAccessViaLibraryHub() {
        return gitHubService.scanRepository("pdulce", "laboratory", new GeneratorWithJavaAssist());
    }

    @GetMapping("/scanGitRepoWithRegexAndAccessViaLibraryHub")
    public List<Tarea> scanGitRepoWithRegexAndAccessViaLibraryHub() {
        return gitHubService.scanRepository("pdulce", "laboratory", new SimpleClassGenerator());
    }

    /****** METODOS PREFERIDOS PORQUE ATACAN VIA API-REST CON EL TOKEN DE GITLAB ****************/
    @GetMapping("/scanGitRepoWithHubParserAndAPIAccessGit")
    public List<Tarea> scanGitRepoWithHubParserAndAPIAccessGit() {
        return gitHubViaApiRest.scanRepository("pdulce", "laboratory", new GeneratorWithGitHubParser());
    }

    @GetMapping("/scanGitRepoWithJavaAssistAndAPIAccessGit")
    public List<Tarea> scanGitRepoWithJavaAssistAndAPIAccessGit() {
        return gitHubViaApiRest.scanRepository("pdulce", "laboratory", new GeneratorWithJavaAssist());
    }

    /****** METODO PREFERIDO PARA NO DEPENDER DE LIBRERIAS DE TERCEROS COMO LÑA DE GITHUB ************/
    @GetMapping("/scanGitRepoWithRegexAndAPIAccessGit")
    public List<Tarea> scanGitRepoWithRegexAndAPIAccessGit() {
        return gitHubViaApiRest.scanRepository("pdulce", "laboratory", new SimpleClassGenerator());
    }

    @PostMapping("/scanTestCobertura")
    public Tarea scanGitRepoTestWithRegexAndAPIAccessGit(@RequestBody Tarea metodos) {
        if (metodos != null && metodos.getChildren() != null && !metodos.getChildren().isEmpty()) {
            return gitHubViaApiRest.scanTestCobertura("pdulce", "laboratory",
                    metodos.getChildren(), new SimpleClassGenerator());
        }
        return null;
    }


}