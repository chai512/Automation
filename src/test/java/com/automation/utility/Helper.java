package com.automation.utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;

import java.io.File;

public class Helper {

    public static String captureScreenshot(WebDriver driver,String testName){
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String destPath =  "D:/Automation/screenshots/"+testName +".png";
        try{
            FileHandler.copy(src,new File(destPath));
        }catch (Exception e){
            System.out.println("IO Exception");
        }
        return destPath;
    }


}
