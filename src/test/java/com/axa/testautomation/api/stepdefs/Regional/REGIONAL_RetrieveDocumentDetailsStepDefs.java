package com.axa.testautomation.api.stepdefs.Regional;

import com.axa.testautomation.api.regional.RetrieveDocumentDetails.*;
import com.axa.testautomation.api.stepdefs.BaseStepDefs;
import com.google.gson.Gson;
import io.cucumber.datatable.DataTable;


import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.junit.Assert;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.codec.binary.Base64;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class REGIONAL_RetrieveDocumentDetailsStepDefs extends BaseStepDefs {

    @Autowired
    private String regionalNitRetrieveDocumentDetails;

    private String lob;
    private String axaEntity;
    private String policyNumber;
    private String documentID;
    private String documentClass;
    private String msgId;
    private RetrieveDocumentDetailsResponseContainer retrieveDocumentDetailsResponseContainer;

    @Given("the following http headers are set Retrieve Document Details")
    public void set_http_headers(DataTable dt) {
        failedStatus = false;
        httpHeaders.clear();
        writeToLogFile("====== HEADERS ======");
        for (Map<String, String> row : dt.asMaps()) {
            for (Map.Entry<String, String> headerMap : row.entrySet()) {
                httpHeaders.set(headerMap.getKey(), headerMap.getValue());
                writeToLogFile(headerMap.getKey() + ": " + headerMap.getValue());
                switch (headerMap.getKey().toLowerCase()) {
                    case "x-axa-entity":
                        axaEntity = headerMap.getValue();
                        break;
                    case "x-axa-lob":
                        lob = headerMap.getValue();
                        break;
                    case "x-axa-msgid":
                        msgId = headerMap.getValue();
                        break;
                }
            }
        }
        writeToLogFile("=====================");
    }

    @And("the following GET input parameters are set for Retrieve Document Details")
    public void set_get_parameters(DataTable dt) {
        failedStatus = false;
        getParameters = "/?";
        for (Map<String, String> row : dt.asMaps()) {
            for (Map.Entry<String, String> getParametersMap : row.entrySet()) {
                if (!getParametersMap.getValue().equalsIgnoreCase("")) {
                    getParameters = getParameters + getParametersMap.getKey() + "=" + getParametersMap.getValue() + "&";
                }
                switch (getParametersMap.getKey()) {
                    case "policyNumber":
                        policyNumber = getParametersMap.getValue();
                        break;
                    case "documentID":
                        documentID = getParametersMap.getValue();
                        break;
                    case "documentClass":
                        documentClass = getParametersMap.getValue();
                        break;
                }
            }
        }
        getParameters = getParameters.substring(0, getParameters.length() - 1);
        writeToLogFile("PARAMETER: " + getParameters);
    }

    @When("the call to the API Retrieve Document Details is made")
    public void send_get_request_for_API() {
        try {
            HttpHost proxy = new HttpHost("10.40.249.26", 8080);
            DefaultProxyRoutePlanner routePlanner = new DefaultProxyRoutePlanner(proxy);

            HttpClient httpclient = HttpClients
                    .custom()
                    .setRoutePlanner(routePlanner)
                    .build();

            HttpComponentsClientHttpRequestFactory requestFactory =
                    new HttpComponentsClientHttpRequestFactory();
            requestFactory.setHttpClient(httpclient);

            if (System.getProperty("isCitrix") != null) {
                restTemplate = new RestTemplate();
            } else {
                restTemplate = new RestTemplate(requestFactory);
            }
            String url = regionalNitRetrieveDocumentDetails.replace("{documentID}", documentID) + "?documentClass=All";
            writeToLogFile("ENDPOINT: " + url);
            //writeToLogFile("Current URL: " + url);
            System.setProperty("file.encoding", "UTF-8");
	            /*
	            writeToLogFile("FILE ENCODING: " + System.getProperty("file.encoding"));
	            httpHeaders.add("Content-Type", "application/json; charset=utf8");
	            
	           =======================
	           
	           byte[] valueDecoded = Base64.decodeBase64(ns1XMLData.getBytes());
	            ns1XMLData = new String(valueDecoded, "UTF-8");
				writeToLogFile("[ns1:XMLData]: " + ns1XMLData); 
	            */
            HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
            response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            writeToLogFile("[API Response]");
            writeToLogFile(response.getBody());


            Gson gson = new Gson();
            retrieveDocumentDetailsResponseContainer = gson.fromJson(response.getBody(), RetrieveDocumentDetailsResponseContainer.class);

            //JsonObject api = new JsonParser().parse(response.getBody()).getAsJsonObject();
            //documentTitle documentContent
            //String result = api.get("RetrieveDocumentDetailsResponse").getAsJsonObject().get("documentContent").toString().replace("\"","");
            //String result = api.get("RetrieveDocumentDetailsResponse").getAsJsonObject().get("documentElement").getAsJsonObject().get("documentTitle").toString();
            RetrieveDocumentDetailsResponse rddr = retrieveDocumentDetailsResponseContainer.getRetrieveDocumentDetailsResponse();
            String result = rddr.getDocumentContent().toString().replace("\"", "");
            String mimeType = rddr.getDocumentElement().getMIMEType();
            byte[] valueDecoded = Base64.decodeBase64(result.getBytes());
            try {
                String ns1XMLData = new String(valueDecoded);
                //writetopdf(result,msgId);
                convertToFile(result, axaEntity+"_"+lob+"_"+msgId, mimeType);
            }catch(Exception e){
                failedStatus = true;
                scenario.write(e.toString());
                writeToLogFile(e.toString());
                Assert.assertFalse(failedStatus);

            }
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            actualHttpErrorCode = Integer.toString(e.getStatusCode().value());
            actualHttpErrorPhrase = e.getStatusCode().getReasonPhrase();
            actualHttpErrorBody = e.getResponseBodyAsString().replaceAll("\n", "");
            writeToLogFile("[API Response]");
            writeToLogFile(actualHttpErrorBody);

            Assert.assertFalse(true);
        }

    }


}
