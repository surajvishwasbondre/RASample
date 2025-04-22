package com.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class abc {
 
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\Eclipse Workplace\\RAWebsite\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
////    
//    driver.get("https://realtyassistant.in/sitemap.xml");  //664
//    List<WebElement> sitemapLinks = driver.findElements(By.cssSelector(".folder>.opened>.line>span:nth-child(2)"));
//    int count=0;
//    
//    for (WebElement link : sitemapLinks) {
//
//    String url = link.getText();
//    
//    
//    count++;
//    
//    if (isValidURL(url)) {
//    	System.out.println(url);
//    	System.out.println(count);
////        System.out.println(urlString1 + " is a valid URL.");
//        if (url != null && !url.isEmpty()) {
//        	
//        	allURLs.add(url);
//        }
//    }
//
//    }

//      
//      //Get Document builder
//      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//      DocumentBuilder builder = factory.newDocumentBuilder();
//      //Get Document
//     // Document document = builder.parse(new File("https://realtyassistant.in/sitemap.xml"));
//      Document document = builder.parse("https://realtyassistant.in/sitemap.xml");
//      //Normalize the xml structure
//      document.getDocumentElement().normalize(); 
        
//        USING X PATH Praser
//      
//      //Get all the elements by tag name
// NodeList  urllist = document.getElementsByTagName("url");
//      
//      for(int i=0;i<urllist.getLength();i++)
//      {
//      	Node url = urllist.item(i);
//      	
//      	if(url.getNodeType()==Node.ELEMENT_NODE)
//      	{
//      		Element urlElement = (Element) url;
//      		//System.out.println("url Name:" + urlElement.getElementsByTagName("loc") );
//      		
//      		NodeList urldetails = url.getChildNodes();
//      		for(int j=0;j< urldetails.getLength();j++)
//      		{   
//      			Node detail =urldetails.item(j);
//      			if(url.getNodeType()==Node.ELEMENT_NODE)
//      			{
//      				Element detailElement = (Element)detail;
//      			    
//      				System.out.println("  "+detailElement.getElementsByTagName("loc"));
//      				
//      				
//      				//allURLs.add(urllink);
//      			}
//      		}
//      	}
//      }
 
    
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
            
 
      
    }
}