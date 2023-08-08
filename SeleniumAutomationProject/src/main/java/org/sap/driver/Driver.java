package org.sap.driver;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sap.constants.FrameworkConstants;
import org.sap.enums.ConfigProperties;

import com.sap.utils.JsonUtils;
import com.sap.utils.ReadPropertyFileUtils;

public final class Driver {
	private Driver() {

	}

	public static void initDriver(String driver) throws Exception {
		if (Objects.isNull(DriverManager.getDriver())) {
			if (driver.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", FrameworkConstants.getCHROMEDRIVERPATH());
				// DriverManager.setDriver(new ChromeDriver()); one more way.....
				DriverManager.setDriver(new ChromeDriver());

			} else if (driver.equalsIgnoreCase("firefox")) {

				System.setProperty("webdriver.gecko.driver", FrameworkConstants.getFirefoxdriverpath());
				DriverManager.setDriver(new FirefoxDriver() );

			} else if (driver.equalsIgnoreCase("edge")) {

				System.setProperty("webdriver.edge.driver", FrameworkConstants.getEdgedriverpath());
				DriverManager.setDriver(new EdgeDriver());
			}
		}
		DriverManager.getDriver().get(ReadPropertyFileUtils.get(ConfigProperties.URL));
		DriverManager.getDriver().manage().window().maximize();
		// DriverManager.getDriver().manage().timeouts().implicitlyWait(10,
		// TimeUnit.SECONDS);
	}

	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}

}
