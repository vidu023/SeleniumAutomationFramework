package com.thetestingacademy.pages.PageObjectModel.normal_POM.normal_POM.vwo;

import com.thetestingacademy.utils.PropertiesReader;
import com.thetestingacademy.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Page Class
public class LoginPage {

    // we want the driver
    static WebDriver driver;

    // generate constructor
    // whenever we want load the page we need to make sure driver is available
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // we shall be writing Page locators & page actions
    // page locators -> figure out which elements we want to interact with

    // Step 1- Page Locators

    // private -> encapsulation we want to access within the class
    // By is a simple class to find the locators
    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signButton = By.id("js-login-btn");
    private By error_message = By.id("js-notification-box-msg");

    // If you are not using it , don't keep.
    //private By signBySSO = By.xpath("//button[normalize-space()='Sign in using SSO']");

     // Step 2 - Page Actions

    // Invalid credentials
    public String loginToVWOLoginInvalidCreds(String user, String pwd) {

        driver.get(PropertiesReader.readKey("url"));
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signButton).click();

        // Wait - Thread sleep
        //WaitHelpers.waitJVM(5000);

        WaitHelpers.checkVisibility(driver, error_message, 3);

        String error_message_text = driver.findElement(error_message).getText();
        return error_message_text;
    }

     // valid credentials
    public void loginToVWOLoginValidCreds(String user, String pwd) {

        driver.get(PropertiesReader.readKey("url"));
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signButton).click();

        // Wait - Thread sleep
        WaitHelpers.waitJVM(5000);

    }

}
