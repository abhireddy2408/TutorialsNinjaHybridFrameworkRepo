package com.tutorialsninja.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tutorialsninja.qa.utils.Utilities;

public class Base {
	
	WebDriver driver;
	public Properties prop;
	public Properties testProp;
	
	// Using constructor 
	public Base() {
		
		//Properties object for config properties file
		prop = new Properties();// make sure you remove duplicate type i.e. Properties prop;
		File propFile = new File(System.getProperty("user.dir")+"/src/main/java/com/tutorialsninja/qa/config/config.properties");
		
		try {
			
			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);
			
		}catch(Throwable e) {
			
			e.printStackTrace();
			
		}	
		
		// Properties object for test data properties file
		testProp = new Properties();
		File testPropFile = new File(System.getProperty("user.dir") + "/src/main/java/com/tutorialsninja/qa/testdata/testdata.properties");
		
		try {
			
			FileInputStream fis2 = new FileInputStream(testPropFile);
		    testProp.load(fis2);
	    
		}catch(Throwable e) {
			
			e.printStackTrace();
		}
	
		
	}
	
	// Using method 
//	public Properties configProperties() {
//		
//		Properties prop = new Properties();
//		File propFile = new File(System.getProperty("user.dir")+"/src/main/java/com/tutorialsninja/qa/config/config.properties");
//		
//		try {
//			
//			FileInputStream fis = new FileInputStream(propFile);
//			prop.load(fis);
//			
//		}catch(Throwable e) {
//			
//			e.printStackTrace();
//			
//		}	
//		
//		return prop;
//	}
	
	public WebDriver initializeBrowserAndOpenApplication(String browserName) {
		
		if(browserName.equalsIgnoreCase("chrome")) {
			
			driver = new ChromeDriver();
			
		}else if (browserName.equalsIgnoreCase("edge")) {
			
			driver = new EdgeDriver();
			
		}else if (browserName.equalsIgnoreCase("firefox")) {
			
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));//WebDriver will wait when trying to locate an element on the page before throwing a NoSuchElementException.
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));//maximum amount of time that the WebDriver will wait for a page to load completely before throwing a TimeoutException.
		driver.get(prop.getProperty("url"));
		
		return driver;
	}

}
