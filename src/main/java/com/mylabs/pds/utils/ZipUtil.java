package com.mylabs.pds.utils;

import com.mylabs.pds.model.Tarea;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipUtil {

    public byte[] generarZipDesdeTareas(List<Tarea> tareas) {

        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ZipOutputStream zipOutputStream = new ZipOutputStream(byteArrayOutputStream)) {

            String testRootFolder = "test/java"; // Cambia el nombre de la carpeta según tus necesidades
            ZipEntry folderEntry = new ZipEntry(testRootFolder + "/");
            zipOutputStream.putNextEntry(folderEntry);
            tareas.forEach((task) -> {
                try {
                    scanRecursiveTreeOfTasks(task, zipOutputStream);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

            // Cerrar el archivo Zip
            zipOutputStream.finish();
            return byteArrayOutputStream.toByteArray();

        } catch (IOException e) {
            // Manejar excepciones apropiadamente
            e.printStackTrace();
            return null;
        }
    }

    private ZipEntry scanRecursiveTreeOfTasks(final Tarea tarea, final ZipOutputStream zipOutputStream) throws IOException {
        ZipEntry zipEntry = null;
        if (tarea.getIsGenerateToZip() == 1 && tarea.getType().contentEquals("CLASS")) { //condicion de parada
            zipEntry = new ZipEntry(tarea.getName());
            zipOutputStream.putNextEntry(zipEntry); // Agregar la entrada al archivo Zip
            zipOutputStream.write(tarea.getContents().getBytes()); // Agregar el contenido de la tarea al archivo Zip
            zipOutputStream.closeEntry(); // Cerrar la entrada actual
        } else if (tarea.getIsGenerateToZip() == 1 && !tarea.getChildrenTasks().isEmpty()) { // hacer llamada recursiva
            zipEntry = new ZipEntry(tarea.getName() + "/"); // Define el nombre de la carpeta
            zipOutputStream.putNextEntry(zipEntry); // Agregar la entrada al archivo Zip
            tarea.getChildrenTasks().forEach((child) ->{
                try {
                    scanRecursiveTreeOfTasks(child, zipOutputStream);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        return zipEntry;
    }

}
