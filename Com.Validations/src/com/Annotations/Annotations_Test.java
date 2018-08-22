package com.Annotations;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Annotations_Test 
{

	@BeforeMethod
	public void launchapplication()
	{
		System.out.println("the application is launched");
		
	}
	@Test(priority=2)
	public void insertdata()
	{
		System.out.println("the application is launched");
		
	}
	@AfterMethod
	public void senddata()
	{
		System.out.println("the application is launched");
		
	}
}
