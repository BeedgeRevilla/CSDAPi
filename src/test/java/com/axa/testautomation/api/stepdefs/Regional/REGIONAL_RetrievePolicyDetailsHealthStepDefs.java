package com.axa.testautomation.api.stepdefs.Regional;


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

import java.nio.file.Files;
import java.nio.file.Paths;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;


public class REGIONAL_RetrievePolicyDetailsHealthStepDefs extends BaseStepDefs {

    @Autowired
    private String regionalNitRetrievePolicyDetails;

    @Autowired
    private String sg_MDCAC7QI;
    @Autowired
    private String g_SG_CACHE;
    @Autowired
    private String gA_SG_CACHE;
    @Autowired
    private String cachePassword;

    private JSONArray jsonHeader;
    private JSONArray jsonMember;

    private String axaEntity;
    private String policyNumber;
    private String certificateNumber;
    private String sourceSystemCode;

    @Given("the following http headers are set Retrieve Policy Details")
    public void set_http_headers(DataTable dt) {
        failedStatus = false;
        httpHeaders.clear();
        writeToLogFile("====== HEADERS ======");
        for(Map<String, String> row : dt.asMaps()) {
            for(Map.Entry<String, String> headerMap : row.entrySet()) {
                httpHeaders.set(headerMap.getKey(), headerMap.getValue());
                writeToLogFile(headerMap.getKey() + ": " + headerMap.getValue());
                if(headerMap.getKey().equalsIgnoreCase("x-axa-entity")) {
                    axaEntity = headerMap.getValue();
                }
            }
        }
        writeToLogFile("=====================");
    }


    @And("the following GET input parameters are set for Retrieve Policy Details")
    public void set_get_parameters(DataTable dt) {
        failedStatus = false;
        getParameters = "?";
        for(Map<String, String> row : dt.asMaps()) {
            for(Map.Entry<String, String> getParametersMap : row.entrySet()) {
                if(getParametersMap.getKey().equalsIgnoreCase("policyNumber")){
                    regionalNitRetrievePolicyDetails = regionalNitRetrievePolicyDetails.replace("{policyNumber}", getParametersMap.getValue());
                } else {
                    getParameters = getParameters + getParametersMap.getKey() + "=" + getParametersMap.getValue() + "&";
                }

                switch (getParametersMap.getKey()){
                    case "policyNumber": policyNumber = getParametersMap.getValue(); break;
                    case "certificateNumber": certificateNumber = getParametersMap.getValue(); break;
                    case "sourceSystemCode": sourceSystemCode = getParametersMap.getValue(); break;
                }
            }
        }
        getParameters = getParameters.substring(0, getParameters.length()-1);
        writeToLogFile("PARAMETER: " + getParameters);
    }

    @When("the api call has been made for Retrieve Policy Details")
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
            String url = regionalNitRetrievePolicyDetails + getParameters;
            writeToLogFile("ENDPOINT: " + regionalNitRetrievePolicyDetails);
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

    @When("the Stored Procedure is called for Retrieve Policy Details")
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
        String dbConnection = "";
        String userName = "";
        String password = "";
        try{
            //step1 load the driver class
            Class.forName("oracle.jdbc.driver.OracleDriver");

            switch (axaEntity.toLowerCase()){
                case "sg": dbConnection = sg_MDCAC7QI;
		                if (sourceSystemCode.equalsIgnoreCase("GASIA")){
		                	userName = gA_SG_CACHE;
		                }else{
		                	userName = g_SG_CACHE;
		                }
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
            filename = "src/sql/Regional/retrievePolicyDetails/header_v5.txt";
            text = new String(Files.readAllBytes(Paths.get(filename)));
            query = text.replace("%policyNumber%", policyNumber);
            writeToLogFile("[SQL Query]");
            writeToLogFile(query);
            jsonHeader = executeQuery(con, query);

            //member
            //filename = "src/sql/Regional/retrievePolicyDetails/member_v13 (DASI-1434).txt";
            //Aug092019-RPDHealth-retrieveMember
            //filename = "src/sql/Regional/retrievePolicyDetails/Aug092019-RPDHealth-retrieveMember.txt";
//            text = new String(Files.readAllBytes(Paths.get(filename)));
//            query = text.replace("${POLICY_NO}", policyNumber)
//                    .replace("${CERT_NO}", certificateNumber)
//                    .replace("${LOB}", sourceSystemCode)
            filename = "src/sql/Regional/retrievePolicyDetails/MEMBER_01282020.txt";
            text = new String(Files.readAllBytes(Paths.get(filename)));
            query = text.replace("%policyNumber%", policyNumber)
                    .replace("%certificateNumber%", certificateNumber)
            ;
            writeToLogFile("[SQL Query]");
            writeToLogFile(query);
            jsonMember = executeQuery(con, query);

            
            //step5 close the connection object
            con.close();

        }catch(Exception e){
            failedStatus = true;
            scenario.write(e.toString());
            writeToLogFile(e.toString());
            Assert.assertFalse(failedStatus);

        }
    }
    
    @Then("verify that API and DB responses matched for Retrieve Policy Details")
    public void api_match_db() {
        JsonObject api = new JsonParser().parse(response.getBody()).getAsJsonObject();
        JsonObject dbHeader = null;
        JsonObject dbMember = null;
        try {
            dbHeader = new JsonParser().parse(jsonHeader.get(0).toString()).getAsJsonObject();
            if(jsonMember.length()!=0)
            dbMember = new JsonParser().parse(jsonMember.get(0).toString()).getAsJsonObject();
        } catch (JsonSyntaxException e) { e.printStackTrace(); Assert.assertFalse(true);
        } catch (JSONException e) { e.printStackTrace(); Assert.assertFalse(true);
        }

        writeToLogFile("[Validations]");
        writeToLogFile("=============================================================================");
        JsonElement a = api.get("RetrievePolicyDetailsResponse").getAsJsonObject().get("healthPolicy");
        writeToLogFile("\nRetrievePolicyDetailsResponse().healthPolicy()");
        writeToLogFile("=============================================================================");
        JsonElement b = dbHeader.getAsJsonObject();
        compareDbToApi_String("issuingBranchCode1", b.getAsJsonObject().get("CNTBRANCH"), a.getAsJsonObject().get("issuingBranchCode1"));
        compareDbToApi_Timestamp_DatePart_toYYYYMMDD("originalInceptionDate", b.getAsJsonObject().get("OCCDATE"), a.getAsJsonObject().get("originalInceptionDate"));
        compareDbToApi_Timestamp_DatePart_toYYYYMMDD("policyEffectiveDate", b.getAsJsonObject().get("CCDATE"), a.getAsJsonObject().get("policyEffectiveDate"));
        compareDbToApi_Timestamp_DatePart_toYYYYMMDD("policyExpirationDate", b.getAsJsonObject().get("CRDATE"), a.getAsJsonObject().get("policyExpirationDate"));
        compareDbToApi_String("policyNumber", b.getAsJsonObject().get("CHDRNUM"), a.getAsJsonObject().get("policyNumber"));
        compareDbToApi_String("policyStatusCode", b.getAsJsonObject().get("STATCODE"), a.getAsJsonObject().get("policyStatusCode"));
        compareDbToApi_String("producingAgentCode1", b.getAsJsonObject().get("AGNTNUM"), a.getAsJsonObject().get("producingAgentCode1"));
        compareDbToApi_String("productCode", b.getAsJsonObject().get("CNTTYPE"), a.getAsJsonObject().get("productCode"));
        compareDbToApi_String("sourceSystemCode", b.getAsJsonObject().get("SRCEBUS"), a.getAsJsonObject().get("sourceSystemCode"));
        compareDbToApi_String("certificateNumber", certificateNumber, a.getAsJsonObject().get("certificateNumber"));
        compareDbToApi_Timestamp_DatePart_toYYYYMMDD("policyRenewalDate", b.getAsJsonObject().get("BTDATENR"), a.getAsJsonObject().get("policyRenewalDate"));
        writeToLogFile("=============================================================================");
        a = api.get("RetrievePolicyDetailsResponse").getAsJsonObject().get("healthPolicy").getAsJsonObject().get("product");
        writeToLogFile("\nRetrievePolicyDetailsResponse().healthPolicy().product()");
        writeToLogFile("=============================================================================");
        compareDbToApi_String("productName", b.getAsJsonObject().get("LONGDESC"), a.getAsJsonObject().get("productName"));
        writeToLogFile("=============================================================================");
        a = api.get("RetrievePolicyDetailsResponse").getAsJsonObject().get("healthPolicy").getAsJsonObject().get("partyRoles").getAsJsonArray().get(0);
        writeToLogFile("\nRetrievePolicyDetailsResponse().healthPolicy().partyRoles[0]");
        writeToLogFile("=============================================================================");
        compareDbToApi_String("partyRoleCode", "OWN", a.getAsJsonObject().get("partyRoleCode"));
        writeToLogFile("=============================================================================");
        a = api.get("RetrievePolicyDetailsResponse").getAsJsonObject().get("healthPolicy").getAsJsonObject().get("partyRoles").getAsJsonArray().get(0).getAsJsonObject().get("party");
        writeToLogFile("\nRetrievePolicyDetailsResponse().healthPolicy().partyRoles[0].party()");
        writeToLogFile("=============================================================================");
        compareAPItoDB("firstName", b.getAsJsonObject().get("LGIVNAME"), a.getAsJsonObject().get("firstName"));
        compareDbToApi_String("lastName", b.getAsJsonObject().get("LSURNAME_OWNER"), a.getAsJsonObject().get("lastName"));
        compareDbToApi_String("partyId", b.getAsJsonObject().get("COWNNUM"), a.getAsJsonObject().get("partyId"));
        writeToLogFile("=============================================================================");
        a = api.get("RetrievePolicyDetailsResponse").getAsJsonObject().get("healthPolicy").getAsJsonObject().get("corePolicyAgents").getAsJsonArray().get(0).getAsJsonObject().get("party");
        writeToLogFile("\nRetrievePolicyDetailsResponse().healthPolicy().corePolicyAgents[0].party()");
        writeToLogFile("=============================================================================");
        compareDbToApi_String("lastName", b.getAsJsonObject().get("LSURNAME_PRODUCER"), a.getAsJsonObject().get("lastName"));
        writeToLogFile("=============================================================================");
        a = api.get("RetrievePolicyDetailsResponse").getAsJsonObject().get("healthPolicy");
        writeToLogFile("\nRetrievePolicyDetailsResponse().healthPolicy()");
        writeToLogFile("=============================================================================");
        compareDbToApi_String("oldPolicyNumber", b.getAsJsonObject().get("FMRPOL"), a.getAsJsonObject().get("oldPolicyNumber"));

        //PolicyCoverage
        if ((jsonMember.length()!=0) && (api.get("RetrievePolicyDetailsResponse").getAsJsonObject().get("healthPolicy").getAsJsonObject().get("PolicyCoverage")!=null)){
	        a = api.get("RetrievePolicyDetailsResponse").getAsJsonObject().get("healthPolicy").getAsJsonObject().get("PolicyCoverage").getAsJsonArray().get(0).getAsJsonObject().get("HealthCoverage").getAsJsonObject().get("Insured").getAsJsonArray().get(0);
	        for(int i=0; i<a.getAsJsonObject().get("HealthProduct").getAsJsonArray().size(); i++) {
                JsonElement c = a.getAsJsonObject().get("HealthProduct").getAsJsonArray().get(i);
                writeToLogFile("=============================================================================");
                writeToLogFile("\nRetrievePolicyDetailsResponse().healthPolicy().PolicyCoverage[0].HealthCoverage().Insured[0].HealthProduct[" + i + "]");
                writeToLogFile("=============================================================================");
                String productCode = c.getAsJsonObject().get("productCode").toString().replace("\"", "");
                JSONArray jsonHealthProduct = null;
                try {
                    String dbConnection = null;
                    String userName = null;
                    String password = null;

                    switch (axaEntity.toLowerCase()) {
                        case "sg":
                            dbConnection = sg_MDCAC7QI;
                            if (sourceSystemCode.equalsIgnoreCase("GASIA")) {
                                userName = gA_SG_CACHE;
                            } else {
                                userName = g_SG_CACHE;
                            }
                            password = cachePassword;
                            break;
                    }
                    Connection con = DriverManager.getConnection(
                            "jdbc:oracle:thin:@//" + dbConnection, userName, password);

                    String filename = "src/sql/Regional/retrievePolicyDetails/Aug092019-RPDHealth-retrieveMember_HealthProduct.txt";
                    String text = new String(Files.readAllBytes(Paths.get(filename)));
                    String query = text.replace("${POLICY_NO}", policyNumber)
                            .replace("${CERT_NO}", certificateNumber)
                            .replace("${LOB}", sourceSystemCode)
                            .replace("%productCode%", productCode);
                    //jsonHealthProduct = executeQuery(con, query);
                    jsonHealthProduct = executeQueryNoLogs(con, query);
                    con.close();
                } catch (Exception e) {
                    writeToLogFile(e.toString());
                    Assert.assertFalse(true);
                }


                if (jsonHealthProduct.length()!=0){
                    JsonObject dbHealthProduct = null;
                    try {
                        dbHealthProduct = new JsonParser().parse(jsonHealthProduct.get(0).toString()).getAsJsonObject();
                        JsonElement d = dbHealthProduct.getAsJsonObject();
                        compareDbToApi_Timestamp_DatePart_toYYYYMMDD("productStartDate", d.getAsJsonObject().get("DTEATT"), c.getAsJsonObject().get("productStartDate"));
                        compareDbToApi_String("productCode", d.getAsJsonObject().get("PRODTYP"), c.getAsJsonObject().get("productCode"));
                        compareDbToApi_String("familyCode", d.getAsJsonObject().get("FMLYCDE"), c.getAsJsonObject().get("familyCode"));
                        compareDbToApi_String("underwriteringDecision", d.getAsJsonObject().get("DECFLG"), c.getAsJsonObject().get("underwriteringDecision"));
                        compareDbToApi_Integer("preExistingCondStart", d.getAsJsonObject().get("PREEXIAFT"), c.getAsJsonObject().get("preExistingCondStart"));
                        compareDbToApi_Integer("preExistingCondEnd", d.getAsJsonObject().get("PREEXIBEF"), c.getAsJsonObject().get("preExistingCondEnd"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                //PLAN
                for (int i2 = 0; i2 < c.getAsJsonObject().get("Plan").getAsJsonArray().size(); i2++) {
                    JsonElement plan = c.getAsJsonObject().get("Plan").getAsJsonArray().get(i2);
                    writeToLogFile("=============================================================================");
                    writeToLogFile("\nHealthProduct[" + i + "].Plan[" + i2 + "]");
                    writeToLogFile("=============================================================================");
                    String benefitCd = null;
                    if (plan.getAsJsonObject().get("benefitCd") != null)
                        benefitCd = plan.getAsJsonObject().get("benefitCd").toString().replace("\"", "");

                    int iCtr = 0;
                    for (int i3 = 0; i3 < jsonMember.length(); i3++) {
                        try {
                            dbMember = new JsonParser().parse(jsonMember.get(i3).toString()).getAsJsonObject();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        if (benefitCd == null) {
                            if (dbMember.getAsJsonObject().get("PRODTYP").toString().equalsIgnoreCase(c.getAsJsonObject().get("productCode").toString()) && dbMember.getAsJsonObject().get("BENCDE") == null) {
                                iCtr = i3;
                                break;
                            }
                        } else {
                            if (dbMember.getAsJsonObject().get("BENCDE") != null) {
                                if (dbMember.getAsJsonObject().get("PRODTYP").toString().equalsIgnoreCase(c.getAsJsonObject().get("productCode").toString()) && dbMember.getAsJsonObject().get("BENCDE").toString().equalsIgnoreCase(plan.getAsJsonObject().get("benefitCd").toString())) {
                                    iCtr = i3;
                                    break;
                                }
                            }
                        }
                    }

                    try {
                        dbMember = new JsonParser().parse(jsonMember.get(iCtr).toString()).getAsJsonObject();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    compareDbToApi_String("planCode", dbMember.getAsJsonObject().get("PLANNO"), plan.getAsJsonObject().get("planCode"));
                    compareDbToApi_String("planDescription", dbMember.getAsJsonObject().get("DESCN"), plan.getAsJsonObject().get("planDescription"));
                    compareDbToApi_Timestamp_DatePart_toYYYYMMDD("planEffectiveDate", dbMember.getAsJsonObject().get("EFFDATE"), plan.getAsJsonObject().get("planEffectiveDate"));
                    compareDbToApi_String("originalPlanCode", dbMember.getAsJsonObject().get("PLANNO"), plan.getAsJsonObject().get("originalPlanCode"));
                    compareDbToApi_String("whomToApplyLimit", dbMember.getAsJsonObject().get("LMTWHOM"), plan.getAsJsonObject().get("whomToApplyLimit"));
                    writeToLogFile("=============================================================================");
                    writeToLogFile("\nHealthProduct[" + i + "].Plan[" + i2 + "].ProviderNetwork()");
                    writeToLogFile("=============================================================================");
                    compareDbToApi_String("providerNetworkCode", dbMember.getAsJsonObject().get("PROVNET"), plan.getAsJsonObject().get("ProviderNetwork").getAsJsonObject().get("providerNetworkCode"));
                    compareAPItoDB("benefitCd", dbMember.getAsJsonObject().get("BENCDE"), plan.getAsJsonObject().get("benefitCd"));

                    if (plan.getAsJsonObject().get("healthProductRemark") != null) {
                        writeToLogFile("=============================================================================");
                        writeToLogFile("\nHealthProduct[" + i + "].Plan[" + i2 + "].healthProductRemark().aggregateLimit()");
                        writeToLogFile("=============================================================================");
                        if (plan.getAsJsonObject().get("healthProductRemark").getAsJsonObject().get("aggregateLimit") != null) {
                            JsonElement aggregateLimit = plan.getAsJsonObject().get("healthProductRemark").getAsJsonObject().get("aggregateLimit");
                            compareDbToApi_Decimal("amtLife", dbMember.getAsJsonObject().get("AMTLIFE"), aggregateLimit.getAsJsonObject().get("amtLife"));
                            compareDbToApi_Decimal("amtMonth", dbMember.getAsJsonObject().get("AMTMNTH"), aggregateLimit.getAsJsonObject().get("amtMonth"));
                            compareDbToApi_Decimal("amtYear", dbMember.getAsJsonObject().get("AMTYEAR"), aggregateLimit.getAsJsonObject().get("amtYear"));
                            compareDbToApi_Integer("visitLife", dbMember.getAsJsonObject().get("VISLIFE"), aggregateLimit.getAsJsonObject().get("visitLife"));
                            compareDbToApi_Integer("visitMonth", dbMember.getAsJsonObject().get("VISMNTH"), aggregateLimit.getAsJsonObject().get("visitMonth"));
                            compareDbToApi_Integer("visitYear", dbMember.getAsJsonObject().get("VISYEAR"), aggregateLimit.getAsJsonObject().get("visitYear"));
                            writeToLogFile("=============================================================================");
                            writeToLogFile("\nHealthProduct[" + i + "].Plan[" + i2 + "].healthProductRemark().perVisitLimit()");
                            writeToLogFile("=============================================================================");
                            JsonElement perVisitLimit = plan.getAsJsonObject().get("healthProductRemark").getAsJsonObject().get("perVisitLimit");
                            compareDbToApi_Decimal("amtDay", dbMember.getAsJsonObject().get("AMTDAY"), perVisitLimit.getAsJsonObject().get("amtDay"));
                            compareDbToApi_Decimal("amtProcedure", dbMember.getAsJsonObject().get("AMTPROC"), perVisitLimit.getAsJsonObject().get("amtProcedure"));
                            compareDbToApi_Integer("amtProcedureAsRelative", dbMember.getAsJsonObject().get("AMTPROPR"), perVisitLimit.getAsJsonObject().get("amtProcedureAsRelative"));
                            compareDbToApi_Decimal("amtVisit", dbMember.getAsJsonObject().get("AMTVIS"), perVisitLimit.getAsJsonObject().get("amtVisit"));
                            //TODO
                            compareDbToApi_Integer("benefitFormula", dbMember.getAsJsonObject().get("PREEXIBEF"), perVisitLimit.getAsJsonObject().get("benefitFormula"));
                            compareDbToApi_Integer("consecutiveDays", dbMember.getAsJsonObject().get("ZCONSDAY"), perVisitLimit.getAsJsonObject().get("consecutiveDays"));
                            compareDbToApi_Integer("dayVisit", dbMember.getAsJsonObject().get("DAYSVIS"), perVisitLimit.getAsJsonObject().get("dayVisit"));
                            //TODO
                            compareDbToApi_Integer("useLimit", dbMember.getAsJsonObject().get("AMTPROPR"), perVisitLimit.getAsJsonObject().get("useLimit"));
                        }
                    }
                    if (plan.getAsJsonObject().get("cardType01") != null) {
                        writeToLogFile("=============================================================================");
                        writeToLogFile("\nHealthProduct[" + i + "].Plan[" + i2 + "]");
                        writeToLogFile("=============================================================================");
                        compareDbToApi_String("cardType01", dbMember.getAsJsonObject().get("CARDTYPE01"), plan.getAsJsonObject().get("cardType01"));
                    }
                }

	        }
        }

        writeToLogFile("=============================================================================");
        a = api.get("RetrievePolicyDetailsResponse").getAsJsonObject().get("healthPolicy").getAsJsonObject().get("PolicyInstallment");
        writeToLogFile("\nRetrievePolicyDetailsResponse().healthPolicy().PolicyInstallment()");
        writeToLogFile("=============================================================================");
        compareDbToApi_String("billingFrequencyCode", b.getAsJsonObject().get("BILLFREQ"), a.getAsJsonObject().get("billingFrequencyCode"));

        writeToLogFile("=============================================================================\n");
        Assert.assertFalse(failedStatus);
    }

}
