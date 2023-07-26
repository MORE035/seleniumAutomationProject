package org.sap.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.sap.driver.DriverManager;
import org.testng.annotations.Test;

public final class LoginPageTests extends BaseTest {
	private LoginPageTests() {
		
	}
	@Test
	public void test1() {
		System.out.println("Login page tests");
		DriverManager.getDriver().findElement(By.xpath("//textarea[@name='q']")).sendKeys("vasanth",Keys.ENTER);

	}
	@Test
	public void test2() {
		System.out.println("Login page tests");
		DriverManager.getDriver().findElement(By.xpath("//textarea[@name='q']")).sendKeys("Malathi",Keys.ENTER);

	}


}
