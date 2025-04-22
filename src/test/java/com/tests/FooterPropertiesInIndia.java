package com.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FooterPropertiesInIndia {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\Eclipse Workplace\\RAWebsite\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://realtyassistant.in/sitemap.xml"); 
        
////		JavascriptExecutor js= (JavascriptExecutor)driver;
////          js.executeScript("windows.scrollBy(0,document.body.scrollHeight)");
//		 // Find all links on the page
//		WebElement allLink=driver.findElement(By.xpath("//*[@id=\"propertyCity\"]/li[*]/a/text()"));
//		System.out.println(allLink.getSize());
//		//Loop through each link and check if it opens
//		

        List<WebElement> links = driver.findElements(By.xpath("//*[contains(@class,'text') and contains(text(),'https')]"));
        System.out.println(links.size());

        for(int i=0; i<links.size();i++){
            //Thread.sleep(200);
            System.out.println(i+ "."+links.get(i).getText());
        }
	
	
	}
	


}
