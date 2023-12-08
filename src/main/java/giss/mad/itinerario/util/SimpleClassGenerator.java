package giss.mad.itinerario.util;

import giss.mad.itinerario.model.volatilentities.Tarea;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleClassGenerator implements IClassGenerator {


    @Override
    public final Tarea obtainTestClass(final String sourceCode, final Map<String, String> rxExpressionsMap) {
        Tarea testClassFound = new Tarea();
        testClassFound.setLevel(Tarea.TIPO_TESTCLASS);
        testClassFound.setContents(sourceCode);
        testClassFound.setChildren(new ArrayList<>());
        Pattern packagePattern = Pattern.compile(rxExpressionsMap.get(RXFORJAVAPACKAGES)); //"package\\s+(.*?);");
        Matcher packageMatcher = packagePattern.matcher(sourceCode);
        if (packageMatcher.find()) {
            testClassFound.setPackageName(packageMatcher.group(1));
        }
        Pattern importPattern = Pattern.compile(rxExpressionsMap.get(RXFORJAVAIMPORTS)); //"import\\s+(.*?);");
        Matcher importMatcher = importPattern.matcher(sourceCode);
        testClassFound.setImports(new ArrayList<>());
        while (importMatcher.find()) {
            testClassFound.getImports().add(importMatcher.group(1));
        }
        Pattern classPattern = Pattern.compile(rxExpressionsMap.get(RXFORJAVACLASS));
        //"public\\s+class\\s+(\\w+)\\s*\\{");
        Matcher classMatcher = classPattern.matcher(sourceCode);
        if (classMatcher.find()) {
            testClassFound.setClassName(classMatcher.group(1));
        }
        Pattern variableDeclarationPattern = Pattern.compile(rxExpressionsMap.get(RXFORVARDECLARATION));
        //"[A-Z](.*?)\\s+(\\w+);");
        Matcher variableMatcher = variableDeclarationPattern.matcher(sourceCode);
        testClassFound.setMemberDeclarations(new ArrayList<>());
        while (variableMatcher.find()) {
            Map<String, String> declarationMap = new HashMap<>();
            String[] matched = variableMatcher.group(0).split(" ");
            if (!matched[1].contentEquals("=")) {
                declarationMap.put(matched[0].trim(), matched[1].replaceAll(";", ""));
                testClassFound.getMemberDeclarations().add(declarationMap);
            }
        }
        return testClassFound;
    }

    private static int contarLineas(final String texto) {
        if (texto == null || texto.isEmpty()) {
            return 0;
        }
        String[] lineas = texto.split("\r\n|\r|\n");
        return lineas.length;
    }


    @Override
    public final Tarea generateTestClassForJavaFile(final String sourceCode,
                                                    final Map<String, String> rxExpressionsMap) {

        if (sourceCode.contains("public interface ") || sourceCode.contains("public final interface ")) {
            return null;
        }
        /*if (sourceCode.contains("public final class TipoElementoCatalogo")) {
            int h = 9;
        }*/

        // Patrones para extraer información del código fuente
        Pattern packagePattern = Pattern.compile(rxExpressionsMap.get(RXFORJAVAPACKAGES));
        Pattern classPattern = Pattern.compile(rxExpressionsMap.get(RXFORJAVACLASS));
        // "public(.*?)class\\s+(\\w+)\\s*(.*?)\\s*\\{"
        Matcher packageMatcher = packagePattern.matcher(sourceCode);
        Matcher classMatcher = classPattern.matcher(sourceCode);
        String packageName;
        String className = "";
        // Buscar el package y el nombre de la clase
        if (packageMatcher.find()) {
            packageName = packageMatcher.group(1);
        } else {
            packageName = "";
        }
        String bodyOfClass = sourceCode;
        if (classMatcher.find()) {
            className = classMatcher.group(0).split(" class ")[1].split("\\{")[0].trim();
            if (className.split(" ").length > 1) {
                className = className.split(" ")[0];
            }
            int index = sourceCode.indexOf(" class " + className);
            bodyOfClass = sourceCode.substring(index + 1);
        }

        List<Tarea> childrenTasks = new ArrayList<>();
        // Crear la clase de Test basada en SpringBoot JPA Data y H2
        StringBuilder testClass = new StringBuilder();
        testClass.append("package ").append(packageName).append(";\n\n");
        testClass.append("import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;\n");
        testClass.append("import org.junit.jupiter.api.Test;\n\n");

        testClass.append("@DataJpaTest\n");
        testClass.append("public class ").append(className).append("Test {\n\n");

        String finalClassName = className;
        int counterLinesInClass = 0;
        Pattern methodPattern = Pattern.compile(/*rxExpressionsMap.get(RXFORPUBLICMETHODS)*/
                "public\\s+[^=;]+\\s+\\{(.*?)\\}", Pattern.DOTALL);
        //"public\\s+[^=]+\\s+\\{(.*?)\\}"
        Matcher methodMatcher = methodPattern.matcher(bodyOfClass);
        while (methodMatcher.find()) {
            String contents = methodMatcher.groupCount() >= 1 ? methodMatcher.group(0) : "";
            int hastaDeclaracionArgs = contents.indexOf("(");
            if (hastaDeclaracionArgs != -1) {
                String[] splitter = contents.substring(0, hastaDeclaracionArgs).split(" ");
                String methodName = splitter[splitter.length - 1];
                if (!methodName.contentEquals(finalClassName)) {
                    String argumentsDeclaration = "";
                    String newContents = contents.replaceAll("\\n", "");
                    newContents = newContents.replaceAll("\\r", "");
                    newContents = newContents.replaceAll("\\t", "");
                    if (newContents.indexOf("(") != -1 && newContents.indexOf("{") != -1) {
                        //System.out.println("contents:: " + newContents);
                        argumentsDeclaration = newContents.substring(newContents.indexOf("(") + 1,
                                newContents.indexOf("{")).trim().replace(")", "");
                    }
                    String[] partsOfDeclarationMethod = newContents.split(methodName)[0].split(" ");
                    String returnType = partsOfDeclarationMethod[partsOfDeclarationMethod.length - 1].trim();
                    StringBuilder methodBuilder = new StringBuilder();
                    // Agregar método de prueba
                    methodBuilder.append("    @Test\n");
                    methodBuilder.append("    public void test_").append(methodName).append("() {\n");
                    methodBuilder.append("        //TO-DO: Implementa tu test \n");
                    methodBuilder.append("    }\n\n");

                    testClass.append(methodBuilder);

                    Tarea newTask = new Tarea();
                    newTask.setLevel(Tarea.TIPO_TESTMETHOD);
                    newTask.setTest("test_" + methodName);
                    newTask.setClassName(finalClassName);
                    newTask.setMethodName(methodName);
                    newTask.setArguments(argumentsDeclaration);
                    newTask.setReturnType(returnType);
                    newTask.setPackageName(packageName);
                    newTask.setName(packageName + "." + finalClassName + "." + methodName);
                    newTask.setSourceScanned(methodName);
                    newTask.setContents(methodBuilder.toString());
                    newTask.setCoverage(false);
                    newTask.setNumLines(contarLineas(contents));
                    newTask.setChildren(new ArrayList<>());
                    childrenTasks.add(newTask);
                    counterLinesInClass += newTask.getNumLines();
                }
            }
        }

        testClass.append("}\n");
        if (childrenTasks.isEmpty() || className == null || className.contentEquals("")) {
            return null;
        }
        // Crear la instancia de Tarea con el resultado
        //System.out.println(testClass.toString());
        Tarea tarea = new Tarea();
        tarea.setLevel(Tarea.TIPO_TESTCLASS);
        tarea.setTest(className.concat("Test.java"));
        tarea.setName(packageName + "." + className);
        tarea.setClassName(className);
        tarea.setPackageName(packageName);
        tarea.setSourceScanned(packageName.concat(".").concat(className).concat(".java"));
        tarea.setContents(testClass.toString());
        tarea.setNumLines(counterLinesInClass);
        tarea.setChildren(childrenTasks);
        return tarea;
    }



}
