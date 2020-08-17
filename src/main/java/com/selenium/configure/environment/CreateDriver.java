package com.selenium.configure.environment;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class CreateDriver {
    private static final CreateDriver instance = null;
    
    /******** Log Attribute ********/
    private static final Logger log = Logger.getLogger(CreateDriver.class);
    
    /******** Initialize Driver Configuration when the class is instanced ********/
    private CreateDriver() {
    	//CreateDriver.initConfig(String os,String browser, String logLevel);
    }
    
    public static WebDriver initConfig(String os,String browser, String logLevel){    	 
    	WebDriver driver; 
    	log.info("[ POM Configuration ] - OS: " + os + " | Browser: " + browser + "|");
        log.info("[ POM Configuration ] - Logger Level: " + logLevel);
        log.info("***********************************************************************************************************");
        
        /****** Load the driver *******/
        driver = WebDriverFactory.createNewWebDriver(os, browser);
        
        /******** Clean Cookies, maxinize and declare Timeout on the Driver *******/
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        
        return driver;
    	}
}
