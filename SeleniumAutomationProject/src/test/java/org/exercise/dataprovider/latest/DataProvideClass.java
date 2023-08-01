package org.exercise.dataprovider.latest;

import org.testng.annotations.DataProvider;

public class DataProvideClass {
	
	protected DataProvideClass() {
	}
	
	@DataProvider(name = "data")
	public static  Integer[][] data() {
		return new Integer[][] {
				{1,2},
				{3,5},
				{7,8}
				};
	}
	@DataProvider(name = "data1")
	public String[][] data1() {
		return new String[][] {
				{"1","2"},
				{"3","4"},
				{"5","6"}
				};
	}

}
