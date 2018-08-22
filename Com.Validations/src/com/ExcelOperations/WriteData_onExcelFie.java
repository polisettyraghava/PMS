package com.ExcelOperations;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteData_onExcelFie {

	public static void main(String[] args) throws IOException
	{
      FileInputStream file = new FileInputStream("C:\\Projects\\Com.Validations\\src\\com\\ExcelTestDataFiles\\TestData.xlsx");
		XSSFWorkbook WorkBook = new XSSFWorkbook(file);
		XSSFSheet sheet = WorkBook.getSheet("Sheet1");
		Row r=sheet.createRow(4);
		Cell c= r.createCell(4);
		c.setCellValue("raghava");
		
		FileOutputStream file1 = new FileOutputStream("C:\\Projects\\Com.Validations\\src\\com\\ExcelTestDataFiles\\TestData.xlsx");
	    WorkBook.write(file1);
	    WorkBook.close();
	    file1.close();
	}

}
