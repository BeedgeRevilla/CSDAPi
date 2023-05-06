package com.axa.testautomation.api.stepdefs.Regional;


import com.axa.testautomation.api.as400.components.TerminalDriver;
import com.axa.testautomation.api.as400.pages.*;
import com.axa.testautomation.api.regional.RecordReceiptIssuance.payload.*;
import com.axa.testautomation.api.regional.RecordReceiptIssuance.response.*;

import com.axa.testautomation.api.stepdefs.BaseStepDefs;
import com.axa.testautomation.api.stepdefs.CommonStepDefs;
import com.google.gson.Gson;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
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
import java.text.SimpleDateFormat;
import java.util.Map;


public class REGIONAL_RecordReceiptIssuanceStepDefs extends BaseStepDefs {

    @Autowired
    private String regionalNitRecordReceiptIssuance;
    @Autowired
    private TerminalDriver PSEA_TerminalDriver;
    @Autowired
    private String PSEA_SG_Username;
    @Autowired
    private String PSEA_SG_Password;
    @Autowired
    private String PSEA_MY_Username;
    @Autowired
    private String PSEA_MY_Password;
    
    private String payload;
    private String msgId;
    private String axaEntity;
    private String username;
    private String password;
    private int waitTime = 2000;

    private SignOnScreen signOnScreen;
    private SystemMasterMenuScreen systemMasterMenuScreen;
    private Receipts_and_Payments receipts_and_payments;
    private Cash_Receipt_Submenu cash_receipt_submenu;
    private Command_Entry command_entry;

    private CreateReceiptRequestPayload createReceiptRequestPayload;
    private CreateReceiptResponseContainer createReceiptResponseContainer;

    @Given("the following http headers are set Record Receipt Issuance")
    public void set_http_headers(DataTable dt) {
        failedStatus = false;
        httpHeaders.clear();
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new java.util.Date());
        writeToLogFile("====== HEADERS ======");
        for(Map<String, String> row : dt.asMaps()) {
            for(Map.Entry<String, String> headerMap : row.entrySet()) {
            	if(headerMap.getKey().equalsIgnoreCase("X-Axa-MsgId") || 
            			headerMap.getKey().equalsIgnoreCase("X-Axa-InitialMsgId")) {
            		if(headerMap.getValue().equalsIgnoreCase("[$autogen]")){
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

                if(headerMap.getKey().equalsIgnoreCase("X-Axa-Entity")){
                    axaEntity = headerMap.getValue();
                }
            }
        }
        
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        writeToLogFile("=====================");
    }

    private String receiptNumber;
    private String bankCode;
    private String currency;
    private String branchCode;
    private String partyId;
    private String policyNumber;

    @Given("the following PAYLOAD request body is set for Record Receipt Issuance")
    public void set_payload(DataTable dt) {
        failedStatus = false;
        payload = "";

        try {
            writeToLogFile("====== PAYLOAD ======");
            String filename = "src/payload/Regional/recordReceiptIssuance/recordReceiptIssuance_template.txt";
            payload = new String(Files.readAllBytes(Paths.get(filename)));

            for(Map<String, String> row : dt.asMaps()) {
                for(Map.Entry<String, String> headerMap : row.entrySet()) {
                    payload = payload.replace("%"+headerMap.getKey()+"%", headerMap.getValue());

                    switch (headerMap.getKey()){
                        //case "receiptNumber": receiptNumber = headerMap.getValue(); break;
                        case "bankCode": bankCode = headerMap.getValue(); break;
                        case "currency": currency = headerMap.getValue(); break;
                        case "branchCode": branchCode = headerMap.getValue(); break;
                        case "partyId": partyId = headerMap.getValue(); break;
                        case "policyNumber": policyNumber = headerMap.getValue(); break;
                    }
                }
            }

            if(branchCode.equalsIgnoreCase("")){
                String strReplace = ",\n" +
                        "        \"Account\": [\n" +
                        "          {\n" +
                        "            \"PSEADebitAccounts\": {\n" +
                        "              \"branchCode\": \"\"\n" +
                        "            }\n" +
                        "          }\n" +
                        "        ]";
                payload = payload.replace(strReplace, "");
            }

            try {
                receiptNumber = getReceiptNumber(bankCode);
                if(receiptNumber.equalsIgnoreCase("")){
                    failedStatus = true;
                    writeToLogFile("Receipt Number not generated - [FAILED]");
                    scenario.write("Receipt Number not generated - [FAILED]");
                    writeToLogFile("=============================================================================\n");
                    Assert.assertFalse(failedStatus);
                }
                payload = payload.replace("%receiptNumber%", receiptNumber);
            } catch (Exception e) {
                e.printStackTrace();
            }

            writeToLogFile(payload);
            Gson gson = new Gson();
            createReceiptRequestPayload = gson.fromJson(payload.toString(), CreateReceiptRequestPayload.class);
            writeToLogFile("=====================");

        } catch (IOException e) {
            failedStatus = true;
            writeToLogFile(e.getMessage());
            scenario.write(e.getMessage());
            writeToLogFile("=============================================================================\n");
            Assert.assertFalse(failedStatus);
        }
    }
    
    @When("the api call has been made for Record Receipt Issuance")
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
            String url = regionalNitRecordReceiptIssuance;
            writeToLogFile("ENDPOINT: " + url);
            HttpEntity<String> entity = new HttpEntity<>(payload, httpHeaders);
            response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
            writeToLogFile("[API Response]");
            writeToLogFile(response.getBody());
            
            Gson gson = new Gson();
            createReceiptResponseContainer = gson.fromJson(response.getBody(), CreateReceiptResponseContainer.class);
        }
        catch (HttpClientErrorException | HttpServerErrorException e) {
            actualHttpErrorCode = Integer.toString(e.getStatusCode().value());
            actualHttpErrorPhrase = e.getStatusCode().getReasonPhrase();
            actualHttpErrorBody = e.getResponseBodyAsString().replaceAll("\n","");
            writeToLogFile("[API Response]");
            writeToLogFile(actualHttpErrorBody);
        }
    }
    
    @Then("verify that API response matches for Record Receipt Issuance")
    public void verify_api_response(DataTable dt) {
    	if(response == null){
            failedStatus = true;
            scenario.write("[API Response]");
            scenario.write(actualHttpErrorBody);
            writeToLogFile("=============================================================================\n");
            Assert.assertFalse(failedStatus);
        }

        if(response.getBody().contains("exception")){
            failedStatus = true;
            scenario.write("[API Response]");
            scenario.write(response.getBody());
            Assert.assertFalse(failedStatus);
        }
    	
        String sourceMsgId = msgId;
        String contextId = createReceiptRequestPayload.getCreateReceiptRequest().getReceipt().getReceiptNumber();
        String status = "";
        
        for(Map<String, String> row : dt.asMaps()) {
            for(Map.Entry<String, String> headerMap : row.entrySet()) {
            	switch (headerMap.getKey()){
                    case "status": status = headerMap.getValue(); break;
            	}
            }
        }

        writeToLogFile("[Validations]");
        writeToLogFile("=============================================================================");
        writeToLogFile("CreateReceiptResponse().ackResponse()");
        writeToLogFile("=============================================================================");
        AckResponse ar = createReceiptResponseContainer.getCreateReceiptResponse().getAckResponse();
        compareDbToApi_String("contextID", contextId, ar.getContextID());
        compareDbToApi_String("sourceMsgID", sourceMsgId, ar.getSourceMsgID());
        compareDbToApi_String("status", status, ar.getStatus());
        
        writeToLogFile("=============================================================================\n");
		Assert.assertFalse(failedStatus);
    }

    @And("verify that the records are matching in PSEA for Record Receipt Issuance")
    public void verifyThatTheRecordsAreMatchingInPSEAForRecordReceiptIssuance() throws Exception{

        writeToLogFile("[PSEA Validations]");
        if (!PSEA_TerminalDriver.isConnected()) {
            PSEA_TerminalDriver.connect();
            Thread.sleep(waitTime);
            if(PSEA_TerminalDriver.isConnected()) {
                signOnScreen = new SignOnScreen(PSEA_TerminalDriver);
                Thread.sleep(waitTime);
                signOnScreen.setUsername(username);
                Thread.sleep(waitTime);
                signOnScreen.setPassword(password);
                Thread.sleep(waitTime);
                //printScreenDump(PSEA_TerminalDriver.getScreenContent().getLines());
                signOnScreen.pressEnter();
                Thread.sleep(waitTime);
                if (!PSEA_TerminalDriver.getScreenContent().getLine(0).contains("System Master Menu")) {
                    writeToLogFile("\n[ERROR] Unable to connect to PSEA!\n");
                    printScreenDump(PSEA_TerminalDriver.getScreenContent().getLines());
                    PSEA_TerminalDriver.disconnect();
                    Assert.assertFalse(true);
                }
                //printScreenDump(PSEA_TerminalDriver.getScreenContent().getLines());

                systemMasterMenuScreen = new SystemMasterMenuScreen(PSEA_TerminalDriver);
                systemMasterMenuScreen.select_ReceiptsandPayments(axaEntity);
                //printScreenDump(PSEA_TerminalDriver.getScreenContent().getLines());

                receipts_and_payments = new Receipts_and_Payments(PSEA_TerminalDriver);
                receipts_and_payments.select_Receipts(axaEntity);
                //printScreenDump(PSEA_TerminalDriver.getScreenContent().getLines());

                cash_receipt_submenu = new Cash_Receipt_Submenu(PSEA_TerminalDriver);
                cash_receipt_submenu.input_BankCode(bankCode);
                cash_receipt_submenu.input_ReceiptNumber(receiptNumber);
                cash_receipt_submenu.input_Action("C");
                //printScreenDump(PSEA_TerminalDriver.getScreenContent().getLines());
                PSEA_TerminalDriver.sendEnter();
                Thread.sleep(waitTime);
                for (String line : PSEA_TerminalDriver.getScreenContent().getLines()) {
                    if (line.contains("Enter a Valid Receipt No¦")) {
                        failedStatus = true;
                        printScreenDump(scenario, PSEA_TerminalDriver.getScreenContent().getLines());
                        PSEA_TerminalDriver.disconnect();
                        writeToLogFile("Receipt Number " + receiptNumber + " not found! - [FAILED]");
                        writeToLogFile("=============================================================================\n");
                        PSEA_TerminalDriver.disconnect();
                        Assert.assertFalse(true);
                    }
                }
                printScreenDump(PSEA_TerminalDriver.getScreenContent().getLines());
                PSEA_TerminalDriver.sendEnter();
                Thread.sleep(waitTime);
                printScreenDump(PSEA_TerminalDriver.getScreenContent().getLines());
                PSEA_TerminalDriver.disconnect();
            }else{
                writeToLogFile("\n[ERROR] Unable to connect to PSEA!\n");
                failedStatus = true;
                PSEA_TerminalDriver.disconnect();
            }
            writeToLogFile("=============================================================================\n");
            Assert.assertFalse(failedStatus);
        }else{
            writeToLogFile("\n[ERROR] Unable to connect to PSEA!\n");
            writeToLogFile("=============================================================================\n");
            PSEA_TerminalDriver.disconnect();
            Assert.assertFalse(true);
        }

    }


    private String getReceiptNumber(String bankCode) throws Exception {
        String receiptNumber = "";

        switch (axaEntity.toUpperCase()){
            case "SG":
                username = PSEA_SG_Username;
                password = PSEA_SG_Password;
                break;
            case "MY":
                username = PSEA_MY_Username;
                password = PSEA_MY_Password;
                break;
        }

        if (!PSEA_TerminalDriver.isConnected()) {
            PSEA_TerminalDriver.connect();
            Thread.sleep(waitTime);
            if(PSEA_TerminalDriver.isConnected()) {
                signOnScreen = new SignOnScreen(PSEA_TerminalDriver);
                Thread.sleep(waitTime);
                signOnScreen.setUsername(username);
                Thread.sleep(waitTime);
                signOnScreen.setPassword(password);
                Thread.sleep(waitTime);
                signOnScreen.pressEnter();
                Thread.sleep(waitTime);
                if (!PSEA_TerminalDriver.getScreenContent().getLine(0).contains("System Master Menu")) {
                    writeToLogFile("\n[ERROR] Unable to connect to PSEA!\n");
                    printScreenDump(PSEA_TerminalDriver.getScreenContent().getLines());
                    writeToLogFile("=============================================================================\n");
                    PSEA_TerminalDriver.disconnect();
                    Assert.assertFalse(true);
                }

                systemMasterMenuScreen = new SystemMasterMenuScreen(PSEA_TerminalDriver);
                systemMasterMenuScreen.select_ReceiptsandPayments(axaEntity);
                //printScreenDump(PSEA_TerminalDriver.getScreenContent().getLines());
                receipts_and_payments = new Receipts_and_Payments(PSEA_TerminalDriver);
                receipts_and_payments.select_Receipts(axaEntity);
                //printScreenDump(PSEA_TerminalDriver.getScreenContent().getLines());
                cash_receipt_submenu = new Cash_Receipt_Submenu(PSEA_TerminalDriver);
                cash_receipt_submenu.input_BankCode(bankCode);
                //printScreenDump(PSEA_TerminalDriver.getScreenContent().getLines());
                PSEA_TerminalDriver.sendEnter();
                //printScreenDump(PSEA_TerminalDriver.getScreenContent().getLines());
                for (String line : PSEA_TerminalDriver.getScreenContent().getLines()) {
                    if (line.contains("Receipt No")) {
                        receiptNumber = line.substring(13, 21);
                    }
                }
                PSEA_TerminalDriver.sendFunctionKey(3);
                Thread.sleep(waitTime);
                PSEA_TerminalDriver.sendFunctionKey(3);
                Thread.sleep(waitTime);
                //printScreenDump(PSEA_TerminalDriver.getScreenContent().getLines());
                PSEA_TerminalDriver.disconnect();
            }else {
                writeToLogFile("\n[ERROR] Unable to connect to PSEA!\n");
                writeToLogFile("=============================================================================\n");
                PSEA_TerminalDriver.disconnect();
                Assert.assertFalse(true);
            }
        }else{
            writeToLogFile("\n[ERROR] Unable to connect to PSEA!\n");
            writeToLogFile("=============================================================================\n");
            PSEA_TerminalDriver.disconnect();
            Assert.assertFalse(true);
        }

        return receiptNumber;
    }
}
