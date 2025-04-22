package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PopupFormPage extends BasePage {
public WebDriver driver;

	public PopupFormPage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//Page object repository 
	 
	
    	@FindBy(xpath="//div[@class=\"getaquotebt\"][2]")   
		private WebElement iconEle; 
		
		@FindBy(xpath="//h3[@class=\"modal-title\"]")
        private WebElement popupFormEle;
		//div[@class=\"modal-dialog login_form\"]
		
		@FindBy(xpath="//input[@placeholder=\"Full Name*\"]")
		private WebElement nameField;
		
		@FindBy(xpath="//input[@placeholder=\"Phone Number*\"]")
		private WebElement phoneNumField;
		
		@FindBy(xpath="//input[@placeholder=\"Email*\"]")
		private WebElement emailField;
		
		@FindBy(xpath="//select[@name=\"prop_id\"]")
		private WebElement propertyDropdown;
		
		@FindBy(xpath="//option[text()=\"Roma Golf Link Apartment\"]")
		private WebElement selectProperty;
		
		@FindBy(xpath="//*[@id=\"enquiry\"]/div[2]/div/div")
		private WebElement checkBoxEle;
		
//		@FindBy(xpath="//*[@id=\"enquiry\"]/div[2]/div/div/div/iframe")
//		private WebElement checkBoxEle2;
//		//div[@class="recaptcha-checkbox-checkmark"]
//		@FindBy(xpath="//div[@class=\"recaptcha-checkbox-checkmark\"]")
//		private WebElement checkBoxEle3;
		
		@FindBy(xpath="//button[@id=\"submitBtn\"]")
		private WebElement submitButton;
		
		@FindBy(xpath="//h1[text()=\"Thank You !\"]")
		private WebElement thankyouEle;
		
		//Page action methods
		public void clickOnPopupIcon()
		{    
			//new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(iconEle)).click();
			WebDriverWait wait = new WebDriverWait(driver, 10);
         	wait.until(ExpectedConditions.visibilityOf(iconEle)).click();
			
		}
		public void switchToPopupForm()
		{   WebDriverWait wait = new WebDriverWait(driver, 10);
     	    wait.until(ExpectedConditions.visibilityOf(popupFormEle));
			driver.switchTo().activeElement();
		}
		
		public void fillOutPopupForm() 
		{
			nameField.sendKeys("sachin");
			phoneNumField.sendKeys("0000000000");
			emailField.sendKeys("test@gmail.com");
			propertyDropdown.click();
			
			Select select=new Select(propertyDropdown);
		    
//	    	WebDriverWait wait = new WebDriverWait(driver, 20);
//	    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Lodha Palava City")));
            select.selectByValue("204");
           checkBoxEle.click();
//            driver.switchTo().frame(checkBoxEle2);
//            
//            Thread.sleep(5000);
//           
//            checkBoxEle3.click();
//            
//            driver.switchTo().defaultContent();
//            Thread.sleep(5000);
            
		}
		public void formSubmittion()
		{  
			submitButton.click();
			thankyouEle.isDisplayed();
		}
		}

