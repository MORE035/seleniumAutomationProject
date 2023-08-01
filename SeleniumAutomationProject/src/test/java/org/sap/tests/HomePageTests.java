package org.sap.tests;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.sap.driver.Driver;
import org.sap.driver.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import net.bytebuddy.implementation.bytecode.Duplication;

public class HomePageTests extends BaseTest{
	@Test(enabled = false)
	public void test2() {
		//Driver.initDriver();
		System.out.println("Home page tests");
		DriverManager.getDriver().findElement(By.xpath("//textarea[@name='q']")).sendKeys("Testing mini bytes - Youtube",Keys.ENTER);
		String title=DriverManager.getDriver().getTitle();
		Assertions.assertThat(title)
		.isNotNull()
		.hasSizeBetween(15, 100)
		.containsIgnoringCase("google search");
		
	/*	TestNG Assertions
	 	Assert.assertTrue(Objects.nonNull(title),"Title is NULL check once");
		Assert.assertTrue(title.length()>15 && title.length()<100);
		Assert.assertTrue(title.toLowerCase().contains("google search"),"google search not present in perticler title");
		*/
		List<WebElement> listLinks = DriverManager.getDriver().findElements(By.xpath("//div[@class='yuRUbf']/a/h3"));
		Assertions.assertThat(listLinks)
		.hasSizeBetween(8,11);
	//	.extracting(e->e.getText());
	//	.matches("\\w"+"Testing Mini Bytes");
	/*	Assert.assertEquals(listLinks.size(),9,"Size is not equals");
		boolean isPresent=false;
		for(WebElement element :listLinks) {
			if(element.getText().equalsIgnoreCase("Testing Mini Bytes")) {
				isPresent=true;
			}
		}
		Assert.assertTrue(isPresent);
		*/

	}
	@Test
	public void test3() throws InterruptedException {
		DriverManager.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		DriverManager.getDriver().findElement(By.xpath("//input[@id=\"src\"]")).sendKeys("Bapatla");
		Thread.sleep(1000);
		DriverManager.getDriver().findElement(By.xpath("(//ul[@class='sc-dnqmqq eFEVtU']/li)[1]")).click();
		DriverManager.getDriver().findElement(By.xpath("//input[@id=\"dest\"]")).sendKeys("Hyderabad");
		Thread.sleep(1000);
		DriverManager.getDriver().findElement(By.xpath("(//ul[@class='sc-dnqmqq eFEVtU']/li)[1]")).click();

		
	}

}
