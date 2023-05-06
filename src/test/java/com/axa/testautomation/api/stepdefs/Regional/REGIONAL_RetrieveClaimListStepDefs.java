package com.axa.testautomation.api.stepdefs.Regional;


import com.axa.testautomation.api.regional.RetrieveClaimList.response.*;
import com.axa.testautomation.api.regional.RetrieveClaimList.dbResult.*;
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
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;


public class REGIONAL_RetrieveClaimListStepDefs extends BaseStepDefs {

    @Autowired
    private String regionalNitRetrieveClaimList;

    @Autowired
    private String sg_MDCOR7QI;
    @Autowired
    private String g_SG_CUST;
    @Autowired
    private String hk_MDCOR2QI;
    @Autowired
    private String g_HK_CUST;
    @Autowired
    private String th_MDCOR3QI;
    @Autowired
    private String l_TH_CUST;
    @Autowired
    private String my_MDCOR7QI;
    @Autowired
    private String g_MY_CUST;
    @Autowired
    private String ph_MDCOR8QI;
    @Autowired
    private String l_PH_CUST;
    @Autowired
    private String corePassword;


    private String nationalID;
    private String policyNumber;
    private String axaEntity;
    private String sourceSystemCode;
    private JSONArray json;
    private JSONArray jsonCnt;
    private MainQuery[] mainQuery;
    private CountQuery[] countQuery;
    private RetrieveClaimListResponseContainer retrieveClaimListResponseContainer;

    @Given("the following http headers are set Retrieve Claim List")
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
                if(headerMap.getKey().equalsIgnoreCase("X-Axa-ContextHeader-CustomData-SourceSystem")){
                    sourceSystemCode = headerMap.getValue();
                }

            }
        }
        writeToLogFile("=====================");
    }


    @And("the following GET input parameters are set for Retrieve Claim List")
    public void set_get_parameters(DataTable dt) {
        failedStatus = false;
        getParameters = "?";
        for(Map<String, String> row : dt.asMaps()) {
            for(Map.Entry<String, String> getParametersMap : row.entrySet()) {
                getParameters = getParameters + getParametersMap.getKey() + "=" + getParametersMap.getValue() + "&";

                switch (getParametersMap.getKey()){
                    case "nationalId": nationalID = getParametersMap.getValue(); break;
                    case "policyNumber": policyNumber = getParametersMap.getValue(); break;
                }
            }
        }
        getParameters = getParameters.substring(0, getParameters.length()-1);
        writeToLogFile("PARAMETER: " + getParameters);
    }

    @When("the api call has been made for Retrieve Claim List")
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
            String url = regionalNitRetrieveClaimList + getParameters;
            writeToLogFile("ENDPOINT: " + regionalNitRetrieveClaimList);
            HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
            response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            writeToLogFile("[API Response]");
            writeToLogFile(response.getBody());

            Gson gson = new Gson();
            retrieveClaimListResponseContainer = gson.fromJson(response.getBody(), RetrieveClaimListResponseContainer.class);
        }
        catch (HttpClientErrorException | HttpServerErrorException e) {
            actualHttpErrorCode = Integer.toString(e.getStatusCode().value());
            actualHttpErrorPhrase = e.getStatusCode().getReasonPhrase();
            actualHttpErrorBody = e.getResponseBodyAsString().replaceAll("\n","");
            writeToLogFile("[API Response]");
            writeToLogFile(actualHttpErrorBody);
        }
    }

    @When("the Stored Procedure is called for Retrieve Claim List")
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
                case "sg": dbConnection = sg_MDCOR7QI;
                    userName = g_SG_CUST;
                    password = corePassword;
                    break;
                case "hk": dbConnection = hk_MDCOR2QI;
                    userName = g_HK_CUST;
                    password = corePassword;
                    break;
                case "th": dbConnection = th_MDCOR3QI;
                    userName = l_TH_CUST;
                    password = corePassword;
                    break;
                case "my": dbConnection = my_MDCOR7QI;
                    userName = g_MY_CUST;
                    password = corePassword;
                    break;
                case "ph": dbConnection = ph_MDCOR8QI;
                    userName = l_PH_CUST;
                    password = corePassword;
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

            String filename = null;
            String text = null;
            String query = null;

            if(!policyNumber.equalsIgnoreCase("")) {
                filename = "src/sql/Regional/retrieveClaimList/retrieveClaimListByPolicy.txt";
                text = new String(Files.readAllBytes(Paths.get(filename)));
                query = text.replace("${policyNumber}", policyNumber)
                        .replace("${whereCondition}", "")
                        .replace("${sortingCondition}", "POLICY_NUMBER")
                        .replace("'${MIN_ROWS}'", "0")
                        .replace("'${MAX_ROWS}'", "50");
                writeToLogFile("[SQL Query]");
                writeToLogFile(query);
                json = executeQuery(con, query);

                filename = "src/sql/Regional/retrieveClaimList/retrieveClaimListCountByPolicy.txt";
                text = new String(Files.readAllBytes(Paths.get(filename)));
                query = text.replace("${policyNumber}", policyNumber)
                        .replace("${whereCondition}", "");
                writeToLogFile("[SQL Query]");
                writeToLogFile(query);
                jsonCnt = executeQuery(con, query);
            }else{
                filename = "src/sql/Regional/retrieveClaimList/whereCondition_usingNationIDAsRequest.txt";
                text = new String(Files.readAllBytes(Paths.get(filename)));
                String whereCondition = text.replace("%nationalId%", nationalID);

                filename = "src/sql/Regional/retrieveClaimList/retrieveClaimListByParty.txt";
                text = new String(Files.readAllBytes(Paths.get(filename)));
                query = text.replace("${whereCondition}", whereCondition)
                        .replace("${whereConditionPolicy}", "--${whereConditionPolicy}")
                        .replace("${sortingCondition}", "POLICY_NUMBER")
                        .replace("'${MIN_ROWS}'", "0")
                        .replace("'${MAX_ROWS}'", "50");
                writeToLogFile("[SQL Query]");
                writeToLogFile(query);
                json = executeQuery(con, query);

                filename = "src/sql/Regional/retrieveClaimList/retrieveClaimListCountByParty.txt";
                text = new String(Files.readAllBytes(Paths.get(filename)));
                query = text.replace("${whereCondition}", whereCondition)
                        .replace("${whereConditionPolicy}", "--${whereConditionPolicy}");
                writeToLogFile("[SQL Query]");
                writeToLogFile(query);
                jsonCnt = executeQuery(con, query);
            }

            Gson gson = new Gson();
            mainQuery = gson.fromJson(json.toString(), MainQuery[].class);
            countQuery = gson.fromJson(jsonCnt.toString(), CountQuery[].class);


        }catch(Exception e){
            failedStatus = true;
            scenario.write(e.toString());
            writeToLogFile(e.toString());
            Assert.assertFalse(failedStatus);

        }
    }
    
    @Then("verify that API and DB responses matched for Retrieve Claim List")
    public void api_match_db() {
        String dbConnection = "";
        String userName = "";
        String password = "";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            //step2 create  the connection object
            switch (axaEntity.toLowerCase()){
                case "sg": dbConnection = sg_MDCOR7QI;
                    userName = g_SG_CUST;
                    password = corePassword;
                    break;
                case "hk": dbConnection = hk_MDCOR2QI;
                    userName = g_HK_CUST;
                    password = corePassword;
                    break;
                case "th": dbConnection = th_MDCOR3QI;
                    userName = l_TH_CUST;
                    password = corePassword;
                    break;
                case "my": dbConnection = my_MDCOR7QI;
                    userName = g_MY_CUST;
                    password = corePassword;
                    break;
                case "ph": dbConnection = ph_MDCOR8QI;
                    userName = l_PH_CUST;
                    password = corePassword;
                    break;
            }

            String[] dbConn = dbConnection.split("/");
            Connection con= null;
            try {
                con = DriverManager.getConnection(
                        "jdbc:oracle:thin:@//"+dbConnection,userName,password);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            writeToLogFile("[Validations]");
            RetrieveClaimListResponse rclr = retrieveClaimListResponseContainer.getRetrieveClaimListResponse();
            for(int i=0; i<mainQuery.length; i++){
                writeToLogFile("=============================================================================");
                writeToLogFile("RetrieveClaimListResponse().coreClaim["+i+"]");
                writeToLogFile("=============================================================================");
                CoreClaim cc = rclr.getCoreClaim().get(i);
                MainQuery mq = mainQuery[i];

                compareDbToApi_String("claimNumber", mq.getCLAIMNUMBER(), cc.getClaimNumber());
                compareDbToApi_String("entityCode", mq.getENTITYCD(), cc.getEntityCode());
                
                compareDbToApi_Timestamp_DatePart("lossDate", mq.getLOSSDATE(), cc.getLossDate());
                compareDbToApi_String("sourceSystemCode", mq.getSOURCESYSTEMCD(), cc.getSourceSystemCode());
                compareDbToApi_String("LOBCode", mq.getSTDLOBCD(), cc.getLOBCode());
                compareDbToApi_String("claimTypeCode", mq.getCLAIM_TYPE(), cc.getClaimTypeCode());
                compareDbToApi_Timestamp_DatePart("claimOpenDate", mq.getCLAIMOPENDT(), cc.getClaimOpenDate());
                compareDbToApi_Timestamp_DatePart("claimCloseDate", mq.getCOMPLETIONDATE(), cc.getClaimCloseDate());
                compareDbToApi_Timestamp_DatePart("lossReportDate", mq.getSUBMISSIONDT(), cc.getLossReportDate());
                compareDbToApi_String("claimStatusCode", mq.getCLAIMSTATUSCD(), cc.getClaimStatusCode());
                compareDbToApi_String("claimCurrencyCode", mq.getCLAIMCURRENCYCD(), cc.getClaimCurrencyCode());
                compareDbToApi_Decimal2("totalClaimAmount", mq.getTOT_CLAIM_AMT(), cc.getTotalClaimAmount());
                compareDbToApi_Decimal2("totalApprovedAmount", mq.getCLAIM_AMOUNT_PAYABLE(), cc.getTotalApprovedAmount());
                if(!axaEntity.equalsIgnoreCase("SG")) {
                    if(mq.getREMAININGBENEFITBALANCE()!=null)
                	    compareDbToApi_String("totalOutstandingAmount", getConvertedDecimal2DP(mq.getREMAININGBENEFITBALANCE()).replace(".00", ""), cc.getTotalOutstandingAmount());
                }else{
                    compareDbToApi_Decimal2("totalOutstandingAmount", mq.getREMAININGBENEFITBALANCE(), cc.getTotalOutstandingAmount());
                }
                if(!axaEntity.equalsIgnoreCase("SG")) {
                    if(mq.getCLAIMAMOUNTPAID()!=null)
                        compareDbToApi_String("totalPaidAmount", getConvertedDecimal2DP(mq.getCLAIMAMOUNTPAID()).replace(".00", ""), cc.getTotalPaidAmount());
                }else{
                	compareDbToApi_Decimal2("totalPaidAmount", mq.getCLAIMAMOUNTPAID(), cc.getTotalPaidAmount());
                }
                compareDbToApi_String("previousClaimNumber", mq.getPREVIOUS_CLAIM_NO(), cc.getPreviousClaimNumber());
                compareDbToApi_Timestamp_DatePart("admissionDate", mq.getADMISSION_DATE(), cc.getAdmissionDate());
                compareDbToApi_Timestamp_DatePart("dischargeDate", mq.getDISCHARGE_DT(), cc.getDischargeDate());
                compareDbToApi_Decimal("totalShortfallAmount", mq.getSHORTFALL_AMT(), cc.getTotalShortfallAmount());
                compareDbToApi_String("policyNumber", mq.getPOLICYNUMBER(), cc.getPolicyNumber());
                compareDbToApi_String("companyCode", mq.getCOMPANYCD(), cc.getCompanyCode());
                compareDbToApi_String("coverageCode", mq.getCOVCD(), cc.getCoverageCode());
                compareDbToApi_String("coverageNumber", mq.getCOVNO(), cc.getCoverageNumber());
                compareDbToApi_Timestamp_DatePart("claimPaymentDate", mq.getCLAIM_PAYMENT_DT(), cc.getClaimPaymentDate());
                compareDbToApi_String("preAuthorizationNumber", mq.getPRE_AUTH_NO(), cc.getPreAuthorizationNumber());
                compareDbToApi_String("claimSettlementTypeCode", mq.getCLAIM_SETTLEMENT_TYPE_CD(), cc.getClaimSettlementTypeCode());
                compareDbToApi_String("claimAdjustmentNumber", mq.getADJUSTMENT_NO(), cc.getClaimAdjustmentNumber());
                compareDbToApi_String("dependentNumber", mq.getDEPENDENT_NUMBER(), cc.getDependentNumber());
                compareDbToApi_String("description", mq.getCLAIMDESCRIPTION(), cc.getDescription());
                if(cc.getClaimPartyRoles()!=null) {
                    writeToLogFile("=============================================================================");
                    writeToLogFile("RetrieveClaimListResponse().coreClaim[" + i + "].claimPartyRoles[0].party()");
                    writeToLogFile("=============================================================================");
                    Party p = cc.getClaimPartyRoles().get(0).getParty();
                    compareDbToApi_String("displayNameFormat", mq.getDISPLAY_NM_FORMAT(), p.getDisplayNameFormat());
                    compareDbToApi_String("firstName", mq.getFIRST_NAME(), p.getFirstName());
                    compareDbToApi_String("lastName", mq.getLASTNAME(), p.getLastName());
                    compareDbToApi_String("partyId", mq.getPARTYID(), p.getPartyId());
                }
                if(cc.getTotalBilledAmt()!=null || cc.getClientClaimRefNo()!=null ||cc.getProviderOrganisation()!=null) {
                    writeToLogFile("=============================================================================");
                    writeToLogFile("RetrieveClaimListResponse().coreClaim[" + i + "]");
                    writeToLogFile("=============================================================================");
                    compareDbToApi_Decimal2("totalBilledAmt", mq.getAMOUNT_BILLED(), cc.getTotalBilledAmt());
                    compareDbToApi_String("clientClaimRefNo", mq.getCLIENT_CLAIM_REF_NO(), cc.getClientClaimRefNo());
                    compareDbToApi_String("providerOrganisation", mq.getPROV_ORG(), cc.getProviderOrganisation());
                }
                //Added new fields - 10/31/2019
                if(cc.getReasonCd()!=null) {
                    String filename = "src/sql/Regional/retrieveClaimList/RetrieveClaimList_ReasonCd.txt";
                    String text = null;
                    try {
                        text = new String(Files.readAllBytes(Paths.get(filename)));
                        String query = text.replace("%claimNumber%", cc.getClaimNumber().toString().replace("\"", ""));
                        JSONArray jsonReasonCd = executeQueryNoLogs(con, query);
                        if (jsonReasonCd.length() != 0) {
                            JsonObject dbReasonCd = new JsonParser().parse(jsonReasonCd.get(0).toString()).getAsJsonObject();
                            JsonElement reasonCd = dbReasonCd.getAsJsonObject();
                            compareDbToApi_String("reasonCd", reasonCd.getAsJsonObject().get("CLAIM_REASON_CD").toString().replace("\"", ""), cc.getReasonCd());
                            compareDbToApi_String("reasonDesc", reasonCd.getAsJsonObject().get("CLAIM_REASON_CD_DESC").toString().replace("\"", ""), cc.getReasonDesc());
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if(cc.getPendingDocuments()!=null) {
                    String filename = "src/sql/Regional/retrieveClaimList/RetrieveClaimList_PendingDocument.txt";
                    String text = null;
                    try {
                        text = new String(Files.readAllBytes(Paths.get(filename)));
                        String query = text.replace("%claimNumber%", cc.getClaimNumber().toString().replace("\"", ""));
                        JSONArray jsonPendingDocument = executeQueryNoLogs(con, query);
                        if (jsonPendingDocument.length() != 0) {
                            JsonObject dbPendingDocument = new JsonParser().parse(jsonPendingDocument.get(0).toString()).getAsJsonObject();
                            JsonElement pendingDocument = dbPendingDocument.getAsJsonObject();
                            String xmlData = pendingDocument.getAsJsonObject().get("PENDING_DOCUMENTS").toString().replace("\"", "");

                            //String xmlData = xmlPendingDocument;
                            try {
                                builder = factory.newDocumentBuilder();
                                Document document = null;
                                try {
                                    document = builder.parse(new InputSource(new StringReader(xmlData)));
                                    document.getDocumentElement().normalize();

                                    NodeList nList = document.getElementsByTagName("pDocs");

                                    for (int x = 0; x < cc.getPendingDocuments().size(); x++) {
                                        writeToLogFile("=============================================================================");
                                        writeToLogFile("pendingDocuments[" + x + "]");
                                        writeToLogFile("=============================================================================");
                                        PendingDocuments pd = cc.getPendingDocuments().get(x);
                                        Node node = nList.item(x);
                                        if (node.getNodeType() == Node.ELEMENT_NODE) {
                                            Element n = (Element) node;

                                            compareDbToApi_String("followUpCd", n.getElementsByTagName("FOLLOW_UP_CD").item(0).getTextContent(), pd.getFollowUpCd());
                                            compareDbToApi_String("followUpStatus", n.getElementsByTagName("FOLLOW_UP_STATUS").item(0).getTextContent(), pd.getFollowUpStatus());
                                            compareDbToApi_Timestamp_DatePart_toYYYYMMDD("reqDt", n.getElementsByTagName("REQUEST_DT").item(0).getTextContent(), pd.getReqDt());
                                            if (pd.getDocRemarks() != null)
                                                compareDbToApi_String("docRemarks", n.getElementsByTagName("DOCUMENT_REMARKS").item(0).getTextContent(), pd.getDocRemarks());
                                        }

                                    }
                                } catch (SAXException e) {
                                    e.printStackTrace();
                                }

                            } catch (ParserConfigurationException e) {
                                e.printStackTrace();
                            }


                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            writeToLogFile("=============================================================================");
            writeToLogFile("RetrieveClaimListResponse().paginationResult()");
            writeToLogFile("=============================================================================");
            PaginationResult pr = rclr.getPaginationResult();
            CountQuery cq = countQuery[0];
            compareDbToApi_Integer("position", 0, pr.getPosition());
            compareDbToApi_Integer("count", json.length(), pr.getCount());
            compareDbToApi_Integer("totalCount", cq.getTOTALRECCOUNT(), pr.getTotalCount());
            writeToLogFile("=============================================================================");
            writeToLogFile("RetrieveClaimListResponse().sortResponse()");
            writeToLogFile("=============================================================================");
            SortResponse sr = rclr.getSortResponse();
            compareDbToApi_String("sortKey", "POLICY_NUMBER", sr.getSortKey());
            compareDbToApi_String("order", "DESC", sr.getOrder());
            writeToLogFile("=============================================================================");
            writeToLogFile("RetrieveClaimListResponse()");
            writeToLogFile("=============================================================================");
            compareDbToApi_Integer("totalCount", cq.getTOTALRECCOUNT(), rclr.getTotalCount());

        } catch (JsonSyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        writeToLogFile("=============================================================================\n");
        Assert.assertFalse(failedStatus);
    }

}
