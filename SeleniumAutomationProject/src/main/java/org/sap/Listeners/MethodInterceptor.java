package org.sap.Listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.sap.constants.FrameworkConstants;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import com.sap.utils.ExcelUtils;

public final class MethodInterceptor  implements IMethodInterceptor {


	

	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
		

		List<Map<String, String>> list = ExcelUtils.getTestData(FrameworkConstants.getRunnersheet());
		List<IMethodInstance> result = new ArrayList<IMethodInstance>();
		for (int i = 0; i < methods.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				if (methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("testname"))) {
					//Use && operation to combile two if conditions 
					if (list.get(j).get("execute").equalsIgnoreCase("yes")) {
						methods.get(i).getMethod().setDescription(list.get(j).get("testdescription"));
						methods.get(i).getMethod().setInvocationCount(Integer.parseInt(list.get(j).get("count")));
						methods.get(i).getMethod().setPriority(Integer.parseInt(list.get(j).get("priority")));

						result.add(methods.get(i));
					}
				}
			}
		}
		return result;
	}

}
