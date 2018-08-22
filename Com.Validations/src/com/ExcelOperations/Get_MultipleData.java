package com.ExcelOperations;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Get_MultipleData {

	public static void main(String[] args) throws IOException
	{
		FileInputStream file1 = new FileInputStream("C:\\Projects\\Com.Validations\\src\\com\\ExcelTestDataFiles\\MultipleTestData.xlsx");
        XSSFWorkbook WorkBook = new XSSFWorkbook(file1);
		XSSFSheet sheet = WorkBook.getSheet("Sheet1");
		    int RowCount=sheet.getLastRowNum();
		    for(int k=0;k<=RowCount;k++)
		    {
		    	Row r= sheet.getRow(k);
		    	int CellCount = r.getLastCellNum();
		    	for(int j=0;j<CellCount;j++) 
		    	{
		    		Cell c=r.getCell(j);
		    		String data = c.getStringCellValue();
		    		System.out.print(data+" ");
		    		
		    	}
		  
		System.out.println();
		WorkBook.close();
		    }
		    }

	
}
