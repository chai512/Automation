package com.automation.utility;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.manager.SeleniumManager;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class
BrowserFactory {

    public static WebDriver startApplication(WebDriver driver, String browserName, String appUrl){

        switch (browserName){
            case "chrome":
             driver = new ChromeDriver();
                break;
            case "firefox":
                driver= new FirefoxDriver();
                break;
            case "edge":
                driver= new EdgeDriver();
                break;
        }
        new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(appUrl);
        driver.manage().window().maximize();
        new WebDriverWait(driver, Duration.ofSeconds(10));
        return driver;
    }
    public static void startApi(){
        baseURI = "https://reqres.in/api/";
        JSONObject json = new JSONObject();
        json.put("name","Lekha");
        json.put("job","leader");
        String res = given().body(json.toString()).log().all().
                when().post("/users").
                then().assertThat().statusCode(201).extract().response().asString();

        given().log().all().
                when().get("/users?page=2").then().assertThat().body("$",notNullValue());
        given().log().all().
                when().get("/users?page=2").then().assertThat().body(containsString("aqua sky"));
    }
}
