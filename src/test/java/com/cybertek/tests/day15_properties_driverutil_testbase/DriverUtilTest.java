package com.cybertek.tests.day15_properties_driverutil_testbase;

import com.cybertek.utils.Driver;
import org.testng.annotations.Test;

public class DriverUtilTest {
    @Test
    public void driverClassTest() {
        Driver.getDriver().get("https://www.google.com");
        System.out.println(Driver.getDriver().getTitle());

        Driver.getDriver().get("https://www.amazon.com");
        Driver.getDriver().get("https://www.etsy.com");
        Driver.getDriver().get("https://www.facebook.com");
        Driver.getDriver().get("https://www.youtube.com");
    }
}
