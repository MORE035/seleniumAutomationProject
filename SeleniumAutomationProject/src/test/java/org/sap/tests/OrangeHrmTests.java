package org.sap.tests;

import org.assertj.core.api.Assertions;
import org.sap.pages.OrangeHrmHomePage;
import org.sap.pages.OrangeHrmLoginPage;
import org.testng.annotations.Test;

public final class OrangeHrmTests extends BaseTest {

	private OrangeHrmTests() {

	}

	@Test
	public void test1() {
		OrangeHrmLoginPage olg = new OrangeHrmLoginPage();
		OrangeHrmHomePage ohh =	 olg.enterUserName("Admin").enterPassword("admin123").clickLogin();	
		String title = ohh.clickNameDropDown().clickLogOut().getTitle();	
		Assertions.assertThat(title)
		.isEqualToIgnoringCase("OrangeHRM");
	}
}
