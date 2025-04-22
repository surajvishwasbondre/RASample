package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class  LandingPageAffiliateMarketingPage2 extends BasePage {
public WebDriver driver;

	public LandingPageAffiliateMarketingPage2(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
}