package com.thetestingacademy.base;

import com.thetestingacademy.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.thetestingacademy.driver.DriverManager.getDriver;

public class CommonToAllPage {

    public CommonToAllPage() {
        // If you want to call something before every Page Object Class call, Put your Code here");
        // Open File, Open Data Base Connection You can write code here
    }

    //opening VWO url
    public void openVWOUrl(){
        getDriver().get(PropertiesReader.readKey("url"));
    }
    public void openOrangeHRMUrl(){
        getDriver().get(PropertiesReader.readKey("ohr_url"));
    }

    public void openKatalonUrl(){
        getDriver().get(PropertiesReader.readKey("katalon_url"));
    }



    //clicking
    public void clickElement(By by) {
        getDriver().findElement(by).click();
    }

    public void clickElement(WebElement by) {
        by.click();
    }

    // sending keys
    public void enterInput(By by, String key) {
        getDriver().findElement(by).sendKeys(key);
    }

    public void enterInput(WebElement by, String key) {
        by.sendKeys(key);
    }

    //opening
    public String getText(By by){
        return getDriver().findElement(by).getText();
    }

    public String getText(WebElement by){
        return by.getText();
    }

}
