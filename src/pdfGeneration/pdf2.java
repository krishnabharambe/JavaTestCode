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
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class pdf2 {

    String filename = "report/" + new Date().toString().replace(":", "") + "hello.pdf";
    String image = "02.jpg";

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

    public pdf2() {
        createpdf(filename);
    }

    public static void main(String[] args) {
        new pdf2();
    }

    private void createpdf(String filename) {
        try {
            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, new FileOutputStream(new File(filename)));
            document.open();
            Image image1 = Image.getInstance(image);
            
            //Top Table
            //table
            PdfPTable tb2 = new PdfPTable(1);
            tb2.setWidthPercentage(100);
            tb2.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            tb2.getDefaultCell().setBorder(0);
            tb2.addCell(new Paragraph("GST INVOICE", H14B));
            document.add(tb2);
            
            //tbe
            float[] f = {3, 8};
            PdfPTable tb3 = new PdfPTable(f);
            tb3.setWidthPercentage(100);
            tb3.getDefaultCell().setFixedHeight(100);
            PdfPCell pcell1 =  new PdfPCell(image1);
            pcell1.setBorder(Rectangle.BOTTOM | Rectangle.TOP | Rectangle.LEFT);
            tb3.addCell(pcell1);
            
            PdfPTable tb4=new PdfPTable(1);
            tb4.setWidthPercentage(100);
            tb4.getDefaultCell().setBorder(0);
            tb4.getDefaultCell().setPaddingRight(4);
            tb4.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
            tb4.addCell(new Paragraph("Mr. Krishna Bharambe",H12B));
            tb4.addCell("hii");
            tb4.addCell("hello");
            
            PdfPCell pcell2 =  new PdfPCell(tb4);
            pcell2.setHorizontalAlignment(Element.ALIGN_RIGHT);
            pcell2.setBorder(Rectangle.BOTTOM | Rectangle.TOP | Rectangle.RIGHT);
            tb3.addCell(pcell2);
            document.add(tb3);
            
            document.close();

            /* opening file if exists */
            try {
                if (new File(filename).exists()) {

                    File myFile = new File(filename);
                    Desktop.getDesktop().open(myFile);
                    System.out.println(filename);

                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        } catch (DocumentException ex) {
            Logger.getLogger(pdf2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(pdf2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(pdf2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
