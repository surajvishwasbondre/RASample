package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {
	
	public WebDriver driver;                                  
    public WebDriverWait wait;
    public String selectedOption;


    public HomePage(WebDriver driver){
		super();
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//Page object repository  
	@FindBy(xpath="//select[@id=\"cities\"]")   
	private WebElement citiesDropdown; 

	
	@FindBy(xpath="//option[text()=\"Noida\"]")
	private WebElement selectCity; 
	
	@FindBy(xpath="//input[@name=\"keywords\"]")
	private WebElement searchBoxEle;
	
	@FindBy(xpath="//input[@class=\"submit\"]")
	private WebElement searchButton;
	
	@FindBy(xpath="//div[@class=\"property_item\"][1]")
	private WebElement noidaPropertyEle;
	
	
	//Page action methods

    public void clickOnDropdown()
    {
        citiesDropdown.click();
    }
    public void selectCityFromDropdown(){
        
        Select select=new Select(selectCity);
        select.selectByVisibleText("Noida");
        selectedOption= select.getFirstSelectedOption().getText();
    }
    public void enterValue() {
    	searchBoxEle.sendKeys("sector 150");
    }
    public void clickSearchButton() {
    	searchButton.click();
    }
    public void checkPageIsVissible() {
    	noidaPropertyEle.isDisplayed();
    }
    
}
