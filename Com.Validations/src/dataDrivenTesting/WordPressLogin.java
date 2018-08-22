package dataDrivenTesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WordPressLogin {

	WebDriver driver;
	
	@Test(dataProvider="wordpressData")
	public void LoginToWordPress(String username,String password) throws InterruptedException
	{
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://demosite.center/wordpress/wp-login.php");
		
		driver.findElement(By.id("user_login")).sendKeys(username);
		driver.findElement(By.id("user_pass")).sendKeys(password);
		driver.findElement(By.xpath("html/body/div[1]/form/p[4]/input[1]")).click();
		Thread.sleep(5000);

		Assert.assertTrue(driver.getTitle().contains("Dashboard"),"User is not able to login-Invalid Credentials");
		
		System.out.println("page title verified- user is able to login successfully");
		
	}	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();

	}
		@DataProvider(name="wordpressData")
		public Object[][] passData()
		{
			Object[][] data = new Object[3][2];
			
			data[0][0] ="admin1";
			data[0][1] ="demo1";
			
			data[1][0] ="admin1";
			data[1][1] ="demo123";
			
			data[2][0] ="admin";
			data[2][1] ="demo123";
			
			return data;
			
		}
	
	
}
