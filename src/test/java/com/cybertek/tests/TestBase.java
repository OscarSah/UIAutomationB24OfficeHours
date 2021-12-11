package com.cybertek.tests;

import com.cybertek.utils.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class TestBase {
    protected WebDriver driver;
    protected Faker faker = new Faker();

    @BeforeMethod
    public void setUp() {
        driver = Driver.getDriver();
    }

    @AfterMethod
    public void tearDown() {
        //Driver.closeDriver();
    }

}
