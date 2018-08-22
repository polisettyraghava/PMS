package browserAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class Browser_Automation {

	public static void main(String[] args) 
	{
      System.setProperty("webdriver.chrome.driver", "C:\\Projects\\Com.Validations\\Drivers\\chromedriver.exe");
      ChromeDriver driver = new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      driver.get("http://www.antarvani.com/pms_test_0713/index.php/portal/admin/logincontroller");
	}

}
