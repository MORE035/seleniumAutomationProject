package org.exercise.testNgListners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

public class MethodInterceptor implements IMethodInterceptor {

	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
		// TODO Auto-generated method stub
		List<IMethodInstance> result=new ArrayList();
		
		//result.add(methods.get(2));//how to call tests by using index name
		
		//how can enable and disable the tests and invocation count set here
		Map<String,String> map1=new HashMap();
		map1.put("name", "test1");
		map1.put("count", "5");
		Map<String,String> map2=new HashMap();
		map2.put("name", "test2");
		map2.put("count", "2");
		List<Map<String,String>>list=new ArrayList();
		list.add(map1);
		list.add(map2);
		for(int i=0;i<methods.size();i++) {
			for(int j=0;j<list.size();j++) {
				if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("name"))) {
					methods.get(i).getMethod().setInvocationCount(Integer.parseInt(list.get(j).get("count")));
					result.add(methods.get(i));
				}
			}
		}
		return result;
	}
	
}
