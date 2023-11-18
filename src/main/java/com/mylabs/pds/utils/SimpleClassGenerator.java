package com.mylabs.pds.utils;

import com.mylabs.pds.model.Tarea;
import org.apache.commons.lang3.NotImplementedException;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleClassGenerator implements IClassGenerator {

    @Override
    public List<Tarea> generateTestMethods(Long id, String sourceCode){
        List<Tarea> listOfTestMethods = new ArrayList<>();
        // Buscamos la clase de Test los métodos públicos
        Pattern methodPattern = Pattern.compile("public\\s+(\\w+)\\s+(\\w+)\\s*\\([^)]*\\)\\s*\\{");
        Matcher methodMatcher = methodPattern.matcher(sourceCode);
        long idTask = id * 100;
        while (methodMatcher.find()) {
            String methodName = methodMatcher.group(2);
            Tarea newTask = new Tarea();
            newTask.setId(idTask++);
            newTask.setParentId(id);
            newTask.setType("METHOD");
            newTask.setTestName(methodName);
            newTask.setContents("TODO::::falta recuperar el propio body del metodo");
            listOfTestMethods.add(newTask);
        }

        Pattern methodPattern2 = Pattern.compile("@Test");
        Matcher methodMatcher2 = methodPattern2.matcher(sourceCode);
        while (methodMatcher2.find()) {
            String methodName = methodMatcher.group(2);
        }


        return listOfTestMethods;
    }



    @Override
    public Tarea generateTestClassForJavaFile(final Long id, final String sourceCode) {
        // Patrones para extraer información del código fuente
        Pattern packagePattern = Pattern.compile("package\\s+([\\w.]+);");
        Pattern classPattern = Pattern.compile("public\\s+class\\s+(\\w+)\\s*\\{");

        Matcher packageMatcher = packagePattern.matcher(sourceCode);
        Matcher classMatcher = classPattern.matcher(sourceCode);

        String packageName = "";
        String className = "";

        // Buscar el package y el nombre de la clase
        while (packageMatcher.find()) {
            packageName = packageMatcher.group(1);
        }

        while (classMatcher.find()) {
            className = classMatcher.group(1);
        }

        List<Tarea> childrenTasks = new ArrayList<>();

        // Crear la clase de Test basada en SpringBoot JPA Data y H2
        StringBuilder testClass = new StringBuilder();
        testClass.append("package ").append(packageName).append(";\n\n");
        testClass.append("import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;\n");
        testClass.append("import org.junit.jupiter.api.Test;\n\n");

        testClass.append("@DataJpaTest\n");
        testClass.append("public class ").append(className).append("Test {\n\n");

        // Obtener los métodos públicos
        Pattern methodPattern = Pattern.compile("public\\s+(\\w+)\\s+(\\w+)\\s*\\([^)]*\\)\\s*\\{");
        Matcher methodMatcher = methodPattern.matcher(sourceCode);
        long idTask = id * 100;
        while (methodMatcher.find()) {
            String returnType = methodMatcher.group(1);
            String methodName = methodMatcher.group(2);

            StringBuilder methodBuilder = new StringBuilder();
            // Agregar método de prueba
            methodBuilder.append("    @Test\n");
            methodBuilder.append("    public void test_").append(methodName).append("() {\n");
            methodBuilder.append("        //TO-DO: Implementa tu test \n");
            methodBuilder.append("    }\n\n");

            testClass.append(methodBuilder);

            Tarea newTask = new Tarea();
            newTask.setId(idTask++);
            newTask.setParentId(id);
            newTask.setType("METHOD");
            newTask.setTestName("test_" + methodName);
            newTask.setOriginPathToTest(methodName);
            newTask.setContents(methodBuilder.toString());
            childrenTasks.add(newTask);
        }

        testClass.append("}\n");
        if (childrenTasks.isEmpty() || className == null || className.contentEquals("")) {
            return null;
        }
        // Crear la instancia de Tarea con el resultado
        System.out.println(testClass.toString());
        Tarea tarea = new Tarea();
        tarea.setId(id);
        tarea.setType("CLASS");
        tarea.setTestName(className.concat("Test.java"));
        tarea.setOriginPathToTest(packageName.concat(".").concat(className).concat(".java"));
        tarea.setContents(testClass.toString());
        tarea.setChildren(childrenTasks);

        return tarea;
    }


    public Tarea generateTestClassForJavaFile(final Long id, final InputStream inputStream) {
        throw new NotImplementedException("not implemented yet");
    }

}