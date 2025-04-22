package com.tests;

import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class PageswiseRURLCheckerTest {

    public static void main(String[] args) {
    	
    	 StringBuilder csvOutput = new StringBuilder("URL,Status\n"); // CSV header
        
    	System.setProperty("webdriver.chrome.driver", "D:\\Eclipse Workplace\\RAWebsite\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Path to Excel file
        String excelFilePath = "D:\\Eclipse Workplace\\RAWebsite\\TestData\\RA Website Setionwise Url.xlsx";

        try (FileInputStream fis = new FileInputStream(excelFilePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            Sheet sheet1 = workbook.getSheetAt(1);
            Sheet sheet2 = workbook.getSheetAt(2);
            Sheet sheet3 = workbook.getSheetAt(3);
            Sheet sheet4 = workbook.getSheetAt(4);
            Sheet sheet5 = workbook.getSheetAt(5);
            Sheet sheet6 = workbook.getSheetAt(6);
            Sheet sheet7 = workbook.getSheetAt(7);
            Sheet sheet8 = workbook.getSheetAt(8);
            Sheet sheet9 = workbook.getSheetAt(9);
            Sheet sheet10 = workbook.getSheetAt(10);
            Sheet sheet11= workbook.getSheetAt(11);
            Sheet sheet12 = workbook.getSheetAt(12);
            Sheet sheet13 = workbook.getSheetAt(13);
            Sheet sheet14 = workbook.getSheetAt(14);
            Sheet sheet15 = workbook.getSheetAt(15);
            Sheet sheet16 = workbook.getSheetAt(16);
            Sheet sheet17 = workbook.getSheetAt(17);
            Sheet sheet18 = workbook.getSheetAt(18);
            Sheet sheet19 = workbook.getSheetAt(19);
            
            // Iterate through rows
            for (Row row : sheet) {
                // Assuming the links are in the first column (index 0)
                Cell cell = row.getCell(0);

                
                if (cell != null) {
                    String link = cell.getStringCellValue();

                    driver.get(link);
 
                    Thread.sleep(2000);
                }
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } 
        // Write the CSV output to a file

        try (FileWriter writer = new FileWriter("PageWiseURLsresults.csv")) {

            IOUtils.write(csvOutput.toString(), writer);

        } catch (IOException e) {

            e.printStackTrace();

        }
        finally {
       
            driver.quit();
        }
    }
}

