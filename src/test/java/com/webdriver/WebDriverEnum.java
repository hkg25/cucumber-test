package com.webdriver;

public enum WebDriverEnum {

	CHROME_DRIVER("chrome"), INTERNET_EXPLORER_DRIVER("ie"), FIREFOX_DRIVER(
			"firefox"), HTMLUNIT_DRIVER("html");

	public final String status;

	private WebDriverEnum(String status) {
		this.status = status;
	}

}
