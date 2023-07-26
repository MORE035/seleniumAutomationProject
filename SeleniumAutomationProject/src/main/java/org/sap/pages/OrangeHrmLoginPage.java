package org.sap.pages;

import org.openqa.selenium.By;
import org.sap.driver.DriverManager;

public final class OrangeHrmLoginPage {

	private final By textbox_username=By.xpath("//input[@name='username']");
	private final By textbox_password=By.xpath("//input[@name='password' and @type='password']");
	private final By button_login=By.xpath("//button[@type='submit']");
	
	public OrangeHrmLoginPage enterUserName(String username) {
		DriverManager.getDriver().findElement(textbox_username).sendKeys(username);
		return this;

	}
	public OrangeHrmLoginPage enterPassword(String password) {
		DriverManager.getDriver().findElement(textbox_password).sendKeys(password);
		return this;
	}
	public OrangeHrmHomePage clickLogin() {
		DriverManager.getDriver().findElement(button_login).click();
		return new OrangeHrmHomePage();
	}
	
}
