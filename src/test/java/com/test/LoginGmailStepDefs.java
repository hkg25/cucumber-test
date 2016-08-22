package com.test;

import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@ContextConfiguration("/cucumber.xml")
public class LoginGmailStepDefs{

	@Autowired
	private BaseTest baseTest;
	
	public LoginGmailStepDefs(){
		
	}
	
	public LoginGmailStepDefs(BaseTest baseTest) {
		this.baseTest = baseTest;
	}

	@Given("^I go to loginURL")
	public void I_goto_loginUrl() {
		baseTest.getDriver().get("http://www.gmail.com");
	}

	@When("^I enter username as \"(.*)\"$")
	public void enter_username(String username) {
		baseTest.getDriver().findElement(By.id("Email")).sendKeys(username);
		baseTest.getDriver().findElement(By.id("next")).submit();
	}

	@And("^I enter password as \"(.*)\"$")
	public void enter_password(String password) {
		baseTest.getDriver().findElement(By.id("Passwd")).sendKeys(password);
		baseTest.getDriver().findElement(By.id("signIn")).submit();
	}

	@Then("^I logged in username should be \"(.*)\"")
	public void I_logged_in_username_should_be(String str) {
		System.out.println("On then condition " + str);
	}

	@And("^I click on \"(.*)\" link$")
	public void i_clickon_logout(String link) {
		System.out.println("Logged out !!! " + link);
		baseTest.getDriver().findElement(By.id("gb_71")).submit();
	}

	/*@After
	public void closeBrowser() {
		baseTest.getDriver().close();
	}*/

}
