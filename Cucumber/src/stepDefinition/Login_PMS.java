package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login_PMS 
{
	WebDriver driver;
	@Given("^Open firefox and start application$")
	public void Open_firefox_and_start_application()  {
	    driver = new FirefoxDriver();
	    driver.manage().window().maximize();
	    driver.get("http://antarvani.com/ikhya_pms1/index.php/portal/admin/logincontroller");
	}

	@When("^I enter valid username and valid password and select valid roletype$")
	public void I_enter_valid_username_and_valid_password_and_select_valid_roletype() throws Throwable {
	  
		driver.findElement(By.name("mobile_number")).sendKeys("9848804212");
		driver.findElement(By.name("password")).sendKeys("12345");
		WebElement rtype=driver.findElement(By.id("roletype_id"));  
		Select roletype= new Select(rtype);
		roletype.selectByVisibleText("Admin");
	    
	}

	@Then("^user should be able to login successfully$")
	public void user_should_be_able_to_login_successfully()  {
		driver.findElement(By.name("submit")).click();

		driver.close();
	}

}
