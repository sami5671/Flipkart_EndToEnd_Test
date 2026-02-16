package com.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	String filePath = System.getProperty("user.dir")
            + "/src/test/resources/TestData/TestData.xlsx";

    public String excelRead(String sheetName, int rowNumber, int cellNumber) throws IOException {

        

        File file = new File(filePath);

        if (!file.exists()) {
            throw new IOException("Excel file not found at: " + file.getAbsolutePath());
        }

        try (FileInputStream fis = new FileInputStream(file);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new RuntimeException("Sheet not found: " + sheetName);
            }

            Row row = sheet.getRow(rowNumber);
            if (row == null) return null;

            Cell cell = row.getCell(cellNumber);
            if (cell == null) return null;

            return new DataFormatter().formatCellValue(cell);
        }
    }
    
   // ================= WRITE =================
    public void excelWrite(String sheetName, int rowNumber,
                           int cellNumber, String text) throws IOException {

        File file = new File(filePath);

        try (FileInputStream fis = new FileInputStream(file);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);

            if (sheet == null)
                sheet = workbook.createSheet(sheetName);

            Row row = sheet.getRow(rowNumber);
            if (row == null)
                row = sheet.createRow(rowNumber);

            Cell cell = row.getCell(cellNumber);
            if (cell == null)
                cell = row.createCell(cellNumber);

            cell.setCellValue(text);

            try (FileOutputStream fos = new FileOutputStream(file)) {
                workbook.write(fos);
            }
        }
    }
    
    
}
