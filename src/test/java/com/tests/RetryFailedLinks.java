package com.tests;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


	
        public class RetryFailedLinks {

            public static void main(String[] args) {
                String[] failedLinks = {
                    "https://example.com/failed_link1",
                    "https://example.com/failed_link2",
                    "https://example.com/failed_link3"
                };

                retryFailedLinks(failedLinks, 3, 5000); // 3 retries with a delay of 5000 milliseconds
            }

            public static void retryFailedLinks(String[] links, int maxRetries, long delay) {
                for (String link : links) {
                    int retryCount = 0;
                    boolean success = false;

                    while (retryCount < maxRetries && !success) {
                        try {
                            // Make a request to the URL
                            URL url = new URL(link);
                            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                            // Check if the request was successful (status code 2xx)
                            int statusCode = connection.getResponseCode();
                            if (statusCode >= 200 && statusCode < 300) {
                                System.out.println("Success: " + link);
                                success = true;
                            } else {
                                System.out.println("Failed: " + link + " - Status Code: " + statusCode);
                            }

                            connection.disconnect();

                        } catch (IOException e) {
                            System.out.println("Error: " + link + " - " + e.getMessage());
                        }

                        // If the request failed, wait for a specified delay before retrying
                        if (!success) {
                            retryCount++;
                            try {
                                Thread.sleep(delay);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
       
	}

