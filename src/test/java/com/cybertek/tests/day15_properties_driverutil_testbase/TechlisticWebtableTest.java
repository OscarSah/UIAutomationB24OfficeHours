package com.cybertek.tests.day15_properties_driverutil_testbase;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TechlisticWebtableTest extends TestBase {
    /**
        Goto https://www.techlistic.com/p/demo-selenium-practice.html
        Assert current url contains "techlistic"
        Print all Building names
     */

    @Test
    public void tallBuildingsTableTest() {

        driver.get(ConfigurationReader.getProperty("techlistic.url"));

        Assert.assertTrue(driver.getCurrentUrl().contains("techlistic"));

        List<WebElement> buildings = driver.findElements(By.xpath("//table[@class='tsc_table_s13']/tbody/tr/th"));
        for (WebElement building : buildings) {
            System.out.println("Building name = " + building.getText());
        }

        // //table[@class='tsc_table_s13']//td[contains(text(),'buildings')]
        // //table[@class='tsc_table_s13']/tfoot/tr/td

    }

}
