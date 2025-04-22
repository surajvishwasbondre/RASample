package com.tests;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchFunctionality {
	 private static WebDriver driver;
	  private Map<String, Object> vars;
	  JavascriptExecutor js;
	  @Before
	  public void setUp() {
	    driver = new ChromeDriver();
	    js = (JavascriptExecutor) driver;
	    vars = new HashMap<String, Object>();
	  }

	public static void main(String[] args) {
		 driver.get("https://realtyassistant.in/");
		    
		    driver.manage().window().setSize(new Dimension(1552, 832));
		    
		    driver.findElement(By.id("cities")).click();
		    
		    {
		      WebElement dropdown = driver.findElement(By.id("cities"));
		      dropdown.findElement(By.xpath("//option[. = 'Noida']")).click();
		    }
		    
		    driver.findElement(By.cssSelector(".col-md-8 > input")).click();
		   
		    driver.findElement(By.cssSelector(".col-md-8 > input")).sendKeys("sector 150");
		   
		    driver.findElement(By.name("submit")).click();

	}

}
