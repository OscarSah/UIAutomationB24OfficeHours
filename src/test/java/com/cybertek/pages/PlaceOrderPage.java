package com.cybertek.pages;

import com.cybertek.utils.Driver;
import com.github.javafaker.Faker;
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

    @FindBy(xpath = "//button[.='Purchase']")
    public WebElement purchaseButton;

    @FindBy(xpath = "//p[@class='lead text-muted ']")
    public WebElement confirmationText;

    @FindBy(xpath = "//button[.='OK']")
    public WebElement OK;

    public void fillForm(Faker faker){

        nameBox.sendKeys(faker.name().fullName());
        countryBox.sendKeys(faker.country().name());
        cityBox.sendKeys(faker.address().city());
        cardBox.sendKeys(faker.finance().creditCard());
        monthBox.sendKeys(""+faker.number().numberBetween(1,12));
        yearBox.sendKeys(""+faker.number().numberBetween(2022,2026));


    }





}
