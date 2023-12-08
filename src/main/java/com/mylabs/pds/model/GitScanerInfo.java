package com.mylabs.pds.model;


import com.mylabs.pds.model.Tarea;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GitScanerInfo {

    private String codigoElementoCatalogo;

    private String release;

    private String gitLabPath;

    private String packageNamePattern;

    private String classNamePattern;

    private Tarea publicMethodsRoot;

    private Tarea testClassesRoot;

}
