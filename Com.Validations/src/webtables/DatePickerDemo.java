package webtables;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DatePickerDemo {

	public static void main(String[] args)
	{
    FirefoxDriver driver = new FirefoxDriver();
    
    driver.manage().window().maximize();
    
    driver.get("https://www.redbus.in/");
    
    driver.findElement(By.id("onward_cal")).click();
    
    //Sleeper.sleepTightInSeconds(3000);
    
    driver.findElement(By.xpath("html/body/div[7]/table/tbody/tr[7]/td[2]")).click();
    
		
	}

}
