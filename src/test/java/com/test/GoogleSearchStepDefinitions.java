/**
 * 
 */
package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author hgarg
 *
 */
@ContextConfiguration("/cucumber.xml")
public class GoogleSearchStepDefinitions{
	
	@Autowired
	private BaseTest baseTest;
	
	public GoogleSearchStepDefinitions(){
		
	}
	
	
	public GoogleSearchStepDefinitions(BaseTest baseTest){
		this.baseTest = baseTest;
	}

	@Given("^I am on the Google search page$")
	public void I_visit_google_page() {
		baseTest.getDriver().get("http://www.google.com");
	}

	@When("^I search for \"(.*)\"$")
	public void search_For(String query) {

		WebElement element = baseTest.getDriver().findElement(By.name("q"));
		element.sendKeys(query);
		element.submit();

	}

	@Then("^the page title should start with \"(.*)\"$")
	public void checkTitle(String str) {

		new WebDriverWait(baseTest.getDriver(), 10).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getTitle().toLowerCase().startsWith("cheese");
			}
		});
		// assertEquals(driver.getTitle(),startsWith("cheese"));
	}

	/*@After
	public void closeBrowser() {
		baseTest.getDriver().close();
	}*/

}
