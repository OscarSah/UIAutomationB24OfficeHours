package com.cybertek.officeHours.oH05;

import com.cybertek.pages.PlaceOrderPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import com.cybertek.utils.Driver;
import com.cybertek.utils.officeUtils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

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
        BrowserUtils.sleep(1);
        placeOrderPage.purchaseButton.click();


        System.out.println("placeOrderPage.confirmationText.getText() = " + placeOrderPage.confirmationText.getText());

        //     split method with regex "\n"  you need two splits

        String [] arr = placeOrderPage.confirmationText.getText().split("\n");

        // Click OK button after we get the text
        BrowserUtils.sleep(2);
        placeOrderPage.OK.click();

        Map<String,Object> dataMap = new HashMap<>(); // if the order of the keys not important for me
        // arr[0].split(":")[0] = Id ---> Key for my Map  arr[0].split(":")[1]=1575159 ----> Value for my map
        // arr[0] : String value

        for (String s : arr) {
            dataMap.put(s.split(":")[0].trim(),s.split(":")[1].trim());
        }

        System.out.println("dataMap = " + dataMap); // dataMap = {Id=5551210}
    }










//1. Go to https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
//2. Switch to iframe.
//3. Double click on the text “Double-click me to change my text color.”
//4. Assert: Text’s “style” attribute value contains “red”.
}
