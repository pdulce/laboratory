package com.mylabs.pds.utils;


import com.mylabs.pds.model.Tarea;
import javassist.*;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.ClassFile;
import javassist.bytecode.ConstPool;
import javassist.bytecode.annotation.Annotation;


import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class GeneratorWithJavaAssist {

    public Tarea generateTestClassForJavaFile(String code) {
        CtClass ctClass = ClassPool.getDefault().makeClass(new StringReader(code).toString());
        return generateTestClass(ctClass);
    }

    public static void addClassAnnotation(CtClass ctClass, String annotationClass) {
        ClassFile classFile = ctClass.getClassFile();
        ConstPool constPool = classFile.getConstPool();
        AnnotationsAttribute annotationsAttribute = new AnnotationsAttribute(constPool, AnnotationsAttribute.visibleTag);
        Annotation annotation = new Annotation(annotationClass, constPool);
        annotationsAttribute.addAnnotation(annotation);
        classFile.addAttribute(annotationsAttribute);
    }

    private void addMethodAnnotation(final CtMethod method, final String annotationMethod) {
        ClassFile classFile = method.getDeclaringClass().getClassFile();
        ConstPool constPool = classFile.getConstPool();
        AnnotationsAttribute annotationsAttribute = new AnnotationsAttribute(constPool, AnnotationsAttribute.visibleTag);
        Annotation annotation = new Annotation(annotationMethod, constPool);
        annotationsAttribute.addAnnotation(annotation);
        method.getMethodInfo().addAttribute(annotationsAttribute);
    }

    public Tarea generateTestClass(final CtClass targetClass) {
        Tarea tarea = new Tarea();
        tarea.setType("CLASS");
        List<Tarea> childrenTasks = new ArrayList<>();
        try {
            // Obtén el nombre de la clase
            String className = targetClass.getSimpleName();
            tarea.setTestName(className.concat("Test.java"));

            // Crea una nueva clase de prueba
            ClassPool pool = ClassPool.getDefault();
            pool.importPackage("org.junit.jupiter.api.Test");
            pool.importPackage("org.springframework.boot.test.context.SpringBootTest");
            pool.importPackage("org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest");
            CtClass testClass = pool.makeClass(className + "Test");

            addClassAnnotation(testClass, "SpringBootTest");
            addClassAnnotation(testClass, "DataJpaTest");

            // Añade los métodos de prueba
            for (CtMethod method : targetClass.getDeclaredMethods()) {
                if (!Modifier.isAbstract(method.getModifiers()) &&
                        Modifier.isPublic(method.getModifiers())) {
                    CtMethod testMethod = generateTestMethod(method.getName(), method.getModifiers());
                    testClass.addMethod(testMethod);
                    Tarea newTask = new Tarea();
                    newTask.setType("METHOD");
                    newTask.setTestName("test_" + method.getName());
                    newTask.setOriginPathToTest(method.getName());
                    newTask.setContents(testMethod.toString());
                    childrenTasks.add(newTask);
                }
            }
            tarea.setChildrenTasks(childrenTasks);
            tarea.setContents(testClass.toString());
            // Puedes imprimir el contenido de la clase de prueba o escribirlo en un archivo
            System.out.println(testClass.toClass().toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return tarea;
    }


    private CtMethod generateTestMethod(String methodName, int modifiers) throws CannotCompileException {
        // Genera un método de prueba con anotación @Test
        CtMethod testMethod = new CtMethod(CtClass.voidType, "test_" + methodName, null, null);
        addMethodAnnotation(testMethod, "org.junit.jupiter.api.Test");
        testMethod.setModifiers(modifiers | Modifier.FINAL);

        // Agrega el contenido del método
        testMethod.setBody("{}");

        return testMethod;
    }

}
