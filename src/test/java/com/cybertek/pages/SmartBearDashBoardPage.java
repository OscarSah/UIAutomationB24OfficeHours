package com.cybertek.pages;

import com.cybertek.utils.Driver;
import org.openqa.selenium.support.PageFactory;

public class SmartBearDashBoardPage {
    // constructor
    public SmartBearDashBoardPage(){
        PageFactory.initElements(Driver.getDriver(),this);
   }


}
