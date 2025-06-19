package com.tests;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class LandingPagesLinksTest {

    public static void main(String[] args) throws InterruptedException, IOException {
        
    	System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        // Path to Excel file
        String excelFilePath = "TestData/LandingPageAutomation-2.xlsx";

         FileInputStream file = new FileInputStream(excelFilePath);
             Workbook workbook = new XSSFWorkbook(file); 

            // Assuming the links are in the first sheet and the links are in the first column (index 0)
            Sheet sheet = workbook.getSheetAt(0);

            // Iterate through rows
            for (Row row : sheet) {
            	 if (row.getRowNum() == 0) continue;
                 
            	   String link = row.getCell(0).getStringCellValue();
                   System.out.println("URL Link : "+ link);
              
     			// Navigate to initial URL
                 driver.get(link);
                 System.out.println(link);
                    
                    // Pause for a moment (you might want to replace this with a more sophisticated wait mechanism)
                   // Thread.sleep(2000);
                    
                    Cell resultCell = row.createCell(1);
                    if (driver.getTitle() != "404 Not Found") {
                    	
                    	String pageTitle = driver.getTitle();
                        resultCell.setCellValue("Pass");
                        
                        TakesScreenshot ts = (TakesScreenshot)driver;
                        File scrFile= ts.getScreenshotAs(OutputType.FILE);
                        String filePath = System.getProperty("user.dir")+"/LandingPagesScreenshot-2/"+pageTitle+System.currentTimeMillis()+"png";
                        File destFile=new File(filePath);
                        FileUtils.copyFile(scrFile, destFile);
                    } else {
                        resultCell.setCellValue("Failed");
                    }
                }
         // Save the updated Excel file
            FileOutputStream out = new FileOutputStream("TestData/LandingPageAutomation-2.xlsx");
            workbook.write(out);
            out.close();
     
            // Close WebDriver
            driver.quit();
            }

       
    }


