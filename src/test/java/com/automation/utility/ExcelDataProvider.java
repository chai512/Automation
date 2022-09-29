package com.automation.utility;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelDataProvider {

    public Workbook wb;
    public ExcelDataProvider(){

        File src = new File("D:\\Automation\\Testdata\\ExcelData.xlsx");
        try {
            FileInputStream fis = new FileInputStream(src);
            wb = new HSSFWorkbook(fis);

        } catch (Exception e) {
            System.out.println("No Excel found in specified path");
        }
    }

    public String getStringData(String sheetName, int rows, int columns){
        return  wb.getSheet(sheetName).getRow(rows).getCell(columns).getStringCellValue();
    }

    public String getStringData(int sheetNum, int rows, int columns){
        return  wb.getSheetAt(sheetNum).getRow(rows).getCell(columns).getStringCellValue();
    }

    public double getNumericData(String sheetName, int rows, int columns){
        return  wb.getSheet(sheetName).getRow(rows).getCell(columns).getNumericCellValue();
    }

}
