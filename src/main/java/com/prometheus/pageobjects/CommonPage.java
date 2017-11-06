package com.prometheus.pageobjects;

public interface CommonPage {
	
	public String getTitle();
	
	public boolean isDisplayed(String xpath);
	
	public String getText(String xpath);
	
	public void close();

	public void search(String searchText);
	
	public void click(String xpath);
	
}
