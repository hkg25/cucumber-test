package com.test;

import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

import com.webdriver.DriverFactory;
import com.webdriver.WebDriverEnum;


@Component
public class BaseTest {

	private static boolean initialized = false;

	private WebDriver driver;
	
	public BaseTest() {
		if (!initialized) {
			driver = DriverFactory.getInstance(WebDriverEnum.INTERNET_EXPLORER_DRIVER);
		}
	}

	public WebDriver getDriver() {
		return driver;
	}

}
