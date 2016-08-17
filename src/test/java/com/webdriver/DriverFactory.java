package com.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {

	private static WebDriver driver = null;

	private DriverFactory() {

	}

	public static WebDriver getInstance(WebDriverEnum driverEnum) {
		setSystemProperties();
		if (driver == null) {
			synchronized (WebDriver.class) {
				if (driver == null) {
					driver = getDriverInstance(driverEnum);
				}
			}
		}
		return driver;
	}

	private static void setSystemProperties() {
		System.setProperty("webdriver.ie.driver",
				"drivers\\ie\\IEDriverServer.exe");
		// Add more properties as per the usage of different browser drivers
	}

	private static WebDriver getDriverInstance(WebDriverEnum driverEnum) {
		switch (driverEnum) {
		/*case CHROME_DRIVER:
			driver = new ChromeDriver();*/
		case INTERNET_EXPLORER_DRIVER:
			DesiredCapabilities capabilities = DesiredCapabilities
					.internetExplorer();
			capabilities
					.setCapability(
							InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
							true);
			driver = new InternetExplorerDriver(capabilities);
		/*case FIREFOX_DRIVER:
			driver = new FirefoxDriver();
		case HTMLUNIT_DRIVER:
			driver = new HtmlUnitDriver();*/
		default:

		}
		return driver;
	}

}
