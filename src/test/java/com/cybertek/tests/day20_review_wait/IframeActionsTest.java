package com.cybertek.tests.day20_review_wait;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import org.testng.annotations.Test;

public class IframeActionsTest extends TestBase {

    @Test
    public void test(){

        driver.get(ConfigurationReader.getProperty("doubleclick.url"));

        // let's switch to iframe

        driver.switchTo().frame("iframeResult");




    }

}
