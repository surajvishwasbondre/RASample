package com.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class URLChecker {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Eclipse Workplace\\RAWebsite\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
		driver.get("https://realtyassistant.in/sitemap.xml");

        List<WebElement> sitemapLinks = driver.findElements(By.partialLinkText("/property/"));

        for (WebElement link : sitemapLinks) {

            String url = link.getText();

            if (url != null && !url.isEmpty()) {

               url.describeConstable();
               System.out.println("Url is null");
            
            }
	}
	}
}
