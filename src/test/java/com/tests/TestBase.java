package com.tests;

import java.io.*;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.utils.ScreenShot;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;
    public static ExtentHtmlReporter htmlreporter;
    public static ExtentReports extent;
    public static ExtentTest test;
    public static Logger logger;

    public TestBase() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("src/test/resources/config.properties");
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger = Logger.getLogger(TestBase.class);
        PropertyConfigurator.configure("src/test/resources/log4j.properties");
    }

    @BeforeSuite
    public void initDriver() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true); // Required for GitHub Actions
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS);

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeTest
    public void setupExtentEnv() {
        // Use relative path for CI compatibility
        htmlreporter = new ExtentHtmlReporter("test-output/extent-report.html");
        htmlreporter.config().setDocumentTitle("Automation Report");
        htmlreporter.config().setReportName("Functional Report");
        htmlreporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(htmlreporter);
        extent.setSystemInfo("HOST NAME", "GitHub Actions");
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Tester NAME", "Suraj");
        extent.setSystemInfo("Browser", "Chrome");

        logger.info("Extent report configured.");
    }

    @BeforeMethod
    public void register(Method method) {
        String testname = method.getName();
        test = extent.createTest(testname);
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "TEST CASE FAILED: " + result.getName());
            test.log(Status.FAIL, result.getThrowable().toString());
            String screenshotPath = ScreenShot.getScreenshot(driver, result.getName());
            test.addScreenCaptureFromPath(screenshotPath);
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "TEST CASE SKIPPED: " + result.getName());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "TEST CASE PASSED: " + result.getName());
        }
    }

    @AfterTest
    public void cleanup() {
        extent.flush();
    }

    @AfterSuite
    public void browserTeardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
