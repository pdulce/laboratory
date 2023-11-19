package com.mylabs.pds.controller;

import com.itextpdf.text.DocumentException;
import com.mylabs.pds.model.Tarea;
import com.mylabs.pds.service.GitHubLibraryAccessService;
import com.mylabs.pds.service.GitHubApiRestAccessService;
import com.mylabs.pds.utils.GeneratorWithGitHubParser;
import com.mylabs.pds.utils.GeneratorWithJavaAssist;
import com.mylabs.pds.utils.SimpleClassGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/scanner")
public class GeneratorTestsController {

    @Autowired
    private GitHubApiRestAccessService gitHubViaApiRest;
    @Autowired
    private GitHubLibraryAccessService gitHubService;

    @GetMapping("/scanGitRepoWithHubParserAndAccessViaLibraryHub")
    public final Tarea scanGitRepoWithHubParserAndAccessViaLibraryHub() {
        return gitHubService.scanRepository("pdulce", "laboratory", new GeneratorWithGitHubParser());
    }

    @GetMapping("/scanGitRepoWithJavaAssistAndAccessViaLibraryHub")
    public final Tarea scanGitRepoWithJavaAssistAndAccessViaLibraryHub() {
        return gitHubService.scanRepository("pdulce", "laboratory", new GeneratorWithJavaAssist());
    }

    @GetMapping("/scanGitRepoWithRegexAndAccessViaLibraryHub")
    public final Tarea scanGitRepoWithRegexAndAccessViaLibraryHub() {
        return gitHubService.scanRepository("pdulce", "laboratory", new SimpleClassGenerator());
    }

    /****** METODOS PREFERIDOS PORQUE ATACAN VIA API-REST CON EL TOKEN DE GITLAB ****************/
    @GetMapping("/scanGitRepoWithHubParserAndAPIAccessGit")
    public final Tarea scanGitRepoWithHubParserAndAPIAccessGit() {
        return gitHubViaApiRest.scanRepository("pdulce", "laboratory", new GeneratorWithGitHubParser());
    }

    @GetMapping("/scanGitRepoWithJavaAssistAndAPIAccessGit")
    public final Tarea scanGitRepoWithJavaAssistAndAPIAccessGit() {
        return gitHubViaApiRest.scanRepository("pdulce", "laboratory", new GeneratorWithJavaAssist());
    }

    /****** METODOS PREFERIDOS ************/
    @GetMapping("/scanGitRepoWithRegexAndAPIAccessGit")
    public final Tarea scanGitRepoWithRegexAndAPIAccessGit() {
        return gitHubViaApiRest.scanRepository("pdulce", "laboratory", new SimpleClassGenerator());
    }

    @PostMapping("/scanTestCobertura")
    public final Tarea scanGitRepoTestWithRegexAndAPIAccessGit(@RequestBody Tarea metodos) {
        if (metodos != null && metodos.getChildren() != null && !metodos.getChildren().isEmpty()) {
            return gitHubViaApiRest.scanTestCobertura("pdulce", "laboratory",
                    metodos.getChildren(), new SimpleClassGenerator());
        }
        return null;
    }

    @PostMapping("/getReportWithSummary")
    public final Tarea generateReportPDFOfCoverage(@RequestBody Tarea methodsAndTest) {
        if (methodsAndTest != null && methodsAndTest.getChildren() != null
                && !methodsAndTest.getChildren().isEmpty() && methodsAndTest.getChildren().size() == 2) {
            Tarea methodsRoot = methodsAndTest.getChildren().get(0);
            Tarea testRoot = methodsAndTest.getChildren().get(1);
            try {
                return gitHubViaApiRest.getMethodsWithCoverage(methodsRoot, testRoot);
            } catch (DocumentException docExc) {
                return null;
            } catch (IOException ioExc) {
                return null;
            }
        }
        return null;
    }

}