package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
        Actions act = new Actions(driver);
        act.keyDown(enterFrom, Keys.SHIFT).sendKeys("Bangalore").keyUp(enterFrom,Keys.SHIFT).build().perform();

    }
    public void enterDest(String dest){
        toPlaceHolder.click();
        enterTo.sendKeys(dest);
        WebElement element = driver.findElement(By.xpath(""));
    }
}
