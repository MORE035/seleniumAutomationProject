package org.sap.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.sap.annotations.FrameWorkAnnotation;
import org.sap.enums.AuthorNames;
import org.sap.enums.CategoryType;
import org.sap.pages.OrangeHrmHomePage;
import org.sap.pages.OrangeHrmLoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sap.utils.DecodeUtils;

public final class OrangeHrmTests extends BaseTest {

	private OrangeHrmTests() {

	}
	@FrameWorkAnnotation(category = {CategoryType.REGRESSION}, autherName = { AuthorNames.VASANTH })
	@Test(dataProvider = "TestData",enabled=false)
	public void test1(String username,String password) {
		OrangeHrmLoginPage olg = new OrangeHrmLoginPage();
		OrangeHrmHomePage ohh =	 olg.enterUserName(username).enterPassword(DecodeUtils.getDecoderString(password)).clickLogin();	
		String title = ohh.clickNameDropDown().clickLogOut().getTitle();	
		Assertions.assertThat(title)
		.isEqualToIgnoringCase("OrangeHRM");
	}
	@FrameWorkAnnotation(category = {CategoryType.REGRESSION}, autherName = { AuthorNames.VASANTH })
	@Test()
	public void loginLogoutTest1(Map<String,String>data) {
		//Data is driven from excel formate
		OrangeHrmLoginPage olg = new OrangeHrmLoginPage();
		OrangeHrmHomePage ohh =	 olg.enterUserName(data.get("username")).enterPassword(DecodeUtils.getDecoderString(data.get("passowrd"))).clickLogin();	
		String title = ohh.clickNameDropDown().clickLogOut().getTitle();	
		Assertions.assertThat(title)
		.isEqualToIgnoringCase("OrangeHRM");
	}
	@FrameWorkAnnotation(category = {CategoryType.REGRESSION}, autherName = { AuthorNames.VASANTH })
	@Test()
	public void newTest1(Map<String,String>data) {
		//Data is driven from excel formate
		OrangeHrmLoginPage olg = new OrangeHrmLoginPage();
		OrangeHrmHomePage ohh =	 olg.enterUserName(data.get("username")).enterPassword(DecodeUtils.getDecoderString(data.get("passowrd"))).clickLogin();	
		String title = ohh.clickNameDropDown().clickLogOut().getTitle();	
		Assertions.assertThat(title)
		.isEqualToIgnoringCase("OrangeHRM");
	}
	@FrameWorkAnnotation(category = {CategoryType.REGRESSION}, autherName = { AuthorNames.VASANTH })
	@Test()
	public void loginLogoutTest2(Map<String,String>data) {
		//Data is driven from excel formate
		OrangeHrmLoginPage olg = new OrangeHrmLoginPage();
		OrangeHrmHomePage ohh =	 olg.enterUserName(data.get("username")).enterPassword(DecodeUtils.getDecoderString(data.get("passowrd"))).clickLogin();	
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
