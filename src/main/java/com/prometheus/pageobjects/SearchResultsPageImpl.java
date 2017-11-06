package com.prometheus.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.prometheus.pages.SearchResultsPage;

public class SearchResultsPageImpl extends WikipediaCommon implements SearchResultsPage {

	public void chooseText(String text) {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		List<WebElement> list = driver.findElements(By.xpath("//*[@class='suggestions-results']/a"));
		for (WebElement element : list) 
		{
			if (element.getText().equalsIgnoreCase(text))
			{
				element.click();
				break;				
			}
		}
	}

	public void enterText(String text) {
		driver.findElement(By.xpath(".//*[@id='searchInput']")).sendKeys(text);
	}

	
	
}
