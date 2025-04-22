package com.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.pages.PropertyPageElementPage;


public class PropertyPageElementTest extends TestBase {
	PropertyPageElementPage propertypageelementpage;


	public PropertyPageElementTest(){
		super();
	}
	
	@BeforeMethod
	public void Setup()
	{
		//initDriver();
		propertypageelementpage =new PropertyPageElementPage(driver);
		driver.get("https://realtyassistant.in/property/gaur-city-14th-avenue-noida-extension-greater-noida-west"); 
	}

	@Test()
	public void VerifyPropertyPageElement() 
	{
		propertypageelementpage.verifyElementsIsPresent();
		logger.info(" verifyopUpFormsubmitted.......Pass");	
	}
	
	
}
