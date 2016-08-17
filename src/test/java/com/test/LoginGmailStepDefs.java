package com.test;

import static com.webdriver.DriverFactory.getInstance;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.webdriver.WebDriverEnum;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginGmailStepDefs {

	private static WebDriver driver = null;

	static {
		driver = getInstance(WebDriverEnum.INTERNET_EXPLORER_DRIVER);
	}

	@Given("^I go to \"(.*)\"$")
	public void I_goto_loginUrl() {
		driver.get("http://www.gmail.com");
	}

	@When("^I enter username as \"(.*)\"$")
	public void search_For(DataTable datatable) {
		List<List<String>> tables = datatable.raw();
		driver.findElement(By.id("Email")).sendKeys(tables.get(0).get(0));
		driver.findElement(By.id("next")).submit();
		driver.findElement(By.id("Passwd")).sendKeys(tables.get(0).get(1));
		driver.findElement(By.id("next")).submit();
	}

	@Then("^I logged in username should be \"(.*)\"")
	public void I_logged_in_username_should_be(String str) {
		System.out.println("On then condition");
	}

	@After
	public void closeBrowser() {
		driver.quit();
	}

}
