package com.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class URLredirection {

    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "D:\\Eclipse Workplace\\RAWebsite\\drivers\\chromedriver.exe");

        // Create a new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Load the Excel file
            FileInputStream fileInputStream = new FileInputStream("D:\\Eclipse Workplace\\RAWebsite\\TestData\\SampleURL Redirection.xlsx");
            Workbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0);

            // Iterate through each row in the Excel sheet
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);

                // Get the URLs from columns 0 and 1
                String originalUrl = row.getCell(0).getStringCellValue();
                String redirectUrl = row.getCell(1).getStringCellValue();

                // Navigate to the original URL
                driver.get(originalUrl);
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

                // Perform context menu action (assuming right-click is needed)
                // Example: Right-click on an element with id "exampleElementId"
                // You can adjust this based on your actual use case
               // driver.findElement(By.id("exampleElementId")).contextClick().perform();

                // Perform redirection
                driver.navigate().to(redirectUrl);

                // Validate if redirection is successful
                String currentUrl = driver.getCurrentUrl();
                if (currentUrl.equals(redirectUrl)) {
                    // Update Excel with "Pass" if redirection is successful
                    row.createCell(2).setCellValue("Pass");
                } else {
                    // Update Excel with "Fail" if redirection is unsuccessful
                    row.createCell(2).setCellValue("Fail");
                }
            }

            // Save the changes to the Excel file
            FileOutputStream fileOutputStream = new FileOutputStream("D:\\Eclipse Workplace\\RAWebsite\\TestData\\SampleURL Redirection.xlsx");
            workbook.write(fileOutputStream);
            fileOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close the WebDriver
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
