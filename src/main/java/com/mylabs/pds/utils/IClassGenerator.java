package com.mylabs.pds.utils;

import com.mylabs.pds.model.Tarea;

import java.io.InputStream;

public interface IClassGenerator {

    public Tarea generateTestClassForJavaFile(String sourceCode);

    public Tarea generateTestClassForJavaFile(InputStream inputStream);
}
