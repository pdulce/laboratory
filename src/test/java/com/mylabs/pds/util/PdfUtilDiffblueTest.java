package com.mylabs.pds.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.itextpdf.text.DocumentException;
import com.mylabs.pds.model.GitScanerInfo;
import com.mylabs.pds.model.Tarea;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class PdfUtilDiffblueTest {
    /**
     * Method under test:
     * {@link PdfUtil#getJavaMethodsCoverageReport(List, GitScanerInfo)}
     */
    @Test
    void testGetJavaMethodsCoverageReport() throws DocumentException, UnsupportedEncodingException {
        ArrayList<Tarea> metodos = new ArrayList<>();

        Tarea publicMethodsRoot = new Tarea();
        publicMethodsRoot.setArguments("Arguments");
        publicMethodsRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        publicMethodsRoot.setChildren(new ArrayList<>());
        publicMethodsRoot.setClassName("Class Name");
        publicMethodsRoot.setContents("Not all who wander are lost");
        publicMethodsRoot.setCoverage(true);
        publicMethodsRoot.setFolderName("Folder Name");
        publicMethodsRoot.setId(1L);
        publicMethodsRoot.setLevel("Level");
        publicMethodsRoot.setMethodName("Method Name");
        publicMethodsRoot.setNumDependencies(3);
        publicMethodsRoot.setNumLines(2);
        publicMethodsRoot.setPackageName("java.text");
        publicMethodsRoot.setParentId(1L);
        publicMethodsRoot.setQName("Q Name");
        publicMethodsRoot.setSourceScanned("Source Scanned");
        publicMethodsRoot.setTest("Test");
        publicMethodsRoot.setTestName("Test Name");
        publicMethodsRoot.setType("Type");

        Tarea testClassesRoot = new Tarea();
        testClassesRoot.setArguments("Arguments");
        testClassesRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        testClassesRoot.setChildren(new ArrayList<>());
        testClassesRoot.setClassName("Class Name");
        testClassesRoot.setContents("Not all who wander are lost");
        testClassesRoot.setCoverage(true);
        testClassesRoot.setFolderName("Folder Name");
        testClassesRoot.setId(1L);
        testClassesRoot.setLevel("Level");
        testClassesRoot.setMethodName("Method Name");
        testClassesRoot.setNumDependencies(3);
        testClassesRoot.setNumLines(2);
        testClassesRoot.setPackageName("java.text");
        testClassesRoot.setParentId(1L);
        testClassesRoot.setQName("Q Name");
        testClassesRoot.setSourceScanned("Source Scanned");
        testClassesRoot.setTest("Test");
        testClassesRoot.setTestName("Test Name");
        testClassesRoot.setType("Type");

        GitScanerInfo gitScanerInfo = new GitScanerInfo();
        gitScanerInfo.setClassNamePattern("Class Name Pattern");
        gitScanerInfo.setGitLabPath("Git Lab Path");
        gitScanerInfo.setPackageNamePattern("java.text");
        gitScanerInfo.setPublicMethodsRoot(publicMethodsRoot);
        gitScanerInfo.setRelease("1.0.2");
        gitScanerInfo.setTestClassesRoot(testClassesRoot);
        byte[] actualJavaMethodsCoverageReport = PdfUtil.getJavaMethodsCoverageReport(metodos, gitScanerInfo);
        assertEquals((byte) -29, actualJavaMethodsCoverageReport[11]);
        assertEquals((byte) -30, actualJavaMethodsCoverageReport[10]);
        assertEquals((byte) -45, actualJavaMethodsCoverageReport[13]);
        assertEquals((byte) -49, actualJavaMethodsCoverageReport[12]);
        assertEquals(' ', actualJavaMethodsCoverageReport[18]);
        assertEquals(' ', actualJavaMethodsCoverageReport[Short.SIZE]);
        assertEquals('%', actualJavaMethodsCoverageReport[0]);
        assertEquals('%', actualJavaMethodsCoverageReport[9]);
        assertEquals('-', actualJavaMethodsCoverageReport[4]);
        assertEquals('.', actualJavaMethodsCoverageReport[6]);
        assertEquals('0', actualJavaMethodsCoverageReport[17]);
        assertEquals('1', actualJavaMethodsCoverageReport[5]);
        assertEquals('3', actualJavaMethodsCoverageReport[15]);
        assertEquals('5', actualJavaMethodsCoverageReport[7]);
        assertEquals('<', actualJavaMethodsCoverageReport[23]);
        assertEquals('<', actualJavaMethodsCoverageReport[24]);
        assertEquals('D', actualJavaMethodsCoverageReport[2]);
        assertEquals('F', actualJavaMethodsCoverageReport[3]);
        assertEquals('P', actualJavaMethodsCoverageReport[1]);
        assertEquals('\n', actualJavaMethodsCoverageReport[14]);
        assertEquals('\n', actualJavaMethodsCoverageReport[22]);
        assertEquals('\n', actualJavaMethodsCoverageReport[8]);
        assertEquals('b', actualJavaMethodsCoverageReport[20]);
        assertEquals('j', actualJavaMethodsCoverageReport[21]);
        assertEquals('o', actualJavaMethodsCoverageReport[19]);
        assertEquals('t', actualJavaMethodsCoverageReport[1477]);
    }

    /**
     * Method under test:
     * {@link PdfUtil#getJavaMethodsCoverageReport(List, GitScanerInfo)}
     */
    @Test
    void testGetJavaMethodsCoverageReport2() throws DocumentException, UnsupportedEncodingException {
        Tarea tarea = new Tarea();
        tarea.setArguments("\t");
        tarea.setArrayOfBytes("A5A5A5A5".getBytes("UTF-8"));
        tarea.setChildren(new ArrayList<>());
        tarea.setClassName("\t");
        tarea.setContents("Not all who wander are lost");
        tarea.setCoverage(true);
        tarea.setFolderName("\t");
        tarea.setId(1L);
        tarea.setLevel("\t");
        tarea.setMethodName("\t");
        tarea.setNumDependencies(3);
        tarea.setNumLines(2);
        tarea.setPackageName("java.text");
        tarea.setParentId(1L);
        tarea.setQName("\t");
        tarea.setSourceScanned("\t");
        tarea.setTest("\t");
        tarea.setTestName("\t");
        tarea.setType("\t");

        ArrayList<Tarea> metodos = new ArrayList<>();
        metodos.add(tarea);

        Tarea publicMethodsRoot = new Tarea();
        publicMethodsRoot.setArguments("Arguments");
        publicMethodsRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        publicMethodsRoot.setChildren(new ArrayList<>());
        publicMethodsRoot.setClassName("Class Name");
        publicMethodsRoot.setContents("Not all who wander are lost");
        publicMethodsRoot.setCoverage(true);
        publicMethodsRoot.setFolderName("Folder Name");
        publicMethodsRoot.setId(1L);
        publicMethodsRoot.setLevel("Level");
        publicMethodsRoot.setMethodName("Method Name");
        publicMethodsRoot.setNumDependencies(3);
        publicMethodsRoot.setNumLines(2);
        publicMethodsRoot.setPackageName("java.text");
        publicMethodsRoot.setParentId(1L);
        publicMethodsRoot.setQName("Q Name");
        publicMethodsRoot.setSourceScanned("Source Scanned");
        publicMethodsRoot.setTest("Test");
        publicMethodsRoot.setTestName("Test Name");
        publicMethodsRoot.setType("Type");

        Tarea testClassesRoot = new Tarea();
        testClassesRoot.setArguments("Arguments");
        testClassesRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        testClassesRoot.setChildren(new ArrayList<>());
        testClassesRoot.setClassName("Class Name");
        testClassesRoot.setContents("Not all who wander are lost");
        testClassesRoot.setCoverage(true);
        testClassesRoot.setFolderName("Folder Name");
        testClassesRoot.setId(1L);
        testClassesRoot.setLevel("Level");
        testClassesRoot.setMethodName("Method Name");
        testClassesRoot.setNumDependencies(3);
        testClassesRoot.setNumLines(2);
        testClassesRoot.setPackageName("java.text");
        testClassesRoot.setParentId(1L);
        testClassesRoot.setQName("Q Name");
        testClassesRoot.setSourceScanned("Source Scanned");
        testClassesRoot.setTest("Test");
        testClassesRoot.setTestName("Test Name");
        testClassesRoot.setType("Type");

        GitScanerInfo gitScanerInfo = new GitScanerInfo();
        gitScanerInfo.setClassNamePattern("Class Name Pattern");
        gitScanerInfo.setGitLabPath("Git Lab Path");
        gitScanerInfo.setPackageNamePattern("java.text");
        gitScanerInfo.setPublicMethodsRoot(publicMethodsRoot);
        gitScanerInfo.setRelease("1.0.2");
        gitScanerInfo.setTestClassesRoot(testClassesRoot);
        byte[] actualJavaMethodsCoverageReport = PdfUtil.getJavaMethodsCoverageReport(metodos, gitScanerInfo);
        assertEquals((byte) -29, actualJavaMethodsCoverageReport[11]);
        assertEquals((byte) -30, actualJavaMethodsCoverageReport[10]);
        assertEquals((byte) -45, actualJavaMethodsCoverageReport[13]);
        assertEquals((byte) -49, actualJavaMethodsCoverageReport[12]);
        assertEquals(' ', actualJavaMethodsCoverageReport[18]);
        assertEquals(' ', actualJavaMethodsCoverageReport[Short.SIZE]);
        assertEquals('%', actualJavaMethodsCoverageReport[0]);
        assertEquals('%', actualJavaMethodsCoverageReport[9]);
        assertEquals('-', actualJavaMethodsCoverageReport[4]);
        assertEquals('.', actualJavaMethodsCoverageReport[6]);
        assertEquals('0', actualJavaMethodsCoverageReport[17]);
        assertEquals('1', actualJavaMethodsCoverageReport[5]);
        assertEquals('3', actualJavaMethodsCoverageReport[15]);
        assertEquals('5', actualJavaMethodsCoverageReport[7]);
        assertEquals('<', actualJavaMethodsCoverageReport[23]);
        assertEquals('<', actualJavaMethodsCoverageReport[24]);
        assertEquals('D', actualJavaMethodsCoverageReport[2]);
        assertEquals('F', actualJavaMethodsCoverageReport[3]);
        assertEquals('P', actualJavaMethodsCoverageReport[1]);
        assertEquals('\n', actualJavaMethodsCoverageReport[14]);
        assertEquals('\n', actualJavaMethodsCoverageReport[22]);
        assertEquals('\n', actualJavaMethodsCoverageReport[8]);
        assertEquals('b', actualJavaMethodsCoverageReport[20]);
        assertEquals('j', actualJavaMethodsCoverageReport[21]);
        assertEquals('o', actualJavaMethodsCoverageReport[19]);
        assertEquals('t', actualJavaMethodsCoverageReport[1561]);
    }

    /**
     * Method under test:
     * {@link PdfUtil#getJavaMethodsCoverageReport(List, GitScanerInfo)}
     */
    @Test
    void testGetJavaMethodsCoverageReport3() throws DocumentException, UnsupportedEncodingException {
        Tarea tarea = new Tarea();
        tarea.setArguments("\t");
        tarea.setArrayOfBytes("A5A5A5A5".getBytes("UTF-8"));
        tarea.setChildren(new ArrayList<>());
        tarea.setClassName("\t");
        tarea.setContents("Not all who wander are lost");
        tarea.setCoverage(true);
        tarea.setFolderName("\t");
        tarea.setId(1L);
        tarea.setLevel("\t");
        tarea.setMethodName("\t");
        tarea.setNumDependencies(3);
        tarea.setNumLines(2);
        tarea.setPackageName("java.text");
        tarea.setParentId(1L);
        tarea.setQName("\t");
        tarea.setSourceScanned("\t");
        tarea.setTest("\t");
        tarea.setTestName("\t");
        tarea.setType("\t");

        Tarea tarea2 = new Tarea();
        tarea2.setArguments("             ");
        tarea2.setArrayOfBytes("A5A5A5A5".getBytes("UTF-8"));
        tarea2.setChildren(new ArrayList<>());
        tarea2.setClassName("             ");
        tarea2.setContents("\t");
        tarea2.setCoverage(false);
        tarea2.setFolderName("             ");
        tarea2.setId(2L);
        tarea2.setLevel("             ");
        tarea2.setMethodName("             ");
        tarea2.setNumDependencies(10);
        tarea2.setNumLines(10);
        tarea2.setPackageName("\t");
        tarea2.setParentId(2L);
        tarea2.setQName("             ");
        tarea2.setSourceScanned("             ");
        tarea2.setTest("             ");
        tarea2.setTestName("             ");
        tarea2.setType("             ");

        ArrayList<Tarea> metodos = new ArrayList<>();
        metodos.add(tarea2);
        metodos.add(tarea);

        Tarea publicMethodsRoot = new Tarea();
        publicMethodsRoot.setArguments("Arguments");
        publicMethodsRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        publicMethodsRoot.setChildren(new ArrayList<>());
        publicMethodsRoot.setClassName("Class Name");
        publicMethodsRoot.setContents("Not all who wander are lost");
        publicMethodsRoot.setCoverage(true);
        publicMethodsRoot.setFolderName("Folder Name");
        publicMethodsRoot.setId(1L);
        publicMethodsRoot.setLevel("Level");
        publicMethodsRoot.setMethodName("Method Name");
        publicMethodsRoot.setNumDependencies(3);
        publicMethodsRoot.setNumLines(2);
        publicMethodsRoot.setPackageName("java.text");
        publicMethodsRoot.setParentId(1L);
        publicMethodsRoot.setQName("Q Name");
        publicMethodsRoot.setSourceScanned("Source Scanned");
        publicMethodsRoot.setTest("Test");
        publicMethodsRoot.setTestName("Test Name");
        publicMethodsRoot.setType("Type");

        Tarea testClassesRoot = new Tarea();
        testClassesRoot.setArguments("Arguments");
        testClassesRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        testClassesRoot.setChildren(new ArrayList<>());
        testClassesRoot.setClassName("Class Name");
        testClassesRoot.setContents("Not all who wander are lost");
        testClassesRoot.setCoverage(true);
        testClassesRoot.setFolderName("Folder Name");
        testClassesRoot.setId(1L);
        testClassesRoot.setLevel("Level");
        testClassesRoot.setMethodName("Method Name");
        testClassesRoot.setNumDependencies(3);
        testClassesRoot.setNumLines(2);
        testClassesRoot.setPackageName("java.text");
        testClassesRoot.setParentId(1L);
        testClassesRoot.setQName("Q Name");
        testClassesRoot.setSourceScanned("Source Scanned");
        testClassesRoot.setTest("Test");
        testClassesRoot.setTestName("Test Name");
        testClassesRoot.setType("Type");

        GitScanerInfo gitScanerInfo = new GitScanerInfo();
        gitScanerInfo.setClassNamePattern("Class Name Pattern");
        gitScanerInfo.setGitLabPath("Git Lab Path");
        gitScanerInfo.setPackageNamePattern("java.text");
        gitScanerInfo.setPublicMethodsRoot(publicMethodsRoot);
        gitScanerInfo.setRelease("1.0.2");
        gitScanerInfo.setTestClassesRoot(testClassesRoot);
        byte[] actualJavaMethodsCoverageReport = PdfUtil.getJavaMethodsCoverageReport(metodos, gitScanerInfo);
        assertEquals((byte) -29, actualJavaMethodsCoverageReport[11]);
        assertEquals((byte) -30, actualJavaMethodsCoverageReport[10]);
        assertEquals((byte) -45, actualJavaMethodsCoverageReport[13]);
        assertEquals((byte) -49, actualJavaMethodsCoverageReport[12]);
        assertEquals(' ', actualJavaMethodsCoverageReport[18]);
        assertEquals(' ', actualJavaMethodsCoverageReport[Short.SIZE]);
        assertEquals('%', actualJavaMethodsCoverageReport[0]);
        assertEquals('%', actualJavaMethodsCoverageReport[9]);
        assertEquals('-', actualJavaMethodsCoverageReport[4]);
        assertEquals('.', actualJavaMethodsCoverageReport[6]);
        assertEquals('0', actualJavaMethodsCoverageReport[17]);
        assertEquals('1', actualJavaMethodsCoverageReport[5]);
        assertEquals('3', actualJavaMethodsCoverageReport[15]);
        assertEquals('5', actualJavaMethodsCoverageReport[7]);
        assertEquals('<', actualJavaMethodsCoverageReport[23]);
        assertEquals('<', actualJavaMethodsCoverageReport[24]);
        assertEquals('D', actualJavaMethodsCoverageReport[2]);
        assertEquals('F', actualJavaMethodsCoverageReport[3]);
        assertEquals('P', actualJavaMethodsCoverageReport[1]);
        assertEquals('\n', actualJavaMethodsCoverageReport[14]);
        assertEquals('\n', actualJavaMethodsCoverageReport[22]);
        assertEquals('\n', actualJavaMethodsCoverageReport[8]);
        assertEquals('b', actualJavaMethodsCoverageReport[20]);
        assertEquals('j', actualJavaMethodsCoverageReport[21]);
        assertEquals('o', actualJavaMethodsCoverageReport[19]);
        assertEquals('t', actualJavaMethodsCoverageReport[1607]);
    }

    /**
     * Method under test:
     * {@link PdfUtil#getJavaMethodsCoverageReport(List, GitScanerInfo)}
     */
    @Test
    void testGetJavaMethodsCoverageReport4() throws DocumentException, UnsupportedEncodingException {
        Tarea tarea = new Tarea();
        tarea.setArguments("             ");
        tarea.setArrayOfBytes("A5A5A5A5".getBytes("UTF-8"));
        tarea.setChildren(new ArrayList<>());
        tarea.setClassName("\t");
        tarea.setContents("Not all who wander are lost");
        tarea.setCoverage(true);
        tarea.setFolderName("\t");
        tarea.setId(1L);
        tarea.setLevel("\t");
        tarea.setMethodName("\t");
        tarea.setNumDependencies(3);
        tarea.setNumLines(2);
        tarea.setPackageName("java.text");
        tarea.setParentId(1L);
        tarea.setQName("\t");
        tarea.setSourceScanned("\t");
        tarea.setTest("\t");
        tarea.setTestName("\t");
        tarea.setType("\t");

        ArrayList<Tarea> metodos = new ArrayList<>();
        metodos.add(tarea);

        Tarea publicMethodsRoot = new Tarea();
        publicMethodsRoot.setArguments("Arguments");
        publicMethodsRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        publicMethodsRoot.setChildren(new ArrayList<>());
        publicMethodsRoot.setClassName("Class Name");
        publicMethodsRoot.setContents("Not all who wander are lost");
        publicMethodsRoot.setCoverage(true);
        publicMethodsRoot.setFolderName("Folder Name");
        publicMethodsRoot.setId(1L);
        publicMethodsRoot.setLevel("Level");
        publicMethodsRoot.setMethodName("Method Name");
        publicMethodsRoot.setNumDependencies(3);
        publicMethodsRoot.setNumLines(2);
        publicMethodsRoot.setPackageName("java.text");
        publicMethodsRoot.setParentId(1L);
        publicMethodsRoot.setQName("Q Name");
        publicMethodsRoot.setSourceScanned("Source Scanned");
        publicMethodsRoot.setTest("Test");
        publicMethodsRoot.setTestName("Test Name");
        publicMethodsRoot.setType("Type");

        Tarea testClassesRoot = new Tarea();
        testClassesRoot.setArguments("Arguments");
        testClassesRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        testClassesRoot.setChildren(new ArrayList<>());
        testClassesRoot.setClassName("Class Name");
        testClassesRoot.setContents("Not all who wander are lost");
        testClassesRoot.setCoverage(true);
        testClassesRoot.setFolderName("Folder Name");
        testClassesRoot.setId(1L);
        testClassesRoot.setLevel("Level");
        testClassesRoot.setMethodName("Method Name");
        testClassesRoot.setNumDependencies(3);
        testClassesRoot.setNumLines(2);
        testClassesRoot.setPackageName("java.text");
        testClassesRoot.setParentId(1L);
        testClassesRoot.setQName("Q Name");
        testClassesRoot.setSourceScanned("Source Scanned");
        testClassesRoot.setTest("Test");
        testClassesRoot.setTestName("Test Name");
        testClassesRoot.setType("Type");

        GitScanerInfo gitScanerInfo = new GitScanerInfo();
        gitScanerInfo.setClassNamePattern("Class Name Pattern");
        gitScanerInfo.setGitLabPath("Git Lab Path");
        gitScanerInfo.setPackageNamePattern("java.text");
        gitScanerInfo.setPublicMethodsRoot(publicMethodsRoot);
        gitScanerInfo.setRelease("1.0.2");
        gitScanerInfo.setTestClassesRoot(testClassesRoot);
        byte[] actualJavaMethodsCoverageReport = PdfUtil.getJavaMethodsCoverageReport(metodos, gitScanerInfo);
        assertEquals((byte) -29, actualJavaMethodsCoverageReport[11]);
        assertEquals((byte) -30, actualJavaMethodsCoverageReport[10]);
        assertEquals((byte) -45, actualJavaMethodsCoverageReport[13]);
        assertEquals((byte) -49, actualJavaMethodsCoverageReport[12]);
        assertEquals(' ', actualJavaMethodsCoverageReport[18]);
        assertEquals(' ', actualJavaMethodsCoverageReport[Short.SIZE]);
        assertEquals('%', actualJavaMethodsCoverageReport[0]);
        assertEquals('%', actualJavaMethodsCoverageReport[9]);
        assertEquals('-', actualJavaMethodsCoverageReport[4]);
        assertEquals('.', actualJavaMethodsCoverageReport[6]);
        assertEquals('0', actualJavaMethodsCoverageReport[17]);
        assertEquals('1', actualJavaMethodsCoverageReport[5]);
        assertEquals('3', actualJavaMethodsCoverageReport[15]);
        assertEquals('5', actualJavaMethodsCoverageReport[7]);
        assertEquals('<', actualJavaMethodsCoverageReport[23]);
        assertEquals('<', actualJavaMethodsCoverageReport[24]);
        assertEquals('D', actualJavaMethodsCoverageReport[2]);
        assertEquals('F', actualJavaMethodsCoverageReport[3]);
        assertEquals('P', actualJavaMethodsCoverageReport[1]);
        assertEquals('\n', actualJavaMethodsCoverageReport[14]);
        assertEquals('\n', actualJavaMethodsCoverageReport[22]);
        assertEquals('\n', actualJavaMethodsCoverageReport[8]);
        assertEquals('b', actualJavaMethodsCoverageReport[20]);
        assertEquals('j', actualJavaMethodsCoverageReport[21]);
        assertEquals('o', actualJavaMethodsCoverageReport[19]);
        assertEquals('t', actualJavaMethodsCoverageReport[1562]);
    }

    /**
     * Method under test:
     * {@link PdfUtil#getJavaMethodsCoverageReport(List, GitScanerInfo)}
     */
    @Test
    void testGetJavaMethodsCoverageReport5() throws DocumentException, UnsupportedEncodingException {
        Tarea tarea = new Tarea();
        tarea.setArguments("               Panorámica de cobertura de unitarias");
        tarea.setArrayOfBytes("A5A5A5A5".getBytes("UTF-8"));
        tarea.setChildren(new ArrayList<>());
        tarea.setClassName("\t");
        tarea.setContents("Not all who wander are lost");
        tarea.setCoverage(true);
        tarea.setFolderName("\t");
        tarea.setId(1L);
        tarea.setLevel("\t");
        tarea.setMethodName("\t");
        tarea.setNumDependencies(3);
        tarea.setNumLines(2);
        tarea.setPackageName("java.text");
        tarea.setParentId(1L);
        tarea.setQName("\t");
        tarea.setSourceScanned("\t");
        tarea.setTest("\t");
        tarea.setTestName("\t");
        tarea.setType("\t");

        ArrayList<Tarea> metodos = new ArrayList<>();
        metodos.add(tarea);

        Tarea publicMethodsRoot = new Tarea();
        publicMethodsRoot.setArguments("Arguments");
        publicMethodsRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        publicMethodsRoot.setChildren(new ArrayList<>());
        publicMethodsRoot.setClassName("Class Name");
        publicMethodsRoot.setContents("Not all who wander are lost");
        publicMethodsRoot.setCoverage(true);
        publicMethodsRoot.setFolderName("Folder Name");
        publicMethodsRoot.setId(1L);
        publicMethodsRoot.setLevel("Level");
        publicMethodsRoot.setMethodName("Method Name");
        publicMethodsRoot.setNumDependencies(3);
        publicMethodsRoot.setNumLines(2);
        publicMethodsRoot.setPackageName("java.text");
        publicMethodsRoot.setParentId(1L);
        publicMethodsRoot.setQName("Q Name");
        publicMethodsRoot.setSourceScanned("Source Scanned");
        publicMethodsRoot.setTest("Test");
        publicMethodsRoot.setTestName("Test Name");
        publicMethodsRoot.setType("Type");

        Tarea testClassesRoot = new Tarea();
        testClassesRoot.setArguments("Arguments");
        testClassesRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        testClassesRoot.setChildren(new ArrayList<>());
        testClassesRoot.setClassName("Class Name");
        testClassesRoot.setContents("Not all who wander are lost");
        testClassesRoot.setCoverage(true);
        testClassesRoot.setFolderName("Folder Name");
        testClassesRoot.setId(1L);
        testClassesRoot.setLevel("Level");
        testClassesRoot.setMethodName("Method Name");
        testClassesRoot.setNumDependencies(3);
        testClassesRoot.setNumLines(2);
        testClassesRoot.setPackageName("java.text");
        testClassesRoot.setParentId(1L);
        testClassesRoot.setQName("Q Name");
        testClassesRoot.setSourceScanned("Source Scanned");
        testClassesRoot.setTest("Test");
        testClassesRoot.setTestName("Test Name");
        testClassesRoot.setType("Type");

        GitScanerInfo gitScanerInfo = new GitScanerInfo();
        gitScanerInfo.setClassNamePattern("Class Name Pattern");
        gitScanerInfo.setGitLabPath("Git Lab Path");
        gitScanerInfo.setPackageNamePattern("java.text");
        gitScanerInfo.setPublicMethodsRoot(publicMethodsRoot);
        gitScanerInfo.setRelease("1.0.2");
        gitScanerInfo.setTestClassesRoot(testClassesRoot);
        byte[] actualJavaMethodsCoverageReport = PdfUtil.getJavaMethodsCoverageReport(metodos, gitScanerInfo);
        assertEquals((byte) -29, actualJavaMethodsCoverageReport[11]);
        assertEquals((byte) -30, actualJavaMethodsCoverageReport[10]);
        assertEquals((byte) -45, actualJavaMethodsCoverageReport[13]);
        assertEquals((byte) -49, actualJavaMethodsCoverageReport[12]);
        assertEquals(' ', actualJavaMethodsCoverageReport[18]);
        assertEquals(' ', actualJavaMethodsCoverageReport[Short.SIZE]);
        assertEquals('%', actualJavaMethodsCoverageReport[0]);
        assertEquals('%', actualJavaMethodsCoverageReport[9]);
        assertEquals('-', actualJavaMethodsCoverageReport[4]);
        assertEquals('.', actualJavaMethodsCoverageReport[6]);
        assertEquals('0', actualJavaMethodsCoverageReport[17]);
        assertEquals('1', actualJavaMethodsCoverageReport[5]);
        assertEquals('3', actualJavaMethodsCoverageReport[15]);
        assertEquals('5', actualJavaMethodsCoverageReport[7]);
        assertEquals('<', actualJavaMethodsCoverageReport[23]);
        assertEquals('<', actualJavaMethodsCoverageReport[24]);
        assertEquals('D', actualJavaMethodsCoverageReport[2]);
        assertEquals('F', actualJavaMethodsCoverageReport[3]);
        assertEquals('P', actualJavaMethodsCoverageReport[1]);
        assertEquals('\n', actualJavaMethodsCoverageReport[14]);
        assertEquals('\n', actualJavaMethodsCoverageReport[22]);
        assertEquals('\n', actualJavaMethodsCoverageReport[8]);
        assertEquals('b', actualJavaMethodsCoverageReport[20]);
        assertEquals('j', actualJavaMethodsCoverageReport[21]);
        assertEquals('o', actualJavaMethodsCoverageReport[19]);
        assertEquals('t', actualJavaMethodsCoverageReport[1563]);
    }

    /**
     * Method under test:
     * {@link PdfUtil#getJavaMethodsCoverageReport(List, GitScanerInfo)}
     */
    @Test
    void testGetJavaMethodsCoverageReport6() throws DocumentException, UnsupportedEncodingException {
        Tarea tarea = new Tarea();
        tarea.setArguments("                    Package");
        tarea.setArrayOfBytes("A5A5A5A5".getBytes("UTF-8"));
        tarea.setChildren(new ArrayList<>());
        tarea.setClassName("\t");
        tarea.setContents("Not all who wander are lost");
        tarea.setCoverage(true);
        tarea.setFolderName("\t");
        tarea.setId(1L);
        tarea.setLevel("\t");
        tarea.setMethodName("\t");
        tarea.setNumDependencies(3);
        tarea.setNumLines(2);
        tarea.setPackageName("java.text");
        tarea.setParentId(1L);
        tarea.setQName("\t");
        tarea.setSourceScanned("\t");
        tarea.setTest("\t");
        tarea.setTestName("\t");
        tarea.setType("\t");

        ArrayList<Tarea> metodos = new ArrayList<>();
        metodos.add(tarea);

        Tarea publicMethodsRoot = new Tarea();
        publicMethodsRoot.setArguments("Arguments");
        publicMethodsRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        publicMethodsRoot.setChildren(new ArrayList<>());
        publicMethodsRoot.setClassName("Class Name");
        publicMethodsRoot.setContents("Not all who wander are lost");
        publicMethodsRoot.setCoverage(true);
        publicMethodsRoot.setFolderName("Folder Name");
        publicMethodsRoot.setId(1L);
        publicMethodsRoot.setLevel("Level");
        publicMethodsRoot.setMethodName("Method Name");
        publicMethodsRoot.setNumDependencies(3);
        publicMethodsRoot.setNumLines(2);
        publicMethodsRoot.setPackageName("java.text");
        publicMethodsRoot.setParentId(1L);
        publicMethodsRoot.setQName("Q Name");
        publicMethodsRoot.setSourceScanned("Source Scanned");
        publicMethodsRoot.setTest("Test");
        publicMethodsRoot.setTestName("Test Name");
        publicMethodsRoot.setType("Type");

        Tarea testClassesRoot = new Tarea();
        testClassesRoot.setArguments("Arguments");
        testClassesRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        testClassesRoot.setChildren(new ArrayList<>());
        testClassesRoot.setClassName("Class Name");
        testClassesRoot.setContents("Not all who wander are lost");
        testClassesRoot.setCoverage(true);
        testClassesRoot.setFolderName("Folder Name");
        testClassesRoot.setId(1L);
        testClassesRoot.setLevel("Level");
        testClassesRoot.setMethodName("Method Name");
        testClassesRoot.setNumDependencies(3);
        testClassesRoot.setNumLines(2);
        testClassesRoot.setPackageName("java.text");
        testClassesRoot.setParentId(1L);
        testClassesRoot.setQName("Q Name");
        testClassesRoot.setSourceScanned("Source Scanned");
        testClassesRoot.setTest("Test");
        testClassesRoot.setTestName("Test Name");
        testClassesRoot.setType("Type");

        GitScanerInfo gitScanerInfo = new GitScanerInfo();
        gitScanerInfo.setClassNamePattern("Class Name Pattern");
        gitScanerInfo.setGitLabPath("Git Lab Path");
        gitScanerInfo.setPackageNamePattern("java.text");
        gitScanerInfo.setPublicMethodsRoot(publicMethodsRoot);
        gitScanerInfo.setRelease("1.0.2");
        gitScanerInfo.setTestClassesRoot(testClassesRoot);
        byte[] actualJavaMethodsCoverageReport = PdfUtil.getJavaMethodsCoverageReport(metodos, gitScanerInfo);
        assertEquals((byte) -29, actualJavaMethodsCoverageReport[11]);
        assertEquals((byte) -30, actualJavaMethodsCoverageReport[10]);
        assertEquals((byte) -45, actualJavaMethodsCoverageReport[13]);
        assertEquals((byte) -49, actualJavaMethodsCoverageReport[12]);
        assertEquals(' ', actualJavaMethodsCoverageReport[18]);
        assertEquals(' ', actualJavaMethodsCoverageReport[Short.SIZE]);
        assertEquals('%', actualJavaMethodsCoverageReport[0]);
        assertEquals('%', actualJavaMethodsCoverageReport[9]);
        assertEquals('-', actualJavaMethodsCoverageReport[4]);
        assertEquals('.', actualJavaMethodsCoverageReport[6]);
        assertEquals('0', actualJavaMethodsCoverageReport[17]);
        assertEquals('1', actualJavaMethodsCoverageReport[5]);
        assertEquals('3', actualJavaMethodsCoverageReport[15]);
        assertEquals('5', actualJavaMethodsCoverageReport[7]);
        assertEquals('<', actualJavaMethodsCoverageReport[23]);
        assertEquals('<', actualJavaMethodsCoverageReport[24]);
        assertEquals('D', actualJavaMethodsCoverageReport[2]);
        assertEquals('F', actualJavaMethodsCoverageReport[3]);
        assertEquals('P', actualJavaMethodsCoverageReport[1]);
        assertEquals('\n', actualJavaMethodsCoverageReport[14]);
        assertEquals('\n', actualJavaMethodsCoverageReport[22]);
        assertEquals('\n', actualJavaMethodsCoverageReport[8]);
        assertEquals('b', actualJavaMethodsCoverageReport[20]);
        assertEquals('j', actualJavaMethodsCoverageReport[21]);
        assertEquals('o', actualJavaMethodsCoverageReport[19]);
        assertEquals('t', actualJavaMethodsCoverageReport[1562]);
    }

    /**
     * Method under test:
     * {@link PdfUtil#getJavaMethodsCoverageReport(List, GitScanerInfo)}
     */
    @Test
    void testGetJavaMethodsCoverageReport7() throws DocumentException, UnsupportedEncodingException {
        Tarea tarea = new Tarea();
        tarea.setArguments("                    Clase");
        tarea.setArrayOfBytes("A5A5A5A5".getBytes("UTF-8"));
        tarea.setChildren(new ArrayList<>());
        tarea.setClassName("\t");
        tarea.setContents("Not all who wander are lost");
        tarea.setCoverage(true);
        tarea.setFolderName("\t");
        tarea.setId(1L);
        tarea.setLevel("\t");
        tarea.setMethodName("\t");
        tarea.setNumDependencies(3);
        tarea.setNumLines(2);
        tarea.setPackageName("java.text");
        tarea.setParentId(1L);
        tarea.setQName("\t");
        tarea.setSourceScanned("\t");
        tarea.setTest("\t");
        tarea.setTestName("\t");
        tarea.setType("\t");

        ArrayList<Tarea> metodos = new ArrayList<>();
        metodos.add(tarea);

        Tarea publicMethodsRoot = new Tarea();
        publicMethodsRoot.setArguments("Arguments");
        publicMethodsRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        publicMethodsRoot.setChildren(new ArrayList<>());
        publicMethodsRoot.setClassName("Class Name");
        publicMethodsRoot.setContents("Not all who wander are lost");
        publicMethodsRoot.setCoverage(true);
        publicMethodsRoot.setFolderName("Folder Name");
        publicMethodsRoot.setId(1L);
        publicMethodsRoot.setLevel("Level");
        publicMethodsRoot.setMethodName("Method Name");
        publicMethodsRoot.setNumDependencies(3);
        publicMethodsRoot.setNumLines(2);
        publicMethodsRoot.setPackageName("java.text");
        publicMethodsRoot.setParentId(1L);
        publicMethodsRoot.setQName("Q Name");
        publicMethodsRoot.setSourceScanned("Source Scanned");
        publicMethodsRoot.setTest("Test");
        publicMethodsRoot.setTestName("Test Name");
        publicMethodsRoot.setType("Type");

        Tarea testClassesRoot = new Tarea();
        testClassesRoot.setArguments("Arguments");
        testClassesRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        testClassesRoot.setChildren(new ArrayList<>());
        testClassesRoot.setClassName("Class Name");
        testClassesRoot.setContents("Not all who wander are lost");
        testClassesRoot.setCoverage(true);
        testClassesRoot.setFolderName("Folder Name");
        testClassesRoot.setId(1L);
        testClassesRoot.setLevel("Level");
        testClassesRoot.setMethodName("Method Name");
        testClassesRoot.setNumDependencies(3);
        testClassesRoot.setNumLines(2);
        testClassesRoot.setPackageName("java.text");
        testClassesRoot.setParentId(1L);
        testClassesRoot.setQName("Q Name");
        testClassesRoot.setSourceScanned("Source Scanned");
        testClassesRoot.setTest("Test");
        testClassesRoot.setTestName("Test Name");
        testClassesRoot.setType("Type");

        GitScanerInfo gitScanerInfo = new GitScanerInfo();
        gitScanerInfo.setClassNamePattern("Class Name Pattern");
        gitScanerInfo.setGitLabPath("Git Lab Path");
        gitScanerInfo.setPackageNamePattern("java.text");
        gitScanerInfo.setPublicMethodsRoot(publicMethodsRoot);
        gitScanerInfo.setRelease("1.0.2");
        gitScanerInfo.setTestClassesRoot(testClassesRoot);
        byte[] actualJavaMethodsCoverageReport = PdfUtil.getJavaMethodsCoverageReport(metodos, gitScanerInfo);
        assertEquals((byte) -29, actualJavaMethodsCoverageReport[11]);
        assertEquals((byte) -30, actualJavaMethodsCoverageReport[10]);
        assertEquals((byte) -45, actualJavaMethodsCoverageReport[13]);
        assertEquals((byte) -49, actualJavaMethodsCoverageReport[12]);
        assertEquals(' ', actualJavaMethodsCoverageReport[18]);
        assertEquals(' ', actualJavaMethodsCoverageReport[Short.SIZE]);
        assertEquals('%', actualJavaMethodsCoverageReport[0]);
        assertEquals('%', actualJavaMethodsCoverageReport[9]);
        assertEquals('-', actualJavaMethodsCoverageReport[4]);
        assertEquals('.', actualJavaMethodsCoverageReport[6]);
        assertEquals('0', actualJavaMethodsCoverageReport[17]);
        assertEquals('1', actualJavaMethodsCoverageReport[5]);
        assertEquals('3', actualJavaMethodsCoverageReport[15]);
        assertEquals('5', actualJavaMethodsCoverageReport[7]);
        assertEquals('<', actualJavaMethodsCoverageReport[23]);
        assertEquals('<', actualJavaMethodsCoverageReport[24]);
        assertEquals('D', actualJavaMethodsCoverageReport[2]);
        assertEquals('F', actualJavaMethodsCoverageReport[3]);
        assertEquals('P', actualJavaMethodsCoverageReport[1]);
        assertEquals('\n', actualJavaMethodsCoverageReport[14]);
        assertEquals('\n', actualJavaMethodsCoverageReport[22]);
        assertEquals('\n', actualJavaMethodsCoverageReport[8]);
        assertEquals('b', actualJavaMethodsCoverageReport[20]);
        assertEquals('j', actualJavaMethodsCoverageReport[21]);
        assertEquals('o', actualJavaMethodsCoverageReport[19]);
        assertEquals('t', actualJavaMethodsCoverageReport[1562]);
    }

    /**
     * Method under test:
     * {@link PdfUtil#getJavaMethodsCoverageReport(List, GitScanerInfo)}
     */
    @Test
    void testGetJavaMethodsCoverageReport8() throws DocumentException, UnsupportedEncodingException {
        Tarea tarea = new Tarea();
        tarea.setArguments("                                Método");
        tarea.setArrayOfBytes("A5A5A5A5".getBytes("UTF-8"));
        tarea.setChildren(new ArrayList<>());
        tarea.setClassName("\t");
        tarea.setContents("Not all who wander are lost");
        tarea.setCoverage(true);
        tarea.setFolderName("\t");
        tarea.setId(1L);
        tarea.setLevel("\t");
        tarea.setMethodName("\t");
        tarea.setNumDependencies(3);
        tarea.setNumLines(2);
        tarea.setPackageName("java.text");
        tarea.setParentId(1L);
        tarea.setQName("\t");
        tarea.setSourceScanned("\t");
        tarea.setTest("\t");
        tarea.setTestName("\t");
        tarea.setType("\t");

        ArrayList<Tarea> metodos = new ArrayList<>();
        metodos.add(tarea);

        Tarea publicMethodsRoot = new Tarea();
        publicMethodsRoot.setArguments("Arguments");
        publicMethodsRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        publicMethodsRoot.setChildren(new ArrayList<>());
        publicMethodsRoot.setClassName("Class Name");
        publicMethodsRoot.setContents("Not all who wander are lost");
        publicMethodsRoot.setCoverage(true);
        publicMethodsRoot.setFolderName("Folder Name");
        publicMethodsRoot.setId(1L);
        publicMethodsRoot.setLevel("Level");
        publicMethodsRoot.setMethodName("Method Name");
        publicMethodsRoot.setNumDependencies(3);
        publicMethodsRoot.setNumLines(2);
        publicMethodsRoot.setPackageName("java.text");
        publicMethodsRoot.setParentId(1L);
        publicMethodsRoot.setQName("Q Name");
        publicMethodsRoot.setSourceScanned("Source Scanned");
        publicMethodsRoot.setTest("Test");
        publicMethodsRoot.setTestName("Test Name");
        publicMethodsRoot.setType("Type");

        Tarea testClassesRoot = new Tarea();
        testClassesRoot.setArguments("Arguments");
        testClassesRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        testClassesRoot.setChildren(new ArrayList<>());
        testClassesRoot.setClassName("Class Name");
        testClassesRoot.setContents("Not all who wander are lost");
        testClassesRoot.setCoverage(true);
        testClassesRoot.setFolderName("Folder Name");
        testClassesRoot.setId(1L);
        testClassesRoot.setLevel("Level");
        testClassesRoot.setMethodName("Method Name");
        testClassesRoot.setNumDependencies(3);
        testClassesRoot.setNumLines(2);
        testClassesRoot.setPackageName("java.text");
        testClassesRoot.setParentId(1L);
        testClassesRoot.setQName("Q Name");
        testClassesRoot.setSourceScanned("Source Scanned");
        testClassesRoot.setTest("Test");
        testClassesRoot.setTestName("Test Name");
        testClassesRoot.setType("Type");

        GitScanerInfo gitScanerInfo = new GitScanerInfo();
        gitScanerInfo.setClassNamePattern("Class Name Pattern");
        gitScanerInfo.setGitLabPath("Git Lab Path");
        gitScanerInfo.setPackageNamePattern("java.text");
        gitScanerInfo.setPublicMethodsRoot(publicMethodsRoot);
        gitScanerInfo.setRelease("1.0.2");
        gitScanerInfo.setTestClassesRoot(testClassesRoot);
        byte[] actualJavaMethodsCoverageReport = PdfUtil.getJavaMethodsCoverageReport(metodos, gitScanerInfo);
        assertEquals((byte) -29, actualJavaMethodsCoverageReport[11]);
        assertEquals((byte) -30, actualJavaMethodsCoverageReport[10]);
        assertEquals((byte) -45, actualJavaMethodsCoverageReport[13]);
        assertEquals((byte) -49, actualJavaMethodsCoverageReport[12]);
        assertEquals(' ', actualJavaMethodsCoverageReport[18]);
        assertEquals(' ', actualJavaMethodsCoverageReport[Short.SIZE]);
        assertEquals('%', actualJavaMethodsCoverageReport[0]);
        assertEquals('%', actualJavaMethodsCoverageReport[9]);
        assertEquals('-', actualJavaMethodsCoverageReport[4]);
        assertEquals('.', actualJavaMethodsCoverageReport[6]);
        assertEquals('0', actualJavaMethodsCoverageReport[17]);
        assertEquals('1', actualJavaMethodsCoverageReport[5]);
        assertEquals('3', actualJavaMethodsCoverageReport[15]);
        assertEquals('5', actualJavaMethodsCoverageReport[7]);
        assertEquals('<', actualJavaMethodsCoverageReport[23]);
        assertEquals('<', actualJavaMethodsCoverageReport[24]);
        assertEquals('D', actualJavaMethodsCoverageReport[2]);
        assertEquals('F', actualJavaMethodsCoverageReport[3]);
        assertEquals('P', actualJavaMethodsCoverageReport[1]);
        assertEquals('\n', actualJavaMethodsCoverageReport[14]);
        assertEquals('\n', actualJavaMethodsCoverageReport[22]);
        assertEquals('\n', actualJavaMethodsCoverageReport[8]);
        assertEquals('b', actualJavaMethodsCoverageReport[20]);
        assertEquals('j', actualJavaMethodsCoverageReport[21]);
        assertEquals('o', actualJavaMethodsCoverageReport[19]);
        assertEquals('t', actualJavaMethodsCoverageReport[1562]);
    }

    /**
     * Method under test:
     * {@link PdfUtil#getJavaMethodsCoverageReport(List, GitScanerInfo)}
     */
    @Test
    void testGetJavaMethodsCoverageReport9() throws DocumentException, UnsupportedEncodingException {
        Tarea tarea = new Tarea();
        tarea.setArguments("Arguments");
        tarea.setArrayOfBytes("A5A5A5A5".getBytes("UTF-8"));
        tarea.setChildren(new ArrayList<>());
        tarea.setClassName("\t");
        tarea.setContents("Not all who wander are lost");
        tarea.setCoverage(true);
        tarea.setFolderName("\t");
        tarea.setId(1L);
        tarea.setLevel("\t");
        tarea.setMethodName("\t");
        tarea.setNumDependencies(3);
        tarea.setNumLines(2);
        tarea.setPackageName("java.text");
        tarea.setParentId(1L);
        tarea.setQName("\t");
        tarea.setSourceScanned("\t");
        tarea.setTest("\t");
        tarea.setTestName("\t");
        tarea.setType("\t");

        ArrayList<Tarea> metodos = new ArrayList<>();
        metodos.add(tarea);

        Tarea publicMethodsRoot = new Tarea();
        publicMethodsRoot.setArguments("Arguments");
        publicMethodsRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        publicMethodsRoot.setChildren(new ArrayList<>());
        publicMethodsRoot.setClassName("Class Name");
        publicMethodsRoot.setContents("Not all who wander are lost");
        publicMethodsRoot.setCoverage(true);
        publicMethodsRoot.setFolderName("Folder Name");
        publicMethodsRoot.setId(1L);
        publicMethodsRoot.setLevel("Level");
        publicMethodsRoot.setMethodName("Method Name");
        publicMethodsRoot.setNumDependencies(3);
        publicMethodsRoot.setNumLines(2);
        publicMethodsRoot.setPackageName("java.text");
        publicMethodsRoot.setParentId(1L);
        publicMethodsRoot.setQName("Q Name");
        publicMethodsRoot.setSourceScanned("Source Scanned");
        publicMethodsRoot.setTest("Test");
        publicMethodsRoot.setTestName("Test Name");
        publicMethodsRoot.setType("Type");

        Tarea testClassesRoot = new Tarea();
        testClassesRoot.setArguments("Arguments");
        testClassesRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        testClassesRoot.setChildren(new ArrayList<>());
        testClassesRoot.setClassName("Class Name");
        testClassesRoot.setContents("Not all who wander are lost");
        testClassesRoot.setCoverage(true);
        testClassesRoot.setFolderName("Folder Name");
        testClassesRoot.setId(1L);
        testClassesRoot.setLevel("Level");
        testClassesRoot.setMethodName("Method Name");
        testClassesRoot.setNumDependencies(3);
        testClassesRoot.setNumLines(2);
        testClassesRoot.setPackageName("java.text");
        testClassesRoot.setParentId(1L);
        testClassesRoot.setQName("Q Name");
        testClassesRoot.setSourceScanned("Source Scanned");
        testClassesRoot.setTest("Test");
        testClassesRoot.setTestName("Test Name");
        testClassesRoot.setType("Type");

        GitScanerInfo gitScanerInfo = new GitScanerInfo();
        gitScanerInfo.setClassNamePattern("Class Name Pattern");
        gitScanerInfo.setGitLabPath("Git Lab Path");
        gitScanerInfo.setPackageNamePattern("java.text");
        gitScanerInfo.setPublicMethodsRoot(publicMethodsRoot);
        gitScanerInfo.setRelease("1.0.2");
        gitScanerInfo.setTestClassesRoot(testClassesRoot);
        byte[] actualJavaMethodsCoverageReport = PdfUtil.getJavaMethodsCoverageReport(metodos, gitScanerInfo);
        assertEquals((byte) -29, actualJavaMethodsCoverageReport[11]);
        assertEquals((byte) -30, actualJavaMethodsCoverageReport[10]);
        assertEquals((byte) -45, actualJavaMethodsCoverageReport[13]);
        assertEquals((byte) -49, actualJavaMethodsCoverageReport[12]);
        assertEquals(' ', actualJavaMethodsCoverageReport[18]);
        assertEquals(' ', actualJavaMethodsCoverageReport[Short.SIZE]);
        assertEquals('%', actualJavaMethodsCoverageReport[0]);
        assertEquals('%', actualJavaMethodsCoverageReport[9]);
        assertEquals('-', actualJavaMethodsCoverageReport[4]);
        assertEquals('.', actualJavaMethodsCoverageReport[6]);
        assertEquals('0', actualJavaMethodsCoverageReport[17]);
        assertEquals('1', actualJavaMethodsCoverageReport[5]);
        assertEquals('3', actualJavaMethodsCoverageReport[15]);
        assertEquals('5', actualJavaMethodsCoverageReport[7]);
        assertEquals('<', actualJavaMethodsCoverageReport[23]);
        assertEquals('<', actualJavaMethodsCoverageReport[24]);
        assertEquals('D', actualJavaMethodsCoverageReport[2]);
        assertEquals('F', actualJavaMethodsCoverageReport[3]);
        assertEquals('P', actualJavaMethodsCoverageReport[1]);
        assertEquals('\n', actualJavaMethodsCoverageReport[14]);
        assertEquals('\n', actualJavaMethodsCoverageReport[22]);
        assertEquals('\n', actualJavaMethodsCoverageReport[8]);
        assertEquals('b', actualJavaMethodsCoverageReport[20]);
        assertEquals('j', actualJavaMethodsCoverageReport[21]);
        assertEquals('o', actualJavaMethodsCoverageReport[19]);
        assertEquals('t', actualJavaMethodsCoverageReport[1568]);
    }

    /**
     * Method under test:
     * {@link PdfUtil#getJavaMethodsCoverageReport(List, GitScanerInfo)}
     */
    @Test
    void testGetJavaMethodsCoverageReport10() throws DocumentException, UnsupportedEncodingException {
        Tarea tarea = new Tarea();
        tarea.setArguments("  Nº líneas");
        tarea.setArrayOfBytes("A5A5A5A5".getBytes("UTF-8"));
        tarea.setChildren(new ArrayList<>());
        tarea.setClassName("\t");
        tarea.setContents("Not all who wander are lost");
        tarea.setCoverage(true);
        tarea.setFolderName("\t");
        tarea.setId(1L);
        tarea.setLevel("\t");
        tarea.setMethodName("\t");
        tarea.setNumDependencies(3);
        tarea.setNumLines(2);
        tarea.setPackageName("java.text");
        tarea.setParentId(1L);
        tarea.setQName("\t");
        tarea.setSourceScanned("\t");
        tarea.setTest("\t");
        tarea.setTestName("\t");
        tarea.setType("\t");

        ArrayList<Tarea> metodos = new ArrayList<>();
        metodos.add(tarea);

        Tarea publicMethodsRoot = new Tarea();
        publicMethodsRoot.setArguments("Arguments");
        publicMethodsRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        publicMethodsRoot.setChildren(new ArrayList<>());
        publicMethodsRoot.setClassName("Class Name");
        publicMethodsRoot.setContents("Not all who wander are lost");
        publicMethodsRoot.setCoverage(true);
        publicMethodsRoot.setFolderName("Folder Name");
        publicMethodsRoot.setId(1L);
        publicMethodsRoot.setLevel("Level");
        publicMethodsRoot.setMethodName("Method Name");
        publicMethodsRoot.setNumDependencies(3);
        publicMethodsRoot.setNumLines(2);
        publicMethodsRoot.setPackageName("java.text");
        publicMethodsRoot.setParentId(1L);
        publicMethodsRoot.setQName("Q Name");
        publicMethodsRoot.setSourceScanned("Source Scanned");
        publicMethodsRoot.setTest("Test");
        publicMethodsRoot.setTestName("Test Name");
        publicMethodsRoot.setType("Type");

        Tarea testClassesRoot = new Tarea();
        testClassesRoot.setArguments("Arguments");
        testClassesRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        testClassesRoot.setChildren(new ArrayList<>());
        testClassesRoot.setClassName("Class Name");
        testClassesRoot.setContents("Not all who wander are lost");
        testClassesRoot.setCoverage(true);
        testClassesRoot.setFolderName("Folder Name");
        testClassesRoot.setId(1L);
        testClassesRoot.setLevel("Level");
        testClassesRoot.setMethodName("Method Name");
        testClassesRoot.setNumDependencies(3);
        testClassesRoot.setNumLines(2);
        testClassesRoot.setPackageName("java.text");
        testClassesRoot.setParentId(1L);
        testClassesRoot.setQName("Q Name");
        testClassesRoot.setSourceScanned("Source Scanned");
        testClassesRoot.setTest("Test");
        testClassesRoot.setTestName("Test Name");
        testClassesRoot.setType("Type");

        GitScanerInfo gitScanerInfo = new GitScanerInfo();
        gitScanerInfo.setClassNamePattern("Class Name Pattern");
        gitScanerInfo.setGitLabPath("Git Lab Path");
        gitScanerInfo.setPackageNamePattern("java.text");
        gitScanerInfo.setPublicMethodsRoot(publicMethodsRoot);
        gitScanerInfo.setRelease("1.0.2");
        gitScanerInfo.setTestClassesRoot(testClassesRoot);
        byte[] actualJavaMethodsCoverageReport = PdfUtil.getJavaMethodsCoverageReport(metodos, gitScanerInfo);
        assertEquals((byte) -29, actualJavaMethodsCoverageReport[11]);
        assertEquals((byte) -30, actualJavaMethodsCoverageReport[10]);
        assertEquals((byte) -45, actualJavaMethodsCoverageReport[13]);
        assertEquals((byte) -49, actualJavaMethodsCoverageReport[12]);
        assertEquals(' ', actualJavaMethodsCoverageReport[18]);
        assertEquals(' ', actualJavaMethodsCoverageReport[Short.SIZE]);
        assertEquals('%', actualJavaMethodsCoverageReport[0]);
        assertEquals('%', actualJavaMethodsCoverageReport[9]);
        assertEquals('-', actualJavaMethodsCoverageReport[4]);
        assertEquals('.', actualJavaMethodsCoverageReport[6]);
        assertEquals('0', actualJavaMethodsCoverageReport[17]);
        assertEquals('1', actualJavaMethodsCoverageReport[5]);
        assertEquals('3', actualJavaMethodsCoverageReport[15]);
        assertEquals('5', actualJavaMethodsCoverageReport[7]);
        assertEquals('<', actualJavaMethodsCoverageReport[23]);
        assertEquals('<', actualJavaMethodsCoverageReport[24]);
        assertEquals('D', actualJavaMethodsCoverageReport[2]);
        assertEquals('F', actualJavaMethodsCoverageReport[3]);
        assertEquals('P', actualJavaMethodsCoverageReport[1]);
        assertEquals('\n', actualJavaMethodsCoverageReport[14]);
        assertEquals('\n', actualJavaMethodsCoverageReport[22]);
        assertEquals('\n', actualJavaMethodsCoverageReport[8]);
        assertEquals('b', actualJavaMethodsCoverageReport[20]);
        assertEquals('j', actualJavaMethodsCoverageReport[21]);
        assertEquals('o', actualJavaMethodsCoverageReport[19]);
        assertEquals('t', actualJavaMethodsCoverageReport[1562]);
    }

    /**
     * Method under test:
     * {@link PdfUtil#getJavaMethodsCoverageReport(List, GitScanerInfo)}
     */
    @Test
    void testGetJavaMethodsCoverageReport11() throws DocumentException, UnsupportedEncodingException {
        Tarea tarea = new Tarea();
        tarea.setArguments("42");
        tarea.setArrayOfBytes("A5A5A5A5".getBytes("UTF-8"));
        tarea.setChildren(new ArrayList<>());
        tarea.setClassName("\t");
        tarea.setContents("Not all who wander are lost");
        tarea.setCoverage(true);
        tarea.setFolderName("\t");
        tarea.setId(1L);
        tarea.setLevel("\t");
        tarea.setMethodName("\t");
        tarea.setNumDependencies(3);
        tarea.setNumLines(2);
        tarea.setPackageName("java.text");
        tarea.setParentId(1L);
        tarea.setQName("\t");
        tarea.setSourceScanned("\t");
        tarea.setTest("\t");
        tarea.setTestName("\t");
        tarea.setType("\t");

        ArrayList<Tarea> metodos = new ArrayList<>();
        metodos.add(tarea);

        Tarea publicMethodsRoot = new Tarea();
        publicMethodsRoot.setArguments("Arguments");
        publicMethodsRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        publicMethodsRoot.setChildren(new ArrayList<>());
        publicMethodsRoot.setClassName("Class Name");
        publicMethodsRoot.setContents("Not all who wander are lost");
        publicMethodsRoot.setCoverage(true);
        publicMethodsRoot.setFolderName("Folder Name");
        publicMethodsRoot.setId(1L);
        publicMethodsRoot.setLevel("Level");
        publicMethodsRoot.setMethodName("Method Name");
        publicMethodsRoot.setNumDependencies(3);
        publicMethodsRoot.setNumLines(2);
        publicMethodsRoot.setPackageName("java.text");
        publicMethodsRoot.setParentId(1L);
        publicMethodsRoot.setQName("Q Name");
        publicMethodsRoot.setSourceScanned("Source Scanned");
        publicMethodsRoot.setTest("Test");
        publicMethodsRoot.setTestName("Test Name");
        publicMethodsRoot.setType("Type");

        Tarea testClassesRoot = new Tarea();
        testClassesRoot.setArguments("Arguments");
        testClassesRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        testClassesRoot.setChildren(new ArrayList<>());
        testClassesRoot.setClassName("Class Name");
        testClassesRoot.setContents("Not all who wander are lost");
        testClassesRoot.setCoverage(true);
        testClassesRoot.setFolderName("Folder Name");
        testClassesRoot.setId(1L);
        testClassesRoot.setLevel("Level");
        testClassesRoot.setMethodName("Method Name");
        testClassesRoot.setNumDependencies(3);
        testClassesRoot.setNumLines(2);
        testClassesRoot.setPackageName("java.text");
        testClassesRoot.setParentId(1L);
        testClassesRoot.setQName("Q Name");
        testClassesRoot.setSourceScanned("Source Scanned");
        testClassesRoot.setTest("Test");
        testClassesRoot.setTestName("Test Name");
        testClassesRoot.setType("Type");

        GitScanerInfo gitScanerInfo = new GitScanerInfo();
        gitScanerInfo.setClassNamePattern("Class Name Pattern");
        gitScanerInfo.setGitLabPath("Git Lab Path");
        gitScanerInfo.setPackageNamePattern("java.text");
        gitScanerInfo.setPublicMethodsRoot(publicMethodsRoot);
        gitScanerInfo.setRelease("1.0.2");
        gitScanerInfo.setTestClassesRoot(testClassesRoot);
        byte[] actualJavaMethodsCoverageReport = PdfUtil.getJavaMethodsCoverageReport(metodos, gitScanerInfo);
        assertEquals((byte) -29, actualJavaMethodsCoverageReport[11]);
        assertEquals((byte) -30, actualJavaMethodsCoverageReport[10]);
        assertEquals((byte) -45, actualJavaMethodsCoverageReport[13]);
        assertEquals((byte) -49, actualJavaMethodsCoverageReport[12]);
        assertEquals(' ', actualJavaMethodsCoverageReport[18]);
        assertEquals(' ', actualJavaMethodsCoverageReport[Short.SIZE]);
        assertEquals('%', actualJavaMethodsCoverageReport[0]);
        assertEquals('%', actualJavaMethodsCoverageReport[9]);
        assertEquals('-', actualJavaMethodsCoverageReport[4]);
        assertEquals('.', actualJavaMethodsCoverageReport[6]);
        assertEquals('0', actualJavaMethodsCoverageReport[17]);
        assertEquals('1', actualJavaMethodsCoverageReport[5]);
        assertEquals('3', actualJavaMethodsCoverageReport[15]);
        assertEquals('5', actualJavaMethodsCoverageReport[7]);
        assertEquals('<', actualJavaMethodsCoverageReport[23]);
        assertEquals('<', actualJavaMethodsCoverageReport[24]);
        assertEquals('D', actualJavaMethodsCoverageReport[2]);
        assertEquals('F', actualJavaMethodsCoverageReport[3]);
        assertEquals('P', actualJavaMethodsCoverageReport[1]);
        assertEquals('\n', actualJavaMethodsCoverageReport[14]);
        assertEquals('\n', actualJavaMethodsCoverageReport[22]);
        assertEquals('\n', actualJavaMethodsCoverageReport[8]);
        assertEquals('b', actualJavaMethodsCoverageReport[20]);
        assertEquals('j', actualJavaMethodsCoverageReport[21]);
        assertEquals('o', actualJavaMethodsCoverageReport[19]);
        assertEquals('t', actualJavaMethodsCoverageReport[1562]);
    }

    /**
     * Method under test:
     * {@link PdfUtil#getJavaMethodsCoverageReport(List, GitScanerInfo)}
     */
    @Test
    void testGetJavaMethodsCoverageReport12() throws DocumentException, UnsupportedEncodingException {
        Tarea tarea = new Tarea();
        tarea.setArguments("  ¿Con test?");
        tarea.setArrayOfBytes("A5A5A5A5".getBytes("UTF-8"));
        tarea.setChildren(new ArrayList<>());
        tarea.setClassName("\t");
        tarea.setContents("Not all who wander are lost");
        tarea.setCoverage(true);
        tarea.setFolderName("\t");
        tarea.setId(1L);
        tarea.setLevel("\t");
        tarea.setMethodName("\t");
        tarea.setNumDependencies(3);
        tarea.setNumLines(2);
        tarea.setPackageName("java.text");
        tarea.setParentId(1L);
        tarea.setQName("\t");
        tarea.setSourceScanned("\t");
        tarea.setTest("\t");
        tarea.setTestName("\t");
        tarea.setType("\t");

        ArrayList<Tarea> metodos = new ArrayList<>();
        metodos.add(tarea);

        Tarea publicMethodsRoot = new Tarea();
        publicMethodsRoot.setArguments("Arguments");
        publicMethodsRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        publicMethodsRoot.setChildren(new ArrayList<>());
        publicMethodsRoot.setClassName("Class Name");
        publicMethodsRoot.setContents("Not all who wander are lost");
        publicMethodsRoot.setCoverage(true);
        publicMethodsRoot.setFolderName("Folder Name");
        publicMethodsRoot.setId(1L);
        publicMethodsRoot.setLevel("Level");
        publicMethodsRoot.setMethodName("Method Name");
        publicMethodsRoot.setNumDependencies(3);
        publicMethodsRoot.setNumLines(2);
        publicMethodsRoot.setPackageName("java.text");
        publicMethodsRoot.setParentId(1L);
        publicMethodsRoot.setQName("Q Name");
        publicMethodsRoot.setSourceScanned("Source Scanned");
        publicMethodsRoot.setTest("Test");
        publicMethodsRoot.setTestName("Test Name");
        publicMethodsRoot.setType("Type");

        Tarea testClassesRoot = new Tarea();
        testClassesRoot.setArguments("Arguments");
        testClassesRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        testClassesRoot.setChildren(new ArrayList<>());
        testClassesRoot.setClassName("Class Name");
        testClassesRoot.setContents("Not all who wander are lost");
        testClassesRoot.setCoverage(true);
        testClassesRoot.setFolderName("Folder Name");
        testClassesRoot.setId(1L);
        testClassesRoot.setLevel("Level");
        testClassesRoot.setMethodName("Method Name");
        testClassesRoot.setNumDependencies(3);
        testClassesRoot.setNumLines(2);
        testClassesRoot.setPackageName("java.text");
        testClassesRoot.setParentId(1L);
        testClassesRoot.setQName("Q Name");
        testClassesRoot.setSourceScanned("Source Scanned");
        testClassesRoot.setTest("Test");
        testClassesRoot.setTestName("Test Name");
        testClassesRoot.setType("Type");

        GitScanerInfo gitScanerInfo = new GitScanerInfo();
        gitScanerInfo.setClassNamePattern("Class Name Pattern");
        gitScanerInfo.setGitLabPath("Git Lab Path");
        gitScanerInfo.setPackageNamePattern("java.text");
        gitScanerInfo.setPublicMethodsRoot(publicMethodsRoot);
        gitScanerInfo.setRelease("1.0.2");
        gitScanerInfo.setTestClassesRoot(testClassesRoot);
        byte[] actualJavaMethodsCoverageReport = PdfUtil.getJavaMethodsCoverageReport(metodos, gitScanerInfo);
        assertEquals((byte) -29, actualJavaMethodsCoverageReport[11]);
        assertEquals((byte) -30, actualJavaMethodsCoverageReport[10]);
        assertEquals((byte) -45, actualJavaMethodsCoverageReport[13]);
        assertEquals((byte) -49, actualJavaMethodsCoverageReport[12]);
        assertEquals(' ', actualJavaMethodsCoverageReport[18]);
        assertEquals(' ', actualJavaMethodsCoverageReport[Short.SIZE]);
        assertEquals('%', actualJavaMethodsCoverageReport[0]);
        assertEquals('%', actualJavaMethodsCoverageReport[9]);
        assertEquals('-', actualJavaMethodsCoverageReport[4]);
        assertEquals('.', actualJavaMethodsCoverageReport[6]);
        assertEquals('0', actualJavaMethodsCoverageReport[17]);
        assertEquals('1', actualJavaMethodsCoverageReport[5]);
        assertEquals('3', actualJavaMethodsCoverageReport[15]);
        assertEquals('5', actualJavaMethodsCoverageReport[7]);
        assertEquals('<', actualJavaMethodsCoverageReport[23]);
        assertEquals('<', actualJavaMethodsCoverageReport[24]);
        assertEquals('D', actualJavaMethodsCoverageReport[2]);
        assertEquals('F', actualJavaMethodsCoverageReport[3]);
        assertEquals('P', actualJavaMethodsCoverageReport[1]);
        assertEquals('\n', actualJavaMethodsCoverageReport[14]);
        assertEquals('\n', actualJavaMethodsCoverageReport[22]);
        assertEquals('\n', actualJavaMethodsCoverageReport[8]);
        assertEquals('b', actualJavaMethodsCoverageReport[20]);
        assertEquals('j', actualJavaMethodsCoverageReport[21]);
        assertEquals('o', actualJavaMethodsCoverageReport[19]);
        assertEquals('t', actualJavaMethodsCoverageReport[1562]);
    }

    /**
     * Method under test:
     * {@link PdfUtil#getJavaMethodsCoverageReport(List, GitScanerInfo)}
     */
    @Test
    void testGetJavaMethodsCoverageReport13() throws DocumentException, UnsupportedEncodingException {
        Tarea tarea = new Tarea();
        tarea.setArguments("");
        tarea.setArrayOfBytes("A5A5A5A5".getBytes("UTF-8"));
        tarea.setChildren(new ArrayList<>());
        tarea.setClassName("\t");
        tarea.setContents("Not all who wander are lost");
        tarea.setCoverage(true);
        tarea.setFolderName("\t");
        tarea.setId(1L);
        tarea.setLevel("\t");
        tarea.setMethodName("\t");
        tarea.setNumDependencies(3);
        tarea.setNumLines(2);
        tarea.setPackageName("java.text");
        tarea.setParentId(1L);
        tarea.setQName("\t");
        tarea.setSourceScanned("\t");
        tarea.setTest("\t");
        tarea.setTestName("\t");
        tarea.setType("\t");

        ArrayList<Tarea> metodos = new ArrayList<>();
        metodos.add(tarea);

        Tarea publicMethodsRoot = new Tarea();
        publicMethodsRoot.setArguments("Arguments");
        publicMethodsRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        publicMethodsRoot.setChildren(new ArrayList<>());
        publicMethodsRoot.setClassName("Class Name");
        publicMethodsRoot.setContents("Not all who wander are lost");
        publicMethodsRoot.setCoverage(true);
        publicMethodsRoot.setFolderName("Folder Name");
        publicMethodsRoot.setId(1L);
        publicMethodsRoot.setLevel("Level");
        publicMethodsRoot.setMethodName("Method Name");
        publicMethodsRoot.setNumDependencies(3);
        publicMethodsRoot.setNumLines(2);
        publicMethodsRoot.setPackageName("java.text");
        publicMethodsRoot.setParentId(1L);
        publicMethodsRoot.setQName("Q Name");
        publicMethodsRoot.setSourceScanned("Source Scanned");
        publicMethodsRoot.setTest("Test");
        publicMethodsRoot.setTestName("Test Name");
        publicMethodsRoot.setType("Type");

        Tarea testClassesRoot = new Tarea();
        testClassesRoot.setArguments("Arguments");
        testClassesRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        testClassesRoot.setChildren(new ArrayList<>());
        testClassesRoot.setClassName("Class Name");
        testClassesRoot.setContents("Not all who wander are lost");
        testClassesRoot.setCoverage(true);
        testClassesRoot.setFolderName("Folder Name");
        testClassesRoot.setId(1L);
        testClassesRoot.setLevel("Level");
        testClassesRoot.setMethodName("Method Name");
        testClassesRoot.setNumDependencies(3);
        testClassesRoot.setNumLines(2);
        testClassesRoot.setPackageName("java.text");
        testClassesRoot.setParentId(1L);
        testClassesRoot.setQName("Q Name");
        testClassesRoot.setSourceScanned("Source Scanned");
        testClassesRoot.setTest("Test");
        testClassesRoot.setTestName("Test Name");
        testClassesRoot.setType("Type");

        GitScanerInfo gitScanerInfo = new GitScanerInfo();
        gitScanerInfo.setClassNamePattern("Class Name Pattern");
        gitScanerInfo.setGitLabPath("Git Lab Path");
        gitScanerInfo.setPackageNamePattern("java.text");
        gitScanerInfo.setPublicMethodsRoot(publicMethodsRoot);
        gitScanerInfo.setRelease("1.0.2");
        gitScanerInfo.setTestClassesRoot(testClassesRoot);
        byte[] actualJavaMethodsCoverageReport = PdfUtil.getJavaMethodsCoverageReport(metodos, gitScanerInfo);
        assertEquals((byte) -29, actualJavaMethodsCoverageReport[11]);
        assertEquals((byte) -30, actualJavaMethodsCoverageReport[10]);
        assertEquals((byte) -45, actualJavaMethodsCoverageReport[13]);
        assertEquals((byte) -49, actualJavaMethodsCoverageReport[12]);
        assertEquals(' ', actualJavaMethodsCoverageReport[18]);
        assertEquals(' ', actualJavaMethodsCoverageReport[Short.SIZE]);
        assertEquals('%', actualJavaMethodsCoverageReport[0]);
        assertEquals('%', actualJavaMethodsCoverageReport[9]);
        assertEquals('-', actualJavaMethodsCoverageReport[4]);
        assertEquals('.', actualJavaMethodsCoverageReport[6]);
        assertEquals('0', actualJavaMethodsCoverageReport[17]);
        assertEquals('1', actualJavaMethodsCoverageReport[5]);
        assertEquals('3', actualJavaMethodsCoverageReport[15]);
        assertEquals('5', actualJavaMethodsCoverageReport[7]);
        assertEquals('<', actualJavaMethodsCoverageReport[23]);
        assertEquals('<', actualJavaMethodsCoverageReport[24]);
        assertEquals('D', actualJavaMethodsCoverageReport[2]);
        assertEquals('F', actualJavaMethodsCoverageReport[3]);
        assertEquals('P', actualJavaMethodsCoverageReport[1]);
        assertEquals('\n', actualJavaMethodsCoverageReport[14]);
        assertEquals('\n', actualJavaMethodsCoverageReport[22]);
        assertEquals('\n', actualJavaMethodsCoverageReport[8]);
        assertEquals('b', actualJavaMethodsCoverageReport[20]);
        assertEquals('j', actualJavaMethodsCoverageReport[21]);
        assertEquals('o', actualJavaMethodsCoverageReport[19]);
        assertEquals('t', actualJavaMethodsCoverageReport[1561]);
    }

    /**
     * Method under test:
     * {@link PdfUtil#getJavaMethodsCoverageReport(List, GitScanerInfo)}
     */
    @Test
    void testGetJavaMethodsCoverageReport14() throws DocumentException, UnsupportedEncodingException {
        Tarea tarea = new Tarea();
        tarea.setArguments("(");
        tarea.setArrayOfBytes("A5A5A5A5".getBytes("UTF-8"));
        tarea.setChildren(new ArrayList<>());
        tarea.setClassName("\t");
        tarea.setContents("Not all who wander are lost");
        tarea.setCoverage(true);
        tarea.setFolderName("\t");
        tarea.setId(1L);
        tarea.setLevel("\t");
        tarea.setMethodName("\t");
        tarea.setNumDependencies(3);
        tarea.setNumLines(2);
        tarea.setPackageName("java.text");
        tarea.setParentId(1L);
        tarea.setQName("\t");
        tarea.setSourceScanned("\t");
        tarea.setTest("\t");
        tarea.setTestName("\t");
        tarea.setType("\t");

        ArrayList<Tarea> metodos = new ArrayList<>();
        metodos.add(tarea);

        Tarea publicMethodsRoot = new Tarea();
        publicMethodsRoot.setArguments("Arguments");
        publicMethodsRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        publicMethodsRoot.setChildren(new ArrayList<>());
        publicMethodsRoot.setClassName("Class Name");
        publicMethodsRoot.setContents("Not all who wander are lost");
        publicMethodsRoot.setCoverage(true);
        publicMethodsRoot.setFolderName("Folder Name");
        publicMethodsRoot.setId(1L);
        publicMethodsRoot.setLevel("Level");
        publicMethodsRoot.setMethodName("Method Name");
        publicMethodsRoot.setNumDependencies(3);
        publicMethodsRoot.setNumLines(2);
        publicMethodsRoot.setPackageName("java.text");
        publicMethodsRoot.setParentId(1L);
        publicMethodsRoot.setQName("Q Name");
        publicMethodsRoot.setSourceScanned("Source Scanned");
        publicMethodsRoot.setTest("Test");
        publicMethodsRoot.setTestName("Test Name");
        publicMethodsRoot.setType("Type");

        Tarea testClassesRoot = new Tarea();
        testClassesRoot.setArguments("Arguments");
        testClassesRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        testClassesRoot.setChildren(new ArrayList<>());
        testClassesRoot.setClassName("Class Name");
        testClassesRoot.setContents("Not all who wander are lost");
        testClassesRoot.setCoverage(true);
        testClassesRoot.setFolderName("Folder Name");
        testClassesRoot.setId(1L);
        testClassesRoot.setLevel("Level");
        testClassesRoot.setMethodName("Method Name");
        testClassesRoot.setNumDependencies(3);
        testClassesRoot.setNumLines(2);
        testClassesRoot.setPackageName("java.text");
        testClassesRoot.setParentId(1L);
        testClassesRoot.setQName("Q Name");
        testClassesRoot.setSourceScanned("Source Scanned");
        testClassesRoot.setTest("Test");
        testClassesRoot.setTestName("Test Name");
        testClassesRoot.setType("Type");

        GitScanerInfo gitScanerInfo = new GitScanerInfo();
        gitScanerInfo.setClassNamePattern("Class Name Pattern");
        gitScanerInfo.setGitLabPath("Git Lab Path");
        gitScanerInfo.setPackageNamePattern("java.text");
        gitScanerInfo.setPublicMethodsRoot(publicMethodsRoot);
        gitScanerInfo.setRelease("1.0.2");
        gitScanerInfo.setTestClassesRoot(testClassesRoot);
        byte[] actualJavaMethodsCoverageReport = PdfUtil.getJavaMethodsCoverageReport(metodos, gitScanerInfo);
        assertEquals((byte) -29, actualJavaMethodsCoverageReport[11]);
        assertEquals((byte) -30, actualJavaMethodsCoverageReport[10]);
        assertEquals((byte) -45, actualJavaMethodsCoverageReport[13]);
        assertEquals((byte) -49, actualJavaMethodsCoverageReport[12]);
        assertEquals(' ', actualJavaMethodsCoverageReport[18]);
        assertEquals(' ', actualJavaMethodsCoverageReport[Short.SIZE]);
        assertEquals('%', actualJavaMethodsCoverageReport[0]);
        assertEquals('%', actualJavaMethodsCoverageReport[9]);
        assertEquals('-', actualJavaMethodsCoverageReport[4]);
        assertEquals('.', actualJavaMethodsCoverageReport[6]);
        assertEquals('0', actualJavaMethodsCoverageReport[17]);
        assertEquals('1', actualJavaMethodsCoverageReport[5]);
        assertEquals('3', actualJavaMethodsCoverageReport[15]);
        assertEquals('5', actualJavaMethodsCoverageReport[7]);
        assertEquals('<', actualJavaMethodsCoverageReport[23]);
        assertEquals('<', actualJavaMethodsCoverageReport[24]);
        assertEquals('D', actualJavaMethodsCoverageReport[2]);
        assertEquals('F', actualJavaMethodsCoverageReport[3]);
        assertEquals('P', actualJavaMethodsCoverageReport[1]);
        assertEquals('\n', actualJavaMethodsCoverageReport[14]);
        assertEquals('\n', actualJavaMethodsCoverageReport[22]);
        assertEquals('\n', actualJavaMethodsCoverageReport[8]);
        assertEquals('b', actualJavaMethodsCoverageReport[20]);
        assertEquals('j', actualJavaMethodsCoverageReport[21]);
        assertEquals('o', actualJavaMethodsCoverageReport[19]);
        assertEquals('t', actualJavaMethodsCoverageReport[1559]);
    }

    /**
     * Method under test:
     * {@link PdfUtil#getJavaMethodsCoverageReport(List, GitScanerInfo)}
     */
    @Test
    void testGetJavaMethodsCoverageReport15() throws DocumentException, UnsupportedEncodingException {
        Tarea tarea = new Tarea();
        tarea.setArguments("\t");
        tarea.setArrayOfBytes("A5A5A5A5".getBytes("UTF-8"));
        tarea.setChildren(new ArrayList<>());
        tarea.setClassName("               Panorámica de cobertura de unitarias");
        tarea.setContents("Not all who wander are lost");
        tarea.setCoverage(true);
        tarea.setFolderName("\t");
        tarea.setId(1L);
        tarea.setLevel("\t");
        tarea.setMethodName("\t");
        tarea.setNumDependencies(3);
        tarea.setNumLines(2);
        tarea.setPackageName("java.text");
        tarea.setParentId(1L);
        tarea.setQName("\t");
        tarea.setSourceScanned("\t");
        tarea.setTest("\t");
        tarea.setTestName("\t");
        tarea.setType("\t");

        ArrayList<Tarea> metodos = new ArrayList<>();
        metodos.add(tarea);

        Tarea publicMethodsRoot = new Tarea();
        publicMethodsRoot.setArguments("Arguments");
        publicMethodsRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        publicMethodsRoot.setChildren(new ArrayList<>());
        publicMethodsRoot.setClassName("Class Name");
        publicMethodsRoot.setContents("Not all who wander are lost");
        publicMethodsRoot.setCoverage(true);
        publicMethodsRoot.setFolderName("Folder Name");
        publicMethodsRoot.setId(1L);
        publicMethodsRoot.setLevel("Level");
        publicMethodsRoot.setMethodName("Method Name");
        publicMethodsRoot.setNumDependencies(3);
        publicMethodsRoot.setNumLines(2);
        publicMethodsRoot.setPackageName("java.text");
        publicMethodsRoot.setParentId(1L);
        publicMethodsRoot.setQName("Q Name");
        publicMethodsRoot.setSourceScanned("Source Scanned");
        publicMethodsRoot.setTest("Test");
        publicMethodsRoot.setTestName("Test Name");
        publicMethodsRoot.setType("Type");

        Tarea testClassesRoot = new Tarea();
        testClassesRoot.setArguments("Arguments");
        testClassesRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        testClassesRoot.setChildren(new ArrayList<>());
        testClassesRoot.setClassName("Class Name");
        testClassesRoot.setContents("Not all who wander are lost");
        testClassesRoot.setCoverage(true);
        testClassesRoot.setFolderName("Folder Name");
        testClassesRoot.setId(1L);
        testClassesRoot.setLevel("Level");
        testClassesRoot.setMethodName("Method Name");
        testClassesRoot.setNumDependencies(3);
        testClassesRoot.setNumLines(2);
        testClassesRoot.setPackageName("java.text");
        testClassesRoot.setParentId(1L);
        testClassesRoot.setQName("Q Name");
        testClassesRoot.setSourceScanned("Source Scanned");
        testClassesRoot.setTest("Test");
        testClassesRoot.setTestName("Test Name");
        testClassesRoot.setType("Type");

        GitScanerInfo gitScanerInfo = new GitScanerInfo();
        gitScanerInfo.setClassNamePattern("Class Name Pattern");
        gitScanerInfo.setGitLabPath("Git Lab Path");
        gitScanerInfo.setPackageNamePattern("java.text");
        gitScanerInfo.setPublicMethodsRoot(publicMethodsRoot);
        gitScanerInfo.setRelease("1.0.2");
        gitScanerInfo.setTestClassesRoot(testClassesRoot);
        byte[] actualJavaMethodsCoverageReport = PdfUtil.getJavaMethodsCoverageReport(metodos, gitScanerInfo);
        assertEquals((byte) -29, actualJavaMethodsCoverageReport[11]);
        assertEquals((byte) -30, actualJavaMethodsCoverageReport[10]);
        assertEquals((byte) -45, actualJavaMethodsCoverageReport[13]);
        assertEquals((byte) -49, actualJavaMethodsCoverageReport[12]);
        assertEquals(' ', actualJavaMethodsCoverageReport[18]);
        assertEquals(' ', actualJavaMethodsCoverageReport[Short.SIZE]);
        assertEquals('%', actualJavaMethodsCoverageReport[0]);
        assertEquals('%', actualJavaMethodsCoverageReport[9]);
        assertEquals('-', actualJavaMethodsCoverageReport[4]);
        assertEquals('.', actualJavaMethodsCoverageReport[6]);
        assertEquals('0', actualJavaMethodsCoverageReport[17]);
        assertEquals('1', actualJavaMethodsCoverageReport[5]);
        assertEquals('3', actualJavaMethodsCoverageReport[15]);
        assertEquals('5', actualJavaMethodsCoverageReport[7]);
        assertEquals('<', actualJavaMethodsCoverageReport[23]);
        assertEquals('<', actualJavaMethodsCoverageReport[24]);
        assertEquals('D', actualJavaMethodsCoverageReport[2]);
        assertEquals('F', actualJavaMethodsCoverageReport[3]);
        assertEquals('P', actualJavaMethodsCoverageReport[1]);
        assertEquals('\n', actualJavaMethodsCoverageReport[14]);
        assertEquals('\n', actualJavaMethodsCoverageReport[22]);
        assertEquals('\n', actualJavaMethodsCoverageReport[8]);
        assertEquals('b', actualJavaMethodsCoverageReport[20]);
        assertEquals('j', actualJavaMethodsCoverageReport[21]);
        assertEquals('o', actualJavaMethodsCoverageReport[19]);
        assertEquals('t', actualJavaMethodsCoverageReport[1579]);
    }

    /**
     * Method under test:
     * {@link PdfUtil#getJavaMethodsCoverageReport(List, GitScanerInfo)}
     */
    @Test
    void testGetJavaMethodsCoverageReport16() throws DocumentException, UnsupportedEncodingException {
        Tarea tarea = new Tarea();
        tarea.setArguments("\t");
        tarea.setArrayOfBytes("A5A5A5A5".getBytes("UTF-8"));
        tarea.setChildren(new ArrayList<>());
        tarea.setClassName(null);
        tarea.setContents("Not all who wander are lost");
        tarea.setCoverage(true);
        tarea.setFolderName("\t");
        tarea.setId(1L);
        tarea.setLevel("\t");
        tarea.setMethodName("\t");
        tarea.setNumDependencies(3);
        tarea.setNumLines(2);
        tarea.setPackageName("java.text");
        tarea.setParentId(1L);
        tarea.setQName("\t");
        tarea.setSourceScanned("\t");
        tarea.setTest("\t");
        tarea.setTestName("\t");
        tarea.setType("\t");

        ArrayList<Tarea> metodos = new ArrayList<>();
        metodos.add(tarea);

        Tarea publicMethodsRoot = new Tarea();
        publicMethodsRoot.setArguments("Arguments");
        publicMethodsRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        publicMethodsRoot.setChildren(new ArrayList<>());
        publicMethodsRoot.setClassName("Class Name");
        publicMethodsRoot.setContents("Not all who wander are lost");
        publicMethodsRoot.setCoverage(true);
        publicMethodsRoot.setFolderName("Folder Name");
        publicMethodsRoot.setId(1L);
        publicMethodsRoot.setLevel("Level");
        publicMethodsRoot.setMethodName("Method Name");
        publicMethodsRoot.setNumDependencies(3);
        publicMethodsRoot.setNumLines(2);
        publicMethodsRoot.setPackageName("java.text");
        publicMethodsRoot.setParentId(1L);
        publicMethodsRoot.setQName("Q Name");
        publicMethodsRoot.setSourceScanned("Source Scanned");
        publicMethodsRoot.setTest("Test");
        publicMethodsRoot.setTestName("Test Name");
        publicMethodsRoot.setType("Type");

        Tarea testClassesRoot = new Tarea();
        testClassesRoot.setArguments("Arguments");
        testClassesRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        testClassesRoot.setChildren(new ArrayList<>());
        testClassesRoot.setClassName("Class Name");
        testClassesRoot.setContents("Not all who wander are lost");
        testClassesRoot.setCoverage(true);
        testClassesRoot.setFolderName("Folder Name");
        testClassesRoot.setId(1L);
        testClassesRoot.setLevel("Level");
        testClassesRoot.setMethodName("Method Name");
        testClassesRoot.setNumDependencies(3);
        testClassesRoot.setNumLines(2);
        testClassesRoot.setPackageName("java.text");
        testClassesRoot.setParentId(1L);
        testClassesRoot.setQName("Q Name");
        testClassesRoot.setSourceScanned("Source Scanned");
        testClassesRoot.setTest("Test");
        testClassesRoot.setTestName("Test Name");
        testClassesRoot.setType("Type");

        GitScanerInfo gitScanerInfo = new GitScanerInfo();
        gitScanerInfo.setClassNamePattern("Class Name Pattern");
        gitScanerInfo.setGitLabPath("Git Lab Path");
        gitScanerInfo.setPackageNamePattern("java.text");
        gitScanerInfo.setPublicMethodsRoot(publicMethodsRoot);
        gitScanerInfo.setRelease("1.0.2");
        gitScanerInfo.setTestClassesRoot(testClassesRoot);
        byte[] actualJavaMethodsCoverageReport = PdfUtil.getJavaMethodsCoverageReport(metodos, gitScanerInfo);
        assertEquals((byte) -29, actualJavaMethodsCoverageReport[11]);
        assertEquals((byte) -30, actualJavaMethodsCoverageReport[10]);
        assertEquals((byte) -45, actualJavaMethodsCoverageReport[13]);
        assertEquals((byte) -49, actualJavaMethodsCoverageReport[12]);
        assertEquals(' ', actualJavaMethodsCoverageReport[18]);
        assertEquals(' ', actualJavaMethodsCoverageReport[Short.SIZE]);
        assertEquals('%', actualJavaMethodsCoverageReport[0]);
        assertEquals('%', actualJavaMethodsCoverageReport[9]);
        assertEquals('-', actualJavaMethodsCoverageReport[4]);
        assertEquals('.', actualJavaMethodsCoverageReport[6]);
        assertEquals('0', actualJavaMethodsCoverageReport[17]);
        assertEquals('1', actualJavaMethodsCoverageReport[5]);
        assertEquals('3', actualJavaMethodsCoverageReport[15]);
        assertEquals('5', actualJavaMethodsCoverageReport[7]);
        assertEquals('<', actualJavaMethodsCoverageReport[23]);
        assertEquals('<', actualJavaMethodsCoverageReport[24]);
        assertEquals('D', actualJavaMethodsCoverageReport[2]);
        assertEquals('F', actualJavaMethodsCoverageReport[3]);
        assertEquals('P', actualJavaMethodsCoverageReport[1]);
        assertEquals('\n', actualJavaMethodsCoverageReport[14]);
        assertEquals('\n', actualJavaMethodsCoverageReport[22]);
        assertEquals('\n', actualJavaMethodsCoverageReport[8]);
        assertEquals('b', actualJavaMethodsCoverageReport[20]);
        assertEquals('j', actualJavaMethodsCoverageReport[21]);
        assertEquals('o', actualJavaMethodsCoverageReport[19]);
        assertEquals('t', actualJavaMethodsCoverageReport[1561]);
    }

    /**
     * Method under test:
     * {@link PdfUtil#getJavaMethodsCoverageReport(List, GitScanerInfo)}
     */
    @Test
    void testGetJavaMethodsCoverageReport17() throws DocumentException, UnsupportedEncodingException {
        Tarea tarea = new Tarea();
        tarea.setArguments("\t");
        tarea.setArrayOfBytes("A5A5A5A5".getBytes("UTF-8"));
        tarea.setChildren(new ArrayList<>());
        tarea.setClassName("");
        tarea.setContents("Not all who wander are lost");
        tarea.setCoverage(true);
        tarea.setFolderName("\t");
        tarea.setId(1L);
        tarea.setLevel("\t");
        tarea.setMethodName("\t");
        tarea.setNumDependencies(3);
        tarea.setNumLines(2);
        tarea.setPackageName("java.text");
        tarea.setParentId(1L);
        tarea.setQName("\t");
        tarea.setSourceScanned("\t");
        tarea.setTest("\t");
        tarea.setTestName("\t");
        tarea.setType("\t");

        ArrayList<Tarea> metodos = new ArrayList<>();
        metodos.add(tarea);

        Tarea publicMethodsRoot = new Tarea();
        publicMethodsRoot.setArguments("Arguments");
        publicMethodsRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        publicMethodsRoot.setChildren(new ArrayList<>());
        publicMethodsRoot.setClassName("Class Name");
        publicMethodsRoot.setContents("Not all who wander are lost");
        publicMethodsRoot.setCoverage(true);
        publicMethodsRoot.setFolderName("Folder Name");
        publicMethodsRoot.setId(1L);
        publicMethodsRoot.setLevel("Level");
        publicMethodsRoot.setMethodName("Method Name");
        publicMethodsRoot.setNumDependencies(3);
        publicMethodsRoot.setNumLines(2);
        publicMethodsRoot.setPackageName("java.text");
        publicMethodsRoot.setParentId(1L);
        publicMethodsRoot.setQName("Q Name");
        publicMethodsRoot.setSourceScanned("Source Scanned");
        publicMethodsRoot.setTest("Test");
        publicMethodsRoot.setTestName("Test Name");
        publicMethodsRoot.setType("Type");

        Tarea testClassesRoot = new Tarea();
        testClassesRoot.setArguments("Arguments");
        testClassesRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        testClassesRoot.setChildren(new ArrayList<>());
        testClassesRoot.setClassName("Class Name");
        testClassesRoot.setContents("Not all who wander are lost");
        testClassesRoot.setCoverage(true);
        testClassesRoot.setFolderName("Folder Name");
        testClassesRoot.setId(1L);
        testClassesRoot.setLevel("Level");
        testClassesRoot.setMethodName("Method Name");
        testClassesRoot.setNumDependencies(3);
        testClassesRoot.setNumLines(2);
        testClassesRoot.setPackageName("java.text");
        testClassesRoot.setParentId(1L);
        testClassesRoot.setQName("Q Name");
        testClassesRoot.setSourceScanned("Source Scanned");
        testClassesRoot.setTest("Test");
        testClassesRoot.setTestName("Test Name");
        testClassesRoot.setType("Type");

        GitScanerInfo gitScanerInfo = new GitScanerInfo();
        gitScanerInfo.setClassNamePattern("Class Name Pattern");
        gitScanerInfo.setGitLabPath("Git Lab Path");
        gitScanerInfo.setPackageNamePattern("java.text");
        gitScanerInfo.setPublicMethodsRoot(publicMethodsRoot);
        gitScanerInfo.setRelease("1.0.2");
        gitScanerInfo.setTestClassesRoot(testClassesRoot);
        byte[] actualJavaMethodsCoverageReport = PdfUtil.getJavaMethodsCoverageReport(metodos, gitScanerInfo);
        assertEquals((byte) -29, actualJavaMethodsCoverageReport[11]);
        assertEquals((byte) -30, actualJavaMethodsCoverageReport[10]);
        assertEquals((byte) -45, actualJavaMethodsCoverageReport[13]);
        assertEquals((byte) -49, actualJavaMethodsCoverageReport[12]);
        assertEquals(' ', actualJavaMethodsCoverageReport[18]);
        assertEquals(' ', actualJavaMethodsCoverageReport[Short.SIZE]);
        assertEquals('%', actualJavaMethodsCoverageReport[0]);
        assertEquals('%', actualJavaMethodsCoverageReport[9]);
        assertEquals('-', actualJavaMethodsCoverageReport[4]);
        assertEquals('.', actualJavaMethodsCoverageReport[6]);
        assertEquals('0', actualJavaMethodsCoverageReport[17]);
        assertEquals('1', actualJavaMethodsCoverageReport[5]);
        assertEquals('3', actualJavaMethodsCoverageReport[15]);
        assertEquals('5', actualJavaMethodsCoverageReport[7]);
        assertEquals('<', actualJavaMethodsCoverageReport[23]);
        assertEquals('<', actualJavaMethodsCoverageReport[24]);
        assertEquals('D', actualJavaMethodsCoverageReport[2]);
        assertEquals('F', actualJavaMethodsCoverageReport[3]);
        assertEquals('P', actualJavaMethodsCoverageReport[1]);
        assertEquals('\n', actualJavaMethodsCoverageReport[14]);
        assertEquals('\n', actualJavaMethodsCoverageReport[22]);
        assertEquals('\n', actualJavaMethodsCoverageReport[8]);
        assertEquals('b', actualJavaMethodsCoverageReport[20]);
        assertEquals('j', actualJavaMethodsCoverageReport[21]);
        assertEquals('o', actualJavaMethodsCoverageReport[19]);
        assertEquals('t', actualJavaMethodsCoverageReport[1561]);
    }

    /**
     * Method under test:
     * {@link PdfUtil#getJavaMethodsCoverageReport(List, GitScanerInfo)}
     */
    @Test
    void testGetJavaMethodsCoverageReport18() throws DocumentException, UnsupportedEncodingException {
        Tarea tarea = new Tarea();
        tarea.setArguments("\t");
        tarea.setArrayOfBytes("A5A5A5A5".getBytes("UTF-8"));
        tarea.setChildren(new ArrayList<>());
        tarea.setClassName("\t");
        tarea.setContents("Not all who wander are lost");
        tarea.setCoverage(true);
        tarea.setFolderName("\t");
        tarea.setId(1L);
        tarea.setLevel("\t");
        tarea.setMethodName("             ");
        tarea.setNumDependencies(3);
        tarea.setNumLines(2);
        tarea.setPackageName("java.text");
        tarea.setParentId(1L);
        tarea.setQName("\t");
        tarea.setSourceScanned("\t");
        tarea.setTest("\t");
        tarea.setTestName("\t");
        tarea.setType("\t");

        ArrayList<Tarea> metodos = new ArrayList<>();
        metodos.add(tarea);

        Tarea publicMethodsRoot = new Tarea();
        publicMethodsRoot.setArguments("Arguments");
        publicMethodsRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        publicMethodsRoot.setChildren(new ArrayList<>());
        publicMethodsRoot.setClassName("Class Name");
        publicMethodsRoot.setContents("Not all who wander are lost");
        publicMethodsRoot.setCoverage(true);
        publicMethodsRoot.setFolderName("Folder Name");
        publicMethodsRoot.setId(1L);
        publicMethodsRoot.setLevel("Level");
        publicMethodsRoot.setMethodName("Method Name");
        publicMethodsRoot.setNumDependencies(3);
        publicMethodsRoot.setNumLines(2);
        publicMethodsRoot.setPackageName("java.text");
        publicMethodsRoot.setParentId(1L);
        publicMethodsRoot.setQName("Q Name");
        publicMethodsRoot.setSourceScanned("Source Scanned");
        publicMethodsRoot.setTest("Test");
        publicMethodsRoot.setTestName("Test Name");
        publicMethodsRoot.setType("Type");

        Tarea testClassesRoot = new Tarea();
        testClassesRoot.setArguments("Arguments");
        testClassesRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        testClassesRoot.setChildren(new ArrayList<>());
        testClassesRoot.setClassName("Class Name");
        testClassesRoot.setContents("Not all who wander are lost");
        testClassesRoot.setCoverage(true);
        testClassesRoot.setFolderName("Folder Name");
        testClassesRoot.setId(1L);
        testClassesRoot.setLevel("Level");
        testClassesRoot.setMethodName("Method Name");
        testClassesRoot.setNumDependencies(3);
        testClassesRoot.setNumLines(2);
        testClassesRoot.setPackageName("java.text");
        testClassesRoot.setParentId(1L);
        testClassesRoot.setQName("Q Name");
        testClassesRoot.setSourceScanned("Source Scanned");
        testClassesRoot.setTest("Test");
        testClassesRoot.setTestName("Test Name");
        testClassesRoot.setType("Type");

        GitScanerInfo gitScanerInfo = new GitScanerInfo();
        gitScanerInfo.setClassNamePattern("Class Name Pattern");
        gitScanerInfo.setGitLabPath("Git Lab Path");
        gitScanerInfo.setPackageNamePattern("java.text");
        gitScanerInfo.setPublicMethodsRoot(publicMethodsRoot);
        gitScanerInfo.setRelease("1.0.2");
        gitScanerInfo.setTestClassesRoot(testClassesRoot);
        byte[] actualJavaMethodsCoverageReport = PdfUtil.getJavaMethodsCoverageReport(metodos, gitScanerInfo);
        assertEquals((byte) -29, actualJavaMethodsCoverageReport[11]);
        assertEquals((byte) -30, actualJavaMethodsCoverageReport[10]);
        assertEquals((byte) -45, actualJavaMethodsCoverageReport[13]);
        assertEquals((byte) -49, actualJavaMethodsCoverageReport[12]);
        assertEquals(' ', actualJavaMethodsCoverageReport[18]);
        assertEquals(' ', actualJavaMethodsCoverageReport[Short.SIZE]);
        assertEquals('%', actualJavaMethodsCoverageReport[0]);
        assertEquals('%', actualJavaMethodsCoverageReport[9]);
        assertEquals('-', actualJavaMethodsCoverageReport[4]);
        assertEquals('.', actualJavaMethodsCoverageReport[6]);
        assertEquals('0', actualJavaMethodsCoverageReport[17]);
        assertEquals('1', actualJavaMethodsCoverageReport[5]);
        assertEquals('3', actualJavaMethodsCoverageReport[15]);
        assertEquals('5', actualJavaMethodsCoverageReport[7]);
        assertEquals('<', actualJavaMethodsCoverageReport[23]);
        assertEquals('<', actualJavaMethodsCoverageReport[24]);
        assertEquals('D', actualJavaMethodsCoverageReport[2]);
        assertEquals('F', actualJavaMethodsCoverageReport[3]);
        assertEquals('P', actualJavaMethodsCoverageReport[1]);
        assertEquals('\n', actualJavaMethodsCoverageReport[14]);
        assertEquals('\n', actualJavaMethodsCoverageReport[22]);
        assertEquals('\n', actualJavaMethodsCoverageReport[8]);
        assertEquals('b', actualJavaMethodsCoverageReport[20]);
        assertEquals('j', actualJavaMethodsCoverageReport[21]);
        assertEquals('o', actualJavaMethodsCoverageReport[19]);
        assertEquals('t', actualJavaMethodsCoverageReport[1559]);
    }

    /**
     * Method under test:
     * {@link PdfUtil#getJavaMethodsCoverageReport(List, GitScanerInfo)}
     */
    @Test
    void testGetJavaMethodsCoverageReport19() throws DocumentException, UnsupportedEncodingException {
        Tarea tarea = new Tarea();
        tarea.setArguments("\t");
        tarea.setArrayOfBytes("A5A5A5A5".getBytes("UTF-8"));
        tarea.setChildren(new ArrayList<>());
        tarea.setClassName("\t");
        tarea.setContents("Not all who wander are lost");
        tarea.setCoverage(true);
        tarea.setFolderName("\t");
        tarea.setId(1L);
        tarea.setLevel("\t");
        tarea.setMethodName("               Panorámica de cobertura de unitarias");
        tarea.setNumDependencies(3);
        tarea.setNumLines(2);
        tarea.setPackageName("java.text");
        tarea.setParentId(1L);
        tarea.setQName("\t");
        tarea.setSourceScanned("\t");
        tarea.setTest("\t");
        tarea.setTestName("\t");
        tarea.setType("\t");

        ArrayList<Tarea> metodos = new ArrayList<>();
        metodos.add(tarea);

        Tarea publicMethodsRoot = new Tarea();
        publicMethodsRoot.setArguments("Arguments");
        publicMethodsRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        publicMethodsRoot.setChildren(new ArrayList<>());
        publicMethodsRoot.setClassName("Class Name");
        publicMethodsRoot.setContents("Not all who wander are lost");
        publicMethodsRoot.setCoverage(true);
        publicMethodsRoot.setFolderName("Folder Name");
        publicMethodsRoot.setId(1L);
        publicMethodsRoot.setLevel("Level");
        publicMethodsRoot.setMethodName("Method Name");
        publicMethodsRoot.setNumDependencies(3);
        publicMethodsRoot.setNumLines(2);
        publicMethodsRoot.setPackageName("java.text");
        publicMethodsRoot.setParentId(1L);
        publicMethodsRoot.setQName("Q Name");
        publicMethodsRoot.setSourceScanned("Source Scanned");
        publicMethodsRoot.setTest("Test");
        publicMethodsRoot.setTestName("Test Name");
        publicMethodsRoot.setType("Type");

        Tarea testClassesRoot = new Tarea();
        testClassesRoot.setArguments("Arguments");
        testClassesRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        testClassesRoot.setChildren(new ArrayList<>());
        testClassesRoot.setClassName("Class Name");
        testClassesRoot.setContents("Not all who wander are lost");
        testClassesRoot.setCoverage(true);
        testClassesRoot.setFolderName("Folder Name");
        testClassesRoot.setId(1L);
        testClassesRoot.setLevel("Level");
        testClassesRoot.setMethodName("Method Name");
        testClassesRoot.setNumDependencies(3);
        testClassesRoot.setNumLines(2);
        testClassesRoot.setPackageName("java.text");
        testClassesRoot.setParentId(1L);
        testClassesRoot.setQName("Q Name");
        testClassesRoot.setSourceScanned("Source Scanned");
        testClassesRoot.setTest("Test");
        testClassesRoot.setTestName("Test Name");
        testClassesRoot.setType("Type");

        GitScanerInfo gitScanerInfo = new GitScanerInfo();
        gitScanerInfo.setClassNamePattern("Class Name Pattern");
        gitScanerInfo.setGitLabPath("Git Lab Path");
        gitScanerInfo.setPackageNamePattern("java.text");
        gitScanerInfo.setPublicMethodsRoot(publicMethodsRoot);
        gitScanerInfo.setRelease("1.0.2");
        gitScanerInfo.setTestClassesRoot(testClassesRoot);
        byte[] actualJavaMethodsCoverageReport = PdfUtil.getJavaMethodsCoverageReport(metodos, gitScanerInfo);
        assertEquals((byte) -29, actualJavaMethodsCoverageReport[11]);
        assertEquals((byte) -30, actualJavaMethodsCoverageReport[10]);
        assertEquals((byte) -45, actualJavaMethodsCoverageReport[13]);
        assertEquals((byte) -49, actualJavaMethodsCoverageReport[12]);
        assertEquals(' ', actualJavaMethodsCoverageReport[18]);
        assertEquals(' ', actualJavaMethodsCoverageReport[Short.SIZE]);
        assertEquals('%', actualJavaMethodsCoverageReport[0]);
        assertEquals('%', actualJavaMethodsCoverageReport[9]);
        assertEquals('-', actualJavaMethodsCoverageReport[4]);
        assertEquals('.', actualJavaMethodsCoverageReport[6]);
        assertEquals('0', actualJavaMethodsCoverageReport[17]);
        assertEquals('1', actualJavaMethodsCoverageReport[5]);
        assertEquals('3', actualJavaMethodsCoverageReport[15]);
        assertEquals('5', actualJavaMethodsCoverageReport[7]);
        assertEquals('<', actualJavaMethodsCoverageReport[23]);
        assertEquals('<', actualJavaMethodsCoverageReport[24]);
        assertEquals('D', actualJavaMethodsCoverageReport[2]);
        assertEquals('F', actualJavaMethodsCoverageReport[3]);
        assertEquals('P', actualJavaMethodsCoverageReport[1]);
        assertEquals('\n', actualJavaMethodsCoverageReport[14]);
        assertEquals('\n', actualJavaMethodsCoverageReport[22]);
        assertEquals('\n', actualJavaMethodsCoverageReport[8]);
        assertEquals('b', actualJavaMethodsCoverageReport[20]);
        assertEquals('j', actualJavaMethodsCoverageReport[21]);
        assertEquals('o', actualJavaMethodsCoverageReport[19]);
        assertEquals('t', actualJavaMethodsCoverageReport[1560]);
    }

    /**
     * Method under test:
     * {@link PdfUtil#getJavaMethodsCoverageReport(List, GitScanerInfo)}
     */
    @Test
    void testGetJavaMethodsCoverageReport20() throws DocumentException, UnsupportedEncodingException {
        Tarea tarea = new Tarea();
        tarea.setArguments("\t");
        tarea.setArrayOfBytes("A5A5A5A5".getBytes("UTF-8"));
        tarea.setChildren(new ArrayList<>());
        tarea.setClassName("\t");
        tarea.setContents("Not all who wander are lost");
        tarea.setCoverage(true);
        tarea.setFolderName("\t");
        tarea.setId(1L);
        tarea.setLevel("\t");
        tarea.setMethodName("                    Package");
        tarea.setNumDependencies(3);
        tarea.setNumLines(2);
        tarea.setPackageName("java.text");
        tarea.setParentId(1L);
        tarea.setQName("\t");
        tarea.setSourceScanned("\t");
        tarea.setTest("\t");
        tarea.setTestName("\t");
        tarea.setType("\t");

        ArrayList<Tarea> metodos = new ArrayList<>();
        metodos.add(tarea);

        Tarea publicMethodsRoot = new Tarea();
        publicMethodsRoot.setArguments("Arguments");
        publicMethodsRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        publicMethodsRoot.setChildren(new ArrayList<>());
        publicMethodsRoot.setClassName("Class Name");
        publicMethodsRoot.setContents("Not all who wander are lost");
        publicMethodsRoot.setCoverage(true);
        publicMethodsRoot.setFolderName("Folder Name");
        publicMethodsRoot.setId(1L);
        publicMethodsRoot.setLevel("Level");
        publicMethodsRoot.setMethodName("Method Name");
        publicMethodsRoot.setNumDependencies(3);
        publicMethodsRoot.setNumLines(2);
        publicMethodsRoot.setPackageName("java.text");
        publicMethodsRoot.setParentId(1L);
        publicMethodsRoot.setQName("Q Name");
        publicMethodsRoot.setSourceScanned("Source Scanned");
        publicMethodsRoot.setTest("Test");
        publicMethodsRoot.setTestName("Test Name");
        publicMethodsRoot.setType("Type");

        Tarea testClassesRoot = new Tarea();
        testClassesRoot.setArguments("Arguments");
        testClassesRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        testClassesRoot.setChildren(new ArrayList<>());
        testClassesRoot.setClassName("Class Name");
        testClassesRoot.setContents("Not all who wander are lost");
        testClassesRoot.setCoverage(true);
        testClassesRoot.setFolderName("Folder Name");
        testClassesRoot.setId(1L);
        testClassesRoot.setLevel("Level");
        testClassesRoot.setMethodName("Method Name");
        testClassesRoot.setNumDependencies(3);
        testClassesRoot.setNumLines(2);
        testClassesRoot.setPackageName("java.text");
        testClassesRoot.setParentId(1L);
        testClassesRoot.setQName("Q Name");
        testClassesRoot.setSourceScanned("Source Scanned");
        testClassesRoot.setTest("Test");
        testClassesRoot.setTestName("Test Name");
        testClassesRoot.setType("Type");

        GitScanerInfo gitScanerInfo = new GitScanerInfo();
        gitScanerInfo.setClassNamePattern("Class Name Pattern");
        gitScanerInfo.setGitLabPath("Git Lab Path");
        gitScanerInfo.setPackageNamePattern("java.text");
        gitScanerInfo.setPublicMethodsRoot(publicMethodsRoot);
        gitScanerInfo.setRelease("1.0.2");
        gitScanerInfo.setTestClassesRoot(testClassesRoot);
        byte[] actualJavaMethodsCoverageReport = PdfUtil.getJavaMethodsCoverageReport(metodos, gitScanerInfo);
        assertEquals((byte) -29, actualJavaMethodsCoverageReport[11]);
        assertEquals((byte) -30, actualJavaMethodsCoverageReport[10]);
        assertEquals((byte) -45, actualJavaMethodsCoverageReport[13]);
        assertEquals((byte) -49, actualJavaMethodsCoverageReport[12]);
        assertEquals(' ', actualJavaMethodsCoverageReport[18]);
        assertEquals(' ', actualJavaMethodsCoverageReport[Short.SIZE]);
        assertEquals('%', actualJavaMethodsCoverageReport[0]);
        assertEquals('%', actualJavaMethodsCoverageReport[9]);
        assertEquals('-', actualJavaMethodsCoverageReport[4]);
        assertEquals('.', actualJavaMethodsCoverageReport[6]);
        assertEquals('0', actualJavaMethodsCoverageReport[17]);
        assertEquals('1', actualJavaMethodsCoverageReport[5]);
        assertEquals('3', actualJavaMethodsCoverageReport[15]);
        assertEquals('5', actualJavaMethodsCoverageReport[7]);
        assertEquals('<', actualJavaMethodsCoverageReport[23]);
        assertEquals('<', actualJavaMethodsCoverageReport[24]);
        assertEquals('D', actualJavaMethodsCoverageReport[2]);
        assertEquals('F', actualJavaMethodsCoverageReport[3]);
        assertEquals('P', actualJavaMethodsCoverageReport[1]);
        assertEquals('\n', actualJavaMethodsCoverageReport[14]);
        assertEquals('\n', actualJavaMethodsCoverageReport[22]);
        assertEquals('\n', actualJavaMethodsCoverageReport[8]);
        assertEquals('b', actualJavaMethodsCoverageReport[20]);
        assertEquals('j', actualJavaMethodsCoverageReport[21]);
        assertEquals('o', actualJavaMethodsCoverageReport[19]);
        assertEquals('t', actualJavaMethodsCoverageReport[1560]);
    }

    /**
     * Method under test:
     * {@link PdfUtil#getJavaMethodsCoverageReport(List, GitScanerInfo)}
     */
    @Test
    void testGetJavaMethodsCoverageReport21() throws DocumentException, UnsupportedEncodingException {
        Tarea tarea = new Tarea();
        tarea.setArguments("\t");
        tarea.setArrayOfBytes("A5A5A5A5".getBytes("UTF-8"));
        tarea.setChildren(new ArrayList<>());
        tarea.setClassName("\t");
        tarea.setContents("Not all who wander are lost");
        tarea.setCoverage(true);
        tarea.setFolderName("\t");
        tarea.setId(1L);
        tarea.setLevel("\t");
        tarea.setMethodName("                    Clase");
        tarea.setNumDependencies(3);
        tarea.setNumLines(2);
        tarea.setPackageName("java.text");
        tarea.setParentId(1L);
        tarea.setQName("\t");
        tarea.setSourceScanned("\t");
        tarea.setTest("\t");
        tarea.setTestName("\t");
        tarea.setType("\t");

        ArrayList<Tarea> metodos = new ArrayList<>();
        metodos.add(tarea);

        Tarea publicMethodsRoot = new Tarea();
        publicMethodsRoot.setArguments("Arguments");
        publicMethodsRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        publicMethodsRoot.setChildren(new ArrayList<>());
        publicMethodsRoot.setClassName("Class Name");
        publicMethodsRoot.setContents("Not all who wander are lost");
        publicMethodsRoot.setCoverage(true);
        publicMethodsRoot.setFolderName("Folder Name");
        publicMethodsRoot.setId(1L);
        publicMethodsRoot.setLevel("Level");
        publicMethodsRoot.setMethodName("Method Name");
        publicMethodsRoot.setNumDependencies(3);
        publicMethodsRoot.setNumLines(2);
        publicMethodsRoot.setPackageName("java.text");
        publicMethodsRoot.setParentId(1L);
        publicMethodsRoot.setQName("Q Name");
        publicMethodsRoot.setSourceScanned("Source Scanned");
        publicMethodsRoot.setTest("Test");
        publicMethodsRoot.setTestName("Test Name");
        publicMethodsRoot.setType("Type");

        Tarea testClassesRoot = new Tarea();
        testClassesRoot.setArguments("Arguments");
        testClassesRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        testClassesRoot.setChildren(new ArrayList<>());
        testClassesRoot.setClassName("Class Name");
        testClassesRoot.setContents("Not all who wander are lost");
        testClassesRoot.setCoverage(true);
        testClassesRoot.setFolderName("Folder Name");
        testClassesRoot.setId(1L);
        testClassesRoot.setLevel("Level");
        testClassesRoot.setMethodName("Method Name");
        testClassesRoot.setNumDependencies(3);
        testClassesRoot.setNumLines(2);
        testClassesRoot.setPackageName("java.text");
        testClassesRoot.setParentId(1L);
        testClassesRoot.setQName("Q Name");
        testClassesRoot.setSourceScanned("Source Scanned");
        testClassesRoot.setTest("Test");
        testClassesRoot.setTestName("Test Name");
        testClassesRoot.setType("Type");

        GitScanerInfo gitScanerInfo = new GitScanerInfo();
        gitScanerInfo.setClassNamePattern("Class Name Pattern");
        gitScanerInfo.setGitLabPath("Git Lab Path");
        gitScanerInfo.setPackageNamePattern("java.text");
        gitScanerInfo.setPublicMethodsRoot(publicMethodsRoot);
        gitScanerInfo.setRelease("1.0.2");
        gitScanerInfo.setTestClassesRoot(testClassesRoot);
        byte[] actualJavaMethodsCoverageReport = PdfUtil.getJavaMethodsCoverageReport(metodos, gitScanerInfo);
        assertEquals((byte) -29, actualJavaMethodsCoverageReport[11]);
        assertEquals((byte) -30, actualJavaMethodsCoverageReport[10]);
        assertEquals((byte) -45, actualJavaMethodsCoverageReport[13]);
        assertEquals((byte) -49, actualJavaMethodsCoverageReport[12]);
        assertEquals(' ', actualJavaMethodsCoverageReport[18]);
        assertEquals(' ', actualJavaMethodsCoverageReport[Short.SIZE]);
        assertEquals('%', actualJavaMethodsCoverageReport[0]);
        assertEquals('%', actualJavaMethodsCoverageReport[9]);
        assertEquals('-', actualJavaMethodsCoverageReport[4]);
        assertEquals('.', actualJavaMethodsCoverageReport[6]);
        assertEquals('0', actualJavaMethodsCoverageReport[17]);
        assertEquals('1', actualJavaMethodsCoverageReport[5]);
        assertEquals('3', actualJavaMethodsCoverageReport[15]);
        assertEquals('5', actualJavaMethodsCoverageReport[7]);
        assertEquals('<', actualJavaMethodsCoverageReport[23]);
        assertEquals('<', actualJavaMethodsCoverageReport[24]);
        assertEquals('D', actualJavaMethodsCoverageReport[2]);
        assertEquals('F', actualJavaMethodsCoverageReport[3]);
        assertEquals('P', actualJavaMethodsCoverageReport[1]);
        assertEquals('\n', actualJavaMethodsCoverageReport[14]);
        assertEquals('\n', actualJavaMethodsCoverageReport[22]);
        assertEquals('\n', actualJavaMethodsCoverageReport[8]);
        assertEquals('b', actualJavaMethodsCoverageReport[20]);
        assertEquals('j', actualJavaMethodsCoverageReport[21]);
        assertEquals('o', actualJavaMethodsCoverageReport[19]);
        assertEquals('t', actualJavaMethodsCoverageReport[1560]);
    }

    /**
     * Method under test:
     * {@link PdfUtil#getJavaMethodsCoverageReport(List, GitScanerInfo)}
     */
    @Test
    void testGetJavaMethodsCoverageReport22() throws DocumentException, UnsupportedEncodingException {
        Tarea tarea = new Tarea();
        tarea.setArguments("\t");
        tarea.setArrayOfBytes("A5A5A5A5".getBytes("UTF-8"));
        tarea.setChildren(new ArrayList<>());
        tarea.setClassName("\t");
        tarea.setContents("Not all who wander are lost");
        tarea.setCoverage(true);
        tarea.setFolderName("\t");
        tarea.setId(1L);
        tarea.setLevel("\t");
        tarea.setMethodName("                                Método");
        tarea.setNumDependencies(3);
        tarea.setNumLines(2);
        tarea.setPackageName("java.text");
        tarea.setParentId(1L);
        tarea.setQName("\t");
        tarea.setSourceScanned("\t");
        tarea.setTest("\t");
        tarea.setTestName("\t");
        tarea.setType("\t");

        ArrayList<Tarea> metodos = new ArrayList<>();
        metodos.add(tarea);

        Tarea publicMethodsRoot = new Tarea();
        publicMethodsRoot.setArguments("Arguments");
        publicMethodsRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        publicMethodsRoot.setChildren(new ArrayList<>());
        publicMethodsRoot.setClassName("Class Name");
        publicMethodsRoot.setContents("Not all who wander are lost");
        publicMethodsRoot.setCoverage(true);
        publicMethodsRoot.setFolderName("Folder Name");
        publicMethodsRoot.setId(1L);
        publicMethodsRoot.setLevel("Level");
        publicMethodsRoot.setMethodName("Method Name");
        publicMethodsRoot.setNumDependencies(3);
        publicMethodsRoot.setNumLines(2);
        publicMethodsRoot.setPackageName("java.text");
        publicMethodsRoot.setParentId(1L);
        publicMethodsRoot.setQName("Q Name");
        publicMethodsRoot.setSourceScanned("Source Scanned");
        publicMethodsRoot.setTest("Test");
        publicMethodsRoot.setTestName("Test Name");
        publicMethodsRoot.setType("Type");

        Tarea testClassesRoot = new Tarea();
        testClassesRoot.setArguments("Arguments");
        testClassesRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        testClassesRoot.setChildren(new ArrayList<>());
        testClassesRoot.setClassName("Class Name");
        testClassesRoot.setContents("Not all who wander are lost");
        testClassesRoot.setCoverage(true);
        testClassesRoot.setFolderName("Folder Name");
        testClassesRoot.setId(1L);
        testClassesRoot.setLevel("Level");
        testClassesRoot.setMethodName("Method Name");
        testClassesRoot.setNumDependencies(3);
        testClassesRoot.setNumLines(2);
        testClassesRoot.setPackageName("java.text");
        testClassesRoot.setParentId(1L);
        testClassesRoot.setQName("Q Name");
        testClassesRoot.setSourceScanned("Source Scanned");
        testClassesRoot.setTest("Test");
        testClassesRoot.setTestName("Test Name");
        testClassesRoot.setType("Type");

        GitScanerInfo gitScanerInfo = new GitScanerInfo();
        gitScanerInfo.setClassNamePattern("Class Name Pattern");
        gitScanerInfo.setGitLabPath("Git Lab Path");
        gitScanerInfo.setPackageNamePattern("java.text");
        gitScanerInfo.setPublicMethodsRoot(publicMethodsRoot);
        gitScanerInfo.setRelease("1.0.2");
        gitScanerInfo.setTestClassesRoot(testClassesRoot);
        byte[] actualJavaMethodsCoverageReport = PdfUtil.getJavaMethodsCoverageReport(metodos, gitScanerInfo);
        assertEquals((byte) -29, actualJavaMethodsCoverageReport[11]);
        assertEquals((byte) -30, actualJavaMethodsCoverageReport[10]);
        assertEquals((byte) -45, actualJavaMethodsCoverageReport[13]);
        assertEquals((byte) -49, actualJavaMethodsCoverageReport[12]);
        assertEquals(' ', actualJavaMethodsCoverageReport[18]);
        assertEquals(' ', actualJavaMethodsCoverageReport[Short.SIZE]);
        assertEquals('%', actualJavaMethodsCoverageReport[0]);
        assertEquals('%', actualJavaMethodsCoverageReport[9]);
        assertEquals('-', actualJavaMethodsCoverageReport[4]);
        assertEquals('.', actualJavaMethodsCoverageReport[6]);
        assertEquals('0', actualJavaMethodsCoverageReport[17]);
        assertEquals('1', actualJavaMethodsCoverageReport[5]);
        assertEquals('3', actualJavaMethodsCoverageReport[15]);
        assertEquals('5', actualJavaMethodsCoverageReport[7]);
        assertEquals('<', actualJavaMethodsCoverageReport[23]);
        assertEquals('<', actualJavaMethodsCoverageReport[24]);
        assertEquals('D', actualJavaMethodsCoverageReport[2]);
        assertEquals('F', actualJavaMethodsCoverageReport[3]);
        assertEquals('P', actualJavaMethodsCoverageReport[1]);
        assertEquals('\n', actualJavaMethodsCoverageReport[14]);
        assertEquals('\n', actualJavaMethodsCoverageReport[22]);
        assertEquals('\n', actualJavaMethodsCoverageReport[8]);
        assertEquals('b', actualJavaMethodsCoverageReport[20]);
        assertEquals('j', actualJavaMethodsCoverageReport[21]);
        assertEquals('o', actualJavaMethodsCoverageReport[19]);
        assertEquals('t', actualJavaMethodsCoverageReport[1560]);
    }

    /**
     * Method under test:
     * {@link PdfUtil#getJavaMethodsCoverageReport(List, GitScanerInfo)}
     */
    @Test
    void testGetJavaMethodsCoverageReport23() throws DocumentException, UnsupportedEncodingException {
        Tarea tarea = new Tarea();
        tarea.setArguments("\t");
        tarea.setArrayOfBytes("A5A5A5A5".getBytes("UTF-8"));
        tarea.setChildren(new ArrayList<>());
        tarea.setClassName("\t");
        tarea.setContents("Not all who wander are lost");
        tarea.setCoverage(true);
        tarea.setFolderName("\t");
        tarea.setId(1L);
        tarea.setLevel("\t");
        tarea.setMethodName("Method Name");
        tarea.setNumDependencies(3);
        tarea.setNumLines(2);
        tarea.setPackageName("java.text");
        tarea.setParentId(1L);
        tarea.setQName("\t");
        tarea.setSourceScanned("\t");
        tarea.setTest("\t");
        tarea.setTestName("\t");
        tarea.setType("\t");

        ArrayList<Tarea> metodos = new ArrayList<>();
        metodos.add(tarea);

        Tarea publicMethodsRoot = new Tarea();
        publicMethodsRoot.setArguments("Arguments");
        publicMethodsRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        publicMethodsRoot.setChildren(new ArrayList<>());
        publicMethodsRoot.setClassName("Class Name");
        publicMethodsRoot.setContents("Not all who wander are lost");
        publicMethodsRoot.setCoverage(true);
        publicMethodsRoot.setFolderName("Folder Name");
        publicMethodsRoot.setId(1L);
        publicMethodsRoot.setLevel("Level");
        publicMethodsRoot.setMethodName("Method Name");
        publicMethodsRoot.setNumDependencies(3);
        publicMethodsRoot.setNumLines(2);
        publicMethodsRoot.setPackageName("java.text");
        publicMethodsRoot.setParentId(1L);
        publicMethodsRoot.setQName("Q Name");
        publicMethodsRoot.setSourceScanned("Source Scanned");
        publicMethodsRoot.setTest("Test");
        publicMethodsRoot.setTestName("Test Name");
        publicMethodsRoot.setType("Type");

        Tarea testClassesRoot = new Tarea();
        testClassesRoot.setArguments("Arguments");
        testClassesRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        testClassesRoot.setChildren(new ArrayList<>());
        testClassesRoot.setClassName("Class Name");
        testClassesRoot.setContents("Not all who wander are lost");
        testClassesRoot.setCoverage(true);
        testClassesRoot.setFolderName("Folder Name");
        testClassesRoot.setId(1L);
        testClassesRoot.setLevel("Level");
        testClassesRoot.setMethodName("Method Name");
        testClassesRoot.setNumDependencies(3);
        testClassesRoot.setNumLines(2);
        testClassesRoot.setPackageName("java.text");
        testClassesRoot.setParentId(1L);
        testClassesRoot.setQName("Q Name");
        testClassesRoot.setSourceScanned("Source Scanned");
        testClassesRoot.setTest("Test");
        testClassesRoot.setTestName("Test Name");
        testClassesRoot.setType("Type");

        GitScanerInfo gitScanerInfo = new GitScanerInfo();
        gitScanerInfo.setClassNamePattern("Class Name Pattern");
        gitScanerInfo.setGitLabPath("Git Lab Path");
        gitScanerInfo.setPackageNamePattern("java.text");
        gitScanerInfo.setPublicMethodsRoot(publicMethodsRoot);
        gitScanerInfo.setRelease("1.0.2");
        gitScanerInfo.setTestClassesRoot(testClassesRoot);
        byte[] actualJavaMethodsCoverageReport = PdfUtil.getJavaMethodsCoverageReport(metodos, gitScanerInfo);
        assertEquals((byte) -29, actualJavaMethodsCoverageReport[11]);
        assertEquals((byte) -30, actualJavaMethodsCoverageReport[10]);
        assertEquals((byte) -45, actualJavaMethodsCoverageReport[13]);
        assertEquals((byte) -49, actualJavaMethodsCoverageReport[12]);
        assertEquals(' ', actualJavaMethodsCoverageReport[18]);
        assertEquals(' ', actualJavaMethodsCoverageReport[Short.SIZE]);
        assertEquals('%', actualJavaMethodsCoverageReport[0]);
        assertEquals('%', actualJavaMethodsCoverageReport[9]);
        assertEquals('-', actualJavaMethodsCoverageReport[4]);
        assertEquals('.', actualJavaMethodsCoverageReport[6]);
        assertEquals('0', actualJavaMethodsCoverageReport[17]);
        assertEquals('1', actualJavaMethodsCoverageReport[5]);
        assertEquals('3', actualJavaMethodsCoverageReport[15]);
        assertEquals('5', actualJavaMethodsCoverageReport[7]);
        assertEquals('<', actualJavaMethodsCoverageReport[23]);
        assertEquals('<', actualJavaMethodsCoverageReport[24]);
        assertEquals('D', actualJavaMethodsCoverageReport[2]);
        assertEquals('F', actualJavaMethodsCoverageReport[3]);
        assertEquals('P', actualJavaMethodsCoverageReport[1]);
        assertEquals('\n', actualJavaMethodsCoverageReport[14]);
        assertEquals('\n', actualJavaMethodsCoverageReport[22]);
        assertEquals('\n', actualJavaMethodsCoverageReport[8]);
        assertEquals('b', actualJavaMethodsCoverageReport[20]);
        assertEquals('j', actualJavaMethodsCoverageReport[21]);
        assertEquals('o', actualJavaMethodsCoverageReport[19]);
        assertEquals('t', actualJavaMethodsCoverageReport[1569]);
    }

    /**
     * Method under test:
     * {@link PdfUtil#getJavaMethodsCoverageReport(List, GitScanerInfo)}
     */
    @Test
    void testGetJavaMethodsCoverageReport24() throws DocumentException, UnsupportedEncodingException {
        Tarea tarea = new Tarea();
        tarea.setArguments("\t");
        tarea.setArrayOfBytes("A5A5A5A5".getBytes("UTF-8"));
        tarea.setChildren(new ArrayList<>());
        tarea.setClassName("\t");
        tarea.setContents("Not all who wander are lost");
        tarea.setCoverage(true);
        tarea.setFolderName("\t");
        tarea.setId(1L);
        tarea.setLevel("\t");
        tarea.setMethodName("  Nº líneas");
        tarea.setNumDependencies(3);
        tarea.setNumLines(2);
        tarea.setPackageName("java.text");
        tarea.setParentId(1L);
        tarea.setQName("\t");
        tarea.setSourceScanned("\t");
        tarea.setTest("\t");
        tarea.setTestName("\t");
        tarea.setType("\t");

        ArrayList<Tarea> metodos = new ArrayList<>();
        metodos.add(tarea);

        Tarea publicMethodsRoot = new Tarea();
        publicMethodsRoot.setArguments("Arguments");
        publicMethodsRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        publicMethodsRoot.setChildren(new ArrayList<>());
        publicMethodsRoot.setClassName("Class Name");
        publicMethodsRoot.setContents("Not all who wander are lost");
        publicMethodsRoot.setCoverage(true);
        publicMethodsRoot.setFolderName("Folder Name");
        publicMethodsRoot.setId(1L);
        publicMethodsRoot.setLevel("Level");
        publicMethodsRoot.setMethodName("Method Name");
        publicMethodsRoot.setNumDependencies(3);
        publicMethodsRoot.setNumLines(2);
        publicMethodsRoot.setPackageName("java.text");
        publicMethodsRoot.setParentId(1L);
        publicMethodsRoot.setQName("Q Name");
        publicMethodsRoot.setSourceScanned("Source Scanned");
        publicMethodsRoot.setTest("Test");
        publicMethodsRoot.setTestName("Test Name");
        publicMethodsRoot.setType("Type");

        Tarea testClassesRoot = new Tarea();
        testClassesRoot.setArguments("Arguments");
        testClassesRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        testClassesRoot.setChildren(new ArrayList<>());
        testClassesRoot.setClassName("Class Name");
        testClassesRoot.setContents("Not all who wander are lost");
        testClassesRoot.setCoverage(true);
        testClassesRoot.setFolderName("Folder Name");
        testClassesRoot.setId(1L);
        testClassesRoot.setLevel("Level");
        testClassesRoot.setMethodName("Method Name");
        testClassesRoot.setNumDependencies(3);
        testClassesRoot.setNumLines(2);
        testClassesRoot.setPackageName("java.text");
        testClassesRoot.setParentId(1L);
        testClassesRoot.setQName("Q Name");
        testClassesRoot.setSourceScanned("Source Scanned");
        testClassesRoot.setTest("Test");
        testClassesRoot.setTestName("Test Name");
        testClassesRoot.setType("Type");

        GitScanerInfo gitScanerInfo = new GitScanerInfo();
        gitScanerInfo.setClassNamePattern("Class Name Pattern");
        gitScanerInfo.setGitLabPath("Git Lab Path");
        gitScanerInfo.setPackageNamePattern("java.text");
        gitScanerInfo.setPublicMethodsRoot(publicMethodsRoot);
        gitScanerInfo.setRelease("1.0.2");
        gitScanerInfo.setTestClassesRoot(testClassesRoot);
        byte[] actualJavaMethodsCoverageReport = PdfUtil.getJavaMethodsCoverageReport(metodos, gitScanerInfo);
        assertEquals((byte) -29, actualJavaMethodsCoverageReport[11]);
        assertEquals((byte) -30, actualJavaMethodsCoverageReport[10]);
        assertEquals((byte) -45, actualJavaMethodsCoverageReport[13]);
        assertEquals((byte) -49, actualJavaMethodsCoverageReport[12]);
        assertEquals(' ', actualJavaMethodsCoverageReport[18]);
        assertEquals(' ', actualJavaMethodsCoverageReport[Short.SIZE]);
        assertEquals('%', actualJavaMethodsCoverageReport[0]);
        assertEquals('%', actualJavaMethodsCoverageReport[9]);
        assertEquals('-', actualJavaMethodsCoverageReport[4]);
        assertEquals('.', actualJavaMethodsCoverageReport[6]);
        assertEquals('0', actualJavaMethodsCoverageReport[17]);
        assertEquals('1', actualJavaMethodsCoverageReport[5]);
        assertEquals('3', actualJavaMethodsCoverageReport[15]);
        assertEquals('5', actualJavaMethodsCoverageReport[7]);
        assertEquals('<', actualJavaMethodsCoverageReport[23]);
        assertEquals('<', actualJavaMethodsCoverageReport[24]);
        assertEquals('D', actualJavaMethodsCoverageReport[2]);
        assertEquals('F', actualJavaMethodsCoverageReport[3]);
        assertEquals('P', actualJavaMethodsCoverageReport[1]);
        assertEquals('\n', actualJavaMethodsCoverageReport[14]);
        assertEquals('\n', actualJavaMethodsCoverageReport[22]);
        assertEquals('\n', actualJavaMethodsCoverageReport[8]);
        assertEquals('b', actualJavaMethodsCoverageReport[20]);
        assertEquals('j', actualJavaMethodsCoverageReport[21]);
        assertEquals('o', actualJavaMethodsCoverageReport[19]);
        assertEquals('t', actualJavaMethodsCoverageReport[1562]);
    }

    /**
     * Method under test:
     * {@link PdfUtil#getJavaMethodsCoverageReport(List, GitScanerInfo)}
     */
    @Test
    void testGetJavaMethodsCoverageReport25() throws DocumentException, UnsupportedEncodingException {
        Tarea tarea = new Tarea();
        tarea.setArguments("\t");
        tarea.setArrayOfBytes("A5A5A5A5".getBytes("UTF-8"));
        tarea.setChildren(new ArrayList<>());
        tarea.setClassName("\t");
        tarea.setContents("Not all who wander are lost");
        tarea.setCoverage(true);
        tarea.setFolderName("\t");
        tarea.setId(1L);
        tarea.setLevel("\t");
        tarea.setMethodName("42");
        tarea.setNumDependencies(3);
        tarea.setNumLines(2);
        tarea.setPackageName("java.text");
        tarea.setParentId(1L);
        tarea.setQName("\t");
        tarea.setSourceScanned("\t");
        tarea.setTest("\t");
        tarea.setTestName("\t");
        tarea.setType("\t");

        ArrayList<Tarea> metodos = new ArrayList<>();
        metodos.add(tarea);

        Tarea publicMethodsRoot = new Tarea();
        publicMethodsRoot.setArguments("Arguments");
        publicMethodsRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        publicMethodsRoot.setChildren(new ArrayList<>());
        publicMethodsRoot.setClassName("Class Name");
        publicMethodsRoot.setContents("Not all who wander are lost");
        publicMethodsRoot.setCoverage(true);
        publicMethodsRoot.setFolderName("Folder Name");
        publicMethodsRoot.setId(1L);
        publicMethodsRoot.setLevel("Level");
        publicMethodsRoot.setMethodName("Method Name");
        publicMethodsRoot.setNumDependencies(3);
        publicMethodsRoot.setNumLines(2);
        publicMethodsRoot.setPackageName("java.text");
        publicMethodsRoot.setParentId(1L);
        publicMethodsRoot.setQName("Q Name");
        publicMethodsRoot.setSourceScanned("Source Scanned");
        publicMethodsRoot.setTest("Test");
        publicMethodsRoot.setTestName("Test Name");
        publicMethodsRoot.setType("Type");

        Tarea testClassesRoot = new Tarea();
        testClassesRoot.setArguments("Arguments");
        testClassesRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        testClassesRoot.setChildren(new ArrayList<>());
        testClassesRoot.setClassName("Class Name");
        testClassesRoot.setContents("Not all who wander are lost");
        testClassesRoot.setCoverage(true);
        testClassesRoot.setFolderName("Folder Name");
        testClassesRoot.setId(1L);
        testClassesRoot.setLevel("Level");
        testClassesRoot.setMethodName("Method Name");
        testClassesRoot.setNumDependencies(3);
        testClassesRoot.setNumLines(2);
        testClassesRoot.setPackageName("java.text");
        testClassesRoot.setParentId(1L);
        testClassesRoot.setQName("Q Name");
        testClassesRoot.setSourceScanned("Source Scanned");
        testClassesRoot.setTest("Test");
        testClassesRoot.setTestName("Test Name");
        testClassesRoot.setType("Type");

        GitScanerInfo gitScanerInfo = new GitScanerInfo();
        gitScanerInfo.setClassNamePattern("Class Name Pattern");
        gitScanerInfo.setGitLabPath("Git Lab Path");
        gitScanerInfo.setPackageNamePattern("java.text");
        gitScanerInfo.setPublicMethodsRoot(publicMethodsRoot);
        gitScanerInfo.setRelease("1.0.2");
        gitScanerInfo.setTestClassesRoot(testClassesRoot);
        byte[] actualJavaMethodsCoverageReport = PdfUtil.getJavaMethodsCoverageReport(metodos, gitScanerInfo);
        assertEquals((byte) -29, actualJavaMethodsCoverageReport[11]);
        assertEquals((byte) -30, actualJavaMethodsCoverageReport[10]);
        assertEquals((byte) -45, actualJavaMethodsCoverageReport[13]);
        assertEquals((byte) -49, actualJavaMethodsCoverageReport[12]);
        assertEquals(' ', actualJavaMethodsCoverageReport[18]);
        assertEquals(' ', actualJavaMethodsCoverageReport[Short.SIZE]);
        assertEquals('%', actualJavaMethodsCoverageReport[0]);
        assertEquals('%', actualJavaMethodsCoverageReport[9]);
        assertEquals('-', actualJavaMethodsCoverageReport[4]);
        assertEquals('.', actualJavaMethodsCoverageReport[6]);
        assertEquals('0', actualJavaMethodsCoverageReport[17]);
        assertEquals('1', actualJavaMethodsCoverageReport[5]);
        assertEquals('3', actualJavaMethodsCoverageReport[15]);
        assertEquals('5', actualJavaMethodsCoverageReport[7]);
        assertEquals('<', actualJavaMethodsCoverageReport[23]);
        assertEquals('<', actualJavaMethodsCoverageReport[24]);
        assertEquals('D', actualJavaMethodsCoverageReport[2]);
        assertEquals('F', actualJavaMethodsCoverageReport[3]);
        assertEquals('P', actualJavaMethodsCoverageReport[1]);
        assertEquals('\n', actualJavaMethodsCoverageReport[14]);
        assertEquals('\n', actualJavaMethodsCoverageReport[22]);
        assertEquals('\n', actualJavaMethodsCoverageReport[8]);
        assertEquals('b', actualJavaMethodsCoverageReport[20]);
        assertEquals('j', actualJavaMethodsCoverageReport[21]);
        assertEquals('o', actualJavaMethodsCoverageReport[19]);
        assertEquals('t', actualJavaMethodsCoverageReport[1562]);
    }

    /**
     * Method under test:
     * {@link PdfUtil#getJavaMethodsCoverageReport(List, GitScanerInfo)}
     */
    @Test
    void testGetJavaMethodsCoverageReport26() throws DocumentException, UnsupportedEncodingException {
        Tarea tarea = new Tarea();
        tarea.setArguments("\t");
        tarea.setArrayOfBytes("A5A5A5A5".getBytes("UTF-8"));
        tarea.setChildren(new ArrayList<>());
        tarea.setClassName("\t");
        tarea.setContents("Not all who wander are lost");
        tarea.setCoverage(true);
        tarea.setFolderName("\t");
        tarea.setId(1L);
        tarea.setLevel("\t");
        tarea.setMethodName("  ¿Con test?");
        tarea.setNumDependencies(3);
        tarea.setNumLines(2);
        tarea.setPackageName("java.text");
        tarea.setParentId(1L);
        tarea.setQName("\t");
        tarea.setSourceScanned("\t");
        tarea.setTest("\t");
        tarea.setTestName("\t");
        tarea.setType("\t");

        ArrayList<Tarea> metodos = new ArrayList<>();
        metodos.add(tarea);

        Tarea publicMethodsRoot = new Tarea();
        publicMethodsRoot.setArguments("Arguments");
        publicMethodsRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        publicMethodsRoot.setChildren(new ArrayList<>());
        publicMethodsRoot.setClassName("Class Name");
        publicMethodsRoot.setContents("Not all who wander are lost");
        publicMethodsRoot.setCoverage(true);
        publicMethodsRoot.setFolderName("Folder Name");
        publicMethodsRoot.setId(1L);
        publicMethodsRoot.setLevel("Level");
        publicMethodsRoot.setMethodName("Method Name");
        publicMethodsRoot.setNumDependencies(3);
        publicMethodsRoot.setNumLines(2);
        publicMethodsRoot.setPackageName("java.text");
        publicMethodsRoot.setParentId(1L);
        publicMethodsRoot.setQName("Q Name");
        publicMethodsRoot.setSourceScanned("Source Scanned");
        publicMethodsRoot.setTest("Test");
        publicMethodsRoot.setTestName("Test Name");
        publicMethodsRoot.setType("Type");

        Tarea testClassesRoot = new Tarea();
        testClassesRoot.setArguments("Arguments");
        testClassesRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        testClassesRoot.setChildren(new ArrayList<>());
        testClassesRoot.setClassName("Class Name");
        testClassesRoot.setContents("Not all who wander are lost");
        testClassesRoot.setCoverage(true);
        testClassesRoot.setFolderName("Folder Name");
        testClassesRoot.setId(1L);
        testClassesRoot.setLevel("Level");
        testClassesRoot.setMethodName("Method Name");
        testClassesRoot.setNumDependencies(3);
        testClassesRoot.setNumLines(2);
        testClassesRoot.setPackageName("java.text");
        testClassesRoot.setParentId(1L);
        testClassesRoot.setQName("Q Name");
        testClassesRoot.setSourceScanned("Source Scanned");
        testClassesRoot.setTest("Test");
        testClassesRoot.setTestName("Test Name");
        testClassesRoot.setType("Type");

        GitScanerInfo gitScanerInfo = new GitScanerInfo();
        gitScanerInfo.setClassNamePattern("Class Name Pattern");
        gitScanerInfo.setGitLabPath("Git Lab Path");
        gitScanerInfo.setPackageNamePattern("java.text");
        gitScanerInfo.setPublicMethodsRoot(publicMethodsRoot);
        gitScanerInfo.setRelease("1.0.2");
        gitScanerInfo.setTestClassesRoot(testClassesRoot);
        byte[] actualJavaMethodsCoverageReport = PdfUtil.getJavaMethodsCoverageReport(metodos, gitScanerInfo);
        assertEquals((byte) -29, actualJavaMethodsCoverageReport[11]);
        assertEquals((byte) -30, actualJavaMethodsCoverageReport[10]);
        assertEquals((byte) -45, actualJavaMethodsCoverageReport[13]);
        assertEquals((byte) -49, actualJavaMethodsCoverageReport[12]);
        assertEquals(' ', actualJavaMethodsCoverageReport[18]);
        assertEquals(' ', actualJavaMethodsCoverageReport[Short.SIZE]);
        assertEquals('%', actualJavaMethodsCoverageReport[0]);
        assertEquals('%', actualJavaMethodsCoverageReport[9]);
        assertEquals('-', actualJavaMethodsCoverageReport[4]);
        assertEquals('.', actualJavaMethodsCoverageReport[6]);
        assertEquals('0', actualJavaMethodsCoverageReport[17]);
        assertEquals('1', actualJavaMethodsCoverageReport[5]);
        assertEquals('3', actualJavaMethodsCoverageReport[15]);
        assertEquals('5', actualJavaMethodsCoverageReport[7]);
        assertEquals('<', actualJavaMethodsCoverageReport[23]);
        assertEquals('<', actualJavaMethodsCoverageReport[24]);
        assertEquals('D', actualJavaMethodsCoverageReport[2]);
        assertEquals('F', actualJavaMethodsCoverageReport[3]);
        assertEquals('P', actualJavaMethodsCoverageReport[1]);
        assertEquals('\n', actualJavaMethodsCoverageReport[14]);
        assertEquals('\n', actualJavaMethodsCoverageReport[22]);
        assertEquals('\n', actualJavaMethodsCoverageReport[8]);
        assertEquals('b', actualJavaMethodsCoverageReport[20]);
        assertEquals('j', actualJavaMethodsCoverageReport[21]);
        assertEquals('o', actualJavaMethodsCoverageReport[19]);
        assertEquals('t', actualJavaMethodsCoverageReport[1562]);
    }

    /**
     * Method under test:
     * {@link PdfUtil#getJavaMethodsCoverageReport(List, GitScanerInfo)}
     */
    @Test
    void testGetJavaMethodsCoverageReport27() throws DocumentException, UnsupportedEncodingException {
        Tarea tarea = new Tarea();
        tarea.setArguments("\t");
        tarea.setArrayOfBytes("A5A5A5A5".getBytes("UTF-8"));
        tarea.setChildren(new ArrayList<>());
        tarea.setClassName("\t");
        tarea.setContents("Not all who wander are lost");
        tarea.setCoverage(true);
        tarea.setFolderName("\t");
        tarea.setId(1L);
        tarea.setLevel("\t");
        tarea.setMethodName("");
        tarea.setNumDependencies(3);
        tarea.setNumLines(2);
        tarea.setPackageName("java.text");
        tarea.setParentId(1L);
        tarea.setQName("\t");
        tarea.setSourceScanned("\t");
        tarea.setTest("\t");
        tarea.setTestName("\t");
        tarea.setType("\t");

        ArrayList<Tarea> metodos = new ArrayList<>();
        metodos.add(tarea);

        Tarea publicMethodsRoot = new Tarea();
        publicMethodsRoot.setArguments("Arguments");
        publicMethodsRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        publicMethodsRoot.setChildren(new ArrayList<>());
        publicMethodsRoot.setClassName("Class Name");
        publicMethodsRoot.setContents("Not all who wander are lost");
        publicMethodsRoot.setCoverage(true);
        publicMethodsRoot.setFolderName("Folder Name");
        publicMethodsRoot.setId(1L);
        publicMethodsRoot.setLevel("Level");
        publicMethodsRoot.setMethodName("Method Name");
        publicMethodsRoot.setNumDependencies(3);
        publicMethodsRoot.setNumLines(2);
        publicMethodsRoot.setPackageName("java.text");
        publicMethodsRoot.setParentId(1L);
        publicMethodsRoot.setQName("Q Name");
        publicMethodsRoot.setSourceScanned("Source Scanned");
        publicMethodsRoot.setTest("Test");
        publicMethodsRoot.setTestName("Test Name");
        publicMethodsRoot.setType("Type");

        Tarea testClassesRoot = new Tarea();
        testClassesRoot.setArguments("Arguments");
        testClassesRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        testClassesRoot.setChildren(new ArrayList<>());
        testClassesRoot.setClassName("Class Name");
        testClassesRoot.setContents("Not all who wander are lost");
        testClassesRoot.setCoverage(true);
        testClassesRoot.setFolderName("Folder Name");
        testClassesRoot.setId(1L);
        testClassesRoot.setLevel("Level");
        testClassesRoot.setMethodName("Method Name");
        testClassesRoot.setNumDependencies(3);
        testClassesRoot.setNumLines(2);
        testClassesRoot.setPackageName("java.text");
        testClassesRoot.setParentId(1L);
        testClassesRoot.setQName("Q Name");
        testClassesRoot.setSourceScanned("Source Scanned");
        testClassesRoot.setTest("Test");
        testClassesRoot.setTestName("Test Name");
        testClassesRoot.setType("Type");

        GitScanerInfo gitScanerInfo = new GitScanerInfo();
        gitScanerInfo.setClassNamePattern("Class Name Pattern");
        gitScanerInfo.setGitLabPath("Git Lab Path");
        gitScanerInfo.setPackageNamePattern("java.text");
        gitScanerInfo.setPublicMethodsRoot(publicMethodsRoot);
        gitScanerInfo.setRelease("1.0.2");
        gitScanerInfo.setTestClassesRoot(testClassesRoot);
        byte[] actualJavaMethodsCoverageReport = PdfUtil.getJavaMethodsCoverageReport(metodos, gitScanerInfo);
        assertEquals((byte) -29, actualJavaMethodsCoverageReport[11]);
        assertEquals((byte) -30, actualJavaMethodsCoverageReport[10]);
        assertEquals((byte) -45, actualJavaMethodsCoverageReport[13]);
        assertEquals((byte) -49, actualJavaMethodsCoverageReport[12]);
        assertEquals(' ', actualJavaMethodsCoverageReport[18]);
        assertEquals(' ', actualJavaMethodsCoverageReport[Short.SIZE]);
        assertEquals('%', actualJavaMethodsCoverageReport[0]);
        assertEquals('%', actualJavaMethodsCoverageReport[9]);
        assertEquals('-', actualJavaMethodsCoverageReport[4]);
        assertEquals('.', actualJavaMethodsCoverageReport[6]);
        assertEquals('0', actualJavaMethodsCoverageReport[17]);
        assertEquals('1', actualJavaMethodsCoverageReport[5]);
        assertEquals('3', actualJavaMethodsCoverageReport[15]);
        assertEquals('5', actualJavaMethodsCoverageReport[7]);
        assertEquals('<', actualJavaMethodsCoverageReport[23]);
        assertEquals('<', actualJavaMethodsCoverageReport[24]);
        assertEquals('D', actualJavaMethodsCoverageReport[2]);
        assertEquals('F', actualJavaMethodsCoverageReport[3]);
        assertEquals('P', actualJavaMethodsCoverageReport[1]);
        assertEquals('\n', actualJavaMethodsCoverageReport[14]);
        assertEquals('\n', actualJavaMethodsCoverageReport[22]);
        assertEquals('\n', actualJavaMethodsCoverageReport[8]);
        assertEquals('b', actualJavaMethodsCoverageReport[20]);
        assertEquals('j', actualJavaMethodsCoverageReport[21]);
        assertEquals('o', actualJavaMethodsCoverageReport[19]);
        assertEquals('t', actualJavaMethodsCoverageReport[1561]);
    }

    /**
     * Method under test:
     * {@link PdfUtil#getJavaMethodsCoverageReport(List, GitScanerInfo)}
     */
    @Test
    void testGetJavaMethodsCoverageReport28() throws DocumentException, UnsupportedEncodingException {
        Tarea tarea = new Tarea();
        tarea.setArguments("\t");
        tarea.setArrayOfBytes("A5A5A5A5".getBytes("UTF-8"));
        tarea.setChildren(new ArrayList<>());
        tarea.setClassName("\t");
        tarea.setContents("Not all who wander are lost");
        tarea.setCoverage(true);
        tarea.setFolderName("\t");
        tarea.setId(1L);
        tarea.setLevel("\t");
        tarea.setMethodName("(");
        tarea.setNumDependencies(3);
        tarea.setNumLines(2);
        tarea.setPackageName("java.text");
        tarea.setParentId(1L);
        tarea.setQName("\t");
        tarea.setSourceScanned("\t");
        tarea.setTest("\t");
        tarea.setTestName("\t");
        tarea.setType("\t");

        ArrayList<Tarea> metodos = new ArrayList<>();
        metodos.add(tarea);

        Tarea publicMethodsRoot = new Tarea();
        publicMethodsRoot.setArguments("Arguments");
        publicMethodsRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        publicMethodsRoot.setChildren(new ArrayList<>());
        publicMethodsRoot.setClassName("Class Name");
        publicMethodsRoot.setContents("Not all who wander are lost");
        publicMethodsRoot.setCoverage(true);
        publicMethodsRoot.setFolderName("Folder Name");
        publicMethodsRoot.setId(1L);
        publicMethodsRoot.setLevel("Level");
        publicMethodsRoot.setMethodName("Method Name");
        publicMethodsRoot.setNumDependencies(3);
        publicMethodsRoot.setNumLines(2);
        publicMethodsRoot.setPackageName("java.text");
        publicMethodsRoot.setParentId(1L);
        publicMethodsRoot.setQName("Q Name");
        publicMethodsRoot.setSourceScanned("Source Scanned");
        publicMethodsRoot.setTest("Test");
        publicMethodsRoot.setTestName("Test Name");
        publicMethodsRoot.setType("Type");

        Tarea testClassesRoot = new Tarea();
        testClassesRoot.setArguments("Arguments");
        testClassesRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        testClassesRoot.setChildren(new ArrayList<>());
        testClassesRoot.setClassName("Class Name");
        testClassesRoot.setContents("Not all who wander are lost");
        testClassesRoot.setCoverage(true);
        testClassesRoot.setFolderName("Folder Name");
        testClassesRoot.setId(1L);
        testClassesRoot.setLevel("Level");
        testClassesRoot.setMethodName("Method Name");
        testClassesRoot.setNumDependencies(3);
        testClassesRoot.setNumLines(2);
        testClassesRoot.setPackageName("java.text");
        testClassesRoot.setParentId(1L);
        testClassesRoot.setQName("Q Name");
        testClassesRoot.setSourceScanned("Source Scanned");
        testClassesRoot.setTest("Test");
        testClassesRoot.setTestName("Test Name");
        testClassesRoot.setType("Type");

        GitScanerInfo gitScanerInfo = new GitScanerInfo();
        gitScanerInfo.setClassNamePattern("Class Name Pattern");
        gitScanerInfo.setGitLabPath("Git Lab Path");
        gitScanerInfo.setPackageNamePattern("java.text");
        gitScanerInfo.setPublicMethodsRoot(publicMethodsRoot);
        gitScanerInfo.setRelease("1.0.2");
        gitScanerInfo.setTestClassesRoot(testClassesRoot);
        byte[] actualJavaMethodsCoverageReport = PdfUtil.getJavaMethodsCoverageReport(metodos, gitScanerInfo);
        assertEquals((byte) -29, actualJavaMethodsCoverageReport[11]);
        assertEquals((byte) -30, actualJavaMethodsCoverageReport[10]);
        assertEquals((byte) -45, actualJavaMethodsCoverageReport[13]);
        assertEquals((byte) -49, actualJavaMethodsCoverageReport[12]);
        assertEquals(' ', actualJavaMethodsCoverageReport[18]);
        assertEquals(' ', actualJavaMethodsCoverageReport[Short.SIZE]);
        assertEquals('%', actualJavaMethodsCoverageReport[0]);
        assertEquals('%', actualJavaMethodsCoverageReport[9]);
        assertEquals('-', actualJavaMethodsCoverageReport[4]);
        assertEquals('.', actualJavaMethodsCoverageReport[6]);
        assertEquals('0', actualJavaMethodsCoverageReport[17]);
        assertEquals('1', actualJavaMethodsCoverageReport[5]);
        assertEquals('3', actualJavaMethodsCoverageReport[15]);
        assertEquals('5', actualJavaMethodsCoverageReport[7]);
        assertEquals('<', actualJavaMethodsCoverageReport[23]);
        assertEquals('<', actualJavaMethodsCoverageReport[24]);
        assertEquals('D', actualJavaMethodsCoverageReport[2]);
        assertEquals('F', actualJavaMethodsCoverageReport[3]);
        assertEquals('P', actualJavaMethodsCoverageReport[1]);
        assertEquals('\n', actualJavaMethodsCoverageReport[14]);
        assertEquals('\n', actualJavaMethodsCoverageReport[22]);
        assertEquals('\n', actualJavaMethodsCoverageReport[8]);
        assertEquals('b', actualJavaMethodsCoverageReport[20]);
        assertEquals('j', actualJavaMethodsCoverageReport[21]);
        assertEquals('o', actualJavaMethodsCoverageReport[19]);
        assertEquals('t', actualJavaMethodsCoverageReport[1559]);
    }

    /**
     * Method under test:
     * {@link PdfUtil#getJavaMethodsCoverageReport(List, GitScanerInfo)}
     */
    @Test
    void testGetJavaMethodsCoverageReport29() throws DocumentException, UnsupportedEncodingException {
        Tarea tarea = new Tarea();
        tarea.setArguments(")");
        tarea.setArrayOfBytes("A5A5A5A5".getBytes("UTF-8"));
        tarea.setChildren(new ArrayList<>());
        tarea.setClassName("\t");
        tarea.setContents("Not all who wander are lost");
        tarea.setCoverage(true);
        tarea.setFolderName("\t");
        tarea.setId(1L);
        tarea.setLevel("\t");
        tarea.setMethodName("\t");
        tarea.setNumDependencies(3);
        tarea.setNumLines(2);
        tarea.setPackageName("java.text");
        tarea.setParentId(1L);
        tarea.setQName("\t");
        tarea.setSourceScanned("\t");
        tarea.setTest("\t");
        tarea.setTestName("\t");
        tarea.setType("\t");

        ArrayList<Tarea> metodos = new ArrayList<>();
        metodos.add(tarea);

        Tarea publicMethodsRoot = new Tarea();
        publicMethodsRoot.setArguments("Arguments");
        publicMethodsRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        publicMethodsRoot.setChildren(new ArrayList<>());
        publicMethodsRoot.setClassName("Class Name");
        publicMethodsRoot.setContents("Not all who wander are lost");
        publicMethodsRoot.setCoverage(true);
        publicMethodsRoot.setFolderName("Folder Name");
        publicMethodsRoot.setId(1L);
        publicMethodsRoot.setLevel("Level");
        publicMethodsRoot.setMethodName("Method Name");
        publicMethodsRoot.setNumDependencies(3);
        publicMethodsRoot.setNumLines(2);
        publicMethodsRoot.setPackageName("java.text");
        publicMethodsRoot.setParentId(1L);
        publicMethodsRoot.setQName("Q Name");
        publicMethodsRoot.setSourceScanned("Source Scanned");
        publicMethodsRoot.setTest("Test");
        publicMethodsRoot.setTestName("Test Name");
        publicMethodsRoot.setType("Type");

        Tarea testClassesRoot = new Tarea();
        testClassesRoot.setArguments("Arguments");
        testClassesRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        testClassesRoot.setChildren(new ArrayList<>());
        testClassesRoot.setClassName("Class Name");
        testClassesRoot.setContents("Not all who wander are lost");
        testClassesRoot.setCoverage(true);
        testClassesRoot.setFolderName("Folder Name");
        testClassesRoot.setId(1L);
        testClassesRoot.setLevel("Level");
        testClassesRoot.setMethodName("Method Name");
        testClassesRoot.setNumDependencies(3);
        testClassesRoot.setNumLines(2);
        testClassesRoot.setPackageName("java.text");
        testClassesRoot.setParentId(1L);
        testClassesRoot.setQName("Q Name");
        testClassesRoot.setSourceScanned("Source Scanned");
        testClassesRoot.setTest("Test");
        testClassesRoot.setTestName("Test Name");
        testClassesRoot.setType("Type");

        GitScanerInfo gitScanerInfo = new GitScanerInfo();
        gitScanerInfo.setClassNamePattern("Class Name Pattern");
        gitScanerInfo.setGitLabPath("Git Lab Path");
        gitScanerInfo.setPackageNamePattern("java.text");
        gitScanerInfo.setPublicMethodsRoot(publicMethodsRoot);
        gitScanerInfo.setRelease("1.0.2");
        gitScanerInfo.setTestClassesRoot(testClassesRoot);
        byte[] actualJavaMethodsCoverageReport = PdfUtil.getJavaMethodsCoverageReport(metodos, gitScanerInfo);
        assertEquals((byte) -29, actualJavaMethodsCoverageReport[11]);
        assertEquals((byte) -30, actualJavaMethodsCoverageReport[10]);
        assertEquals((byte) -45, actualJavaMethodsCoverageReport[13]);
        assertEquals((byte) -49, actualJavaMethodsCoverageReport[12]);
        assertEquals(' ', actualJavaMethodsCoverageReport[18]);
        assertEquals(' ', actualJavaMethodsCoverageReport[Short.SIZE]);
        assertEquals('%', actualJavaMethodsCoverageReport[0]);
        assertEquals('%', actualJavaMethodsCoverageReport[9]);
        assertEquals('-', actualJavaMethodsCoverageReport[4]);
        assertEquals('.', actualJavaMethodsCoverageReport[6]);
        assertEquals('0', actualJavaMethodsCoverageReport[17]);
        assertEquals('1', actualJavaMethodsCoverageReport[5]);
        assertEquals('3', actualJavaMethodsCoverageReport[15]);
        assertEquals('5', actualJavaMethodsCoverageReport[7]);
        assertEquals('<', actualJavaMethodsCoverageReport[23]);
        assertEquals('<', actualJavaMethodsCoverageReport[24]);
        assertEquals('D', actualJavaMethodsCoverageReport[2]);
        assertEquals('F', actualJavaMethodsCoverageReport[3]);
        assertEquals('P', actualJavaMethodsCoverageReport[1]);
        assertEquals('\n', actualJavaMethodsCoverageReport[14]);
        assertEquals('\n', actualJavaMethodsCoverageReport[22]);
        assertEquals('\n', actualJavaMethodsCoverageReport[8]);
        assertEquals('b', actualJavaMethodsCoverageReport[20]);
        assertEquals('j', actualJavaMethodsCoverageReport[21]);
        assertEquals('o', actualJavaMethodsCoverageReport[19]);
        assertEquals('t', actualJavaMethodsCoverageReport[1562]);
    }

    /**
     * Method under test:
     * {@link PdfUtil#getJavaMethodsCoverageReport(List, GitScanerInfo)}
     */
    @Test
    void testGetJavaMethodsCoverageReport30() throws DocumentException, UnsupportedEncodingException {
        Tarea tarea = new Tarea();
        tarea.setArguments("\t");
        tarea.setArrayOfBytes("A5A5A5A5".getBytes("UTF-8"));
        tarea.setChildren(new ArrayList<>());
        tarea.setClassName("\t");
        tarea.setContents("Not all who wander are lost");
        tarea.setCoverage(true);
        tarea.setFolderName("\t");
        tarea.setId(1L);
        tarea.setLevel("\t");
        tarea.setMethodName(")");
        tarea.setNumDependencies(3);
        tarea.setNumLines(2);
        tarea.setPackageName("java.text");
        tarea.setParentId(1L);
        tarea.setQName("\t");
        tarea.setSourceScanned("\t");
        tarea.setTest("\t");
        tarea.setTestName("\t");
        tarea.setType("\t");

        ArrayList<Tarea> metodos = new ArrayList<>();
        metodos.add(tarea);

        Tarea publicMethodsRoot = new Tarea();
        publicMethodsRoot.setArguments("Arguments");
        publicMethodsRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        publicMethodsRoot.setChildren(new ArrayList<>());
        publicMethodsRoot.setClassName("Class Name");
        publicMethodsRoot.setContents("Not all who wander are lost");
        publicMethodsRoot.setCoverage(true);
        publicMethodsRoot.setFolderName("Folder Name");
        publicMethodsRoot.setId(1L);
        publicMethodsRoot.setLevel("Level");
        publicMethodsRoot.setMethodName("Method Name");
        publicMethodsRoot.setNumDependencies(3);
        publicMethodsRoot.setNumLines(2);
        publicMethodsRoot.setPackageName("java.text");
        publicMethodsRoot.setParentId(1L);
        publicMethodsRoot.setQName("Q Name");
        publicMethodsRoot.setSourceScanned("Source Scanned");
        publicMethodsRoot.setTest("Test");
        publicMethodsRoot.setTestName("Test Name");
        publicMethodsRoot.setType("Type");

        Tarea testClassesRoot = new Tarea();
        testClassesRoot.setArguments("Arguments");
        testClassesRoot.setArrayOfBytes("AXAXAXAX".getBytes("UTF-8"));
        testClassesRoot.setChildren(new ArrayList<>());
        testClassesRoot.setClassName("Class Name");
        testClassesRoot.setContents("Not all who wander are lost");
        testClassesRoot.setCoverage(true);
        testClassesRoot.setFolderName("Folder Name");
        testClassesRoot.setId(1L);
        testClassesRoot.setLevel("Level");
        testClassesRoot.setMethodName("Method Name");
        testClassesRoot.setNumDependencies(3);
        testClassesRoot.setNumLines(2);
        testClassesRoot.setPackageName("java.text");
        testClassesRoot.setParentId(1L);
        testClassesRoot.setQName("Q Name");
        testClassesRoot.setSourceScanned("Source Scanned");
        testClassesRoot.setTest("Test");
        testClassesRoot.setTestName("Test Name");
        testClassesRoot.setType("Type");

        GitScanerInfo gitScanerInfo = new GitScanerInfo();
        gitScanerInfo.setClassNamePattern("Class Name Pattern");
        gitScanerInfo.setGitLabPath("Git Lab Path");
        gitScanerInfo.setPackageNamePattern("java.text");
        gitScanerInfo.setPublicMethodsRoot(publicMethodsRoot);
        gitScanerInfo.setRelease("1.0.2");
        gitScanerInfo.setTestClassesRoot(testClassesRoot);
        byte[] actualJavaMethodsCoverageReport = PdfUtil.getJavaMethodsCoverageReport(metodos, gitScanerInfo);
        assertEquals((byte) -29, actualJavaMethodsCoverageReport[11]);
        assertEquals((byte) -30, actualJavaMethodsCoverageReport[10]);
        assertEquals((byte) -45, actualJavaMethodsCoverageReport[13]);
        assertEquals((byte) -49, actualJavaMethodsCoverageReport[12]);
        assertEquals(' ', actualJavaMethodsCoverageReport[18]);
        assertEquals(' ', actualJavaMethodsCoverageReport[Short.SIZE]);
        assertEquals('%', actualJavaMethodsCoverageReport[0]);
        assertEquals('%', actualJavaMethodsCoverageReport[9]);
        assertEquals('-', actualJavaMethodsCoverageReport[4]);
        assertEquals('.', actualJavaMethodsCoverageReport[6]);
        assertEquals('0', actualJavaMethodsCoverageReport[17]);
        assertEquals('1', actualJavaMethodsCoverageReport[5]);
        assertEquals('3', actualJavaMethodsCoverageReport[15]);
        assertEquals('5', actualJavaMethodsCoverageReport[7]);
        assertEquals('<', actualJavaMethodsCoverageReport[23]);
        assertEquals('<', actualJavaMethodsCoverageReport[24]);
        assertEquals('D', actualJavaMethodsCoverageReport[2]);
        assertEquals('F', actualJavaMethodsCoverageReport[3]);
        assertEquals('P', actualJavaMethodsCoverageReport[1]);
        assertEquals('\n', actualJavaMethodsCoverageReport[14]);
        assertEquals('\n', actualJavaMethodsCoverageReport[22]);
        assertEquals('\n', actualJavaMethodsCoverageReport[8]);
        assertEquals('b', actualJavaMethodsCoverageReport[20]);
        assertEquals('j', actualJavaMethodsCoverageReport[21]);
        assertEquals('o', actualJavaMethodsCoverageReport[19]);
        assertEquals('t', actualJavaMethodsCoverageReport[1561]);
    }
}
