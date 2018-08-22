package com.uploadFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Upload_Files {

	public static void main(String[] args) 
	{

		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://kriyative-edge.com/careercontroller");
	driver.findElement(By.linkText("Apply Here")).click();
	//upload.sendKeys("‪C:\\Users\\Raghava\\Desktop\\test.xlsx");
	//driver.findElement(By.id("terms")).click();
	//driver.findElement(By.id("submitbutton")).click();
	System.out.println("application uploaded");
	driver.close();
	}

}
