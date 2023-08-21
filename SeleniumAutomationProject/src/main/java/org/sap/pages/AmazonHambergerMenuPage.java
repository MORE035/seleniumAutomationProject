package org.sap.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.sap.enums.WaitStrategy;
import org.testng.annotations.Test;

import com.sap.utils.DynamicXpathUtils;

public final class AmazonHambergerMenuPage extends BasePage{
	 AmazonHambergerMenuPage() {}
	private static String linkSubMenu="//div[text()='%s']";
	public  AmazonMobileComputersPage clickSubMenuItem(String menuText) {
		String newLink=DynamicXpathUtils.getXpath1(linkSubMenu, menuText);
		click(By.xpath(newLink), WaitStrategy.CLICKBLE, menuText);
		
		return new AmazonMobileComputersPage();
	}
	
	
	

}
