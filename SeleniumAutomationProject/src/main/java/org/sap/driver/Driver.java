package org.sap.driver;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sap.constants.FrameworkConstants;

import com.sap.utils.ReadPropertyFile;

public final class Driver {
	private Driver() {
		
	}
	

	public static void initDriver() throws Exception {
		if (Objects.isNull(DriverManager.getDriver())) {
			System.setProperty("webdriver.chrome.driver", FrameworkConstants.getCHROMEDRIVERPATH());
			WebDriver driver = new ChromeDriver();
		//	DriverManager.setDriver(new ChromeDriver()); one more way.....
			DriverManager.setDriver(driver);
			DriverManager.getDriver().get(ReadPropertyFile.get("url"));
			DriverManager.getDriver().manage().window().maximize();
			DriverManager.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	}

	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}

}
