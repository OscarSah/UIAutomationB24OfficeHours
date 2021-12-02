package com.cybertek.officeHours.oH03;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class priceTestTwo {

    static WebDriver driver;
    String url = "https://www.demoblaze.com/index.html#";
    int expectedTotalPrice = 0;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.get(url);
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    // useful method to use
    public static void getLink(String str){                  // we can not call instance variable from static
        driver.findElement(By.partialLinkText(str)).click(); // we made the webdriver static
    }


/*
- From Categories select Laptops, and from products select Sony Vaio i7
 - click Add to Cart then handle pop up
 - Navigate to Home
  - From Categories select Phones, and from products select Iphone 6 32gb
 - click Add to Cart then handle pop up
 - Navigate to Cart
- Then Verify that total cart price is equal to expected (total of added 2 items) price
 */
    @Test
    public void testTwo() throws InterruptedException {
//From Categories select Laptops, and from products select Sony Vaio i7

        getLink("Laptops");
        getLink("Sony vaio i7");
        Thread.sleep(2000);
        WebElement priceContainer = driver.findElement(By.xpath("//h3"));
        // I need a variable that will hold all the prices that I am adding

        expectedTotalPrice += Integer.parseInt(priceContainer.getText().substring(1,4));

        System.out.println("expectedTotalPrice = " + expectedTotalPrice);

        getLink("Add to cart");
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        alert.accept();

        getLink("Home");

        getLink("Phones");
        getLink("Iphone 6 32gb");
        Thread.sleep(2000);
        priceContainer = driver.findElement(By.xpath("//h3"));
        // I need a variable that will hold all the prices that I am adding

        expectedTotalPrice += Integer.parseInt(priceContainer.getText().substring(1,4));

        System.out.println("expectedTotalPrice = " + expectedTotalPrice);

        getLink("Add to cart");

        Thread.sleep(1000);
        alert.accept();

    }

}
