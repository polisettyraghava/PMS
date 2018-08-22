package com.Dropdowns;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;

public class Dropdown {

	public static void main(String[] args) throws IOException 
	{

		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://newtours.demoaut.com");
		Sleeper.sleepTightInSeconds(5);
		driver.findElementByLinkText("REGISTER").click();
		WebElement country=driver.findElement(By.name("country"));
		List<WebElement>countrynames=country.findElements(By.tagName("option"));
		System.out.println(countrynames.size());
		for(int i=0;i<countrynames.size();i++)
		{
			String countryname=countrynames.get(i).getText();
			System.out.println(i+" "+countryname);
		}
		
		 
		driver.close();
	}
	

}
