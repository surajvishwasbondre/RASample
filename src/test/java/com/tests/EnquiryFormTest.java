package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.EnquiryFormPage;


public class EnquiryFormTest extends TestBase {
	EnquiryFormPage enquiryformpage;
	
	public EnquiryFormTest(){
		super();
	}
	
	@BeforeMethod
	public void Setup()
	{
		//initDriver();
		enquiryformpage=new EnquiryFormPage(driver);
				driver.get("https://realtyassistant.in/properties"); 
	}
	
	@Test(priority=1)
	public void VerifyEnquiryFormIsFilled() 
	{
		enquiryformpage.clickOnPopupIcon();
		
		logger.info(" VerifyEnquiryFormIsFilled.......Pass");
	}
	
	@Test(priority=2)
	public void verifyopUpFormsubmitted() {
		enquiryformpage.formSubmittion();
		
		
		WebElement successMessage = driver.findElement(By.xpath("//div[@class=\"jumbotron text-center thankupage\"]"));
		if(successMessage.isDisplayed())
		{
			System.out.println("Form submitted successfully");
		}else
		{
			System.out.println("Form submission failed");
		}
		logger.info(" verifyopUpFormsubmitted.......Pass");			
}
}
