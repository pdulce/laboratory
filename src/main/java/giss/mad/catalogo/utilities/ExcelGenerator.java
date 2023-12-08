package giss.mad.catalogo.utilities;

import giss.mad.catalogo.model.AtributoEje;
import giss.mad.catalogo.model.ElementOrEntregaInterface;
import giss.mad.catalogo.model.Grupo;
import giss.mad.catalogo.service.ElementOrReleaseServiceInterface;
import giss.mad.catalogo.service.GrupoService;
import giss.mad.catalogo.service.ValorDominioService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public final class ExcelGenerator {

    private ExcelGenerator() {

    }

    public static byte[] generateExcelSummarized(final List<ElementOrEntregaInterface> elementos,
                                                 final ElementOrReleaseServiceInterface elementoCatalogoService,
                                                 final GrupoService grupoService,
                                                 final List<AtributoEje> listaAtributos,
                                                 final ValorDominioService valorDominioService) throws IOException {

        try {
            Workbook workbook = new XSSFWorkbook();

            Sheet sheet = workbook.createSheet("Atributos");

            CellStyle style = workbook.createCellStyle();
            Font font = workbook.createFont();
            font.setBold(true);
            style.setFont(font);

            // Crear la fila de títulos
            Row titleRow = sheet.createRow(0);
            Cell cell1 = titleRow.createCell(Constantes.NUMBER_0);
            cell1.setCellValue("Nombre de elemento");
            cell1.setCellStyle(style);
            sheet.autoSizeColumn(0);

            Cell cell2 = titleRow.createCell(Constantes.NUMBER_1);
            cell2.setCellValue("Código");
            cell2.setCellStyle(style);
            sheet.autoSizeColumn(Constantes.NUMBER_1);

            Cell cell3 = titleRow.createCell(Constantes.NUMBER_2);
            cell3.setCellValue("Centro");
            cell3.setCellStyle(style);
            sheet.autoSizeColumn(Constantes.NUMBER_2);

            Cell cell4 = titleRow.createCell(Constantes.NUMBER_3);
            cell4.setCellValue("Contacto");
            cell4.setCellStyle(style);
            sheet.autoSizeColumn(Constantes.NUMBER_3);

            Cell cell5 = titleRow.createCell(Constantes.NUMBER_4);
            cell5.setCellValue("Descripción corta");
            cell5.setCellStyle(style);
            sheet.autoSizeColumn(Constantes.NUMBER_4);

            Cell cell6 = titleRow.createCell(Constantes.NUMBER_5);
            cell6.setCellValue("Nombre del responsable");
            cell6.setCellStyle(style);
            sheet.autoSizeColumn(Constantes.NUMBER_5);

            // Llenar el resto de las filas con datos
            int rowNum = 1;
            for (ElementOrEntregaInterface item : elementos) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(Constantes.NUMBER_0).setCellValue(item.getName());
                sheet.autoSizeColumn(Constantes.NUMBER_0);
                row.createCell(Constantes.NUMBER_1).setCellValue(item.getCappCode());
                sheet.autoSizeColumn(Constantes.NUMBER_1);
                Grupo unidadResposableTto = grupoService.getById(item.getGroupId());
                row.createCell(Constantes.NUMBER_2).setCellValue(unidadResposableTto.getCodigo().concat(" - ").
                        concat(unidadResposableTto.getName()));
                sheet.autoSizeColumn(Constantes.NUMBER_2);
                for (AtributoEje atributo : listaAtributos) {
                    if (atributo.getName().contentEquals("Correo del líder QA")
                            || atributo.getCode().contentEquals("ATTR09")) {
                        row.createCell(Constantes.NUMBER_3).
                           setCellValue(elementoCatalogoService.getValueOfAttr(atributo, item, valorDominioService));
                        sheet.autoSizeColumn(Constantes.NUMBER_3);
                    } else if (atributo.getName().contentEquals("Descripción")
                            || atributo.getCode().contentEquals("ATTR04")) {
                        row.createCell(Constantes.NUMBER_4).
                           setCellValue(elementoCatalogoService.getValueOfAttr(atributo, item, valorDominioService));
                        sheet.autoSizeColumn(Constantes.NUMBER_4);
                    } else if (atributo.getName().contentEquals("Nombre del responsable")
                            || atributo.getCode().contentEquals("ATTR06")) {
                        row.createCell(Constantes.NUMBER_5).
                           setCellValue(elementoCatalogoService.getValueOfAttr(atributo, item, valorDominioService));
                        sheet.autoSizeColumn(Constantes.NUMBER_5);
                    }
                }
            }
            // Escribir el libro de trabajo en el flujo de salida
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);

            byte[] bytesOfStream = outputStream.toByteArray();
            /*String filePath = "C:\\Temp\\informeExcelResumido.xlsx";
            try (FileOutputStream fos = new FileOutputStream(filePath)) {
                fos.write(bytesOfStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }*/

            // Devolver los bytes del flujo de salida
            return bytesOfStream;
        } catch (Exception exc) {
            return null;
        }
    }

    public static byte[] generateExcelExtended(final List<ElementOrEntregaInterface> elementosOrEntregas,
                                               final ElementOrReleaseServiceInterface elementoCatalogoService,
                                               final GrupoService grupoService,
                                               final List<AtributoEje> listaAtributos,
                                               final ValorDominioService valorDominioService) throws IOException {
        try {
            Workbook workbook = new XSSFWorkbook();

            Sheet sheet = workbook.createSheet("Atributos");

            CellStyle style = workbook.createCellStyle();
            Font font = workbook.createFont();
            font.setBold(true);
            style.setFont(font);

            // Crear la fila de títulos
            Row titleRow = sheet.createRow(0);
            Cell cell1 = titleRow.createCell(Constantes.NUMBER_0);
            cell1.setCellValue("Nombre de elemento");
            cell1.setCellStyle(style);
            sheet.autoSizeColumn(0);

            Cell cell2 = titleRow.createCell(Constantes.NUMBER_1);
            cell2.setCellValue("Código");
            cell2.setCellStyle(style);
            sheet.autoSizeColumn(Constantes.NUMBER_1);

            Cell cell3 = titleRow.createCell(Constantes.NUMBER_2);
            cell3.setCellValue("Centro");
            cell3.setCellStyle(style);
            sheet.autoSizeColumn(Constantes.NUMBER_2);

            int columIndex = Constantes.NUMBER_3;
            for (AtributoEje atributo : listaAtributos) {
                Cell cellIesimo = titleRow.createCell(columIndex);
                cellIesimo.setCellValue(atributo.getName());
                cellIesimo.setCellStyle(style);
                sheet.autoSizeColumn(columIndex++);
            }


            // Llenar el resto de las filas con datos
            int rowNum = 1;
            for (ElementOrEntregaInterface item : elementosOrEntregas) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(Constantes.NUMBER_0).setCellValue(item.getName());
                sheet.autoSizeColumn(Constantes.NUMBER_0);
                row.createCell(Constantes.NUMBER_1).setCellValue(item.getCappCode());
                sheet.autoSizeColumn(Constantes.NUMBER_1);
                Grupo unidadResposableTto = grupoService.getById(item.getGroupId());
                row.createCell(Constantes.NUMBER_2).setCellValue(unidadResposableTto.getCodigo().concat(" - ").
                        concat(unidadResposableTto.getName()));
                sheet.autoSizeColumn(Constantes.NUMBER_2);
                int columIndexRecord = Constantes.NUMBER_3;
                for (AtributoEje atributo : listaAtributos) {
                    row.createCell(columIndexRecord).
                        setCellValue(elementoCatalogoService.getValueOfAttr(atributo, item, valorDominioService));
                    sheet.autoSizeColumn(columIndexRecord++);
                }
            }


            // Escribir el libro de trabajo en el flujo de salida
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);

            byte[] bytesOfStream = outputStream.toByteArray();
            /*String filePath = "C:\\Temp\\informeExcelExtendido.xlsx";
            try (FileOutputStream fos = new FileOutputStream(filePath)) {
                fos.write(bytesOfStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }*/

            // Devolver los bytes del flujo de salida
            return bytesOfStream;
        } catch (Exception exc) {
            return null;
        }
    }



}

