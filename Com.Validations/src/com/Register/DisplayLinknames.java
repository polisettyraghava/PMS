package com.Register;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DisplayLinknames {

	public static void main(String[] args) 
	{
           FirefoxDriver driver = new FirefoxDriver();
           driver.get("http://google.com");
           driver.manage().window().maximize();
           List<WebElement>Links= driver.findElements(By.tagName("a"));
           int LinksCount = Links.size(); 
           System.out.println("the total number of links are " +LinksCount);
           
           for(int k=0;k<Links.size();k++)
           {
        	   String linkName =Links.get(k).getText();
        	   System.out.println(k+" "+linkName);
           }
           driver.close();
	}

}
