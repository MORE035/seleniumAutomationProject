package org.sap.tests;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.sap.driver.Driver;
import org.sap.reports.ExtentReporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.sap.utils.JsonUtils;

public class BaseTest {
	protected BaseTest() {
		
	}
	
	@BeforeMethod
	protected void setUp(Method m) throws Exception {
		Driver.initDriver();


	}

	@AfterMethod
	protected void tearDown() {
		Driver.quitDriver();
	}



}
