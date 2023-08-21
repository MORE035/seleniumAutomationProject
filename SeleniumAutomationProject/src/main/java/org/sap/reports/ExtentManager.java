package org.sap.reports;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {

	private ExtentManager() {
		
	}
	public static ThreadLocal<ExtentTest> test=new ThreadLocal<ExtentTest>();
	public  static ExtentTest getExtentTest() {
		return test.get();
	}
	 static void setExtentTest(ExtentTest extentTest) {
		test.set(extentTest);
	}
	 static void unload() {
		test.remove();
	}


}
