package com.cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/features/gpmdtest.feature", glue = "com.stepdefinitions", tags = "@googlelogin", 
plugin = {"pretty"}, monochrome = true, stepNotifications = true)

public class TestRunner {

}

    

