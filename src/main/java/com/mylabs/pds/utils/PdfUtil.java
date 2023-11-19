package com.mylabs.pds.utils;

import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.*;
import com.mylabs.pds.model.Tarea;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PdfUtil {

    public static void main(String[] args) throws IOException, DocumentException {
        new PdfUtil().getJavaMethodsCoverageReport(new ArrayList<>());
        /*File file22 = new File("C:\\Temp\\pdfSample22.pdf");
        new PdfUtil().createPdf22("C:\\Temp\\pdfSample22.pdf");

        File file33 = new File("C:\\Temp\\pdfSample33.pdf");
        new PdfUtil().createPdf33("C:\\Temp\\pdfSample33.pdf");*

        File file33 = new File("C:\\Temp\\pdfSampleWithLayers.pdf");
        new PdfUtil().createPdf("C:\\Temp\\pdfSampleWithLayers.pdf");*/
    }

    /** The resulting PDF. */

    /**
     * Creates a PDF document.
     * @param filename the path to the new PDF document
     * @throws DocumentException
     * @throws IOException
     */
    public void createPdf(String filename)
            throws DocumentException, IOException {
        // step 1
        Document document = new Document();
        document.setPageSize(PageSize.A4);//.rotate());
        // step 2
        PdfWriter writer =
                PdfWriter.getInstance(document, new FileOutputStream(filename));
        writer.setPdfVersion(PdfWriter.VERSION_1_5);
        // step 3
        document.open();
        // step 4
        PdfContentByte cb = writer.getDirectContent();
        PdfLayer nested = new PdfLayer("Nested layers", writer);
        PdfLayer nested_1 = new PdfLayer("Nested layer 1", writer);
        PdfLayer nested_2 = new PdfLayer("Nested layer 2", writer);
        nested.addChild(nested_1);
        nested.addChild(nested_2);
        writer.lockLayer(nested_2);
        cb.beginLayer(nested);
        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(
                "nested layers"), 80, 775, 0);
        cb.endLayer();
        cb.beginLayer(nested_1);
        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(
                "nested layer 1"), 80, 800, 0);
        cb.endLayer();
        cb.beginLayer(nested_2);
        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(
                "nested layer 2"), 80, 750, 0);
        cb.endLayer();

        PdfPTable table = new PdfPTable(5);
        // HEADER
        Paragraph packageCell = new Paragraph("Package");
        packageCell.getFont().setStyle(Font.BOLD);
        table.addCell(packageCell);
        table.addCell("Nombre de Clase");
        table.addCell("Nombre de Método");
        table.addCell("Número de líneas");
        table.addCell("Cobertura por test unitario");
        document.add(table);

        PdfLayer group = PdfLayer.createTitle("Grouped layers", writer);
        PdfLayer layer1 = new PdfLayer("Group: layer 1", writer);
        PdfLayer layer2 = new PdfLayer("Group: layer 2", writer);
        group.addChild(layer1);
        group.addChild(layer2);
        cb.beginLayer(layer1);
        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(
                "layer 1 in the group"), 50, 700, 0);
        cb.endLayer();
        cb.beginLayer(layer2);
        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(
                "layer 2 in the group"), 50, 675, 0);
        cb.endLayer();

        PdfLayer radiogroup = PdfLayer.createTitle("Radio group", writer);
        PdfLayer radio1 = new PdfLayer("Radiogroup: layer 1", writer);
        radio1.setOn(true);
        PdfLayer radio2 = new PdfLayer("Radiogroup: layer 2", writer);
        radio2.setOn(false);
        PdfLayer radio3 = new PdfLayer("Radiogroup: layer 3", writer);
        radio3.setOn(false);
        radiogroup.addChild(radio1);
        radiogroup.addChild(radio2);
        radiogroup.addChild(radio3);
        ArrayList<PdfLayer> options = new ArrayList<PdfLayer>();
        options.add(radio1);
        options.add(radio2);
        options.add(radio3);
        writer.addOCGRadioGroup(options);
        cb.beginLayer(radio1);
        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(
                "option 1"), 50, 600, 0);
        cb.endLayer();
        cb.beginLayer(radio2);
        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(
                "option 2"), 50, 575, 0);
        cb.endLayer();
        cb.beginLayer(radio3);
        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(
                "option 3"), 50, 550, 0);
        cb.endLayer();

        PdfLayer not_printed = new PdfLayer("not printed", writer);
        not_printed.setOnPanel(false);
        not_printed.setPrint("Print", false);
        cb.beginLayer(not_printed);
        ColumnText.showTextAligned(cb, Element.ALIGN_CENTER, new Phrase(
                "PRINT THIS PAGE"), 300, 700, 90);
        cb.endLayer();

        PdfLayer zoom = new PdfLayer("Zoom 0.75-1.25", writer);
        zoom.setOnPanel(false);
        zoom.setZoom(0.75f, 1.25f);
        cb.beginLayer(zoom);
        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(
                        "Only visible if the zoomfactor is between 75 and 125%"), 30,
                530, 90);
        cb.endLayer();

        // step 5
        document.close();
    }

    public byte[] getJavaMethodsCoverageReport(final List<Tarea> metodos) throws IOException, DocumentException {

        Document document = new Document();
        document.setPageSize(PageSize.A4);
        // step 2
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter writer = PdfWriter.getInstance(document, baos);
        writer.setPdfVersion(PdfWriter.VERSION_1_5);

        // step 3
        document.open();
        // step 4
        Font headerFont = new Font(Font.FontFamily.HELVETICA, 14);
        PdfPTable tabHead1 = new PdfPTable(1);
        tabHead1.setWidthPercentage(100);
        PdfPCell cellOne = new PdfPCell(
                new Phrase("Informe ejecutivo de cobertura en tests unitarios", headerFont));
        cellOne.setBorder(Rectangle.NO_BORDER);
        PdfPCell cellBlank1 = new PdfPCell(new Phrase("                                              "));
        cellBlank1.setBorder(Rectangle.NO_BORDER);
        PdfPCell cellBlank2 = new PdfPCell(new Phrase("                                              "));
        cellBlank2.setBorder(Rectangle.NO_BORDER);
        tabHead1.addCell(cellOne);
        tabHead1.addCell(cellBlank1);
        tabHead1.addCell(cellBlank2);
        document.add(tabHead1);

        PdfPTable tabHead2 = new PdfPTable(1);
        tabHead2.setWidthPercentage(50);
        PdfPCell cellTwo = new PdfPCell(new Phrase("Elemento promocionable MACAMAC0"));
        cellTwo.setBorder(Rectangle.BOX);
        //cellOne.setBackgroundColor(new BaseColor(255,255,45));
        tabHead2.addCell(cellTwo);
        document.add(tabHead2);

        /**** chicha de las tareas ***/
        //PdfPTable table = new PdfPTable(5);
        PdfPTable table = new PdfPTable(new float[] { 26, 24, 24, 11, 13 });

        table.setWidthPercentage(100);
        table.setPaddingTop(2);
        // HEADER
        Paragraph packageCell = new Paragraph("Package");
        packageCell.getFont().setStyle(Font.BOLD);
        packageCell.getFont().setStyle(Font.FontFamily.HELVETICA.name());
        table.addCell(packageCell);

        Paragraph claseCell = new Paragraph("Clase");
        claseCell.getFont().setStyle(Font.BOLD);
        claseCell.getFont().setStyle(Font.FontFamily.HELVETICA.name());
        table.addCell(claseCell);

        Paragraph metodoCell = new Paragraph("Método");
        metodoCell.getFont().setStyle(Font.BOLD);
        metodoCell.getFont().setStyle(Font.FontFamily.HELVETICA.name());
        table.addCell(metodoCell);

        Paragraph numLinesCell = new Paragraph("Nº líneas");
        numLinesCell.getFont().setStyle(Font.BOLD);
        numLinesCell.getFont().setStyle(Font.FontFamily.HELVETICA.name());
        table.addCell(numLinesCell);

        Paragraph coberturaCell = new Paragraph("¿Con test?");
        coberturaCell.getFont().setStyle(Font.BOLD);
        coberturaCell.getFont().setStyle(Font.FontFamily.HELVETICA.name());
        table.addCell(coberturaCell);

        Map<String, Integer> clasesToTest = new HashMap<>();
        Map<String, Integer> packagesToTest = new HashMap<>();
        long numTotalLineas = 0;
        long numMethods = 0;
        int cubiertos = 0;
        Font smallfont = new Font(Font.FontFamily.HELVETICA, 8);
        // Llenar la tabla con datos de listaTareas
        for (Tarea tarea : metodos) {
            numMethods++;
            Paragraph cell1 = new Paragraph(tarea.getPackageName());
            cell1.setFont(smallfont);
            table.addCell(cell1);
            packagesToTest.merge(tarea.getPackageName(), 1, Integer::sum);

            Paragraph cell2 = new Paragraph(tarea.getClassName());
            cell2.setFont(smallfont);
            table.addCell(cell2);
            clasesToTest.merge(tarea.getClassName(), 1, Integer::sum);

            Paragraph cell3 = new Paragraph(tarea.getMethodName());
            cell3.setFont(smallfont);
            table.addCell(cell3);

            numTotalLineas += tarea.getNumLines();
            Paragraph cell4 = new Paragraph(tarea.getNumLines());
            cell4.setFont(smallfont);
            table.addCell(cell4);
            if (tarea.getCoverage()) {
                cubiertos++;
            }
            Paragraph cell5 = new Paragraph(tarea.getCoverage() ? "Sí" : "No");
            cell5.setFont(smallfont);
            table.addCell(cell5);

        }
        document.add(table);

        Double porcentaje = 100*Double.valueOf(cubiertos / metodos.size());

        /** tabla de totalizadores **/
        PdfPTable tabTotales = new PdfPTable(1);
        tabTotales.setWidthPercentage(60);

        PdfPCell cellBlank11 = new PdfPCell(new Phrase("                     "));
        cellBlank11.setBorder(Rectangle.NO_BORDER);
        PdfPCell cellBlank22 = new PdfPCell(new Phrase("                     "));
        cellBlank22.setBorder(Rectangle.NO_BORDER);
        tabTotales.addCell(cellBlank11);
        tabTotales.addCell(cellBlank22);

        PdfPCell cellTotales1 = new PdfPCell(new Phrase("Número de paquetes a testear:              "
                + packagesToTest.keySet().size()));
        PdfPCell cellTotales2 = new PdfPCell(new Phrase("Número de clases a testear:                 "
                + clasesToTest.keySet().size()));
        PdfPCell cellTotales3 = new PdfPCell(new Phrase("Número de métodos a testear:               "
                + numMethods));
        PdfPCell cellTotales4 = new PdfPCell(new Phrase("Número total de líneas a testear:           "
                + numTotalLineas));
        PdfPCell cellTotales5 = new PdfPCell(new Phrase("Porcentaje de cobertura en tests unitarios: "
                + porcentaje + " %"));
        cellTotales5.setBorder(Rectangle.BOX);
        cellTotales5.setBackgroundColor(new BaseColor(255,255,45));

        tabTotales.addCell(cellTotales1);
        tabTotales.addCell(cellTotales2);
        tabTotales.addCell(cellTotales3);
        tabTotales.addCell(cellTotales4);
        tabTotales.addCell(cellTotales5);
        document.add(tabTotales);

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
