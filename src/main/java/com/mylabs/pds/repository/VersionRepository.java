package com.mylabs.pds.repository;

import com.mylabs.pds.model.Version;
import org.springframework.data.jpa.repository.JpaRepository;



public interface VersionRepository extends JpaRepository<Version, Long> {

}