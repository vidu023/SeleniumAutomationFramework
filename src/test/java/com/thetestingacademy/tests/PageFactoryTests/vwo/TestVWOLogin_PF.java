package com.thetestingacademy.tests.PageFactoryTests.vwo;

import com.thetestingacademy.base.CommonToAllTest;
import com.thetestingacademy.pages.PageFactory.vwo.LoginPage_PF;
import com.thetestingacademy.utils.PropertiesReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;


import static com.thetestingacademy.driver.DriverManager.driver;

public class TestVWOLogin_PF extends CommonToAllTest {


    // before starting any testcase we need to start our logger
    private static final Logger logger = LogManager.getLogger(TestVWOLogin_PF.class);

    @Test
    public void testLoginNegativeVWO_PF() {
        logger.info("Starting the Testcases Page Factory");
        LoginPage_PF loginPage_PF = new LoginPage_PF(driver);
        String error_msg = loginPage_PF.loginToVWOInvalidCreds();
        logger.info("Error msg I got "+ error_msg);
        logger.info("Finished the Testcases Page Factory");
        logger.debug("Finished the Testcases Page Factory");
        logger.error("Finished the Testcases Page Factory");
        logger.fatal("Fatal error - code is dead!");
        Assert.assertEquals(error_msg, PropertiesReader.readKey("error_message"));
    }
}
