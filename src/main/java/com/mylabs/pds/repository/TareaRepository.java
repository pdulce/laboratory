package com.mylabs.pds.repository;

import com.mylabs.pds.model.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepository extends JpaRepository<Tarea, Long> {

}