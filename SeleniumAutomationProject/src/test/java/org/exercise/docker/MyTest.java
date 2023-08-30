package org.exercise.docker;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class MyTest {
private MyTest() {
	WebDriverManager.chromedriver().setup();
	WebDriverManager.firefoxdriver().setup();
}

Capabilities chromeCapabilities = DesiredCapabilities.chrome();
Capabilities firefoxCapabilities = DesiredCapabilities.firefox();

@Test
public  void main() throws MalformedURLException {

  WebDriver chrome = new RemoteWebDriver(new URL("http://localhost:4446/wd/hub"), chromeCapabilities);
  WebDriver firefox = new RemoteWebDriver(new URL("http://localhost:4446/wd/hub"), firefoxCapabilities);

  // run against chrome
  chrome.get("https://www.google.com");
  System.out.println(chrome.getTitle());

  // run against firefox
  firefox.get("https://www.google.com");
  System.out.println(firefox.getTitle());

  chrome.quit();
  firefox.quit();
}
}
