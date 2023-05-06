package com.axa.testautomation.api.tests;

import com.axa.testautomation.api.stepdefs.BaseStepDefs;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;

import java.text.SimpleDateFormat;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                //"classpath:features/eb_xpapi_RetrieveAccountDetails.feature",
                //"classpath:features/eb_xpapi_RetrievePolicyList.feature",
                "classpath:features/XPAPI_RetrievePolicyInformation.feature",
                //"classpath:features/hkal_RetrieveExchangeRate.feature"
                },
        glue = {"com.axa.testautomation.api.stepdefs" },
        plugin = {"pretty", "html:target/cucumber-reports"})
public class TestRunner {

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @BeforeClass
    public static void timeStamp() {
        BaseStepDefs.timeStamp = new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss").format(new java.util.Date());
    }
}
