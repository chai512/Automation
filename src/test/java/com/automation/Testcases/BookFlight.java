package com.automation.Testcases;

import com.automation.pages.BaseClass;
import com.automation.pages.HomePage;
import com.automation.utility.BrowserFactory;
import com.automation.utility.Helper;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.PageFactory.initElements;

public class BookFlight extends BaseClass {


    @Test
    public void enterOriginDetails(){
        logger = report.createTest("Add Origin details").info("Entering origin details");
        HomePage homepage = new HomePage(driver);
        homepage.enterOrigin("Bangalore");
        Assert.assertTrue(true,"Origin entered");
    }


}
