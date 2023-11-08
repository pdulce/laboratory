package com.mylabs.pds.utils;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.tools.*;
import javax.tools.JavaCompiler.CompilationTask;
import java.io.*;
import java.util.*;
import javax.lang.model.element.*;
import com.sun.source.tree.*;
import com.sun.source.util.*;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

public class JavaCodeAnalyzer {
    public void analyzeJavaCode(String javaFilePath) throws IOException {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);

        Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjects(new File(javaFilePath));
        CompilationTask task = compiler.getTask(null, fileManager, null, null, null, compilationUnits);

        SourcePositions sourcePositions = Trees.instance(task).getSourcePositions();
        //Elements elements = task.getElements();
        //Types types = task.getTypes();
        task.setProcessors(Collections.singleton(new AbstractProcessor() {
            @Override
            public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
                for (Element element : roundEnv.getRootElements()) {
                    if (element.getKind() == ElementKind.CLASS) {
                        TypeElement typeElement = (TypeElement) element;
                        System.out.println("Clase: " + typeElement.getSimpleName());

                        for (Element enclosedElement : typeElement.getEnclosedElements()) {
                            if (enclosedElement.getKind() == ElementKind.METHOD) {
                                ExecutableElement methodElement = (ExecutableElement) enclosedElement;
                                System.out.println("Método: " + methodElement.getSimpleName());
                            }
                        }
                    }
                }
                return true;
            }
        }));

        task.call();

    }

    public static void main(String[] args) {
        JavaCodeAnalyzer analyzer = new JavaCodeAnalyzer();
        String javaFilePath = "Ruta/a/TuArchivo.java"; // Ruta al archivo Java que deseas analizar
        try {
            analyzer.analyzeJavaCode(javaFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

