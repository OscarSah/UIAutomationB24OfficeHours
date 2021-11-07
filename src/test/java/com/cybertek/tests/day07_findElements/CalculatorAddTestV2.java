package com.cybertek.tests.day07_findElements;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalculatorAddTestV2 {
    public static void main(String[] args) {
        String appUrl = "https://www.calculator.net";
        int num1 = 8, num2 = 9;
        /**
            Homework: make selenium work for numbers more than 1 digit as well
         int num1 = 128, num2 = 90; etc
         */
        int expectedResult = num1 + num2;
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get(appUrl);
        System.out.println("//span[.='"+ num1 +"']"); // //span[.='7']
        WebElement num1Elem = driver.findElement(By.xpath("//span[.='" + num1 + "']"));
        WebElement num2Elem = driver.findElement(By.xpath("//span[.='" + num2 + "']"));
        WebElement plus = driver.findElement(By.xpath("//span[.='+']"));
        WebElement equals = driver.findElement(By.xpath("//span[.='=']"));

        num1Elem.click();
        plus.click();
        num2Elem.click();
        equals.click();

        WebElement result = driver.findElement(By.xpath("//div[@id='sciOutPut']"));
        System.out.println("Result = " + result.getText());

        driver.quit();

    }
}
