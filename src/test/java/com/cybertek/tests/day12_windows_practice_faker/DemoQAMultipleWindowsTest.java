package com.cybertek.tests.day12_windows_practice_faker;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class DemoQAMultipleWindowsTest {
    WebDriver driver;
    String url = "https://demoqa.com/browser-windows";
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.get(url);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    /**
     Click on New Window button
     Switch to new window
     Locate and print the message
     Close the new window
     Go back to main window
     */

    @Test
    public void newWindowTest() throws InterruptedException {
        WebElement newWindowBtn = driver.findElement(By.cssSelector("#windowButton"));
        newWindowBtn.click();

        Thread.sleep(2000);
        //driver.close(); // close currently active window
        //driver.quit(); // closes all opened windows in same session

        Set<String> windowHandlesSet = driver.getWindowHandles();
        String parentWindowHandle = driver.getWindowHandle(); //store current window handle

        for(String windowHandle : windowHandlesSet) {
            if (!windowHandle.equals(parentWindowHandle)) {
                driver.switchTo().window(windowHandle);
            }
        }

        WebElement header = driver.findElement(By.cssSelector("#sampleHeading"));
        System.out.println("header text = " + header.getText());

        Thread.sleep(2000);

        driver.close(); //closes current window

        //go back to parent window
        driver.switchTo().window(parentWindowHandle);
        System.out.println("title = " + driver.getTitle());

    }
}
