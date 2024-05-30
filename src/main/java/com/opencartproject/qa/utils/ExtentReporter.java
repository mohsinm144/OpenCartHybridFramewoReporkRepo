package com.opencartproject.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {

	public static ExtentReports generateExtentReport(){
		
		ExtentReports extentReport = new ExtentReports();
		
		File extentReportFile = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(extentReportFile);
		
		sparkReport.config().setTheme(Theme.DARK);
		sparkReport.config().setReportName("OpenCart Automation Test Result");
		sparkReport.config().setDocumentTitle("Automation Test Result");
		sparkReport.config().setTimeStampFormat("dd/mm/yyyy hh:mm:ss");
		
		extentReport.attachReporter(sparkReport);
		
		Properties configProp = new Properties();
		File ConfigPropFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\opencart\\qa\\config\\config.properties");
		try{
			FileInputStream fisConfigProp = new FileInputStream(ConfigPropFile);
			configProp.load(fisConfigProp);
		}catch(Exception e) {
			e.printStackTrace();
		}
		extentReport.setSystemInfo("Application URL", configProp.getProperty("url"));
		extentReport.setSystemInfo("Browser Name", configProp.getProperty("browserName"));
		extentReport.setSystemInfo("Email", configProp.getProperty("validEmail"));
		extentReport.setSystemInfo("User Name", System.getProperty("user.name"));
		extentReport.setSystemInfo("OS Name", System.getProperty("os.name"));
		extentReport.setSystemInfo("Java Version", System.getProperty("java.version"));
		
		return extentReport;
	}
		
	
	
}
