package com.axa.testautomation.api.stepdefs.Regional;


import com.axa.testautomation.api.regional.RetrievePolicyDetailsLife.response.*;
import com.axa.testautomation.api.regional.RetrievePolicyDetailsLife.dbResult.*;
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
import org.springframework.http.HttpMethod;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Map;


public class REGIONAL_RetrievePolicyDetailsLifeStepDefs extends BaseStepDefs {

    @Autowired
    private String regionalNitRetrievePolicyDetails;
    @Autowired
    private String regionalRetrievePolicyDetailsPPE3;

    @Autowired
    private String sg_MDCAC7QI;
    @Autowired
    private String l_SG_CACHE;
    @Autowired
    private String th_MDCAC7QI;
    @Autowired
    private String l_TH_CACHE;
    @Autowired
    private String hk_MDCRPP2I_204;
    @Autowired
    private String l_HK_CACHE;
    @Autowired
    private String ph_MDCAC2QI;
    @Autowired
    private String l_PH_CACHE;
    @Autowired
    private String cachePassword;

    @Autowired
    private String regionalRetrievePolicyDetailsQA;
    @Autowired
    private String hk_MDCAC2QI;

    @Autowired
    private String regionalRetrievePolicyDetailsSIT;
    @Autowired
    private String th_MDCAC6QI;

    private String endpoint;
    private String dbConnection;
    private String userName;
    private String password;

    private JSONArray jsonHeader;
    private JSONArray jsonMember;

    private String axaEntity;
    private String axaEnv;
    private String policyNumber;
    private RetrievePolicyDetailsResponseContainer retrievePolicyDetailsResponseContainer;
    private GetPolicyDetailsHeaderInfo[] getPolicyDetailsHeaderInfo;
    private GetLFPCCON[] getLFPCCON;
    private GetLFPCS232NI_LFPSTMTR[] getLFPCS232NI_LFPSTMTR;
    private GetTABSTAFF[] getTABSTAFF;
    private GetLFPDCRD[] getLFPDCRD;
    private GetLFPODSAFYP[] getLFPODSAFYP;
    private GetTABPLAN[] getTABPLAN;
    private GetActualServicingAgent[] getActualServicingAgent;
    private GetLFPPOLUS[] getLFPPOLUS;
    private GetLFPCDBPLPC[] getLFPCDBPLPC;
    private GetLFPODSAS[] getLFPODSAS;
    private GetAssignee[] getAssignee;
    private GetCreditCardAuthorization[] getCreditCardAuthorization;
    private GetDebitAccountAuthorization[] getDebitAccountAuthorization;
    private GetChineseProductName[] getChineseProductName;
    private GetAGPODAGTO[] getAGPODAGTO;
    private GetPolicyRider[] getPolicyRider;
    private GetLFPCDBLPIF[] getLFPCDBLPIF;

    @Given("the following http headers are set Retrieve Policy Details Life")
    public void set_http_headers(DataTable dt) {
        failedStatus = false;
        httpHeaders.clear();
        writeToLogFile("====== HEADERS ======");
        for(Map<String, String> row : dt.asMaps()) {
            for(Map.Entry<String, String> headerMap : row.entrySet()) {
                String value = headerMap.getValue();
                if(headerMap.getKey().equalsIgnoreCase("x-axa-entity")) {
                    axaEntity = headerMap.getValue();
                }
                if(headerMap.getKey().equalsIgnoreCase("x-axa-env")) {
                    axaEnv = headerMap.getValue();
                    switch (headerMap.getValue().toUpperCase()){
                        case "QA6":
                            endpoint = regionalRetrievePolicyDetailsQA; break;
                        case "SIT":
                            value = "";
                            endpoint = regionalRetrievePolicyDetailsSIT; break;
                        case "PPE3":
                            value = "";
                            endpoint = regionalRetrievePolicyDetailsPPE3; break;
                        default:
                            endpoint = regionalNitRetrievePolicyDetails; break;
                    }
                }
                httpHeaders.set(headerMap.getKey(), value);
                writeToLogFile(headerMap.getKey() + ": " + value);
            }
        }
        writeToLogFile("=====================");
    }


    @And("the following GET input parameters are set for Retrieve Policy Details Life")
    public void set_get_parameters(DataTable dt) {
        failedStatus = false;
        getParameters = "?";

        for(Map<String, String> row : dt.asMaps()) {
            for(Map.Entry<String, String> getParametersMap : row.entrySet()) {
                if(getParametersMap.getKey().equalsIgnoreCase("policyNumber")){
                    endpoint = endpoint.replace("{policyNumber}", getParametersMap.getValue());
                } else {
                    if(getParametersMap.getKey().equalsIgnoreCase("resourceID")){
                        getParameters = getParameters + "policyNumber=" + getParametersMap.getValue() + "&";
                    }else {
                        getParameters = getParameters + getParametersMap.getKey() + "=" + getParametersMap.getValue() + "&";
                    }
                }

                switch (getParametersMap.getKey()){
                    case "policyNumber": policyNumber = getParametersMap.getValue(); break;
                }
            }
        }
        getParameters = getParameters.substring(0, getParameters.length()-1);
        writeToLogFile("PARAMETER: " + getParameters);
    }

    @When("the api call has been made for Retrieve Policy Details Life")
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

            if(endpoint.startsWith("http://")){
                restTemplate = new RestTemplate();
            }else {
                if (System.getProperty("isCitrix") != null) {
                    restTemplate = new RestTemplate();
                } else {
                    restTemplate = new RestTemplate(requestFactory);
                }
            }
            String url = endpoint + getParameters;
            writeToLogFile("ENDPOINT: " + endpoint);
            HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
            response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            writeToLogFile("[API Response]");
            writeToLogFile(response.getBody());

            Gson gson = new Gson();
            retrievePolicyDetailsResponseContainer = gson.fromJson(response.getBody(), RetrievePolicyDetailsResponseContainer.class);
        }
        catch (HttpClientErrorException | HttpServerErrorException e) {
            actualHttpErrorCode = Integer.toString(e.getStatusCode().value());
            actualHttpErrorPhrase = e.getStatusCode().getReasonPhrase();
            actualHttpErrorBody = e.getResponseBodyAsString().replaceAll("\n","");
            writeToLogFile("[API Response]");
            writeToLogFile(actualHttpErrorBody);
        }
    }

    @When("the Stored Procedure is called for Retrieve Policy Details Life")
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

        String filename = "";
        String text = "";
        String query = "";
        try{
            //step1 load the driver class
            Class.forName("oracle.jdbc.driver.OracleDriver");

            switch (axaEntity.toLowerCase()){
                case "sg": dbConnection = sg_MDCAC7QI;
                   userName = l_SG_CACHE;
                   password = cachePassword;
                   break;
                case "th":
                    if(axaEnv.equalsIgnoreCase("SIT")){
                        dbConnection = th_MDCAC6QI;
                    }else {
                        dbConnection = th_MDCAC7QI;
                    }
                   userName = l_TH_CACHE;
                   password = cachePassword;
                   break;
                case "hk":
                    if(axaEnv.equalsIgnoreCase("QA6")){
                        dbConnection = hk_MDCAC2QI;
                    }else {
                        dbConnection = hk_MDCRPP2I_204;
                    }
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

            //header
            filename = "src/sql/Regional/retrievePolicyDetails_Life/getPolicyDetailsHeaderInfo_20200107.txt";
            text = new String(Files.readAllBytes(Paths.get(filename)));
            query = text.replace("%policyNumber%", policyNumber);
            writeToLogFile("[SQL Query]");
            writeToLogFile(query);
            JSONArray jsonHeader = executeQuery(con, query);
            Gson gson = new Gson();
            getPolicyDetailsHeaderInfo = gson.fromJson(jsonHeader.toString(), GetPolicyDetailsHeaderInfo[].class);

            filename = "src/sql/Regional/retrievePolicyDetails_Life/getPolicyDetails_LFPCCONFromLifeByPolicyNumber.txt";
            text = new String(Files.readAllBytes(Paths.get(filename)));
            query = text.replace("%policyNumber%", policyNumber);
            writeToLogFile("[SQL Query]");
            writeToLogFile(query);
            jsonHeader = executeQuery(con, query);
            gson = new Gson();
            getLFPCCON = gson.fromJson(jsonHeader.toString(), GetLFPCCON[].class);

            filename = "src/sql/Regional/retrievePolicyDetails_Life/getPolicyDetails_LFPCS232N1_LFPSTMTRFromLifeByPolicyNumber.txt";
            text = new String(Files.readAllBytes(Paths.get(filename)));
            query = text.replace("%policyNumber%", policyNumber);
            writeToLogFile("[SQL Query]");
            writeToLogFile(query);
            jsonHeader = executeQuery(con, query);
            gson = new Gson();
            getLFPCS232NI_LFPSTMTR = gson.fromJson(jsonHeader.toString(), GetLFPCS232NI_LFPSTMTR[].class);

            filename = "src/sql/Regional/retrievePolicyDetails_Life/getPolicyDetails_TABSTAFFFromLifeByPolicyNumber.txt";
            text = new String(Files.readAllBytes(Paths.get(filename)));
            query = text.replace("%policyNumber%", policyNumber);
            writeToLogFile("[SQL Query]");
            writeToLogFile(query);
            jsonHeader = executeQuery(con, query);
            gson = new Gson();
            getTABSTAFF = gson.fromJson(jsonHeader.toString(), GetTABSTAFF[].class);

            filename = "src/sql/Regional/retrievePolicyDetails_Life/getPolicyDetailsForLFPDCRDFromLIFEByPolicyDetails.txt";
            text = new String(Files.readAllBytes(Paths.get(filename)));
            query = text.replace("%policyNumber%", policyNumber);
            writeToLogFile("[SQL Query]");
            writeToLogFile(query);
            jsonHeader = executeQuery(con, query);
            gson = new Gson();
            getLFPDCRD = gson.fromJson(jsonHeader.toString(), GetLFPDCRD[].class);

            filename = "src/sql/Regional/retrievePolicyDetails_Life/getPolicyDetailsForLFPODSAFYPFromLIFEByPolicyNumber.txt";
            text = new String(Files.readAllBytes(Paths.get(filename)));
            query = text.replace("%policyNumber%", policyNumber);
            writeToLogFile("[SQL Query]");
            writeToLogFile(query);
            jsonHeader = executeQuery(con, query);
            gson = new Gson();
            getLFPODSAFYP = gson.fromJson(jsonHeader.toString(), GetLFPODSAFYP[].class);

            /*
            filename = "src/sql/Regional/retrievePolicyDetails_Life/getActualServicingAgent.txt";
            text = new String(Files.readAllBytes(Paths.get(filename)));
            query = text.replace("%policyNumber%", policyNumber);
            writeToLogFile("[SQL Query]");
            writeToLogFile(query);
            jsonHeader = executeQuery(con, query);
            gson = new Gson();
            getActualServicingAgent = gson.fromJson(jsonHeader.toString(), GetActualServicingAgent[].class);
            */

            filename = "src/sql/Regional/retrievePolicyDetails_Life/getPolicyDetailsForLFPPOLUSFromLIFEByPolicyNumber.txt";
            text = new String(Files.readAllBytes(Paths.get(filename)));
            query = text.replace("%policyNumber%", policyNumber);
            writeToLogFile("[SQL Query]");
            writeToLogFile(query);
            jsonHeader = executeQuery(con, query);
            gson = new Gson();
            getLFPPOLUS = gson.fromJson(jsonHeader.toString(), GetLFPPOLUS[].class);

            filename = "src/sql/Regional/retrievePolicyDetails_Life/getPolicyDetailsForLFPCDBPLPCFromLIFEByPolicyNumber.txt";
            text = new String(Files.readAllBytes(Paths.get(filename)));
            query = text.replace("%policyNumber%", policyNumber);
            writeToLogFile("[SQL Query]");
            writeToLogFile(query);
            jsonHeader = executeQuery(con, query);
            gson = new Gson();
            getLFPCDBPLPC = gson.fromJson(jsonHeader.toString(), GetLFPCDBPLPC[].class);

            filename = "src/sql/Regional/retrievePolicyDetails_Life/getLFPODSAS.txt";
            text = new String(Files.readAllBytes(Paths.get(filename)));
            query = text.replace("%policyNumber%", policyNumber);
            writeToLogFile("[SQL Query]");
            writeToLogFile(query);
            jsonHeader = executeQuery(con, query);
            gson = new Gson();
            getLFPODSAS = gson.fromJson(jsonHeader.toString(), GetLFPODSAS[].class);

            filename = "src/sql/Regional/retrievePolicyDetails_Life/getAssignee.txt";
            text = new String(Files.readAllBytes(Paths.get(filename)));
            query = text.replace("%policyNumber%", policyNumber);
            writeToLogFile("[SQL Query]");
            writeToLogFile(query);
            jsonHeader = executeQuery(con, query);
            gson = new Gson();
            getAssignee = gson.fromJson(jsonHeader.toString(), GetAssignee[].class);

            filename = "src/sql/Regional/retrievePolicyDetails_Life/getCreditCardAuthorization.txt";
            text = new String(Files.readAllBytes(Paths.get(filename)));
            query = text.replace("%policyNumber%", policyNumber);
            writeToLogFile("[SQL Query]");
            writeToLogFile(query);
            jsonHeader = executeQuery(con, query);
            gson = new Gson();
            getCreditCardAuthorization = gson.fromJson(jsonHeader.toString(), GetCreditCardAuthorization[].class);

            filename = "src/sql/Regional/retrievePolicyDetails_Life/getDebitAccountAuthorization.txt";
            text = new String(Files.readAllBytes(Paths.get(filename)));
            query = text.replace("%policyNumber%", policyNumber);
            writeToLogFile("[SQL Query]");
            writeToLogFile(query);
            jsonHeader = executeQuery(con, query);
            gson = new Gson();
            getDebitAccountAuthorization = gson.fromJson(jsonHeader.toString(), GetDebitAccountAuthorization[].class);

            filename = "src/sql/Regional/retrievePolicyDetails_Life/getPolicyDetails_LFPCDBLPIFfromLifeByPolicyNumber.txt";
            text = new String(Files.readAllBytes(Paths.get(filename)));
            query = text.replace("%policyNumber%", policyNumber);
            writeToLogFile("[SQL Query]");
            writeToLogFile(query);
            jsonHeader = executeQuery(con, query);
            gson = new Gson();
            getLFPCDBLPIF = gson.fromJson(jsonHeader.toString(), GetLFPCDBLPIF[].class);

            //step5 close the connection object
            con.close();

        }catch(Exception e){
            failedStatus = true;
            scenario.write(e.toString());
            writeToLogFile(e.toString());
            Assert.assertFalse(failedStatus);

        }
    }
    
    @Then("verify that API and DB responses matched for Retrieve Policy Details Life")
    public void api_match_db() {
        String filename = "";
        String text = "";
        String query = "";
        Connection con = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con=DriverManager.getConnection(
                    "jdbc:oracle:thin:@//"+dbConnection,userName,password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            Assert.assertFalse(failedStatus);
        }

        writeToLogFile("[Validations]");
        writeToLogFile("=============================================================================");
        writeToLogFile("RetrievePolicyDetailsResponse().RLSPolicy()");
        writeToLogFile("=============================================================================");
        RLSPolicy rp = retrievePolicyDetailsResponseContainer.getRetrievePolicyDetailsResponse().getRLSPolicy();
        GetPolicyDetailsHeaderInfo header = getPolicyDetailsHeaderInfo[0];
        compareDbToApi_String("entityCode", axaEntity, rp.getEntityCode());
        compareDbToApi_String("LOBCode", header.getPOLICYTYPE(), rp.getLOBCode());
        compareDbToApi_Timestamp_DatePart("policyEffectiveDate", header.getPOLICYEFFECTIVEDATE(), rp.getPolicyEffectiveDate());
        compareDbToApi_String("policyNumber", header.getPOLICYNUMBER(), rp.getPolicyNumber());
        compareDbToApi_String("policyStatusCode", header.getPOLICYSTATUS(), rp.getPolicyStatusCode());
        if(header.getPOLICYTERMINATIONDATE().contains("1900-01-01")){
            compareDbToApi_String("policyTerminationDate", "", rp.getPolicyTerminationDate());
        }else {
            compareDbToApi_Timestamp_DatePart("policyTerminationDate", header.getPOLICYTERMINATIONDATE(), rp.getPolicyTerminationDate());
        }
        compareDbToApi_String("producingAgentCode1", header.getPRODUCINGAGENTCD1(), rp.getProducingAgentCode1());
        compareDbToApi_String("policyCurrencyCode", header.getCURRENCY(), rp.getPolicyCurrencyCode());
        compareDbToApi_Timestamp_DatePart("paidToDate", header.getPAIDTODATE(), rp.getPaidToDate());
        compareDbToApi_String("paymentModeCode", header.getPAYMENTMODECD(), rp.getPaymentModeCode());
        if(header.getMODALPREMIUM()!=null)
            compareDbToApi_Decimal("modalPremiumAmount", header.getMODALPREMIUM().toString(), rp.getModalPremiumAmount());
        compareDbToApi_Timestamp_DatePart("policyIssueDate", header.getPOLICYISSUEDATE(), rp.getPolicyIssueDate());
        compareDbToApi_String("producingAgentCode2", header.getPRODUCINGAGENTCD2(), rp.getProducingAgentCode2());
        compareDbToApi_String("servicingAgentCode1", header.getSERVICINGAGENTCD1(), rp.getServicingAgentCode1());
        compareDbToApi_String("servicingAgentCode2", header.getSERVICINGAGENTCD2(), rp.getServicingAgentCode2());


        if(getLFPDCRD.length!=0) {
            writeToLogFile("=============================================================================");
            writeToLogFile("FinancialSummary()");
            writeToLogFile("=============================================================================");
            FinancialSummary fs = rp.getFinancialSummary();
            GetLFPDCRD lfpdcrd = getLFPDCRD[0];
            compareDbToApi_Decimal("totalDFCAmount", lfpdcrd.getTOTAL_DFC_AMT().toString(), fs.getTotalDFCAmount());
            compareDbToApi_Decimal("firstDepositAmount", lfpdcrd.getFIRST_DEPOSITE_AMOUNT(), fs.getFirstDepositAmount());
            compareDbToApi_Timestamp_DatePart("firstSubmissionDate", lfpdcrd.getFIRST_SUBMISSION_DATE(), fs.getFirstSubmissionDate());
        }/*else{
            compareDbToApi_String("totalDFCAmount", "", fs.getTotalDFCAmount());
            compareDbToApi_String("firstDepositAmount", "", fs.getFirstDepositAmount());
            compareDbToApi_Timestamp_DatePart("firstSubmissionDate", "", fs.getFirstSubmissionDate());
        }*/

        for(int i=0; i<rp.getPartyRoles().size(); i++) {
            writeToLogFile("=============================================================================");
            writeToLogFile("partyRoles[" + i + "]");
            writeToLogFile("=============================================================================");
            PartyRole pr = rp.getPartyRoles().get(i);
            if(i==0){
                compareDbToApi_String("partyRoleCode", header.getOWNER_PARTY_ID(), pr.getPartyRoleCode());
                writeToLogFile("=============================================================================");
                writeToLogFile("partyRoles[" + i + "].RLSParty()");
                writeToLogFile("=============================================================================");
                RLSParty rlsp = pr.getRLSParty();
                compareDbToApi_Timestamp_DatePart("birthDate", header.getOWNER_DATE_OF_BIRTH(), rlsp.getBirthDate());
                compareDbToApi_String("genderCode", header.getOWNER_GENDER(), rlsp.getGenderCode());
                compareDbToApi_String("lastName", header.getOWNER_LAST_NAME(), rlsp.getLastName());
                compareDbToApi_String("partyTypeCode", header.getOWNERPARTYTYPCD(), rlsp.getPartyTypeCode());
                compareDbToApi_String("partyId", header.getOWNER_PARTY_ID(), rlsp.getPartyId());
                writeToLogFile("=============================================================================");
                writeToLogFile("partyRoles[" + i + "].RLSParty().partyIdentifiers[0]");
                writeToLogFile("=============================================================================");
                PartyIdentifier pi = rlsp.getPartyIdentifiers().get(0);
                compareDbToApi_String("idDocumentNumber", header.getOWNER_ID_DOC_NUMBER(), pi.getIdDocumentNumber());
                compareDbToApi_String("idDocumentType", header.getIDDOCUMENTTYPE(), pi.getIdDocumentType());
            }
            if(i==1){
                compareDbToApi_String("partyRoleCode", header.getINSRDPARTYID(), pr.getPartyRoleCode());
                writeToLogFile("=============================================================================");
                writeToLogFile("partyRoles[" + i + "].RLSParty()");
                writeToLogFile("=============================================================================");
                RLSParty rlsp = pr.getRLSParty();
                compareDbToApi_Timestamp_DatePart("birthDate", header.getDATEOFBIRTH(), rlsp.getBirthDate());
                compareDbToApi_String("genderCode", header.getGENDER(), rlsp.getGenderCode());
                compareDbToApi_String("lastName", header.getINSRDLASTNAME(), rlsp.getLastName());
                compareDbToApi_String("partyTypeCode", header.getINSRDPARTYTYPCD(), rlsp.getPartyTypeCode());
                compareDbToApi_String("partyId", header.getINSRDPARTYID(), rlsp.getPartyId());
                writeToLogFile("=============================================================================");
                writeToLogFile("partyRoles[" + i + "].RLSParty().partyIdentifiers[0]");
                writeToLogFile("=============================================================================");
                PartyIdentifier pi = rlsp.getPartyIdentifiers().get(0);
                compareDbToApi_String("idDocumentNumber", header.getINSIDDOCUMENTNUMBER(), pi.getIdDocumentNumber());
                compareDbToApi_String("idDocumentType", header.getIDDOCUMENTTYPE(), pi.getIdDocumentType());
            }
            if(i==2){
                RLSParty rlsp = pr.getRLSParty();
                writeToLogFile("=============================================================================");
                writeToLogFile("partyRoles[" + i + "].RLSParty().physicalContacts[0]");
                writeToLogFile("=============================================================================");
                PhysicalContact pc = rlsp.getPhysicalContacts().get(0);
                if(pc.getPhysicalAddressTypeCode().equalsIgnoreCase("COR")) {
                    compareDbToApi_String("addressLine1", header.getPOLICYADDRESSLINE1(), pc.getAddressLine1());
                    compareDbToApi_String("addressLine2", header.getPOLICYADDRESSLINE2(), pc.getAddressLine2());
                    compareDbToApi_String("addressLine3", header.getPOLICY_ADDRESS_LINE_3(), pc.getAddressLine3());
                    compareDbToApi_String("addressLine4", header.getPOLICYADDRESSLINE4(), pc.getAddressLine4());
                }
                if(pc.getPhysicalAddressTypeCode().equalsIgnoreCase("CH-COR")) {
                    compareDbToApi_String("addressLine1", header.getCHINESE_POLICY_ADDRESS_LINE_1(), pc.getAddressLine1());
                    compareDbToApi_String("addressLine2", header.getCHINESE_POLICY_ADDRESS_LINE_2(), pc.getAddressLine2());
                    compareDbToApi_String("addressLine3", header.getCHINESE_POLICY_ADDRESS_LINE_3(), pc.getAddressLine3());
                    compareDbToApi_String("addressLine4", header.getCHINESE_POLICY_ADDRESS_LINE_4(), pc.getAddressLine4());
                }
                compareDbToApi_String("physicalAddressTypeCode", pc.getPhysicalAddressTypeCode(), pc.getPhysicalAddressTypeCode());
            }
        }
        //TODO - need to re-check mapping
        //compareDbToApi_String("actualServicingAgentCode1", getActualServicingAgent[0].getACTUALSERVICINGAGENTCODE1().replace("-0-", "-"), rp.getActualServicingAgentCode1());
        try {
            String servicingAgent = "";
            if(header.getACTUAL_SERVICING_AGENT()!=null){
                servicingAgent = header.getACTUAL_SERVICING_AGENT();
            }else {
                String agentCode = rp.getActualServicingAgentCode1().substring(rp.getActualServicingAgentCode1().length() - 6);
                if (String.valueOf(agentCode.charAt(0)).equalsIgnoreCase("0")) {
                    agentCode = rp.getActualServicingAgentCode1().substring(rp.getActualServicingAgentCode1().length() - 5);
                }
                filename = "src/sql/Regional/retrievePolicyDetails_Life/getPolicyDetails_AGPODAGTOFromLifeByAgentCode.txt";
                text = new String(Files.readAllBytes(Paths.get(filename)));
                query = text.replace("%agentCode%", agentCode);
                jsonHeader = executeQueryNoLogs(con, query);
                Gson gson = new Gson();
                getAGPODAGTO = gson.fromJson(jsonHeader.toString(), GetAGPODAGTO[].class);
                servicingAgent = getAGPODAGTO[0].getFULLAGENTCODE();
                if (String.valueOf(servicingAgent.charAt(0)).equalsIgnoreCase("0")) {
                    //servicingAgent = getAGPODAGTO[0].getFULLAGENTCODE().substring(1);
                    String s = getAGPODAGTO[0].getFULLAGENTCODE().substring(1);
                    s = s.replaceFirst("^0+(?!$)", "");
                    servicingAgent = ((s.substring(0,1)).equals("-") ? s.substring(1): s);
                }
            }

            compareDbToApi_String("actualServicingAgentCode1", servicingAgent.replace("--", "-"), rp.getActualServicingAgentCode1());
        } catch (IOException e) {
            //e.printStackTrace();
        }

        if(header.getACCUMULATEDDIVIDEND()!=null) {
            if (header.getACCUMULATEDDIVIDEND() == 0.0) {
                compareDbToApi_Decimal0DP("accumulatedDividendAmount", header.getACCUMULATEDDIVIDEND().toString(), rp.getAccumulatedDividendAmount());
            } else {
                compareDbToApi_Decimal("accumulatedDividendAmount", header.getACCUMULATEDDIVIDEND(), rp.getAccumulatedDividendAmount());
            }
        }
        if(header.getACCUMULATEDDIVINTRST()!=null) {
            DecimalFormat df = new DecimalFormat("#0.####");
            compareDbToApi_Decimal("accumulatedDividendInterestAmount", df.format(header.getACCUMULATEDDIVINTRST()), rp.getAccumulatedDividendInterestAmount());
        }
        if(header.getACTUALTERMDATE().contains("1900-01-01")){
            compareDbToApi_String("actualTerminationDate", "", rp.getActualTerminationDate());
        }else {
            compareDbToApi_Timestamp_DatePart("actualTerminationDate", header.getACTUALTERMDATE(), rp.getActualTerminationDate());
        }
        if(header.getADDITIONALPAIDUPAMOUNT()!=null) {
            compareDbToApi_Decimal("additionalPaidUpAmount", header.getADDITIONALPAIDUPAMOUNT().toString(), rp.getAdditionalPaidUpAmount());
        }
        if(header.getADDITIONALPAIDUPFACEVALUE()!=null) {
            compareDbToApi_Decimal("additionalPaidUpFaceValueAmount", header.getADDITIONALPAIDUPFACEVALUE().toString(), rp.getAdditionalPaidUpFaceValueAmount());
        }
        if(getLFPODSAFYP.length!=0) {
            compareDbToApi_Decimal("annualFirstYearPremiumAmount", getLFPODSAFYP[0].getANNL_FRST_YR_PRM(), rp.getAnnualFirstYearPremiumAmount());
        }else{
            compareDbToApi_String("annualFirstYearPremiumAmount", "", rp.getAnnualFirstYearPremiumAmount());
        }

        if(getLFPPOLUS.length==0){
            compareDbToApi_Timestamp_DatePart("applicationSignDate", "", rp.getApplicationSignDate());
        }else{
            if(getLFPPOLUS[0].getUSDAPP().toString().contains("1900-01-01")){
                compareDbToApi_Timestamp_DatePart("applicationSignDate", "", rp.getApplicationSignDate());
            }else {
                compareDbToApi_Timestamp_DatePart("applicationSignDate", getLFPPOLUS[0].getUSDAPP(), rp.getApplicationSignDate());
            }
        }
        //TODO - need to re-check mapping
        compareDbToApi_String("assigneeChineseName", "", rp.getAssigneeChineseName());
        compareDbToApi_String("assigneeName", header.getASIGNEE_NAME(), rp.getAssigneeName());
        compareDbToApi_String("assigneeType", header.getASSIGNEETYPE(), rp.getAssigneeType());
        compareDbToApi_String("assigneeTypeCode", header.getASSIGNEETYPECODE(), rp.getAssigneeTypeCode());
        if(getLFPCDBLPIF.length!=0)
            compareDbToApi_String("autoReinstatementApplicabilityFlag", getLFPCDBLPIF[0].getQ49AUTORNS(), rp.getAutoReinstatementApplicabilityFlag());
        if(header.getBASICSUMINSURED()!=null)
            compareDbToApi_Decimal("basicSumInsuredAmount", header.getBASICSUMINSURED().toString(), rp.getBasicSumInsuredAmount());
        if(header.getBONUSINFACEVALUEAMOUNT()!=null)
            compareDbToApi_Decimal("bonusFaceValueAmount", header.getBONUSINFACEVALUEAMOUNT().toString(), rp.getBonusFaceValueAmount());
        DecimalFormat df = new DecimalFormat("#0.##");
        compareDbToApi_Decimal("commissionRate", df.format(header.getCOMMISSIONRATE()), rp.getCommissionRate());
        compareDbToApi_String("communicationMean", header.getCOMMUNICATIONMEANS(), rp.getCommunicationMean());
        if(header.getDATEOFCOSTINSUPD()!=null) {
            if (header.getDATEOFCOSTINSUPD().contains("1900-01-01")) {
                compareDbToApi_String("costOfInsuranceUpdateDate", "", rp.getCostOfInsuranceUpdateDate());
            } else {
                compareDbToApi_Timestamp_DatePart("costOfInsuranceUpdateDate", header.getDATEOFCOSTINSUPD(), rp.getCostOfInsuranceUpdateDate());
            }
        }
        if(header.getCOUPONAMOUNT()!=null) {
            compareDbToApi_Decimal("couponAmount", header.getCOUPONAMOUNT().toString(), rp.getCouponAmount());
        }else{
            compareDbToApi_Decimal("couponAmount", "", rp.getCouponAmount());
        }
        if(header.getCOUPONINTEREST()!=null)
            compareDbToApi_Decimal("couponInterestAmount", header.getCOUPONINTEREST().toString(), rp.getCouponInterestAmount());
        compareDbToApi_String("dateBackPolicyFlag", ((getLFPPOLUS.length==0) ? "" : getLFPPOLUS[0].getUSDBK()), rp.getDateBackPolicyFlag());
        compareDbToApi_String("deathBenefitOption", header.getDEATHBNFTOPTIONS(), rp.getDeathBenefitOption());
        compareDbToApi_String("dividendOptionFlag", header.getDIVIDENDOPTION(), rp.getDividendOptionFlag());
        if(header.getEFFPOLICYCHANGEDATE().contains("1900-01-01")){
            compareDbToApi_String("effectivePolicyChangeDate", "", rp.getEffectivePolicyChangeDate());
        }else {
            compareDbToApi_Timestamp_DatePart("effectivePolicyChangeDate", header.getEFFPOLICYCHANGEDATE(), rp.getEffectivePolicyChangeDate());
        }
        compareDbToApi_String("eServiceFlag", header.getESERVICEINDICATOR(), rp.getEServiceFlag());
        if(header.getETAEXPIRYDATE()!=null) {
            if (header.getETAEXPIRYDATE().contains("1900-01-01")) {
                compareDbToApi_String("ETAExpiryDate", "", rp.getETAExpiryDate());
            } else {
                compareDbToApi_Timestamp_DatePart("ETAExpiryDate", header.getETAEXPIRYDATE(), rp.getETAExpiryDate());
            }
        }
        compareDbToApi_Timestamp_DatePart("expireDate", header.getEXPIRYDATE(), rp.getExpireDate());
        if(header.getFACEVALONRVRSNRYBONUS()!=null)
            compareDbToApi_Decimal("faceValueReversionaryBonusAmount", header.getFACEVALONRVRSNRYBONUS().toString(), rp.getFaceValueReversionaryBonusAmount());
        if(header.getFACEVALONTRMNLBONUS()!=null)
            compareDbToApi_Decimal("faceValueTerminalBonusAmount", header.getFACEVALONTRMNLBONUS().toString(), rp.getFaceValueTerminalBonusAmount());
        compareDbToApi_Decimal0DP("futurePremiumDepositAmount", header.getFUTUREPREMIUMDEPOSIT().toString(), rp.getFuturePremiumDepositAmount());
        df = new DecimalFormat("#0.####");
        compareDbToApi_Decimal0DP("futurePremiumDepositInterestAmount", df.format(header.getFUTUREPREMDEPOSITINTEREST()), rp.getFuturePremiumDepositInterestAmount());
        compareDbToApi_String("indexationState", header.getINDEXATIONSTATE(), rp.getIndexationState());
        if(header.getINITIALLSPREMIUM()!=null)
            compareDbToApi_Decimal("initialLumpsumPremiumAmount", header.getINITIALLSPREMIUM().toString(), rp.getInitialLumpsumPremiumAmount());
        if(!axaEntity.equalsIgnoreCase("SG"))
            compareDbToApi_String("insuredIDFlag", ((getLFPPOLUS.length==0) ? "" : getLFPPOLUS[0].getUSIDINC()), rp.getInsuredIDFlag());
        if (getLFPCDBPLPC.length != 0) {
            compareDbToApi_Decimal3("lastModalPremiumAmount", getLFPCDBPLPC[0].getQ46LMPREM(), rp.getLastModalPremiumAmount());
        } else {
            compareDbToApi_String("lastModalPremiumAmount", "", rp.getLastModalPremiumAmount());
        }
        if(header.getLOANBALANCE()!=null) {
            df = new DecimalFormat("#0.####");
            compareDbToApi_Decimal("loanBalanceAmount", df.format(header.getLOANBALANCE()), rp.getLoanBalanceAmount());
        }
        if(header.getLOANBLNCEINTEREST()!=null) {
            df = new DecimalFormat("#0.####");
            compareDbToApi_Decimal("loanBalanceInterestAmount", df.format(header.getLOANBLNCEINTEREST()), rp.getLoanBalanceInterestAmount());
        }
        compareDbToApi_String("MAEOptionCode", header.getMAEOPTIONCODE(), rp.getMAEOptionCode());
        compareDbToApi_Decimal3("modalCommissionAmount", header.getMODALCOMMISSION(), rp.getModalCommissionAmount());
        compareDbToApi_String("policyIndexationType", header.getPOLICYINDEXATIONTYPE(), rp.getPolicyIndexationType());
        compareDbToApi_String("policyOrphanFlag", ((getLFPPOLUS.length==0) ? "" : getLFPPOLUS[0].getUSORP()), rp.getPolicyOrphanFlag());
        if(getLFPCDBPLPC.length!=0){
            compareDbToApi_Decimal3("premiumChargeAmount", getLFPCDBPLPC[0].getQ46PRMCHG(), rp.getPremiumChargeAmount());
        }else{
            compareDbToApi_String("premiumChargeAmount", "", rp.getPremiumChargeAmount());
        }
        if(header.getPREMIUMDUEDATE()!=null) {
            if (header.getPREMIUMDUEDATE().contains("1900-01-01")) {
                compareDbToApi_String("premiumDueDate", "", rp.getPremiumDueDate());
            } else {
                compareDbToApi_Timestamp_DatePart("premiumDueDate", header.getPREMIUMDUEDATE(), rp.getPremiumDueDate());
            }
        }
        compareDbToApi_String("premiumHolidayFlag", header.getPREMIUMHOLIDAYINDICATOR(), rp.getPremiumHolidayFlag());
        compareDbToApi_String("premiumOverdueFlag", header.getPREMIUMOVERDUE(), rp.getPremiumOverdueFlag());
        compareDbToApi_String("premiumPaymentMethod", header.getPAYMENTMETHOD(), rp.getPremiumPaymentMethod());
        if(header.getPUREENDOWMENT()!=null)
            compareDbToApi_Decimal("pureEndowmentAmount", header.getPUREENDOWMENT().toString(), rp.getPureEndowmentAmount());
        if(header.getREDUCEDPAIDUP()!=null)
            compareDbToApi_Decimal("reducedPaidUpAmount", header.getREDUCEDPAIDUP().toString(), rp.getReducedPaidUpAmount());
        if(header.getREGULARTOPUPPREMIUM()!=null)
            compareDbToApi_Decimal("regularTopUpPremiumAmount", header.getREGULARTOPUPPREMIUM().toString(), rp.getRegularTopUpPremiumAmount());
        if(header.getREINSTATEMENTEFFDATE().contains("1900-01-01")){
            compareDbToApi_String("reinstatementEffectiveDate", "", rp.getReinstatementEffectiveDate());
        }else {
            compareDbToApi_Timestamp_DatePart("reinstatementEffectiveDate", header.getREINSTATEMENTEFFDATE(), rp.getReinstatementEffectiveDate());
        }
        if(getLFPCDBPLPC.length!=0) {
            compareDbToApi_Decimal3("requiredPremiumAmount", getLFPCDBPLPC[0].getQ46MPREM(), rp.getRequiredPremiumAmount());
        }else{
            compareDbToApi_String("requiredPremiumAmount", "", rp.getRequiredPremiumAmount());
        }
        compareDbToApi_String("SMS", header.getSMS(), rp.getSMS());
        compareDbToApi_String("staffFlag", ((getTABSTAFF.length==0) ? "" : getTABSTAFF[0].getSTAFF_FLAG()), rp.getStaffFlag());
        compareDbToApi_Timestamp_DatePart("submissionDate", header.getSUBMISSIONDATE(), rp.getSubmissionDate());
        if(header.getSUMINSURED()!=null)
            compareDbToApi_Decimal("sumInsuredAmount", header.getSUMINSURED().toString(), rp.getSumInsuredAmount());
        //TODO - need to re-check mapping
        compareDbToApi_String("SUSEmail", "", rp.getSUSEmail());
        //TODO - need to re-check mapping
        compareDbToApi_String("SUSSMS", "", rp.getSUSSMS());
        if(header.getPOLICYTERMINATIONDATE().contains("1900-01-01")){
            compareDbToApi_String("terminationDate", "", rp.getTerminationDate());
        }else {
            compareDbToApi_Timestamp_DatePart("terminationDate", header.getPOLICYTERMINATIONDATE(), rp.getTerminationDate());
        }

        if(rp.getLOBCode().equalsIgnoreCase("UNIT LINK")){
            if (getLFPODSAS.length!=0) {
                compareDbToApi_Decimal("totalAmount", getLFPODSAS[0].getASABALPR(), rp.getTotalAmount());
            }else{
                compareDbToApi_Decimal("totalAmount", "", rp.getTotalAmount());
            }
        }else{
            if(rp.getTotalAmount().equalsIgnoreCase("")){
                compareDbToApi_String("totalAmount", "", rp.getTotalAmount());
            }else {
                compareDbToApi_Decimal("totalAmount", header.getTOTAL_AMOUNT(), rp.getTotalAmount());
            }
        }

        if (getLFPCDBPLPC.length!=0) {
            compareDbToApi_Decimal3("totalPremiumAmount", getLFPCDBPLPC[0].getQ46MPREM(), rp.getTotalPremiumAmount());
        }else{
            compareDbToApi_String("totalPremiumAmount", "", rp.getTotalPremiumAmount());
        }
        if(header.getTOTALSUMINSURED()!=null)
            compareDbToApi_Decimal("totalSumInsuredAmount", header.getTOTALSUMINSURED().toString(), rp.getTotalSumInsuredAmount());
        //TODO - need to re-check mapping
        compareDbToApi_Decimal("totalWithdrawalAmount", rp.getTotalWithdrawalAmount(), rp.getTotalWithdrawalAmount());
        if(header.getTRANSDATE().contains("1900-01-01")){
            compareDbToApi_String("terminationDate", "", rp.getTransactionDate());
        }else {
            compareDbToApi_Timestamp_DatePart("transactionDate", header.getTRANSDATE(), rp.getTransactionDate());
        }

        if(getLFPCS232NI_LFPSTMTR.length!=0) {
            compareDbToApi_Timestamp_DatePart("noClaimBonusDate", getLFPCS232NI_LFPSTMTR[0].getNO_CLAIM_BONUS_DATE(), rp.getNoClaimBonusDate());
            if(getLFPCS232NI_LFPSTMTR[0].getNO_CLAIM_BONUS_AMOUNT()!=null) {
                compareDbToApi_Decimal("noClaimBonusAmount", getLFPCS232NI_LFPSTMTR[0].getNO_CLAIM_BONUS_AMOUNT().toString(), rp.getNoClaimBonusAmount());
            }else{
                compareDbToApi_String("noClaimBonusAmount", "", rp.getNoClaimBonusAmount());
            }
        } else {
            compareDbToApi_String("noClaimBonusDate", "", rp.getNoClaimBonusDate());
            compareDbToApi_String("noClaimBonusAmount", "", rp.getNoClaimBonusAmount());
        }
        compareDbToApi_String("classCode", header.getCLASSCODE(), rp.getClassCode());
        compareDbToApi_String("policyConversionNumber", ((getLFPCCON.length==0) ? "" : getLFPCCON[0].getPOLICY_CONVERSION_NUMBER()), rp.getPolicyConversionNumber());
        compareDbToApi_String("activitySuspensionFlag", header.getACTIVITYSUSPENSIONFLG(), rp.getActivitySuspensionFlag());
        compareDbToApi_String("nonforfeitureOption", header.getNONFORFEITUREOPT(), rp.getNonforfeitureOption());
        compareDbToApi_String("maintenanceCode", header.getMAINTENANCECD(), rp.getMaintenanceCode());
        //TODO - need to re-check mapping
        compareDbToApi_Decimal("lumpSum", "", rp.getLumpSum());
        //TODO - need to re-check mapping
        compareDbToApi_Decimal("modalRegularPremiumExcludeTopup", "", rp.getModalRegularPremiumExcludeTopup());

        writeToLogFile("=============================================================================");
        writeToLogFile("creditCardAuthorization()");
        writeToLogFile("=============================================================================");
        CreditCardAuthorization cca = rp.getCreditCardAuthorization();
        //TODO - need to check mapping
        if (getCreditCardAuthorization.length != 0) {
            if(getCreditCardAuthorization[0].getD7ASTU().equalsIgnoreCase(" ")){
                compareDbToApi_String("cardStatus", "", cca.getCardStatus());
            }else {
                compareDbToApi_String("cardStatus", getCreditCardAuthorization[0].getD7ASTU(), cca.getCardStatus());
            }
            compareDbToApi_String("creditCardNumber", getCreditCardAuthorization[0].getD7ACNO(), cca.getCreditCardNumber());
            if (getCreditCardAuthorization[0].getD7ADTE() != null) {
                if(getCreditCardAuthorization[0].getD7ADTE().equalsIgnoreCase("0")){
                    compareDbToApi_String("processingDate", "", cca.getProcessingDate());
                }else {
                    compareDbToApi_Timestamp_DatePart("processingDate", getCreditCardAuthorization[0].getD7ADTE(), cca.getProcessingDate());
                }
            } else {
                compareDbToApi_String("processingDate", "", cca.getProcessingDate());
            }
        } else {
            compareDbToApi_String("cardStatus", "", cca.getCardStatus());
            compareDbToApi_String("creditCardNumber", "", cca.getCreditCardNumber());
            compareDbToApi_String("processingDate", "", cca.getProcessingDate());
        }

        writeToLogFile("=============================================================================");
        writeToLogFile("creditCardAuthorization().cardHolder()");
        writeToLogFile("=============================================================================");
        CardHolder ch = cca.getCardHolder();
        if (getCreditCardAuthorization.length != 0) {
            compareDbToApi_String("lastName", getCreditCardAuthorization[0].getD7ANAM(), ch.getLastName());
        } else {
            compareDbToApi_String("lastName", "", ch.getLastName());
        }

        try {
            filename = "src/sql/Regional/retrievePolicyDetails_Life/getPlanNameForTABPLANFromLFPPMLByPlanCode.txt";
            text = new String(Files.readAllBytes(Paths.get(filename)));
            query = text.replace("%planCode%", header.getPLANCODE());
            JSONArray jsonPlan = executeQueryNoLogs(con, query);
            Gson gson = new Gson();
            getTABPLAN = gson.fromJson(jsonPlan.toString(), GetTABPLAN[].class);
            if(getTABPLAN.length!=0) {
                writeToLogFile("=============================================================================");
                writeToLogFile("RLSProduct()");
                writeToLogFile("=============================================================================");
                RLSProduct rlsp = rp.getRLSProduct();
                GetTABPLAN plan = getTABPLAN[0];
                compareDbToApi_String("productCode", header.getPLANCODE(), rlsp.getProductCode());
                compareDbToApi_String("productName", plan.getPLAND(), rlsp.getProductName());
                filename = "src/sql/Regional/retrievePolicyDetails_Life/getChineseProductName.txt";
                text = new String(Files.readAllBytes(Paths.get(filename)));
                query = text.replace("%planCode%", header.getPLANCODE());
                jsonPlan = executeQueryNoLogs(con, query);
                gson = new Gson();
                getChineseProductName = gson.fromJson(jsonPlan.toString(), GetChineseProductName[].class);
                if(getChineseProductName.length!=0) {
                    compareDbToApi_String("chineseProductName", getChineseProductName[getChineseProductName.length-1].getH9DESC(), rlsp.getChineseProductName());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            Assert.assertFalse(failedStatus);
        }

        if(rp.getPolicyRiders()!=null){
            if(axaEntity.equalsIgnoreCase("SG")) {
                try {
                    filename = "src/sql/Regional/retrievePolicyDetails_Life/getPolicyRider.txt";
                    text = new String(Files.readAllBytes(Paths.get(filename)));
                    query = text.replace("%policyNumber%", policyNumber);
                    writeToLogFile("[SQL Query]");
                    writeToLogFile(query);
                    JSONArray jsonHeader = executeQuery(con, query);
                    Gson gson = new Gson();
                    getPolicyRider = gson.fromJson(jsonHeader.toString(), GetPolicyRider[].class);
                    for (int i = 0; i < rp.getPolicyRiders().size(); i++) {
                        writeToLogFile("=============================================================================");
                        writeToLogFile("policyRiders[" + i + "]");
                        writeToLogFile("=============================================================================");
                        PolicyRider polRider = rp.getPolicyRiders().get(i);
                        compareDbToApi_String("policyNumber", getPolicyRider[i].getRIDERPOLICY(), polRider.getPolicyNumber());
                        //TODO - need to re-check mapping
                        compareDbToApi_Decimal("loadingAmount", "", polRider.getLoadingAmount());
                        if (header.getTEMPLOADING() != null)
                            compareDbToApi_Decimal("temporaryLoadingAmount", header.getTEMPLOADING().toString(), polRider.getTemporaryLoadingAmount());
                        writeToLogFile("=============================================================================");
                        writeToLogFile("policyRiders[" + i + "].product()");
                        writeToLogFile("=============================================================================");
                        Product prod = polRider.getProduct();
                        //TODO - need to re-check mapping
                        compareDbToApi_String("productCode", getPolicyRider[i].getRIDERPLAN(), prod.getProductCode());
                        //TODO - need to re-check mapping
                        compareDbToApi_String("productName", getPolicyRider[i].getRIDERDESC(), prod.getProductName());
                        //TODO - need to re-check mapping
                        compareDbToApi_String("basePlanFlag", getPolicyRider[i].getPLANFLG(), prod.getBasePlanFlag());
                        if (polRider.getRiderExclusions() != null) {
                            for (int i2 = 0; i2 < polRider.getRiderExclusions().size(); i2++) {
                                writeToLogFile("=============================================================================");
                                writeToLogFile("policyRiders[" + i + "].product().riderExclusions[" + i2 + "]");
                                writeToLogFile("=============================================================================");
                                RiderExclusion re = polRider.getRiderExclusions().get(i2);
                                //TODO - need to re-check mapping
                                compareDbToApi_String("exclusionCode", header.getEXCLUSION(), re.getExclusionCode());
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    Assert.assertFalse(failedStatus);
                }
            }else{
                for (int i = 0; i < rp.getPolicyRiders().size(); i++) {
                    writeToLogFile("=============================================================================");
                    writeToLogFile("policyRiders[" + i + "]");
                    writeToLogFile("=============================================================================");
                    PolicyRider polRider = rp.getPolicyRiders().get(i);
                    compareDbToApi_String("policyNumber", "", polRider.getPolicyNumber());
                    compareDbToApi_Decimal("loadingAmount", "", polRider.getLoadingAmount());
                    if (header.getTEMPLOADING() != null)
                        compareDbToApi_Decimal("temporaryLoadingAmount", header.getTEMPLOADING().toString(), polRider.getTemporaryLoadingAmount());
                    writeToLogFile("=============================================================================");
                    writeToLogFile("policyRiders[" + i + "].product()");
                    writeToLogFile("=============================================================================");
                    Product prod = polRider.getProduct();
                    compareDbToApi_String("productCode", "", prod.getProductCode());
                    compareDbToApi_String("productName", "", prod.getProductName());
                    //TODO - need to re-check mapping
                    compareDbToApi_String("basePlanFlag", "P", prod.getBasePlanFlag());
                    if (polRider.getRiderExclusions() != null) {
                        for (int i2 = 0; i2 < polRider.getRiderExclusions().size(); i2++) {
                            writeToLogFile("=============================================================================");
                            writeToLogFile("policyRiders[" + i + "].product().riderExclusions[" + i2 + "]");
                            writeToLogFile("=============================================================================");
                            RiderExclusion re = polRider.getRiderExclusions().get(i2);
                            //TODO - need to re-check mapping
                            compareDbToApi_String("exclusionCode", header.getEXCLUSION(), re.getExclusionCode());
                        }
                    }
                }
            }
        }


        if(!System.getProperty("byPassKnownIssues").equalsIgnoreCase("true")) {
            writeToLogFile("=============================================================================");
            writeToLogFile("Assignee()");
            writeToLogFile("=============================================================================");
            Assignee ass = rp.getAssignee();
            for (int i = 0; i < ass.getPhysicalContact().size(); i++) {
                writeToLogFile("=============================================================================");
                writeToLogFile("Assignee().PhysicalContact[" + i + "]");
                writeToLogFile("=============================================================================");
                PhysicalContact pc = ass.getPhysicalContact().get(i);
                compareDbToApi_String("addressLine1", getAssignee[i].getLASSA1(), pc.getAddressLine1());
                compareDbToApi_String("addressLine2", getAssignee[i].getLASSA2(), pc.getAddressLine2());
                compareDbToApi_String("addressLine3", getAssignee[i].getLASSA3(), pc.getAddressLine3());
                compareDbToApi_String("addressLine4", getAssignee[i].getLASSA4(), pc.getAddressLine4());
                compareDbToApi_String("cityName", getAssignee[i].getLASCTY(), pc.getCityName());
                compareDbToApi_String("physicalAddressTypeCode", getAssignee[i].getADDRESS_TYPE_CODE(), pc.getPhysicalAddressTypeCode());
            }
        }

        writeToLogFile("=============================================================================");
        writeToLogFile("investmentPolicy()");
        writeToLogFile("=============================================================================");
        InvestmentPolicy ip = rp.getInvestmentPolicy();
        //TODO - need to re-check mapping
        compareDbToApi_String("additionalPaidUpCashValueAmount", "", ip.getAdditionalPaidUpCashValueAmount());
        //TODO - need to re-check mapping
        compareDbToApi_String("bonusInCashValueAmount", "", ip.getBonusInCashValueAmount());
        //TODO - need to re-check mapping
        compareDbToApi_String("cashValueOnBasicSumInsuredAmount", "", ip.getCashValueOnBasicSumInsuredAmount());
        //TODO - need to re-check mapping
        compareDbToApi_String("coverageSurrenderValueAmount", "", ip.getCoverageSurrenderValueAmount());
        //TODO - need to re-check mapping
        compareDbToApi_String("specialInvestmentBonusAmount", "", ip.getSpecialInvestmentBonusAmount());
        if(getLFPODSAS.length!=0) {
            compareDbToApi_Decimal3("costOfInsuranceAmount", getLFPODSAS[0].getASCOI(), ip.getCostOfInsuranceAmount());
            compareDbToApi_Decimal3("surrenderValueInPolicyCurrencyAmount", getLFPODSAS[0].getASSURV(), ip.getSurrenderValueInPolicyCurrencyAmount());
            compareDbToApi_Decimal3("totalAccountValueAmount", getLFPODSAS[0].getASABAL(), ip.getTotalAccountValueAmount());
        }else{
            compareDbToApi_String("costOfInsuranceAmount", "", ip.getCostOfInsuranceAmount());
            compareDbToApi_String("surrenderValueInPolicyCurrencyAmount", "", ip.getSurrenderValueInPolicyCurrencyAmount());
            compareDbToApi_String("totalAccountValueAmount", "", ip.getTotalAccountValueAmount());
        }

        writeToLogFile("=============================================================================");
        writeToLogFile("debitAccountAuthorization()");
        writeToLogFile("=============================================================================");
        DebitAccountAuthorization daa = rp.getDebitAccountAuthorization();
        //TODO - need to re-check mapping
        if (getDebitAccountAuthorization.length != 0) {
            compareDbToApi_String("bankAccountNumber", getDebitAccountAuthorization[0].getAAC(), daa.getBankAccountNumber());
            compareDbToApi_String("bankAccountStatus", getDebitAccountAuthorization[0].getASTATU(), daa.getBankAccountStatus());
            compareDbToApi_Timestamp_DatePart_toYYYYMMDD("processingDate", getDebitAccountAuthorization[0].getADATE(), daa.getProcessingDate());
        } else {
            compareDbToApi_String("bankAccountNumber", "", daa.getBankAccountNumber());
            compareDbToApi_String("bankAccountStatus", "", daa.getBankAccountStatus());
            compareDbToApi_String("processingDate", "", daa.getProcessingDate());
        }
        writeToLogFile("=============================================================================");
        writeToLogFile("debitAccountAuthorization().cardHolder()");
        writeToLogFile("=============================================================================");
        Debtor d = daa.getDebtor();
        //TODO - need to re-check mapping
        if (getDebitAccountAuthorization.length != 0) {
            compareDbToApi_String("lastName", getDebitAccountAuthorization[0].getANAME(), d.getLastName());
        } else {
            compareDbToApi_String("lastName", "", d.getLastName());
        }

        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        writeToLogFile("=============================================================================\n");
        Assert.assertFalse(failedStatus);


    }

}
