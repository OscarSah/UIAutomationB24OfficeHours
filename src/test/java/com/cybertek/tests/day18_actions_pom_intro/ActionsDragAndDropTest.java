package com.cybertek.tests.day18_actions_pom_intro;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ActionsDragAndDropTest extends TestBase {
    @Test
    public void dragAndDropTest() {
        driver.get(ConfigurationReader.getProperty("draganddrop.url"));

        WebElement source = driver.findElement(By.linkText("5000"));
        WebElement target = driver.findElement(By.id("amt7"));

        actions.dragAndDrop(source,target).perform();

    }
}
