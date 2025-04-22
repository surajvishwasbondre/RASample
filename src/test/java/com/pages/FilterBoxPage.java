package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FilterBoxPage extends BasePage {
	
	public WebDriver driver;
    public FilterBoxPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Page object repository 
	

	@FindBy(id="cities")
	private WebElement locationDropdown; 
	
	@FindBy(xpath="//select[@id=\"cities\"]/option[@value=\"10\"]")
	private WebElement selectlocation; 
	
	
	@FindBy(id="category")
	private WebElement categoryDropdown; 
	
	@FindBy(xpath="//select[@id=\"category\"]/option[@value=\"1\"]")
	private WebElement selectCategory; 
	
	@FindBy(id="type")
	private WebElement typeDropdown;	
	
	@FindBy(xpath="//select[@id=\"type\"]/option[@value=\"Apartments\"]")
	private WebElement selectType;
	
	@FindBy(id="typology")
	private WebElement typologyDropdown;
	
	@FindBy(xpath="//select[@id=\"typology\"]/option[@value=\"3 BHK\"]")
	private WebElement selectTypology;
	
	@FindBy(id="status")
	private WebElement statusDropdown;
	
	
	@FindBy(xpath="//select[@id=\"status\"]/option[@value=\"New Launch\"]")
	private WebElement selectStatus;
	
	@FindBy(id="possession")
	private WebElement possessionDropdown;
	
	@FindBy(xpath="//select[@id=\"possession\"]/option[@value=\"2+ years\"]")
	private WebElement selectPossession;
	
	@FindBy(xpath="//input[@name=\"submit\"]")
	private WebElement submitButton;

	@FindBy(xpath="//div[@class=\"property_item\"]")
	private WebElement resultEle;
	
	//Page action methods
	public void selectCityFromDropdown(){
    	Select select=new Select(locationDropdown);
    
    	WebDriverWait wait = new WebDriverWait(driver, 20);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Noida")));

       select.selectByVisibleText("Noida");
    }
	public void selectCategoryFromDropdown(){
    	Select select=new Select(categoryDropdown);
    
//    	WebDriverWait wait = new WebDriverWait(driver, 20);
//    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Residential Properties")));

       select.selectByVisibleText("Residential Properties");
    }
	public void selectTypeFromDropdown(){
    	Select select=new Select(typeDropdown);
    
//    	WebDriverWait wait = new WebDriverWait(driver, 20);
//    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Apartments")));

       select.selectByVisibleText("Apartments");
    }
	public void selectTypologyFromDropdown(){
    	Select select=new Select(typologyDropdown);
    
//    	WebDriverWait wait = new WebDriverWait(driver, 20);
//    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("3 BHK")));

       select.selectByVisibleText("3 BHK");
    }
	public void selectStatusFromDropdown(){
    	Select select=new Select(statusDropdown);
    
//    	WebDriverWait wait = new WebDriverWait(driver, 20);
//    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("New Launch")));

       select.selectByVisibleText("New Launch");
    }
	public void selectPossessionFromDropdown(){
    	Select select=new Select(possessionDropdown);
    
//    	WebDriverWait wait = new WebDriverWait(driver, 20);
//    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("2+ years")));

       select.selectByVisibleText("2+ years");
    }
	public void clickOnSubmitButton() {
		submitButton.click();
	}
	
	public void resultElement() {
		System.out.println("Searched Property was Displayed = "+ resultEle.isDisplayed());
	}
}
