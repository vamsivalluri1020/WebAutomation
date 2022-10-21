package excelAcess;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class test1 {
    public static void main(String[] args) throws Exception {


        String projectpath = System.getProperty("user.dir");
        FileInputStream fr = new FileInputStream(projectpath + "\\src\\test\\resources\\properties\\Book1.xlsx");
        Workbook wb = WorkbookFactory.create(fr);
        Sheet sheet = wb.getSheet("Sheet1");
        int nour = sheet.getPhysicalNumberOfRows();
        System.out.println(nour);
        //0th row(first row) in excel file sheet is having names of columns
        for (int i = 1; i < nour; i++) {
            DataFormatter df = new DataFormatter();
            String to = df.formatCellValue(sheet.getRow(i).getCell(0));
            String subj = df.formatCellValue(sheet.getRow(i).getCell(1));
            String body = df.formatCellValue(sheet.getRow(i).getCell(2));
            String attachfile = df.formatCellValue(sheet.getRow(i).getCell(3));
            System.out.println(to + subj + body + attachfile);
        }
    }
}
