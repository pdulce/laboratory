package com.mylabs.pds.controller;

import com.mylabs.pds.model.Tarea;
import com.mylabs.pds.service.GitHubLibraryAccessService;
import com.mylabs.pds.service.GitHubApiRestAccessService;
import com.mylabs.pds.utils.GeneratorWithGitHubParser;
import com.mylabs.pds.utils.GeneratorWithJavaAssist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/scanGitRepoWithHubParserAndAPIAccessGit")
    public List<Tarea> scanGitRepoWithHubParserAndAPIAccessGit() {

        return gitHubViaApiRest.scanRepository("pdulce", "laboratory", new GeneratorWithGitHubParser());
    }

    @GetMapping("/scanGitRepoWithJavaAssistAndAPIAccessGit")
    public List<Tarea> scanGitRepoWithJavaAssistAndAPIAccessGit() {
        return gitHubViaApiRest.scanRepository("pdulce", "laboratory", new GeneratorWithJavaAssist());
    }

}