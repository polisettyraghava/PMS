package com.Pms;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
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

public class dashboarddisplayLink_url
{
	FirefoxDriver driver;
	@BeforeTest
	public void setup() {

		 driver = new FirefoxDriver();
		driver.get("http://antarvani.com/ikhya_pms1/index.php/portal/admin/logincontroller");
	    driver.manage().window().maximize();
	}
	
	@Test
	public void login() throws IOException 
	{
		
		driver.findElement(By.name("mobile_number")).sendKeys("9848804212");
		driver.findElement(By.name("password")).sendKeys("12345");
		WebElement rtype=driver.findElement(By.id("roletype_id"));  
		Select roletype= new Select(rtype);
		roletype.selectByVisibleText("Admin");
		driver.findElement(By.name("submit")).click();
		
		FileInputStream file = new FileInputStream("C:\\Projects\\learnAutomation\\src\\testfiles\\PMS_LinksName.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(file);
		XSSFSheet sheet = workBook.getSheet("Sheet1");
		
		WebElement ctrb=driver.findElement(By.xpath("html/body/div[1]/aside/section/ul/li/ul"));
		List<WebElement>LinksNames=ctrb.findElements(By.tagName("a"));

		System.out.println("total links in pms is:"+LinksNames.size());
		
		for(int i=0;i<=LinksNames.size();i++)
		{
			Row r=sheet.createRow(i);
			Cell c=r.createCell(0);
			Cell c1=r.createCell(1);
			
			String Linkname=LinksNames.get(i).getText();
			System.out.println(i+" "+Linkname);		
			String url=driver.getCurrentUrl();
   			System.out.println(" "+url);

            LinksNames.get(i).click();
			c.setCellValue(Linkname);
			c1.setCellValue(url);
               
              System.out.println(driver.getTitle());
   			System.out.println(driver.getCurrentUrl());
   			System.out.println();
			Sleeper.sleepTightInSeconds(10);

			driver.navigate().back();
			ctrb=driver.findElement(By.xpath("html/body/div[1]/aside/section/ul/li/ul"));
			LinksNames=ctrb.findElements(By.tagName("a"));
		} 
			
			
		
		
		
		
	
FileOutputStream file1 = new FileOutputStream("C:\\Projects\\learnAutomation\\src\\testfiles\\PMS_LinksName.xlsx");
workBook.write(file1);
workBook.close();
}
		
@AfterTest
public void teardown() {
	driver.close();

		
	}

}


