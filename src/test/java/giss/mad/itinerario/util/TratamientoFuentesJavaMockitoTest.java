package giss.mad.itinerario.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import giss.mad.itinerario.model.volatilentities.Tarea;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class TratamientoFuentesJavaMockitoTest {
    /**
     * Method under test:
     * {@link TratamientoFuentesJava#lookupVarNameOfClassMethod(Tarea, String)}
     */
    @Test
    void testLookupVarNameOfClassMethod() throws UnsupportedEncodingException {
        Tarea testClass = new Tarea();
        testClass.setArguments("Arguments");
        testClass.setByteArrayCompressed("AXAXAXAX".getBytes("UTF-8"));
        testClass.setChildren(new ArrayList<>());
        testClass.setClassName("Class Name");
        testClass.setContents("Not all who wander are lost");
        testClass.setCoverage(true);
        testClass.setFolderName("Folder Name");
        testClass.setImports(new ArrayList<>());
        testClass.setLevel("Level");
        testClass.setMemberDeclarations(new ArrayList<>());
        testClass.setMethodName("Method Name");
        testClass.setName("Name");
        testClass.setNumDependencies(3);
        testClass.setNumLines(2);
        testClass.setPackageName("java.text");
        testClass.setReturnType("Return Type");
        testClass.setSourceScanned("Source Scanned");
        testClass.setTest("Test");
        assertNull(TratamientoFuentesJava.lookupVarNameOfClassMethod(testClass, "Class Name Searched"));
    }

    /**
     * Method under test:
     * {@link TratamientoFuentesJava#filterOnlyPackages(Tarea, String, String)}
     */
    @Test
    void testFilterOnlyPackages() throws UnsupportedEncodingException {
        Tarea rootSinFiltrar = new Tarea();
        rootSinFiltrar.setArguments("Arguments");
        rootSinFiltrar.setByteArrayCompressed("AXAXAXAX".getBytes("UTF-8"));
        ArrayList<Tarea> children = new ArrayList<>();
        rootSinFiltrar.setChildren(children);
        rootSinFiltrar.setClassName("Class Name");
        rootSinFiltrar.setContents("Not all who wander are lost");
        rootSinFiltrar.setCoverage(true);
        rootSinFiltrar.setFolderName("Folder Name");
        rootSinFiltrar.setImports(new ArrayList<>());
        rootSinFiltrar.setLevel("Level");
        rootSinFiltrar.setMemberDeclarations(new ArrayList<>());
        rootSinFiltrar.setMethodName("Method Name");
        rootSinFiltrar.setName("Name");
        rootSinFiltrar.setNumDependencies(3);
        rootSinFiltrar.setNumLines(2);
        rootSinFiltrar.setPackageName("java.text");
        rootSinFiltrar.setReturnType("Return Type");
        rootSinFiltrar.setSourceScanned("Source Scanned");
        rootSinFiltrar.setTest("Test");
        Tarea actualFilterOnlyPackagesResult = TratamientoFuentesJava.filterOnlyPackages(rootSinFiltrar, "java.text",
                "Class Name");
        assertEquals("Folder Name", actualFilterOnlyPackagesResult.getFolderName());
        assertEquals("Level", actualFilterOnlyPackagesResult.getLevel());
        assertEquals("Not all who wander are lost", actualFilterOnlyPackagesResult.getContents());
        assertEquals("Test", actualFilterOnlyPackagesResult.getTest());
        List<Tarea> children2 = actualFilterOnlyPackagesResult.getChildren();
        assertTrue(children2.isEmpty());
        assertEquals(children, children2);
        byte[] expectedByteArrayCompressed = "AXAXAXAX".getBytes("UTF-8");
        assertArrayEquals(expectedByteArrayCompressed, actualFilterOnlyPackagesResult.getByteArrayCompressed());
    }

    /**
     * Method under test:
     * {@link TratamientoFuentesJava#filterOnlyPackages(Tarea, String, String)}
     */
    @Test
    void testFilterOnlyPackages2() throws UnsupportedEncodingException {
        Tarea rootSinFiltrar = new Tarea();
        rootSinFiltrar.setArguments("Arguments");
        rootSinFiltrar.setByteArrayCompressed("AXAXAXAX".getBytes("UTF-8"));
        rootSinFiltrar.setClassName("Class Name");
        rootSinFiltrar.setContents("Not all who wander are lost");
        rootSinFiltrar.setCoverage(true);
        rootSinFiltrar.setFolderName("Folder Name");
        ArrayList<String> imports = new ArrayList<>();
        rootSinFiltrar.setImports(imports);
        rootSinFiltrar.setLevel("Level");
        rootSinFiltrar.setMemberDeclarations(new ArrayList<>());
        rootSinFiltrar.setMethodName("Method Name");
        rootSinFiltrar.setName("Name");
        rootSinFiltrar.setNumDependencies(3);
        rootSinFiltrar.setNumLines(2);
        rootSinFiltrar.setPackageName("java.text");
        rootSinFiltrar.setReturnType("Return Type");
        rootSinFiltrar.setSourceScanned("Source Scanned");
        rootSinFiltrar.setTest("Test");
        rootSinFiltrar.setChildren(null);
        Tarea actualFilterOnlyPackagesResult = TratamientoFuentesJava.filterOnlyPackages(rootSinFiltrar, "foo", "foo");
        assertEquals("Folder Name", actualFilterOnlyPackagesResult.getFolderName());
        assertEquals("Level", actualFilterOnlyPackagesResult.getLevel());
        assertEquals("Not all who wander are lost", actualFilterOnlyPackagesResult.getContents());
        assertEquals("Test", actualFilterOnlyPackagesResult.getTest());
        List<Tarea> children = actualFilterOnlyPackagesResult.getChildren();
        assertTrue(children.isEmpty());
        assertEquals(imports, children);
        byte[] expectedByteArrayCompressed = "AXAXAXAX".getBytes("UTF-8");
        assertArrayEquals(expectedByteArrayCompressed, actualFilterOnlyPackagesResult.getByteArrayCompressed());
    }

    /**
     * Method under test:
     * {@link TratamientoFuentesJava#filterOnlyPackages(Tarea, String, String)}
     */
    @Test
    void testFilterOnlyPackages3() throws UnsupportedEncodingException {
        Tarea tarea = new Tarea();
        tarea.setArguments(Tarea.TIPO_PACKAGE);
        tarea.setByteArrayCompressed("AXAXAXAX".getBytes("UTF-8"));
        tarea.setChildren(new ArrayList<>());
        tarea.setClassName(Tarea.TIPO_PACKAGE);
        tarea.setContents("Not all who wander are lost");
        tarea.setCoverage(true);
        tarea.setFolderName(Tarea.TIPO_PACKAGE);
        tarea.setImports(new ArrayList<>());
        tarea.setLevel(Tarea.TIPO_PACKAGE);
        tarea.setMemberDeclarations(new ArrayList<>());
        tarea.setMethodName(Tarea.TIPO_PACKAGE);
        tarea.setName(Tarea.TIPO_PACKAGE);
        tarea.setNumDependencies(3);
        tarea.setNumLines(2);
        tarea.setPackageName("java.text");
        tarea.setReturnType(Tarea.TIPO_PACKAGE);
        tarea.setSourceScanned(Tarea.TIPO_PACKAGE);
        tarea.setTest(Tarea.TIPO_PACKAGE);

        ArrayList<Tarea> children = new ArrayList<>();
        children.add(tarea);

        Tarea rootSinFiltrar = new Tarea();
        rootSinFiltrar.setArguments("Arguments");
        rootSinFiltrar.setByteArrayCompressed("AXAXAXAX".getBytes("UTF-8"));
        rootSinFiltrar.setChildren(children);
        rootSinFiltrar.setClassName("Class Name");
        rootSinFiltrar.setContents("Not all who wander are lost");
        rootSinFiltrar.setCoverage(true);
        rootSinFiltrar.setFolderName("Folder Name");
        rootSinFiltrar.setImports(new ArrayList<>());
        rootSinFiltrar.setLevel("Level");
        rootSinFiltrar.setMemberDeclarations(new ArrayList<>());
        rootSinFiltrar.setMethodName("Method Name");
        rootSinFiltrar.setName("Name");
        rootSinFiltrar.setNumDependencies(3);
        rootSinFiltrar.setNumLines(2);
        rootSinFiltrar.setPackageName("java.text");
        rootSinFiltrar.setReturnType("Return Type");
        rootSinFiltrar.setSourceScanned("Source Scanned");
        rootSinFiltrar.setTest("Test");
        Tarea actualFilterOnlyPackagesResult = TratamientoFuentesJava.filterOnlyPackages(rootSinFiltrar, "java.text",
                "Class Name");
        assertEquals("Folder Name", actualFilterOnlyPackagesResult.getFolderName());
        assertEquals("Level", actualFilterOnlyPackagesResult.getLevel());
        assertEquals("Not all who wander are lost", actualFilterOnlyPackagesResult.getContents());
        assertEquals("Test", actualFilterOnlyPackagesResult.getTest());
        List<Tarea> children2 = actualFilterOnlyPackagesResult.getChildren();
        assertEquals(1, children2.size());
        assertEquals(children, children2);
        byte[] expectedByteArrayCompressed = "AXAXAXAX".getBytes("UTF-8");
        assertArrayEquals(expectedByteArrayCompressed, actualFilterOnlyPackagesResult.getByteArrayCompressed());
    }

    /**
     * Method under test:
     * {@link TratamientoFuentesJava#filterOnlyPackages(Tarea, String, String)}
     */
    @Test
    void testFilterOnlyPackages4() throws UnsupportedEncodingException {
        Tarea tarea = new Tarea();
        tarea.setArguments(Tarea.TIPO_PACKAGE);
        tarea.setByteArrayCompressed("AXAXAXAX".getBytes("UTF-8"));
        tarea.setChildren(new ArrayList<>());
        tarea.setClassName(Tarea.TIPO_PACKAGE);
        tarea.setContents("Not all who wander are lost");
        tarea.setCoverage(true);
        tarea.setFolderName(Tarea.TIPO_PACKAGE);
        tarea.setImports(new ArrayList<>());
        tarea.setLevel(Tarea.TIPO_PACKAGE);
        tarea.setMemberDeclarations(new ArrayList<>());
        tarea.setMethodName(Tarea.TIPO_PACKAGE);
        tarea.setName(Tarea.TIPO_PACKAGE);
        tarea.setNumDependencies(3);
        tarea.setNumLines(2);
        tarea.setPackageName("java.text");
        tarea.setReturnType(Tarea.TIPO_PACKAGE);
        tarea.setSourceScanned(Tarea.TIPO_PACKAGE);
        tarea.setTest(Tarea.TIPO_PACKAGE);

        Tarea tarea2 = new Tarea();
        tarea2.setArguments("*");
        tarea2.setByteArrayCompressed(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
        tarea2.setChildren(new ArrayList<>());
        tarea2.setClassName("*");
        tarea2.setContents(Tarea.TIPO_PACKAGE);
        tarea2.setCoverage(false);
        tarea2.setFolderName("*");
        tarea2.setImports(new ArrayList<>());
        tarea2.setLevel("*");
        tarea2.setMemberDeclarations(new ArrayList<>());
        tarea2.setMethodName("*");
        tarea2.setName("*");
        tarea2.setNumDependencies(10);
        tarea2.setNumLines(10);
        tarea2.setPackageName(Tarea.TIPO_PACKAGE);
        tarea2.setReturnType("*");
        tarea2.setSourceScanned("*");
        tarea2.setTest("*");

        ArrayList<Tarea> children = new ArrayList<>();
        children.add(tarea2);
        children.add(tarea);

        Tarea rootSinFiltrar = new Tarea();
        rootSinFiltrar.setArguments("Arguments");
        rootSinFiltrar.setByteArrayCompressed("AXAXAXAX".getBytes("UTF-8"));
        rootSinFiltrar.setChildren(children);
        rootSinFiltrar.setClassName("Class Name");
        rootSinFiltrar.setContents("Not all who wander are lost");
        rootSinFiltrar.setCoverage(true);
        rootSinFiltrar.setFolderName("Folder Name");
        rootSinFiltrar.setImports(new ArrayList<>());
        rootSinFiltrar.setLevel("Level");
        rootSinFiltrar.setMemberDeclarations(new ArrayList<>());
        rootSinFiltrar.setMethodName("Method Name");
        rootSinFiltrar.setName("Name");
        rootSinFiltrar.setNumDependencies(3);
        rootSinFiltrar.setNumLines(2);
        rootSinFiltrar.setPackageName("java.text");
        rootSinFiltrar.setReturnType("Return Type");
        rootSinFiltrar.setSourceScanned("Source Scanned");
        rootSinFiltrar.setTest("Test");
        Tarea actualFilterOnlyPackagesResult = TratamientoFuentesJava.filterOnlyPackages(rootSinFiltrar, "java.text",
                "Class Name");
        assertEquals("Folder Name", actualFilterOnlyPackagesResult.getFolderName());
        assertEquals("Level", actualFilterOnlyPackagesResult.getLevel());
        assertEquals("Not all who wander are lost", actualFilterOnlyPackagesResult.getContents());
        assertEquals("Test", actualFilterOnlyPackagesResult.getTest());
        assertEquals(1, actualFilterOnlyPackagesResult.getChildren().size());
        byte[] expectedByteArrayCompressed = "AXAXAXAX".getBytes("UTF-8");
        assertArrayEquals(expectedByteArrayCompressed, actualFilterOnlyPackagesResult.getByteArrayCompressed());
    }

    /**
     * Method under test:
     * {@link TratamientoFuentesJava#filterOnlyPackages(Tarea, String, String)}
     */
    @Test
    void testFilterOnlyPackages5() throws UnsupportedEncodingException {
        Tarea rootSinFiltrar = new Tarea();
        rootSinFiltrar.setArguments("Arguments");
        rootSinFiltrar.setByteArrayCompressed("AXAXAXAX".getBytes("UTF-8"));
        rootSinFiltrar.setClassName("Class Name");
        rootSinFiltrar.setContents("Not all who wander are lost");
        rootSinFiltrar.setCoverage(true);
        rootSinFiltrar.setFolderName("Folder Name");
        ArrayList<String> imports = new ArrayList<>();
        rootSinFiltrar.setImports(imports);
        rootSinFiltrar.setLevel(Tarea.TIPO_PACKAGE);
        rootSinFiltrar.setMemberDeclarations(new ArrayList<>());
        rootSinFiltrar.setMethodName("Method Name");
        rootSinFiltrar.setName("Name");
        rootSinFiltrar.setNumDependencies(3);
        rootSinFiltrar.setNumLines(2);
        rootSinFiltrar.setPackageName("java.text");
        rootSinFiltrar.setReturnType("Return Type");
        rootSinFiltrar.setSourceScanned("Source Scanned");
        rootSinFiltrar.setTest("Test");
        rootSinFiltrar.setChildren(null);
        Tarea actualFilterOnlyPackagesResult = TratamientoFuentesJava.filterOnlyPackages(rootSinFiltrar, "foo", "foo");
        assertEquals("Folder Name", actualFilterOnlyPackagesResult.getFolderName());
        assertEquals("Not all who wander are lost", actualFilterOnlyPackagesResult.getContents());
        assertEquals("Test", actualFilterOnlyPackagesResult.getTest());
        assertEquals("package", actualFilterOnlyPackagesResult.getLevel());
        List<Tarea> children = actualFilterOnlyPackagesResult.getChildren();
        assertTrue(children.isEmpty());
        assertEquals(imports, children);
        byte[] expectedByteArrayCompressed = "AXAXAXAX".getBytes("UTF-8");
        assertArrayEquals(expectedByteArrayCompressed, actualFilterOnlyPackagesResult.getByteArrayCompressed());
    }

    /**
     * Method under test:
     * {@link TratamientoFuentesJava#filterOnlyPackages(Tarea, String, String)}
     */
    @Test
    void testFilterOnlyPackages6() throws UnsupportedEncodingException {
        Tarea rootSinFiltrar = new Tarea();
        rootSinFiltrar.setArguments("Arguments");
        rootSinFiltrar.setByteArrayCompressed("AXAXAXAX".getBytes("UTF-8"));
        rootSinFiltrar.setClassName("Class Name");
        rootSinFiltrar.setContents("Not all who wander are lost");
        rootSinFiltrar.setCoverage(true);
        rootSinFiltrar.setFolderName("Folder Name");
        rootSinFiltrar.setImports(new ArrayList<>());
        rootSinFiltrar.setLevel(Tarea.TIPO_PACKAGE);
        rootSinFiltrar.setMemberDeclarations(new ArrayList<>());
        rootSinFiltrar.setMethodName("Method Name");
        rootSinFiltrar.setName("Name");
        rootSinFiltrar.setNumDependencies(3);
        rootSinFiltrar.setNumLines(2);
        rootSinFiltrar.setPackageName("java.text");
        rootSinFiltrar.setReturnType("Return Type");
        rootSinFiltrar.setSourceScanned("Source Scanned");
        rootSinFiltrar.setTest("Test");
        rootSinFiltrar.setChildren(null);
        Tarea actualFilterOnlyPackagesResult = TratamientoFuentesJava.filterOnlyPackages(rootSinFiltrar, "java.text",
                "foo");
        assertEquals("Folder Name", actualFilterOnlyPackagesResult.getFolderName());
        assertEquals("Not all who wander are lost", actualFilterOnlyPackagesResult.getContents());
        assertEquals("Test", actualFilterOnlyPackagesResult.getTest());
        assertEquals("package", actualFilterOnlyPackagesResult.getLevel());
        assertEquals(1, actualFilterOnlyPackagesResult.getChildren().size());
        byte[] expectedByteArrayCompressed = "AXAXAXAX".getBytes("UTF-8");
        assertArrayEquals(expectedByteArrayCompressed, actualFilterOnlyPackagesResult.getByteArrayCompressed());
    }

    /**
     * Method under test:
     * {@link TratamientoFuentesJava#filterOnlyPackages(Tarea, String, String)}
     */
    @Test
    void testFilterOnlyPackages7() throws UnsupportedEncodingException {
        Tarea rootSinFiltrar = new Tarea();
        rootSinFiltrar.setArguments("Arguments");
        rootSinFiltrar.setByteArrayCompressed("AXAXAXAX".getBytes("UTF-8"));
        rootSinFiltrar.setClassName("Class Name");
        rootSinFiltrar.setContents("Not all who wander are lost");
        rootSinFiltrar.setCoverage(true);
        rootSinFiltrar.setFolderName("Folder Name");
        rootSinFiltrar.setImports(new ArrayList<>());
        rootSinFiltrar.setLevel(Tarea.TIPO_PACKAGE);
        rootSinFiltrar.setMemberDeclarations(new ArrayList<>());
        rootSinFiltrar.setMethodName("Method Name");
        rootSinFiltrar.setName("Name");
        rootSinFiltrar.setNumDependencies(3);
        rootSinFiltrar.setNumLines(2);
        rootSinFiltrar.setPackageName("java.text");
        rootSinFiltrar.setReturnType("Return Type");
        rootSinFiltrar.setSourceScanned("Source Scanned");
        rootSinFiltrar.setTest("Test");
        rootSinFiltrar.setChildren(null);
        Tarea actualFilterOnlyPackagesResult = TratamientoFuentesJava.filterOnlyPackages(rootSinFiltrar, "*", "foo");
        assertEquals("Folder Name", actualFilterOnlyPackagesResult.getFolderName());
        assertEquals("Not all who wander are lost", actualFilterOnlyPackagesResult.getContents());
        assertEquals("Test", actualFilterOnlyPackagesResult.getTest());
        assertEquals("package", actualFilterOnlyPackagesResult.getLevel());
        assertEquals(1, actualFilterOnlyPackagesResult.getChildren().size());
        byte[] expectedByteArrayCompressed = "AXAXAXAX".getBytes("UTF-8");
        assertArrayEquals(expectedByteArrayCompressed, actualFilterOnlyPackagesResult.getByteArrayCompressed());
    }

    /**
     * Method under test:
     * {@link TratamientoFuentesJava#recursiveLookupPackages(Tarea, String, String, List)}
     */
    @Test
    void testRecursiveLookupPackages() throws UnsupportedEncodingException {
        Tarea root = new Tarea();
        root.setArguments("Arguments");
        root.setByteArrayCompressed("AXAXAXAX".getBytes("UTF-8"));
        ArrayList<Tarea> children = new ArrayList<>();
        root.setChildren(children);
        root.setClassName("Class Name");
        root.setContents("Not all who wander are lost");
        root.setCoverage(true);
        root.setFolderName("Folder Name");
        root.setImports(new ArrayList<>());
        root.setLevel("Level");
        root.setMemberDeclarations(new ArrayList<>());
        root.setMethodName("Method Name");
        root.setName("Name");
        root.setNumDependencies(3);
        root.setNumLines(2);
        root.setPackageName("java.text");
        root.setReturnType("Return Type");
        root.setSourceScanned("Source Scanned");
        root.setTest("Test");
        TratamientoFuentesJava.recursiveLookupPackages(root, "java.text", "Class Name Pattern", new ArrayList<>());
        assertEquals("Arguments", root.getArguments());
        assertEquals("Class Name", root.getClassName());
        assertEquals("Folder Name", root.getFolderName());
        assertEquals("Level", root.getLevel());
        assertEquals("Method Name", root.getMethodName());
        assertEquals("Name", root.getName());
        assertEquals("Not all who wander are lost", root.getContents());
        assertEquals("Return Type", root.getReturnType());
        assertEquals("Source Scanned", root.getSourceScanned());
        assertEquals("Test", root.getTest());
        assertEquals("java.text", root.getPackageName());
        assertEquals(2, root.getNumLines().intValue());
        assertEquals(3, root.getNumDependencies().intValue());
        assertTrue(root.getCoverage());
        assertTrue(root.getChildren().isEmpty());
        assertEquals(children, root.getImports());
        assertEquals(children, root.getMemberDeclarations());
        byte[] expectedByteArrayCompressed = "AXAXAXAX".getBytes("UTF-8");
        assertArrayEquals(expectedByteArrayCompressed, root.getByteArrayCompressed());
    }

    /**
     * Method under test:
     * {@link TratamientoFuentesJava#recursiveLookupPackages(Tarea, String, String, List)}
     */
    @Test
    void testRecursiveLookupPackages2() throws UnsupportedEncodingException {
        Tarea root = new Tarea();
        root.setArguments("Arguments");
        root.setByteArrayCompressed("AXAXAXAX".getBytes("UTF-8"));
        root.setClassName("Class Name");
        root.setContents("Not all who wander are lost");
        root.setCoverage(true);
        root.setFolderName("Folder Name");
        ArrayList<String> imports = new ArrayList<>();
        root.setImports(imports);
        root.setLevel("Level");
        root.setMemberDeclarations(new ArrayList<>());
        root.setMethodName("Method Name");
        root.setName("Name");
        root.setNumDependencies(3);
        root.setNumLines(2);
        root.setPackageName("java.text");
        root.setReturnType("Return Type");
        root.setSourceScanned("Source Scanned");
        root.setTest("Test");
        root.setChildren(null);
        TratamientoFuentesJava.recursiveLookupPackages(root, "foo", "foo", new ArrayList<>());
        assertEquals("Arguments", root.getArguments());
        assertEquals("Class Name", root.getClassName());
        assertEquals("Folder Name", root.getFolderName());
        assertEquals("Level", root.getLevel());
        assertEquals("Method Name", root.getMethodName());
        assertEquals("Name", root.getName());
        assertEquals("Not all who wander are lost", root.getContents());
        assertEquals("Return Type", root.getReturnType());
        assertEquals("Source Scanned", root.getSourceScanned());
        assertEquals("Test", root.getTest());
        assertEquals("java.text", root.getPackageName());
        assertEquals(2, root.getNumLines().intValue());
        assertEquals(3, root.getNumDependencies().intValue());
        assertTrue(root.getCoverage());
        assertTrue(root.getImports().isEmpty());
        assertEquals(imports, root.getMemberDeclarations());
        byte[] expectedByteArrayCompressed = "AXAXAXAX".getBytes("UTF-8");
        assertArrayEquals(expectedByteArrayCompressed, root.getByteArrayCompressed());
    }

    /**
     * Method under test:
     * {@link TratamientoFuentesJava#recursiveLookupPackages(Tarea, String, String, List)}
     */
    @Test
    void testRecursiveLookupPackages3() throws UnsupportedEncodingException {
        Tarea tarea = new Tarea();
        tarea.setArguments(Tarea.TIPO_PACKAGE);
        tarea.setByteArrayCompressed("AXAXAXAX".getBytes("UTF-8"));
        tarea.setChildren(new ArrayList<>());
        tarea.setClassName(Tarea.TIPO_PACKAGE);
        tarea.setContents("Not all who wander are lost");
        tarea.setCoverage(true);
        tarea.setFolderName(Tarea.TIPO_PACKAGE);
        tarea.setImports(new ArrayList<>());
        tarea.setLevel(Tarea.TIPO_PACKAGE);
        tarea.setMemberDeclarations(new ArrayList<>());
        tarea.setMethodName(Tarea.TIPO_PACKAGE);
        tarea.setName(Tarea.TIPO_PACKAGE);
        tarea.setNumDependencies(3);
        tarea.setNumLines(2);
        tarea.setPackageName("java.text");
        tarea.setReturnType(Tarea.TIPO_PACKAGE);
        tarea.setSourceScanned(Tarea.TIPO_PACKAGE);
        tarea.setTest(Tarea.TIPO_PACKAGE);

        ArrayList<Tarea> children = new ArrayList<>();
        children.add(tarea);

        Tarea root = new Tarea();
        root.setArguments("Arguments");
        root.setByteArrayCompressed("AXAXAXAX".getBytes("UTF-8"));
        root.setChildren(children);
        root.setClassName("Class Name");
        root.setContents("Not all who wander are lost");
        root.setCoverage(true);
        root.setFolderName("Folder Name");
        root.setImports(new ArrayList<>());
        root.setLevel("Level");
        root.setMemberDeclarations(new ArrayList<>());
        root.setMethodName("Method Name");
        root.setName("Name");
        root.setNumDependencies(3);
        root.setNumLines(2);
        root.setPackageName("java.text");
        root.setReturnType("Return Type");
        root.setSourceScanned("Source Scanned");
        root.setTest("Test");
        ArrayList<Tarea> listAcumuladas = new ArrayList<>();
        TratamientoFuentesJava.recursiveLookupPackages(root, "java.text", "Class Name Pattern", listAcumuladas);
        assertEquals(1, listAcumuladas.size());
    }

    /**
     * Method under test:
     * {@link TratamientoFuentesJava#recursiveLookupPackages(Tarea, String, String, List)}
     */
    @Test
    void testRecursiveLookupPackages4() throws UnsupportedEncodingException {
        Tarea tarea = new Tarea();
        tarea.setArguments(Tarea.TIPO_PACKAGE);
        tarea.setByteArrayCompressed("AXAXAXAX".getBytes("UTF-8"));
        tarea.setChildren(new ArrayList<>());
        tarea.setClassName(Tarea.TIPO_PACKAGE);
        tarea.setContents("Not all who wander are lost");
        tarea.setCoverage(true);
        tarea.setFolderName(Tarea.TIPO_PACKAGE);
        tarea.setImports(new ArrayList<>());
        tarea.setLevel(Tarea.TIPO_PACKAGE);
        tarea.setMemberDeclarations(new ArrayList<>());
        tarea.setMethodName(Tarea.TIPO_PACKAGE);
        tarea.setName(Tarea.TIPO_PACKAGE);
        tarea.setNumDependencies(3);
        tarea.setNumLines(2);
        tarea.setPackageName("java.text");
        tarea.setReturnType(Tarea.TIPO_PACKAGE);
        tarea.setSourceScanned(Tarea.TIPO_PACKAGE);
        tarea.setTest(Tarea.TIPO_PACKAGE);

        Tarea tarea2 = new Tarea();
        tarea2.setArguments("*");
        tarea2.setByteArrayCompressed(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
        tarea2.setChildren(new ArrayList<>());
        tarea2.setClassName("*");
        tarea2.setContents(Tarea.TIPO_PACKAGE);
        tarea2.setCoverage(false);
        tarea2.setFolderName("*");
        tarea2.setImports(new ArrayList<>());
        tarea2.setLevel("*");
        tarea2.setMemberDeclarations(new ArrayList<>());
        tarea2.setMethodName("*");
        tarea2.setName("*");
        tarea2.setNumDependencies(10);
        tarea2.setNumLines(10);
        tarea2.setPackageName(Tarea.TIPO_PACKAGE);
        tarea2.setReturnType("*");
        tarea2.setSourceScanned("*");
        tarea2.setTest("*");

        ArrayList<Tarea> children = new ArrayList<>();
        children.add(tarea2);
        children.add(tarea);

        Tarea root = new Tarea();
        root.setArguments("Arguments");
        root.setByteArrayCompressed("AXAXAXAX".getBytes("UTF-8"));
        root.setChildren(children);
        root.setClassName("Class Name");
        root.setContents("Not all who wander are lost");
        root.setCoverage(true);
        root.setFolderName("Folder Name");
        root.setImports(new ArrayList<>());
        root.setLevel("Level");
        root.setMemberDeclarations(new ArrayList<>());
        root.setMethodName("Method Name");
        root.setName("Name");
        root.setNumDependencies(3);
        root.setNumLines(2);
        root.setPackageName("java.text");
        root.setReturnType("Return Type");
        root.setSourceScanned("Source Scanned");
        root.setTest("Test");
        ArrayList<Tarea> listAcumuladas = new ArrayList<>();
        TratamientoFuentesJava.recursiveLookupPackages(root, "java.text", "Class Name Pattern", listAcumuladas);
        assertEquals(1, listAcumuladas.size());
    }

    /**
     * Method under test:
     * {@link TratamientoFuentesJava#recursiveLookupPackages(Tarea, String, String, List)}
     */
    @Test
    void testRecursiveLookupPackages5() throws UnsupportedEncodingException {
        Tarea tarea = new Tarea();
        tarea.setArguments(Tarea.TIPO_PACKAGE);
        tarea.setByteArrayCompressed("AXAXAXAX".getBytes("UTF-8"));
        tarea.setChildren(new ArrayList<>());
        tarea.setClassName(Tarea.TIPO_PACKAGE);
        tarea.setContents("Not all who wander are lost");
        tarea.setCoverage(true);
        tarea.setFolderName(Tarea.TIPO_PACKAGE);
        tarea.setImports(new ArrayList<>());
        tarea.setLevel(Tarea.TIPO_PACKAGE);
        tarea.setMemberDeclarations(new ArrayList<>());
        tarea.setMethodName(Tarea.TIPO_PACKAGE);
        tarea.setName(Tarea.TIPO_PACKAGE);
        tarea.setNumDependencies(3);
        tarea.setNumLines(2);
        tarea.setPackageName("java.text");
        tarea.setReturnType(Tarea.TIPO_PACKAGE);
        tarea.setSourceScanned(Tarea.TIPO_PACKAGE);
        tarea.setTest(Tarea.TIPO_PACKAGE);

        Tarea tarea2 = new Tarea();
        tarea2.setArguments("*");
        tarea2.setByteArrayCompressed(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
        tarea2.setChildren(new ArrayList<>());
        tarea2.setClassName("*");
        tarea2.setContents(Tarea.TIPO_PACKAGE);
        tarea2.setCoverage(false);
        tarea2.setFolderName("*");
        tarea2.setImports(new ArrayList<>());
        tarea2.setLevel(Tarea.TIPO_PACKAGE);
        tarea2.setMemberDeclarations(new ArrayList<>());
        tarea2.setMethodName("*");
        tarea2.setName("*");
        tarea2.setNumDependencies(10);
        tarea2.setNumLines(10);
        tarea2.setPackageName(Tarea.TIPO_PACKAGE);
        tarea2.setReturnType("*");
        tarea2.setSourceScanned("*");
        tarea2.setTest("*");

        ArrayList<Tarea> children = new ArrayList<>();
        children.add(tarea2);
        children.add(tarea);

        Tarea root = new Tarea();
        root.setArguments("Arguments");
        root.setByteArrayCompressed("AXAXAXAX".getBytes("UTF-8"));
        root.setChildren(children);
        root.setClassName("Class Name");
        root.setContents("Not all who wander are lost");
        root.setCoverage(true);
        root.setFolderName("Folder Name");
        root.setImports(new ArrayList<>());
        root.setLevel("Level");
        root.setMemberDeclarations(new ArrayList<>());
        root.setMethodName("Method Name");
        root.setName("Name");
        root.setNumDependencies(3);
        root.setNumLines(2);
        root.setPackageName("java.text");
        root.setReturnType("Return Type");
        root.setSourceScanned("Source Scanned");
        root.setTest("Test");
        ArrayList<Tarea> listAcumuladas = new ArrayList<>();
        TratamientoFuentesJava.recursiveLookupPackages(root, "java.text", "Class Name Pattern", listAcumuladas);
        assertEquals(2, listAcumuladas.size());
    }

    /**
     * Method under test:
     * {@link TratamientoFuentesJava#recursiveLookupPackages(Tarea, String, String, List)}
     */
    @Test
    void testRecursiveLookupPackages6() throws UnsupportedEncodingException {
        Tarea root = new Tarea();
        root.setArguments("Arguments");
        root.setByteArrayCompressed("AXAXAXAX".getBytes("UTF-8"));
        root.setChildren(new ArrayList<>());
        root.setClassName("Class Name");
        root.setContents("Not all who wander are lost");
        root.setCoverage(true);
        root.setFolderName("Folder Name");
        root.setImports(new ArrayList<>());
        root.setLevel(Tarea.TIPO_PACKAGE);
        root.setMemberDeclarations(new ArrayList<>());
        root.setMethodName("Method Name");
        root.setName("Name");
        root.setNumDependencies(3);
        root.setNumLines(2);
        root.setPackageName("java.text");
        root.setReturnType("Return Type");
        root.setSourceScanned("Source Scanned");
        root.setTest("Test");
        ArrayList<Tarea> listAcumuladas = new ArrayList<>();
        TratamientoFuentesJava.recursiveLookupPackages(root, "java.text", "Class Name Pattern", listAcumuladas);
        assertEquals(1, listAcumuladas.size());
    }

    /**
     * Method under test:
     * {@link TratamientoFuentesJava#recursiveLookupPackages(Tarea, String, String, List)}
     */
    @Test
    void testRecursiveLookupPackages7() throws UnsupportedEncodingException {
        Tarea root = new Tarea();
        root.setArguments("Arguments");
        root.setByteArrayCompressed("AXAXAXAX".getBytes("UTF-8"));
        root.setClassName("Class Name");
        root.setContents("Not all who wander are lost");
        root.setCoverage(true);
        root.setFolderName("Folder Name");
        ArrayList<String> imports = new ArrayList<>();
        root.setImports(imports);
        root.setLevel(Tarea.TIPO_PACKAGE);
        root.setMemberDeclarations(new ArrayList<>());
        root.setMethodName("Method Name");
        root.setName("Name");
        root.setNumDependencies(3);
        root.setNumLines(2);
        root.setPackageName("java.text");
        root.setReturnType("Return Type");
        root.setSourceScanned("Source Scanned");
        root.setTest("Test");
        root.setChildren(null);
        TratamientoFuentesJava.recursiveLookupPackages(root, "foo", "foo", new ArrayList<>());
        assertEquals("Arguments", root.getArguments());
        assertEquals("Class Name", root.getClassName());
        assertEquals("Folder Name", root.getFolderName());
        assertEquals("Method Name", root.getMethodName());
        assertEquals("Name", root.getName());
        assertEquals("Not all who wander are lost", root.getContents());
        assertEquals("Return Type", root.getReturnType());
        assertEquals("Source Scanned", root.getSourceScanned());
        assertEquals("Test", root.getTest());
        assertEquals("java.text", root.getPackageName());
        assertEquals("package", root.getLevel());
        assertEquals(2, root.getNumLines().intValue());
        assertEquals(3, root.getNumDependencies().intValue());
        assertTrue(root.getCoverage());
        assertTrue(root.getImports().isEmpty());
        assertEquals(imports, root.getMemberDeclarations());
        byte[] expectedByteArrayCompressed = "AXAXAXAX".getBytes("UTF-8");
        assertArrayEquals(expectedByteArrayCompressed, root.getByteArrayCompressed());
    }
}
