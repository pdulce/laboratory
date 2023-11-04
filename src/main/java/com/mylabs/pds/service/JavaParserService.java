package com.mylabs.pds.service;

import com.github.javaparser.ParseException;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

import java.nio.file.FileVisitResult;

import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.body.MethodDeclaration;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;

public class JavaParserService {
    public CompilationUnit parseJavaFile(String javaCode) {
        return StaticJavaParser.parse(javaCode);
    }

    public void generateTestClassesForJavaFiles(String baseDir) {
        File srcMainDir = new File(baseDir + "/src/main");
        for (File file : listJavaFiles(srcMainDir)) {
            CompilationUnit cu = parseJavaFileContent(file);
            if (cu != null) {
                // Verificar si la clase tiene métodos públicos
                if (containsPublicMethods(cu)) {
                    generateTestClass(cu);
                }
            }
        }
    }

    private List<File> listJavaFiles(File dir) {
        // Implementa la lógica para listar los archivos Java bajo la carpeta "src/main".
        List<File> javaFiles = new ArrayList<>();
        Path directory = Paths.get(dir.toURI());

        try {
            Files.walkFileTree(directory, new FileVisitorAdapter() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (file.toString().endsWith(".java")) {
                        javaFiles.add(file.toFile());
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return javaFiles;
    }

    private CompilationUnit parseJavaFileContent(File file) {
        try {
            return StaticJavaParser.parse(file);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
            return null;
        }
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

    private void generateTestClass(CompilationUnit cu) {
        // Implementa la lógica para generar una clase de prueba con métodos de prueba.
        // Configura la clase de prueba para Spring Boot Test y uso de H2.
        new TestClassGenerator().generateTestClass(cu);
    }

    // Esta es una clase auxiliar para simplificar la implementación de FileVisitor.
    private static class FileVisitorAdapter implements FileVisitor<Path> {
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            return FileVisitResult.CONTINUE;
        }
    }
}

