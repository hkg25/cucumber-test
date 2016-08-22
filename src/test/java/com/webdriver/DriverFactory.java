package com.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {

	private static WebDriver driver = null;

	private DriverFactory() {

	}

	//TODO: Update method to get the instance of web driver on the basis of property file
	public static WebDriver getInstance(WebDriverEnum driverEnum) {
		if (driver == null) {
			/*
			 * synchronized (WebDriver.class) { if (driver == null) {
			 */
			driver = getDriverInstance(driverEnum);
			/*
			 * } }
			 */
		}
		return driver;
	}

	private static WebDriver getDriverInstance(WebDriverEnum driverEnum) {
		switch (driverEnum) {
			/*case CHROME_DRIVER:
				System.setProperty("webdriver.chrome.driver",
						"drivers\\chrome\\chromeDriver.exe");
				driver = new ChromeDriver();*/
			case INTERNET_EXPLORER_DRIVER:
				System.setProperty("webdriver.ie.driver",
						"drivers\\ie\\IEDriverServer.exe");
				DesiredCapabilities capabilities = DesiredCapabilities
						.internetExplorer();
				capabilities
						.setCapability(
								InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
								true);
				driver = new InternetExplorerDriver(capabilities);
				/*
				 * case FIREFOX_DRIVER: driver = new FirefoxDriver(); case
				 * HTMLUNIT_DRIVER: driver = new HtmlUnitDriver();
				 */
			default:
		}
		return driver;
	}

}
