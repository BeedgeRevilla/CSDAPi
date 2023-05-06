package com.axa.testautomation.api.stepdefs;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.After;

import static com.axa.testautomation.api.stepdefs.BaseStepDefs.writeToLogFile;

public class Hooks {
    @Before
    public void before(Scenario scenario) {
        BaseStepDefs.scenario = scenario;
        writeToLogFile("[Scenario Name] " + scenario.getName());
    }

    @After
    public void after(Scenario scenario) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
