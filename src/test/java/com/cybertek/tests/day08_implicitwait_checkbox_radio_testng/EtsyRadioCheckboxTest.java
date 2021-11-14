package com.cybertek.tests.day08_implicitwait_checkbox_radio_testng;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class EtsyRadioCheckboxTest {
    public static void main(String[] args) throws InterruptedException {
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

        //select Free shipping, on sale, under $25 > click on Apply
        WebElement freeShipping = driver.findElement(By.xpath("//label[@for='special-offers-free-shipping']"));
        freeShipping.click();

        WebElement onSale = driver.findElement(By.xpath("//label[@for='special-offers-on-sale']"));
        onSale.click();

        WebElement under$25 = driver.findElement(By.xpath("//label[@for='price-input-1']"));
        under$25.click();

        WebElement apply = driver.findElement(By.xpath("//button[@aria-label='Apply']"));
        apply.click();

        Thread.sleep(2000);

        WebElement resultsCount = driver.findElement(By.xpath("//span[contains(text(),'results,')]"));
        System.out.println("Results = " + resultsCount.getText());
        driver.quit();

    }
}
