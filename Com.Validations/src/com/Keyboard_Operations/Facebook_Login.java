package com.Keyboard_Operations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Facebook_Login {

	public static void main(String[] args) 
	{
       
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://facebook.com");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("email")).sendKeys("hello");
		
		Actions act= new Actions(driver);
		
		act.sendKeys(Keys.TAB).build().perform();
		act.sendKeys("helooooo").build().perform();
		act.sendKeys(Keys.ENTER).build().perform();
		System.out.println();
		driver.close();
	}

}
