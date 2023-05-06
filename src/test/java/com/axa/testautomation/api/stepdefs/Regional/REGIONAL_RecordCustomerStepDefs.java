package com.axa.testautomation.api.stepdefs.Regional;


import com.axa.testautomation.api.regional.RecordCustomer.payload.RecordCustomerRequestPayload;
import com.axa.testautomation.api.regional.RecordCustomer.response.*;
import com.axa.testautomation.api.stepdefs.BaseStepDefs;
import com.google.gson.*;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

import org.apache.commons.lang.SystemUtils;
import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.json.JSONArray;
import org.json.JSONException;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;


public class REGIONAL_RecordCustomerStepDefs extends BaseStepDefs {

    @Autowired
    private String regionalNitRecordCustomer;
    
    private String payload;
    private String filePath;
    private String msgId;

	private RecordCustomerRequestPayload recordCustomerRequestPayload;

	private RecordCustomerResponseContainer recordCustomerResponseContainer;

    @Given("the following http headers are set Record Customer")
    public void set_http_headers(DataTable dt) {
        failedStatus = false;
        httpHeaders.clear();
        writeToLogFile("====== HEADERS ======");
        for(Map<String, String> row : dt.asMaps()) {
            for(Map.Entry<String, String> headerMap : row.entrySet()) {
            	if(headerMap.getKey().equalsIgnoreCase("X-Axa-MsgId") || 
            			headerMap.getKey().equalsIgnoreCase("X-Axa-InitialMsgId")) {
            		if(headerMap.getValue().equalsIgnoreCase("[$autogen]")){
	            		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new java.util.Date());
	            		httpHeaders.set(headerMap.getKey(), timeStamp);
	            		msgId = timeStamp;
            		}else{
            			httpHeaders.set(headerMap.getKey(), headerMap.getValue());
            			msgId = headerMap.getValue();
            		}
            		writeToLogFile(headerMap.getKey() + ": " + msgId);
            	}else{
            		httpHeaders.set(headerMap.getKey(), headerMap.getValue());
            		writeToLogFile(headerMap.getKey() + ": " + headerMap.getValue());
            	}
            }
        }
        
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        writeToLogFile("=====================");
    }
    
    @Given("the following PAYLOAD request body is set for Record Customer")
    public void set_payload(DataTable dt) {
        failedStatus = false;
        payload = "";
        writeToLogFile("====== PAYLOAD ======");
        
        for(Map<String, String> row : dt.asMaps()) {
            for(Map.Entry<String, String> headerMap : row.entrySet()) {
            	if(headerMap.getKey().equalsIgnoreCase("payload")){
            		filePath = headerMap.getValue();
            	}
            }
        }
        
        String filename = "src/payload/Regional/recordCustomer/"+filePath;
		try {
			payload = new String(Files.readAllBytes(Paths.get(filename)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writeToLogFile(payload);
        Gson gson = new Gson();
        recordCustomerRequestPayload = gson.fromJson(payload.toString(), RecordCustomerRequestPayload.class);
        writeToLogFile("=====================");
    }
    
    @When("the api call has been made for Record Customer")
    public void send_put_request_for_API() {
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

            if(System.getProperty("isCitrix")!=null) {
                restTemplate = new RestTemplate();
            }else{
                restTemplate = new RestTemplate(requestFactory);
            }
            String url = regionalNitRecordCustomer;
            writeToLogFile("ENDPOINT: " + url);
            HttpEntity<String> entity = new HttpEntity<>(payload, httpHeaders);
            response = restTemplate.exchange(url, HttpMethod.PUT, entity, String.class);
            writeToLogFile("[API Response]");
            writeToLogFile(response.getBody());
            
            Gson gson = new Gson();
            recordCustomerResponseContainer = gson.fromJson(response.getBody(), RecordCustomerResponseContainer.class);
        }
        catch (HttpClientErrorException | HttpServerErrorException e) {
            actualHttpErrorCode = Integer.toString(e.getStatusCode().value());
            actualHttpErrorPhrase = e.getStatusCode().getReasonPhrase();
            actualHttpErrorBody = e.getResponseBodyAsString().replaceAll("\n","");
            writeToLogFile("[API Response]");
            writeToLogFile(actualHttpErrorBody);
        }
    }
    
    @Then("verify that API response matches for Record Customer")
    public void verify_api_response(DataTable dt) {
    	if(response == null){
            failedStatus = true;
            scenario.write("[API Response]");
            scenario.write(actualHttpErrorBody);
            Assert.assertFalse(failedStatus);
        }

        if(response.getBody().contains("exception")){
            failedStatus = true;
            scenario.write("[API Response]");
            scenario.write(response.getBody());
            Assert.assertFalse(failedStatus);
        }
    	
        String sourceMsgID = "";
        String contextID = "";
        String status = "";
        
        for(Map<String, String> row : dt.asMaps()) {
            for(Map.Entry<String, String> headerMap : row.entrySet()) {
            	switch (headerMap.getKey()){
            		case "sourceMsgID": sourceMsgID = msgId; break;
            		case "contextID": contextID = msgId; break;
            		case "status": status = headerMap.getValue(); break;
            	}
            }
        }
        
        writeToLogFile("[Validations]");
        writeToLogFile("=============================================================================");
        writeToLogFile("RecordCustomerResponse().ackResponse()");
        writeToLogFile("=============================================================================");
        AckResponse ar = recordCustomerResponseContainer.getRecordCustomerResponse().getAckResponse();
        compareDbToApi_String("sourceMsgID", sourceMsgID, ar.getSourceMsgID());
        compareDbToApi_String("contextID", contextID, ar.getContextID());
        compareDbToApi_String("status", status, ar.getStatus());
        
        writeToLogFile("=============================================================================\n");
		Assert.assertFalse(failedStatus);
    }

}
