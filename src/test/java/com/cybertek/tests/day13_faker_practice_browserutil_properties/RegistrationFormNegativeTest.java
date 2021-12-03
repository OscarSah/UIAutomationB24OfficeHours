package com.cybertek.tests.day13_faker_practice_browserutil_properties;

import com.cybertek.utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class RegistrationFormNegativeTest extends RegistrationFormTestBase {
    @Test
    public void invalidFirstNameTest() {
        //do not enter any value in firstname and click on sign up
        //"first name is required" error msg should be displayed
        WebElement signUp = driver.findElement(By.id("wooden_spoon"));
        signUp.click();

        //wait for 1 second
        BrowserUtils.sleep(2);

        WebElement errorMsg = driver.findElement(By.xpath("//small[.='first name is required']"));
        assertTrue(errorMsg.isDisplayed(), "Error message is not displayed");

        //type 12345 and verify "first name can only consist of alphabetical letters" is displayed
        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("12345");

        BrowserUtils.sleep(2);

        WebElement noNumbersMsg = driver.findElement(By.xpath("//small[.='first name can only consist of alphabetical letters']"));
        assertTrue(noNumbersMsg.isDisplayed(), "Error message is not displayed");

    }
}
