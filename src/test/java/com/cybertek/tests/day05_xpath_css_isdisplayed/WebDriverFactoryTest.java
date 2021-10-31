package com.cybertek.tests.day05_xpath_css_isdisplayed;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class WebDriverFactoryTest {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.etsy.com");

    }
}
