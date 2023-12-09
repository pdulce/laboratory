package giss.mad.itinerario.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import giss.mad.itinerario.model.volatilentities.Tarea;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class SimpleClassGeneratorDiffblueTest {
    /**
     * Method under test: {@link SimpleClassGenerator#obtainTestClass(String, Map)}
     */
    @Test
    void testObtainTestClass() {
        SimpleClassGenerator simpleClassGenerator = new SimpleClassGenerator();

        HashMap<String, String> rxExpressionsMap = new HashMap<>();
        rxExpressionsMap.put((String) IClassGenerator.RXFORJAVAPACKAGES, "foo");
        rxExpressionsMap.put((String) IClassGenerator.RXFORJAVAIMPORTS, "foo");
        rxExpressionsMap.put((String) IClassGenerator.RXFORJAVACLASS, "foo");
        rxExpressionsMap.put((String) IClassGenerator.RXFORVARDECLARATION, "foo");
        Tarea actualObtainTestClassResult = simpleClassGenerator.obtainTestClass("clase de test", rxExpressionsMap);
        assertEquals("clase de test", actualObtainTestClassResult.getContents());
        assertEquals("clase de test", actualObtainTestClassResult.getLevel());
        List<Map<String, String>> memberDeclarations = actualObtainTestClassResult.getMemberDeclarations();
        assertTrue(memberDeclarations.isEmpty());
        assertEquals(memberDeclarations, actualObtainTestClassResult.getChildren());
        assertEquals(memberDeclarations, actualObtainTestClassResult.getImports());
    }

    /**
     * Method under test: {@link SimpleClassGenerator#obtainTestClass(String, Map)}
     */
    @Test
    void testObtainTestClass2() {
        SimpleClassGenerator simpleClassGenerator = new SimpleClassGenerator();

        HashMap<String, String> rxExpressionsMap = new HashMap<>();
        rxExpressionsMap.put((String) IClassGenerator.RXFORJAVAPACKAGES, "foo");
        rxExpressionsMap.put((String) IClassGenerator.RXFORJAVAIMPORTS, "foo");
        rxExpressionsMap.put((String) IClassGenerator.RXFORJAVACLASS, "foo");
        rxExpressionsMap.put((String) IClassGenerator.RXFORVARDECLARATION, "clase de test");
        Tarea actualObtainTestClassResult = simpleClassGenerator.obtainTestClass("clase de test", rxExpressionsMap);
        assertEquals("clase de test", actualObtainTestClassResult.getContents());
        assertEquals("clase de test", actualObtainTestClassResult.getLevel());
        List<Map<String, String>> memberDeclarations = actualObtainTestClassResult.getMemberDeclarations();
        assertEquals(1, memberDeclarations.size());
        assertEquals(1, memberDeclarations.get(0).size());
        List<String> imports = actualObtainTestClassResult.getImports();
        assertTrue(imports.isEmpty());
        assertEquals(imports, actualObtainTestClassResult.getChildren());
    }

    /**
     * Method under test:
     * {@link SimpleClassGenerator#generateTestClassForJavaFile(String, Map)}
     */
    @Test
    void testGenerateTestClassForJavaFile() {
        SimpleClassGenerator simpleClassGenerator = new SimpleClassGenerator();
        assertNull(simpleClassGenerator.generateTestClassForJavaFile("public interface ", new HashMap<>()));
    }

    /**
     * Method under test:
     * {@link SimpleClassGenerator#generateTestClassForJavaFile(String, Map)}
     */
    @Test
    void testGenerateTestClassForJavaFile2() {
        SimpleClassGenerator simpleClassGenerator = new SimpleClassGenerator();
        assertNull(simpleClassGenerator.generateTestClassForJavaFile("public final interface ", new HashMap<>()));
    }
}
