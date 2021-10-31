package com.cybertek.tests.day05_xpath_css_isdisplayed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC3_ForgotPassword {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "http://practice.cybertekschool.com/forgot_password";
        driver.get(url);

        //enter email
        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("viped47430@niekie.com");

        //click on retrieve password
        WebElement retrievePwdBtn = driver.findElement(By.id("form_submit"));
        retrievePwdBtn.click();

        //verify url contains email_sent
        String currentUrl = driver.getCurrentUrl();
        if(currentUrl.contains("email_sent")) {
            System.out.println("PASS: email_sent url verified");
        } else {
            System.out.println("FAIL: email_sent url failed");
        }

        //verify Your e-mail's been sent! is displayed
        WebElement message = driver.findElement(By.name("confirmation_message"));
        System.out.println("message displayed = " + message.getText());

        //<h4 name="confirmation_message">Your e-mail's been sent!</h4>

        String expMessage = "Your e-mail's been sent!";
        String actMessage = message.getText();

        if (actMessage.equals(expMessage)) {
            System.out.println("PASS: message displayed correctly");
        } else {
            System.out.println("FAIL: message is not displayed as expected");
        }

        System.out.println("'Name' attribute value of message element = " + message.getAttribute("name"));

        driver.quit();

    }
}
