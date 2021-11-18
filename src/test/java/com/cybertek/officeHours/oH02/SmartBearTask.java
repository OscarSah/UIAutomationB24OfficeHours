package com.cybertek.officeHours.oH02;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class SmartBearTask {
/*
Test Case 1:
Basic login authentication
- Go to:  http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
- Verify title equals: String expectedTitle = "Web Orders Login"
- Enter username: Tester
- Enter password: test
- Click “Sign In” button
- Verify title equals: String expectedHomePageTitle = "Web Orders"

Test Case 2:
After login
 - click on Check All button
 - verify that all check buttons are selected
 - click on Uncheck All button
 - verify that all buttons are unchecked
 - select one of the check box and delete that row
 - verify that row of information is deleted
Hope to see you all and hope to have a productive time together.
 */

    @Test
    public void loginTest(){

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        // open the page
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        // page Title before login
        String expectedTitle = "Web Orders Login";
        String actualTitle = driver.getTitle();
        System.out.println(expectedTitle.equalsIgnoreCase(actualTitle));
        // username box info
        WebElement username = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        username.sendKeys("Tester");
        // password box
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test"+ Keys.ENTER);

        // check the title after login

        String expectedTitleAfterLogin = "Web Orders";
        String actualTitleAfterLogin = driver.getTitle();
        System.out.println("expectedTitleAfterLogin = " + expectedTitleAfterLogin);
        System.out.println("actualTitleAfterLogin = " + actualTitleAfterLogin);
        System.out.println(expectedTitleAfterLogin.equalsIgnoreCase(actualTitleAfterLogin));

        driver.close();
    }

    @Test
    public void checkBoxTest() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        // open the page
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        // username box info
        WebElement username = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        username.sendKeys("Tester");
        // password box
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test"+ Keys.ENTER);

        // click on Check All button
        WebElement checkAllButton = driver.findElement(By.id("ctl00_MainContent_btnCheckAll"));
        checkAllButton.click();

        // locating all the checkboxes
        List<WebElement> allCheckBoxes = driver.findElements(By.cssSelector("input[type='checkbox']"));

        for (WebElement eachCheckBox : allCheckBoxes) {
            if (eachCheckBox.isSelected()==false){
                System.out.println("Not All selected");  // in TestNG we will learn assertions for these situations
                break;
            }
        }

        WebElement uncheckAllButton = driver.findElement(By.id("ctl00_MainContent_btnUncheckAll"));
        uncheckAllButton.click();

        allCheckBoxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        for (WebElement eachCheckBox : allCheckBoxes) {
            if(eachCheckBox.isSelected()==true){
                System.out.println("Not All check boxes unselected");
                break;
            }
        }

        allCheckBoxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        System.out.println("Before I delete : " + allCheckBoxes.size());
        WebElement itemForDeleting = driver.findElement(By.xpath("//tr//td[.='Paul Brown']/../td[1]/input"));
        itemForDeleting.click();

        Thread.sleep(3000);


        WebElement deleteButton = driver.findElement(By.id("ctl00_MainContent_btnDelete"));
        deleteButton.click();

        allCheckBoxes = driver.findElements(By.cssSelector("input[type='checkbox']"));

        System.out.println("After I delete : "+ allCheckBoxes.size());







        driver.close();
    }

}
