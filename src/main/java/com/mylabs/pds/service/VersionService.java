package com.mylabs.pds.service;

import com.mylabs.pds.model.Version;
import com.mylabs.pds.repository.VersionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class VersionService {

    @Autowired
    private VersionRepository versionRepository;

    public final List<Version> getAllVersiones() {
        return this.versionRepository.findAll();
    }

    public Version createVersion(@RequestBody Version version) {
        return this.versionRepository.save(version);
    }

}
