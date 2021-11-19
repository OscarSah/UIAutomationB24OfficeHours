package com.cybertek.tests.day09_testng_dropdowns;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DropDownTests {

    String url = "http://practice.cybertekschool.com/dropdown";
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.out.println("Setting up WebDriver...");
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Test
    public void titleTest() {
        System.out.println("Title of the page = " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Practice");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Closing browser");
        driver.quit();
    }

}
