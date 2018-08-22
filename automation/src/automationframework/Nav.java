package automationframework;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.session.FirefoxFilter;

public class Nav {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox");
		File pathBinary = new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);   
		DesiredCapabilities desired = DesiredCapabilities.firefox();
		FirefoxOptions options = new FirefoxOptions();
		FirefoxBinary FirefoxFilteroxDriverLogLevelefoxBinary = null;
		desired.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options.setBinary(FirefoxFilteroxDriverLogLevelefoxBinary));
		WebDriver driver = new FirefoxDriver();
		
		String baseUrl = "http://demo.guru99.com/test/newtours/";
		
		String expectedTitle = "welcome: mercury tours";
		
		String actualTitle = "";
		
		driver.get(baseUrl);
		
		actualTitle = driver.getTitle();
		
		if(actualTitle.contentEquals(expectedTitle)) {
			
			System.out.println("test passed");
		}
		else
		{
			System.out.println("test failed");
		}
		driver.close();
		
		}
		
		
		
		
		
	}


