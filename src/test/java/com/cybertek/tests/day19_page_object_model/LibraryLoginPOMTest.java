package com.cybertek.tests.day19_page_object_model;

import com.cybertek.pages.LibraryLoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import org.testng.annotations.Test;

public class LibraryLoginPOMTest extends TestBase {
    @Test
    public void invalidCredentialsTest() {
        driver.get(ConfigurationReader.getProperty("library.url"));
        //create object of LibraryLoginPage page object class
        LibraryLoginPage loginPage = new LibraryLoginPage();
        //access email WebElement and type the email
        loginPage.email.sendKeys("invalid_email@gmail.com");
    }

}
