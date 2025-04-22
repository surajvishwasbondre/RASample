package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SearchBoxPage extends BasePage{
	
	public WebDriver driver;                                  
    public WebDriverWait wait;
    public String selectedOption;


    public SearchBoxPage(WebDriver driver){
    	super(driver);
		this.driver=driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	//Page object repository  
    @FindBy(id="cities")
    private WebElement citiesDropdown; 

	@FindBy(xpath="//select[@id=\"cities\"]/option[3] [text()=\"Noida\"]")
	//@FindBy(xpath="//option[. = 'Noida']")
	private WebElement selectCity; 
	
	@FindBy(xpath="//input[@name=\"keywords\"]")
	private WebElement searchBoxEle;
	
	@FindBy(xpath="//input[@class=\"submit\"]")
	private WebElement searchButton;
	
	@FindBy(xpath="//div[@class=\"property_item\"][1]")
	private WebElement noidaPropertyEle;
	

	//Page action methods
	
    public void selectCityFromDropdown(){
    	Select select=new Select(citiesDropdown);
    
    	WebDriverWait wait = new WebDriverWait(driver, 20);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Noida")));

       select.selectByVisibleText("Noida");
   
    }
    public void enterValue()  {
    	
    	searchBoxEle.sendKeys("sector 150");
    }
    public void clickSearchButton() {
    	searchButton.click();
    }
    public void checkPageIsVissible() {
    	
    	System.out.println("Searched Property was Displayed = "+ noidaPropertyEle.isDisplayed()); //true
    }
    
}
