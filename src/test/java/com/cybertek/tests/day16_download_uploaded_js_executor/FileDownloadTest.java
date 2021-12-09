package com.cybertek.tests.day16_download_uploaded_js_executor;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class FileDownloadTest extends TestBase {
    @Test
    public void fileDownloadTest() {
        //Navigate to download page. Reading url from properties file
        driver.get(ConfigurationReader.getProperty("download.url"));
        //locate and click on some-file.txt to download
        WebElement someFileDownload = driver.findElement(By.linkText("some-file.txt"));
        someFileDownload.click();

        BrowserUtils.sleep(2);



        //verify that file is downloaded: /Users/cybertekb24/       Downloads/some-file.txt
        String filePath = System.getProperty("user.home") + "/Downloads/some-file.txt";
        System.out.println("filePath = " + filePath);

        //build file object
        File file = new File( filePath );
        System.out.println("File exist = " + file.exists());

//        while(!file.exists()) {
//            BrowserUtils.sleep(1);
//        }

        Assert.assertTrue(file.exists() , "File download failed");

        //delete after verification complete
        file.delete();

    }
}
