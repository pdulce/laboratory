package com.mylabs.pds.service;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.TypeDeclaration;

public class TestClassGenerator {

    public void generateTestClass(CompilationUnit cu) {
        if (cu != null) {
            // Obtén el nombre de la clase de la CompilationUnit
            String className = cu.findFirst(ClassOrInterfaceDeclaration.class).
                    map(TypeDeclaration::getNameAsString).orElse("UnknownClass");

            // Crea una nueva CompilationUnit para la clase de prueba
            CompilationUnit testClass = new CompilationUnit();
            testClass.addImport("org.junit.jupiter.api.Test");
            testClass.addImport("org.springframework.boot.test.context.SpringBootTest");
            testClass.addImport("org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest");
            testClass.setPackageDeclaration(cu.getPackageDeclaration().orElse(null));

            // Define la clase de prueba
            ClassOrInterfaceDeclaration testClassDeclaration = testClass.addClass(className + "Test");
            testClassDeclaration.addAnnotation("SpringBootTest");
            testClassDeclaration.addAnnotation("DataJpaTest");

            // Genera métodos de prueba para los métodos públicos
            for (MethodDeclaration method : cu.findAll(MethodDeclaration.class)) {
                if (method.getModifiers().contains(Modifier.publicModifier())) {
                    testClassDeclaration.addMember(generateTestMethod(method.getNameAsString()));
                }
            }

            // Puedes imprimir el contenido de la clase de prueba o escribirlo en un archivo
            System.out.println(testClass.toString());
        }
    }

    private MethodDeclaration generateTestMethod(String methodName) {
        MethodDeclaration testMethod = new MethodDeclaration();
        testMethod.addAnnotation("Test");
        testMethod.setModifiers(Modifier.publicModifier().getKeyword());
        testMethod.setName("test" + methodName); // Agrega "test" al nombre del método

        return testMethod;
    }
}
