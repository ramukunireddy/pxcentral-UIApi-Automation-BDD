package com.test.step.definitions;


import java.net.MalformedURLException;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.selenium.configure.environment.CreateDriver;
import com.selenium.configure.environment.WebDriverFactory;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;


public class Hooks {
	public static WebDriver driver;
	public static String type;
	public static String browser;
	public static String os;
	public static String logLevel;

	
	Logger log = Logger.getLogger(Hooks.class);
	Scenario scenario=null;	
	private static final String properties = "test.properties";
    private static final Properties prop = new Properties();
    private static final InputStream in = WebDriverFactory.class.getResourceAsStream("/test.properties");
	@Before
	public void Before(Scenario scenario)
	{
		this.scenario=scenario;
	}

	@Before
	public void initConfiguration() throws MalformedURLException{
		try{
		log.info("***********************************************************************************************************");
    	log.info("[ POM Configuration ] - Read the basic properties configuration from: " + properties);
        prop.load(in);
        }
		catch (IOException e){
			log.error("initConfig Error", e);
			}
		type=prop.getProperty("type");
		if(type.equalsIgnoreCase("UI")){
			log.info("***********************************************************************************************************");
			log.info("[ Configuration ] - Initializing driver configuration");
			log.info("***********************************************************************************************************");
			browser = prop.getProperty("browser");
            os = prop.getProperty("os");
            logLevel = prop.getProperty("logLevel");
            driver = CreateDriver.initConfig(os,browser,logLevel);
            log.info("***********************************************************************************************************");
			log.info("[ Scenario ] - "+scenario.getName());
			log.info("***********************************************************************************************************");
		}else{
			
		}
		
	}
	
	@After
 	/**
     * Embed a screenshot in test report if test is marked as failed
     */
    public void embedScreenshot(Scenario scenario) {
       
        if(scenario.isFailed()) {
	        try {
	        	scenario.write("The scenario failed.");
	        	scenario.write("Current Page URL is " + driver.getCurrentUrl());
	            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	            scenario.embed(screenshot, "resources/screenshot");
	        } catch (WebDriverException somePlatformsDontSupportScreenshots) {
	            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
	        }	        
        }
        
		log.info("***********************************************************************************************************");
		log.info("[ Driver Status ] - Clean and close the intance of the driver");
		log.info("***********************************************************************************************************");
        driver.quit();
        
    }
	
}
