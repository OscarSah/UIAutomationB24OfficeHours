package com.cybertek.tests.day08_implicitwait_checkbox_radio_testng;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class EtsyRadioCheckboxTest {
    public static void main(String[] args) {
        String url = "https://www.etsy.com";
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //wait upto 10 seconds while finding element
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);

        //search for wooden spoon
        WebElement searchField = driver.findElement(By.name("search_query"));
        searchField.sendKeys("wooden spoon" + Keys.ENTER);

        //click on All filters
        WebElement allFilters = driver.findElement(By.id("search-filter-button"));
        allFilters.click();
    }
}
