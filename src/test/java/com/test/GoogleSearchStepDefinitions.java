/**
 * 
 */
package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

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

		System.setProperty("webdriver.ie.driver",
				"drivers\\ie\\IEDriverServer.exe");

		System.out.println(System.getProperty("webdriver.ie.driver"));
		DesiredCapabilities capabilities = DesiredCapabilities
				.internetExplorer();
		capabilities
				.setCapability(
						InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
						true);
		driver = new InternetExplorerDriver(capabilities);
	}

	// private final WebDriver driver = new InternetExplorerDriver();

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
