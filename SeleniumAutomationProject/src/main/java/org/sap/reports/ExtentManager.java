package org.sap.reports;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {

	private ExtentManager() {
		
	}
	public static ThreadLocal<ExtentTest> test=new ThreadLocal<ExtentTest>();
	 static ExtentTest getExtentTest() {
		return test.get();
	}
	 static void setExtentTest(ExtentTest extentTest) {
		test.set(extentTest);
	}
	 static void unload() {
		test.remove();
	}


}
