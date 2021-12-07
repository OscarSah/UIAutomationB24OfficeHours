package com.cybertek.tests;

import com.cybertek.utils.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class TestBase {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = Driver.getDriver();
    }

    @AfterMethod
    public void tearDown() {
        //Driver.closeDriver();
    }

}
