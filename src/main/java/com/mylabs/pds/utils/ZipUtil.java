package com.mylabs.pds.utils;

import com.mylabs.pds.model.Tarea;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipUtil {

    public final byte[] generarZipDesdeTareas(List<Tarea> tareas) {

        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ZipOutputStream zipOutputStream = new ZipOutputStream(byteArrayOutputStream)) {

            String testRootFolderPath = "test/java/"; // Cambia el nombre de la carpeta según tus necesidades
            ZipEntry folderEntry = new ZipEntry(testRootFolderPath);
            zipOutputStream.putNextEntry(folderEntry);
            tareas.forEach((task) -> {
                try {
                    scanRecursiveTreeOfTasks(testRootFolderPath, task, zipOutputStream);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

            // Cerrar el archivo Zip
            zipOutputStream.finish();
            // escribir este array en un path del servidor a efectos de depuración
            String filePath = "C:\\temp\\testSuite.zip";
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            fileOutputStream.write(byteArrayOutputStream.toByteArray());
            fileOutputStream.close();
            System.out.println("Archivo guardado con éxito en el servidor.");
            return byteArrayOutputStream.toByteArray();

        } catch (IOException e) {
            // Manejar excepciones apropiadamente
            e.printStackTrace();
            return null;
        }
    }

    private void scanRecursiveTreeOfTasks(final String parentDirPath, final Tarea tarea,
                                              final ZipOutputStream zipOutputStream) throws IOException {
        if (tarea.getType().contentEquals("CLASS")) { //condicion de parada
            ZipEntry zipEntry = new ZipEntry(parentDirPath + tarea.getTestName());
            zipOutputStream.putNextEntry(zipEntry); // Agregar la entrada al archivo Zip
            zipOutputStream.write(tarea.getContents().getBytes()); // Agregar el contenido de la tarea al archivo Zip
            zipOutputStream.closeEntry(); // Cerrar la entrada actual
        } else if (tarea.getType().contentEquals("FOLDER") && !tarea.getChildren().isEmpty()) {
            // hacer llamada recursiva
            String folderPath = parentDirPath + tarea.getTestName() + "/";
            ZipEntry zipEntry = new ZipEntry(folderPath); // Define el nombre de la carpeta
            zipOutputStream.putNextEntry(zipEntry); // Agregar la entrada al archivo Zip
            tarea.getChildren().forEach((child) ->{
                try {
                    scanRecursiveTreeOfTasks(folderPath, child, zipOutputStream);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
}
