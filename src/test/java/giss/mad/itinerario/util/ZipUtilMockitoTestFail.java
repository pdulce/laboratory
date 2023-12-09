package giss.mad.itinerario.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import giss.mad.itinerario.model.volatilentities.Tarea;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class ZipUtilMockitoTestFail {
    /**
     * Method under test: {@link ZipUtil#generarZipDesdeTareas(List)}
     */
    @Test
    void testGenerarZipDesdeTareas() throws Exception {
        ZipUtil zipUtil = new ZipUtil();
        byte[] actualGenerarZipDesdeTareasResult = zipUtil.generarZipDesdeTareas(new ArrayList<>());
        assertEquals((byte) -47, actualGenerarZipDesdeTareasResult[10]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[118]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[119]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[120]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[121]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[123]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[125]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[128]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[129]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[131]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[132]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[133]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[134]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[135]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[14]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[15]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[17]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[18]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[19]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[20]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[21]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[22]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[23]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[24]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[5]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[9]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[Float.MAX_EXPONENT]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[Short.SIZE]);
        assertEquals(136, actualGenerarZipDesdeTareasResult.length);
        assertEquals((byte) 1, actualGenerarZipDesdeTareasResult[122]);
        assertEquals((byte) 1, actualGenerarZipDesdeTareasResult[124]);
        assertEquals((byte) 20, actualGenerarZipDesdeTareasResult[4]);
        assertEquals((byte) 3, actualGenerarZipDesdeTareasResult[2]);
        assertEquals((byte) 4, actualGenerarZipDesdeTareasResult[3]);
        assertEquals((byte) 5, actualGenerarZipDesdeTareasResult[116]);
        assertEquals((byte) 6, actualGenerarZipDesdeTareasResult[117]);
        assertEquals('/', actualGenerarZipDesdeTareasResult[113]);
        assertEquals('8', actualGenerarZipDesdeTareasResult[126]);
        assertEquals(':', actualGenerarZipDesdeTareasResult[130]);
        assertEquals('K', actualGenerarZipDesdeTareasResult[1]);
        assertEquals('K', actualGenerarZipDesdeTareasResult[115]);
        assertEquals('P', actualGenerarZipDesdeTareasResult[0]);
        assertEquals('P', actualGenerarZipDesdeTareasResult[114]);
        assertEquals('W', actualGenerarZipDesdeTareasResult[13]);
        assertEquals('\b', actualGenerarZipDesdeTareasResult[6]);
        assertEquals('\b', actualGenerarZipDesdeTareasResult[7]);
        assertEquals('\b', actualGenerarZipDesdeTareasResult[8]);
        assertEquals('a', actualGenerarZipDesdeTareasResult[112]);
        assertEquals('v', actualGenerarZipDesdeTareasResult[111]);
    }

    /**
     * Method under test: {@link ZipUtil#generarZipDesdeTareas(List)}
     */
    @Test
    void testGenerarZipDesdeTareas2() throws Exception {
        ZipUtil zipUtil = new ZipUtil();

        Tarea tarea = new Tarea();
        tarea.setArguments("test/java/");
        tarea.setByteArrayCompressed("AXAXAXAX".getBytes("UTF-8"));
        tarea.setChildren(new ArrayList<>());
        tarea.setClassName("test/java/");
        tarea.setContents("Not all who wander are lost");
        tarea.setCoverage(true);
        tarea.setFolderName("test/java/");
        tarea.setImports(new ArrayList<>());
        tarea.setLevel("test/java/");
        tarea.setMemberDeclarations(new ArrayList<>());
        tarea.setMethodName("test/java/");
        tarea.setName("test/java/");
        tarea.setNumDependencies(3);
        tarea.setNumLines(2);
        tarea.setPackageName("java.text");
        tarea.setReturnType("test/java/");
        tarea.setSourceScanned("test/java/");
        tarea.setTest("test/java/");

        ArrayList<Tarea> tareas = new ArrayList<>();
        tareas.add(tarea);
        byte[] actualGenerarZipDesdeTareasResult = zipUtil.generarZipDesdeTareas(tareas);
        assertEquals((byte) -47, actualGenerarZipDesdeTareasResult[10]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[118]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[119]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[120]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[121]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[123]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[125]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[128]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[129]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[131]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[132]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[133]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[134]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[135]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[14]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[15]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[17]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[18]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[19]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[20]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[21]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[22]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[23]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[24]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[5]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[9]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[Float.MAX_EXPONENT]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[Short.SIZE]);
        assertEquals(136, actualGenerarZipDesdeTareasResult.length);
        assertEquals((byte) 1, actualGenerarZipDesdeTareasResult[122]);
        assertEquals((byte) 1, actualGenerarZipDesdeTareasResult[124]);
        assertEquals((byte) 20, actualGenerarZipDesdeTareasResult[4]);
        assertEquals((byte) 3, actualGenerarZipDesdeTareasResult[2]);
        assertEquals((byte) 4, actualGenerarZipDesdeTareasResult[3]);
        assertEquals((byte) 5, actualGenerarZipDesdeTareasResult[116]);
        assertEquals((byte) 6, actualGenerarZipDesdeTareasResult[117]);
        assertEquals('/', actualGenerarZipDesdeTareasResult[113]);
        assertEquals('8', actualGenerarZipDesdeTareasResult[126]);
        assertEquals(':', actualGenerarZipDesdeTareasResult[130]);
        assertEquals('K', actualGenerarZipDesdeTareasResult[1]);
        assertEquals('K', actualGenerarZipDesdeTareasResult[115]);
        assertEquals('P', actualGenerarZipDesdeTareasResult[0]);
        assertEquals('P', actualGenerarZipDesdeTareasResult[114]);
        assertEquals('W', actualGenerarZipDesdeTareasResult[13]);
        assertEquals('\b', actualGenerarZipDesdeTareasResult[6]);
        assertEquals('\b', actualGenerarZipDesdeTareasResult[7]);
        assertEquals('\b', actualGenerarZipDesdeTareasResult[8]);
        assertEquals('a', actualGenerarZipDesdeTareasResult[112]);
        assertEquals('v', actualGenerarZipDesdeTareasResult[111]);
    }

    /**
     * Method under test: {@link ZipUtil#generarZipDesdeTareas(List)}
     */
    @Test
    void testGenerarZipDesdeTareas3() throws Exception {
        ZipUtil zipUtil = new ZipUtil();

        Tarea tarea = new Tarea();
        tarea.setArguments("test/java/");
        tarea.setByteArrayCompressed("AXAXAXAX".getBytes("UTF-8"));
        tarea.setChildren(new ArrayList<>());
        tarea.setClassName("test/java/");
        tarea.setContents("Not all who wander are lost");
        tarea.setCoverage(true);
        tarea.setFolderName("test/java/");
        tarea.setImports(new ArrayList<>());
        tarea.setLevel("test/java/");
        tarea.setMemberDeclarations(new ArrayList<>());
        tarea.setMethodName("test/java/");
        tarea.setName("test/java/");
        tarea.setNumDependencies(3);
        tarea.setNumLines(2);
        tarea.setPackageName("java.text");
        tarea.setReturnType("test/java/");
        tarea.setSourceScanned("test/java/");
        tarea.setTest("test/java/");

        Tarea tarea2 = new Tarea();
        tarea2.setArguments(Tarea.TIPO_TESTCLASS);
        tarea2.setByteArrayCompressed("AXAXAXAX".getBytes("UTF-8"));
        tarea2.setChildren(new ArrayList<>());
        tarea2.setClassName(Tarea.TIPO_TESTCLASS);
        tarea2.setContents("test/java/");
        tarea2.setCoverage(false);
        tarea2.setFolderName(Tarea.TIPO_TESTCLASS);
        tarea2.setImports(new ArrayList<>());
        tarea2.setLevel(Tarea.TIPO_TESTCLASS);
        tarea2.setMemberDeclarations(new ArrayList<>());
        tarea2.setMethodName(Tarea.TIPO_TESTCLASS);
        tarea2.setName(Tarea.TIPO_TESTCLASS);
        tarea2.setNumDependencies(10);
        tarea2.setNumLines(10);
        tarea2.setPackageName("test/java/");
        tarea2.setReturnType(Tarea.TIPO_TESTCLASS);
        tarea2.setSourceScanned(Tarea.TIPO_TESTCLASS);
        tarea2.setTest(Tarea.TIPO_TESTCLASS);

        ArrayList<Tarea> tareas = new ArrayList<>();
        tareas.add(tarea2);
        tareas.add(tarea);
        byte[] actualGenerarZipDesdeTareasResult = zipUtil.generarZipDesdeTareas(tareas);
        assertEquals((byte) -117, actualGenerarZipDesdeTareasResult[280]);
        assertEquals((byte) -47, actualGenerarZipDesdeTareasResult[10]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[14]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[15]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[17]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[18]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[19]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[20]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[21]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[22]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[23]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[24]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[268]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[269]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[270]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[271]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[273]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[275]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[277]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[278]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[279]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[281]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[282]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[283]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[284]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[285]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[5]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[9]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[Short.SIZE]);
        assertEquals((byte) 20, actualGenerarZipDesdeTareasResult[4]);
        assertEquals(286, actualGenerarZipDesdeTareasResult.length);
        assertEquals((byte) 2, actualGenerarZipDesdeTareasResult[272]);
        assertEquals((byte) 2, actualGenerarZipDesdeTareasResult[274]);
        assertEquals((byte) 3, actualGenerarZipDesdeTareasResult[2]);
        assertEquals((byte) 4, actualGenerarZipDesdeTareasResult[3]);
        assertEquals((byte) 5, actualGenerarZipDesdeTareasResult[266]);
        assertEquals((byte) 6, actualGenerarZipDesdeTareasResult[267]);
        assertEquals('K', actualGenerarZipDesdeTareasResult[1]);
        assertEquals('K', actualGenerarZipDesdeTareasResult[265]);
        assertEquals('P', actualGenerarZipDesdeTareasResult[0]);
        assertEquals('P', actualGenerarZipDesdeTareasResult[264]);
        assertEquals('W', actualGenerarZipDesdeTareasResult[13]);
        assertEquals('\b', actualGenerarZipDesdeTareasResult[6]);
        assertEquals('\b', actualGenerarZipDesdeTareasResult[7]);
        assertEquals('\b', actualGenerarZipDesdeTareasResult[8]);
        assertEquals('e', actualGenerarZipDesdeTareasResult[261]);
        assertEquals('s', actualGenerarZipDesdeTareasResult[262]);
        assertEquals('t', actualGenerarZipDesdeTareasResult[263]);
        assertEquals('}', actualGenerarZipDesdeTareasResult[276]);
    }

    /**
     * Method under test: {@link ZipUtil#generarZipDesdeTareas(List)}
     */
    @Test
    void testGenerarZipDesdeTareas4() throws Exception {
        ZipUtil zipUtil = new ZipUtil();

        Tarea tarea = new Tarea();
        tarea.setArguments("test/java/");
        tarea.setByteArrayCompressed("AXAXAXAX".getBytes("UTF-8"));
        tarea.setChildren(new ArrayList<>());
        tarea.setClassName("test/java/");
        tarea.setContents("Not all who wander are lost");
        tarea.setCoverage(true);
        tarea.setFolderName("test/java/");
        tarea.setImports(new ArrayList<>());
        tarea.setLevel(Tarea.TIPO_PACKAGE);
        tarea.setMemberDeclarations(new ArrayList<>());
        tarea.setMethodName("test/java/");
        tarea.setName("test/java/");
        tarea.setNumDependencies(3);
        tarea.setNumLines(2);
        tarea.setPackageName("java.text");
        tarea.setReturnType("test/java/");
        tarea.setSourceScanned("test/java/");
        tarea.setTest("test/java/");

        ArrayList<Tarea> tareas = new ArrayList<>();
        tareas.add(tarea);
        byte[] actualGenerarZipDesdeTareasResult = zipUtil.generarZipDesdeTareas(tareas);
        assertEquals((byte) -47, actualGenerarZipDesdeTareasResult[10]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[118]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[119]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[120]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[121]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[123]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[125]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[128]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[129]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[131]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[132]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[133]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[134]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[135]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[14]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[15]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[17]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[18]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[19]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[20]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[21]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[22]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[23]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[24]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[5]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[9]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[Float.MAX_EXPONENT]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[Short.SIZE]);
        assertEquals(136, actualGenerarZipDesdeTareasResult.length);
        assertEquals((byte) 1, actualGenerarZipDesdeTareasResult[122]);
        assertEquals((byte) 1, actualGenerarZipDesdeTareasResult[124]);
        assertEquals((byte) 20, actualGenerarZipDesdeTareasResult[4]);
        assertEquals((byte) 3, actualGenerarZipDesdeTareasResult[2]);
        assertEquals((byte) 4, actualGenerarZipDesdeTareasResult[3]);
        assertEquals((byte) 5, actualGenerarZipDesdeTareasResult[116]);
        assertEquals((byte) 6, actualGenerarZipDesdeTareasResult[117]);
        assertEquals('/', actualGenerarZipDesdeTareasResult[113]);
        assertEquals('8', actualGenerarZipDesdeTareasResult[126]);
        assertEquals(':', actualGenerarZipDesdeTareasResult[130]);
        assertEquals('K', actualGenerarZipDesdeTareasResult[1]);
        assertEquals('K', actualGenerarZipDesdeTareasResult[115]);
        assertEquals('P', actualGenerarZipDesdeTareasResult[0]);
        assertEquals('P', actualGenerarZipDesdeTareasResult[114]);
        assertEquals('W', actualGenerarZipDesdeTareasResult[13]);
        assertEquals('\b', actualGenerarZipDesdeTareasResult[6]);
        assertEquals('\b', actualGenerarZipDesdeTareasResult[7]);
        assertEquals('\b', actualGenerarZipDesdeTareasResult[8]);
        assertEquals('a', actualGenerarZipDesdeTareasResult[112]);
        assertEquals('v', actualGenerarZipDesdeTareasResult[111]);
    }

    /**
     * Method under test: {@link ZipUtil#generarZipDesdeTareas(List)}
     */
    @Test
    void testGenerarZipDesdeTareas5() throws Exception {
        ZipUtil zipUtil = new ZipUtil();

        Tarea tarea = new Tarea();
        tarea.setArguments("test/java/");
        tarea.setByteArrayCompressed("AXAXAXAX".getBytes("UTF-8"));
        tarea.setChildren(new ArrayList<>());
        tarea.setClassName("test/java/");
        tarea.setContents("Not all who wander are lost");
        tarea.setCoverage(true);
        tarea.setFolderName("test/java/");
        tarea.setImports(new ArrayList<>());
        tarea.setLevel(Tarea.TIPO_FOLDER);
        tarea.setMemberDeclarations(new ArrayList<>());
        tarea.setMethodName("test/java/");
        tarea.setName("test/java/");
        tarea.setNumDependencies(3);
        tarea.setNumLines(2);
        tarea.setPackageName("java.text");
        tarea.setReturnType("test/java/");
        tarea.setSourceScanned("test/java/");
        tarea.setTest("test/java/");

        ArrayList<Tarea> tareas = new ArrayList<>();
        tareas.add(tarea);
        byte[] actualGenerarZipDesdeTareasResult = zipUtil.generarZipDesdeTareas(tareas);
        assertEquals((byte) -47, actualGenerarZipDesdeTareasResult[10]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[118]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[119]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[120]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[121]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[123]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[125]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[128]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[129]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[131]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[132]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[133]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[134]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[135]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[14]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[15]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[17]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[18]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[19]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[20]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[21]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[22]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[23]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[24]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[5]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[9]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[Float.MAX_EXPONENT]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[Short.SIZE]);
        assertEquals(136, actualGenerarZipDesdeTareasResult.length);
        assertEquals((byte) 1, actualGenerarZipDesdeTareasResult[122]);
        assertEquals((byte) 1, actualGenerarZipDesdeTareasResult[124]);
        assertEquals((byte) 20, actualGenerarZipDesdeTareasResult[4]);
        assertEquals((byte) 3, actualGenerarZipDesdeTareasResult[2]);
        assertEquals((byte) 4, actualGenerarZipDesdeTareasResult[3]);
        assertEquals((byte) 5, actualGenerarZipDesdeTareasResult[116]);
        assertEquals((byte) 6, actualGenerarZipDesdeTareasResult[117]);
        assertEquals('/', actualGenerarZipDesdeTareasResult[113]);
        assertEquals('8', actualGenerarZipDesdeTareasResult[126]);
        assertEquals(':', actualGenerarZipDesdeTareasResult[130]);
        assertEquals('K', actualGenerarZipDesdeTareasResult[1]);
        assertEquals('K', actualGenerarZipDesdeTareasResult[115]);
        assertEquals('P', actualGenerarZipDesdeTareasResult[0]);
        assertEquals('P', actualGenerarZipDesdeTareasResult[114]);
        assertEquals('W', actualGenerarZipDesdeTareasResult[13]);
        assertEquals('\b', actualGenerarZipDesdeTareasResult[6]);
        assertEquals('\b', actualGenerarZipDesdeTareasResult[7]);
        assertEquals('\b', actualGenerarZipDesdeTareasResult[8]);
        assertEquals('a', actualGenerarZipDesdeTareasResult[112]);
        assertEquals('v', actualGenerarZipDesdeTareasResult[111]);
    }

    /**
     * Method under test: {@link ZipUtil#generarZipDesdeTareas(List)}
     */
    @Test
    void testGenerarZipDesdeTareas6() throws Exception {
        ZipUtil zipUtil = new ZipUtil();

        Tarea tarea = new Tarea();
        tarea.setArguments("test/java/");
        tarea.setByteArrayCompressed("AXAXAXAX".getBytes("UTF-8"));
        tarea.setChildren(new ArrayList<>());
        tarea.setClassName("test/java/");
        tarea.setContents("Not all who wander are lost");
        tarea.setCoverage(true);
        tarea.setFolderName("test/java/");
        tarea.setImports(new ArrayList<>());
        tarea.setLevel("test/java/");
        tarea.setMemberDeclarations(new ArrayList<>());
        tarea.setMethodName("test/java/");
        tarea.setName("test/java/");
        tarea.setNumDependencies(3);
        tarea.setNumLines(2);
        tarea.setPackageName("java.text");
        tarea.setReturnType("test/java/");
        tarea.setSourceScanned("test/java/");
        tarea.setTest("test/java/");

        Tarea tarea2 = new Tarea();
        tarea2.setArguments(Tarea.TIPO_TESTCLASS);
        tarea2.setByteArrayCompressed("AXAXAXAX".getBytes("UTF-8"));
        tarea2.setChildren(new ArrayList<>());
        tarea2.setClassName(Tarea.TIPO_TESTCLASS);
        tarea2.setContents("test/java/");
        tarea2.setCoverage(false);
        tarea2.setFolderName(Tarea.TIPO_TESTCLASS);
        tarea2.setImports(new ArrayList<>());
        tarea2.setLevel(Tarea.TIPO_TESTCLASS);
        tarea2.setMemberDeclarations(new ArrayList<>());
        tarea2.setMethodName(Tarea.TIPO_TESTCLASS);
        tarea2.setName(Tarea.TIPO_TESTCLASS);
        tarea2.setNumDependencies(10);
        tarea2.setNumLines(10);
        tarea2.setPackageName("test/java/");
        tarea2.setReturnType(Tarea.TIPO_TESTCLASS);
        tarea2.setSourceScanned(Tarea.TIPO_TESTCLASS);
        tarea2.setTest("");

        ArrayList<Tarea> tareas = new ArrayList<>();
        tareas.add(tarea2);
        tareas.add(tarea);
        byte[] actualGenerarZipDesdeTareasResult = zipUtil.generarZipDesdeTareas(tareas);
        assertEquals((byte) -47, actualGenerarZipDesdeTareasResult[10]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[118]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[119]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[120]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[121]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[123]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[125]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[128]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[129]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[131]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[132]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[133]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[134]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[135]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[14]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[15]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[17]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[18]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[19]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[20]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[21]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[22]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[23]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[24]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[5]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[9]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[Float.MAX_EXPONENT]);
        assertEquals((byte) 0, actualGenerarZipDesdeTareasResult[Short.SIZE]);
        assertEquals(136, actualGenerarZipDesdeTareasResult.length);
        assertEquals((byte) 1, actualGenerarZipDesdeTareasResult[122]);
        assertEquals((byte) 1, actualGenerarZipDesdeTareasResult[124]);
        assertEquals((byte) 20, actualGenerarZipDesdeTareasResult[4]);
        assertEquals((byte) 3, actualGenerarZipDesdeTareasResult[2]);
        assertEquals((byte) 4, actualGenerarZipDesdeTareasResult[3]);
        assertEquals((byte) 5, actualGenerarZipDesdeTareasResult[116]);
        assertEquals((byte) 6, actualGenerarZipDesdeTareasResult[117]);
        assertEquals('/', actualGenerarZipDesdeTareasResult[113]);
        assertEquals('8', actualGenerarZipDesdeTareasResult[126]);
        assertEquals(':', actualGenerarZipDesdeTareasResult[130]);
        assertEquals('K', actualGenerarZipDesdeTareasResult[1]);
        assertEquals('K', actualGenerarZipDesdeTareasResult[115]);
        assertEquals('P', actualGenerarZipDesdeTareasResult[0]);
        assertEquals('P', actualGenerarZipDesdeTareasResult[114]);
        assertEquals('W', actualGenerarZipDesdeTareasResult[13]);
        assertEquals('\b', actualGenerarZipDesdeTareasResult[6]);
        assertEquals('\b', actualGenerarZipDesdeTareasResult[7]);
        assertEquals('\b', actualGenerarZipDesdeTareasResult[8]);
        assertEquals('a', actualGenerarZipDesdeTareasResult[112]);
        assertEquals('v', actualGenerarZipDesdeTareasResult[111]);
    }
}
