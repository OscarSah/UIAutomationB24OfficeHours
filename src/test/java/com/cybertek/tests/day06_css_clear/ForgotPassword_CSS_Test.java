package com.cybertek.tests.day06_css_clear;

import com.cybertek.utils.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ForgotPassword_CSS_Test {
    public static void main(String[] args) throws InterruptedException {
        String appUrl = "http://practice.cybertekschool.com/forgot_password";
        WebDriver driver = WebDriverFactory.getDriver("chrome");
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get(appUrl);

        WebElement emailField = driver.findElement(By.cssSelector("input[name='email']"));
        emailField.sendKeys("student1@gmail.com");
        //wait a second and clear > type different email
        Thread.sleep(1234);

        emailField.clear(); //clear and make empty
        emailField.sendKeys("student2@gmail.com");

        //loop
        for (int i = 3; i < 10; i++) {
            Thread.sleep(1234);

            emailField.clear(); //clear and make empty
            emailField.sendKeys("student"+i+"@gmail.com");
        }
    }
}
