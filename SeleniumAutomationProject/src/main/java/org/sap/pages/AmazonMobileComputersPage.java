package org.sap.pages;

import org.sap.driver.DriverManager;

public final class AmazonMobileComputersPage  extends BasePage{
	
	public  String  getTitle() {
		return DriverManager.getDriver().getTitle();
	}

}
