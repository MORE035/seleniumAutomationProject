package org.sap.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sap.constants.FrameworkConstants;
import org.sap.driver.DriverManager;
import org.sap.enums.WaitStrategy;
import org.sap.factories.ExpliciteWaitFactory;
import org.sap.reports.ExtentLogger;

public class BasePage {

	protected void click(By by, WaitStrategy waitStrategy,String elementName)  {
		ExpliciteWaitFactory.performExplicteWait(waitStrategy, by).click();
		//ExtentLogger.pass(elementName);
		
			ExtentLogger.pass(elementName, true);
		
		
		//DriverManager.getDriver().findElement(by).click(); //clubed this code into Explicitewait factory
	}

	protected void enterText(By by, WaitStrategy waitStrategy, String value,String elementName){
		ExpliciteWaitFactory.performExplicteWait(waitStrategy, by).sendKeys(value);;
		
			ExtentLogger.pass("value "+value+" entered in "+elementName,true);
		

		//DriverManager.getDriver().findElement(by).sendKeys(value); //clubed this code into Explicitewait factory
	}

	protected String getPageTitle() {

		return DriverManager.getDriver().getTitle();
	}

	private void explicitlyWaitForElementToBeClickble(By by) {
		new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait())
				.until(ExpectedConditions.elementToBeClickable(by));
	}//This method code placed in Factory

	private void explicitlyWaitForElementToBePresence(By by) {
		new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait())
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
	}//This method code placed in Factory

}
