package com.cybertek.tests.day14_utils_webtables_properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static com.cybertek.utils.WebDriverFactory.getDriver;

public class WebTableDemoTest {
    WebDriver driver;
    String url = "http://practice.cybertekschool.com/tables";

    @BeforeMethod
    public void setUp() {
        driver = getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Test
    public void readFromTableTest() {
        //Print table data as a single String, not so common, but useful sometimes
        WebElement table1 = driver.findElement(By.xpath("//table[@id='table1']"));
        System.out.println("Table 1 text = " + table1.getText());
    }


}
