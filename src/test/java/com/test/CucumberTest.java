package com.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@ContextConfiguration("/cucumber.xml")
public class CucumberTest{

	@Autowired
	private BaseTest baseTest;
	
	public CucumberTest(){
		
	}

	@Autowired
	public CucumberTest(BaseTest baseTest) {
		this.baseTest = baseTest;
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

	/*@After
	public void closeBrowser() {
		baseTest.getDriver().close();
	}
*/
}
