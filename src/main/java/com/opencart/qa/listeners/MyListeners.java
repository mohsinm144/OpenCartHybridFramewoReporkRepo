package com.opencart.qa.listeners;


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
import com.opencartproject.qa.utils.ExtentReporter;
import com.opencartproject.qa.utils.Utilities;

public class MyListeners implements ITestListener{

	ExtentReports extentReport;
	ExtentTest extentTest;
	String testName;
	
	@Override
	public void onStart(ITestContext context) {
		extentReport = ExtentReporter.generateExtentReport();
		//System.out.println("Execution of Project Test Started");
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		testName = result.getName();
		extentTest = extentReport.createTest(testName);
		extentTest.log(Status.INFO, testName + "Started Execution");
		//System.out.println(testName + "Started Execution");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//testName = result.getName();
		extentTest.log(Status.PASS, testName + "get successfully executed");
		//System.out.println(testName + "get successfully executed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//String testName = result.getName();
		System.out.println("Screenshot taken");
		
		WebDriver driver = null;
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		/*
		File SrcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationScreenshotPath = System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png";
		try {
			FileHandler.copy(SrcScreenshot, new File(destinationScreenshotPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		
		String destinationScreenshotPath = Utilities.captureScreenshot(driver, testName);
		extentTest.addScreenCaptureFromPath(destinationScreenshotPath);
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL, testName + "got failed");
		//System.out.println(testName + "got failed");
		//System.out.println(result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		//String testName = result.getName();
		extentTest.log(Status.INFO,result.getThrowable());
		extentTest.log(Status.SKIP,testName + "got skipped");
		//System.out.println(testName + "got skipped");
		//System.out.println(result.getThrowable());
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();
		//System.out.println("Finished executing project Test");
		
		String pathOfExtentReport = System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html";
		File extentReport = new File(pathOfExtentReport);
				
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	


}
