package com.tests;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class UrlExtractor {

    public static void main(String[] args) {
        
    	System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://realtyassistant.in/";

        try {
            // Connect to the webpage and get the HTML document
            Document document = Jsoup.connect(url).get();

            // Extract all anchor tags (a) that contain an href attribute
            Elements links = document.select("a[href]");

            // Iterate through the links and print the URLs
            for (Element link : links) {
                String url1 = link.attr("href");
                System.out.println("URL: " + url1);
                driver.get(url1);          
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
