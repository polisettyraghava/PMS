package com.Register;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Newtours_Webapp_Links {

	
		public static void main(String[] args) throws IOException
		{
			FirefoxDriver driver = new FirefoxDriver();
			driver.get("http://newtours.demoaut.com");
			
	    List<WebElement>links= driver.findElements(By.tagName("a"));
	       int  linksCount=links.size();
	       System.out.println("the total no of links are:" + linksCount);
	       for(int i=0;i<links.size();i++) 
	       {
	    String LinkName = links.get(i).getText();
	            System.out.println(i+ " "+ LinkName);
	            links.get(i).click();
	            System.out.println(driver.getTitle());
	            System.out.println(driver.getCurrentUrl());            
	            System.out.println();
	            
	            
	            driver.navigate().back();
	            
	            links=driver.findElements(By.tagName("a"));
	            
	       
	            FileInputStream file = new FileInputStream("C:\\Projects\\Com.Validations\\src\\com\\ExcelTestDataFiles\\newtours_links.xlsx");
	            XSSFWorkbook workbook = new XSSFWorkbook(file);
	            XSSFSheet sheet = workbook.getSheet("Sheet1");
	            int rowcount = sheet.getLastRowNum();
	    		for(int j=0;i<=rowcount;i++)
	    		{
	            String data= sheet.getRow(j).getCell(1).getStringCellValue();
	            System.out.println(data);
	            System.out.println(driver.getCurrentUrl());
	            
	            String expected_data = data;
	            String Actual_data = LinkName;
	            if(Actual_data.equals(expected_data))
	            {
	            	System.out.println("matched");
	            }
	            else
	            {
	            	System.out.println("not matched");
	            }
	            
	            
	           /* FileInputStream file = new FileInputStream("C:\\Projects\\Com.Validations\\src\\com\\ExcelTestDataFiles\\newtours_links.xlsx");
	            XSSFWorkbook workbook = new XSSFWorkbook(file);
	            XSSFSheet sheet = workbook.getSheet("Sheet1");
	            int rowcount = sheet.getLastRowNum();
	    		for(int j=1;i<=rowcount;i++)
	    		{
	    			Row r = sheet.getRow(j);
	    			
	    			Cell c = r.getCell(1);
	    			
	    			String data = c.getStringCellValue();
	    			
	    			System.out.println(data);
	            String expected_data = data;
	            String Actual_data = driver.getTitle();
	            if(Actual_data.equals(expected_data))
	            {
	            	System.out.println("matched");
	            }
	            else
	            {
	            	System.out.println("not matched");
	            }
	            }*/
	            
	       }

		driver.close();
		}
		
		}
}

