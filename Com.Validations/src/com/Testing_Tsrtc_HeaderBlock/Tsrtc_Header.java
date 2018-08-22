package com.Testing_Tsrtc_HeaderBlock;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;

public class Tsrtc_Header {

	public static void main(String[] args) 
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://www.tsrtconline.in/oprs-web/");
		
		// identifying the Header Block
		// <div class="menu-wrap">
		
WebElement HeaderBlock=driver.findElement(By.className("menu-wrap"));
List<WebElement>headerLinks=HeaderBlock.findElements(By.tagName("a"));
		
		System.out.println("Total links in HeaderBlock is: "+headerLinks.size());
		
		for(int a=0;a<headerLinks.size();a++)
		{
			String headerLinkName=headerLinks.get(a).getText();
			System.out.println(a+"  "+"Header link Name is: "+headerLinkName);
			
			headerLinks.get(a).click();
			
			System.out.println(driver.getTitle());
			System.out.println(driver.getCurrentUrl());
			System.out.println();
			
			driver.navigate().back();
			
			Sleeper.sleepTightInSeconds(10);
			
			HeaderBlock=driver.findElement(By.className("menu-wrap"));
			headerLinks=HeaderBlock.findElements(By.tagName("a"));
		}
		
		driver.close();

	}


}
