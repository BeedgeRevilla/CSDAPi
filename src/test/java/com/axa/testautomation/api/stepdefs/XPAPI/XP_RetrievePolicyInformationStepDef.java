package com.axa.testautomation.api.stepdefs.XPAPI;


import com.axa.testautomation.api.stepdefs.BaseStepDefs;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.And;
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

import javax.net.ssl.SSLContext;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;


public class XP_RetrievePolicyInformationStepDef extends BaseStepDefs {

    @Autowired
    private String retrievePolicyInformationUrl;

    @Autowired
    private String retrievePolicyInformationValidatorUrl;

    @Given("the following http headers are set for Retrieve Policy Information")
    public void set_http_headers(DataTable dt) {
        failedStatus = false;
        httpHeaders.clear();
        validatorHttpHeaders.clear();
        writeToLogFile("====== XPAPI HEADERS ======");
        for(Map<String, String> row : dt.asMaps()) {
            for(Map.Entry<String, String> headerMap : row.entrySet()) {
                if(!headerMap.getValue().equalsIgnoreCase("#####")) {
                    httpHeaders.set(headerMap.getKey(), headerMap.getValue());
                    writeToLogFile(headerMap.getKey() + ": " + headerMap.getValue());
                    validatorHttpHeaders.set(headerMap.getKey(), headerMap.getValue());
                }
            }
        }
        writeToLogFile("==========================");
        validatorHttpHeaders.set("x-axahk-channelcode", "EB-PORTAL");
        validatorHttpHeaders.set("x-axahk-lob", "HEALTH");
        validatorHttpHeaders.set("x-axahk-sourcesystem", "EB");
        validatorHttpHeaders.set("Accept", "application/json");
        validatorHttpHeaders.set("Content-Type", "application/json");
    }

    @And("the following GET input parameters are set for Retrieve Policy Information")
    public void set_get_parameters(DataTable dt) {
        getParameters = "?";
        getValidatorParameters = "?";
        for(Map<String, String> row : dt.asMaps()) {
            for (Map.Entry<String, String> getParametersMap : row.entrySet()) {
                if (!getParametersMap.getValue().equalsIgnoreCase("")) {
                    if (getParametersMap.getKey().equalsIgnoreCase("policyHolderNo")) {
                        retrievePolicyInformationUrl = retrievePolicyInformationUrl.replace("{" + getParametersMap.getKey() + "}", getParametersMap.getValue());
                        getValidatorParameters = getValidatorParameters + "policyNumber" + "=" + getParametersMap.getValue() + "&";
                    } else {
                        getParameters = getParameters + getParametersMap.getKey() + "=" + getParametersMap.getValue() + "&";
                        if (getParametersMap.getKey().equalsIgnoreCase("affiliateNo")) {
                            getValidatorParameters = getValidatorParameters + "affiliateNumber=" + getParametersMap.getValue() + "&";
                        }else{
                            getValidatorParameters = getValidatorParameters + getParametersMap.getKey() + "=" + getParametersMap.getValue() + "&";
                        }
                    }
                }
            }
        }

        writeToLogFile("PARAMETER: " + getParameters.substring(0, getParameters.length()-1));
        getParameters = getParameters.concat("apikey=SjKAt8YLPtmkTVZJreJAmkJNjhFg7ArQyHibDnqCD2z56zUXtE9sQ7aU9MXvbSyb");
        //getValidatorParameters = getValidatorParameters.substring(0, getValidatorParameters.length()-1);
        getValidatorParameters = getValidatorParameters + "mdmId=8555559";
    }

    @When("the XPAPI call has been made for Retrieve Policy Information")
    public void send_get_request_for_XPAPI() {
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
            
            String url = retrievePolicyInformationUrl + getParameters;
            writeToLogFile("ENDPOINT: " + retrievePolicyInformationUrl);
            HttpEntity<String> entity = new HttpEntity<>("", httpHeaders);
            response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            writeToLogFile("\n[XPAPI Response]");
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

    @When("the BAPI call has been made for Retrieve Policy Information")
    public void send_get_request_for_bapi() {
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
            String validatorUrl = retrievePolicyInformationValidatorUrl + getValidatorParameters;
            HttpEntity<String> validatorEntity = new HttpEntity<>("", validatorHttpHeaders);
            validatorResponse = restTemplateValidator.exchange(validatorUrl, HttpMethod.GET, validatorEntity, String.class);
            writeToLogFile("====== BAPI HEADERS ======");
            validatorHttpHeaders.forEach((key, values) -> {
                for (String value : values) {
                    writeToLogFile(key + ": " + value);
                }
            });
            writeToLogFile("==========================");
            writeToLogFile("PARAMETER: " + getValidatorParameters);
            writeToLogFile("ENDPOINT: " + retrievePolicyInformationValidatorUrl);

            writeToLogFile("\n[BAPI Response]");
            writeToLogFile(validatorResponse.getBody());
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


    @Then("verify that XP API and BAPI responses matched for Retrieve Policy Information")
    public void xpapi_match_bapi() {
        JsonObject xpAPI = new JsonParser().parse(response.getBody()).getAsJsonObject();
        JsonObject bAPI = new JsonParser().parse(validatorResponse.getBody()).getAsJsonObject();
        writeToLogFile("[Validations]");
        writeToLogFile("=============================================================================");
        JsonElement x = xpAPI.get("retrievePolicyInformationResponse").getAsJsonObject();
        JsonElement b = bAPI.get("retrievePolicyListResponse").getAsJsonObject().get("policy").getAsJsonArray().get(0);
        writeToLogFile("retrievePolicyInformationResponse()");
        writeToLogFile("=============================================================================");
        //Assert.assertEquals(x.getAsJsonObject().get("policyNo").toString(), b.getAsJsonObject().get("policyNumber").toString());
        compareAPItoAPI("policyNo", b.getAsJsonObject().get("policyNumber").toString(), x.getAsJsonObject().get("policyNo").toString());
        compareAPItoAPI("affiliateName", b.getAsJsonObject().get("affiliateName").toString(), x.getAsJsonObject().get("affiliateName").toString());
        compareAPItoAPI("affiliateNo", b.getAsJsonObject().get("affiliateNumber").toString(), x.getAsJsonObject().get("affiliateNo").toString());
        compareAPItoAPI("policyStatus", b.getAsJsonObject().get("policyStatusCode").toString(), x.getAsJsonObject().get("policyStatus").toString());
        int numOfMembers = b.getAsJsonObject().get("numberOfInsuredEmployees").getAsInt()+b.getAsJsonObject().get("numberOfInsuredSpouses").getAsInt()+b.getAsJsonObject().get("numberOfInsuredChildren").getAsInt();
        compareAPItoAPI("numOfMembers", "\""+Integer.toString(numOfMembers)+"\"", x.getAsJsonObject().get("numOfMembers").toString());
        String str = b.getAsJsonObject().get("policyNumber").toString().replace("\"","");
        String contractType = "\""+str.substring(str.length() - 2)+"\"";
        compareAPItoAPI("contractType", contractType, x.getAsJsonObject().get("contractType").toString());
        compareAPItoAPI("numOfEmployee", b.getAsJsonObject().get("numberOfInsuredEmployees").toString(), x.getAsJsonObject().get("numOfEmployee").toString());
        compareAPItoAPI("numOfSpouse", b.getAsJsonObject().get("numberOfInsuredSpouses").toString(), x.getAsJsonObject().get("numOfSpouse").toString());
        compareAPItoAPI("numOfChildren", b.getAsJsonObject().get("numberOfInsuredChildren").toString(), x.getAsJsonObject().get("numOfChildren").toString());
        //premiumAmount
        compareAPItoAPI("effectiveDate", b.getAsJsonObject().get("policyEffectiveDate").toString(), x.getAsJsonObject().get("effectiveDate").toString());
        compareAPItoAPI("renewDate", b.getAsJsonObject().get("policyRenewalDate").toString(), x.getAsJsonObject().get("renewDate").toString());
        compareAPItoAPI("paymentMode", b.getAsJsonObject().get("paymentModeCode").toString(), x.getAsJsonObject().get("paymentMode").toString());

        writeToLogFile("=============================================================================\n");
		Assert.assertFalse(failedStatus);

    }

}
