package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FooterPage extends BasePage{
	public WebDriver driver;                                  
    public WebDriverWait wait;
    public String selectedOption;


    public FooterPage(WebDriver driver){
    	super(driver);
		this.driver=driver; 
		PageFactory.initElements(driver, this);
	}
	
   @FindBy(xpath="//*[@id=\"propertyCity\"]/li[1]/a")
   private WebElement varanasilink;
   
   @FindBy(xpath="//*[@id=\"propertyCity\"]/li[2]/a")
   private WebElement noidalink;
   
   @FindBy(xpath="//*[@id=\"propertyCity\"]/li[3]/a")
   private WebElement gurugramlink;
  
   @FindBy(xpath="//*[@id=\"propertyCity\"]/li[4]/a")
   private WebElement punelink;
   
   @FindBy(xpath="//*[@id=\"propertyCity\"]/li[5]/a")
   private WebElement lucknowlink;
   
   @FindBy(xpath="//*[@id=\"propertyCity\"]/li[6]/a")
   private WebElement delhilink;
   
   @FindBy(xpath="//*[@id=\"propertyCity\"]/li[7]/a")
   private WebElement mumbailink;
   
   @FindBy(xpath="//*[@id=\"propertyCity\"]/li[8]/a")
   private WebElement bengalurulink;
   
   @FindBy(xpath="//*[@id=\"propertyCity\"]/li[9]/a")
   private WebElement navimumbailink;
   
   @FindBy(xpath="//*[@id=\"propertyCity\"]/li[10]/a")
   private WebElement greaternoidalink;
   
   
}
