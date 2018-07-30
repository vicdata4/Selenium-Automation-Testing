package org.utils;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverBase {
    public static WebDriver driver;
    protected Properties ic = new Properties();

   protected DriverBase() {
        try (InputStream is = getClass().getResourceAsStream("/infocenter.properties")){
            ic.load(is);
        } catch (IOException ioe){}
    }

    @BeforeClass
    public static void init(){
        System.setProperty("webdriver.chrome.driver","/Users/vghaya/Documents/chromedriver");
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        
        driver = new ChromeDriver(options);   
 
        String url = "http://www.google.com";
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        driver.get(url);
        
    }

    @AfterClass
    public static void finishIt(){
        //driver.manage().deleteAllCookies();
        //driver.close();
    }
}