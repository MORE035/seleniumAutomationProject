package org.exercise.testNgListners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class ReTry implements IRetryAnalyzer {

	//when ever the test fail the method Re try will called,if the method true,the failed
	//you call this class in where ever rerun your test
	int limit=5;
	int count=0;
	@Override
	public boolean retry(ITestResult result) {
		
		if(count<limit) {
			count++;
			return true;
		}
		return false;
		
	}

}
