package basicPrograms;

import org.openqa.selenium.firefox.FirefoxDriver;

public class Example {

	public static void main(String[] args) {

		FirefoxDriver driver = new FirefoxDriver();
		
	
		driver.get("https://fb.com");
	System.out.println("success");
	driver.close();
	}
    
}
