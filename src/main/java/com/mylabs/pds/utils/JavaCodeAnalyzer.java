package com.mylabs.pds.utils;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.tools.*;
import javax.tools.JavaCompiler.CompilationTask;
import java.io.*;
import java.net.URI;
import java.util.*;
import javax.lang.model.element.*;
import com.sun.source.tree.*;
import com.sun.source.util.*;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

public class JavaCodeAnalyzer {
    public void analyzeJavaCode(final String javaclassName, final String javaSourceCode) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null,
                null, null);

        // Crear un objeto de archivo fuente a partir del código fuente proporcionado
        JavaFileObject sourceFile = new JavaSourceFromString(javaclassName, javaSourceCode);

        Iterable<? extends JavaFileObject> compilationUnits = Arrays.asList(sourceFile);

        CompilationTask task = compiler.getTask(null, fileManager, null,
                null, null, compilationUnits);

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

    // Clase personalizada para representar un archivo fuente desde una cadena de código
    public static class JavaSourceFromString extends SimpleJavaFileObject {
        private final String code;

        protected JavaSourceFromString(String name, String code) {
            super(URI.create("string:///" + name.replace('.', '/') + Kind.SOURCE.extension),
                    Kind.SOURCE);
            this.code = code;
        }

        @Override
        public CharSequence getCharContent(boolean ignoreEncodingErrors) {
            return code;
        }
    }
}

