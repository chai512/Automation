package com.automation.Testcases;

import com.automation.pages.BaseClass;
import com.automation.pages.HomePage;
import com.automation.utility.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.PageFactory.initElements;

public class SearchFlight extends BaseClass {


    @Test
    public void loginFail(){
        logger = report.createTest("LoginFail");
        logger.info("Enter dest details");
        HomePage homepage = new HomePage(driver);
        driver.findElement(By.xpath("//span[contains(text(),'From')]/following-sibling::p")).click();
        driver.findElement(By.xpath("//span[contains(text(),'From')]/following-sibling::input")).sendKeys("Bangalore");

    }

}
