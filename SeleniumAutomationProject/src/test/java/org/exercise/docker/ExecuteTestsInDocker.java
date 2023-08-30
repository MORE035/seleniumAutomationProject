package org.exercise.docker;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class ExecuteTestsInDocker {
	private ExecuteTestsInDocker() {}
	
	@Test
	public void localTest() throws MalformedURLException {
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setBrowserName(BrowserType.CHROME);
		//WebDriverManager.chromedriver().setup();
		WebDriver driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
		driver.get("https://www.google.co.in/");
		System.out.println(driver.getTitle());
		driver.quit();
	}
	@Test
	public void localTest1() throws MalformedURLException {
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setBrowserName(BrowserType.FIREFOX);
		//WebDriverManager.chromedriver().setup();
		WebDriver driver=new RemoteWebDriver(new URL("http://localhost:cmd/wd/hub"),cap);
		driver.get("https://www.facebook.com/");
		System.out.println(driver.getTitle());
		driver.quit();
	}
	@Test(dataProvider = "data")
	public void localTestDataProvider(String browser) throws MalformedURLException {
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setBrowserName(browser);
	
		cap.setPlatform(Platform.LINUX);
		//WebDriverManager.chromedriver().setup();
	//	WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new RemoteWebDriver(new URL("http://localhost:4446/wd/hub"),cap);
		driver.get("https://www.facebook.com/");
		System.out.println(driver.getTitle());
		driver.quit();
	}

	@DataProvider(parallel = true)
	public Object[][] data() {
		Object[][] obj=new Object[][] {{"chrome"},{"firefox"},{"chrome"},{"firefox"}};
		return obj;
	}
}
