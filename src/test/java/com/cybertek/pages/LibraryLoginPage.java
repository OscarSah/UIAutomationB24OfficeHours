package com.cybertek.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LibraryLoginPage {

    @FindBy(id="inputEmail")
    public WebElement email;

    public WebElement password;

    public WebElement signInBtn;


}
