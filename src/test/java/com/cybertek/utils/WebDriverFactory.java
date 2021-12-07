package com.cybertek.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 WebDriverFactory class:
    is used to create WebDriver(Selenium) object and return it.
    It will open the browser
 method:
    getDriver(String browserType)
    It will check browser type and returns object:
        if browserType is "chrome":
            it will set up chrome driver, and return new ChromeDriver
        if browserType is "firefox":
            it will set up firefox driver, and return new FirefoxDriver
 EX:
    WebDriver driver = WebDriverFactory.getDriver("chrome");
    and use driver as normal
 Thank you, nice working with you, Bye
 */

public class WebDriverFactory {

    public static WebDriver getDriver(String browserType) {
        if (browserType.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else if (browserType.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else {
            System.out.println("Invalid BrowserType = " + browserType);
            return null; //null means No object. empty
        }
    }
}
