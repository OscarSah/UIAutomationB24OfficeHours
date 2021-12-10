package com.cybertek.tests.day17_upload_js_executor;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JavaScriptExecutorTest extends TestBase {
    @Test
    public void alertExampleTest() {
        //down casting from WebDriver to JavaScriptExecutor interface
        JavascriptExecutor js = (JavascriptExecutor)driver;
        //running javascript alert command
        js.executeScript( "alert('hello hello!')" );

        BrowserUtils.sleep(2);

        Alert alert = driver.switchTo().alert();
        System.out.println("Alert text = " + alert.getText());
        alert.accept();
    }

    @Test
    public void scrollTest() {
        driver.get(ConfigurationReader.getProperty("scroll.url"));
        BrowserUtils.sleep(2);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 5000)");

        for (int i = 0; i < 10; i++) {
            BrowserUtils.sleep(1);
            js.executeScript("window.scrollBy(0, 1000)");
        }

    }

    @Test
    public void scrollToElementTest() {
        driver.get(ConfigurationReader.getProperty("tesla.url"));
        //locate model y element
        WebElement modelYLabel = driver.findElement(By.xpath("(//h1[.='Model Y'])[1]"));

        JavascriptExecutor js = (JavascriptExecutor)driver;

        js.executeScript("arguments[0].scrollIntoView(true)" , modelYLabel );

        BrowserUtils.sleep(2);

        WebElement contactLink = driver.findElement(By.xpath("//a[@href='/contact']"));
        js.executeScript("arguments[0].scrollIntoView(true)" , contactLink );

        WebElement shopNow = driver.findElement(By.xpath("//a[@title='Shop Now']"));
        js.executeScript("arguments[0].scrollIntoView(true)" , shopNow);

        //js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

    }

}
