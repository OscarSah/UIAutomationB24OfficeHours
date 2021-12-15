package com.cybertek.officeHours.oH05;

import com.cybertek.pages.PlaceOrderPage;
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

        officeUtils.getLink("Cart").click();

        expectedPrice -= officeUtils.removeProduct("Iphone 6 32gb");

        System.out.println("expectedPrice = " + expectedPrice);

        // we are calling our form filling method
        PlaceOrderPage placeOrderPage = new PlaceOrderPage();
        placeOrderPage.placeOrderButton.click();
        placeOrderPage.fillForm(faker);
        placeOrderPage.purchaseButton.click();

    }



}
