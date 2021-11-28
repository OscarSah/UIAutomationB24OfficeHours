package com.cybertek.tests.day11_alerts_iframe_windows;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static com.cybertek.utils.WebDriverFactory.getDriver;

public class AlertExamplesTest {

    WebDriver driver;
    String url = "http://practice.cybertekschool.com/javascript_alerts";

    @BeforeMethod
    public void setUp() {
        driver = getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Test
    public void infoAlertTest() {
        //click on JS alert link
        WebElement alertLink = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        alertLink.click();
        //switch to the alert and assert text is "I am a JS Alert"
        Alert alert = driver.switchTo().alert();
        System.out.println("Text of Alert = " + alert.getText());
        assertEquals(alert.getText(), "I am a JS Alert");
        alert.accept(); //clicking on Ok button on the alert

        //assert the confirmation message is displayed
        WebElement resultMsg = driver.findElement(By.id("result"));
        System.out.println("resultMsg.getText() = " + resultMsg.getText());
        assertEquals(resultMsg.getText(), "You successfuly clicked an alert");
    }

    @Test
    public void confirmAlertTest() {
        //click on JS Confirm button
        WebElement jsConfirmBtn = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        jsConfirmBtn.click();
        //switch to alert then assert the text is "I am a JS Confirm"
        Alert confirmAlert = driver.switchTo().alert();
        System.out.println("Confirm alert text = " + confirmAlert.getText());
        assertEquals(confirmAlert.getText(), "I am a JS Confirm");

        //click on cancel
        confirmAlert.dismiss();

        //assert result message is "You clicked: Cancel"
        WebElement resultMsg = driver.findElement(By.id("result"));
        System.out.println("resultMsg.getText() = " + resultMsg.getText());
        assertEquals(resultMsg.getText() , "You clicked: Cancel");

    }




}
