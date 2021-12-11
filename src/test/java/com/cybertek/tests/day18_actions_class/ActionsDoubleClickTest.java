package com.cybertek.tests.day18_actions_class;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ActionsDoubleClickTest extends TestBase {
    @Test
    public void doubleClickForColorChange() {
        driver.get(ConfigurationReader.getProperty("doubleclick.url"));
        //switch to iframe
        driver.switchTo().frame("iframeResult");

        WebElement text = driver.findElement(By.id("demo"));

        System.out.println("text.getText() = " + text.getText());

        //double click to see color change
        //new Actions(driver).doubleClick(text).perform();
        actions.doubleClick(text).perform();

        //<p id="demo" ondblclick="myFunction()" style="color: red;">Double-click me to change my text color.</p>
        System.out.println("style of text = " + text.getAttribute("style"));

        assertTrue(text.getAttribute("style").contains("red"));
        //switch back out from frame
        driver.switchTo().defaultContent();

    }
}
