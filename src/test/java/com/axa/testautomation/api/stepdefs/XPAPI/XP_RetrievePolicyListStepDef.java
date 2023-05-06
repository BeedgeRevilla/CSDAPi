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


public class XP_RetrievePolicyListStepDef extends BaseStepDefs {

    @Autowired
    private String retrievePolicyListUrl;

    @Autowired
    private String retrievePolicyListValidatorUrl;

    private int recordsPerPage;
    private int pageNo;

    @Given("the following http headers are set for Retrieve Policy List")
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

    @And("the following GET input parameters are set for XP Retrieve Policy List")
    public void set_get_parameters(DataTable dt) {
        getParameters = "?";
        getValidatorParameters = "?";
        for(Map<String, String> row : dt.asMaps()) {
            for(Map.Entry<String, String> getParametersMap : row.entrySet()) {
                if(!getParametersMap.getValue().equalsIgnoreCase("")) {
                    getParameters = getParameters + getParametersMap.getKey() + "=" + getParametersMap.getValue() + "&";
                    switch (getParametersMap.getKey()){
                        case "affiliateNo": getValidatorParameters = getValidatorParameters + "affiliateNumber=" + getParametersMap.getValue() + "&"; break;
                        case "policyHolderNo": getValidatorParameters = getValidatorParameters + "policyHolderNumber=" + getParametersMap.getValue() + "&"; break;
                        case "pageNo": pageNo = Integer.parseInt(getParametersMap.getValue()); break;
                        case "recordsPerPage": recordsPerPage = Integer.parseInt(getParametersMap.getValue()); break;
                        default: getValidatorParameters = getValidatorParameters + getParametersMap.getKey() + "=" + getParametersMap.getValue() + "&"; break;
                    }
                }
            }
        }

        writeToLogFile("PARAMETER: " + getParameters);
        getParameters = getParameters.concat("apikey=SjKAt8YLPtmkTVZJreJAmkJNjhFg7ArQyHibDnqCD2z56zUXtE9sQ7aU9MXvbSyb");
        getValidatorParameters = getValidatorParameters + "startingIndex=" + String.valueOf((recordsPerPage*pageNo) - recordsPerPage) + "&mdmId=8555845";
    }

    @When("the XPAPI call has been made for Retrieve Policy List")
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
            String url = retrievePolicyListUrl + getParameters;
            writeToLogFile("ENDPOINT: " + retrievePolicyListUrl);
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

    @When("the BAPI call has been made for Retrieve Policy List")
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
            String validatorUrl = retrievePolicyListValidatorUrl + getValidatorParameters;
            //String validatorUrl = retrievePolicyListValidatorUrl + "?startingIndex=1&recordsPerPage=4&mdmId=8555845&fromDate=20160101&policyHolderNumber=049685&toDate=20180101&orderBy=DESC&sortKey=BILL_ISSUE_DT&affiliateNumber=01";
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
            writeToLogFile("ENDPOINT: " + retrievePolicyListValidatorUrl);
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


    @Then("verify that XP API and BAPI responses matched for Retrieve Policy List")
    public void xpapi_match_bapi() {
        JsonObject xpAPI = new JsonParser().parse(response.getBody()).getAsJsonObject();
        JsonObject bAPI = new JsonParser().parse(validatorResponse.getBody()).getAsJsonObject();
        writeToLogFile("[Validations]");
        writeToLogFile("=============================================================================");
        JsonElement xp = xpAPI.get("retrievePolicyListResponse");
        JsonElement bp = bAPI.get("retrievePolicyListResponse");
        writeToLogFile("retrievePolicyListResponse()");
        writeToLogFile("=============================================================================");
        compareAPItoAPI("totalRecordCount", bp.getAsJsonObject().get("totalCount").toString(), xp.getAsJsonObject().get("totalRecordCount").toString());

        for(int i=0; i<xpAPI.get("retrievePolicyListResponse").getAsJsonObject().get("policy").getAsJsonArray().size(); i++) {
            JsonElement x = xpAPI.get("retrievePolicyListResponse").getAsJsonObject().get("policy").getAsJsonArray().get(i);
            JsonElement b = bAPI.get("retrievePolicyListResponse").getAsJsonObject().get("policy").getAsJsonArray().get(i);
            writeToLogFile("=============================================================================");
            writeToLogFile("retrievePolicyListResponse().policy["+i+"]");
            writeToLogFile("=============================================================================");
            String str = b.getAsJsonObject().get("policyNumber").toString().replace("\"","");
            String contractType = "\""+str.substring(str.length() - 2)+"\"";
            compareAPItoAPI("contractType", contractType, x.getAsJsonObject().get("contractType").toString());
            compareAPItoAPI("policyNo", b.getAsJsonObject().get("policyNumber").toString(), x.getAsJsonObject().get("policyNo").toString());
            compareAPItoAPI("affiliateName", b.getAsJsonObject().get("affiliateName").toString(), x.getAsJsonObject().get("affiliateName").toString());
            compareAPItoAPI("affiliateNo", b.getAsJsonObject().get("affiliateNumber").toString(), x.getAsJsonObject().get("affiliateNo").toString());
            compareAPItoAPI("policyStatus", b.getAsJsonObject().get("policyStatusCode").toString(), x.getAsJsonObject().get("policyStatus").toString());
            int numOfMembers = b.getAsJsonObject().get("numberOfInsuredEmployees").getAsInt()+b.getAsJsonObject().get("numberOfInsuredSpouses").getAsInt()+b.getAsJsonObject().get("numberOfInsuredChildren").getAsInt();
            compareAPItoAPI("numOfMembers", Integer.toString(numOfMembers), x.getAsJsonObject().get("numOfMembers").getAsString());
            compareAPItoAPI("effectiveDate", b.getAsJsonObject().get("policyEffectiveDate").toString(), x.getAsJsonObject().get("effectiveDate").toString());
            compareAPItoAPI("policyType", contractType, x.getAsJsonObject().get("policyType").toString());
        }
        writeToLogFile("=============================================================================\n");
		Assert.assertFalse(failedStatus);
    }

}
