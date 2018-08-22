package captureScreenshot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import library.Utility;

public class FacebookScreenshot {
	
	@Test
	public void captureScreenshot() throws Exception
	{
		
		WebDriver driver = new FirefoxDriver();

		driver.manage().window().maximize();
		
		driver.get("http://google.com");
		Utility.capturescreenshot(driver, "website started");
		
		
		driver.findElement(By.xpath(".//*[@id='gs_htif0']")).sendKeys("learn automation");
		
		Utility.capturescreenshot(driver, "typename");
	     driver.quit();
	
	}
	

}
