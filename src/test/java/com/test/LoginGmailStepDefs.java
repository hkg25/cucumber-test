package com.test;

import static com.webdriver.DriverFactory.getInstance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.webdriver.WebDriverEnum;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginGmailStepDefs {

	private static WebDriver driver = null;

	static {
		driver = getInstance(WebDriverEnum.INTERNET_EXPLORER_DRIVER);
	}

	@Given("^I go to \"(.*)\"$")
	public void I_goto_loginUrl(String loginUrl) {
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
		driver.findElement(By.id("next")).submit();
	}

	@Then("^I logged in username should be \"(.*)\"")
	public void I_logged_in_username_should_be(String str) {
		System.out.println("On then condition" + str);
	}

	@And("^I click on \"(.*)\" link$")
	public void i_clickon_logout() {
		System.out.println("Logged out !!!");
	}

	@After
	public void closeBrowser() {
		driver.quit();
	}

}
