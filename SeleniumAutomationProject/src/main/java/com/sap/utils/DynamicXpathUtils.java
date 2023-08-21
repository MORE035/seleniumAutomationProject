package com.sap.utils;

public final class DynamicXpathUtils  {

	private DynamicXpathUtils(){}
	public static String getXpath(String xpath,String value) {
		return xpath.replace("%replaceble%", value);
		
	}
	public static String getXpath1(String xpath,String value) {
		return String.format(xpath, value);
		
	}
	
}
