package com.mylabs.pds.controller;

import com.mylabs.pds.model.Version;
import com.mylabs.pds.service.VersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/versiones")
public class VersionRestController {

    @Autowired
    private VersionService versionService;

    @GetMapping("/getAll")
    public List<Version> getAllVersiones() {
        return versionService.getAllVersiones();
    }

    @PostMapping("/create/{version}")
    public Version createVersion(@RequestBody Version version) {
        return versionService.createVersion(version);
    }


    // Otros métodos para actualizar, eliminar, etc.

}