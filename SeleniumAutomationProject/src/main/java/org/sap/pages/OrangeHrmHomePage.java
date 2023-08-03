package org.sap.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sap.driver.DriverManager;
import org.sap.enums.WaitStrategy;
import org.sap.reports.ExtentLogger;
import org.sap.reports.ExtentManager;
import org.sap.reports.ExtentReporter;

import com.google.common.util.concurrent.Uninterruptibles;

public class OrangeHrmHomePage extends BasePage {
	private final By dropdownName = By.xpath("//p[@class='oxd-userdropdown-name']");
	private final By linkLogout = By.xpath("//a[text()='Logout']");

	public OrangeHrmHomePage clickNameDropDown() {
		click(dropdownName, WaitStrategy.CLICKBLE,"clicked name drop down");
		return this;
	}

	public OrangeHrmLoginPage clickLogOut() {
		// Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS); other way of
		// Thread.sleep
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 10);
		wait.until(ExpectedConditions.elementToBeClickable(linkLogout));
		click(linkLogout, WaitStrategy.CLICKBLE,"clicked Logout link");
		return new OrangeHrmLoginPage();
	}

}
