package com.cybertek.tests.day11_alerts_iframe_windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import static com.cybertek.utils.WebDriverFactory.getDriver;

public class MultipleWindowsExampleTest {
    WebDriver driver;
    String url = "http://practice.cybertekschool.com/windows";
    String demoQaUrl = "https://demoqa.com/browser-windows";

    @BeforeMethod
    public void setUp() {
        driver = getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void windowsTest() {
        driver.get(url);
        //get window handle of current window
        String mainWindowHandle = driver.getWindowHandle();
        System.out.println("windowHandle = " + mainWindowHandle);

        //click on new window link
        WebElement newWindowLink = driver.findElement(By.linkText("Click Here"));
        newWindowLink.click();

        Set<String> windowsHandles = driver.getWindowHandles();
        System.out.println("Count of windows = " + windowsHandles.size());
        //print all window handles
        System.out.println("windowsHandles = " + windowsHandles);

        //loop and switch to a different window
        for(String windowHandle : windowsHandles) {
            driver.switchTo().window(windowHandle);
            System.out.println("Current window title = " + driver.getTitle());
        }

        WebElement h3Elem = driver.findElement(By.xpath("//h3"));
        System.out.println("h3 header text on new page = " + h3Elem.getText());

        //go back to parent window/main window
        driver.switchTo().window(mainWindowHandle);
        System.out.println("Title after switching back to main window = " + driver.getTitle());

    }

    @Test
    public void demoQAMultipleWindows() {
        driver.get(demoQaUrl);

    }

}








