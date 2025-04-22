package com.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.Home;

public class HomeTests extends TestBase {
	
	Home homepage;
	public HomeTests(){
		super();
	}
	
	@BeforeMethod
	public void Setup()
	{
		//initDriver();
		homepage=new Home(driver);
		driver.get(prop.getProperty("baseurl"));//reading the data from proprties file
	}
	
	@Test(priority=1)
	public void verifyHomePageTitle() {
	  String expectedTitle="Automation Practice Site";
	  String actualTitle=homepage.getHomePageTitle();
	 Assert.assertEquals(actualTitle, expectedTitle);
	 logger.info(" verifyHomePageTitle.......Pass");
 	}
	
	@Test(priority=2)
	public void verifyNewArrivalsDisplayed() {
		boolean arrivalsActual=homepage.arrivalsisDisplayed();
		Assert.assertTrue(arrivalsActual);
		logger.info(" verifyNewArrivalsDisplayed.......Pass");
 	}
	
	@Test(priority=3)
	public void verifyFirstBookTitle() {
		String expectedTitleBook="Selenium Ruby";
		String actualTitleBook=homepage.getFirstBookTitle();
		Assert.assertEquals(actualTitleBook,expectedTitleBook);
		logger.info(" verifyFirstBookTitle.......Pass");
	}
	
	@Test(priority=4)
	public void verifySecondBookTitle() {
		String expectedTitleBook="Thinking in HTML";
		String actualTitleBook=homepage.getSecondBookTitle();
		Assert.assertEquals(actualTitleBook,expectedTitleBook);
		logger.info(" verifySecondBookTitle.......pass");
 	}
	
	@Test(priority=5)
	public void verifyThrirdBookTitle() {
		String expectedTitleBook="Mastering JavaScript";
		String actualTitleBook=homepage.getThirdBookTitle();
		Assert.assertEquals(actualTitleBook,expectedTitleBook);
		logger.info("verifyThrirdBookTitle............Pass");
 	}
	
	
	
}
