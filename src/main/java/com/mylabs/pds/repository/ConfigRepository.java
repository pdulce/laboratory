package com.mylabs.pds.repository;

import com.mylabs.pds.model.Configuracion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigRepository extends JpaRepository<Configuracion, Long> {

}