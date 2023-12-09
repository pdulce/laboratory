package giss.mad.itinerario.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.itextpdf.text.DocumentException;
import giss.mad.itinerario.model.itinerario.Configuracion;
import giss.mad.itinerario.model.volatilentities.GitScanerInfo;
import giss.mad.itinerario.model.volatilentities.Tarea;
import giss.mad.itinerario.repository.itinerario.ConfiguracionRepository;
import giss.mad.itinerario.util.IClassGenerator;
import giss.mad.itinerario.util.SimpleClassGenerator;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {GitLabAccessService.class})
@ActiveProfiles({"test"})
@ExtendWith(SpringExtension.class)
class GitLabAccessServiceDiffblueTest {
    @MockBean
    private ConfiguracionRepository configuracionRepository;

    @Autowired
    private GitLabAccessService gitLabAccessService;

    /**
     * Method under test:
     * {@link GitLabAccessService#scanRepository(GitScanerInfo, IClassGenerator)}
     */
    @Test
    void testScanRepository() throws Exception {
        Configuracion configuracion = new Configuracion();
        configuracion.setCreationDate(mock(Timestamp.class));
        configuracion.setDeleted(1);
        configuracion.setDescription("The characteristics of someone or something");
        configuracion.setId(1);
        configuracion.setKey("Key");
        configuracion.setUpdateDate(mock(Timestamp.class));
        configuracion.setValue("42");
        when(configuracionRepository.findByKeyAndDeletedIsNull(Mockito.<String>any())).thenReturn(configuracion);

        Tarea publicMethodsRoot = new Tarea();
        publicMethodsRoot.setArguments("Arguments");
        publicMethodsRoot.setByteArrayCompressed("AXAXAXAX".getBytes("UTF-8"));
        publicMethodsRoot.setChildren(new ArrayList<>());
        publicMethodsRoot.setClassName("Class Name");
        publicMethodsRoot.setContents("Not all who wander are lost");
        publicMethodsRoot.setCoverage(true);
        publicMethodsRoot.setFolderName("Folder Name");
        publicMethodsRoot.setImports(new ArrayList<>());
        publicMethodsRoot.setLevel("Level");
        publicMethodsRoot.setMemberDeclarations(new ArrayList<>());
        publicMethodsRoot.setMethodName("Method Name");
        publicMethodsRoot.setName("Name");
        publicMethodsRoot.setNumDependencies(3);
        publicMethodsRoot.setNumLines(2);
        publicMethodsRoot.setPackageName("java.text");
        publicMethodsRoot.setReturnType("Return Type");
        publicMethodsRoot.setSourceScanned("Source Scanned");
        publicMethodsRoot.setTest("Test");

        Tarea testClassesRoot = new Tarea();
        testClassesRoot.setArguments("Arguments");
        testClassesRoot.setByteArrayCompressed("AXAXAXAX".getBytes("UTF-8"));
        testClassesRoot.setChildren(new ArrayList<>());
        testClassesRoot.setClassName("Class Name");
        testClassesRoot.setContents("Not all who wander are lost");
        testClassesRoot.setCoverage(true);
        testClassesRoot.setFolderName("Folder Name");
        testClassesRoot.setImports(new ArrayList<>());
        testClassesRoot.setLevel("Level");
        testClassesRoot.setMemberDeclarations(new ArrayList<>());
        testClassesRoot.setMethodName("Method Name");
        testClassesRoot.setName("Name");
        testClassesRoot.setNumDependencies(3);
        testClassesRoot.setNumLines(2);
        testClassesRoot.setPackageName("java.text");
        testClassesRoot.setReturnType("Return Type");
        testClassesRoot.setSourceScanned("Source Scanned");
        testClassesRoot.setTest("Test");

        GitScanerInfo gitScanerInfo = new GitScanerInfo();
        gitScanerInfo.setClassNamePattern("Class Name Pattern");
        gitScanerInfo.setGitLabPath("Git Lab Path");
        gitScanerInfo.setPackageNamePattern("java.text");
        gitScanerInfo.setPublicMethodsRoot(publicMethodsRoot);
        gitScanerInfo.setRelease("1.0.2");
        gitScanerInfo.setTestClassesRoot(testClassesRoot);
        assertThrows(Exception.class, () -> gitLabAccessService.scanRepository(gitScanerInfo, new SimpleClassGenerator()));
        verify(configuracionRepository, atLeast(1)).findByKeyAndDeletedIsNull(Mockito.<String>any());
    }

    /**
     * Method under test:
     * {@link GitLabAccessService#scanMethodTestCoverage(GitScanerInfo, IClassGenerator)}
     */
    @Test
    void testScanMethodTestCoverage() throws Exception {
        Configuracion configuracion = new Configuracion();
        configuracion.setCreationDate(mock(Timestamp.class));
        configuracion.setDeleted(1);
        configuracion.setDescription("The characteristics of someone or something");
        configuracion.setId(1);
        configuracion.setKey("Key");
        configuracion.setUpdateDate(mock(Timestamp.class));
        configuracion.setValue("42");
        when(configuracionRepository.findByKeyAndDeletedIsNull(Mockito.<String>any())).thenReturn(configuracion);

        Tarea publicMethodsRoot = new Tarea();
        publicMethodsRoot.setArguments("Arguments");
        publicMethodsRoot.setByteArrayCompressed("AXAXAXAX".getBytes("UTF-8"));
        publicMethodsRoot.setChildren(new ArrayList<>());
        publicMethodsRoot.setClassName("Class Name");
        publicMethodsRoot.setContents("Not all who wander are lost");
        publicMethodsRoot.setCoverage(true);
        publicMethodsRoot.setFolderName("Folder Name");
        publicMethodsRoot.setImports(new ArrayList<>());
        publicMethodsRoot.setLevel("Level");
        publicMethodsRoot.setMemberDeclarations(new ArrayList<>());
        publicMethodsRoot.setMethodName("Method Name");
        publicMethodsRoot.setName("Name");
        publicMethodsRoot.setNumDependencies(3);
        publicMethodsRoot.setNumLines(2);
        publicMethodsRoot.setPackageName("java.text");
        publicMethodsRoot.setReturnType("Return Type");
        publicMethodsRoot.setSourceScanned("Source Scanned");
        publicMethodsRoot.setTest("Test");

        Tarea testClassesRoot = new Tarea();
        testClassesRoot.setArguments("Arguments");
        testClassesRoot.setByteArrayCompressed("AXAXAXAX".getBytes("UTF-8"));
        testClassesRoot.setChildren(new ArrayList<>());
        testClassesRoot.setClassName("Class Name");
        testClassesRoot.setContents("Not all who wander are lost");
        testClassesRoot.setCoverage(true);
        testClassesRoot.setFolderName("Folder Name");
        testClassesRoot.setImports(new ArrayList<>());
        testClassesRoot.setLevel("Level");
        testClassesRoot.setMemberDeclarations(new ArrayList<>());
        testClassesRoot.setMethodName("Method Name");
        testClassesRoot.setName("Name");
        testClassesRoot.setNumDependencies(3);
        testClassesRoot.setNumLines(2);
        testClassesRoot.setPackageName("java.text");
        testClassesRoot.setReturnType("Return Type");
        testClassesRoot.setSourceScanned("Source Scanned");
        testClassesRoot.setTest("Test");

        GitScanerInfo gitScanerInfo = new GitScanerInfo();
        gitScanerInfo.setClassNamePattern("Class Name Pattern");
        gitScanerInfo.setGitLabPath("Git Lab Path");
        gitScanerInfo.setPackageNamePattern("java.text");
        gitScanerInfo.setPublicMethodsRoot(publicMethodsRoot);
        gitScanerInfo.setRelease("1.0.2");
        gitScanerInfo.setTestClassesRoot(testClassesRoot);
        assertThrows(Exception.class,
                () -> gitLabAccessService.scanMethodTestCoverage(gitScanerInfo, new SimpleClassGenerator()));
        verify(configuracionRepository, atLeast(1)).findByKeyAndDeletedIsNull(Mockito.<String>any());
    }

    /**
     * Method under test:
     * {@link GitLabAccessService#scanMethodTestCoverage(GitScanerInfo, IClassGenerator)}
     */
    @Test
    void testScanMethodTestCoverage2() throws Exception {
        Configuracion configuracion = mock(Configuracion.class);
        when(configuracion.getValue()).thenReturn("42");
        doNothing().when(configuracion).setCreationDate(Mockito.<Timestamp>any());
        doNothing().when(configuracion).setDeleted(Mockito.<Integer>any());
        doNothing().when(configuracion).setDescription(Mockito.<String>any());
        doNothing().when(configuracion).setId(Mockito.<Integer>any());
        doNothing().when(configuracion).setKey(Mockito.<String>any());
        doNothing().when(configuracion).setUpdateDate(Mockito.<Timestamp>any());
        doNothing().when(configuracion).setValue(Mockito.<String>any());
        configuracion.setCreationDate(mock(Timestamp.class));
        configuracion.setDeleted(1);
        configuracion.setDescription("The characteristics of someone or something");
        configuracion.setId(1);
        configuracion.setKey("Key");
        configuracion.setUpdateDate(mock(Timestamp.class));
        configuracion.setValue("42");
        when(configuracionRepository.findByKeyAndDeletedIsNull(Mockito.<String>any())).thenReturn(configuracion);

        Tarea publicMethodsRoot = new Tarea();
        publicMethodsRoot.setArguments("Arguments");
        publicMethodsRoot.setByteArrayCompressed("AXAXAXAX".getBytes("UTF-8"));
        publicMethodsRoot.setChildren(new ArrayList<>());
        publicMethodsRoot.setClassName("Class Name");
        publicMethodsRoot.setContents("Not all who wander are lost");
        publicMethodsRoot.setCoverage(true);
        publicMethodsRoot.setFolderName("Folder Name");
        publicMethodsRoot.setImports(new ArrayList<>());
        publicMethodsRoot.setLevel("Level");
        publicMethodsRoot.setMemberDeclarations(new ArrayList<>());
        publicMethodsRoot.setMethodName("Method Name");
        publicMethodsRoot.setName("Name");
        publicMethodsRoot.setNumDependencies(3);
        publicMethodsRoot.setNumLines(2);
        publicMethodsRoot.setPackageName("java.text");
        publicMethodsRoot.setReturnType("Return Type");
        publicMethodsRoot.setSourceScanned("Source Scanned");
        publicMethodsRoot.setTest("Test");

        Tarea testClassesRoot = new Tarea();
        testClassesRoot.setArguments("Arguments");
        testClassesRoot.setByteArrayCompressed("AXAXAXAX".getBytes("UTF-8"));
        testClassesRoot.setChildren(new ArrayList<>());
        testClassesRoot.setClassName("Class Name");
        testClassesRoot.setContents("Not all who wander are lost");
        testClassesRoot.setCoverage(true);
        testClassesRoot.setFolderName("Folder Name");
        testClassesRoot.setImports(new ArrayList<>());
        testClassesRoot.setLevel("Level");
        testClassesRoot.setMemberDeclarations(new ArrayList<>());
        testClassesRoot.setMethodName("Method Name");
        testClassesRoot.setName("Name");
        testClassesRoot.setNumDependencies(3);
        testClassesRoot.setNumLines(2);
        testClassesRoot.setPackageName("java.text");
        testClassesRoot.setReturnType("Return Type");
        testClassesRoot.setSourceScanned("Source Scanned");
        testClassesRoot.setTest("Test");

        GitScanerInfo gitScanerInfo = new GitScanerInfo();
        gitScanerInfo.setClassNamePattern("Class Name Pattern");
        gitScanerInfo.setGitLabPath("Git Lab Path");
        gitScanerInfo.setPackageNamePattern("java.text");
        gitScanerInfo.setPublicMethodsRoot(publicMethodsRoot);
        gitScanerInfo.setRelease("1.0.2");
        gitScanerInfo.setTestClassesRoot(testClassesRoot);
        assertThrows(Exception.class,
                () -> gitLabAccessService.scanMethodTestCoverage(gitScanerInfo, new SimpleClassGenerator()));
        verify(configuracion, atLeast(1)).getValue();
        verify(configuracion).setCreationDate(Mockito.<Timestamp>any());
        verify(configuracion).setDeleted(Mockito.<Integer>any());
        verify(configuracion).setDescription(Mockito.<String>any());
        verify(configuracion).setId(Mockito.<Integer>any());
        verify(configuracion).setKey(Mockito.<String>any());
        verify(configuracion).setUpdateDate(Mockito.<Timestamp>any());
        verify(configuracion).setValue(Mockito.<String>any());
        verify(configuracionRepository, atLeast(1)).findByKeyAndDeletedIsNull(Mockito.<String>any());
    }

    /**
     * Method under test:
     * {@link GitLabAccessService#analysisCoverageOfPublicMethods(GitScanerInfo)}
     */
    @Test
    void testAnalysisCoverageOfPublicMethods() throws DocumentException, IOException {
        Tarea publicMethodsRoot = new Tarea();
        publicMethodsRoot.setArguments("Arguments");
        publicMethodsRoot.setByteArrayCompressed("AXAXAXAX".getBytes("UTF-8"));
        publicMethodsRoot.setChildren(new ArrayList<>());
        publicMethodsRoot.setClassName("Class Name");
        publicMethodsRoot.setContents("Not all who wander are lost");
        publicMethodsRoot.setCoverage(true);
        publicMethodsRoot.setFolderName("Folder Name");
        publicMethodsRoot.setImports(new ArrayList<>());
        publicMethodsRoot.setLevel("Level");
        publicMethodsRoot.setMemberDeclarations(new ArrayList<>());
        publicMethodsRoot.setMethodName("Method Name");
        publicMethodsRoot.setName("Name");
        publicMethodsRoot.setNumDependencies(3);
        publicMethodsRoot.setNumLines(2);
        publicMethodsRoot.setPackageName("java.text");
        publicMethodsRoot.setReturnType("Return Type");
        publicMethodsRoot.setSourceScanned("Source Scanned");
        publicMethodsRoot.setTest("Test");

        Tarea testClassesRoot = new Tarea();
        testClassesRoot.setArguments("Arguments");
        testClassesRoot.setByteArrayCompressed("AXAXAXAX".getBytes("UTF-8"));
        testClassesRoot.setChildren(new ArrayList<>());
        testClassesRoot.setClassName("Class Name");
        testClassesRoot.setContents("Not all who wander are lost");
        testClassesRoot.setCoverage(true);
        testClassesRoot.setFolderName("Folder Name");
        testClassesRoot.setImports(new ArrayList<>());
        testClassesRoot.setLevel("Level");
        testClassesRoot.setMemberDeclarations(new ArrayList<>());
        testClassesRoot.setMethodName("Method Name");
        testClassesRoot.setName("Name");
        testClassesRoot.setNumDependencies(3);
        testClassesRoot.setNumLines(2);
        testClassesRoot.setPackageName("java.text");
        testClassesRoot.setReturnType("Return Type");
        testClassesRoot.setSourceScanned("Source Scanned");
        testClassesRoot.setTest("Test");

        GitScanerInfo gitScanerInfo = new GitScanerInfo();
        gitScanerInfo.setClassNamePattern("Class Name Pattern");
        gitScanerInfo.setGitLabPath("Git Lab Path");
        gitScanerInfo.setPackageNamePattern("java.text");
        gitScanerInfo.setPublicMethodsRoot(publicMethodsRoot);
        gitScanerInfo.setRelease("1.0.2");
        gitScanerInfo.setTestClassesRoot(testClassesRoot);
        Tarea actualAnalysisCoverageOfPublicMethodsResult = gitLabAccessService
                .analysisCoverageOfPublicMethods(gitScanerInfo);
        assertEquals("carpeta", actualAnalysisCoverageOfPublicMethodsResult.getLevel());
        assertEquals('%', actualAnalysisCoverageOfPublicMethodsResult.getByteArrayCompressed()[0]);
    }

    /**
     * Method under test:
     * {@link GitLabAccessService#analysisCoverageOfPublicMethods(GitScanerInfo)}
     */
    @Test
    void testAnalysisCoverageOfPublicMethods2() throws DocumentException, IOException {
        Tarea publicMethodsRoot = new Tarea();
        publicMethodsRoot.setArguments("Arguments");
        publicMethodsRoot.setByteArrayCompressed("AXAXAXAX".getBytes("UTF-8"));
        publicMethodsRoot.setChildren(new ArrayList<>());
        publicMethodsRoot.setClassName("Class Name");
        publicMethodsRoot.setContents("Not all who wander are lost");
        publicMethodsRoot.setCoverage(true);
        publicMethodsRoot.setFolderName("Folder Name");
        publicMethodsRoot.setImports(new ArrayList<>());
        publicMethodsRoot.setLevel("Level");
        publicMethodsRoot.setMemberDeclarations(new ArrayList<>());
        publicMethodsRoot.setMethodName("Method Name");
        publicMethodsRoot.setName("Name");
        publicMethodsRoot.setNumDependencies(3);
        publicMethodsRoot.setNumLines(2);
        publicMethodsRoot.setPackageName("java.text");
        publicMethodsRoot.setReturnType("Return Type");
        publicMethodsRoot.setSourceScanned("Source Scanned");
        publicMethodsRoot.setTest("Test");

        Tarea testClassesRoot = new Tarea();
        testClassesRoot.setArguments("Arguments");
        testClassesRoot.setByteArrayCompressed("AXAXAXAX".getBytes("UTF-8"));
        testClassesRoot.setChildren(new ArrayList<>());
        testClassesRoot.setClassName("Class Name");
        testClassesRoot.setContents("Not all who wander are lost");
        testClassesRoot.setCoverage(true);
        testClassesRoot.setFolderName("Folder Name");
        testClassesRoot.setImports(new ArrayList<>());
        testClassesRoot.setLevel("Level");
        testClassesRoot.setMemberDeclarations(new ArrayList<>());
        testClassesRoot.setMethodName("Method Name");
        testClassesRoot.setName("Name");
        testClassesRoot.setNumDependencies(3);
        testClassesRoot.setNumLines(2);
        testClassesRoot.setPackageName("java.text");
        testClassesRoot.setReturnType("Return Type");
        testClassesRoot.setSourceScanned("Source Scanned");
        testClassesRoot.setTest("Test");

        Tarea tarea = new Tarea();
        tarea.setArguments("Arguments");
        tarea.setByteArrayCompressed("AXAXAXAX".getBytes("UTF-8"));
        tarea.setChildren(new ArrayList<>());
        tarea.setClassName("Class Name");
        tarea.setContents("Not all who wander are lost");
        tarea.setCoverage(true);
        tarea.setFolderName("Folder Name");
        tarea.setImports(new ArrayList<>());
        tarea.setLevel("Level");
        tarea.setMemberDeclarations(new ArrayList<>());
        tarea.setMethodName("Method Name");
        tarea.setName("Name");
        tarea.setNumDependencies(3);
        tarea.setNumLines(2);
        tarea.setPackageName("java.text");
        tarea.setReturnType("Return Type");
        tarea.setSourceScanned("Source Scanned");
        tarea.setTest("Test");

        Tarea tarea2 = new Tarea();
        tarea2.setArguments("Arguments");
        tarea2.setByteArrayCompressed("AXAXAXAX".getBytes("UTF-8"));
        tarea2.setChildren(new ArrayList<>());
        tarea2.setClassName("Class Name");
        tarea2.setContents("Not all who wander are lost");
        tarea2.setCoverage(true);
        tarea2.setFolderName("Folder Name");
        tarea2.setImports(new ArrayList<>());
        tarea2.setLevel("Level");
        tarea2.setMemberDeclarations(new ArrayList<>());
        tarea2.setMethodName("Method Name");
        tarea2.setName("Name");
        tarea2.setNumDependencies(3);
        tarea2.setNumLines(2);
        tarea2.setPackageName("java.text");
        tarea2.setReturnType("Return Type");
        tarea2.setSourceScanned("Source Scanned");
        tarea2.setTest("Test");
        GitScanerInfo gitScanerInfo = mock(GitScanerInfo.class);
        when(gitScanerInfo.getRelease()).thenReturn("1.0.2");
        when(gitScanerInfo.getTestClassesRoot()).thenReturn(tarea2);
        when(gitScanerInfo.getPublicMethodsRoot()).thenReturn(tarea);
        doNothing().when(gitScanerInfo).setClassNamePattern(Mockito.<String>any());
        doNothing().when(gitScanerInfo).setGitLabPath(Mockito.<String>any());
        doNothing().when(gitScanerInfo).setPackageNamePattern(Mockito.<String>any());
        doNothing().when(gitScanerInfo).setPublicMethodsRoot(Mockito.<Tarea>any());
        doNothing().when(gitScanerInfo).setRelease(Mockito.<String>any());
        doNothing().when(gitScanerInfo).setTestClassesRoot(Mockito.<Tarea>any());
        gitScanerInfo.setClassNamePattern("Class Name Pattern");
        gitScanerInfo.setGitLabPath("Git Lab Path");
        gitScanerInfo.setPackageNamePattern("java.text");
        gitScanerInfo.setPublicMethodsRoot(publicMethodsRoot);
        gitScanerInfo.setRelease("1.0.2");
        gitScanerInfo.setTestClassesRoot(testClassesRoot);
        Tarea actualAnalysisCoverageOfPublicMethodsResult = gitLabAccessService
                .analysisCoverageOfPublicMethods(gitScanerInfo);
        verify(gitScanerInfo).getPublicMethodsRoot();
        verify(gitScanerInfo, atLeast(1)).getRelease();
        verify(gitScanerInfo).getTestClassesRoot();
        verify(gitScanerInfo).setClassNamePattern(Mockito.<String>any());
        verify(gitScanerInfo).setGitLabPath(Mockito.<String>any());
        verify(gitScanerInfo).setPackageNamePattern(Mockito.<String>any());
        verify(gitScanerInfo).setPublicMethodsRoot(Mockito.<Tarea>any());
        verify(gitScanerInfo).setRelease(Mockito.<String>any());
        verify(gitScanerInfo).setTestClassesRoot(Mockito.<Tarea>any());
        assertEquals("carpeta", actualAnalysisCoverageOfPublicMethodsResult.getLevel());
        assertEquals('%', actualAnalysisCoverageOfPublicMethodsResult.getByteArrayCompressed()[0]);
    }

    /**
     * Method under test:
     * {@link GitLabAccessService#analysisCoverageOfPublicMethods(GitScanerInfo)}
     */
    @Test
    void testAnalysisCoverageOfPublicMethods3() throws DocumentException, IOException {
        Tarea publicMethodsRoot = new Tarea();
        publicMethodsRoot.setArguments("Arguments");
        publicMethodsRoot.setByteArrayCompressed("AXAXAXAX".getBytes("UTF-8"));
        publicMethodsRoot.setChildren(new ArrayList<>());
        publicMethodsRoot.setClassName("Class Name");
        publicMethodsRoot.setContents("Not all who wander are lost");
        publicMethodsRoot.setCoverage(true);
        publicMethodsRoot.setFolderName("Folder Name");
        publicMethodsRoot.setImports(new ArrayList<>());
        publicMethodsRoot.setLevel("Level");
        publicMethodsRoot.setMemberDeclarations(new ArrayList<>());
        publicMethodsRoot.setMethodName("Method Name");
        publicMethodsRoot.setName("Name");
        publicMethodsRoot.setNumDependencies(3);
        publicMethodsRoot.setNumLines(2);
        publicMethodsRoot.setPackageName("java.text");
        publicMethodsRoot.setReturnType("Return Type");
        publicMethodsRoot.setSourceScanned("Source Scanned");
        publicMethodsRoot.setTest("Test");

        Tarea testClassesRoot = new Tarea();
        testClassesRoot.setArguments("Arguments");
        testClassesRoot.setByteArrayCompressed("AXAXAXAX".getBytes("UTF-8"));
        testClassesRoot.setChildren(new ArrayList<>());
        testClassesRoot.setClassName("Class Name");
        testClassesRoot.setContents("Not all who wander are lost");
        testClassesRoot.setCoverage(true);
        testClassesRoot.setFolderName("Folder Name");
        testClassesRoot.setImports(new ArrayList<>());
        testClassesRoot.setLevel("Level");
        testClassesRoot.setMemberDeclarations(new ArrayList<>());
        testClassesRoot.setMethodName("Method Name");
        testClassesRoot.setName("Name");
        testClassesRoot.setNumDependencies(3);
        testClassesRoot.setNumLines(2);
        testClassesRoot.setPackageName("java.text");
        testClassesRoot.setReturnType("Return Type");
        testClassesRoot.setSourceScanned("Source Scanned");
        testClassesRoot.setTest("Test");

        Tarea tarea = new Tarea();
        tarea.setArguments("Arguments");
        tarea.setByteArrayCompressed("AXAXAXAX".getBytes("UTF-8"));
        tarea.setChildren(new ArrayList<>());
        tarea.setClassName("Class Name");
        tarea.setContents("Not all who wander are lost");
        tarea.setCoverage(true);
        tarea.setFolderName("Folder Name");
        tarea.setImports(new ArrayList<>());
        tarea.setLevel("Level");
        tarea.setMemberDeclarations(new ArrayList<>());
        tarea.setMethodName("Method Name");
        tarea.setName("Name");
        tarea.setNumDependencies(3);
        tarea.setNumLines(2);
        tarea.setPackageName("java.text");
        tarea.setReturnType("Return Type");
        tarea.setSourceScanned("Source Scanned");
        tarea.setTest("Test");

        Tarea tarea2 = new Tarea();
        tarea2.setArguments("Arguments");
        tarea2.setByteArrayCompressed("AXAXAXAX".getBytes("UTF-8"));
        tarea2.setChildren(new ArrayList<>());
        tarea2.setClassName("Class Name");
        tarea2.setContents("Not all who wander are lost");
        tarea2.setCoverage(true);
        tarea2.setFolderName("Folder Name");
        tarea2.setImports(new ArrayList<>());
        tarea2.setLevel("Level");
        tarea2.setMemberDeclarations(new ArrayList<>());
        tarea2.setMethodName("Method Name");
        tarea2.setName("Name");
        tarea2.setNumDependencies(3);
        tarea2.setNumLines(2);
        tarea2.setPackageName("java.text");
        tarea2.setReturnType("Return Type");
        tarea2.setSourceScanned("Source Scanned");
        tarea2.setTest("Test");
        GitScanerInfo gitScanerInfo = mock(GitScanerInfo.class);
        when(gitScanerInfo.getRelease()).thenReturn("\t");
        when(gitScanerInfo.getTestClassesRoot()).thenReturn(tarea2);
        when(gitScanerInfo.getPublicMethodsRoot()).thenReturn(tarea);
        doNothing().when(gitScanerInfo).setClassNamePattern(Mockito.<String>any());
        doNothing().when(gitScanerInfo).setGitLabPath(Mockito.<String>any());
        doNothing().when(gitScanerInfo).setPackageNamePattern(Mockito.<String>any());
        doNothing().when(gitScanerInfo).setPublicMethodsRoot(Mockito.<Tarea>any());
        doNothing().when(gitScanerInfo).setRelease(Mockito.<String>any());
        doNothing().when(gitScanerInfo).setTestClassesRoot(Mockito.<Tarea>any());
        gitScanerInfo.setClassNamePattern("Class Name Pattern");
        gitScanerInfo.setGitLabPath("Git Lab Path");
        gitScanerInfo.setPackageNamePattern("java.text");
        gitScanerInfo.setPublicMethodsRoot(publicMethodsRoot);
        gitScanerInfo.setRelease("1.0.2");
        gitScanerInfo.setTestClassesRoot(testClassesRoot);
        Tarea actualAnalysisCoverageOfPublicMethodsResult = gitLabAccessService
                .analysisCoverageOfPublicMethods(gitScanerInfo);
        verify(gitScanerInfo).getPublicMethodsRoot();
        verify(gitScanerInfo, atLeast(1)).getRelease();
        verify(gitScanerInfo).getTestClassesRoot();
        verify(gitScanerInfo).setClassNamePattern(Mockito.<String>any());
        verify(gitScanerInfo).setGitLabPath(Mockito.<String>any());
        verify(gitScanerInfo).setPackageNamePattern(Mockito.<String>any());
        verify(gitScanerInfo).setPublicMethodsRoot(Mockito.<Tarea>any());
        verify(gitScanerInfo).setRelease(Mockito.<String>any());
        verify(gitScanerInfo).setTestClassesRoot(Mockito.<Tarea>any());
        assertEquals("carpeta", actualAnalysisCoverageOfPublicMethodsResult.getLevel());
        assertEquals('%', actualAnalysisCoverageOfPublicMethodsResult.getByteArrayCompressed()[0]);
    }

    /**
     * Method under test:
     * {@link GitLabAccessService#analysisCoverageOfPublicMethods(GitScanerInfo)}
     */
    @Test
    void testAnalysisCoverageOfPublicMethods4() throws DocumentException, IOException {
        Tarea publicMethodsRoot = new Tarea();
        publicMethodsRoot.setArguments("Arguments");
        publicMethodsRoot.setByteArrayCompressed("AXAXAXAX".getBytes("UTF-8"));
        publicMethodsRoot.setChildren(new ArrayList<>());
        publicMethodsRoot.setClassName("Class Name");
        publicMethodsRoot.setContents("Not all who wander are lost");
        publicMethodsRoot.setCoverage(true);
        publicMethodsRoot.setFolderName("Folder Name");
        publicMethodsRoot.setImports(new ArrayList<>());
        publicMethodsRoot.setLevel("Level");
        publicMethodsRoot.setMemberDeclarations(new ArrayList<>());
        publicMethodsRoot.setMethodName("Method Name");
        publicMethodsRoot.setName("Name");
        publicMethodsRoot.setNumDependencies(3);
        publicMethodsRoot.setNumLines(2);
        publicMethodsRoot.setPackageName("java.text");
        publicMethodsRoot.setReturnType("Return Type");
        publicMethodsRoot.setSourceScanned("Source Scanned");
        publicMethodsRoot.setTest("Test");

        Tarea testClassesRoot = new Tarea();
        testClassesRoot.setArguments("Arguments");
        testClassesRoot.setByteArrayCompressed("AXAXAXAX".getBytes("UTF-8"));
        testClassesRoot.setChildren(new ArrayList<>());
        testClassesRoot.setClassName("Class Name");
        testClassesRoot.setContents("Not all who wander are lost");
        testClassesRoot.setCoverage(true);
        testClassesRoot.setFolderName("Folder Name");
        testClassesRoot.setImports(new ArrayList<>());
        testClassesRoot.setLevel("Level");
        testClassesRoot.setMemberDeclarations(new ArrayList<>());
        testClassesRoot.setMethodName("Method Name");
        testClassesRoot.setName("Name");
        testClassesRoot.setNumDependencies(3);
        testClassesRoot.setNumLines(2);
        testClassesRoot.setPackageName("java.text");
        testClassesRoot.setReturnType("Return Type");
        testClassesRoot.setSourceScanned("Source Scanned");
        testClassesRoot.setTest("Test");

        Tarea tarea = new Tarea();
        tarea.setArguments("Arguments");
        tarea.setByteArrayCompressed("AXAXAXAX".getBytes("UTF-8"));
        tarea.setChildren(new ArrayList<>());
        tarea.setClassName("Class Name");
        tarea.setContents("Not all who wander are lost");
        tarea.setCoverage(true);
        tarea.setFolderName("Folder Name");
        tarea.setImports(new ArrayList<>());
        tarea.setLevel("Level");
        tarea.setMemberDeclarations(new ArrayList<>());
        tarea.setMethodName("Method Name");
        tarea.setName("Name");
        tarea.setNumDependencies(3);
        tarea.setNumLines(2);
        tarea.setPackageName("java.text");
        tarea.setReturnType("Return Type");
        tarea.setSourceScanned("Source Scanned");
        tarea.setTest("Test");

        Tarea tarea2 = new Tarea();
        tarea2.setArguments("Arguments");
        tarea2.setByteArrayCompressed("AXAXAXAX".getBytes("UTF-8"));
        tarea2.setChildren(new ArrayList<>());
        tarea2.setClassName("Class Name");
        tarea2.setContents("Not all who wander are lost");
        tarea2.setCoverage(true);
        tarea2.setFolderName("Folder Name");
        tarea2.setImports(new ArrayList<>());
        tarea2.setLevel("Level");
        tarea2.setMemberDeclarations(new ArrayList<>());
        tarea2.setMethodName("Method Name");
        tarea2.setName("Name");
        tarea2.setNumDependencies(3);
        tarea2.setNumLines(2);
        tarea2.setPackageName("java.text");
        tarea2.setReturnType("Return Type");
        tarea2.setSourceScanned("Source Scanned");
        tarea2.setTest("Test");
        GitScanerInfo gitScanerInfo = mock(GitScanerInfo.class);
        when(gitScanerInfo.getCodigoElementoCatalogo()).thenReturn("Codigo Elemento Catalogo");
        when(gitScanerInfo.getRelease()).thenReturn(null);
        when(gitScanerInfo.getTestClassesRoot()).thenReturn(tarea2);
        when(gitScanerInfo.getPublicMethodsRoot()).thenReturn(tarea);
        doNothing().when(gitScanerInfo).setClassNamePattern(Mockito.<String>any());
        doNothing().when(gitScanerInfo).setGitLabPath(Mockito.<String>any());
        doNothing().when(gitScanerInfo).setPackageNamePattern(Mockito.<String>any());
        doNothing().when(gitScanerInfo).setPublicMethodsRoot(Mockito.<Tarea>any());
        doNothing().when(gitScanerInfo).setRelease(Mockito.<String>any());
        doNothing().when(gitScanerInfo).setTestClassesRoot(Mockito.<Tarea>any());
        gitScanerInfo.setClassNamePattern("Class Name Pattern");
        gitScanerInfo.setGitLabPath("Git Lab Path");
        gitScanerInfo.setPackageNamePattern("java.text");
        gitScanerInfo.setPublicMethodsRoot(publicMethodsRoot);
        gitScanerInfo.setRelease("1.0.2");
        gitScanerInfo.setTestClassesRoot(testClassesRoot);
        Tarea actualAnalysisCoverageOfPublicMethodsResult = gitLabAccessService
                .analysisCoverageOfPublicMethods(gitScanerInfo);
        verify(gitScanerInfo).getCodigoElementoCatalogo();
        verify(gitScanerInfo).getPublicMethodsRoot();
        verify(gitScanerInfo).getRelease();
        verify(gitScanerInfo).getTestClassesRoot();
        verify(gitScanerInfo).setClassNamePattern(Mockito.<String>any());
        verify(gitScanerInfo).setGitLabPath(Mockito.<String>any());
        verify(gitScanerInfo).setPackageNamePattern(Mockito.<String>any());
        verify(gitScanerInfo).setPublicMethodsRoot(Mockito.<Tarea>any());
        verify(gitScanerInfo).setRelease(Mockito.<String>any());
        verify(gitScanerInfo).setTestClassesRoot(Mockito.<Tarea>any());
        assertEquals("carpeta", actualAnalysisCoverageOfPublicMethodsResult.getLevel());
        assertEquals('%', actualAnalysisCoverageOfPublicMethodsResult.getByteArrayCompressed()[0]);
    }
}
