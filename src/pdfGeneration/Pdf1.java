/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdfGeneration;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import com.sun.scenario.effect.ImageData;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author admin
 */
public class Pdf1 {

    String FILE_NAME = "report/" + new Date().toString().replace(":", "") + " itext.pdf";
    String imgName = "02.jpg";

    Font H16 = new Font(Font.FontFamily.HELVETICA, 16, Font.NORMAL, BaseColor.BLACK);
    Font H16B = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD, BaseColor.BLACK);
    Font H15 = new Font(Font.FontFamily.HELVETICA, 15, Font.NORMAL, BaseColor.BLACK);
    Font H15B = new Font(Font.FontFamily.HELVETICA, 15, Font.BOLD, BaseColor.BLACK);
    Font H14 = new Font(Font.FontFamily.HELVETICA, 14, Font.NORMAL, BaseColor.BLACK);
    Font H14B = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.BLACK);
    Font H13 = new Font(Font.FontFamily.HELVETICA, 13, Font.NORMAL, BaseColor.BLACK);
    Font H13B = new Font(Font.FontFamily.HELVETICA, 13, Font.BOLD, BaseColor.BLACK);
    Font H12 = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL, BaseColor.BLACK);
    Font H12B = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLACK);
    Font H11 = new Font(Font.FontFamily.HELVETICA, 11, Font.NORMAL, BaseColor.BLACK);
    Font H11B = new Font(Font.FontFamily.HELVETICA, 11, Font.BOLD, BaseColor.BLACK);
    Font H10 = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL, BaseColor.BLACK);
    Font H10B = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.BLACK);
    Font H9 = new Font(Font.FontFamily.HELVETICA, 9, Font.NORMAL, BaseColor.BLACK);
    Font H9B = new Font(Font.FontFamily.HELVETICA, 9, Font.BOLD, BaseColor.BLACK);
    Font H8 = new Font(Font.FontFamily.HELVETICA, 8, Font.NORMAL, BaseColor.BLACK);
    Font H8B = new Font(Font.FontFamily.HELVETICA, 8, Font.BOLD, BaseColor.BLACK);

    public Pdf1() {
        createPdf(FILE_NAME);
    }

    public static void main(String[] args) {
        new Pdf1();
    }

    private void createPdf(String FILE_NAME) {
        try {
            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, new FileOutputStream(new File(FILE_NAME)));
            document.open();

            //paragraph
            document.add(new Paragraph("Lorem Lipsum", H16B));
            document.add(new Paragraph("Lorem Lipsum", H16));
            document.add(new Paragraph("Lorem Lipsum", H14B));
            document.add(new Paragraph("Lorem Lipsum", H14));
            document.add(new Paragraph("Lorem Lipsum", H12B));
            document.add(new Paragraph("Lorem Lipsum", H12));
            document.add(new Paragraph("Lorem Lipsum", H10B));
            document.add(new Paragraph("Lorem Lipsum", H10));

            //Image
            Image image1 = Image.getInstance(imgName);
            document.add(image1);

            document.add(new Paragraph("\n"));
            //Table
            PdfPTable tb1 = new PdfPTable(3);
//            tb1.setHorizontalAlignment(Element.ALIGN_RIGHT);
            tb1.setWidthPercentage(100);
            tb1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            tb1.addCell(new Paragraph("Call 00", H16));
            tb1.addCell("cell 01");
            tb1.addCell("cell 02");

            tb1.addCell("cell 10");
            tb1.addCell("cell 11");
            tb1.addCell("cell 12");

            PdfPCell pcell = new PdfPCell(new Paragraph("demo 1"));
            pcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            tb1.addCell(pcell);
            PdfPCell pcell2 = new PdfPCell(new Paragraph("demo 2 "));
            pcell2.setHorizontalAlignment(Element.ALIGN_RIGHT);
            pcell2.setColspan(2);
            tb1.addCell(pcell2);
          

            document.add(tb1);
            float[] NoCol= {1,5,3};
            PdfPTable tb2 = new PdfPTable(NoCol);
            tb2.setWidthPercentage(100);
            tb2.getDefaultCell().setBorder(0);
            tb2.addCell(new Paragraph("Call 00", H16));
            tb2.addCell("cell 01");
            tb2.addCell(image1);

            tb2.addCell("cell 10");
            tb2.addCell("cell 11");
            tb2.addCell("cell 12");
            
            tb2.addCell(new Paragraph("Call 00", H16));
            tb2.addCell("cell 01");
            tb2.addCell("cell 02");

            tb2.addCell("cell 10");
            tb2.addCell("cell 11");
            tb2.addCell("cell 12");
            
            document.add(tb2);

            document.close();

            /* opening file if exists */
            try {
                if (new File(FILE_NAME).exists()) {

                    File myFile = new File(FILE_NAME);
                    Desktop.getDesktop().open(myFile);
                    System.out.println(FILE_NAME);

                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }

        } catch (DocumentException ex) {
            Logger.getLogger(Pdf1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Pdf1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Pdf1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
