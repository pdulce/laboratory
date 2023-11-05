package com.mylabs.pds.service;

import com.mylabs.pds.model.Tarea;
import com.mylabs.pds.repository.ConfiguracionRepository;
import com.mylabs.pds.repository.TareaRepository;
import com.mylabs.pds.utils.ZipUtil;
import org.kohsuke.github.GHContent;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class GitHubService {
    private byte[] bytesOfZipped;
    private List<Tarea> tareas;

    @Autowired
    private TareaRepository tareaRepository;

    @Autowired
    private ConfiguracionRepository configRepository;

    private void initGitHubService() {
        try {
            String token = this.configRepository.findById(1L).isPresent() ? this.configRepository.findById(1L).get().getCodigo() : "unknown";
            GitHub github = GitHub.connectUsingOAuth(token);
            GHRepository repository = github.getUser("pdulce").getRepository("laboratory");
            if (repository == null) {
                System.out.println("Error al acceder al repositorio");
                return;
            }
            this.tareas = scanMainDir("src", repository);
            this.bytesOfZipped = ZipUtil.generarZipDesdeTareas(tareas);
            this.tareaRepository.saveAll(this.tareas);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Tarea> scanMainDir(final String baseDir, final GHRepository repository) {
        List<Tarea> listaTareas = new ArrayList<>();
        try {
            List<GHContent> ghDirContent = repository.getDirectoryContent(baseDir);
            ghDirContent.forEach((ghContent -> {
                listaTareas.add(scanDirectory(baseDir.concat("/").concat(ghContent.getName()), repository,
                        ghContent));
            }
            ));
        } catch (IOException ioExc) {
            ioExc.printStackTrace();
            return null;
        }
        return listaTareas;
    }

    private Tarea scanDirectory(final String baseDir, final GHRepository repository, final GHContent item) {

        if (item.isFile()) {
            //condicion de parada y retorno
            if (item.getName().endsWith("java")) {
                //me creo y me retorno para que me capture el padre invocador
                try {
                    Tarea tarea = new JavaParserService().generateTestClassForJavaFile(item.read());
                    tarea.setFolder(baseDir); //baseDir parent
                    return tarea;
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
            tareaFolder.setFolder(baseDir); //baseDir parent
            tareaFolder.setType("FOLDER");
            tareaFolder.setName(item.getName());
            tareaFolder.setIsGenerateToZip(1);
            tareaFolder.setChildrenTasks(new ArrayList<>());
            try {
                List<GHContent> ghDirContent = repository.getDirectoryContent(baseDir);
                ghDirContent.forEach((ghContent -> {
                    Tarea taskChild = scanDirectory(baseDir.concat("/").concat(ghContent.getName()), repository,
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

    private void scanDir(final GHContent item, final List<GHContent> lista) {
        if (item.isDirectory()) {
            scanDir(null, lista);
        } else if (item.isFile() && item.getName().endsWith("java")) {
            lista.add(item);
        }
    }

    // Implementa métodos para acceder a repositorios y archivos en GitHub.

    public List<Tarea> getListOfTasks() {
        initGitHubService();
        return this.tareas;
    }

    public byte[] getZipOfTests() {
        initGitHubService();
        return this.bytesOfZipped;
    }

}