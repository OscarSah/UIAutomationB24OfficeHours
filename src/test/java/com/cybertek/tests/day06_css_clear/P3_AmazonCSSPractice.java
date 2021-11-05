package com.cybertek.tests.day06_css_clear;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P3_AmazonCSSPractice {
    public static void main(String[] args) throws InterruptedException {
        String appUrl = "https://www.amazon.com";
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get(appUrl);

        Thread.sleep(3000);
        //type Wooden spoon
        WebElement searchField = driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"));
        WebElement searchButton = driver.findElement(By.cssSelector("input[value='Go']"));

        searchField.sendKeys("wooden spoon");
        searchButton.click();

        Thread.sleep(2000);
        /**
         Page refreshes at this point
         We need to locate the elements again in order to use them
         So we need to repeat steps 17-18
         */
        //clear the search input box then search for "iphone 13 case"
        searchField = driver.findElement(By.cssSelector("input[name='field-keywords']"));
        searchButton = driver.findElement(By.cssSelector("input[id='nav-search-submit-button']"));

        //clear the value of search field
        searchField.clear();
        searchField.sendKeys("iphone wooden case");
        searchButton.click();


    }
}
