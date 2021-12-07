package com.cybertek.tests.day13_faker_practice_browserutil_properties;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.cybertek.utils.WebDriverFactory.getDriver;

public class RegistrationFormTest extends RegistrationFormTestBase {

    Faker faker = new Faker();

    @Test
    public void formTest() throws InterruptedException {
        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys(faker.name().firstName());

        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys(faker.name().lastName());

        enterUserName(faker.name().username().replace(".",""));

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys(faker.internet().emailAddress());

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys(faker.internet().password());

        WebElement mobile = driver.findElement(By.name("phone"));
        mobile.sendKeys(faker.phoneNumber().cellPhone()
                .replace("(" , "")
                .replace(")" , "")
                .replace("." , "-")
                .replace(" " , "-"));

        WebElement maleRadio = driver.findElement(By.xpath("//*[@value='male']"));
        maleRadio.click();

        WebElement birthday = driver.findElement(By.name("birthday"));
        birthday.sendKeys("01/01/1990");

        Select department = new Select(driver.findElement(By.name("department")));
        department.selectByIndex(faker.number().numberBetween(1,9));

        Select jobTitle = new Select(driver.findElement(By.name("job_title")));
        jobTitle.selectByIndex(faker.number().numberBetween(1, 8));

        List<WebElement> languages = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for(WebElement eachLang : languages) {
            eachLang.click();
        }

        WebElement signUp = driver.findElement(By.id("wooden_spoon"));
        signUp.click();

        Thread.sleep(2000);

        //verify "Well done!" message is displayed
        WebElement heading = driver.findElement(By.className("alert-heading"));
        Assert.assertEquals(heading.getText(), "Well done!");
        Assert.assertTrue(heading.isDisplayed());


    }

    public void enterUserName(String userName) {
        WebElement userNameField = driver.findElement(By.name("username"));
        userNameField.sendKeys(userName);
    }

}
