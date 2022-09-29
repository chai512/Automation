package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//span[contains(text(),'From')]/following-sibling::p")
    WebElement fromPlaceHolder;
    @FindBy(xpath = "//span[contains(text(),'From')]/following-sibling::input")
    WebElement enterFrom;
    @FindBy(xpath = "//span[contains(text(),'To')]/following-sibling::p")
    WebElement toPlaceHolder;
    @FindBy(xpath = "//span[contains(text(),'To')]/following-sibling::input")
    WebElement enterTo;



    public void enterOrigin(String origin){
        fromPlaceHolder.click();
        enterFrom.sendKeys(origin);
    }
    public void enterDest(String dest){
        toPlaceHolder.click();
        enterTo.sendKeys(dest);
    }
}
