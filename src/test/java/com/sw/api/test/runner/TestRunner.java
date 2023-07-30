package com.sw.api.test.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

    @RunWith(Cucumber.class)
    @CucumberOptions(
            features = {"src/test/resources/features/GetActivities.feature"},
            glue     = {"com.sw.api.test.stepdefinitions"},
            plugin   = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
            monochrome = true
    )
    public class TestRunner {

}
