package com.selenium.configure.environment;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
	static String resourceFolder="src/test/resources/files/software/";
    /******** Log Attribute ********/
    private static final Logger log = Logger.getLogger(WebDriverFactory.class);
    
	private static WebDriverFactory instance = null;
	    
    private WebDriverFactory() {    
    }
    
    /**
     * Singleton pattern
     * @return a single instance
     */
    public static WebDriverFactory getInstance() {
        if (instance == null) {
            instance = new WebDriverFactory();
        }
        return instance;
    }
    
    public static WebDriver createNewWebDriver(String os, String browser){
    	WebDriver driver = null;
    	 /******** The driver selected is Local: Firefox  ********/    	
		 if ("FIREFOX".equalsIgnoreCase(browser)) {
			 if("MAC".equalsIgnoreCase(os)){
				 System.setProperty("webdriver.gecko.driver", resourceFolder+os+"/geckodriver");
			 }
			 else{
				 System.setProperty("webdriver.gecko.driver", resourceFolder+os+"/geckodriver.exe");
			 }
		     driver = new FirefoxDriver();	
		 }
					        
		 /******** The driver selected is Chrome  ********/
					   
	     else if ("CHROME".equalsIgnoreCase(browser)) {
	    	 if("MAC".equalsIgnoreCase(os)){
	    		 System.setProperty("webdriver.chrome.driver", resourceFolder+os+"/chromedriver");
	    	 }
	    	 else{
	    		 System.setProperty("webdriver.chrome.driver", resourceFolder+os+"/chromedriver.exe");
	    	 }
	         driver = new ChromeDriver();
	     }  
		 /******** The driver is not selected  ********/
	     else {
	    	 log.error("The Driver is not selected properly, invalid name: " + browser + ", " + os);
	     }
		 return driver;
    }
}
