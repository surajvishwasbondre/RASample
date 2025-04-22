package com.tests;

import org.openqa.selenium.By;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.pages.URLCheckerPage;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
 
public class URLCheckerTest extends TestBase{
	
	URLCheckerPage urlcheckpage;


	public URLCheckerTest(){
		super();
	}
	
	@BeforeMethod
	public void Setup()
	{
		//initDriver();
		urlcheckpage=new URLCheckerPage(driver);
		driver.get("https://realtyassistant.in"); 
	}
	
	 public static boolean isValidURL(String urlString) {
         try {
             new URL(urlString);
             return true; // The URL is valid
         } catch (MalformedURLException e) {
             return false; // The URL is not valid
         }
     }
	
	@Test()
 
    public void verifyURL() {

        Set<String> allURLs = new HashSet<>();

        StringBuilder csvOutput = new StringBuilder("URL,Status\n"); // CSV header
// 
        try {

//            // Extract URLs from the each webpage

            List<WebElement> links = driver.findElements(By.tagName("a"));

            for (WebElement link : links) {
                    
               String url = link.getAttribute("href");

                if (url != null && !url.isEmpty()) {

                    allURLs.add(url);

                }

            }
 
            // Extract URLs from the sitemap
            

            
            
            List<String> matches = new ArrayList<String>();
            
        	driver.get("https://realtyassistant.in/sitemap.xml");
            String str = driver.getPageSource();
        	System.out.println(str);
        	Matcher m = Pattern.compile("(?s)<loc>(?<link>.*?)</loc>").matcher(str);
        	 
        	while(m.find()) {
        	     System.out.println(m.group("link"));
        	      matches.add(m.group("link"));
           }
        	System.out.println(matches.size());
            

 
        	// Loop through each URL, open it, take a screenshot, and append the result to the CSV int counter = 1;

            for (String url : matches) {
               
                
                try {

                    driver.get(url);
                   String pageTitle = driver.getTitle();
                  
//                   TakesScreenshot ts = (TakesScreenshot)driver;
//                   File scrFile= ts.getScreenshotAs(OutputType.FILE);
//                   String filePath = System.getProperty("user.dir")+"/URLScreenshot/"+pageTitle+System.currentTimeMillis()+"png";
//                   File destFile=new File(filePath);
//                   FileUtils.copyFile(scrFile, destFile);
                    
                    csvOutput.append(url).append(",Success\n");

                } catch (Exception e) {
                	
                	try {
                		driver.get(url);
                    	System.out.println("Retried Failed Url = "+ url);
                	}catch (Exception ex) {
         
                          csvOutput.append(url).append(",Failure\n");
                	}
                             	
                		
//                		HttpURLConnection connection;
//                		URL url1;
//                		try {
//                			url1=new URL(url);
//                			connection=(HttpURLConnection)url1.openConnection();
//                			connection.setConnectTimeout(5000);
//                			connection.connect();
//                			if(connection.getResponseCode()==200)
//                			{
//                				System.out.println("Link is working");
//                			}else {
//                				System.out.println("Link is not working");
//                				System.out.println(url1);
//                				System.out.println(connection.getResponseMessage());
//                				System.out.println();
//                			}
//                		}catch(IOException ex) {
//                			ex.printStackTrace();
//                		}
                		
                }	
            }

            

        } catch (Exception e) {

            e.printStackTrace();

        } 
 
        // Write the CSV output to a file

        try (FileWriter writer = new FileWriter("results.csv")) {

            IOUtils.write(csvOutput.toString(), writer);

        } catch (IOException e) {

            e.printStackTrace();

        }


    }

}
