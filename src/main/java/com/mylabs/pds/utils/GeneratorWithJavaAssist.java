package com.mylabs.pds.utils;


import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtMethod;
import javassist.CtNewMethod;

public class GeneratorWithJavaAssist {

    public void generarSampleCode() {
        try {
            // Crea una instancia de la piscina de clases de Javassist
            ClassPool classPool = ClassPool.getDefault();

            // Crea una nueva clase llamada "DynamicClass"
            CtClass dynamicClass = classPool.makeClass("DynamicClass");

            // Añade un campo a la clase
            CtField field = new CtField(CtClass.intType, "dynamicField", dynamicClass);
            dynamicClass.addField(field);

            // Añade un método a la clase
            CtMethod method = CtNewMethod.make("public int getDynamicFieldValue() { return dynamicField; }", dynamicClass);
            dynamicClass.addMethod(method);

            // Crea la clase en tiempo de ejecución
            Class<?> generatedClass = dynamicClass.toClass();

            // Escribe la clase en un StringBuilder
            StringBuilder classContent = new StringBuilder();
            classContent.append(dynamicClass.toClass().toGenericString());
            classContent.append(dynamicClass.toBytecode());

            // Imprime la clase generada en el StringBuilder
            System.out.println("Clase generada:\n" + classContent.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}