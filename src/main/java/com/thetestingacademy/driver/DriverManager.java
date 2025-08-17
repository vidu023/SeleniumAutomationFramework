package com.thetestingacademy.driver;

import com.thetestingacademy.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverManager {

    // generate getter setter
    // we are using drivers because if in future any one wants driver then it can be through getDriver()
    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driver = driver;
    }

    // static because it shall be used multiple times in our testcases
    public static WebDriver driver;

    // When we want to start the browser
    // we use init() to initialise
    // we need to know which browser we want using switch loop
    public static void init(){
        String browser = PropertiesReader.readKey("browser");
        browser = browser.toLowerCase();

        switch (browser){
            case "edge" :
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--start-maximized");
                edgeOptions.addArguments("--guest");
                driver = new EdgeDriver(edgeOptions);
                break;
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--start-maximized");
                driver = new FirefoxDriver(firefoxOptions);
                break;
            default:
                System.out.println("Not browser Supported!!!");
        }

    }

    // When we want to close the browser
    public static void down(){
        if (getDriver() != null) {
            driver.quit();
            driver = null;
        }

    }

}
