package com.cybertek.tests.day10_dropdown_alerts_intro;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
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

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void jsAlertsTest() throws InterruptedException {
        //click on Informational/Warning alert link
        WebElement infoAlertLink = driver.findElement(By.xpath("//*[.='Click for JS Alert']"));
        infoAlertLink.click();

        Thread.sleep(1234);

        //switch to alert and click on Ok
        Alert infoAlert = driver.switchTo().alert();
        System.out.println("Text of alert = " + infoAlert.getText());
        infoAlert.accept(); //click on Ok
    }

    @Test
    public void confirmAlertTest() throws InterruptedException {
        WebElement confirm = driver.findElement(By.xpath("//*[.='Click for JS Confirm']"));
        confirm.click();

        Thread.sleep(1234);

        Alert alert = driver.switchTo().alert();
        System.out.println("Text of alert = " + alert.getText());
        Assert.assertEquals(alert.getText(), "I am a JS Confirm");

        alert.dismiss(); //cancel
    }

}
