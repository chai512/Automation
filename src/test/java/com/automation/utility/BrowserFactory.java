package com.automation.utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BrowserFactory {

    public static WebDriver startApplication(WebDriver driver, String browserName, String appUrl){

        switch (browserName){
            case "chrome":
                System.setProperty("webdriver.chrome.driver","D:\\Automation\\src\\main\\resources\\Drivers\\chromedriver.exe");
                driver = new ChromeDriver();

        }
        new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(appUrl);
        driver.manage().window().maximize();
        new WebDriverWait(driver, Duration.ofSeconds(10));
        return driver;
    }

}
