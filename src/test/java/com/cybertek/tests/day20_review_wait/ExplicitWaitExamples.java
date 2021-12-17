package com.cybertek.tests.day20_review_wait;

import com.cybertek.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ExplicitWaitExamples extends TestBase {

    //  http://practice.cybertekschool.com/dynamic_loading/1


    @Test
    public void test1(){

        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        WebElement triggerButton = driver.findElement(By.xpath("//button[.='Start']"));

        triggerButton.click();

        WebElement userName = driver.findElement(By.id("username"));

        // In order to use explicit wait you need to create "wait" object
        WebDriverWait wait = new WebDriverWait(driver,10);  // constructor expects parameters
        // 1. Driver object, 2. waiting time

        // give condition for the element that you are waiting for, for this case elelent taht I am waiting for is userName

        wait.until(ExpectedConditions.visibilityOf(userName));

        userName.sendKeys("MikeSmith");

        // when we comment out implicit wait to observe synchronization problem
        // ElementNotInteractableException: element not interactable

    }

}
