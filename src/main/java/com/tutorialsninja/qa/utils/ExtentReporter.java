package com.tutorialsninja.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	
	public static ExtentReports generateExtentReport() {
		
		ExtentReports extentReport = new ExtentReports();//Engine
		File extentReportPath = new File(System.getProperty("user.dir")+"/test-output/ExtentReports/extentReport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportPath);
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("TutorialsNinja Test Automation Results");
		sparkReporter.config().setDocumentTitle("TN Automation Report");
		
		extentReport.attachReporter(sparkReporter);
		
		
		Properties prop = new Properties();
		File propFilePath = new File(System.getProperty("user.dir")+"/src/main/java/com/tutorialsninja/qa/config/config.properties");
		try {
			FileInputStream fis = new FileInputStream(propFilePath);
			prop.load(fis);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
		extentReport.setSystemInfo("Application URL", prop.getProperty("url"));
		extentReport.setSystemInfo("Browser Name", prop.getProperty("browserName"));
		extentReport.setSystemInfo("Email", prop.getProperty("validEmail"));
		extentReport.setSystemInfo("Pass", prop.getProperty("validPass"));
		
		// To gte user anme, OS name, Java version use System.getProperties().list(System.out); Will print all the system properties.
		
		extentReport.setSystemInfo("Operating System", System.getProperty("os.name"));
		extentReport.setSystemInfo("User Name", System.getProperty("user.name"));
		extentReport.setSystemInfo("Java Version", System.getProperty("java.version"));
		
		return extentReport;
	}


}
