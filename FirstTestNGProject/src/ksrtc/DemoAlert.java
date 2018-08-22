package ksrtc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoAlert {
	
	@Test
	public void handleAlert() throws InterruptedException {

		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ksrtc.in/oprs-web/");
		driver.findElement(By.xpath("html/body/div[5]/div[1]/form/div[1]/div[1]/div/div/div/input")).click();
        Thread.sleep(2000);
		//Alert alt= driver.switchTo().alert();
        //alt.accept();
	String Actual_msg = driver.switchTo().alert().getText();
	System.out.println("alert msg is:"+Actual_msg);
	driver.switchTo().alert().accept();
	
	String Expected_msg = "Please select start place from near";
	Assert.assertEquals(Actual_msg, Expected_msg);
	
	}
}
