package com.cybertek.tests.day03_locators_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TC4_GoogleSearch {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://www.google.com";
        driver.get(url);
        //locate and type "apple" to google search
        driver.findElement(By.name("q")).sendKeys("apple");

        Thread.sleep(2000);
        //locate and click on search bottom
        driver.findElement(By.name("btnK")).click();
        /**
         * if above two lines did not work , try this way:
         * driver.findElement(By.name("q")).sendKeys("apple" + Keys.ENTER);
         */
        //driver.findElement(By.name("q")).sendKeys("apple" + Keys.ENTER);

        String actTitle = driver.getTitle();
        String expTitle = "apple";

        if (actTitle.startsWith(expTitle)) {
            System.out.println("PASS: Title match");
        } else {
            System.out.println("FAIL: Title mismatched");
        }

        driver.quit();

    }
}
