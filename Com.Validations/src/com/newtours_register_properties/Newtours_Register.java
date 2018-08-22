package com.newtours_register_properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Newtours_Register {
	
	ChromeDriver driver;
	String url = "http://newtours.demoaut.com";
	
	@BeforeTest
	public void Setup() 
	{
         System.setProperty("webdriver.chrome.driver", "C:\\Projects\\Com.Validations\\Drivers\\chromedriver.exe");
         driver = new ChromeDriver();
         driver.get(url);
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void Register() throws IOException
	{
		FileInputStream file = new FileInputStream("C:\\Projects\\Com.Validations\\new_tours_register.properties");
		Properties pr = new Properties();
		pr.load(file);
		driver.findElement(By.linkText(pr.getProperty("register"))).click();
		driver.findElement(By.name(pr.getProperty("firstname"))).sendKeys("raghava");
		driver.findElement(By.name(pr.getProperty("lastname"))).sendKeys("rag");
		driver.findElement(By.name(pr.getProperty("phoneNumber"))).sendKeys("999999999");
		driver.findElement(By.id(pr.getProperty("email"))).sendKeys("rag@gmail.com");
		driver.findElement(By.name(pr.getProperty("address"))).sendKeys("inkollu");
		driver.findElement(By.name(pr.getProperty("city"))).sendKeys("hyderabad");
		driver.findElement(By.name(pr.getProperty("stateName"))).sendKeys("telangana");
		driver.findElement(By.name(pr.getProperty("postalcode"))).sendKeys("500003");
		driver.findElement(By.name(pr.getProperty("country"))).sendKeys("india");
		driver.findElement(By.id(pr.getProperty("username"))).sendKeys("raghavendra");
		driver.findElement(By.name(pr.getProperty("password"))).sendKeys("12345");
		driver.findElement(By.name(pr.getProperty("confirmpassword"))).sendKeys("12345");
		driver.findElement(By.name(pr.getProperty("submit"))).click();
		System.out.println("registration successful");
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
}
