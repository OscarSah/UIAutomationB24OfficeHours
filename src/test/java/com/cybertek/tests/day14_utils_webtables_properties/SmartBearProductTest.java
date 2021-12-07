package com.cybertek.tests.day14_utils_webtables_properties;

import com.cybertek.utils.SmartBearUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class SmartBearProductTest extends SmartBearTestBase {

    @Test
    public void verifyLinksAfterLogin() {
        //perform login steps
        SmartBearUtils.loginToSmartBear(driver);

        //get all the links and print count and text
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Links count = " + links.size());

        for(WebElement link : links) {
            System.out.println("Link text = " + link.getText());
        }

    }

}
