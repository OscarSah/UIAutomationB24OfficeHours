package com.cybertek.pages;

import com.cybertek.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllOrdersPage extends SmartBearDashBoardPage {

    // Do I have to put constructor?  NO
    // constructor is not inherited however, child class has to call Parent class constructor

    @FindBy(id = "ctl00_MainContent_btnDelete")
    public WebElement deleteSelected;

    // I want to go to other links in the AllOrder Page, do I have to create a getLink method?
    // NO, I already have getLink method at the parent

    // create a method that selects the checkbox with using Name of the person

    // //td[.='Mark Smith']/..//input[@type='checkbox']
    // String name = "Mark Smith"
    // "//td[.='"+name+"']/..//input[@type='checkbox']"

    public void selectCheckBox(String name){
        Driver.getDriver().findElement(By.xpath("//td[.='"+ name +"']/..//input[@type='checkbox']")).click();
    }

}
