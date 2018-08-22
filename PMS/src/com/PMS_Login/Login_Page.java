package com.PMS_Login;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login_Page 
{
	FirefoxDriver driver;
	   @BeforeTest
	   public void setup() {
		 driver= new FirefoxDriver();
		 driver.get("http://antarvani.com/ikhya_pms1/index.php/portal/admin/logincontroller");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   }
	  
	   @Test
	   public void Login() throws IOException {
		   
		   FileInputStream file = new FileInputStream("C:\\Projects\\PMS\\src\\PMS_ExcelData\\PMS_LoginData.xlsx");
		   XSSFWorkbook workBook = new XSSFWorkbook(file);
		   XSSFSheet sheet = workBook.getSheet("Sheet1");
		   	   
		   int rowCount = sheet.getLastRowNum();
		   System.out.println("the number of rows are:"+rowCount);
		   
		   for(int i=0;i<=rowCount;i++) {
			   Row r = sheet.getRow(i);
			   double d= r.getCell(0).getNumericCellValue();
		          long x = (long)d;
		          String phoneNumber = Long.toString(x);
			   driver.findElement(By.name("mobile_number")).sendKeys(phoneNumber);
			   double p= r.getCell(1).getNumericCellValue();
		          long y = (long)p;
		          String pin = Long.toString(y);
			   driver.findElement(By.name("password")).sendKeys(pin);
			   WebElement rtype=driver.findElement(By.id("roletype_id"));  
				Select roletype= new Select(rtype);
				roletype.selectByVisibleText("Admin");
				driver.findElement(By.name("submit")).click();
				System.out.println(driver.getCurrentUrl());
				
				String expected_data ="http://antarvani.com/ikhya_pms1/index.php/portal/admin/dashboardcontroller";
				String Actual_data = driver.getCurrentUrl();
				System.out.println("expected_data is:"+expected_data);

				System.out.println("Actual_data is:"+Actual_data);

				if(Actual_data.equals(expected_data))
				{
					System.out.println("data matched-login pass-pass");
					r.createCell(2).setCellValue("data Matched-pass");
					
				}
				else
				{
					System.out.println("data not matched-fail-fail");
					r.createCell(2).setCellValue("data not Matched-pass");
				}
				
				FileOutputStream file1 = new FileOutputStream("C:\\Projects\\PMS\\src\\PMS_ExcelData\\PMS_LoginData.xlsx");
				workBook.write(file1);
				driver.navigate().back();
			
		   }
	   }
	   
	  @AfterTest
	   public void teardown() {
		   driver.quit();
	   }	
     	
}
