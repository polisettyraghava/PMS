package com.ExcelOperations;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetData_in_ExcelFile {

	public static void main(String[] args) throws IOException 
	{
      FileInputStream file = new FileInputStream("C:\\Projects\\Com.Validations\\src\\com\\ExcelTestDataFiles\\TestData.xlsx");
	   XSSFWorkbook WorkBook = new XSSFWorkbook(file);
	   XSSFSheet sheet=WorkBook.getSheet("Sheet1");
	  Row r=sheet.getRow(0);
	  Cell c=r.getCell(0);
	 String data =c.getStringCellValue();
	 System.out.println(data);
	WorkBook.close();
	}

}
