package firsttestngpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTestNGFile {
	
	public String CurrentUrl = "https://www.facebook.com/";
	String driverPath = "C:\\Users\\Raghava\\Downloads\\geckodriver-v0.20.1-win64";
	public WebDriver driver;
	
	@Test
  public void verifyHomepageTitle() {
		
		System.out.println("launching firefox browser");
		System.setProperty("webdriver.firefox.marionette", driverPath);
		driver = new FirefoxDriver();
		driver.getCurrentUrl();
		String expectedTitle = "welcome:Mercury Tours";
		String actualTitle= driver.getTitle();
		Assert.assertEquals(actualTitle,expectedTitle);
		driver.close();
  }
}
