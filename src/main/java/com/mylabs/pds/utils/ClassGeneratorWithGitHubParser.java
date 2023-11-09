package com.mylabs.pds.utils;

import aj.org.objectweb.asm.Type;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.TypeDeclaration;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.mylabs.pds.model.Tarea;

import java.util.ArrayList;
import java.util.List;

public class ClassGeneratorWithGitHubParser {

    public Tarea generateTestClass(final CompilationUnit cu) {

        if (cu != null) {
            try {
                // Obtén el nombre de la clase de la CompilationUnit
                String className = cu.findFirst(ClassOrInterfaceDeclaration.class).
                        map(TypeDeclaration::getNameAsString).orElse("UnknownClass");
                Tarea tarea = new Tarea();
                tarea.setType("CLASS");
                tarea.setTestName(className.concat("Test.java"));
                List<Tarea> childrenTasks = new ArrayList<>();

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
                cu.findAll(MethodDeclaration.class).forEach((method -> {
                    if (!method.isAbstract() && //method.isFinal() &&
                            method.getModifiers().contains(Modifier.publicModifier())) {
                        MethodDeclaration methodDeclaration = generateTestMethod(method.getNameAsString(),
                                method.isStatic());
                        testClassDeclaration.addMember(methodDeclaration);
                        Tarea newTask = new Tarea();
                        newTask.setType("METHOD");
                        newTask.setTestName("test_" + method.getNameAsString());
                        newTask.setOriginPathToTest(method.getNameAsString());
                        newTask.setContents(methodDeclaration.toString());
                        newTask.setParentTaskId(tarea);
                        childrenTasks.add(newTask);
                    }
                }));

                // Puedes imprimir el contenido de la clase de prueba o escribirlo en un archivo
                System.out.println(testClass.toString());
                tarea.setContents(testClass.toString());
                tarea.setChildrenTasks(childrenTasks);
                return tarea;
            } catch (Throwable exc) {
                exc.printStackTrace();
                return null;
            }
        }
        return null;
    }

    private MethodDeclaration generateTestMethod(final String methodName, final boolean isStatic) {
        // Genera un método de prueba con anotación @Test
        MethodDeclaration testMethod = new MethodDeclaration();
        testMethod.addAnnotation("Test");
        testMethod.setModifiers(Modifier.publicModifier().getKeyword());
        testMethod.setType(Type.VOID_TYPE.getClassName());
        testMethod.setFinal(true);

        // Agrega el nombre del método y su contenido
        testMethod.setName("test_" + methodName);
        testMethod.setBody(new BlockStmt());

        return testMethod;
    }
}