package org.sap.pages;

import org.openqa.selenium.By;
import org.sap.driver.DriverManager;

public class OrangeHrmHomePage {
		private final By dropdown_name=By.xpath("//p[@class='oxd-userdropdown-name']");
		private final By link_logout=By.xpath("//a[text()='Logout']");
		
		public OrangeHrmHomePage clickNameDropDown() {
			DriverManager.getDriver().findElement(dropdown_name).click();
			return this;
		}
		public OrangeHrmLoginPage clickLogOut() {
			DriverManager.getDriver().findElement(link_logout).click();
			return new OrangeHrmLoginPage();
		}

}
