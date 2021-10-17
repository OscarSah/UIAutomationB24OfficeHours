package com.cybertek.tests.day01_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {
    public static void main(String[] args) throws InterruptedException {
        //1) set up the browser driver
        WebDriverManager.chromedriver().setup();

        //Open browser
        WebDriver driver = new ChromeDriver();

        //navigate to tesla homepage
        driver.get("https://www.tesla.com");

        //navigate back. similar to clicking back button
        //on the browser
        driver.navigate().back();

        //pause/stop the code. code will sleep/wait
        Thread.sleep(2000);

        //navigate forward
        driver.navigate().forward();

        Thread.sleep(2000);

        //refresh the page.
        driver.navigate().refresh();

        Thread.sleep(2000);

        //navigate to etsy homepage
        driver.navigate().to("https://www.bestbuy.com");

        //print title of the page
        System.out.println("Current title: " + driver.getTitle());

        //close the browser
        driver.quit();


    }
}
