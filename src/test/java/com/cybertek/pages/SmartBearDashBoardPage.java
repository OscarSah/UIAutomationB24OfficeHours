package com.cybertek.pages;

import com.cybertek.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class SmartBearDashBoardPage {
    // constructor
    public SmartBearDashBoardPage(){
        PageFactory.initElements(Driver.getDriver(),this);
   }

   public void getLink(String link){
        Driver.getDriver().findElement(By.partialLinkText(link)).click();
   }

}
