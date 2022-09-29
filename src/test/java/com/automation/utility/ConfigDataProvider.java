package com.automation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigDataProvider {

    Properties pro = new Properties();
    public ConfigDataProvider() {

        File file = new File("./Config/config.properties");
        try {
            FileInputStream fis = new FileInputStream(file);
            pro.load(fis);
        } catch (Exception e) {
           System.out.println("No config file is provided in provided path");
        }
    }

    public String getBrowser(){

        return pro.getProperty("Browser");
    }
    public String getQaUrl(){

        return pro.getProperty("QaUrl");
    }

}
