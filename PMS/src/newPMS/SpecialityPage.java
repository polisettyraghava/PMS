package newPMS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class SpecialityPage extends DepartmentPage
{
	
	public static void main(String args[])
	{
		DepartmentPage direct = new DepartmentPage();
		direct.Department();	
	}

	
	@Test(priority=4)
	public void Speciality()
	{
		System.out.println("speciality page is opened");
		WebElement spl=driver.findElement(By.xpath("html/body/div[1]/aside/section/ul/li/ul/li[4]/a/span[1]/i"));
		spl.click();
		System.out.println(driver.getCurrentUrl());
		WebElement addspl=driver.findElement(By.linkText("Add Speciality"));
		addspl.click();
		String Expected_url="pms";
		String Actual_url=driver.getCurrentUrl();
		System.out.println("Expected_url:"+ Expected_url);
		System.out.println("Actual_url is:"+ Actual_url);
		if(Actual_url.contains(Expected_url))
		{
			System.out.println("url matched----pass");
		}
		else
		{
			System.out.println("url not matched---fail");
		}
		System.out.println("speciality page is closed");

		Sleeper.sleepTightInSeconds(3);
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
	}

}

