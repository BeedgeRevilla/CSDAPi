package com.axa.testautomation.api.stepdefs.Regional;


import com.axa.testautomation.api.regional.RecordCustomerContact.response.*;
import com.axa.testautomation.api.regional.RecordCustomerContact.dbResult.*;
import com.axa.testautomation.api.regional.RecordCustomerContact.payload.*;
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
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;


public class REGIONAL_RecordCustomerContactStepDefs extends BaseStepDefs {

    @Autowired
    private String regionalNitRecordCustomerContact;
    @Autowired
	private String sg_MDCOR7QI;
    @Autowired
    private String g_SG_CUST;
    @Autowired
    private String hk_MDCOR7QI;
    @Autowired
    private String g_HK_CUST;
    @Autowired
    private String corePassword;
    
    private String axaEntity;
    private String sourceSystem;
    
    private String payload;
    private String filePath;
    private String msgId;

	private RecordCustomerContactRequestPayload recordCustomerContactRequestPayload;

	private RecordCustomerContactResponseContainer recordCustomerContactResponseContainer;
	private GetCustomerContact[] getCustomerContact;

    @Given("the following http headers are set Record Customer Contact")
    public void set_http_headers(DataTable dt) {
        failedStatus = false;
        httpHeaders.clear();
        writeToLogFile("====== HEADERS ======");
        for(Map<String, String> row : dt.asMaps()) {
            for(Map.Entry<String, String> headerMap : row.entrySet()) {
            	if(headerMap.getKey().equalsIgnoreCase("X-Axa-MsgId") || 
            			headerMap.getKey().equalsIgnoreCase("X-Axa-InitialMsgId")) {
            		if(headerMap.getValue().equalsIgnoreCase("[$autogen]")){
	            		msgId = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new java.util.Date());
	            		httpHeaders.set(headerMap.getKey(), msgId);
            		}else{
            			httpHeaders.set(headerMap.getKey(), headerMap.getValue());
            			msgId = headerMap.getValue();
            		}
            		writeToLogFile(headerMap.getKey() + ": " + msgId);
            	}else{
            		httpHeaders.set(headerMap.getKey(), headerMap.getValue());
            		writeToLogFile(headerMap.getKey() + ": " + headerMap.getValue());
            	}
            	if(headerMap.getKey().equalsIgnoreCase("X-Axa-Entity")) {
                    axaEntity = headerMap.getValue();
                }
            }
        }
        
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        writeToLogFile("=====================");
    }
    
    @Given("the following PAYLOAD request body is set for Record Customer Contact")
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

        filePath = "recordCustomerContact_template.txt";
        
        String filename = "src/payload/Regional/recordCustomerContact/"+filePath;
		try {
			payload = new String(Files.readAllBytes(Paths.get(filename)));
            for(Map<String, String> row : dt.asMaps()) {
                for(Map.Entry<String, String> headerMap : row.entrySet()) {
                    if(!headerMap.getKey().equalsIgnoreCase("payload")){
                        payload = payload.replace("%" + headerMap.getKey() + "%", headerMap.getValue());
                    }
                }
            }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writeToLogFile(payload);
        Gson gson = new Gson();
        recordCustomerContactRequestPayload = gson.fromJson(payload.toString(), RecordCustomerContactRequestPayload.class);
        writeToLogFile("=====================");
    }
    
    @When("the api call has been made for Record Customer Contact")
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
           
            String url = regionalNitRecordCustomerContact;
            writeToLogFile("ENDPOINT: " + url);
            HttpEntity<String> entity = new HttpEntity<>(payload, httpHeaders);
            response = restTemplate.exchange(url, HttpMethod.PUT, entity, String.class);
            writeToLogFile("[API Response]");
            writeToLogFile(response.getBody());
            
            Gson gson = new Gson();
            recordCustomerContactResponseContainer = gson.fromJson(response.getBody(), RecordCustomerContactResponseContainer.class);
        }
        catch (HttpClientErrorException | HttpServerErrorException e) {
            actualHttpErrorCode = Integer.toString(e.getStatusCode().value());
            actualHttpErrorPhrase = e.getStatusCode().getReasonPhrase();
            actualHttpErrorBody = e.getResponseBodyAsString().replaceAll("\n","");
            writeToLogFile("[API Response]");
            writeToLogFile(actualHttpErrorBody);
        }
    }
    
    @Then("verify that API response matches for Record Customer Contact")
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
        
        writeToLogFile("\n[API Validations]");
        writeToLogFile("=============================================================================");
        writeToLogFile("RecordCustomerContactResponse().ackResponse()");
        writeToLogFile("=============================================================================");
        AckResponse ar = recordCustomerContactResponseContainer.getRecordCustomerContactResponse().getAckResponse();
        compareDbToApi_String("sourceMsgID", sourceMsgID, ar.getSourceMsgID());
        compareDbToApi_String("contextID", contextID, ar.getContextID());
        compareDbToApi_String("status", status, ar.getStatus());
        
        writeToLogFile("=============================================================================\n");
		Assert.assertFalse(failedStatus);
    }
    
    @And("verify that records are updated in DB for Record Customer Contact")
    public void verify_records_in_DB() {
    	String filename = "";
        String text = "";
        String query = "";
        String dbConnection = "";
        String userName = "";
        String password = "";
        Connection con;
        
        CoreParty cp = recordCustomerContactRequestPayload.getRecordCustomerContactRequest().getCoreParty();
        
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
	        switch (axaEntity.toLowerCase()){
	            case "sg": dbConnection = sg_MDCOR7QI;
	                userName = g_SG_CUST;
	                password = corePassword;
	                break;
                case "hk": dbConnection = hk_MDCOR7QI;
                    userName = g_HK_CUST;
                    password = corePassword;
                    break;
            }
	        writeToLogFile("====== DB Connection ======");
	        String[] dbConn = dbConnection.split("/");
	        writeToLogFile("Host/Port: " + dbConn[0]);
	        writeToLogFile("Service: " + dbConn[1]);
	        writeToLogFile("Schema: " + userName);
			con = DriverManager.getConnection(
			        "jdbc:oracle:thin:@//"+dbConnection,userName,password);
	        filename = "src/sql/Regional/recordCustomerContact/getRecordCustomerContact.txt";
	        text = new String(Files.readAllBytes(Paths.get(filename)));
	        query = text.replace("%sourceSystem%", "PSEA")
	        		.replace("%coreDBPartyId%", cp.getCoreDBPartyId())
	        		;
	        writeToLogFile("[SQL Query]");
	        writeToLogFile(query);
	        JSONArray jaResponse = executeQuery(con, query);
	        Gson gson = new Gson();
	        getCustomerContact = gson.fromJson(jaResponse.toString(), GetCustomerContact[].class);
	        con.close();
	        
		} catch (SQLException | ClassNotFoundException | IOException e) {
            failedStatus = true;
            scenario.write(e.toString());
            writeToLogFile(e.toString());
            Assert.assertFalse(failedStatus);
		}
		
		writeToLogFile("\n[DB Validations]");
		writeToLogFile("=============================================================================");
		if(getCustomerContact!=null){
	        writeToLogFile("RecordCustomerContactRequest().coreParty()");
	        writeToLogFile("=============================================================================");
			compareDbToApi_String("coreDBPartyId", cp.getCoreDBPartyId(), getCustomerContact[0].getPARTYRK());
			writeToLogFile("=============================================================================");
	        writeToLogFile("RecordCustomerContactRequest().coreParty().electronicContacts()");
	        writeToLogFile("=============================================================================");
	        PhysicalContact pc = cp.getPhysicalContacts().get(0);
	        compareDbToApi_String("physicalAddressTypeCode", pc.getPhysicalAddressTypeCode(), getCustomerContact[0].getSTDPHYADDRTYPECD());
	        compareDbToApi_String("addressLine1", pc.getAddressLine1(), getCustomerContact[0].getADDRLINE1());
	        compareDbToApi_String("addressLine2", pc.getAddressLine2(), getCustomerContact[0].getADDRLINE2());
	        compareDbToApi_String("addressLine3", pc.getAddressLine3(), getCustomerContact[0].getADDRLINE3());
	        compareDbToApi_String("addressLine4", pc.getAddressLine4(), getCustomerContact[0].getADDRLINE4());
	        compareDbToApi_String("addressLine5", pc.getAddressLine5(), getCustomerContact[0].getADDRLINE5());
	        compareDbToApi_String("countryCode", pc.getCountryCode(), getCustomerContact[0].getCOUNTRYCD());
	        compareDbToApi_String("postalCode", pc.getPostalCode(), getCustomerContact[0].getPOSTALCD());
	        compareDbToApi_String("primaryAddressFlag", pc.getPrimaryAddressFlag(), "Y");
			writeToLogFile("=============================================================================");
	        writeToLogFile("RecordCustomerContactRequest().coreParty().electronicContacts()");
	        writeToLogFile("=============================================================================");
			ElectronicContact ec = cp.getElectronicContacts().get(0);
			compareDbToApi_String("electronicAddressTypeCode", ec.getElectronicAddressTypeCode(), getCustomerContact[0].getELECTRONICADDRTYPECD());
			compareDbToApi_String("electronicAddress", ec.getElectronicAddress(), getCustomerContact[0].getELECTRONICADDR());
			
		}else{
            failedStatus = true;
            scenario.write("[ERROR: No Record Found!]");
			writeToLogFile("[ERROR: No Record Found!]");
		}
		
		writeToLogFile("=============================================================================");
        Assert.assertFalse(failedStatus);
        
    
    }

}
