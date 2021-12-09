package com.cybertek.officeHours.oH04;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import com.cybertek.utils.officeUtils;
import org.testng.annotations.Test;

public class placeOrderTest extends TestBase {
    /*
    DemoBlaze WebSite Order Confirmation
 - Go to https://www.demoblaze.com/index.html#
 - From Categories select Laptops, and from products select Sony Vaio i7
 - click Add to Cart then handle pop up
 - Navigate to Home
 - From Categories select Phones, and from products select Iphone 6 32gb
 - click Add to Cart then handle pop up
 - From Categories select Monitors, and from products select Apple Monitor
 - click Add to Cart then handle pop up
 - Navigate to Cart
 - Delete Iphone product from the Cart
 - Then click on Place Order
 - Fill Out the form with Faker Data
 - Then Verify that expected (total of each individual product's price) is equal to actual (both the Cart price and Order amount) price
 - Also capture order confirmation number, and verify customer's information
     */

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






    }

}
