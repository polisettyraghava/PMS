package com.Keyboard_Operations;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Table_Operations {

	public static void main(String[] args) 
	{
		FirefoxDriver driver = new FirefoxDriver();
		
		driver.get("https://www.timeanddate.com/worldclock/");
		
		String Date=driver.findElement(By.xpath("html/body/div[1]/div[9]/section[2]/div[1]/table/tbody/tr[1]/td[1]")).getText();
		
		System.out.println(Date);
		
		driver.close();
	}

}
