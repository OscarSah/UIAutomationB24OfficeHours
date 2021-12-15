package com.cybertek.utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class officeUtils {

    static Alert alert;  // declare a static alert object

// create a static method, will accept String, will return WebElement, getLink(String str)

    public static WebElement getLink(String str){
        return Driver.getDriver().findElement(By.partialLinkText(str));
    }

// addProduct(String category, String product), return an integer value which is product price
// also add the product to my Cart

    public static int addProduct(String category,String product){

        getLink(category).click();
        getLink(product).click();

        // getting the product's price
        WebElement priceContainer = Driver.getDriver().findElement(By.xpath("//h3"));
        int productsPrice=Integer.parseInt(priceContainer.getText().substring(1,4));

        // click on Add to cart
        getLink("Add to cart").click();
        BrowserUtils.sleep(2);
        alert = Driver.getDriver().switchTo().alert(); // initialize the object
        alert.accept();
        getLink("Home").click();
        return productsPrice;
    }

public static int removeProduct(String product){
    int productPrice = 0;
        // remove the product and return its price as well
// Delete Button way one: //tbody//tr//td[contains(text(),'Sony vaio i7')]/..//td[.='Delete']/a
// Delete Button way two: //tbody//tr//td[contains(text(),'Sony vaio i7')]/following-sibling::*/a
    return productPrice;
}

}
