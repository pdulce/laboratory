package com.mylabs.pds.controller;


import com.mylabs.pds.model.ElementoCatalogo;
import com.mylabs.pds.service.ElementoCatalogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/elementos")
public class ElementoCatalogoRestController {

    @Autowired
    private ElementoCatalogoService elementoCatalogoService;

    @GetMapping("/getAll")
    public List<ElementoCatalogo> getAllElementos() {
        return elementoCatalogoService.getAllElementos();
    }

    @PostMapping("/create/{elemento}")
    public ElementoCatalogo createElemento(@RequestBody ElementoCatalogo elemento) {
        return elementoCatalogoService.createElemento(elemento);
    }

    // Otros métodos para actualizar, eliminar, etc.

}