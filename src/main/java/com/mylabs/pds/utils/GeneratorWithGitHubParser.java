package com.mylabs.pds.utils;

/** SOlo esta dependencia en tu proyecto de Itinerario
 *      <dependency>
 * 			<groupId>com.github.javaparser</groupId>
 * 			<artifactId>javaparser-core</artifactId>
 * 			<version>3.25.6</version>
 * 		</dependency>
 */

import aj.org.objectweb.asm.Type;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.TypeDeclaration;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.mylabs.pds.model.Tarea;
import org.apache.commons.lang3.NotImplementedException;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class GeneratorWithGitHubParser implements IClassGenerator {

    @Override
    public List<Tarea> generateTestMethods(Long id, String sourceCode){
        throw new NotImplementedException("not impleted yet");
    }

    @Override
    public final Tarea generateTestClassForJavaFile(final Long id, final InputStream inputStream) {
        Tarea tarea = null;
        CompilationUnit cu = StaticJavaParser.parse(inputStream);
        if (cu != null) {
            // Verificar si la clase tiene métodos públicos
            if (containsPublicMethods(cu)) {
                tarea = generateTestClass(id, cu);
                tarea.setId(id);
            }
        }
        return tarea;
    }

    @Override
    public final Tarea generateTestClassForJavaFile(final Long id, final String code) {
        Tarea tarea = null;
        CompilationUnit cu = StaticJavaParser.parse(code);
        if (cu != null) {
            // Verificar si la clase tiene métodos públicos
            if (containsPublicMethods(cu)) {
                tarea = generateTestClass(id, cu);
            }
        }
        return tarea;
    }

    private boolean containsPublicMethods(CompilationUnit cu) {
        if (cu != null) {
            // Obtén todas las declaraciones de métodos en la clase
            List<MethodDeclaration> methodDeclarations = cu.findAll(MethodDeclaration.class);
            for (MethodDeclaration methodDeclaration : methodDeclarations) {
                // Verifica si el método tiene el modificador "public"
                if (methodDeclaration.getModifiers().contains(Modifier.publicModifier())) {
                    return true; // Se encontró al menos un método público
                }
            }
        }
        return false; // No se encontraron métodos públicos
    }

    public final Tarea generateTestClass(final Long id, final CompilationUnit cu) {

        if (cu != null) {
            try {
                // Obtén el nombre de la clase de la CompilationUnit
                String className = cu.findFirst(ClassOrInterfaceDeclaration.class).
                        map(TypeDeclaration::getNameAsString).orElse("UnknownClass");

                List<Tarea> childrenTasks = new ArrayList<>();

                // Crea una nueva CompilationUnit para la clase de prueba
                CompilationUnit testClass = new CompilationUnit();
                testClass.setPackageDeclaration(cu.getPackageDeclaration().get().getNameAsString());
                testClass.addImport("org.junit.jupiter.api.Test");
                testClass.addImport("org.springframework.boot.test.context.SpringBootTest");
                testClass.addImport("org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest");
                testClass.setPackageDeclaration(cu.getPackageDeclaration().orElse(null));

                // Define la clase de prueba
                ClassOrInterfaceDeclaration testClassDeclaration = testClass.addClass(className + "Test");
                testClassDeclaration.addAnnotation("SpringBootTest");
                testClassDeclaration.addAnnotation("DataJpaTest");
                AtomicLong idTask = new AtomicLong(id * 100);
                cu.findAll(MethodDeclaration.class).forEach((method -> {
                    if (!method.isAbstract() && //method.isFinal() &&
                            method.getModifiers().contains(Modifier.publicModifier())) {
                        MethodDeclaration methodDeclaration = generateTestMethod(method.getNameAsString(),
                                method.isStatic());
                        testClassDeclaration.addMember(methodDeclaration);
                        Tarea newTask = new Tarea();
                        newTask.setId(idTask.getAndIncrement());
                        newTask.setParentId(id);
                        newTask.setType("METHOD");
                        newTask.setTestName("test_" + method.getNameAsString());
                        newTask.setSourceScanned(method.getNameAsString());
                        newTask.setContents(methodDeclaration.toString());
                        childrenTasks.add(newTask);
                    }
                }));
                if (childrenTasks.isEmpty()) {
                    return null;
                }
                // Puedes imprimir el contenido de la clase de prueba o escribirlo en un archivo
                System.out.println(testClass.toString());
                Tarea tarea = new Tarea();
                tarea.setId(id);
                tarea.setType("CLASS");
                tarea.setTestName(className.concat("Test.java"));
                tarea.setSourceScanned(testClass.getPackageDeclaration().get().getNameAsString().
                        concat(".").concat(className).concat(".java"));
                tarea.setContents(testClass.toString());
                tarea.setChildren(childrenTasks);
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
        testMethod.setStatic(isStatic);
        testMethod.setFinal(true);

        // Agrega el nombre del método y su contenido
        testMethod.setName("test_" + methodName);
        testMethod.setBody(new BlockStmt());

        return testMethod;
    }
}
