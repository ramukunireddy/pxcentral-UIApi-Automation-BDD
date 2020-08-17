package com.test.step.definitions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"html:target/cucumberHtmlReport"},
		glue = {"classpath:com.test.step.definitions"},
		features = "classpath:features/UI"
)

public class RunCukesTest{
}
