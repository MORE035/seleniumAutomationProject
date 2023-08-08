package org.sap.Listeners;

import org.sap.enums.ConfigProperties;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.sap.utils.ReadPropertyFileUtils;

public class ReTryFailedTests implements IRetryAnalyzer{
	private int count=0;
	private int retries=1;
	@Override
	public boolean retry(ITestResult result) {
		boolean value=false;
		if(ReadPropertyFileUtils.get(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes")) {
		 value=count<retries;
		count++;
		return value;
		
	}
		return value;
	}

}
