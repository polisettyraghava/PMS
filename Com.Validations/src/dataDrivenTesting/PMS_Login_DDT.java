package dataDrivenTesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PMS_Login_DDT {
WebDriver driver;
	
	@Test(dataProvider="pmsData")
	public void LoginToPMS(String username,String password) throws InterruptedException
	{
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://www.antarvani.com/pms_test_0713/index.php/portal/admin/logincontroller");
		
		WebElement name=driver.findElement(By.name("mobile_number"));
		name.sendKeys(username);
	WebElement password1=driver.findElement(By.name("password"));
	    password1.sendKeys(password);
	    WebElement rtype=driver.findElement(By.id("roletype_id"));  
		Select roletype= new Select(rtype);
		roletype.selectByVisibleText("Admin");
		WebElement signin= driver.findElement(By.name("submit"));
		signin.click();
		Thread.sleep(5000);

		Assert.assertTrue(driver.getTitle().contains("dashboardcontroller"),"User is not able to login-Invalid Credentials");
		
		System.out.println("page title verified- user is able to login successfully");
		
	}	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();

	}
		@DataProvider(name="pmsData")
		public Object[][] passData()
		{
			Object[][] data = new Object[3][2];
			
			data[0][0] ="9845321245";
			data[0][1] ="12345";
			
			data[1][0] ="3645125678";
			data[1][1] ="demo123";
			
			data[2][0] ="9848804212";
			data[2][1] ="12345";
			
			return data;
			
		}
	
	
}



