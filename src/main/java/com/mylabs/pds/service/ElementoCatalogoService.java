package com.mylabs.pds.service;

import com.mylabs.pds.model.ElementoCatalogo;
import com.mylabs.pds.repository.ElementoCatalogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ElementoCatalogoService {

    @Autowired
    private ElementoCatalogoRepository elementoCatalogoRepository;

    public final List<ElementoCatalogo> getAllElementos() {
        return this.elementoCatalogoRepository.findAll();
    }

    public ElementoCatalogo createElemento(@RequestBody ElementoCatalogo elementoCatalogo) {
        return this.elementoCatalogoRepository.save(elementoCatalogo);
    }
}
