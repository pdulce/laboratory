package com.mylabs.pds.controller;

import com.mylabs.pds.model.Tarea;
import com.mylabs.pds.model.Version;
import com.mylabs.pds.service.GitHubService;
import com.mylabs.pds.service.VersionService;
import com.mylabs.pds.utils.ZipUtil;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/testasks")
public class GeneratorTestsRestController {


    @GetMapping("/listTestingTasks")
    public List<Tarea> getAllTasks() {
        GitHubService gitHubService = new GitHubService();
        return gitHubService.getListOfTasks();
    }

    @GetMapping("/generar-zip")
    public ResponseEntity<Resource> generarZipDeTareas() {
        GitHubService gitHubService = new GitHubService();
        byte[] zipContent = gitHubService.getZipOfTests();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=tareas.zip");
        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body((Resource) new ByteArrayResource(zipContent));
    }


}