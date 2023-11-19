package com.mylabs.pds.service;

import com.mylabs.pds.model.Tarea;
import com.mylabs.pds.repository.ConfiguracionRepository;
import com.mylabs.pds.utils.IClassGenerator;
import com.mylabs.pds.utils.ZipUtil;
import org.kohsuke.github.GHBranch;
import org.kohsuke.github.GHContent;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GitHubLibraryAccessService {

    private static final String INIT_BASE_DIR = "/src/main/java";
    @Autowired
    private ConfiguracionRepository configRepository;

    private IClassGenerator classGenerator;
    private String owner;
    private String repositoryName;

    public final List<Tarea> scanRepository(final String owner, final String repositoryName,
                                      final IClassGenerator classGenerator) {
        this.classGenerator = classGenerator;
        this.repositoryName = repositoryName;
        this.owner = owner;
        String token = this.configRepository.findById(1L).isPresent()
                ? this.configRepository.findById(1L).get().getCodigo() : "unknown";
        List<Tarea> tareas = new ArrayList<>();
        try {
            GitHub github = GitHub.connectUsingOAuth(token);
            GHRepository repository = github.getUser(this.owner).getRepository(this.repositoryName);
            if (repository == null) {
                System.out.println("Error al acceder al repositorio");
                return null;
            }
            GHBranch developBranch = repository.getBranch("develop");
            if (developBranch == null) {
                System.out.println("Error al acceder a la rama 'develop'");
                return null;
            }
            // Recupera la información de los directorios de la rama 'develop'
            List<GHContent> ghDirContent = repository.getDirectoryContent(INIT_BASE_DIR, developBranch.getSHA1());
            Long idInitial = 1L;
            int i = 0;
            for (GHContent ghContent : ghDirContent) {
                tareas.add(scanRecursiveDirectory(idInitial + (i++),
                        INIT_BASE_DIR.concat("/").concat(ghContent.getName()), repository, ghContent));
            }
            byte[] bytesOfZipped = new ZipUtil().generarZipDesdeTareas(tareas);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return tareas;
    }

    private Tarea scanRecursiveDirectory(final Long idAssigned, final String baseDir, final GHRepository repository, final GHContent item) {
        Tarea tarea = null;
        if (item.isFile()) {
            //condicion de parada y retorno
            if (item.getType().equals("file") && item.getName().endsWith("java")) {
                //me creo y me retorno para que me capture el padre invocador
                try {
                    tarea = this.classGenerator.generateTestClassForJavaFile(idAssigned, item.read());
                    if (tarea != null) {
                        tarea.setId(idAssigned);
                        tarea.setSourceScanned(baseDir); //baseDir
                    }
                } catch (IOException ioExc) {
                    ioExc.printStackTrace();
                    tarea = null;
                }
            }
        } else { //soy una carpeta
            // me creo y creo una lista de hijos que lleno con llamadas recursivas de cada uno
            tarea = new Tarea();
            tarea.setId(idAssigned);
            tarea.setSourceScanned(baseDir); //baseDir
            tarea.setType("FOLDER");
            tarea.setTestName(item.getName());
            tarea.setChildren(new ArrayList<>());
            try {
                List<GHContent> ghDirContent = repository.getDirectoryContent(baseDir);
                if (ghDirContent != null) {
                    AtomicLong idNewAssigned = new AtomicLong(idAssigned * 10);
                    Tarea finalTarea = tarea;
                    ghDirContent.forEach((ghContent -> {
                        Tarea taskChild = scanRecursiveDirectory(idNewAssigned.getAndIncrement(),
                                baseDir.concat("/").concat(ghContent.getName()), repository, ghContent);
                        if (taskChild != null) {
                            taskChild.setParentId(idAssigned);
                            finalTarea.getChildren().add(taskChild);
                        }
                    }
                    ));
                }
            } catch(IOException ioExc){
                ioExc.printStackTrace();
            }
        }
        return tarea;
    }


}