package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CucumberTest {
	private static WebDriver driver = null;

	@Before
	public void init() {
		// driver = getInstance(WebDriverEnum.INTERNET_EXPLORER_DRIVER);
		DesiredCapabilities capabilities = DesiredCapabilities
				.internetExplorer();
		capabilities
				.setCapability(
						InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
						true);
		driver = new InternetExplorerDriver(capabilities);
	}

	@Given("^there are \"(.*)\" cucumbers$")
	public void there_are_some_cucumbers(int totalCucumbers) {
		System.out.println("Cucumbers are :" + totalCucumbers);
	}

	@When("^I eat \"(.*)\" cucumbers$")
	public void eat_cucumbers(int eatenCucumbers) {
		System.out.println("Eaten Cucumbers are :" + eatenCucumbers);
	}

	@Then("^I should have \"(.*)\" cucumbers$")
	public void remaining_cucumbers(int remainingCucumbers) {
		System.out.println("Remaining Cucumbers are :" + remainingCucumbers);
	}


	@After
	public void closeBrowser() {
		driver.close();
	}

}
