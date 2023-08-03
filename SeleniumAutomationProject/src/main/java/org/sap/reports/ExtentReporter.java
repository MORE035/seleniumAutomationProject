package org.sap.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public final class ExtentReporter {
	private ExtentReporter() {

	}

	private static ExtentReports report;
	public static ExtentTest test;

	public static void initReports() {
		if (Objects.isNull(report)) {
			report = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
			report.attachReporter(spark);
			spark.config().setTheme(Theme.DARK);
			spark.config().setReportName("Vasanth");
			spark.config().setDocumentTitle("Automation Test");
		}
	}

	public static void tearDownReports() throws IOException {
		if (Objects.nonNull(report)) {
			report.flush();
		}
		Desktop.getDesktop().browse(new File("index.html").toURI());// Open the file on the desktop default browser

	}

	public static void createTest(String testName) {
		ExtentManager.setExtentTest(report.createTest(testName));
	}
}
