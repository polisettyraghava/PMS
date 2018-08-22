package com.TitleValidate;

import org.openqa.selenium.firefox.FirefoxDriver;

public class CaptureTitle {

	public static void main(String[] args) {


		FirefoxDriver driver = new FirefoxDriver();
		
		driver.get("http://www.facebook.com");
		
		String expectedTitle = "Facebook";
		
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
	driver.close();
	}
	

}
