package com.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.FilterBoxPage;



public class FilterBoxTest extends TestBase{
	
	FilterBoxPage filterboxpage;


	public FilterBoxTest(){
		super();
	}
	
	@BeforeMethod
	public void Setup()
	{
		//initDriver();
		filterboxpage=new FilterBoxPage(driver);
		driver.get("https://realtyassistant.in/properties"); 
	}

	
	@Test()
	public void VerifyFilterBoxFunctionality() 
	{  
		filterboxpage.selectCityFromDropdown();
		filterboxpage.selectCategoryFromDropdown();
		filterboxpage.selectTypeFromDropdown();
		filterboxpage.selectTypologyFromDropdown();
		filterboxpage.selectStatusFromDropdown();
		filterboxpage.selectPossessionFromDropdown();
		filterboxpage.resultElement();
		logger.info(" VerifyFilterBoxFunctionality.......Pass");
	}
	
}
