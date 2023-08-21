package org.sap.reports;

import java.awt.Desktop;
import java.io.File;
import java.util.Objects;

import org.sap.constants.FrameworkConstants;
import org.sap.enums.AuthorNames;
import org.sap.enums.CategoryType;
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

	public static void initReports() throws Exception {
		if (Objects.isNull(report)) {
			report = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
			report.attachReporter(spark);
			spark.config().setTheme(Theme.DARK);
			spark.config().setReportName("Vasanth");
			spark.config().setDocumentTitle("Automation Test");
		}
	}

	public static void tearDownReports() throws Exception {
		if (Objects.nonNull(report)) {
			report.flush();
			ExtentManager.unload();
		}
		Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());// Open the file on the desktop default browser

	}

	public static void createTest(String testName) {
		ExtentManager.setExtentTest(report.createTest(testName));
	}
	public static void addAuthors(AuthorNames[] authors) {
		for(AuthorNames temp:authors) {
			ExtentManager.getExtentTest().assignAuthor(temp.toString());
		}
	}
	public static void addCatogeries(CategoryType[] catogeries) {
		for(CategoryType temp:catogeries) {
			ExtentManager.getExtentTest().assignCategory(temp.toString());
		}
	}
}
