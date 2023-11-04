package com.mylabs.pds.service;

import com.mylabs.pds.model.Tarea;
import com.mylabs.pds.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    public final List<Tarea> getAllTareas() {
        return this.tareaRepository.findAll();
    }

    public Tarea createTarea(@RequestBody Tarea tarea) {
        return this.tareaRepository.save(tarea);
    }


}
