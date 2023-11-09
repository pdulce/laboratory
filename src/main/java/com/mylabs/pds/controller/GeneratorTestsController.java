package com.mylabs.pds.controller;

import com.mylabs.pds.model.Tarea;
import com.mylabs.pds.service.GitHubService;
import com.mylabs.pds.service.GitHubViaApiRest;
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
    private GitHubViaApiRest gitHubViaApiRest;
    @Autowired
    private GitHubService gitHubService;

    @GetMapping("/scanGitRepoWithHubParserAccessViaLibraryHub")
    public List<Tarea> scanGitRepoWithHubParserAccessViaLibraryHub() {

        return gitHubService.scanRepository("pdulce", "laboratory", new GeneratorWithGitHubParser());
    }

    @GetMapping("/scanGitRepoWithJavaAssistParserAccessViaLibraryHub")
    public List<Tarea> scanGitRepoWithJavaAssistParserAccessViaLibraryHub() {
        return gitHubService.scanRepository("pdulce", "laboratory", new GeneratorWithJavaAssist());
    }

    @GetMapping("/scanGitRepoWithHubParserWithAPIAccessGit")
    public List<Tarea> scanGitRepoWithHubParserWithAPIAccessGit() {

        return gitHubViaApiRest.scanRepository("pdulce", "laboratory", new GeneratorWithGitHubParser());
    }

    @GetMapping("/scanGitRepoWithJavaAssistParserWithAPIAccessGit")
    public List<Tarea> scanGitRepoWithJavaAssistParserWithAPIAccessGit() {
        return gitHubViaApiRest.scanRepository("pdulce", "laboratory", new GeneratorWithJavaAssist());
    }

}