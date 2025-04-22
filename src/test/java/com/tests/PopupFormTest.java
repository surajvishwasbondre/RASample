package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.PopupFormPage;

public class PopupFormTest extends TestBase{

	PopupFormPage popupformpg;


	public PopupFormTest(){
		super();
	}
	
	@BeforeMethod
	public void Setup()
	{
		//initDriver();
		popupformpg=new PopupFormPage(driver);
		driver.get("https://realtyassistant.in/properties"); 
	}
     
	@Test(priority=1)
	public void VerifyPopUpFormIsFilled() 
	{
		popupformpg.clickOnPopupIcon();
		popupformpg.switchToPopupForm();
		popupformpg.fillOutPopupForm();
		logger.info(" VerifyPopUpFormIsFilled.......Pass");
	}
	@Test(priority=2)
	public void verifyopUpFormsubmitted() {
		popupformpg.formSubmittion();
		
		
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
