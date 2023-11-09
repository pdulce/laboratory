package com.mylabs.pds.utils;

import com.mylabs.pds.model.Tarea;

import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

public class JavaCodeAnalyzer {
    public Tarea analyzeJavaCode(final String javaclassName, final String javaSourceCode) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null,
                null, null);

        // Crear un objeto de archivo fuente a partir del código fuente proporcionado
        JavaFileObject sourceFile = new JavaSourceFromString(javaclassName, javaSourceCode);

        Iterable<? extends JavaFileObject> compilationUnits = Arrays.asList(sourceFile);

        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();
        CompilationTask task = compiler.getTask(null, fileManager, diagnostics, null, null, compilationUnits);
        PackageUsageProcessor classProcessor = new PackageUsageProcessor(new Tarea());
        task.setProcessors(List.of(classProcessor));
        boolean success = task.call();

        if (!success) {
            System.out.println("Error en el análisis");
            for (javax.tools.Diagnostic<?> diagnostic : diagnostics.getDiagnostics()) {
                System.out.println(diagnostic);
            }
            return null;
        } else {
            return classProcessor.getTarea();
        }

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

