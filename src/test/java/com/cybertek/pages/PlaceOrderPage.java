package com.cybertek.pages;

import com.cybertek.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlaceOrderPage {

        // constructor

    public PlaceOrderPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[.='Place Order']")
    public WebElement placeOrderButton;

    @FindBy(id = "name")
    public WebElement nameBox;

    @FindBy(id = "country")
    public WebElement countryBox;

    @FindBy(id = "city")
    public WebElement cityBox;

    @FindBy (id = "card")
    public WebElement cardBox;

    @FindBy (id = "month")
    public WebElement monthBox;

    @FindBy(id = "year")
    public WebElement yearBox;








}
