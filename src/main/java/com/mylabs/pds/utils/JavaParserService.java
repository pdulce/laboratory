package com.mylabs.pds.utils;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.mylabs.pds.model.Tarea;

import java.io.InputStream;
import java.util.List;

public class JavaParserService {

    public Tarea generateTestClassForJavaFile(InputStream inputStream) {
        Tarea tarea = null;
        CompilationUnit cu = StaticJavaParser.parse(inputStream);
        if (cu != null) {
            // Verificar si la clase tiene métodos públicos
            if (containsPublicMethods(cu)) {
                tarea = generateTestClass(cu);
            }
        }
        return tarea;
    }

    public Tarea generateTestClassForJavaFile(String code) {
        Tarea tarea = null;
        CompilationUnit cu = StaticJavaParser.parse(code);
        if (cu != null) {
            // Verificar si la clase tiene métodos públicos
            if (containsPublicMethods(cu)) {
                tarea = generateTestClass(cu);
            }
        }
        return tarea;
    }

    private boolean containsPublicMethods(CompilationUnit cu) {
        if (cu != null) {
            // Obtén todas las declaraciones de métodos en la clase
            List<MethodDeclaration> methodDeclarations = cu.findAll(MethodDeclaration.class);
            for (MethodDeclaration methodDeclaration : methodDeclarations) {
                // Verifica si el método tiene el modificador "public"
                if (methodDeclaration.getModifiers().contains(Modifier.publicModifier())) {
                    return true; // Se encontró al menos un método público
                }
            }
        }
        return false; // No se encontraron métodos públicos
    }

    private Tarea generateTestClass(CompilationUnit cu) {
        // Implementa la lógica para generar una clase de prueba con métodos de prueba.
        // Configura la clase de prueba para Spring Boot Test y uso de H2.
        return new ClassGeneratorWithGitHubParser().generateTestClass(cu);
    }

}

