package com.TakeScreenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;

public class Screenshot {

	public static void main(String[] args) throws IOException
	{

		FirefoxDriver driver = new FirefoxDriver();
		
		driver.get("http://www.bing.com");
		
		driver.manage().window().maximize();
		
		Sleeper.sleepTightInSeconds(10);
		
		File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils .copyFile(srcfile,new File("C:\\Projects\\Com.Validations\\Screenshots\\bing1.png"));
	     driver.close();
	}
	

}
