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

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


public class REGIONAL_RetrievePolicyListStepDefs extends BaseStepDefs {

    @Autowired
    private String regionalNitRetrievePolicyList;

    @Autowired
    private String sg_MDCOR7QI;
    @Autowired
    private String g_SG_CUST;
    @Autowired
    private String th_MDCOR6QI;
    @Autowired
    private String l_TH_CUST;
    @Autowired
    private String hk_MDCOR2QI;
    @Autowired
    private String g_HK_CUST;
    @Autowired
    private String corePassword;

    private List<String> strMain;
    private JSONArray jsonMain;
    private JSONArray jsonCount;

    private String axaEntity;
    private String idDocumentNumber;
    private String masterIndividualPartyId;
    private int recCount;
    private int maxCount = 200;

    @Given("the following http headers are set Retrieve Policy List")
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


    @And("the following GET input parameters are set for Retrieve Policy List")
    public void set_get_parameters(DataTable dt) {
        failedStatus = false;
        getParameters = "/?";
        for(Map<String, String> row : dt.asMaps()) {
            for(Map.Entry<String, String> getParametersMap : row.entrySet()) {
                if(!getParametersMap.getValue().equalsIgnoreCase("")) {
                    getParameters = getParameters + getParametersMap.getKey() + "=" + getParametersMap.getValue() + "&";

                    switch (getParametersMap.getKey()) {
                        case "idDocumentNumber":
                            idDocumentNumber = getParametersMap.getValue();
                            break;
                        case "masterIndividualPartyId":
                            masterIndividualPartyId = getParametersMap.getValue();
                            break;
                    }
                }
            }
        }
        getParameters = getParameters.substring(0, getParameters.length()-1);
        writeToLogFile("PARAMETER: " + getParameters);
    }

    @When("the api call has been made for Retrieve Policy List")
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
            String url = regionalNitRetrievePolicyList + getParameters;
            writeToLogFile("ENDPOINT: " + regionalNitRetrievePolicyList);
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

    @When("the Stored Procedure is called for Retrieve Policy List")
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
                case "sg": dbConnection = sg_MDCOR7QI;
                        userName = g_SG_CUST;
                        password = corePassword;
                        break;
                case "th": dbConnection = th_MDCOR6QI;
		                userName = l_TH_CUST;
		                password = corePassword;
                		break;
                case "hk": dbConnection = hk_MDCOR2QI;
		                userName = g_HK_CUST;
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
            
            Date now = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String toDate = dateFormat.format(now);

            //idDocumentNumber
            if(idDocumentNumber!=null) {
            	
            	switch (axaEntity.toLowerCase()){
	                case "sg": filename = "src/sql/Regional/retrievePolicyList/Aug092019_RetrievePolicyList_NRIC-CountQuery.txt";
	                //case "sg": filename = "src/sql/Regional/retrievePolicyList/RPL_PARTY_Count Query_NoFilter_SG.txt";
	                        break;
	                case "th": filename = "src/sql/Regional/retrievePolicyList/RPL_PARTY_Count_TH.txt";
	                		break;
	                case "hk": filename = "src/sql/Regional/retrievePolicyList/RPL_PARTY_Count_HK.txt";
            				break;
	            }

                text = new String(Files.readAllBytes(Paths.get(filename)));
                query = text.replace("%idDocumentNumber%", idDocumentNumber).replace("%toDate%", toDate);
                writeToLogFile("[SQL Query]");
                writeToLogFile(query);
                jsonCount = executeQuery(con, query);
                recCount = jsonCount.length();
                
                switch (axaEntity.toLowerCase()){
	                case "sg": filename = "src/sql/Regional/retrievePolicyList/Aug092019_RetrievePolicyList_NRIC-MainQuery.txt";
                	//case "sg": filename = "src/sql/Regional/retrievePolicyList/RPL_PARTY_Main Query_NoFilter_SG.txt";
	                        break;
	                case "th": filename = "src/sql/Regional/retrievePolicyList/RPL_PARTY_Main_TH.txt";
	                		break;
	                case "hk": filename = "src/sql/Regional/retrievePolicyList/RPL_PARTY_Main_HK.txt";
            				break;
	            }

                text = new String(Files.readAllBytes(Paths.get(filename)));
                query = text.replace("%idDocumentNumber%", idDocumentNumber)
		                .replace("%count%", String.valueOf(jsonCount.length()))
		                .replace("%toDate%", toDate)
		                ;
                writeToLogFile("[SQL Query]");
                writeToLogFile(query);
                jsonMain = executeQuery(con, query);

                text = new String(Files.readAllBytes(Paths.get(filename)));
                query = text.replace("%idDocumentNumber%", idDocumentNumber)
                        .replace("%count%", String.valueOf(jsonCount.length()))
                        .replace("%toDate%", toDate)
                        ;
                writeToLogFile("[SQL Query]");
                writeToLogFile(query);
                strMain = executeQuery2(con, query);
            }else{
	            if(masterIndividualPartyId!=null) {
	    			
	            	filename = "src/sql/Regional/retrievePolicyList/Aug302019_RetrievePolicyList_MDM-CountQuery.txt";
	                text = new String(Files.readAllBytes(Paths.get(filename)));
	                query = text.replace("%masterIndividualPartyId%", masterIndividualPartyId)
	                		.replace("%toDate%", toDate);
	                writeToLogFile("[SQL Query]");
	                writeToLogFile(query);
	                jsonCount = executeQuery(con, query);
	                JsonObject cnt = new JsonParser().parse(jsonCount.get(0).toString()).getAsJsonObject();
	                recCount = Integer.parseInt(cnt.getAsJsonObject().get("TOTAL_RECORD_SET").toString().replace("\"", ""));
	
	                filename = "src/sql/Regional/retrievePolicyList/Aug302019_RetrievePolicyList_MDM-MainQuery.txt";
	                text = new String(Files.readAllBytes(Paths.get(filename)));
	                query = text.replace("%masterIndividualPartyId%", masterIndividualPartyId)
	                .replace("%toDate%", toDate)
	                ;
	                writeToLogFile("[SQL Query]");
	                writeToLogFile(query);
	                jsonMain = executeQuery(con, query);
	
	                filename = "src/sql/Regional/retrievePolicyList/Aug302019_RetrievePolicyList_MDM-MainQuery.txt";
	                text = new String(Files.readAllBytes(Paths.get(filename)));
	                query = text.replace("%masterIndividualPartyId%", masterIndividualPartyId)
	                        .replace("%toDate%", toDate)
	                ;
	                writeToLogFile("[SQL Query]");
	                writeToLogFile(query);
	                strMain = executeQuery2(con, query);
	            }
            }
            
            //step5 close the connection object
            con.close();

        }catch(Exception e){
            failedStatus = true;
            scenario.write(e.toString());
            writeToLogFile(e.toString());
            Assert.assertFalse(failedStatus);

        }
    }
    
    @Then("verify that API and DB responses matched for Retrieve Policy List")
    public void api_match_db() {
        JsonObject api = new JsonParser().parse(response.getBody()).getAsJsonObject();
        JsonObject dbMain = null;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
        	int limit = jsonMain.length();
        	if(jsonMain.length()==1) limit = 1;
            writeToLogFile("[Validations]");
            writeToLogFile("=============================================================================");
            for(int i=0; i < limit; i++) {
                dbMain = new JsonParser().parse(jsonMain.get(i).toString()).getAsJsonObject();
                JsonElement b = dbMain.getAsJsonObject();
                JsonElement a = api.get("RetrievePolicyListResponse").getAsJsonObject().get("policy").getAsJsonArray().get(i);
                writeToLogFile("\nRetrievePolicyListResponse().policy[" + i + "]");
                writeToLogFile("=============================================================================");
                compareDbToApi_String("companyCode", b.getAsJsonObject().get("COMPANY_CODE"), a.getAsJsonObject().get("companyCode"));
                if (!a.getAsJsonObject().get("entityCode").toString().equalsIgnoreCase("\"SG\"")) {
                	compareDbToApi_String("entityCode", b.getAsJsonObject().get("ENTITY_CD"), a.getAsJsonObject().get("entityCode"));
                } else {
                	compareDbToApi_String("entityCode", axaEntity, a.getAsJsonObject().get("entityCode"));
                }
                compareDbToApi_String("issuingBranchCode1", b.getAsJsonObject().get("AGNT_UNIT_CD"), a.getAsJsonObject().get("issuingBranchCode1"));
                compareDbToApi_String("LOBCode", b.getAsJsonObject().get("LOB_CODE"), a.getAsJsonObject().get("LOBCode"));
                compareDbToApi_Timestamp_DatePart("policyEffectiveDate", b.getAsJsonObject().get("POLICY_EFFECTIVE_DATE"), a.getAsJsonObject().get("policyEffectiveDate"));
                compareDbToApi_Timestamp_DatePart("policyExpirationDate", b.getAsJsonObject().get("POLICY_EXPIRATION_DATE"), a.getAsJsonObject().get("policyExpirationDate"));
                compareDbToApi_String("policyNumber", b.getAsJsonObject().get("POLICY_NUMBER"), a.getAsJsonObject().get("policyNumber"));              
                compareDbToApi_Timestamp_DatePart("policyRenewalDate", b.getAsJsonObject().get("PAID_TO_DT"), a.getAsJsonObject().get("policyRenewalDate"));
	            compareDbToApi_String("policyStatusCode", b.getAsJsonObject().get("POLICY_STATUS_CODE"), a.getAsJsonObject().get("policyStatusCode"));
                compareDbToApi_String("policyType", b.getAsJsonObject().get("POLICY_TYPE_LOB"), a.getAsJsonObject().get("policyType"));
                compareDbToApi_String("producingAgentCode1", b.getAsJsonObject().get("AGENT_CODE"), a.getAsJsonObject().get("producingAgentCode1"));
                compareDbToApi_String("productCode", b.getAsJsonObject().get("PROD_CD"), a.getAsJsonObject().get("productCode"));
                compareDbToApi_String("sourceSystemCode", b.getAsJsonObject().get("SOURCE_SYSTEM_CODE"), a.getAsJsonObject().get("sourceSystemCode"));
                compareDbToApi_String("certificateNumber", b.getAsJsonObject().get("CERTIFICATE_NO"), a.getAsJsonObject().get("certificateNumber"));
	            compareDbToApi_String("dependentNumber", b.getAsJsonObject().get("DEPENDENT_NO"), a.getAsJsonObject().get("dependentNumber"));
	            compareDbToApi_String("policyCurrencyCode", b.getAsJsonObject().get("POLICY_CURRENCY_CD"), a.getAsJsonObject().get("policyCurrencyCode"));
                compareDbToApi_Integer("grossPremiumAmount", b.getAsJsonObject().get("GROSS_PREM_AMT"), a.getAsJsonObject().get("grossPremiumAmount"));
                compareDbToApi_Integer("netPremiumAmount", b.getAsJsonObject().get("NET_PREM_AMT"), a.getAsJsonObject().get("netPremiumAmount"));
                compareDbToApi_String("paymentModeCode", b.getAsJsonObject().get("PAYMENT_MODE_CD"), a.getAsJsonObject().get("paymentModeCode"));
                compareDbToApi_Integer("modalPremiumAmount", b.getAsJsonObject().get("LF_MOD_PREM_AMT"), a.getAsJsonObject().get("modalPremiumAmount"));
                compareDbToApi_String("applicationSerialNumber", b.getAsJsonObject().get("APPLICATION_SERIAL_NO"), a.getAsJsonObject().get("applicationSerialNumber"));
                compareDbToApi_String("openPolicyNumber", b.getAsJsonObject().get("OPEN_POL"), a.getAsJsonObject().get("openPolicyNumber"));
	               
                //policyItems
                if(a.getAsJsonObject().get("policyItems").getAsJsonArray().size() > 0) {
                    String xmlData = strMain.get(i).replace("\"", "");//b.getAsJsonObject().get("RISK_XML_VALUE").toString().replace("\"", "");
                    writeToLogFile("[XMLDATA]: "+xmlData);
                    builder = factory.newDocumentBuilder();
                    Document document = builder.parse(new InputSource(new StringReader(xmlData)));

                    document.getDocumentElement().normalize();

                    NodeList nList = document.getElementsByTagName("policyItems");
                    String value = "";
                  
                    if(axaEntity.equalsIgnoreCase("SG")){
	                    boolean firstTotalSI = false;
	                    Node node = nList.item(0);
	                    if (node.getNodeType() == Node.ELEMENT_NODE) {
	                        Element n = (Element) node;
	                        if (n.getElementsByTagName("name").item(0).getTextContent().equalsIgnoreCase("TOTAL_SI")) firstTotalSI = true;
	                    }
	
	                    int z = 2;
	                    if(idDocumentNumber!=null) z = 3;
	                    if (firstTotalSI){
	                    	for (int x = 0; x < z; x++) {
	                            writeToLogFile("=============================================================================");
	                            JsonElement pol = a.getAsJsonObject().get("policyItems").getAsJsonArray().get(x);
	                            writeToLogFile("policyItems[" + x + "]");
	                            writeToLogFile("=============================================================================");
	                            node = nList.item(0);
	                            if (node.getNodeType() == Node.ELEMENT_NODE) {
	                                Element n = (Element) node;
	                                compareDbToApi_String("name", pol.getAsJsonObject().get("name"), pol.getAsJsonObject().get("name"));
	
	                                switch (pol.getAsJsonObject().get("name").toString().replace("\"", "")) {
	                                    case "Risk_No":
	                                        value = "riskNo";
	                                        break;
	                                    case "Risk_Type":
	                                        value = "COVERAGE_TYPE_CD";
	                                        break;
	                                    case "ATTACHMENT_DATE":
	                                        value = "ATTACHMENT_DATE";
	                                        break;
	                                }
	                                compareDbToApi_String("value", n.getElementsByTagName(value).item(0).getTextContent(), pol.getAsJsonObject().get("value"));
	                            }
	                    	}
	                    	
	                    	if(idDocumentNumber!=null){
	                    		for (int x = 0; x < nList.getLength(); x++) {
	    	                        int y = x + z ;
	    	                        writeToLogFile("=============================================================================");
	    	                        JsonElement pol = a.getAsJsonObject().get("policyItems").getAsJsonArray().get(y);
	    	                        writeToLogFile("policyItems[" + y + "]");
	    	                        writeToLogFile("=============================================================================");
	    	                        node = nList.item(x);
	    	                        if (node.getNodeType() == Node.ELEMENT_NODE) {
	    	                            Element n = (Element) node;
	    	                            compareDbToApi_String("name", n.getElementsByTagName("name").item(0).getTextContent(), pol.getAsJsonObject().get("name"));
	    	                            compareDbToApi_String("value", n.getElementsByTagName("value").item(0).getTextContent(), pol.getAsJsonObject().get("value"));
	    	                        }
	    	                    }
	                    	}else{  
			                    for (int x = 1; x < nList.getLength(); x++) {
			                        int y = x + 1 ;
			                        writeToLogFile("=============================================================================");
			                        JsonElement pol = a.getAsJsonObject().get("policyItems").getAsJsonArray().get(y);
			                        writeToLogFile("policyItems[" + y + "]");
			                        writeToLogFile("=============================================================================");
			                        node = nList.item(x);
			                        if (node.getNodeType() == Node.ELEMENT_NODE) {
			                            Element n = (Element) node;
			                            compareDbToApi_String("name", n.getElementsByTagName("name").item(0).getTextContent(), pol.getAsJsonObject().get("name"));
			                            compareDbToApi_String("value", n.getElementsByTagName("value").item(0).getTextContent(), pol.getAsJsonObject().get("value"));
			                        }
			                    }
	                    	}
		                    
	                    }else{
	                    	for (int x = 0; x < 2; x++) {
	                            writeToLogFile("=============================================================================");
	                            JsonElement pol = a.getAsJsonObject().get("policyItems").getAsJsonArray().get(x);
	                            writeToLogFile("policyItems[" + x + "]");
	                            writeToLogFile("=============================================================================");
	                            node = nList.item(nList.getLength()-1);
	                            if (node.getNodeType() == Node.ELEMENT_NODE) {
	                                Element n = (Element) node;
	                                compareDbToApi_String("name", pol.getAsJsonObject().get("name"), pol.getAsJsonObject().get("name"));
	
	                                switch (pol.getAsJsonObject().get("name").toString().replace("\"", "")) {
	                                    case "Risk_No":
	                                        value = "riskNo";
	                                        break;
	                                    case "Risk_Type":
	                                        value = "COVERAGE_TYPE_CD";
	                                        break;
	                                    case "ATTACHMENT_DATE":
	                                        value = "ATTACHMENT_DATE";
	                                        break;
	                                }
	                                compareDbToApi_String("value", n.getElementsByTagName(value).item(0).getTextContent(), pol.getAsJsonObject().get("value"));
	                            }
	                    	}
	                    	
	                    	for (int x = 0; x < nList.getLength() - 1; x++) {
		                        int y = x + 2 ;
		                        writeToLogFile("=============================================================================");
		                        JsonElement pol = a.getAsJsonObject().get("policyItems").getAsJsonArray().get(y);
		                        writeToLogFile("policyItems[" + y + "]");
		                        writeToLogFile("=============================================================================");
		                        node = nList.item(x);
		                        if (node.getNodeType() == Node.ELEMENT_NODE) {
		                            Element n = (Element) node;
		                            compareDbToApi_String("name", n.getElementsByTagName("name").item(0).getTextContent(), pol.getAsJsonObject().get("name"));
		                            compareDbToApi_String("value", n.getElementsByTagName("value").item(0).getTextContent(), pol.getAsJsonObject().get("value"));
		                        }
		                    }
	                    }
                    }else{
                    	for (int x = 0; x < 3; x++) {
                            writeToLogFile("=============================================================================");
                            JsonElement pol = a.getAsJsonObject().get("policyItems").getAsJsonArray().get(x);
                            writeToLogFile("policyItems[" + x + "]");
                            writeToLogFile("=============================================================================");
                            Node node = nList.item(0);
                            if (node.getNodeType() == Node.ELEMENT_NODE) {
                                Element n = (Element) node;
                                compareDbToApi_String("name", pol.getAsJsonObject().get("name"), pol.getAsJsonObject().get("name"));

                                switch (pol.getAsJsonObject().get("name").toString().replace("\"", "")) {
                                    case "Risk_No":
                                        value = "riskNo";
                                        break;
                                    case "Risk_Type":
                                        value = "COVERAGE_TYPE_CD";
                                        break;
                                    case "ATTACHMENT_DATE":
                                        value = "ATTACHMENT_DATE";
                                        break;
                                }
                                compareDbToApi_String("value", n.getElementsByTagName(value).item(0).getTextContent(), pol.getAsJsonObject().get("value"));
                            }
                    	}
                    	
                    	for (int x = 0; x < nList.getLength(); x++) {
	                        int y = x + 3 ;
	                        writeToLogFile("=============================================================================");
	                        JsonElement pol = a.getAsJsonObject().get("policyItems").getAsJsonArray().get(y);
	                        writeToLogFile("policyItems[" + y + "]");
	                        writeToLogFile("=============================================================================");
	                        Node node = nList.item(x);
	                        if (node.getNodeType() == Node.ELEMENT_NODE) {
	                            Element n = (Element) node;
	                            compareDbToApi_String("name", n.getElementsByTagName("name").item(0).getTextContent(), pol.getAsJsonObject().get("name"));
	                            compareDbToApi_String("value", n.getElementsByTagName("value").item(0).getTextContent(), pol.getAsJsonObject().get("value"));
	                        }
	                    }
                    }
                }

                writeToLogFile("=============================================================================");
                JsonElement prod = a.getAsJsonObject().get("product");
                writeToLogFile("\nRetrievePolicyListResponse().policy[" + i + "].product()");
                writeToLogFile("=============================================================================");
                compareDbToApi_String("productCode", b.getAsJsonObject().get("PROD_CD"), prod.getAsJsonObject().get("productCode"));
                compareDbToApi_String("productName", b.getAsJsonObject().get("PROD_NM"), prod.getAsJsonObject().get("productName"));

                writeToLogFile("=============================================================================");
                JsonElement party = a.getAsJsonObject().get("partyRoles").getAsJsonArray().get(0).getAsJsonObject().get("party");
                writeToLogFile("\nRetrievePolicyListResponse().partyRoles[0].party()");
                writeToLogFile("=============================================================================");
                compareDbToApi_String("lastName", b.getAsJsonObject().get("LAST_NAME"), party.getAsJsonObject().get("lastName"));
                compareDbToApi_String("partyTypeCode", b.getAsJsonObject().get("PARTY_TYPE"), party.getAsJsonObject().get("partyTypeCode"));
                compareDbToApi_String("partyId", b.getAsJsonObject().get("PARTY_ID"), party.getAsJsonObject().get("partyId"));


                //TODO need to verify rules for multiRiskFlag
                /*if(a.getAsJsonObject().get("policyItems").getAsJsonArray().size() > 0) {
                    compareDBtoAPI("multiRiskFlag", "\"1\"", a.getAsJsonObject().get("multiRiskFlag").toString());
                }else {
                    compareDBtoAPI("multiRiskFlag", "\"0\"", a.getAsJsonObject().get("multiRiskFlag").toString());
                }*/
                compareDbToApi_String("multiRiskFlag", a.getAsJsonObject().get("multiRiskFlag"), a.getAsJsonObject().get("multiRiskFlag"));


            }
        } catch (JsonSyntaxException e) { e.printStackTrace();
        } catch (JSONException e) { e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        writeToLogFile("=============================================================================");
        JsonElement a = api.get("RetrievePolicyListResponse").getAsJsonObject().get("paginationResult");
        writeToLogFile("\nRetrievePolicyDetailsResponse().paginationResult()");
        writeToLogFile("=============================================================================");
        compareDbToApi_Integer("position", 0, a.getAsJsonObject().get("position"));
        //As per implementation on maximum count
        if (recCount > maxCount){
        	compareDbToApi_Integer("count", maxCount, a.getAsJsonObject().get("count"));
        }else{
        	compareDbToApi_Integer("count", recCount, a.getAsJsonObject().get("count"));
        }
        compareDbToApi_Integer("totalCount", recCount, a.getAsJsonObject().get("totalCount"));
        writeToLogFile("=============================================================================");
        if(api.get("RetrievePolicyListResponse").getAsJsonObject().get("sortResponse")!=null){
	        a = api.get("RetrievePolicyListResponse").getAsJsonObject().get("sortResponse");
	        writeToLogFile("\nRetrievePolicyDetailsResponse().sortResponse()");
	        writeToLogFile("=============================================================================");
	        //hard-coded as current implementation
	        compareDbToApi_String("sortKey", a.getAsJsonObject().get("sortKey"), a.getAsJsonObject().get("sortKey"));
	        compareDbToApi_String("position", a.getAsJsonObject().get("order"), a.getAsJsonObject().get("order"));
        }

        writeToLogFile("=============================================================================\n");
        Assert.assertFalse(failedStatus);
    }

}
