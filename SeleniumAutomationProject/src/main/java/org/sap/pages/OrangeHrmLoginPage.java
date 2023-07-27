package org.sap.pages;

import org.openqa.selenium.By;
import org.sap.driver.DriverManager;
import org.sap.enums.WaitStrategy;

public final class OrangeHrmLoginPage extends BasePage {

	private final By textboxUserName=By.xpath("//input[@name='username']");
	private final By textboxPassword=By.xpath("//input[@name='password' and @type='password']");
	private final By buttonLogin=By.xpath("//button[@type='submit']");
	
	public OrangeHrmLoginPage enterUserName(String username) {
		enterText(textboxUserName,WaitStrategy.PRESENCE,username);
		return this;

	}
	public OrangeHrmLoginPage enterPassword(String password) {
		enterText(textboxPassword,WaitStrategy.PRESENCE,password);
		return this;
	}
	public OrangeHrmHomePage clickLogin() {
		click(buttonLogin,WaitStrategy.CLICKBLE);
		return new OrangeHrmHomePage();
	}
	public String getTitle() {
		return getPageTitle();
		
	}
}
