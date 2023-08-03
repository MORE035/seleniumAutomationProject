package org.exercise.testNgListners;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Runner {
	

		 @FindBys({@FindBy(id = "foo"),
		           @FindBy(className = "bar")})
		 WebElement element;
	
	@BeforeSuite
	public void initSuite() {
		System.out.println("Before suite in Runner");
	}
	
	@AfterSuite
	public void tearSuite() {
		System.out.println("After suite in Runner");
	}
	@BeforeTest
	public void initTest() {
		System.out.println("Before test in Runner");
	}
	@AfterTest
	public void tearTest() {
		System.out.println("After test in Runner");
	}
	@BeforeMethod
	public void initMethod() {
		System.out.println("Before Method in Runner");
	}
	@AfterMethod
	public void tearMethod() {
		System.out.println("After Method in Runner");

	}
	@Test
	public void test1() {
		System.out.println("Test1 in Runner");
	}

	@Test(retryAnalyzer = ReTry.class)
	public void test2() {
		System.out.println("Test2 in Runner");
		Assert.assertTrue(false);
		WebDriver driver=null;

		
		

	List<WebElement> list = driver.findElement(By.xpath("")).findElements(By.xpath(""));

	}
	@Test
	public void test3() {
		System.out.println("Test3 in Runner");
	}
	
}
