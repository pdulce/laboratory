package com.mylabs.pds.utils;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.*;
import com.mylabs.pds.model.Tarea;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class PdfUtil {

    public static void main(String[] args) throws IOException, DocumentException {

        File file22 = new File("C:\\Temp\\pdfSample22.pdf");
        new PdfUtil().createPdf22("C:\\Temp\\pdfSample22.pdf");

        File file33 = new File("C:\\Temp\\pdfSample33.pdf");
        new PdfUtil().createPdf33("C:\\Temp\\pdfSample33.pdf");
    }

    public byte[] getJavaMethodsCoverageReport(final List<Tarea> metodos) throws IOException, DocumentException {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        Document document = new Document();
        PdfWriter.getInstance(document, baos);
        document.open();

        PdfPTable table = new PdfPTable(5);
        PdfPHeaderCell headerCell_1 = new PdfPHeaderCell();
        headerCell_1.setName("Package");
        PdfPCell cell_1 = new PdfPCell();

        PdfPHeaderCell headerCell_2 = new PdfPHeaderCell();
        headerCell_2.setName("Nombre de Clase");
        PdfPCell cell_2 = new PdfPCell();

        PdfPHeaderCell headerCell_3 = new PdfPHeaderCell();
        headerCell_3.setName("Nombre de Método");
        PdfPCell cell_3 = new PdfPCell();

        PdfPHeaderCell headerCell_4 = new PdfPHeaderCell();
        headerCell_4.setName("Número de líneas");
        PdfPCell cell_4 = new PdfPCell();

        PdfPHeaderCell headerCell_5 = new PdfPHeaderCell();
        headerCell_5.setName("Cobertura por test unitario");
        PdfPCell cell_5 = new PdfPCell();

        cell_1.addHeader(headerCell_1);
        table.addCell(cell_1);
        cell_2.addHeader(headerCell_2);
        table.addCell(cell_2);
        cell_3.addHeader(headerCell_3);
        table.addCell(cell_3);
        cell_4.addHeader(headerCell_4);
        table.addCell(cell_4);
        cell_5.addHeader(headerCell_5);
        table.addCell(cell_5);

        // Llenar la tabla con datos de listaTareas
        for (Tarea tarea : metodos) {
            table.addCell(tarea.getPackageName());
            table.addCell(tarea.getClassName());
            table.addCell(tarea.getMethodName());
            table.addCell("" + tarea.getNumLines());
            table.addCell(tarea.getCoverage() ? "Sí" : "No");
        }

        document.add(table);
        document.close();

        byte[] bytesOfStream = baos.toByteArray();
        // Escribir el byte array en un archivo
        String filePath = "C:\\Temp\\pdfSample.pdf";
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(bytesOfStream);
        }

        System.out.println("generando report en df de la cobertura de métodos java por invocación desde test-prj...");
        System.out.println("...report en df generado con éxito.");

        return bytesOfStream;
    }

    public void createPdf22(String dest) throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();

        PdfPTable table = new PdfPTable(8);
        for(int aw = 0; aw < 16; aw++){
            table.addCell("hi");
        }
        document.add(table);
        document.close();
    }

    public void createPdf33(String dest) throws IOException, DocumentException {
        Rectangle small = new Rectangle(290,100);
        Font smallfont = new Font(Font.FontFamily.HELVETICA, 10);
        Document document = new Document(small, 5, 5, 5, 5);
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();

        PdfPTable table = new PdfPTable(2);
        table.setTotalWidth(new float[]{ 160, 120 });
        table.setLockedWidth(true);
        PdfContentByte cb = writer.getDirectContent();
        // first row
        PdfPCell cell = new PdfPCell(new Phrase("Some text here"));
        cell.setFixedHeight(30);
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setColspan(2);
        table.addCell(cell);
        // second row
        cell = new PdfPCell(new Phrase("Some more text", smallfont));
        cell.setFixedHeight(30);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setBorder(Rectangle.NO_BORDER);
        table.addCell(cell);
        Barcode128 code128 = new Barcode128();
        code128.setCode("14785236987541");
        code128.setCodeType(Barcode128.CODE128);
        Image code128Image = code128.createImageWithBarcode(cb, null, null);
        cell = new PdfPCell(code128Image, true);
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setFixedHeight(30);
        table.addCell(cell);
        // third row
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("and something else here", smallfont));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        table.addCell(cell);
        document.add(table);
        document.close();
    }
}
