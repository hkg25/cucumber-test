/**
 * 
 */
package com.test;

import static com.webdriver.DriverFactory.getInstance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webdriver.WebDriverEnum;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author hgarg
 *
 */
public class GoogleSearchStepDefinitions {

	private static WebDriver driver = null;

	static {
		driver = getInstance(WebDriverEnum.INTERNET_EXPLORER_DRIVER);
	}

	@Given("^I am on the Google search page$")
	public void I_visit_google_page() {
		driver.get("http://www.google.com");
	}

	@When("^I search for \"(.*)\"$")
	public void search_For(String query) {

		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys(query);
		element.submit();

	}

	@Then("^the page title should start with \"(.*)\"$")
	public void checkTitle(String str) {

		new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getTitle().toLowerCase().startsWith("cheese");
			}
		});
		//assertEquals(driver.getTitle(),startsWith("cheese"));
	}

	@After
	public void closeBrowser() {
		driver.quit();
	}

}
