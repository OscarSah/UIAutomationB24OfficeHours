package com.cybertek.tests.day10_dropdown_alerts_iframes_windows;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static com.cybertek.utils.WebDriverFactory.getDriver;

public class HandlingAlertsTest {
    String url = "http://practice.cybertekschool.com/javascript_alerts";
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Test
    public void jsAlertsTest() {
        //click on Informational/Warning alert link
        WebElement infoAlertLink = driver.findElement(By.xpath("//*[.='Click for JS Alert']"));
        infoAlertLink.click();

        Alert infoAlert = driver.switchTo().alert();
        infoAlert.accept(); //click on Ok




    }

}
