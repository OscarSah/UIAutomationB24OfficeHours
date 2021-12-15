package com.cybertek.pages;

import com.cybertek.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BookManagementPage {
    public BookManagementPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath="//h3[.='Book Management']")
    public WebElement bookMangtHeader;

    //method to verify if we are on correct page
    public void isCurrentPage() {
        Assert.assertEquals(Driver.getDriver().getTitle(),"Library");
    }

}
