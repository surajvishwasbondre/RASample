package com.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.SearchBoxPage;

public class SearchBoxTest extends TestBase{
	
	SearchBoxPage searchboxpage;


	public SearchBoxTest(){
		super();
	}
	
	@BeforeMethod
	public void Setup()
	{
		//initDriver();
		searchboxpage=new SearchBoxPage(driver);
		driver.get("https://realtyassistant.in/"); 
	}

	
	@Test()
	public void searchProcess() 
	{
		searchboxpage.selectCityFromDropdown();
		searchboxpage.enterValue();
		searchboxpage.clickSearchButton();
		searchboxpage.checkPageIsVissible();
		logger.info(" searchProcess.......Pass");
	}
	
	
}
