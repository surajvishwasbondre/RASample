package com.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.HomePage;

public class HomePageTest extends TestBase{
	HomePage homepage;
	public HomePageTest(){
		super();
	}
	@BeforeMethod
	public void Setup()
	{
		//initDriver();
		homepage=new HomePage(driver);
		driver.get("https://realtyassistant.in/");
	}
	
	@Test()
	public void searchProcess()
	{
		homepage.clickOnDropdown();
		homepage.selectCityFromDropdown();
		homepage.enterValue();
		homepage.clickSearchButton();
	}
	
	
}
