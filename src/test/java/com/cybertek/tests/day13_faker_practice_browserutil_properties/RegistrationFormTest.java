package com.cybertek.tests.day13_faker_practice_browserutil_properties;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static com.cybertek.utils.WebDriverFactory.getDriver;

public class RegistrationFormTest extends RegistrationFormTestBase {

    Faker faker = new Faker();

    @Test
    public void formTest() {
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
        mobile.sendKeys(faker.phoneNumber().cellPhone());

        WebElement maleRadio = driver.findElement(By.xpath("//*[@value='male']"));
        maleRadio.click();

    }

    public void enterUserName(String userName) {
        WebElement userNameField = driver.findElement(By.name("username"));
        userNameField.sendKeys(userName);
    }

}
