package com.cybertek.tests.day05_xpath_css_isdisplayed;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P1_ForgotPassword_xpath_css {
    public static void main(String[] args) {

        String appUrl = "http://practice.cybertekschool.com/forgot_password";

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get(appUrl);

        //<a class="nav-link" href="/">Home</a>
        WebElement homeLink = driver.findElement(By.xpath("//a[@class='nav-link']"));

        //<h2>Forgot Password</h2>
        WebElement forgotPasswordHeader = driver.findElement(By.xpath("//h2[.='Forgot Password']"));

        WebElement emailLabel ;
        WebElement emailField ;
        WebElement retrievePasswordBtn ;
        WebElement poweredByLabel ;

        System.out.println("homelink = " + homeLink.isDisplayed());

    }
}
