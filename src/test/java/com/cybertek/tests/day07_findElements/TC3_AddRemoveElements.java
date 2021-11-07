package com.cybertek.tests.day07_findElements;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TC3_AddRemoveElements {
    public static void main(String[] args) {
        String url = "http://practice.cybertekschool.com/add_remove_elements/";

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get(url);

        //locate and click addElement button 50 times
        WebElement addElement = driver.findElement(By.xpath("//button[@onclick='addElement()']"));

        for (int i = 0; i < 50; i++) {
            addElement.click();
        }

        //verify 50 delete buttons are on the page
        List<WebElement> deleteButtons = driver.findElements(By.xpath("//button[.='Delete']"));
        System.out.println("Count of delete Buttons = " + deleteButtons.size());
        if (deleteButtons.size() == 50) {
            System.out.println("PASS: 50 buttons added successfully");
        } else {
            System.out.println("FAIL: cannot add 50 buttons");
        }

        //click all delete buttons to remove them
        for (WebElement deleteButton : deleteButtons) {
            deleteButton.click();
        }

        //ForEach method with lambda expression (->)
        //deleteButtons.forEach(delete -> delete.click());

        //run findElements for delete buttons again and see if it is 0
        deleteButtons = driver.findElements(By.xpath("//button[.='Delete']"));
        if (deleteButtons.isEmpty()) {
            System.out.println("PASS: All 50 buttons deleted successfully");
        } else {
            System.out.println("FAIL: Could not delete all 50 buttons");
        }

        driver.quit();

    }
}
