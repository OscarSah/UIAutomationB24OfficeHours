package com.cybertek.tests.day05_xpath_css_isdisplayed;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WorldPopulationXpathTest {
    public static void main(String[] args) throws InterruptedException {
        String appUrl = "https://www.worldometers.info/world-population";
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get(appUrl);

        Thread.sleep(4000);
        //<div class="maincounter-number">
        WebElement worldPopulation = driver.findElement(By.xpath("//div[@class='maincounter-number']"));
        System.out.println(worldPopulation.getText());

    }
}
