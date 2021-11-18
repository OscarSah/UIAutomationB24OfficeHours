package com.cybertek.officeHours.oH01;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UI01_PolymerTest {

    /*
    Here is this week's task:
Write a basic browser automation framework to validate a Polymer website.
The focus should be on the interaction with the browser.
The Web Application under test http://todomvc.com/
    The first step should be to load the website,
    click within the JavaScript tab,
    and select the Polymer link.
    The second step should be: Add one Todo item
    Then Verify that the item added.
     */
    public static WebDriver driver;

    public static void main(String[] args) {

        // The first step should be to load the website  http://todomvc.com/
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        String url = "http://todomvc.com/";
        driver.get(url);

        // click within the JavaScript tab
        /*
        WebElement tabLink = driver.findElement(By.xpath("//div[.='JavaScript']"));
        tabLink.click(); */

        getTab("JavaScript").click();

        // select the Polymer link
       /* WebElement link = driver.findElement(By.linkText("Polymer"));
        link.click(); */
        getLink("Polymer").click();

        // edit box
        WebElement addBox = driver.findElement(By.id("new-todo"));


        // The second step should be: Add one Todo item

        String toDoItemOne = "Office Hours for B24";

        addBox.sendKeys(toDoItemOne+ Keys.ENTER);

        String locatorForAddedItem = "//label[.='"+toDoItemOne+"']";
        // string concatination : "//label[.='"+toDoItemOne+"']"
        // "apple"+variable+"banana"


        // Then Verify that the item added

        System.out.println("driver.findElement(By.xpath(locatorForAddedItem)).isDisplayed() = "
                + driver.findElement(By.xpath(locatorForAddedItem)).isDisplayed());

        driver.close();

    }

    public static WebElement getTab(String tab){
        String locator = "//div[.='"+tab+"']";
        return driver.findElement(By.xpath(locator));
    }

    public static WebElement getLink(String link){

        return driver.findElement(By.linkText(link));
    }

}
