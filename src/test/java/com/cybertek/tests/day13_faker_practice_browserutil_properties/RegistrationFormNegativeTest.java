package com.cybertek.tests.day13_faker_practice_browserutil_properties;

import com.cybertek.utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class RegistrationFormNegativeTest extends RegistrationFormTestBase {
    @Test
    public void invalidFirstNameTest() {
        //do not enter any value in firstname and click on sign up
        //"first name is required" error msg should be displayed
        WebElement signUp = driver.findElement(By.id("wooden_spoon"));
        signUp.click();

        //wait for 1 second
        BrowserUtils.sleep(2);

    }
}
