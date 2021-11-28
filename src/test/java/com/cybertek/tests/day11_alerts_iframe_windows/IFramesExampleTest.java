package com.cybertek.tests.day11_alerts_iframe_windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static com.cybertek.utils.WebDriverFactory.getDriver;

public class IFramesExampleTest {
    WebDriver driver;
    String url = "http://practice.cybertekschool.com/iframe";

    @BeforeMethod
    public void setUp() {
        driver = getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Test
    public void iframeTest() {
        //switch to the frame by id "mce_0_ifr"
        driver.switchTo().frame("mce_0_ifr");
        //now we are focused on the frame
        WebElement commentField = driver.findElement(By.id("tinymce"));
        System.out.println("Comment text = " + commentField.getText());
        commentField.clear();
        commentField.sendKeys("Hello Hello");

        //go out from iframe back to main content:
        driver.switchTo().defaultContent();

    }

}
