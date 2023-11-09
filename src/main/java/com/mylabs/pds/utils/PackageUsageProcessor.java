package com.mylabs.pds.utils;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.mylabs.pds.model.Tarea;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;


@SupportedAnnotationTypes("*")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class PackageUsageProcessor extends AbstractProcessor {

    private Tarea tarea;

    private Elements elementUtils;
    private Types typeUtils;
    private Filer filer;

    public PackageUsageProcessor() {

    }

    public PackageUsageProcessor(final Tarea task) {
        this.tarea = task;
    }

    public Tarea getTarea() {
        return tarea;
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        elementUtils = processingEnv.getElementUtils();
        typeUtils = processingEnv.getTypeUtils();
        filer = processingEnv.getFiler();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Tarea tareaOfClass = new Tarea();
        tareaOfClass.setType("CLASS");
        tareaOfClass.setChildrenTasks(new ArrayList<>());
        for (Element element : roundEnv.getRootElements()) {
            if (element.getKind() == ElementKind.CLASS) {
                TypeElement classElement = (TypeElement) element;
                PackageElement packageElement = elementUtils.getPackageOf(classElement);

                System.out.println("Clase: " + classElement.getQualifiedName());
                System.out.println("Paquete: " + packageElement.getQualifiedName());

                // Genera la clase de prueba
                CompilationUnit testClass = new CompilationUnit();
                testClass.addImport("org.junit.jupiter.api.Test");
                testClass.addImport("org.springframework.boot.test.context.SpringBootTest");
                testClass.addImport("org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest");
                testClass.setPackageDeclaration(classElement.getQualifiedName().toString());

                // Define la clase de prueba
                String className = classElement.getSimpleName().toString();
                ClassOrInterfaceDeclaration testClassDeclaration = testClass.addClass(className + "Test");
                testClassDeclaration.addAnnotation("SpringBootTest");
                testClassDeclaration.addAnnotation("DataJpaTest");

                // Recopila métodos públicos
                for (Element enclosedElement : element.getEnclosedElements()) {
                    if (enclosedElement.getKind() == ElementKind.METHOD
                            && ((ExecutableElement) enclosedElement).getModifiers().
                            contains(com.github.javaparser.ast.Modifier.publicModifier())) {
                        String methodName = enclosedElement.getSimpleName().toString();

                        // Genera el método de prueba
                        MethodDeclaration methodDeclaration = generateTestMethod(methodName);
                        testClassDeclaration.addMember(methodDeclaration);

                        Tarea newTask = new Tarea();
                        newTask.setType("METHOD");
                        newTask.setTestName("test_" + methodName);
                        newTask.setOriginPathToTest(methodName);
                        newTask.setContents(methodDeclaration.toString());
                        tareaOfClass.getChildrenTasks().add(newTask);
                    }
                }

                // Guarda la clase de prueba generada en un archivo
                try {
                    filer.createSourceFile(classElement.getQualifiedName() + "Test").openWriter().
                            append(testClass.toString()).close();
                    tareaOfClass.setOriginPathToTest(className + ".java");
                    tareaOfClass.setTestName(className.concat("Test.java"));
                    tareaOfClass.setContents(testClass.toString());
                    this.tarea = tareaOfClass;

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    private MethodDeclaration generateTestMethod(String methodName) {
        // Genera un método de prueba con anotación @Test
        MethodDeclaration testMethod = new MethodDeclaration();
        testMethod.addAnnotation("Test");
        testMethod.setModifiers(Modifier.publicModifier().getKeyword());

        // Agrega el nombre del método y su contenido
        testMethod.setName("test_" + methodName);
        testMethod.setBody(new BlockStmt());

        return testMethod;
    }
}

