package Webedriver_Examples;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown_Example {
public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new FirefoxDriver();
	driver.navigate().to("http://wenzhixin.net.cn/p/multiple-select/docs/");
	driver.manage().window().maximize();
	//wait for elements while searching 
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
Select dropdown=new Select(driver.findElement(By.xpath(".//*[@id='e1_f']/select")));
boolean value=dropdown.isMultiple();
System.out.println("multiple or single selection::"+value);
dropdown.selectByVisibleText("January");
Thread.sleep(3000);
dropdown.selectByIndex(11);
Thread.sleep(3000);
dropdown.selectByIndex(2);
Thread.sleep(3000);
dropdown.selectByIndex(3);
Thread.sleep(3000);
dropdown.selectByIndex(4);
Thread.sleep(3000);
dropdown.selectByIndex(7);
Thread.sleep(3000);
dropdown.selectByIndex(9);
Thread.sleep(3000);
//print no of item got selected
List<WebElement>listbox=dropdown.getAllSelectedOptions();
System.out.println(listbox.size());
for(int i=1;i<listbox.size();i++){
	String itenname=listbox.get(i).getText();
	System.out.println(itenname);
}
dropdown.deselectByVisibleText("January");
Thread.sleep(2000);
dropdown.deselectByIndex(2);
Thread.sleep(2000);
dropdown.deselectByIndex(3);
Thread.sleep(2000);
dropdown.deselectAll();
Thread.sleep(5000);
driver.quit();
	}

}















