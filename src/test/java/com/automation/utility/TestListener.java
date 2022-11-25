package com.automation.utility;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        if(!result.isSuccess()){

        }

    }
}
