package org.sap.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.sap.Listeners.ReTryFailedTests;
import org.sap.pages.OrangeHrmHomePage;
import org.sap.pages.OrangeHrmLoginPage;
import org.sap.reports.ExtentReporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sap.utils.DataProviderUtils;

public final class OrangeHrmTests extends BaseTest {

	private OrangeHrmTests() {

	}

	@Test(dataProvider = "TestData",enabled=false)
	public void test1(String username,String password) {
		OrangeHrmLoginPage olg = new OrangeHrmLoginPage();
		OrangeHrmHomePage ohh =	 olg.enterUserName(username).enterPassword(password).clickLogin();	
		String title = ohh.clickNameDropDown().clickLogOut().getTitle();	
		Assertions.assertThat(title)
		.isEqualToIgnoringCase("OrangeHRM");
	}
	@Test()
	public void loginLogoutTest1(Map<String,String>data) {
		//Data is driven from excel formate
		OrangeHrmLoginPage olg = new OrangeHrmLoginPage();
		OrangeHrmHomePage ohh =	 olg.enterUserName(data.get("username")).enterPassword(data.get("passowrd")).clickLogin();	
		String title = ohh.clickNameDropDown().clickLogOut().getTitle();	
		Assertions.assertThat(title)
		.isEqualToIgnoringCase("OrangeHRM");
	}
	@Test()
	public void newTest1(Map<String,String>data) {
		//Data is driven from excel formate
		OrangeHrmLoginPage olg = new OrangeHrmLoginPage();
		OrangeHrmHomePage ohh =	 olg.enterUserName(data.get("username")).enterPassword(data.get("passowrd")).clickLogin();	
		String title = ohh.clickNameDropDown().clickLogOut().getTitle();	
		Assertions.assertThat(title)
		.isEqualToIgnoringCase("OrangeHRM");
	}
	@Test()
	public void loginLogoutTest2(Map<String,String>data) {
		//Data is driven from excel formate
		OrangeHrmLoginPage olg = new OrangeHrmLoginPage();
		OrangeHrmHomePage ohh =	 olg.enterUserName(data.get("username")).enterPassword(data.get("passowrd")).clickLogin();	
		String title = ohh.clickNameDropDown().clickLogOut().getTitle();	
		Assertions.assertThat(title)
		.isEqualToIgnoringCase("OrangeHRM");
	}
	@DataProvider(name ="TestData",parallel = true)
	public Object[][] data() {
		return new Object[][]
				{
			{"Admin","admin123"},
			{"admin123","admin1"},
			{"Admin","admin123"},
			{"Admin","admin123"}
				};
	}
}
