package com.cybertek.tests.day17_upload_js_executor;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.BrowserUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
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

    }

}
