package com.cybertek.officeHours.oH02;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SmartBearTask {
/*
Test Case 1:
Basic login authentication
- Go to:  http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
- Verify title equals: String expectedTitle = "Web Orders Login"
- Enter username: Tester
- Enter password: test
- Click “Sign In” button
- Verify title equals: String expectedHomePageTitle = "Web Orders"

Test Case 2:
After login
 - click on Check All button
 - verify that all check buttons are selected
 - click on Uncheck All button
 - verify that all buttons are unchecked
 - select one of the check box and delete that row
 - verify that row of information is deleted
Hope to see you all and hope to have a productive time together.
 */

    @Test
    public void loginTest(){

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        // open the page
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        // page Title before login
        String expectedTitle = "Web Orders Login";
        String actualTitle = driver.getTitle();
        System.out.println(expectedTitle.equalsIgnoreCase(actualTitle));
        // username box info
        WebElement username = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        username.sendKeys("Tester");
        // password box
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test"+ Keys.ENTER);

        // check the title after login

        String expectedTitleAfterLogin = "Web Orders";
        String actualTitleAfterLogin = driver.getTitle();
        System.out.println(expectedTitleAfterLogin.equalsIgnoreCase(actualTitleAfterLogin));

        driver.close();
    }


}
