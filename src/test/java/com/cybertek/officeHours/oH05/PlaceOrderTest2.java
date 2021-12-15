package com.cybertek.officeHours.oH05;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import com.cybertek.utils.Driver;
import com.cybertek.utils.officeUtils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class PlaceOrderTest2 extends TestBase {


    int expectedPrice = 0;
    @Test
    public void placeOrder(){
        // gets me URL of the page
        driver.get(ConfigurationReader.getProperty("demoblazeUrl"));
        // adding Laptops Sony vaio i7
        expectedPrice += officeUtils.addProduct("Laptops","Sony vaio i7");

        // adding Iphone
        expectedPrice +=officeUtils.addProduct("Phones","Iphone 6 32gb");
        // adding Monitor
        expectedPrice += officeUtils.addProduct("Monitors","Apple monitor 24");

        System.out.println(expectedPrice);

        officeUtils.getLink("Cart").click();

        expectedPrice -= officeUtils.removeProduct("Iphone 6 32gb");


        BrowserUtils.sleep(1);



    }



}
