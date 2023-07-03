package com.tutorialsninja.qa.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.tutorialsninja.qa.utils.ExtentReporter;
import com.tutorialsninja.qa.utils.Utilities;

public class MyListeners implements ITestListener {

	ExtentReports extentReport;
	ExtentTest extentTest;
	String testName;
	@Override
	public void onStart(ITestContext context) {
	
		extentReport = ExtentReporter.generateExtentReport();
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		testName = result.getName();
		extentTest = extentReport.createTest(testName);
		extentTest.log(Status.INFO, testName+ " Test started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
//		String testName = result.getName();
		extentTest.log(Status.PASS, testName+ " Test success");

	}

	@Override
	public void onTestFailure(ITestResult result) {
//		String testName = result.getName();
		
		
		//Takes screenshot // very IMP : Webdriver in the test class should be public 
		WebDriver driver = null;
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
//		File srcScreenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		String destinationScreenshotPath = System.getProperty("user.dir")+"/Screenshots/"+ testName +".png";
//		try {
//			FileHandler.copy(srcScreenshotFile, new File(destinationScreenshotPath));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		extentTest.addScreenCaptureFromPath(Utilities.getScreenshot(driver, testName));// add screenshot to extent report
		
		Throwable err = result.getThrowable();
		
		extentTest.log(Status.FAIL, testName+ " Test Failure");
		extentTest.log(Status.INFO, err+ " Test Failure logs");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
//		String testName = result.getName();
		extentTest.log(Status.SKIP, testName+ " Test Skipped");
		
	}

	

	@Override
	public void onFinish(ITestContext context) {
	
		extentReport.flush();// data will be logged onto report.
		String extentReportPath = System.getProperty("user.dir")+"/test-output/ExtentReports/extentReport.html";
		File e = new File(extentReportPath);
		try {
			Desktop.getDesktop().browse(e.toURI());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}// to open extent report automatically
	}
	
}
