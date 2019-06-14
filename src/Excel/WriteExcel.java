/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author admin
 */
public class WriteExcel {

    public static void main(String[] args) {
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("FirstExcelSheet");
            HSSFRow row = null;

            HSSFCell cell = null;
            for (int i = 0; i <= 10; i++) {
                row = sheet.createRow(i);
                for (int j = 0; j < 15; j++) {
                    cell = row.createCell(j);
                    cell.setCellValue("X= " + i + "Y = " + j);
                }
            }
            workbook.write(new FileOutputStream("excel.xls"));

        } catch (IOException ex) {
            Logger.getLogger(WriteExcel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
