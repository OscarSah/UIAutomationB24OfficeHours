package com.cybertek.tests.day08_implicitwait_checkbox_radio_testng;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class RadioButtonsTest {
    public static void main(String[] args) {
        String url = "http://practice.cybertekschool.com/radio_buttons";
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //wait upto 10 seconds while finding element
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);

        WebElement red = driver.findElement(By.id("red"));
        if(!red.isSelected()) {
            red.click();
        }

        //select football
        WebElement football = driver.findElement(By.id("football"));
        if (!football.isSelected()) {
            System.out.println("SELECTING <Football> radio button");
            football.click();
        }

        //verify if football option is selected
        if (football.isSelected()) {
            System.out.println("PASS - football is selected");
        } else {
            System.out.println("FAIL - football is not selected");
        }

        //find all radio buttons
        //print the count
        //click one by one , waiting 1 second in between
        //we can use isEnabled method to check if element is active/disabled



    }
}
