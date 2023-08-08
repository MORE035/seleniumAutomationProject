package org.exercise.extent.reports;

import java.awt.Desktop;
import java.io.File;
import java.lang.reflect.Method;

import org.sap.constants.FrameworkConstants;
import org.testng.IMethodInstance;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportDemo {
	@Test
	public void test1() throws Exception {
		ExtentReports report=new ExtentReports();
		ExtentSparkReporter spark=new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
		report.attachReporter(spark);
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("Vasanth");
		spark.config().setDocumentTitle("Automation Test");
		ExtentTest test = report.createTest("Test 1 test case 1");
		test.pass("checking logs");
		ExtentTest test1 = report.createTest("Test 1  test case 2");
		test1.fail("checking logs");
		report.flush();
		Desktop.getDesktop().browse(new File("index.html").toURI());//Open the file on the desktop default browser
	}

}
