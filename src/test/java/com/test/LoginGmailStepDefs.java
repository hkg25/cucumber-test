package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginGmailStepDefs {

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

	/*
	 * static { driver = getInstance(WebDriverEnum.INTERNET_EXPLORER_DRIVER); }
	 */
	@Given("^I go to loginURL")
	public void I_goto_loginUrl() {
		driver.get("http://www.gmail.com");
	}

	@When("^I enter username as \"(.*)\"$")
	public void enter_username(String username) {
		driver.findElement(By.id("Email")).sendKeys(username);
		driver.findElement(By.id("next")).submit();
	}

	@And("^I enter password as \"(.*)\"$")
	public void enter_password(String password) {
		driver.findElement(By.id("Passwd")).sendKeys(password);
		driver.findElement(By.id("signIn")).submit();
	}

	@Then("^I logged in username should be \"(.*)\"")
	public void I_logged_in_username_should_be(String str) {
		System.out.println("On then condition" + str);
	}

	@And("^I click on \"(.*)\" link$")
	public void i_clickon_logout(String link) {
		System.out.println("Logged out !!!" + link);
	}

	@After
	public void closeBrowser() {
		driver.close();
	}

}
