package com.cybertek.tests.day01_selenium_intro;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) {
        //1) set up browser driver
        WebDriverManager.chromedriver().setup();

        //2) open the browser. Create object of ChromeDriver class
        WebDriver driver = new ChromeDriver();

        //Goto google homepage
        driver.get("https://www.google.com");

    }
}
