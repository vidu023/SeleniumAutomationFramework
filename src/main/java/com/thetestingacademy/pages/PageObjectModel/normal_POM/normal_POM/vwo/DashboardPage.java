package com.thetestingacademy.pages.PageObjectModel.normal_POM.normal_POM.vwo;

import com.thetestingacademy.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

    WebDriver driver;

    //getter
    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    private By userNameOnDashboard = By.cssSelector("[data-qa=\"lufexuloga\"]");
    // Page Actions
    public String loggedInUserName(){
        WaitHelpers.waitJVM(10000);
        driver.get("https://app.vwo.com/#/dashboard"); // this will locate dashboard page &  open it
        return driver.findElement(userNameOnDashboard).getText();
    }

}
