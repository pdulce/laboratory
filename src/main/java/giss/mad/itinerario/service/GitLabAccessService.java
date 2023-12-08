package giss.mad.itinerario.service;

import com.itextpdf.text.DocumentException;
import giss.mad.itinerario.exception.ErrorHandler;
import giss.mad.itinerario.model.volatilentities.GitScanerInfo;
import giss.mad.itinerario.model.volatilentities.Tarea;
import giss.mad.itinerario.repository.itinerario.ConfiguracionRepository;
import giss.mad.itinerario.util.IClassGenerator;
import giss.mad.itinerario.util.PdfUtil;
import giss.mad.itinerario.util.TareaComparator;
import giss.mad.itinerario.util.TratamientoFuentesJava;
import giss.mad.itinerario.util.ZipUtil;
import org.gitlab4j.api.GitLabApi;
import org.gitlab4j.api.GitLabApiException;
import org.gitlab4j.api.models.RepositoryFile;
import org.gitlab4j.api.models.TreeItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class GitLabAccessService {
    private static final String TOKEN_GITLAB = "TOKEN_GITLAB";
    private static final String GITLAB_API_URL = "https://gitlab.pro.portal.ss";
    private static final String INIT_BASE_DIR = "src/main/java";
    private static final String INIT_BASE_TEST_DIR = "src/test/java";
    private static final String BRANCH_NAME = "develop";
    private IClassGenerator classGenerator;

    @Autowired
    private ConfiguracionRepository configuracionRepository;

    public final Tarea scanRepository(final GitScanerInfo gitScanerInfo, final IClassGenerator classGenerator) throws Exception{
        String repositoryName = gitScanerInfo.getGitLabPath();
        this.classGenerator = classGenerator;
        String packageNamePattern = gitScanerInfo.getPackageNamePattern();
        String classNamePattern = gitScanerInfo.getClassNamePattern();
        String gitToken = configuracionRepository.findByKeyAndDeletedIsNull(TOKEN_GITLAB).getValue();
        GitLabApi gitLabApi = new GitLabApi(GITLAB_API_URL, gitToken);
        gitLabApi.setIgnoreCertificateErrors(true);

        Map<String, String> rxExpressions = new HashMap<>();
        rxExpressions.put(IClassGenerator.RXFORJAVAPACKAGES,
                configuracionRepository.findByKeyAndDeletedIsNull(IClassGenerator.RXFORJAVAPACKAGES).getValue());
        rxExpressions.put(IClassGenerator.RXFORJAVAIMPORTS,
                configuracionRepository.findByKeyAndDeletedIsNull(IClassGenerator.RXFORJAVAIMPORTS).getValue());
        rxExpressions.put(IClassGenerator.RXFORJAVACLASS,
                configuracionRepository.findByKeyAndDeletedIsNull(IClassGenerator.RXFORJAVACLASS).getValue());
        rxExpressions.put(IClassGenerator.RXFORVARDECLARATION,
                configuracionRepository.findByKeyAndDeletedIsNull(IClassGenerator.RXFORVARDECLARATION).getValue());
        rxExpressions.put(IClassGenerator.RXFORPUBLICMETHODS,
                configuracionRepository.findByKeyAndDeletedIsNull(IClassGenerator.RXFORPUBLICMETHODS).getValue());

        Tarea rootTask = new Tarea();
        rootTask.setName("Raiz");
        rootTask.setTest("Desglose tareas unitarias");
        rootTask.setLevel(Tarea.TIPO_RAIZ);
        rootTask.setChildren(new ArrayList<>());

        try {
            List<TreeItem> treeItems = gitLabApi.getRepositoryApi().getTree(repositoryName,
                    INIT_BASE_DIR, BRANCH_NAME);
            for (TreeItem treeItem : treeItems) {
                rootTask.getChildren().
                        add(recursiveScanSourceDirectory(treeItem, INIT_BASE_DIR, gitLabApi, repositoryName,
                                rxExpressions));
            }
            rootTask.setByteArrayCompressed(new ZipUtil().generarZipDesdeTareas(rootTask.getChildren()));
        } catch (GitLabApiException e) {
            throw new Exception(ErrorHandler.NOT_AVALAIBLE_MESSAGE);
        }
        return TratamientoFuentesJava.filterOnlyPackages(rootTask,
                packageNamePattern == null ? "*" : packageNamePattern,
                classNamePattern == null ? "*" : classNamePattern);
    }

    public final Tarea scanMethodTestCoverage(final GitScanerInfo gitScanerInfo, final IClassGenerator classGenerator)
    throws Exception {
        String repositoryName = gitScanerInfo.getGitLabPath();
        this.classGenerator = classGenerator;
        //String packageNamePattern = gitScanerInfo.getPackageNamePattern();
        //String classNamePattern = gitScanerInfo.getClassNamePattern();
        String gitToken = configuracionRepository.findByKeyAndDeletedIsNull(TOKEN_GITLAB).getValue();
        GitLabApi gitLabApi = new GitLabApi(GITLAB_API_URL, gitToken);
        gitLabApi.setIgnoreCertificateErrors(true);

        Map<String, String> rxExpressions = new HashMap<>();
        rxExpressions.put(IClassGenerator.RXFORJAVAPACKAGES,
                configuracionRepository.findByKeyAndDeletedIsNull(IClassGenerator.RXFORJAVAPACKAGES).getValue());
        rxExpressions.put(IClassGenerator.RXFORJAVAIMPORTS,
                configuracionRepository.findByKeyAndDeletedIsNull(IClassGenerator.RXFORJAVAIMPORTS).getValue());
        rxExpressions.put(IClassGenerator.RXFORJAVACLASS,
                configuracionRepository.findByKeyAndDeletedIsNull(IClassGenerator.RXFORJAVACLASS).getValue());
        rxExpressions.put(IClassGenerator.RXFORVARDECLARATION,
                configuracionRepository.findByKeyAndDeletedIsNull(IClassGenerator.RXFORVARDECLARATION).getValue());
        rxExpressions.put(IClassGenerator.RXFORPUBLICMETHODS,
                configuracionRepository.findByKeyAndDeletedIsNull(IClassGenerator.RXFORPUBLICMETHODS).getValue());
        Tarea rootTask = new Tarea();
        rootTask.setTest("Tests existentes");
        rootTask.setLevel(Tarea.TIPO_RAIZ);
        List<Tarea> tesClassesFound = new ArrayList<>();

        try {
            List<TreeItem> treeItems = gitLabApi.getRepositoryApi().getTree(repositoryName,
                    INIT_BASE_TEST_DIR, BRANCH_NAME);
            for (TreeItem treeItem : treeItems) {
                recursiveScanTestDir(treeItem, INIT_BASE_TEST_DIR, gitLabApi, repositoryName, tesClassesFound,
                        rxExpressions);
            }
        } catch (GitLabApiException e) {
            throw new Exception(ErrorHandler.NOT_AVALAIBLE_MESSAGE);
        }
        rootTask.setChildren(tesClassesFound);
        return rootTask;
    }

    public final Tarea analysisCoverageOfPublicMethods(final GitScanerInfo gitScanerInfo) throws DocumentException,
            IOException {
        List<Tarea> publicMethods = new ArrayList<>();
        recursiveLookupMethods(gitScanerInfo.getPublicMethodsRoot(), publicMethods);
        List<Tarea> testClasses = gitScanerInfo.getTestClassesRoot().getChildren();
        Collections.sort(publicMethods, new TareaComparator());
        publicMethods.forEach((publicMethod) -> {
            publicMethod.setCoverage(false);
            boolean esInvocadoAlMenosUnaVez = false;
            int j = 0;
            while (!esInvocadoAlMenosUnaVez && j < testClasses.size()) {
                Tarea testClass = testClasses.get(j++);
                if (testClass.getPackageName().contentEquals(publicMethod.getPackageName())) {
                    String varNameFound = TratamientoFuentesJava.
                            lookupVarNameOfClassMethod(testClass, publicMethod.getClassName());
                    //buscamos las apariciones al método invocado
                    if (varNameFound != null) {
                        String memberAndMethodInvocation = varNameFound.concat(".").
                                concat(publicMethod.getMethodName());
                        Pattern patronInInstanceWay = Pattern.compile(memberAndMethodInvocation);
                        Matcher matcherInInstanceWay = patronInInstanceWay.matcher(testClass.getContents());
                        esInvocadoAlMenosUnaVez = matcherInInstanceWay.find();
                    }
                    if (!esInvocadoAlMenosUnaVez) {
                        String staticMethodInvocation = publicMethod.getClassName().concat(".").
                                concat(publicMethod.getMethodName());
                        Pattern patronInStaticWay = Pattern.compile(staticMethodInvocation);
                        Matcher matcherInStaticWay = patronInStaticWay.matcher(testClass.getContents());
                        esInvocadoAlMenosUnaVez = matcherInStaticWay.find();
                    }
                }
            }
            publicMethod.setCoverage(esInvocadoAlMenosUnaVez);
        });
        Tarea tarea = new Tarea();
        tarea.setLevel(Tarea.TIPO_FOLDER);
        tarea.setByteArrayCompressed(PdfUtil.getJavaMethodsCoverageReport(publicMethods, gitScanerInfo));
        return tarea;
    }

    private Tarea recursiveScanSourceDirectory(final TreeItem treeItem, final String treeParentDir,
                                               final GitLabApi gitLabApi, final String repositoryName,
                                               final Map<String, String> rxExpressions)
            throws GitLabApiException {
        Tarea tarea = null;
        if (treeItem.getType().toString().equals("blob") && treeItem.getName().endsWith(".java")) {
            // Obtener el contenido del archivo
            RepositoryFile fileItem = gitLabApi.getRepositoryFileApi().getFile(repositoryName,
                    treeItem.getPath(), BRANCH_NAME);
            tarea = this.classGenerator.generateTestClassForJavaFile(fileItem.getDecodedContentAsString(),
                    rxExpressions);
        } else if (treeItem.getType().toString().equals("tree")) {
            String newTreeParentDir = treeParentDir + "/" + treeItem.getName();
            // me creo siempre como package
            tarea = new Tarea();
            tarea.setChildren(new ArrayList<>());
            String packageName = treeItem.getPath().replaceFirst(INIT_BASE_DIR + "/", "").
                    replaceAll("/", ".");
            tarea.setTest(packageName);
            tarea.setName(packageName);
            tarea.setSourceScanned(packageName);
            tarea.setFolderName(treeItem.getName());
            List<TreeItem> newtreeItems = gitLabApi.getRepositoryApi().getTree(repositoryName,
                    newTreeParentDir, BRANCH_NAME);
            boolean isFolder = true;
            if (newtreeItems != null && !newtreeItems.isEmpty()) {
                for (TreeItem treechildItem: newtreeItems) {
                    if (!treechildItem.getType().toString().equals("tree")) {
                        isFolder = false;
                    }
                    Tarea tareaChild = recursiveScanSourceDirectory(treechildItem, newTreeParentDir, gitLabApi,
                            repositoryName, rxExpressions);
                    if (tareaChild != null) {
                        tarea.getChildren().add(tareaChild);
                    }
                }
            }
            tarea.setLevel(isFolder ? Tarea.TIPO_FOLDER : Tarea.TIPO_PACKAGE);
        }
        return tarea;
    }

    private void recursiveScanTestDir(final TreeItem treeItem, final String treeParentDir, final GitLabApi gitLabApi,
                                      final String repositoryName,
                                      final List<Tarea> tareasAcumuladas, final Map<String, String> rxExpressions)
            throws GitLabApiException {

        if (treeItem.getType().toString().equals("blob") && treeItem.getName().endsWith(".java")) {
            // Obtener el contenido del archivo
            RepositoryFile fileItem = gitLabApi.getRepositoryFileApi().getFile(repositoryName,
                    treeItem.getPath(), BRANCH_NAME);
            Tarea testClass = this.classGenerator.obtainTestClass(fileItem.getDecodedContentAsString(), rxExpressions);
            if (testClass != null && testClass.getContents() != null) {
                tareasAcumuladas.add(testClass);
            }
        } else {
            String newTreeParentDir = treeParentDir + "/" + treeItem.getName();
            List<TreeItem> newtreeItems = gitLabApi.getRepositoryApi().getTree(repositoryName,
                    newTreeParentDir, BRANCH_NAME);
            if (newtreeItems != null && !newtreeItems.isEmpty()) {
                for (TreeItem treechildItem: newtreeItems) {
                    recursiveScanTestDir(treechildItem, newTreeParentDir, gitLabApi, repositoryName, tareasAcumuladas,
                            rxExpressions);
                }
            }
        }
    }


    private void recursiveLookupMethods(final Tarea root, final List<Tarea> filtered) {
        if (root.getLevel().contentEquals(Tarea.TIPO_TESTMETHOD)) {
            filtered.add(root);
        } else {
            List<Tarea> children = root.getChildren() == null ? new ArrayList<>() : root.getChildren();
            children.forEach((child) -> {
                if (child.getLevel().contentEquals(Tarea.TIPO_TESTMETHOD)) {
                   filtered.add(child);
                } else {
                    recursiveLookupMethods(child, filtered);
                }
            });
        }

    }


}
