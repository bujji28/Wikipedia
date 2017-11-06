package com.prometheus.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CommonUtils 
{
	
	static WebDriver driver = null;
	
	public static WebDriver startBrowser()
	{
		driver = new FirefoxDriver();
		return driver;
	}
	
	public static void closeBrowser() 
	{
		driver.close();
	}
	
	public static WebDriver getBrowser()
	{
		if (driver == null){
			startBrowser();
		}
		return driver;
	}
			
	
	
	
	
	
	

}
