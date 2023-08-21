package org.sap.pages;

import org.openqa.selenium.By;
import org.sap.enums.WaitStrategy;

public final class AmazonHomePage extends BasePage{
	
	private  By linkHamburgerMenu=By.xpath("//a[@id='nav-hamburger-menu']");
	
	public   AmazonHambergerMenuPage clickHamburgerMenu() {
		click(linkHamburgerMenu, WaitStrategy.CLICKBLE, "clicked Hamburger menu");
		return new AmazonHambergerMenuPage();
	}
}
