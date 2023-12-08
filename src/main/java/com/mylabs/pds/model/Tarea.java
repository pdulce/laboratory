package com.mylabs.pds.model;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Tarea {
    @Id
    private Long id;
    private String testName;
    private String qName;
    private String methodName;
    private String className;
    private String packageName;
    private Integer numDependencies;
    private Integer numLines;
    private byte[] arrayOfBytes;
    private Boolean coverage;
    private String contents;
    private Long parentId;
    private String sourceScanned;
    private String type; //FOLDER, CLASS, METHOD
    private List<Tarea> children;
    private String arguments;
    private String level;
    private String test;
    private String folderName;

    public static final String TIPO_TESTCLASS = "TestClass";
    public static final String TIPO_PACKAGE = "Package";
    public static final String TIPO_FOLDER = "Folder";
}
