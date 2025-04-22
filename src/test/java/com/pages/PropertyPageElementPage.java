package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PropertyPageElementPage extends BasePage{

	public WebDriver driver;                                  
    public WebDriverWait wait;


    public PropertyPageElementPage(WebDriver driver){
    	super(driver);
		this.driver=driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	//Page object repository  
    @FindBy(xpath="//h2[@class=\"bg_blue default_clr\"]")
    private WebElement propertyTitleEle; 
    
    @FindBy(xpath="//div[@class=\"row properties-sec-right row-padding\"]")
    private WebElement propertyDetailsBox;
    
    @FindBy(xpath="//div[@class=\"col-md-3 border-left-class\"]")
    private WebElement reraDetails;
  
    @FindBy(xpath="//form[@name=\"searchProperty\"]")
    private WebElement searchproperty;
    
    @FindBy(xpath="//*[@id=\"sidebar_fixed\"]/div/div[1]")
    private WebElement intrestToBuyPropertyForm;
    
    @FindBy(xpath="//div[@class=\"single-property-carousel owl-carousel owl-theme owl-loaded owl-drag\"]")
    private WebElement propertyImage;
    
    @FindBy(xpath="//div[@class=\"property-tabs-navigation\"]")
    private WebElement propertyTabsNavigation;
    
    @FindBy(xpath="//div[@id=\"ecww-widgetwrapper\"]")
    private WebElement emiCalculator;
    
    @FindBy(id="summary")
    private WebElement quickSummary;
    
    @FindBy(id="description")
    private WebElement propertydescription;
    
    @FindBy(id="amenities")
    private WebElement amenities;
    
    @FindBy(id="floor-plan")
    private WebElement floorplan;
    
    @FindBy(xpath="//div[@class=\"property-summary\"][5]")
    private WebElement pricing;
    
    @FindBy(id="gallery-sec")
    private WebElement gallery; 
    
    @FindBy(id="map")
    private WebElement map; 
    
    @FindBy(xpath="/html/body/section[1]/div")
    private WebElement relatedProperties; 
    
    @FindBy(xpath="//section[@class=\"disclaimer-wrapper\"]")
    private WebElement disclaimer; 
    
//Page action methods
	
    public void verifyElementsIsPresent(){
    	System.out.println("Property Title was Displayed = "+propertyTitleEle.isDisplayed());
        
    	System.out.println("Property DetailsBox was Displayed = "+propertyDetailsBox.isDisplayed());
    	
    	System.out.println("RERA Details was Displayed = "+reraDetails.isDisplayed());
    	
    	System.out.println("Search Property was Displayed = "+searchproperty.isDisplayed());
    	
    	System.out.println("Intrest To Buy Property Form was Displayed = "+intrestToBuyPropertyForm.isDisplayed());
    	
    	System.out.println("Property Image was Displayed = "+propertyImage.isDisplayed());
    	
    	System.out.println("Property Tabs Navigation was Displayed = "+propertyTabsNavigation.isDisplayed());
    	
    	System.out.println("EMI Calculator was Displayed = "+emiCalculator.isDisplayed());
    	
    	System.out.println("Quick Summary was Displayed = "+quickSummary.isDisplayed());
    	
    	System.out.println("Property Description was Displayed = "+propertydescription.isDisplayed());
    	
    	System.out.println("Amenities was Displayed = "+amenities.isDisplayed());
    	
    	System.out.println("Floor plan was Displayed = "+floorplan.isDisplayed());
    	
    	System.out.println("Pricing was Displayed = "+pricing.isDisplayed());
    	
    	System.out.println("Gallery was Displayed = "+gallery.isDisplayed());
    	
    	System.out.println("Map was Displayed = "+map.isDisplayed());
    	
    	System.out.println("Related Properties was Displayed = "+relatedProperties.isDisplayed());
    	
    	System.out.println("Disclaimer was Displayed = "+disclaimer.isDisplayed());
    }
}
