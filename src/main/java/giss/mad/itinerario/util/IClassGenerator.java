package giss.mad.itinerario.util;


import giss.mad.itinerario.model.volatilentities.Tarea;

import java.util.Map;

public interface IClassGenerator {

    String RXFORJAVAPACKAGES = "REGEXFORJAVAPACKAGES";
    String RXFORJAVAIMPORTS = "REGEXFORJAVAIMPORTS";
    String RXFORJAVACLASS = "REGEXFORJAVACLASS";
    String RXFORVARDECLARATION = "REGEXFORVARDECLARATION";
    String RXFORPUBLICMETHODS = "REGEXFORPUBLICMETHODS";
    Tarea generateTestClassForJavaFile(String sourceCode, Map<String, String> rxExpressionsMap);
    Tarea obtainTestClass(String sourceCode, Map<String, String> rxExpressionsMap);

}
