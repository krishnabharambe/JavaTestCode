/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Word;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class CreateWord {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        XWPFDocument document = new XWPFDocument();
        try (OutputStream fileOut = new FileOutputStream("Javatpoint.doc")) {
           
            XWPFTable table = document.createTable();
            XWPFTableRow TableRowOne = table.getRow(0);
            TableRowOne.getCell(0).setText("col one,row one");
            TableRowOne.addNewTableCell().setText("col two, row one");
            TableRowOne.addNewTableCell().setText("col three, row one");

            //create second row
            XWPFTableRow TableRowTwo = table.createRow();
            TableRowTwo.getCell(0).setText("col one, row two");
            TableRowTwo.getCell(1).setText("col two, row two");
            TableRowTwo.getCell(2).setText("col three, row two");

            //create third row
            XWPFTableRow TableRowThree = table.createRow();
            TableRowThree.getCell(0).setText("col one, row three");
            TableRowThree.getCell(1).setText("col two, row three");
            TableRowThree.getCell(2).setText("col three, row three");

            document.write(fileOut);
            System.out.println("File created");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
