package com.cybertek.tests.day05_xpath_css_isdisplayed;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P6_MultipleButtonsXpathTest {
    public static void main(String[] args) {
        String appUrl = "http://practice.cybertekschool.com/multiple_buttons";
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get(appUrl);
        //<button class="btn btn-primary" onclick="button1()">Button 1</button>
        WebElement button1 = driver.findElement(By.xpath("//button[@onclick='button1()']"));
        button1.click();

        //<p id="result" style="color:green">Clicked on button one!</p>
        WebElement resultMsg = driver.findElement(By.xpath("//p[@id='result']"));
        System.out.println(resultMsg.getText());
    }
}
