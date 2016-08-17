package com.test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	//	glue = "GoogleSearchStepDefinitions",
		strict = true, 
	//	features = "src/test/resources/", 
		tags = {"@Google_search,@Gmail_Login"}
		)
//format = {"pretty", "json:target/" })
public class CukeTest {

}
