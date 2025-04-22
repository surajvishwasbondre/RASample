package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

    public class EnquiryFormPage extends BasePage {
    
    public WebDriver driver;
	public EnquiryFormPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Page object repository 
	

	@FindBy(xpath="//span[@class=\"tag_t\"][1]")
    //span[@onclick=\"getValue(261);\"]")   
	private WebElement getCallbackEle; 
	//div[@class="modal-content"]
	@FindBy (xpath="//*[@id=\"getcallnow\"]/div/div/div[2]")
	//*[@id=\\\"getcallnow\\\"]/div/div/div[2]/div/div[2]\"
	//*[@id=\"getcallnow\"]/div/div/div[2]/div/div[2]/h5/text()"
	
    private WebElement EnquiryFormEle;
	
	@FindBy(xpath="//input[@placeholder=\"Your Name\"]")
	private WebElement nameField;
	
	@FindBy(xpath="//input[@placeholder=\"Phone Number\"]")
	private WebElement phoneNumField;
	
	@FindBy(id="email")
	private WebElement emailField;
	
	@FindBy(id="message")
	private WebElement messagefield;
	
	@FindBy(id="recaptcha-container-1699858680813")
	private WebElement checkBoxEle;
	
	@FindBy(id="submitBtn")
	private WebElement submitButton;
	
	@FindBy(xpath="//h1[text()=\"Thank You !\"]")
	private WebElement thankyouEle;
	


	//Page action methods
	public void clickOnPopupIcon()
	{    
		//new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(iconEle)).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(getCallbackEle)).click();

	}
	public void switchToPopupForm()
	{   WebDriverWait wait = new WebDriverWait(driver, 10);
 	    wait.until(ExpectedConditions.visibilityOf(EnquiryFormEle));
		driver.switchTo().frame(EnquiryFormEle);
	}
	
	public void fillOutPopupForm() 
	{
		nameField.sendKeys("sachin");
		phoneNumField.sendKeys("0000000000");
		emailField.sendKeys("test@gmail.com");	
		messagefield.sendKeys("Hello...");
        checkBoxEle.click();

	}
	public void formSubmittion()
	{  
		submitButton.click();
		thankyouEle.isDisplayed();
	}

}

