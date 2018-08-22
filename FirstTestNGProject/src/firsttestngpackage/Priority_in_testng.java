package firsttestngpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Priority_in_testng {

	WebDriver driver;
	@Test(priority=1)
	public  void openBrowser(){
	    driver= new FirefoxDriver();
	}
	
	@Test (priority=2)
	public void lauchGoogle() {
		driver.get("http://www.google.com");
	}
	
	@Test(priority=3)
	public void performSearchandClick1stLink() {
		driver.findElement(By.id("sb_ifc0")).sendKeys("facebook");
	}
	
	/*@Test(priority=4)
	public void FacebookPageTitleVerification() throws Exception{
		driver.findElement(By.xpath(".//*[@value='Search']")).click();
		
		Thread.sleep(3000);
		Assert.assertEquals(driver.getTitle().contains("Facebook-google search"),true);
	}*/
   
}
