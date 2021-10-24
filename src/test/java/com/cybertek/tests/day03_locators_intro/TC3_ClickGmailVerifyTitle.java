package com.cybertek.tests.day03_locators_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC3_ClickGmailVerifyTitle {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String url = "https://www.google.com";
        driver.get(url);
        //Find Gmail link and click on it
        driver.findElement(By.linkText("Gmail")).click();
        //driver.findElement(By.partialLinkText("mail")).click();
        //verify title contains/starts with Gmail
        String expectedTitle = "Gmail";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitle)) {
            System.out.println("PASS: gmail title verification successful");
        } else {
            System.out.println("FAIL: gmail title verification failed");
        }

        //go back
        driver.navigate().back();

        String googleExpectedTitle = "Google";
        String googleActTitle = driver.getTitle();

        if (googleActTitle.equals(googleExpectedTitle)) {
            System.out.println("PASS: Google title verification passed");
        } else {
            System.out.println("FAIL: Google title verification failed");
        }

        driver.quit();

    }
}
