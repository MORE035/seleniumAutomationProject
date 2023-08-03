package org.exercise.testNgListners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.IAnnotationTransformer;
import org.testng.IMethodInstance;
import org.testng.annotations.ITestAnnotation;

public class AnnotationTranform implements IAnnotationTransformer{

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

		Map<String,Object> map1=new HashMap();
		map1.put("name", "test1");
		map1.put("count", "5");
		map1.put("enable", false);

		Map<String,Object> map2=new HashMap();
		map2.put("name", "test2");
		map2.put("count", "2");
		map2.put("enable", true);

		List<Map<String,Object>>list=new ArrayList();
		list.add(map1);
		list.add(map2);
		for(int i=0;i<list.size();i++) {
			if(testMethod.getName().equalsIgnoreCase((String) list.get(i).get("name"))) {
				if(list.get(i).get("enable").equals(false)) {
					annotation.setEnabled(false);
				}else {
				//	annotation.setInvocationCount((Integer.parseInt( (String) list.get(i).get("count")))); //setting invocation count
					annotation.setRetryAnalyzer(ReTry.class);//calling Re Try class
				}
			}
		}
	}

	
}
