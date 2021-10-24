package com.cybertek.tests.day03_locators_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZeroBankTC2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String appUrl = "http://zero.webappsecurity.com/login.html";
        driver.get(appUrl);

        String textOfLink = driver.findElement(By.className("brand")).getText();
        System.out.println("textOfLink = " + textOfLink);

        if (textOfLink.equals("Zero Bank")) {
            System.out.println("PASS: link text matched");
        } else {
            System.out.println("FAIL: link text mismatched");
        }

        String href = driver.findElement(By.className("brand")).getAttribute("href");
        System.out.println("href = " + href);

        driver.quit();

    }
}
