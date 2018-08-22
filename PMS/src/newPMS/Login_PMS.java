package newPMS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Login_PMS 
{
	FirefoxDriver driver;
	
		@BeforeTest
	public void setup() {
		driver = new FirefoxDriver();
		driver.get("http://antarvani.com/ikhya_pms1/index.php/portal/admin/logincontroller");
		driver.manage().window().maximize();
	}
	
	@Test(priority=0)
	public void login() {
		
	driver.findElement(By.name("mobile_number")).sendKeys("9848804212");
	driver.findElement(By.name("password")).sendKeys("12345");
	WebElement rtype=driver.findElement(By.id("roletype_id"));  
	Select roletype= new Select(rtype);
	roletype.selectByVisibleText("Admin");
	driver.findElement(By.name("submit")).click();
	}
	
	/*@AfterTest
	public void teardown() {
		driver.close();
	}*/
}
