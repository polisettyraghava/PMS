package com.ConsoleData_Display_Excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PMS_Login
{
	FirefoxDriver driver;
   @BeforeTest
   public void setup() {
	 driver= new FirefoxDriver();
	 driver.get("http://newtours.demoaut.com");
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   }
  
   @Test
   public void Login() throws IOException {
	   
	   FileInputStream file = new FileInputStream("C:\\Projects\\Com.Validations\\src\\com\\ResultData\\PMS_RESULT.xlsx");
	   XSSFWorkbook workBook = new XSSFWorkbook(file);
	   XSSFSheet sheet = workBook.getSheet("Sheet1");
	   	   
	   int rowCount = sheet.getLastRowNum();
	   
	   for(int i=0;i<rowCount;i++) {
		   Row r = sheet.getRow(i);
		   driver.findElement(By.name("userName")).sendKeys(r.getCell(0).getStringCellValue());
		   driver.findElement(By.name("password")).sendKeys(r.getCell(1).getStringCellValue());
		   
			driver.findElement(By.name("login")).click();
			
			String expected_Title ="find";
			String Actual_Title = driver.getTitle();

			if(Actual_Title.contains(expected_Title))
			{
				System.out.println("title matched-login pass-pass");
				r.createCell(2).setCellValue("TILE Matched-pass");
				
			}
			else
			{
				System.out.println("title not matched-fail-fail");
				r.createCell(2).setCellValue("login fail-fail");
			}
			
			FileOutputStream file1 = new FileOutputStream("C:\\Projects\\Com.Validations\\src\\com\\ResultData\\PMS_OUTPUT.xlsx");
			workBook.write(file1);
			driver.navigate().back();
		
	   }
   }
   
   @AfterTest
   public void teardown() {
	   driver.close();
   }
}

