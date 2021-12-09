package com.cybertek.tests.day16_download_uploaded_js_executor;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FileUploadTest extends TestBase {
    @Test
    public void uploadFileTest() {
        driver.get(ConfigurationReader.getProperty("upload.url"));

        WebElement upload = driver.findElement(By.id("file-upload"));
        upload.sendKeys(System.getProperty("user.home") + "/Downloads/some-file.txt");

        WebElement uploadBtn = driver.findElement(By.id("file-submit"));
        uploadBtn.click();

        /**
         verify file is uploaded. check filename is displayed on page
         */
    }
}
