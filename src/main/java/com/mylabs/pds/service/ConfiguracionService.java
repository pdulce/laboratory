package com.mylabs.pds.service;

import com.mylabs.pds.model.Configuracion;
import com.mylabs.pds.repository.ConfiguracionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ConfiguracionService {

    @Autowired
    private ConfiguracionRepository configRepository;

    public final List<Configuracion> getAllConfiguraciones() {

        return this.configRepository.findAll();
    }

    public final Configuracion getById(final Long id) {

        return this.configRepository.findById(id).isPresent() ? this.configRepository.findById(id).get() : null;
    }

    public final Configuracion createConfiguracion(@RequestBody Configuracion configuracion) {

        return this.configRepository.save(configuracion);
    }

}
