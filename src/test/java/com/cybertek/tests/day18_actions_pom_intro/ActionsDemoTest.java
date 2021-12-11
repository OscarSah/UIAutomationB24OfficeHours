package com.cybertek.tests.day18_actions_pom_intro;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsDemoTest extends TestBase {
    @Test
    public void hoverElementTest() {
        driver.get(ConfigurationReader.getProperty("hover.url"));

        WebElement img1 = driver.findElement(By.xpath("(//img)[1]"));

        //create Actions class object to be able to hover over image
        Actions actions = new Actions(driver);

        //hover over img1
        actions.moveToElement(img1).perform();

        BrowserUtils.sleep(1);

        WebElement img2 = driver.findElement(By.xpath("(//img)[2]"));
        actions.moveToElement(img2).perform();

        BrowserUtils.sleep(1);

        WebElement img3 = driver.findElement(By.xpath("(//img)[3]"));
        actions.moveToElement(img3).perform();

        //repeat above steps with the loop

    }
}
