package com.mylabs.pds.util;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mylabs.pds.model.Constantes;
import com.mylabs.pds.model.GitScanerInfo;
import com.mylabs.pds.model.Tarea;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public final class PdfUtil {

    public static final String FORMATO_DECIMAL = "%.2f";
    private PdfUtil() {

    }

    public static byte[] getJavaMethodsCoverageReport(final List<Tarea> metodos, final GitScanerInfo gitScanerInfo)
            throws DocumentException {
        Document document = new Document();
        document.setPageSize(PageSize.A4.rotate());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter writer = PdfWriter.getInstance(document, baos);
        writer.setPdfVersion(PdfWriter.VERSION_1_5);
        document.open();
        Font headerFont = new Font(Font.FontFamily.HELVETICA, Constantes.NUMBER_14);
        PdfPTable tabHead1 = new PdfPTable(1);
        tabHead1.setWidthPercentage(Constantes.NUMBER_100);
        PdfPCell cellOne = new PdfPCell(new Phrase("Informe ejecutivo de cobertura en tests unitarios para "
                + (gitScanerInfo.getRelease() == null ? gitScanerInfo.getCodigoElementoCatalogo()
                : " release " + gitScanerInfo.getRelease()), headerFont));
        cellOne.setBorder(Rectangle.NO_BORDER);
        PdfPCell cellBlank1 = new PdfPCell(new Phrase("             "));
        cellBlank1.setBorder(Rectangle.NO_BORDER);
        PdfPCell cellBlank2 = new PdfPCell(new Phrase("             "));
        cellBlank2.setBorder(Rectangle.NO_BORDER);
        tabHead1.addCell(cellOne);
        tabHead1.addCell(cellBlank1);
        tabHead1.addCell(cellBlank2);
        document.add(tabHead1);
        PdfPTable tabHead2 = new PdfPTable(1);
        tabHead2.setWidthPercentage(Constantes.NUMBER_40);
        PdfPCell cellTwo = new PdfPCell(new Phrase("               Panorámica de cobertura de unitarias"));
        cellTwo.setBorder(Rectangle.BOX);
        tabHead2.addCell(cellTwo);
        document.add(tabHead2);
        PdfPTable table = new PdfPTable(new float[]{Constantes.NUMBER_24, Constantes.NUMBER_22, Constantes.NUMBER_32,
                Constantes.NUMBER_8, Constantes.NUMBER_10});
        table.setWidthPercentage(Constantes.NUMBER_100);
        table.setPaddingTop(Constantes.NUMBER_2);
        Paragraph packageCell = new Paragraph("                    Package");
        packageCell.getFont().setStyle(Font.BOLD);
        packageCell.getFont().setStyle(Font.FontFamily.HELVETICA.name());
        table.addCell(packageCell);
        Paragraph claseCell = new Paragraph("                    Clase");
        claseCell.getFont().setStyle(Font.BOLD);
        claseCell.getFont().setStyle(Font.FontFamily.HELVETICA.name());
        table.addCell(claseCell);
        Paragraph metodoCell = new Paragraph("                                Método");
        metodoCell.getFont().setStyle(Font.BOLD);
        metodoCell.getFont().setStyle(Font.FontFamily.HELVETICA.name());
        table.addCell(metodoCell);
        Paragraph numLinesCell = new Paragraph("  Nº líneas");
        numLinesCell.getFont().setStyle(Font.BOLD);
        numLinesCell.getFont().setStyle(Font.FontFamily.HELVETICA.name());
        table.addCell(numLinesCell);
        Paragraph coberturaCell = new Paragraph("  ¿Con test?");
        coberturaCell.getFont().setStyle(Font.BOLD);
        coberturaCell.getFont().setStyle(Font.FontFamily.HELVETICA.name());
        table.addCell(coberturaCell);
        Map<String, Integer> clasesToTest = new HashMap<>();
        Map<String, Integer> packagesToTest = new HashMap<>();
        long numTotalLineas = 0;
        long numMethods = 0;
        int numCoverage = 0;
        Font smallfont = new Font(Font.FontFamily.HELVETICA, Constantes.NUMBER_10);
        for (Tarea method : metodos) {
            numMethods++;
            Paragraph cell1 = new Paragraph(method.getPackageName());
            cell1.setFont(smallfont);
            PdfPCell cell11 = new PdfPCell();
            cell11.addElement(cell1);
            table.addCell(cell11);
            packagesToTest.merge(method.getPackageName(), Constantes.NUMBER_1, Integer::sum);
            Paragraph cell2 = new Paragraph(method.getClassName());
            cell2.setFont(smallfont);
            PdfPCell cell22 = new PdfPCell();
            cell22.addElement(cell2);
            table.addCell(cell22);
            clasesToTest.merge(method.getClassName(), Constantes.NUMBER_1, Integer::sum);
            Paragraph cell3 = new Paragraph(method.getMethodName().concat("(").
                    concat(method.getArguments()).concat(")"));
            cell3.setFont(smallfont);
            PdfPCell cell33 = new PdfPCell();
            cell33.addElement(cell3);
            table.addCell(cell33);
            numTotalLineas += method.getNumLines();
            Paragraph cell4 = new Paragraph("        " + method.getNumLines());
            cell4.setFont(smallfont);
            PdfPCell cell44 = new PdfPCell();
            cell44.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell44.addElement(cell4);
            table.addCell(cell44);
            numCoverage = method.getCoverage() ? (numCoverage + 1) : numCoverage;
            Paragraph cell5 = new Paragraph(method.getCoverage() ? "            Sí" : "            No");
            cell5.setFont(smallfont);
            PdfPCell cell55 = new PdfPCell();
            cell55.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell55.addElement(cell5);
            table.addCell(cell55);
        }
        document.add(table);
        double porcentajeSinFmt = Constantes.NUMBER_100 * Double.valueOf(numCoverage) / Double.valueOf(metodos.size());
        String porcentaje = String.format(FORMATO_DECIMAL, porcentajeSinFmt);
        PdfPTable tabTotales = new PdfPTable(Constantes.NUMBER_1);
        tabTotales.setWidthPercentage(Constantes.NUMBER_45);
        PdfPCell cellBlank11 = new PdfPCell(new Phrase("                     "));
        cellBlank11.setBorder(Rectangle.NO_BORDER);
        PdfPCell cellBlank22 = new PdfPCell(new Phrase("                     "));
        cellBlank22.setBorder(Rectangle.NO_BORDER);
        tabTotales.addCell(cellBlank11);
        tabTotales.addCell(cellBlank22);
        PdfPCell cellTotales1 = new PdfPCell(new Phrase("Núm. de paquetes a testear:      "
                + packagesToTest.keySet().size()));
        PdfPCell cellTotales2 = new PdfPCell(new Phrase("Núm. total de líneas a testear:  " + numTotalLineas));
        PdfPCell cellTotales3 = new PdfPCell(new Phrase("Núm. de clases a testear:         "
                + clasesToTest.keySet().size()));
        PdfPCell cellTotales4 = new PdfPCell(new Phrase("Núm. de métodos a testear:       " + numMethods));
        PdfPCell cellTotales5 = new PdfPCell(new Phrase("Núm. de métodos con cobertura de unitarias:             "
                + numCoverage));
        PdfPCell cellTotales6 = new PdfPCell(new Phrase("Porcentaje de métodos con cobertura de unitarias:    "
                + porcentaje + " %"));
        cellTotales6.setBorder(Rectangle.BOX);
        cellTotales6.setBackgroundColor(new BaseColor(Constantes.NUMBER_255, Constantes.NUMBER_255,
                Constantes.NUMBER_45));
        tabTotales.addCell(cellTotales1);
        tabTotales.addCell(cellTotales2);
        tabTotales.addCell(cellTotales3);
        tabTotales.addCell(cellTotales4);
        tabTotales.addCell(cellTotales5);
        tabTotales.addCell(cellTotales6);
        document.add(tabTotales);
        document.close();
        byte[] bytesOfStream = baos.toByteArray();
        /*String filePath = "C:\\Temp\\pdfSample.pdf";
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(bytesOfStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
        return bytesOfStream;
    }

}
