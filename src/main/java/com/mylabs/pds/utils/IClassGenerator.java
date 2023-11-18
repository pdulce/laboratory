package com.mylabs.pds.utils;

import com.mylabs.pds.model.Tarea;

import java.io.InputStream;
import java.util.List;

public interface IClassGenerator {

    public Tarea generateTestClassForJavaFile(Long id, String sourceCode);

    public Tarea generateTestClassForJavaFile(Long id, InputStream inputStream);

    public List<Tarea> generateTestMethods(Long id, String sourceCode);
}
