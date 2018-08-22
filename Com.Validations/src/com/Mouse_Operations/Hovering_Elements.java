package com.Mouse_Operations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Hovering_Elements {

	public static void main(String[] args) 
	{
		FirefoxDriver driver = new FirefoxDriver();
		
		driver.get("http://amazon.in");
		
		WebElement hellosignin = driver.findElement(By.id("nav-link-yourAccount"));
		
		Actions act= new Actions(driver);
		act.moveToElement(hellosignin).build().perform();
		driver.findElement(By.xpath("html/body/div[1]/header/div/div[1]/div[4]/div[6]/div[3]/a[3]/span")).click();
		driver.navigate().back();
		
		WebElement shopall = driver.findElement(By.id("nav-link-shopall"));
		shopall.click();
		driver.findElement(By.linkText("Echo Dot")).click();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println();
		driver.close();
		

	}

}
