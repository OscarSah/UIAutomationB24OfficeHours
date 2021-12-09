package com.cybertek.tests.day16_download_uploaded_js_executor;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FileDownloadTest extends TestBase {
    @Test
    public void fileDownloadTest() {
        driver.get(ConfigurationReader.getProperty("download.url"));
        WebElement someFileDownload = driver.findElement(By.linkText("some-file.txt"));
        someFileDownload.click();
    }
}
