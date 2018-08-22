package com.Register;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DemoAut {

	public static void main(String[] args) throws IOException
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://newtours.demoaut.com");
		
    List<WebElement>links= driver.findElements(By.tagName("a"));
       int  linksCount=links.size();
       System.out.println("the total no of links are:" + linksCount);
       for(int i=0;i<links.size();i++) 
       {
    String LinkName = links.get(i).getText();
            System.out.println(i+ " "+ LinkName);
            links.get(i).click();
            System.out.println(driver.getTitle());
            System.out.println(driver.getCurrentUrl());
    		//File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			//FileUtils .copyFile(srcfile,new File("C:\\Projects\\Com.Validations\\Screenshots\\"+LinkName+".png"));

            
            System.out.println();
            
            driver.navigate().back();
            
            links=driver.findElements(By.tagName("a"));
       }
	driver.close();
	}
	

}
