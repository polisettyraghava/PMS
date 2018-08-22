package com.TitleValidate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.ui.Select;

public class PMS_Title {

	public static void main(String[] args) 
	{
      FirefoxDriver driver = new FirefoxDriver();
      driver.get("http://www.antarvani.com/pms_test_0713/index.php/portal/admin/logincontroller");
      driver.manage().window().maximize();
      WebElement name=driver.findElement(By.name("mobile_number"));
		name.sendKeys("9848804212");
	WebElement password=driver.findElement(By.name("password"));
	    password.sendKeys("12345");
	     WebElement rtype=driver.findElement(By.id("roletype_id"));
	     
	Select roletype= new Select(rtype);
	roletype.selectByVisibleText("Admin");
    WebElement checkbox=driver.findElement(By.cssSelector(".cr-icon.icofont.icofont-ui-check.txt-primary"));
     checkbox.click();
	WebElement signin= driver.findElement(By.name("submit"));
	signin.click();
	
	
      
     /* String expectedTitle = "Facebook";
		
		String actualTitle =driver.getTitle();
		
		System.out.println("expected title is:"+expectedTitle);
		System.out.println("actual Title is:"+actualTitle);
		
		if(actualTitle.contains(expectedTitle))
		{
			System.out.println("matching found--pass");
		}
		else
		{
			System.out.println("matching not found--fail");
		}	
		}*/

	Sleeper.sleepTightInSeconds(6);
	WebElement department=driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div/nav/div[2]/div/div[1]/div/ul/li[2]/a/span[1]/i"));
	department.click();
	String ExpectedTitle="Patient Management System | IKHYA";
    String ActualTitle=driver.getCurrentUrl();
   System.out.println("Expected Title is:" +ExpectedTitle);
   System.out.println("Actual Title is:" +ActualTitle);
   if(ActualTitle.equals(ExpectedTitle))
	{
		System.out.println("Title Matched -- PASS");
	}
	else
	{
		System.out.println("Title not matched -- FAIL");
	}
   driver.close();
}
	
}
