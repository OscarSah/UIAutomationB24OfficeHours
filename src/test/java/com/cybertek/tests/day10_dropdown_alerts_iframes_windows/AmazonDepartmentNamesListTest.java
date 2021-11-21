package com.cybertek.tests.day10_dropdown_alerts_iframes_windows;

import static com.cybertek.utils.WebDriverFactory.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//import all static methods/Variables of Assert class
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;

public class AmazonDepartmentNamesListTest {

    String url = "https://www.amazon.com";
    WebDriver driver; //can use in every method

    @BeforeMethod
    public void setUp() {
        driver = getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Test
    public void amazonDepartmentTest() {
        String expTitle = "Amazon.com. Spend less. Smile more.";
        assertEquals(driver.getTitle(), expTitle);

        //assert that "All" option is selected by default/automatically
        Select departments = new Select(driver.findElement(By.id("searchDropdownBox")));
        String selectedOption = departments.getFirstSelectedOption().getText();
        assertEquals(selectedOption, "All Departments");

    }
}
