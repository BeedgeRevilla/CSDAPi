package com.axa.testautomation.api.stepdefs.XPAPI;


import com.axa.testautomation.api.stepdefs.BaseStepDefs;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.ssl.SSLContextBuilder;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
//import org.testng.asserts.SoftAssert;






import javax.net.ssl.SSLContext;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;


public class XP_RetrieveAccountDetailsStepDef extends BaseStepDefs {

    @Autowired
    private String retrieveAccountDetailsUrl;

    @Autowired
    private String retrieveAccountDetailsValidatorUrl;

    @Given("the following http headers are set for XP Retrieve Account Details")
    public void set_http_headers(DataTable dt) {
        failedStatus = false;
        httpHeaders.clear();
        validatorHttpHeaders.clear();
        writeToLogFile("====== XP API HEADERS ======");
        for(Map<String, String> row : dt.asMaps()) {
            for(Map.Entry<String, String> headerMap : row.entrySet()) {
                if(!headerMap.getValue().equalsIgnoreCase("#####")) {
                    httpHeaders.set(headerMap.getKey(), headerMap.getValue());
                    writeToLogFile(headerMap.getKey() + ": " + headerMap.getValue());
                    validatorHttpHeaders.set(headerMap.getKey(), headerMap.getValue());
                }
            }
        }
        writeToLogFile("============================");
        validatorHttpHeaders.set("x-axahk-channelcode", "EB-PORTAL");
        validatorHttpHeaders.set("x-axahk-lob", "HEALTH");
        validatorHttpHeaders.set("x-axahk-sourcesystem", "EB");
        validatorHttpHeaders.set("Accept", "application/json");
        validatorHttpHeaders.set("Content-Type", "application/json");
    }

    @And("the following GET input parameters are set for XP Retrieve Account Details")
    public void set_get_parameters(DataTable dt) {
        getParameters = "?";

        for(Map<String, String> row : dt.asMaps()) {
            for(Map.Entry<String, String> getParametersMap : row.entrySet()) {
                if(!getParametersMap.getValue().equalsIgnoreCase("")) {
                    getParameters = getParameters + getParametersMap.getKey() + "=" + getParametersMap.getValue() + "&";
                    getValidatorParameters = getValidatorParameters + getParametersMap.getKey() + "=" + getParametersMap.getValue() + "&";
                }
            }
        }

        writeToLogFile("PARAMETER: " + getParameters);
        getParameters = getParameters.concat("apikey=SjKAt8YLPtmkTVZJreJAmkJNjhFg7ArQyHibDnqCD2z56zUXtE9sQ7aU9MXvbSyb");
        getValidatorParameters = getValidatorParameters.substring(0, getValidatorParameters.length()-1);
    }

    @When("a GET XP API call has been made to the Retrieve Account Details")
    public void send_get_XPAPI_request() {
        try {
            HttpHost proxy = new HttpHost("10.40.249.26", 8080);
            DefaultProxyRoutePlanner routePlanner = new DefaultProxyRoutePlanner(proxy);

            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, (certificate, authType) -> true).build();

            HttpClient httpclient = HttpClients
                    .custom()
                    .setRoutePlanner(routePlanner)
                    .setSSLContext(sslContext)
                    .setSSLHostnameVerifier(new NoopHostnameVerifier())
                    .build();

            if(System.getProperty("isCitrix")!=null) {
            	httpclient = HttpClients
                        .custom()
                        .setSSLContext(sslContext)
                        .setSSLHostnameVerifier(new NoopHostnameVerifier())
                        .build();
            }

            HttpComponentsClientHttpRequestFactory requestFactory =
                    new HttpComponentsClientHttpRequestFactory();
            requestFactory.setHttpClient(httpclient);

            restTemplate = new RestTemplate(requestFactory);
            String url = retrieveAccountDetailsUrl + getParameters;
            writeToLogFile("ENDPOINT: " + retrieveAccountDetailsUrl);
            HttpEntity<String> entity = new HttpEntity<>("", httpHeaders);
            response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            writeToLogFile("[XPAPI Response]");
            writeToLogFile(response.getBody());
        }
        catch (HttpClientErrorException e) {
            actualHttpErrorCode = Integer.toString(e.getStatusCode().value());
            actualHttpErrorPhrase = e.getStatusCode().getReasonPhrase();
            actualHttpErrorBody = e.getResponseBodyAsString().replaceAll("\n","");
        }
        catch(HttpServerErrorException e ) {
            actualHttpErrorCode = Integer.toString(e.getStatusCode().value());
            actualHttpErrorPhrase = e.getStatusCode().getReasonPhrase();
            actualHttpErrorBody = e.getResponseBodyAsString().replaceAll("\n","");
        }
        catch (NoSuchAlgorithmException | KeyStoreException | KeyManagementException e) {
            //writeToLogFile(e.printStackTrace());
        }
    }

    @When("a GET BAPI call has been made to the Retrieve Account Details")
    public void send_get_BAPI_request() {
        try {
            HttpHost proxy = new HttpHost("10.40.249.26", 8080);
            DefaultProxyRoutePlanner routePlanner = new DefaultProxyRoutePlanner(proxy);

            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, (certificate, authType) -> true).build();

            HttpClient httpclient = HttpClients
                    .custom()
                    .setRoutePlanner(routePlanner)
                    .setSSLContext(sslContext)
                    .setSSLHostnameVerifier(new NoopHostnameVerifier())
                    .build();

            if(System.getProperty("isCitrix")!=null) {
            	httpclient = HttpClients
                        .custom()
                        .setSSLContext(sslContext)
                        .setSSLHostnameVerifier(new NoopHostnameVerifier())
                        .build();
            }

            HttpComponentsClientHttpRequestFactory requestFactory =
                    new HttpComponentsClientHttpRequestFactory();
            requestFactory.setHttpClient(httpclient);

            restTemplateValidator = new RestTemplate(requestFactory);
            String url = retrieveAccountDetailsValidatorUrl + getValidatorParameters;
            HttpEntity<String> entity = new HttpEntity<>("", validatorHttpHeaders);
            response = restTemplateValidator.exchange(url, HttpMethod.GET, entity, String.class);
            writeToLogFile("====== BAPI HEADERS ======");
            validatorHttpHeaders.forEach((key, values) -> {
                for (String value : values) {
                    writeToLogFile(key + ": " + value);
                }
            });
            writeToLogFile("==========================");
            writeToLogFile("PARAMETER: " + getValidatorParameters);
            writeToLogFile("ENDPOINT: " + retrieveAccountDetailsValidatorUrl);
            writeToLogFile("[BAPI Response]");
            writeToLogFile(response.getBody());
        }
        catch (HttpClientErrorException e) {
            actualHttpErrorCode = Integer.toString(e.getStatusCode().value());
            actualHttpErrorPhrase = e.getStatusCode().getReasonPhrase();
            actualHttpErrorBody = e.getResponseBodyAsString().replaceAll("\n","");
        }
        catch(HttpServerErrorException e ) {
            actualHttpErrorCode = Integer.toString(e.getStatusCode().value());
            actualHttpErrorPhrase = e.getStatusCode().getReasonPhrase();
            actualHttpErrorBody = e.getResponseBodyAsString().replaceAll("\n","");
        }
        catch (NoSuchAlgorithmException | KeyStoreException | KeyManagementException e) {
            //writeToLogFile(e.printStackTrace());
        }
    }

    @Then("verify that XP API and BAPI responses matched for Retrieve Account Details")
    public void verify_response_body(DataTable dt) {
//        SoftAssert sa = new SoftAssert();
        JsonObject jsonObject = new JsonParser().parse(response.getBody()).getAsJsonObject();
        List<Map<String, String>> listOfRowsToValidate = dt.asMaps();
        writeToLogFile("[Validations]");
        writeToLogFile("=============================================================================");
        for(int i=0; i<jsonObject.get("retrieveAccountDetailsResponse").getAsJsonArray().size(); i++) {

            String actualCompanyName = jsonObject.get("retrieveAccountDetailsResponse").getAsJsonArray().get(i).getAsJsonObject().get("companyName").toString();
            String actualCompanyAddress = jsonObject.get("retrieveAccountDetailsResponse").getAsJsonArray().get(i).getAsJsonObject().get("companyAddress").toString();
            String actualCompanyPIC = jsonObject.get("retrieveAccountDetailsResponse").getAsJsonArray().get(i).getAsJsonObject().get("companyPIC").toString();
            String actualCompanyTelephone = jsonObject.get("retrieveAccountDetailsResponse").getAsJsonArray().get(i).getAsJsonObject().get("companyTelephone").toString();
            String actualCompanyAffiliateName = jsonObject.get("retrieveAccountDetailsResponse").getAsJsonArray().get(i).getAsJsonObject().get("affiliateName").toString();
            String actualCompanyAffiliateAddress = jsonObject.get("retrieveAccountDetailsResponse").getAsJsonArray().get(i).getAsJsonObject().get("affiliateAddress").toString();

            String expectedCompanyName = listOfRowsToValidate.get(i).get("companyName");
            String expectedCompanyAddress = listOfRowsToValidate.get(i).get("companyAddress");
            String expectedCompanyPIC = listOfRowsToValidate.get(i).get("companyPIC");
            String expectedCompanyTelephone = listOfRowsToValidate.get(i).get("companyTelephone");
            String expectedCompanyAffiliateName = listOfRowsToValidate.get(i).get("affiliateName");
            String expectedCompanyAffiliateAddress = listOfRowsToValidate.get(i).get("affiliateAddress");
            writeToLogFile("retrieveAccountDetailsResponse["+i+"]");
            writeToLogFile("=============================================================================");
            compareAPItoTable("companyName", expectedCompanyName, actualCompanyName);
            compareAPItoTable("companyAddress", expectedCompanyAddress, actualCompanyAddress);
            compareAPItoTable("companyPIC", expectedCompanyPIC, actualCompanyPIC);
            compareAPItoTable("companyTelephone", expectedCompanyTelephone, actualCompanyTelephone);
            compareAPItoTable("affiliateName", expectedCompanyAffiliateName, actualCompanyAffiliateName);
            compareAPItoTable("affiliateAddress", expectedCompanyAffiliateAddress, actualCompanyAffiliateAddress);
            writeToLogFile("=============================================================================");
        }

        writeToLogFile("=============================================================================\n");
		Assert.assertFalse(failedStatus);
    }

}
