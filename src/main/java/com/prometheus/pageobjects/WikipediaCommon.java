package com.prometheus.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.prometheus.utils.CommonUtils;

public class WikipediaCommon implements CommonPage {
	
	protected static WebDriver driver = null;
 
	public String getTitle() {
		return driver.getTitle();
	}
	
	public boolean isDisplayed(String xpath) {
		return driver.findElement(By.xpath(xpath)).isDisplayed();
	}
	
	public String getText(String xpath) {
		return driver.findElement(By.xpath(xpath)).getText();
	}
	
	public void close() {
		CommonUtils.closeBrowser();
	}
	
	public void search(String searchText) 
	{
		driver.findElement(By.xpath(".//*[@id='searchInput']")).sendKeys(searchText);
		driver.findElement(By.xpath(".//*[@type='submit']")).click();
	}

	public void click(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
