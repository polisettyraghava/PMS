package com.ConsoleData_Display_Excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Newtours_Register_Countrynames 
{
  FirefoxDriver driver;
  
  @BeforeTest
  public void setup() {
	  driver = new FirefoxDriver();
	  driver.get("http://newtours.demoaut.com");
	  driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }
  
  @Test(priority=0)
  public void Login() {
	  driver.findElement(By.linkText("REGISTER")).click();
	  
  }
  
  @Test(priority=1)
  public void Country() throws IOException {
	  
	  FileInputStream file= new FileInputStream("C:\\Projects\\Com.Validations\\src\\com\\ResultData\\NewTours_Result.xlsx");
      XSSFWorkbook workBook = new XSSFWorkbook(file);
      XSSFSheet sheet = workBook.getSheet("Sheet1");
      
      WebElement country = driver.findElement(By.name("country"));
          List<WebElement>countrynames= driver.findElements(By.tagName("option"));
          System.out.println(countrynames.size());
          
         for(int i=0;i<countrynames.size();i++) {
        	 Row r = sheet.createRow(i);
        	 Cell c = r.createCell(0);
        	 String countryname= countrynames.get(i).getText();
        	 System.out.println(countryname);
        	 c.setCellValue(countryname);
        	 FileOutputStream file1 = new FileOutputStream("C:\\Projects\\Com.Validations\\src\\com\\ResultData\\NewTours_Result.xlsx");
        	 workBook.write(file1);
         }
  }
  @AfterTest
  public void teardown() {
	  driver.close();
  }
  }

