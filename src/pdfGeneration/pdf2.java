/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdfGeneration;

import Database.db;
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
import java.sql.ResultSet;
import java.sql.SQLException;
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
            PdfPCell pcell1 = new PdfPCell(image1);
            pcell1.setBorder(Rectangle.BOTTOM | Rectangle.TOP | Rectangle.LEFT);
            tb3.addCell(pcell1);

            PdfPTable tb4 = new PdfPTable(1);
            tb4.setWidthPercentage(100);
            tb4.getDefaultCell().setBorder(0);
            tb4.getDefaultCell().setPaddingRight(4);
            tb4.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
            tb4.addCell(new Paragraph("Mr. Krishna Bharambe", H12B));
            tb4.addCell("hii");
            tb4.addCell("hello");

            PdfPCell pcell2 = new PdfPCell(tb4);
            pcell2.setHorizontalAlignment(Element.ALIGN_RIGHT);
            pcell2.setBorder(Rectangle.BOTTOM | Rectangle.TOP | Rectangle.RIGHT);
            tb3.addCell(pcell2);
            document.add(tb3);

            PdfPTable tb6 = new PdfPTable(1);
            tb6.setWidthPercentage(100);
            tb6.getDefaultCell().setBorder(0);
            tb6.getDefaultCell().setPaddingRight(4);
            tb6.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
            tb6.addCell(new Paragraph("Mr. Krishna Bharambe", H12B));
            tb6.addCell("hii");
            tb6.addCell("hello");

            PdfPTable tb7 = new PdfPTable(1);
            tb7.getDefaultCell().setBorder(0);
            tb7.addCell("line1");
            tb7.addCell("line2");
            tb7.addCell("line1");

            float[] f2 = {60, 30, 30};
            PdfPTable tb5 = new PdfPTable(f2);
            tb5.setWidthPercentage(100);
            tb5.getDefaultCell().setFixedHeight(60);
            tb5.addCell(tb6);
            tb5.addCell(tb7);
            tb5.addCell(tb7);
            document.add(tb5);

            float f3[] = {20, 60, 30, 30, 30, 30, 30};
            PdfPTable tb8 = new PdfPTable(f3);
            tb8.setWidthPercentage(100);
            tb8.addCell(new Paragraph("Sr.No", H11B));
            tb8.addCell(new Paragraph("Description Of Goods", H11B));
            tb8.addCell(new Paragraph("HSN", H11B));
            tb8.addCell(new Paragraph("Rate", H11B));
            tb8.addCell(new Paragraph("Dis%", H11B));
            tb8.addCell(new Paragraph("Qty", H11B));
            tb8.addCell(new Paragraph("Amount", H11B));

            int rowCounter = 27;

            ResultSet data = db.getdata("select * from transatio2");
            int i = 1;
            while (data.next()) {
                tb8.addCell(new Paragraph(String.valueOf(i), H10));
                tb8.addCell(new Paragraph(data.getString("stockselect"), H10));
                tb8.addCell(new Paragraph("HSN", H10));
                tb8.addCell(new Paragraph(data.getString("price"), H10));
                tb8.addCell(new Paragraph("0", H10));
                tb8.addCell(new Paragraph(data.getString("quantity"), H10));
                tb8.addCell(new Paragraph(data.getString("total"), H10));
                i++;
            }

            tb8.getDefaultCell().setBorder(Rectangle.LEFT);

            int BlackRows = rowCounter - i;
            for (int j = 0; j <= BlackRows; j++) {
                for (int k = 0; k < 6; k++) {
                    tb8.addCell(new Paragraph(" ", H10));
                }
                tb8.getDefaultCell().setBorder(Rectangle.LEFT | Rectangle.RIGHT);
                tb8.addCell(new Paragraph(" ", H10));
                tb8.getDefaultCell().setBorder(Rectangle.LEFT);
            }

            for (int k = 0; k < 5; k++) {
                tb8.addCell(new Paragraph(" ", H10));
            }

            PdfPTable tb10 = new PdfPTable(2);
            tb10.addCell("Taxable");
            tb10.addCell("12.00");
            tb10.addCell("SGST 9%");
            tb10.addCell("1.08");
            tb10.addCell("CGST 9%");
            tb10.addCell("1.08");
            tb10.addCell("Total");
            tb10.addCell("14.16");

            PdfPCell pcell12 = new PdfPCell(tb10);
            pcell12.setColspan(2);
            tb8.addCell(pcell12);

            document.add(tb8);

            PdfPTable tb9 = new PdfPTable(1);
            tb9.setWidthPercentage(100);
            tb9.addCell(new Paragraph("Payable : Rupees Fourteen And Paise Ten Six Only", H11));
            document.add(tb9);

            PdfPTable tb12 = new PdfPTable(1);
            tb12.getDefaultCell().setBorder(0);
            tb12.addCell(new Paragraph("Bank Details",H9B));
            tb12.addCell(new Paragraph("A\\C No. : account 1",H9B));
            tb12.addCell(new Paragraph("IFSC : IFSC 1",H9B));
            tb12.addCell(new Paragraph("Bank & Branch : Buldana",H9B));

            float f4[] = {20, 20, 20, 20, 20, 20, 20, 60};
            PdfPTable tb11 = new PdfPTable(f4);
            tb11.setWidthPercentage(100);
            tb11.addCell(new Paragraph("HSN", H8B));
            tb11.addCell(new Paragraph("TAXABLE", H8B));
            tb11.addCell(new Paragraph("SGST%", H8B));
            tb11.addCell(new Paragraph("SGST", H8B));
            tb11.addCell(new Paragraph("CGST%", H8B));
            tb11.addCell(new Paragraph("CGST", H8B));
            tb11.addCell(new Paragraph("TOTAL GST", H8B));
            PdfPCell pcell13 = new PdfPCell(tb12);
            pcell13.setRowspan(7);
            tb11.addCell(pcell13);

            tb11.addCell(new Paragraph("HSN", H8));
            tb11.addCell(new Paragraph("TAXABLE", H8));
            tb11.addCell(new Paragraph("SGST%", H8));
            tb11.addCell(new Paragraph("SGST", H8));
            tb11.addCell(new Paragraph("CGST%", H8));
            tb11.addCell(new Paragraph("CGST", H8));
            tb11.addCell(new Paragraph("TOTAL GST", H8));
            
            tb11.addCell(new Paragraph("HSN", H8));
            tb11.addCell(new Paragraph("TAXABLE", H8));
            tb11.addCell(new Paragraph("SGST%", H8));
            tb11.addCell(new Paragraph("SGST", H8));
            tb11.addCell(new Paragraph("CGST%", H8));
            tb11.addCell(new Paragraph("CGST", H8));
            tb11.addCell(new Paragraph("TOTAL GST", H8));

            tb11.addCell(new Paragraph("HSN", H8));
            tb11.addCell(new Paragraph("TAXABLE", H8));
            tb11.addCell(new Paragraph("SGST%", H8));
            tb11.addCell(new Paragraph("SGST", H8));
            tb11.addCell(new Paragraph("CGST%", H8));
            tb11.addCell(new Paragraph("CGST", H8));
            tb11.addCell(new Paragraph("TOTAL GST", H8));

            tb11.addCell(new Paragraph("HSN", H8));
            tb11.addCell(new Paragraph("TAXABLE", H8));
            tb11.addCell(new Paragraph("SGST%", H8));
            tb11.addCell(new Paragraph("SGST", H8));
            tb11.addCell(new Paragraph("CGST%", H8));
            tb11.addCell(new Paragraph("CGST", H8));
            tb11.addCell(new Paragraph("TOTAL GST", H8));

            tb11.addCell(new Paragraph("Total(Rs.)", H8B));
            tb11.addCell(new Paragraph("12.00", H8B));
            tb11.addCell(new Paragraph("", H8B));
            tb11.addCell(new Paragraph("1.08", H8B));
            tb11.addCell(new Paragraph("", H8B));
            tb11.addCell(new Paragraph("1.08", H8B));
            tb11.addCell(new Paragraph("2.16", H8B));

            document.add(tb11);

            PdfPTable tb13 = new PdfPTable(1);
            tb13.setWidthPercentage(100);
            tb13.addCell(new Paragraph("Total GST : Rupees Two And Paise Ten Six Only", H11));
            document.add(tb13);

            PdfPTable tb15 = new PdfPTable(1);
            tb15.getDefaultCell().setBorder(0);
            tb15.addCell(new Paragraph("Terms & Condition",H10));
            tb15.addCell(new Paragraph("gaagagaggaga",H8));

            PdfPTable tb16 = new PdfPTable(1);
            tb16.getDefaultCell().setBorder(0);
            tb16.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            tb16.addCell (new Paragraph("FOR RAVIKIRAN ENTERPRISES",H10B));
            tb16.addCell("\n");
            tb16.addCell("Authorised Signatury");
            tb16.addCell("\n");
            tb16.addCell("\n");

            PdfPTable tb17 = new PdfPTable(1);
            tb17.getDefaultCell().setBorder(0);
            tb17.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);

            tb17.addCell("\n");
            tb17.addCell("\n");

            tb17.addCell(new Paragraph("Customer Seal & Signature", H10));

            float[] f5 = {35, 35, 50};
            PdfPTable tb14 = new PdfPTable(f5);
            tb14.setWidthPercentage(100);
            tb14.getDefaultCell().setBorder(Rectangle.LEFT|Rectangle.BOTTOM );
            tb14.addCell(tb15);
            tb14.getDefaultCell().setBorder(Rectangle.RIGHT|Rectangle.BOTTOM );
            tb14.addCell(tb17);
            tb14.addCell(tb16);

            document.add(tb14);

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
        } catch (DocumentException | SQLException ex) {
            Logger.getLogger(pdf2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(pdf2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(pdf2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
