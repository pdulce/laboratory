package com.mylabs.pds.utils;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
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

        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();
        CompilationTask task = compiler.getTask(null, fileManager, diagnostics, null, null, compilationUnits);

        task.setProcessors(List.of(new PackageUsageProcessor()));

        boolean success = task.call();

        if (!success) {
            System.out.println("Error en el análisis");
            for (javax.tools.Diagnostic<?> diagnostic : diagnostics.getDiagnostics()) {
                System.out.println(diagnostic);
            }
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

    public static class PackageUsageProcessor extends AbstractProcessor {

        private Elements elementUtils;
        private Types typeUtils;
        private Filer filer;

        @Override
        public synchronized void init(ProcessingEnvironment processingEnv) {
            super.init(processingEnv);
            elementUtils = processingEnv.getElementUtils();
            typeUtils = processingEnv.getTypeUtils();
            filer = processingEnv.getFiler();
        }

        @Override
        public Set<String> getSupportedAnnotationTypes() {
            return Set.of("*");
        }

        @Override
        public SourceVersion getSupportedSourceVersion() {
            return SourceVersion.latest();
        }

        @Override
        public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
            for (Element element : roundEnv.getRootElements()) {
                if (element.getKind() == ElementKind.CLASS) {
                    TypeElement classElement = (TypeElement) element;
                    PackageElement packageElement = elementUtils.getPackageOf(classElement);

                    System.out.println("Clase: " + classElement.getQualifiedName());
                    System.out.println("Paquete: " + packageElement.getQualifiedName());

                    List<String> publicMethods = new ArrayList<>();
                    for (Element enclosedElement : element.getEnclosedElements()) {
                        if (enclosedElement.getKind() == ElementKind.METHOD
                                && ((ExecutableElement) enclosedElement).getModifiers().contains(Modifier.PUBLIC)) {
                            publicMethods.add(enclosedElement.toString());
                        }
                    }

                    System.out.println("Métodos públicos:");
                    for (String method : publicMethods) {
                        System.out.println(method);
                    }
                }
            }
            return true;
        }
    }
}

