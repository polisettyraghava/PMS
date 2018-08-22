package com.Pms;

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
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest_pms_MultipleData 
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
		public void logIn() throws IOException
		{
			
			FileInputStream file = new FileInputStream("C:\\Projects\\Practise\\src\\com\\TestDataFiles\\PMS_LoginData.xlsx");
			XSSFWorkbook workBook = new XSSFWorkbook(file);
			XSSFSheet sheet = workBook.getSheet("Sheet1");
			
			int RowCount=sheet.getLastRowNum();
			   System.out.println("the number of rows are:"+RowCount);

			
			   for(int i=0;i<=RowCount;i++) {
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
					
					String expected_data ="http://antarvani.com/ikhya_pms1/index.php/portal/admin/dashboardcontroller";
					String Actual_data = driver.getCurrentUrl();
					System.out.println("expected_data is:"+expected_data);

					System.out.println("Actual_data is:"+Actual_data);

					if(Actual_data.equals(expected_data))
					{
						System.out.println("data matched-login pass-pass");
						r.createCell(2).setCellValue("data Matched-pass");
						Sleeper.sleepTightInSeconds(10);
						driver.findElement(By.xpath("html/body/div[1]/aside/section/ul/li/ul/li[16]/a/span[2]")).click();
					}
					else
					{
						System.out.println("data not matched-fail-fail");
						r.createCell(2).setCellValue("data not Matched-fail");
					}
					
					
			FileOutputStream file1 = new FileOutputStream("C:\\Projects\\Practise\\src\\PMS_LoginData.xlsx");
			workBook.write(file1);
			
				
				driver.navigate().back();
				
			} 
		}	   
			   @AfterTest
			   public void teardown() {
				   driver.close();
			   }
}
