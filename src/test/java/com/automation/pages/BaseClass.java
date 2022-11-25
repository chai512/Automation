package com.automation.pages;

import com.automation.utility.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.observer.ExtentObserver;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.sql.SQLException;

public class BaseClass {

    public WebDriver driver;
    public ConfigDataProvider configDataProvider;
    public ExcelDataProvider excelDataProvider;
    public  ExtentReports report;
    public  ExtentTest logger;
    public DBConnection dbConnection;

    @Parameters("browser")
    @BeforeSuite
    public void setUpBrowser(String browser) throws SQLException, ClassNotFoundException {
        ExtentSparkReporter spark = new ExtentSparkReporter(new File("./Reports/LatestReport.html"));
        report = new ExtentReports();
        report.attachReporter(spark);
        dbConnection = new DBConnection();
        configDataProvider = new ConfigDataProvider();
        BrowserFactory.startApi();
        driver = BrowserFactory.startApplication(driver,browser,configDataProvider.getQaUrl());
    }

    @AfterMethod
    public void captureScreenshotOnFailure(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            logger.fail(MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver,result.getName())).build());
        }else if(result.getStatus() == ITestResult.SUCCESS){
           logger.pass(MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver,result.getName())).build());
        }

    }
    @AfterSuite
    public void closeAllDrivers(){
        report.flush();
        driver.quit();
    }


}
