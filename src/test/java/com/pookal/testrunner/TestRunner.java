package com.pookal.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "classpath:features/AdminCustomer.feature",
	    glue = {
	        "com.pookal.stepdefiniton.login",
	        "com.pookal.stepdefiniton.admin",
	        "com.pookal.utilityfiles"
	    },
	    plugin = {
	        "pretty",
	        "html:target/cucumber-reports.html"
	    },
	    monochrome = true
	)
	public class TestRunner extends AbstractTestNGCucumberTests {
	}
	