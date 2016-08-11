/**
 * 
 */
package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author hgarg
 *
 */
public class GoogleSearchStepDefinitions {

	static {
		System.setProperty("webdriver.ie.driver",
				"C:\\Users\\hgarg\\Downloads\\IEDriverServer_x64_2.53.1\\IEDriverServer.exe");
		
		System.out.println(System.getProperty("webdriver.ie.driver"));
	}

	private final WebDriver driver = new InternetExplorerDriver();

	@Given("^I am on the Google search page$")
	public void I_visit_google_page() {
		driver.get("www.google.com");
		System.out.println("On given condition");
	}

	@When("^I search for \"(.*)\"$")
	public void search_For(String query) {
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys(query);
		element.submit();
		System.out.println("On when condition");
	}

	@Then("^the page title should start with \"(.*)\"$")
	public void checkTitle(String str) {
		new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getTitle().toLowerCase().startsWith("cheese");
			}
		});
		// assertEquals(driver.getTitle(),startsWith("cheese"));
		System.out.println("On then condition");
	}

	/*
	 * @After public void closeBrowser(){ driver.quit(); }
	 */
}
