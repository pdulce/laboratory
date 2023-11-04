package com.mylabs.pds.utils;

import com.mylabs.pds.model.Tarea;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipUtil {

    public static byte[] generarZipDesdeTareas(List<Tarea> tareas) {

        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ZipOutputStream zipOutputStream = new ZipOutputStream(byteArrayOutputStream)) {
            for (Tarea tarea : tareas) {
                // Crear una entrada en el archivo Zip para cada tarea
                if (tarea.getIsGenerateToZip() == 1) {
                    String nombreArchivo = tarea.getName(); // Define el nombre del archivo basado en los datos de la tarea
                    ZipEntry zipEntry = new ZipEntry(nombreArchivo);
                    // Agregar la entrada al archivo Zip
                    zipOutputStream.putNextEntry(zipEntry);
                    // Agregar el contenido de la tarea al archivo Zip (puedes ajustar esto según tus necesidades)
                    String contenidoTarea = tarea.getContents(); // Define el contenido del archivo basado en los datos de la tarea
                    zipOutputStream.write(contenidoTarea.getBytes());
                    // Cerrar la entrada actual
                    zipOutputStream.closeEntry();
                }
            }
            // Cerrar el archivo Zip
            zipOutputStream.finish();
            return byteArrayOutputStream.toByteArray();

        } catch (IOException e) {
            // Manejar excepciones apropiadamente
            e.printStackTrace();
            return null;
        }
    }

}
