package com.prometheus.pageobjects;

import com.prometheus.pages.WikipediaHomePage;
import com.prometheus.utils.CommonUtils;

public class WikipediaHomePageImpl extends WikipediaCommon implements WikipediaHomePage {

	public void openHomePage() 
	{
		driver = CommonUtils.startBrowser();
		driver.get("https://www.wikipedia.org");		
	}


	
}
