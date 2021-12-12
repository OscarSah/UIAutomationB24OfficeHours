package com.cybertek.pages;

import com.cybertek.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LibraryLoginPage {

    public LibraryLoginPage() {
        //Selenium command to initialize the elements below
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id="inputEmail")
    public WebElement email; //WebElement email = driver.findElement(By.id("inputEmail"))

    @FindBy(id="inputPassword")
    public WebElement password;

    @FindBy(xpath="//button[.='Sign in']")
    public WebElement signInBtn;


}
