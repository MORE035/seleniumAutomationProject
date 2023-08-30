package org.sap.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sap.annotations.FrameWorkAnnotation;
import org.sap.enums.AuthorNames;
import org.sap.enums.CategoryType;
import org.sap.pages.AmazonHomePage;
import org.testng.annotations.Test;

public final class AmazonDemoTest extends BaseTest{
private AmazonDemoTest() {}
@FrameWorkAnnotation(category = {CategoryType.REGRESSION}, autherName = { AuthorNames.VASANTH })
@Test
public void amazonTest(Map<String,String> data) {
	String title= new AmazonHomePage().clickHamburgerMenu().clickSubMenuItem(data.get("items")).getTitle();
	 Assertions.assertThat(title).isNotBlank().isNotEmpty();
	// ExtentManager.getExtentTest().assignAuthor("Vasanth").assignCategory("smoke"); //code is switched framework annotations
	 //Mobiles, Computers
	 //TV, Appliances, Electronics
	 //Men's Fashion
	 //Women's Fashion

}
@Test(enabled = false)
public void m1() {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\SPUGE\\git\\repository3\\SeleniumAutomationProject\\src\\test\\resources\\drivers\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.orangehrm.com/");
	boolean isPresent = driver.findElement(By.cssSelector("#optanon-menu  .menu-item-about")).isDisplayed();
	System.out.println(isPresent);
}

}
