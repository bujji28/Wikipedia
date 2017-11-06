package com.prometheus.tests;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.prometheus.pageobjects.CommonPage;
import com.prometheus.pageobjects.SearchResultsPageImpl;
import com.prometheus.pageobjects.WikipediaHomePageImpl;
import com.prometheus.pages.SearchResultsPage;
import com.prometheus.pages.WikipediaHomePage;

public class WikipediaTest 
{

	CommonPage wiki = null;
	
	@BeforeSuite
	public void suiteTestBefore() 
	{
		wiki = new WikipediaHomePageImpl();
		((WikipediaHomePage) wiki).openHomePage();

	}
	
	@Test (priority = 1)
	public void basicSearchBarTest()
	{	
		String expResult ="Puppy";
		((WikipediaHomePage) wiki).search("Puppies");
		
		Assert.assertEquals(wiki.getTitle(), expResult + " - Wikipedia");
		
		String pageHeading = wiki.getText(".//*[@id='firstHeading']");
		Assert.assertEquals(pageHeading, expResult);
				
	}
	

	@Test (priority = 2)
	public void hiddenContentsTest()
	{	
		boolean isHideDisplayed = wiki.isDisplayed(".//*[@id='toc']/div/span/a");
		Assert.assertEquals(isHideDisplayed, true);
		
		wiki.click(".//*[@id='toc']/div/span/a");
		boolean isContentDisplayed = wiki.isDisplayed(".//*[@id='toc']/ul/li");
		Assert.assertEquals(isContentDisplayed, false);
	}
	
	@Test (priority = 3)
	public void autoCompleteSearchTest()
	{
		wiki = new SearchResultsPageImpl();
		String expResult ="France";
		((SearchResultsPage) wiki).enterText("Franc");
		((SearchResultsPage) wiki).chooseText(expResult);
		
		Assert.assertEquals(wiki.getTitle(), expResult + " - Wikipedia");
		
		String pageHeading = wiki.getText(".//*[@id='firstHeading']");
		Assert.assertEquals(pageHeading, expResult);
				
	}
	
	@AfterSuite
	public void suiteTestAfter() {
		wiki.close();
	}
}
