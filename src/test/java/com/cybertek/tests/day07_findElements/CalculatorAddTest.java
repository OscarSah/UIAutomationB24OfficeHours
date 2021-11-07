package com.cybertek.tests.day07_findElements;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalculatorAddTest {
    public static void main(String[] args) throws InterruptedException {
        String appUrl = "https://www.calculator.net";
        int num1 = 5, num2 = 3, expectedResult = 8;

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get(appUrl);

        /**
         4) Locate 4 elements “5”, “3”, “+” , “=” using css or xpath and store into WebElement
         objects
         */
        WebElement num1Elem = driver.findElement(By.cssSelector("span[onclick='r(5)']"));
        WebElement num2Elem = driver.findElement(By.cssSelector("span[onclick='r(3)']"));
        //        <span onclick="r('+')" class="sciop"> + </span>
        WebElement addElem = driver.findElement(By.xpath("//span[.='+']"));
        WebElement equalElem = driver.findElement(By.xpath("//span[text()='=']"));
        //5+3=
        num1Elem.click();
        Thread.sleep(1234);
        addElem.click();
        Thread.sleep(1234);
        num2Elem.click();
        Thread.sleep(1234);
        equalElem.click();

        //6) Locate result area and store into webElement object
        WebElement result = driver.findElement(By.cssSelector("div[id='sciOutPut']"));//#sciOutPut

        System.out.println(num1 +" + "+ num2 + " = " + result.getText());
        String resultValue = result.getText();
        //get rid//remove of right/left spaces
        resultValue = resultValue.trim();
        //convert from String to int
        int actualResult = Integer.parseInt(resultValue);

        if (actualResult == expectedResult) {
            System.out.println("Pass: calculation match");
        } else {
            System.out.println("Fail: calculation mismatch");
        }

        driver.quit();
    }
}
