package com.sap.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.sap.constants.FrameworkConstants;
import org.testng.annotations.DataProvider;

public class DataProviderUtils {
private DataProviderUtils() {}
private static List<Map<String, String>> list=new ArrayList();

	@DataProvider
	public static Object[] getData(Method m) {
		if(list.isEmpty()) {
		list=ExcelUtils.getTestData(FrameworkConstants.getIterationdatasheet());
		}
		List<Map<String, String>> smallList=new ArrayList<>();
		String name=m.getName();
		for(int i=0;i<list.size();i++) {
			if(list.get(i).get("testname").equalsIgnoreCase(name)){
							//Use && operation to combile two if conditions 
				if(list.get(i).get("execute").equalsIgnoreCase("yes")) {
					smallList.add(list.get(i));
				}
			}
		}
	//	list.removeAll(smallList); //here remove used data if you can
		return smallList.toArray();
	}
}
