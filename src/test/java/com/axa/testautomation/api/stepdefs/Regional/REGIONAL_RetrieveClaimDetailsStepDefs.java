package com.axa.testautomation.api.stepdefs.Regional;


import com.axa.testautomation.api.stepdefs.BaseStepDefs;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
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
import org.springframework.http.HttpMethod;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.sql.*;
import java.util.Map;
import java.nio.file.Files;
import java.nio.file.Paths;


public class REGIONAL_RetrieveClaimDetailsStepDefs extends BaseStepDefs {

    @Autowired
    private String regionalNitRetrieveClaimDetails;

    @Autowired
    private String sg_MDCAC7QI;
    @Autowired
    private String l_SG_CACHE;
    @Autowired
    private String cachePassword;

    @Autowired
    private String th_MDCAC6QI;
    @Autowired
    private String th_MDCAC7QI;
    @Autowired
    private String l_TH_CACHE;
    @Autowired
    private String g_TH_CUST;
    @Autowired
    private String hk_MDCAC2QI;
    @Autowired
    private String l_HK_CACHE;
    @Autowired
    private String ph_MDCAC2QI;
    @Autowired
    private String l_PH_CACHE;


    private String claimNumber;
    private String policyNumber;
    private String axaEntity;
    private JSONArray json;
    private JSONArray jsonLFPWPC;
    private JSONArray jsonLFPDTHCL;
    private JSONArray jsonLFPLIC;
    private JSONArray jsonLFPBNFYINFF;
    private int cntLife;

    @Given("the following http headers are set Retrieve Claim Details")
    public void set_http_headers(DataTable dt) {
        failedStatus = false;
        httpHeaders.clear();
        writeToLogFile("====== HEADERS ======");
        for(Map<String, String> row : dt.asMaps()) {
            for(Map.Entry<String, String> headerMap : row.entrySet()) {
                httpHeaders.set(headerMap.getKey(), headerMap.getValue());
                writeToLogFile(headerMap.getKey() + ": " + headerMap.getValue());
                if(headerMap.getKey().equalsIgnoreCase("x-axa-entity")){
                    axaEntity = headerMap.getValue();
                }
            }
        }
        writeToLogFile("=====================");
    }


    @And("the following GET input parameters are set for Retrieve Claim Details")
    public void set_get_parameters(DataTable dt) {
        failedStatus = false;
        getParameters = "?";
        for(Map<String, String> row : dt.asMaps()) {
            for(Map.Entry<String, String> getParametersMap : row.entrySet()) {
                if(getParametersMap.getKey().equalsIgnoreCase("claimNumber")){
                    regionalNitRetrieveClaimDetails = regionalNitRetrieveClaimDetails.replace("{claimNumber}", getParametersMap.getValue());
                } else {
                    getParameters = getParameters + getParametersMap.getKey() + "=" + getParametersMap.getValue() + "&";
                }

                switch (getParametersMap.getKey()){
                    case "claimNumber": claimNumber = getParametersMap.getValue(); break;
                    case "policyNumber": policyNumber = getParametersMap.getValue(); break;
                }
            }
        }
        getParameters = getParameters.substring(0, getParameters.length()-1);
        writeToLogFile("PARAMETER: " + getParameters);
    }

    @When("the api call has been made for Retrieve Claim Details")
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

            if(System.getProperty("isCitrix")!=null) {
                restTemplate = new RestTemplate();
            }else{
                restTemplate = new RestTemplate(requestFactory);
            }
            String url = regionalNitRetrieveClaimDetails + getParameters;
            writeToLogFile("ENDPOINT: " + regionalNitRetrieveClaimDetails);
            HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
            response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            writeToLogFile("[API Response]");
            writeToLogFile(response.getBody());
        }
        catch (HttpClientErrorException | HttpServerErrorException e) {
            actualHttpErrorCode = Integer.toString(e.getStatusCode().value());
            actualHttpErrorPhrase = e.getStatusCode().getReasonPhrase();
            actualHttpErrorBody = e.getResponseBodyAsString().replaceAll("\n","");
            writeToLogFile("[API Response]");
            writeToLogFile(actualHttpErrorBody);
        }

    }

    @When("the Stored Procedure is called for Retrieve Claim Details")
    public void call_stored_procedure(){

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

        String dbConnection = "";
        String userName = "";
        String password = "";
        try{
            //step1 load the driver class
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //step2 create  the connection object
            switch (axaEntity.toLowerCase()){
                case "sg": dbConnection = sg_MDCAC7QI;
                    userName = l_SG_CACHE;
                    password = cachePassword;
                    break;
                case "th": dbConnection = th_MDCAC6QI;
                    userName = l_TH_CACHE;
                    password = cachePassword;
                    break;
                case "hk": dbConnection = hk_MDCAC2QI;
                    userName = l_HK_CACHE;
                    password = cachePassword;
                    break;
                case "ph": dbConnection = ph_MDCAC2QI;
                    userName = l_PH_CACHE;
                    password = cachePassword;
                    break;
            }

            writeToLogFile("====== DB Connection ======");
            String[] dbConn = dbConnection.split("/");
            writeToLogFile("Host/Port: " + dbConn[0]);
            writeToLogFile("Service: " + dbConn[1]);
            writeToLogFile("Schema: " + userName);
            //writeToLogFile("Password: " + password);
            Connection con=DriverManager.getConnection(
                    "jdbc:oracle:thin:@//"+dbConnection,userName,password);
            writeToLogFile("===========================");

            String text = "SELECT COUNT(*) FROM MR_LFPCLM WHERE CLCLM = '%claimNumber%' AND CLPNO = '%policyNumber%'";
            String query = text.replace("%claimNumber%", claimNumber).replace("%policyNumber%", policyNumber);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            cntLife = rs.getInt(1);

            String filename = "src/sql/Regional/retrieveClaimDetails/retrieveClaimDetails_LFPCLMH.txt";
            if(cntLife == 1) filename = "src/sql/Regional/retrieveClaimDetails/retrieveClaimDetails_LFPCLM.txt";
            text = new String(Files.readAllBytes(Paths.get(filename)));
            query = text.replace("%claimNumber%", claimNumber).replace("%policyNumber%", policyNumber);
            writeToLogFile("[SQL Query]");
            writeToLogFile(query);
            json = executeQuery(con, query);

            if(cntLife == 1){
                filename = "src/sql/Regional/retrieveClaimDetails/retrieveClaimDetails_LFPDTHCL.txt";
                text = new String(Files.readAllBytes(Paths.get(filename)));
                query = text.replace("%claimNumber%", claimNumber).replace("%policyNumber%", policyNumber)
                        .replace("DECADJ='%decadj%'", "1=1");
                writeToLogFile("[SQL Query]");
                writeToLogFile(query);
                jsonLFPDTHCL = executeQuery(con, query);

                filename = "src/sql/Regional/retrieveClaimDetails/retrieveClaimDetails_LFPWPC.txt";
                text = new String(Files.readAllBytes(Paths.get(filename)));
                query = text.replace("%claimNumber%", claimNumber).replace("%policyNumber%", policyNumber)
                    .replace("WPCADJ='%wpcadj%'", "1=1");
                writeToLogFile("[SQL Query]");
                writeToLogFile(query);
                jsonLFPWPC = executeQuery(con, query);

                filename = "src/sql/Regional/retrieveClaimDetails/retrieveClaimDetails_LFPLIC.txt";
                text = new String(Files.readAllBytes(Paths.get(filename)));
                query = text.replace("%claimNumber%", claimNumber).replace("%policyNumber%", policyNumber)
                        .replace("LICADJ='%licadj%'", "1=1");
                writeToLogFile("[SQL Query]");
                writeToLogFile(query);
                jsonLFPLIC = executeQuery(con, query);

                filename = "src/sql/Regional/retrieveClaimDetails/retrieveClaimDetails_LFPBNFYINFF.txt";
                text = new String(Files.readAllBytes(Paths.get(filename)));
                query = text.replace("%claimNumber%", claimNumber);
                writeToLogFile("[SQL Query]");
                writeToLogFile(query);
                jsonLFPBNFYINFF = executeQuery(con, query);
            }

        }catch(Exception e){
            failedStatus = true;
            scenario.write(e.toString());
            writeToLogFile(e.toString());
            Assert.assertFalse(failedStatus);

        }
    }
    
    @Then("verify that API and DB responses matched for Retrieve Claim Details")
    public void api_match_db() {
        JsonObject api = new JsonParser().parse(response.getBody()).getAsJsonObject();
        JsonObject db = null;
        JsonObject dbLPFWPC = null;
        JsonObject dbLFPDTHCL = null;
        JsonObject dbLFPLIC = null;
        JsonObject dbLFPBNFYINFF = null;
        try {
            if (json.length() != 0)
            db = new JsonParser().parse(json.get(0).toString()).getAsJsonObject();
            if(cntLife == 1) {
                if (jsonLFPWPC.length() != 0)
                    dbLPFWPC = new JsonParser().parse(jsonLFPWPC.get(0).toString()).getAsJsonObject();
                if (jsonLFPDTHCL.length() != 0)
                    dbLFPDTHCL = new JsonParser().parse(jsonLFPDTHCL.get(0).toString()).getAsJsonObject();
                if (jsonLFPLIC.length() != 0)
                    dbLFPLIC = new JsonParser().parse(jsonLFPLIC.get(0).toString()).getAsJsonObject();
                if (jsonLFPBNFYINFF.length() != 0)
                    dbLFPBNFYINFF = new JsonParser().parse(jsonLFPBNFYINFF.get(0).toString()).getAsJsonObject();
            }
        } catch (JsonSyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        writeToLogFile("[Validations]");
        writeToLogFile("=============================================================================");
        writeToLogFile("RetrieveClaimDetailsResponse().RLSClaim()");
        writeToLogFile("=============================================================================");
        JsonElement a = api.get("RetrieveClaimDetailsResponse").getAsJsonObject().get("RLSClaim");
        JsonElement b = db.getAsJsonObject();
        if (cntLife == 1) {
            compareDbToApi_Integer("claimNumber", b.getAsJsonObject().get("CLCLM"), a.getAsJsonObject().get("claimNumber"));
        } else {
        	compareDbToApi_Integer("claimNumber", b.getAsJsonObject().get("HCLMNO"), a.getAsJsonObject().get("claimNumber"));
        }
        compareDbToApi_String("entityCode", axaEntity, a.getAsJsonObject().get("entityCode"));
        if (cntLife == 1) {
            compareDbToApi_String("claimTypeCode", b.getAsJsonObject().get("CLTYPE"), a.getAsJsonObject().get("claimTypeCode"));
        } else {
            compareDbToApi_String("claimTypeCode", b.getAsJsonObject().get("HCTYPE"), a.getAsJsonObject().get("claimTypeCode"));
        }
        compareDbToApi_Timestamp_DatePart("claimCloseDate", b.getAsJsonObject().get("COMPLETION_DATE"), a.getAsJsonObject().get("claimCloseDate"));
        compareDbToApi_Timestamp_DatePart("lossReportDate", b.getAsJsonObject().get("SUBMISSION_DATE"), a.getAsJsonObject().get("lossReportDate"));
        if (cntLife == 1) {
            compareDbToApi_String("claimStatusCode", b.getAsJsonObject().get("CLSTU"), a.getAsJsonObject().get("claimStatusCode"));
        }else{
            compareDbToApi_String("claimStatusCode", b.getAsJsonObject().get("HCSTU"), a.getAsJsonObject().get("claimStatusCode"));
        }
        if (cntLife == 1) {
            compareDbToApi_String("claimCurrencyCode", b.getAsJsonObject().get("CLSCCY"), a.getAsJsonObject().get("claimCurrencyCode"));
        }else {
            compareDbToApi_String("claimCurrencyCode", b.getAsJsonObject().get("HCCCY"), a.getAsJsonObject().get("claimCurrencyCode"));
        }
        if (cntLife == 1) {
            if(!axaEntity.equalsIgnoreCase("SG")){
            	compareDbToApi_Integer("totalPaidAmount", b.getAsJsonObject().get("CLPAY"), a.getAsJsonObject().get("totalPaidAmount"));
            }else {
            	compareDbToApi_Decimal("totalPaidAmount", b.getAsJsonObject().get("CLPAY"), a.getAsJsonObject().get("totalPaidAmount"));
            }
        }else {
            if(!axaEntity.equalsIgnoreCase("SG")){
            	compareDbToApi_Integer("totalPaidAmount", b.getAsJsonObject().get("TOT_PAID_AMOUNT"), a.getAsJsonObject().get("totalPaidAmount"));
            }else {
            	compareDbToApi_Decimal("totalPaidAmount", b.getAsJsonObject().get("TOT_PAID_AMOUNT"), a.getAsJsonObject().get("totalPaidAmount"));
            }
        }
        if (cntLife == 1) {
            compareDbToApi_Timestamp_DatePart("admissionDate", b.getAsJsonObject().get("CLAIM_PERIOD_FROM"), a.getAsJsonObject().get("admissionDate"));
        }else {
        	compareDbToApi_Timestamp_DatePart("admissionDate", b.getAsJsonObject().get("ADMISSION_DATE"), a.getAsJsonObject().get("admissionDate"));
        	compareDbToApi_Timestamp_DatePart("dischargeDate", b.getAsJsonObject().get("DATE_OF_DISCHARGE"), a.getAsJsonObject().get("dischargeDate"));
        }
        if (cntLife == 1) {
            compareDbToApi_String("policyNumber", b.getAsJsonObject().get("CLPNO"), a.getAsJsonObject().get("policyNumber"));
        }else {
            compareDbToApi_String("policyNumber", b.getAsJsonObject().get("PNO"), a.getAsJsonObject().get("policyNumber"));
        }
        if (cntLife == 1) {
            compareDbToApi_Integer("claimAdjustmentNumber", b.getAsJsonObject().get("CLADJ"), a.getAsJsonObject().get("claimAdjustmentNumber"));
            compareDbToApi_Timestamp_DatePart("claimPeriodFrom", b.getAsJsonObject().get("CLAIM_PERIOD_FROM"), a.getAsJsonObject().get("claimPeriodFrom"));
            compareDbToApi_Timestamp_DatePart("claimPeriodTo", b.getAsJsonObject().get("CLAIM_PERIOD_TO"), a.getAsJsonObject().get("claimPeriodTo"));
            compareDbToApi_String("diagnosisCode1", b.getAsJsonObject().get("CLDIA1"), a.getAsJsonObject().get("diagnosisCode1"));
            compareDbToApi_String("claimStatusDescription", b.getAsJsonObject().get("CLSTU"), a.getAsJsonObject().get("claimStatusDescription"));
            if(a.getAsJsonObject().get("deductedPremiumAmount")!=null){
                if (dbLFPDTHCL!=null){
                    JsonElement c = dbLFPDTHCL.getAsJsonObject();
                    if(axaEntity.equalsIgnoreCase("HK") || axaEntity.equalsIgnoreCase("PH")) {
                        compareDbToApi_Integer("deductedPremiumAmount", c.getAsJsonObject().get("PREM_AMT_DUE"), a.getAsJsonObject().get("deductedPremiumAmount"));
                    }else{
                        compareDbToApi_String("deductedPremiumAmount", c.getAsJsonObject().get("PREM_AMT_DUE"), a.getAsJsonObject().get("deductedPremiumAmount"));
                    }
                }else {
                    if(axaEntity.equalsIgnoreCase("HK") || axaEntity.equalsIgnoreCase("PH") || axaEntity.equalsIgnoreCase("TH")) {
                    	compareDbToApi_Integer("deductedPremiumAmount", 0, a.getAsJsonObject().get("deductedPremiumAmount"));
                    /*}else if (axaEntity.equalsIgnoreCase("SG")) {
                    	compareDbToApi_Decimal("deductedPremiumAmount", 0.00, a.getAsJsonObject().get("deductedPremiumAmount"));*/
                    } else {
                        compareDbToApi_String("deductedPremiumAmount", "", a.getAsJsonObject().get("deductedPremiumAmount"));
                    }
                }
            }
            if(a.getAsJsonObject().get("longTermDisabilityFlag")!=null){
                if (dbLPFWPC!=null){
                    JsonElement c = dbLPFWPC.getAsJsonObject();
                    compareDbToApi_String("longTermDisabilityFlag", c.getAsJsonObject().get("WPCLTD"), a.getAsJsonObject().get("longTermDisabilityFlag"));
                }else {
                    compareDbToApi_String("longTermDisabilityFlag", "", a.getAsJsonObject().get("longTermDisabilityFlag"));
                }
            }
        }else {

        	compareDbToApi_Timestamp_DatePart("claimPaymentDate", b.getAsJsonObject().get("PAYMENT_DATE"), a.getAsJsonObject().get("claimPaymentDate"));
            compareDbToApi_Timestamp_DatePart("claimTransactionDate", b.getAsJsonObject().get("TRANSACTION_DATE"), a.getAsJsonObject().get("claimTransactionDate"));
            compareDbToApi_String("productTypeCode", b.getAsJsonObject().get("PRODUCT_TYPE"), a.getAsJsonObject().get("productTypeCode"));
            compareDbToApi_String("hospitalCode", b.getAsJsonObject().get("HOSPITAL_CODE"), a.getAsJsonObject().get("hospitalCode"));
            if(!axaEntity.equalsIgnoreCase("SG")){
                compareDbToApi_Integer("claimOtherTotalAmount", b.getAsJsonObject().get("OTH_INS_TOTAL_AMT"), a.getAsJsonObject().get("claimOtherTotalAmount"));
            }else {
                compareDbToApi_Decimal("claimOtherTotalAmount", b.getAsJsonObject().get("OTH_INS_TOTAL_AMT"), a.getAsJsonObject().get("claimOtherTotalAmount"));
            }
            compareDbToApi_String("surgicalCode", b.getAsJsonObject().get("SURGICAL_CODE"), a.getAsJsonObject().get("surgicalCode"));
            compareDbToApi_String("languageCode", b.getAsJsonObject().get("CN_LANGUAGE"), a.getAsJsonObject().get("languageCode"));
            compareDbToApi_String("sameDisabilityFlag", b.getAsJsonObject().get("SAME_DISABILITY_FLAG"), a.getAsJsonObject().get("sameDisabilityFlag"));
        }
        if(a.getAsJsonObject().get("assessorName")!=null)
            if (cntLife == 1) {
                compareDbToApi_String("assessorName", b.getAsJsonObject().get("CLASOR"), a.getAsJsonObject().get("assessorName"));
            }else {
                compareDbToApi_String("assessorName", b.getAsJsonObject().get("ASSESSOR_NAME"), a.getAsJsonObject().get("assessorName"));
            }

        if (cntLife == 1) {
            //claimBeneficiaryPayment
            if(dbLFPBNFYINFF!=null){
                JsonObject d = null;
                for (int i=0; i<jsonLFPBNFYINFF.length(); i++) {
                    try {
                        d = new JsonParser().parse(jsonLFPBNFYINFF.get(i).toString()).getAsJsonObject();
                    } catch (JsonSyntaxException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    if (a.getAsJsonObject().get("claimBeneficiaryPayments") != null) {
                        writeToLogFile("=============================================================================");
                        writeToLogFile("RetrieveClaimDetailsResponse().RLSClaim().claimBeneficiaryPayments[" + i + "]");
                        writeToLogFile("=============================================================================");
                        JsonElement cbp = a.getAsJsonObject().get("claimBeneficiaryPayments").getAsJsonArray().get(i);
                        compareDbToApi_String("totalPendingAmount", d.getAsJsonObject().get("AMT_PENDING"), cbp.getAsJsonObject().get("totalPendingAmount"));
                        compareDbToApi_String("lastPaymentDate", d.getAsJsonObject().get("LAST_PAYMENT_DATE"), cbp.getAsJsonObject().get("lastPaymentDate"));
                      //TODO get mapping for recordIncident fields
                        compareDbToApi_Decimal("recordIncidentAmount", d.getAsJsonObject().get("REC_INCIDENT_PAID"), cbp.getAsJsonObject().get("recordIncidentAmount"));
                        compareDbToApi_Decimal("recordIncidentInterestAmount", d.getAsJsonObject().get("REC_INCIDENT_PAID"), cbp.getAsJsonObject().get("recordIncidentInterestAmount"));
                        writeToLogFile("=============================================================================");
                        writeToLogFile("RetrieveClaimDetailsResponse().RLSClaim().claimBeneficiaryPayments[" + i + "].beneficiaries[0]");
                        writeToLogFile("=============================================================================");
                        JsonElement bnf = cbp.getAsJsonObject().get("beneficiaries").getAsJsonArray().get(0);
                        compareDbToApi_Integer("beneficiaryAllocationPercentage", d.getAsJsonObject().get("PERCENTAGE"), bnf.getAsJsonObject().get("beneficiaryAllocationPercentage"));
                    }
                }

            }else{
                if(a.getAsJsonObject().get("claimBeneficiaryPayments")!=null) {
                    writeToLogFile("=============================================================================");
                    writeToLogFile("RetrieveClaimDetailsResponse().RLSClaim().claimBeneficiaryPayments[0]");
                    writeToLogFile("=============================================================================");
                    JsonElement cbp = a.getAsJsonObject().get("claimBeneficiaryPayments").getAsJsonArray().get(0);
                    compareDbToApi_String("totalPendingAmount", "", cbp.getAsJsonObject().get("totalPendingAmount"));
                    compareDbToApi_String("lastPaymentDate", "", cbp.getAsJsonObject().get("lastPaymentDate"));
                    //TODO get mapping for recordIncident fields
                    compareAPItoDB("recordIncidentAmount", null, cbp.getAsJsonObject().get("recordIncidentAmount"));
                    compareAPItoDB("recordIncidentInterestAmount", null, cbp.getAsJsonObject().get("recordIncidentInterestAmount"));
                    writeToLogFile("=============================================================================");
                    writeToLogFile("RetrieveClaimDetailsResponse().RLSClaim().claimBeneficiaryPayments[0].beneficiaries[0]");
                    writeToLogFile("=============================================================================");
                    JsonElement bnf = cbp.getAsJsonObject().get("beneficiaries").getAsJsonArray().get(0);
                    compareDbToApi_String("beneficiaryAllocationPercentage", "", bnf.getAsJsonObject().get("beneficiaryAllocationPercentage"));
                }
            }

            //claimBenefits
            if(dbLFPLIC!=null){

            }else{
                String benefitName = "";
                String claimedBenefitAmount = "";
                String claimedBenefitMonthCount = "";
                String paidBenefitMonthCount = "";
                for(int i=0;i<7;i++) {
                    switch (i){
                        case 0: benefitName = "Major Illness Benefit";
                            claimedBenefitAmount = "%AXAAsia_BusinessAPI_Claim_Life.doc.pub:retrieveClaimDetailsResponseForLFPLIC/results/LICBNF%";
                            break;
                        case 1: benefitName = "Minor Illness Benefit";
                            claimedBenefitAmount = "%AXAAsia_BusinessAPI_Claim_Life.doc.pub:retrieveClaimDetailsResponseForLFPLIC/results/LIMIBNF%";
                            break;
                        case 2: benefitName = "Bonus Amount";
                            claimedBenefitAmount = "%AXAAsia_BusinessAPI_Claim_Life.doc.pub:retrieveClaimDetailsResponseForLFPLIC/results/LIBONUS%";
                            break;
                        case 3: benefitName = "Record Interest";
                            claimedBenefitAmount = "%AXAAsia_BusinessAPI_Claim_Life.doc.pub:retrieveClaimDetailsResponseForLFPLIC/results/LICRIP%";
                            break;
                        case 4: benefitName = "Benefit Payable";
                            claimedBenefitAmount = "%AXAAsia_BusinessAPI_Claim_Life.doc.pub:retrieveClaimDetailsResponseForLFPLIC/results/LICSI%";
                            break;
                        case 5: benefitName = "Advance PTD Amount";
                            claimedBenefitAmount = "%AXAAsia_BusinessAPI_Claim_Life.doc.pub:retrieveClaimDetailsResponseForLFPWPC/results/WPCAAM%";
                            claimedBenefitMonthCount = "%AXAAsia_BusinessAPI_Claim_Life.doc.pub:retrieveClaimDetailsResponseForLFPWPC/results/WPCAMN%";
                            break;
                        case 6: benefitName = "Refund Premium Amount";
                            claimedBenefitAmount = "%AXAAsia_BusinessAPI_Claim_Life.doc.pub:retrieveClaimDetailsResponseForLFPWPC/results/WPCRAM%";
                            paidBenefitMonthCount = "%AXAAsia_BusinessAPI_Claim_Life.doc.pub:retrieveClaimDetailsResponseForLFPWPC/results/WPCRMN%";
                            break;
                    }
                    writeToLogFile("=============================================================================");
                    writeToLogFile("RetrieveClaimDetailsResponse().RLSClaim().claimBenefits[" + i + "]");
                    writeToLogFile("=============================================================================");
                    JsonElement cb = a.getAsJsonObject().get("claimBenefits").getAsJsonArray().get(i);
                    compareDbToApi_String("benefitName", benefitName, cb.getAsJsonObject().get("benefitName"));
                    if(axaEntity.equalsIgnoreCase("HK") || axaEntity.equalsIgnoreCase("PH")){
                        compareDbToApi_String("claimedBenefitAmount", claimedBenefitAmount, cb.getAsJsonObject().get("claimedBenefitAmount"));
                    }else {
                        compareDbToApi_String("claimedBenefitAmount", "", cb.getAsJsonObject().get("claimedBenefitAmount"));
                    }
                    if(i==5)
                        if(axaEntity.equalsIgnoreCase("HK") || axaEntity.equalsIgnoreCase("PH")){
                            compareDbToApi_String("claimedBenefitMonthCount", claimedBenefitMonthCount, cb.getAsJsonObject().get("claimedBenefitMonthCount"));
                        }else {
                            compareDbToApi_String("claimedBenefitMonthCount", "", cb.getAsJsonObject().get("claimedBenefitMonthCount"));
                        }
                    if(i==6)
                        if(axaEntity.equalsIgnoreCase("HK") || axaEntity.equalsIgnoreCase("PH")){
                            compareDbToApi_String("paidBenefitMonthCount", paidBenefitMonthCount, cb.getAsJsonObject().get("paidBenefitMonthCount"));
                        }else {
                            compareDbToApi_String("paidBenefitMonthCount", "", cb.getAsJsonObject().get("paidBenefitMonthCount"));
                        }
                }
            }
        }

        writeToLogFile("=============================================================================\n");
        Assert.assertFalse(failedStatus);
    }

}
