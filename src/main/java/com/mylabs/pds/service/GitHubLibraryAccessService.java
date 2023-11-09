package com.mylabs.pds.service;

import com.mylabs.pds.model.Tarea;
import com.mylabs.pds.repository.ConfiguracionRepository;
import com.mylabs.pds.repository.TareaRepository;
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

@Service
public class GitHubLibraryAccessService {

    private static final String INIT_BASE_DIR = "/src/main/java";
    @Autowired
    private TareaRepository tareaRepository;
    @Autowired
    private ConfiguracionRepository configRepository;

    private IClassGenerator classGenerator;

    public List<Tarea> scanRepository(final String owner, final String repositoryName,
                                      final IClassGenerator classGenerator) {
        this.classGenerator = classGenerator;
        String token = this.configRepository.findById(1L).isPresent()
                ? this.configRepository.findById(1L).get().getCodigo() : "unknown";
        List<Tarea> tareas = new ArrayList<>();
        try {
            GitHub github = GitHub.connectUsingOAuth(token);
            GHRepository repository = github.getUser(owner).getRepository(repositoryName);
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
            for (GHContent ghContent : ghDirContent) {
                tareas.add(scanRecursiveDirectory(INIT_BASE_DIR.concat("/").concat(ghContent.getName()),
                        repository, ghContent));
            }
            byte[] bytesOfZipped = new ZipUtil().generarZipDesdeTareas(tareas);
            tareas = this.tareaRepository.saveAll(tareas);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return tareas;
    }

    private Tarea scanRecursiveDirectory(final String baseDir, final GHRepository repository, final GHContent item) {

        if (item.isFile()) {
            //condicion de parada y retorno
            if (item.getName().endsWith("java")) {
                //me creo y me retorno para que me capture el padre invocador
                try {
                    Tarea tarea = this.classGenerator.generateTestClassForJavaFile(item.read());
                    if (tarea != null) {
                        tarea.setOriginPathToTest(baseDir); //baseDir parent
                        return tarea;
                    } else {
                        return null;
                    }

                } catch (IOException ioExc) {
                    ioExc.printStackTrace();
                    return null;
                }
            } else {
                return null;
            }
        } else { //soy una carpeta
            // me creo y creo una lista de hijos que lleno con llamadas recursivas de cada uno
            Tarea tareaFolder = new Tarea();
            tareaFolder.setOriginPathToTest(baseDir); //baseDir parent
            tareaFolder.setType("FOLDER");
            tareaFolder.setTestName(item.getName());
            tareaFolder.setChildrenTasks(new ArrayList<>());
            try {
                List<GHContent> ghDirContent = repository.getDirectoryContent(baseDir);
                ghDirContent.forEach((ghContent -> {
                    Tarea taskChild = scanRecursiveDirectory(baseDir.concat("/").concat(ghContent.getName()), repository,
                            ghContent);
                    if (taskChild != null) {
                        tareaFolder.getChildrenTasks().add(taskChild);
                    }
                }
                ));
                return tareaFolder;
            } catch (IOException ioExc) {
                ioExc.printStackTrace();
                return null;
            }
        }
    }


}