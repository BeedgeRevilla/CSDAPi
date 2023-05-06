package com.axa.testautomation.api.stepdefs;


import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;
import org.junit.After;
import org.junit.Assert;

import java.util.Map;


public class CommonStepDefs extends BaseStepDefs{

    @Given("the following headers are set")
    public void set_http_headers(DataTable dt) {
        failedStatus = false;
        httpHeaders.clear();
        writeToLogFile("====== HEADERS ======");
        for(Map<String, String> row : dt.asMaps()) {
            for(Map.Entry<String, String> headerMap : row.entrySet()) {
                if(!headerMap.getValue().equalsIgnoreCase("#####")) {
                    httpHeaders.set(headerMap.getKey(), headerMap.getValue());
                    writeToLogFile(headerMap.getKey() + ": " + headerMap.getValue());
                }
            }
        }
        writeToLogFile("=====================");
    }

    @And("the following GET query parameters are set")
    public void set_get_parameters(DataTable dt) {
        getParameters = "?";
        for(Map<String, String> row : dt.asMaps()) {
            for(Map.Entry<String, String> getParametersMap : row.entrySet()) {
                getParameters = getParameters + getParametersMap.getKey() + "=" + getParametersMap.getValue() + "&";
            }
        }
        getParameters = getParameters.substring(0, getParameters.length()-1);
        writeToLogFile("PARAMETER: " + getParameters);
    }

    @And("no GET query parameters are set")
    public void set_empty_get_parameters() {
        getParameters = "?";
    }

    @Then("an error must be encountered with the following reasons")
    public void verify_error_response(DataTable dt) {
        writeToLogFile("\nValidations");
        writeToLogFile("=============================================================================");
        String expectedHttpErrorCode = dt.asMaps().get(0).get("ERROR_CODE");
        String expectedHttpErrorPhrase = dt.asMaps().get(0).get("ERROR_PHRASE");
        String expectedHttpErrorBody = dt.asMaps().get(0).get("ERROR_BODY");
        compareAPItoTable("Error Code", expectedHttpErrorCode, actualHttpErrorCode);
        compareAPItoTable("Error Phrase", expectedHttpErrorPhrase, actualHttpErrorPhrase);
        compareAPItoTable("Error Body", expectedHttpErrorBody, actualHttpErrorBody);
        Assert.assertFalse(failedStatus);
        writeToLogFile("=============================================================================\n");
    }

}
