package com.axa.testautomation.api.stepdefs.Regional;


import com.axa.testautomation.api.regional.RetrieveAgentDetails.response.*;
import com.axa.testautomation.api.regional.RetrieveAgentDetails.dbResultSet.*;
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

import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


public class REGIONAL_RetrieveAgentDetailsStepDefs extends BaseStepDefs {

    @Autowired
    private String regionalNitRetrieveAgentDetails;

    @Autowired
    private String sg_MDCAC7QI;
    @Autowired
    private String g_SG_CACHE;
    @Autowired
    private String cachePassword;

    private JSONArray jsonPSEAByAgentCode;
    private JSONArray jsonPSEAByAgentCodeByCompanyCode;
    private JSONArray jsonPSEAByClientCode;
  

    private String axaEntity;
    private String agentCode;

	private List<String> strMain;

	private RetrieveAgentDetailsResponseContainer retrieveAgentDetailsResponseContainer;

    private GetAgentDetailsFromPSEAByAgentCode[] getAgentDetailsFromPSEAByAgentCode;
    private GetPSEAByAgentCodeByCompanyCode[] getPSEAByAgentCodeByCompanyCode;
    private GetPSEAByClientCode[] getPSEAByClientCode;

    @Given("the following http headers are set Retrieve Agent Details")
    public void set_http_headers(DataTable dt) {
        failedStatus = false;
        httpHeaders.clear();
        writeToLogFile("====== HEADERS ======");
        for(Map<String, String> row : dt.asMaps()) {
            for(Map.Entry<String, String> headerMap : row.entrySet()) {
                httpHeaders.set(headerMap.getKey(), headerMap.getValue());
                writeToLogFile(headerMap.getKey() + ": " + headerMap.getValue());
                if(headerMap.getKey().equalsIgnoreCase("X-Axa-Entity")) {
                    axaEntity = headerMap.getValue();
                }
            }
        }
        writeToLogFile("=====================");
    }


    @And("the following GET input parameters are set for Retrieve Agent Details")
    public void set_get_parameters(DataTable dt) {
        failedStatus = false;
        getParameters = "?";
        for(Map<String, String> row : dt.asMaps()) {
            for(Map.Entry<String, String> getParametersMap : row.entrySet()) {
                if(getParametersMap.getKey().equalsIgnoreCase("agentCode")){
                    regionalNitRetrieveAgentDetails = regionalNitRetrieveAgentDetails.replace("{agentCode}", getParametersMap.getValue());
                } else {
                    getParameters = getParameters + getParametersMap.getKey() + "=" + getParametersMap.getValue() + "&";
                }

                switch (getParametersMap.getKey()){
                    case "agentCode": agentCode = getParametersMap.getValue(); break;
                }
            }
        }
        getParameters = getParameters.substring(0, getParameters.length()-1);
        writeToLogFile("PARAMETER: " + getParameters);
    }

    @When("the api call has been made for Retrieve Agent Details")
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
            String url = regionalNitRetrieveAgentDetails + getParameters;
            writeToLogFile("ENDPOINT: " + regionalNitRetrieveAgentDetails);
            HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
            response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            writeToLogFile("[API Response]");
            writeToLogFile(response.getBody());

            Gson gson = new Gson();
            retrieveAgentDetailsResponseContainer = gson.fromJson(response.getBody(), RetrieveAgentDetailsResponseContainer.class);

        }
        catch (HttpClientErrorException | HttpServerErrorException e) {
            actualHttpErrorCode = Integer.toString(e.getStatusCode().value());
            actualHttpErrorPhrase = e.getStatusCode().getReasonPhrase();
            actualHttpErrorBody = e.getResponseBodyAsString().replaceAll("\n","");
            writeToLogFile("[API Response]");
            writeToLogFile(actualHttpErrorBody);
        }
    }

    @When("the Stored Procedure is called for Retrieve Agent Details")
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

            //step2 create  the connection object
            switch (axaEntity.toLowerCase()){
                case "sg": dbConnection = sg_MDCAC7QI;
                    userName = g_SG_CACHE;
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

            //AgentCode
            filename = "src/sql/Regional/retrieveAgentDetails/getAgentDetailsFromPSEAByAgentCode.txt";
            text = new String(Files.readAllBytes(Paths.get(filename)));
            query = text.replace("%agentCode%", agentCode);
            writeToLogFile("[SQL Query]");
            writeToLogFile(query);
            jsonPSEAByAgentCode = executeQuery(con, query);
            Gson gson = new Gson();
            getAgentDetailsFromPSEAByAgentCode = gson.fromJson(jsonPSEAByAgentCode.toString(), GetAgentDetailsFromPSEAByAgentCode[].class);
            String clientCode = getAgentDetailsFromPSEAByAgentCode[0].getCLNTNUM();
            
            //AgentCodeByCompanyCode
            filename = "src/sql/Regional/retrieveAgentDetails/getAgentDetailsFromPSEAByAgentNoComanyCode.txt";
            text = new String(Files.readAllBytes(Paths.get(filename)));
            query = text.replace("%agentCode%", agentCode);
            writeToLogFile("[SQL Query]");
            writeToLogFile(query);
            jsonPSEAByAgentCodeByCompanyCode = executeQuery(con, query);
            gson = new Gson();
            getPSEAByAgentCodeByCompanyCode = gson.fromJson(jsonPSEAByAgentCodeByCompanyCode.toString(), GetPSEAByAgentCodeByCompanyCode[].class);
            
            //ClientCode
            filename = "src/sql/Regional/retrieveAgentDetails/getAgentDetailsFromPSEAByClientNumber.txt";
            text = new String(Files.readAllBytes(Paths.get(filename)));
            query = text.replace("%clientCode%", clientCode);
            writeToLogFile("[SQL Query]");
            writeToLogFile(query);
            jsonPSEAByClientCode = executeQuery(con, query);
            gson = new Gson();
            getPSEAByClientCode = gson.fromJson(jsonPSEAByClientCode.toString(), GetPSEAByClientCode[].class);

            filename = "src/sql/Regional/retrieveAgentDetails/getAgentDetailsFromPSEAByClientNumber.txt";
            text = new String(Files.readAllBytes(Paths.get(filename)));
            query = text.replace("%clientCode%", clientCode);
            strMain = executeQuery2(con, query);
            
            //step5 close the connection object
            con.close();

        }catch(Exception e){
            failedStatus = true;
            scenario.write(e.toString());
            writeToLogFile(e.toString());
            Assert.assertFalse(failedStatus);

        }
    }
    
    @Then("verify that API and DB responses matched for Retrieve Agent Details")
    public void api_match_db() throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        
        writeToLogFile("[Validations]");
        writeToLogFile("=============================================================================");
        writeToLogFile("RetrieveAgentDetailsResponse().PSEAAgent()");
        writeToLogFile("=============================================================================");
        PSEAAgent pseaAgent = retrieveAgentDetailsResponseContainer.getRetrieveAgentDetailsResponse().getPSEAAgent();
        compareDbToApi_String("agentCode", getAgentDetailsFromPSEAByAgentCode[0].getAGNTNUM(), pseaAgent.getAgentCode());
        compareDbToApi_Timestamp_DatePart("agentContractEffectiveDate", getAgentDetailsFromPSEAByAgentCode[0].getCONTRACTEFFECTIVEDATE(), pseaAgent.getAgentContractEffectiveDate());
        compareDbToApi_String("agentIARBRegistrationNumber", getAgentDetailsFromPSEAByAgentCode[0].getAGTLICNO(), pseaAgent.getAgentIARBRegistrationNumber());
        compareDbToApi_Timestamp_DatePart("agentTerminationDate", getAgentDetailsFromPSEAByAgentCode[0].getTERMINATIONDATE(), pseaAgent.getAgentTerminationDate());
        compareDbToApi_String("agentTypeCode", getAgentDetailsFromPSEAByAgentCode[0].getAGTYPE(), pseaAgent.getAgentTypeCode());
        compareDbToApi_String("agentUnitCode", getAgentDetailsFromPSEAByAgentCode[0].getAGNTBR(), pseaAgent.getAgentUnitCode());

        writeToLogFile("=============================================================================");
        writeToLogFile("RetrieveAgentDetailsResponse().PSEAAgent().party()");
        writeToLogFile("=============================================================================");
        Party party = pseaAgent.getParty();
        compareDbToApi_String("genderCode", getPSEAByClientCode[0].getCLTSEX(), party.getGenderCode());
        compareDbToApi_String("lastName", getPSEAByClientCode[0].getLSURNAME(), party.getLastName());
        compareDbToApi_String("partyTypeCode", "C", party.getPartyTypeCode());
        compareDbToApi_String("partyId", getAgentDetailsFromPSEAByAgentCode[0].getCLNTNUM(), party.getPartyId());
        
        if(party.getTelephoneContacts().size() > 0){
        	String xmlData = strMain.get(0).replace("\"", "");
            //writeToLogFile("[XMLDATA]: "+xmlData);
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(xmlData)));

            document.getDocumentElement().normalize();

            NodeList nList = document.getElementsByTagName("telephoneContacts");
            
            for(int x=0; x<party.getTelephoneContacts().size(); x++){
            	writeToLogFile("=============================================================================");
                TelephoneContact tel = party.getTelephoneContacts().get(x);
                writeToLogFile("telephoneContacts[" + x + "]");
                writeToLogFile("=============================================================================");
                Node node = nList.item(x);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element n = (Element) node;
                 
                    if(n.getElementsByTagName("telephoneAddressTypeCode").item(0).getTextContent().contains("OFF")){
                    	compareDbToApi_String("telephoneAddressTypeCode", n.getElementsByTagName("telephoneAddressTypeCode").item(0).getTextContent().substring(0, 3), tel.getTelephoneAddressTypeCode());
                    }else{
                    	compareDbToApi_String("telephoneAddressTypeCode", n.getElementsByTagName("telephoneAddressTypeCode").item(0).getTextContent(), tel.getTelephoneAddressTypeCode());
                    }
                    compareDbToApi_String("telephoneNumber", n.getElementsByTagName("telephoneNumber").item(0).getTextContent(), tel.getTelephoneNumber());
                }

            }
        }
        
        if(party.getPhysicalContacts().size() > 0){
        	String xmlData = strMain.get(0).replace("\"", "");
            //writeToLogFile("[XMLDATA]: "+xmlData);
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(xmlData)));

            document.getDocumentElement().normalize();

            NodeList nList = document.getElementsByTagName("physicalContacts");
            
            for(int x=0; x<party.getPhysicalContacts().size(); x++){
            	writeToLogFile("=============================================================================");
                PhysicalContact phy = party.getPhysicalContacts().get(x);
                writeToLogFile("physicalContacts[" + x + "]");
                writeToLogFile("=============================================================================");
                Node node = nList.item(x);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element n = (Element) node;
                    compareDbToApi_String("addressLine1", n.getElementsByTagName("addressLine1").item(0).getTextContent(), phy.getAddressLine1());
                    compareDbToApi_String("addressLine2", n.getElementsByTagName("addressLine2").item(0).getTextContent(), phy.getAddressLine2());
                    compareDbToApi_String("addressLine3", n.getElementsByTagName("addressLine3").item(0).getTextContent(), phy.getAddressLine3());
                    compareDbToApi_String("addressLine4", n.getElementsByTagName("addressLine4").item(0).getTextContent(), phy.getAddressLine4());
                    compareDbToApi_String("postalCode", n.getElementsByTagName("postalCode").item(0).getTextContent(), phy.getPostalCode());
                }

            }
        }
        
        writeToLogFile("=============================================================================");
        ElectronicContact elec = party.getElectronicContacts().get(0);
        writeToLogFile("electronicContacts[" + 0 + "]");
        writeToLogFile("=============================================================================");
        compareDbToApi_String("electronicAddress", getPSEAByClientCode[0].getRINTERNET(), elec.getElectronicAddress());
        
        writeToLogFile("=============================================================================");
        AgentUnit agentUnit = pseaAgent.getAgentUnit();
        writeToLogFile("RetrieveAgentDetailsResponse().PSEAAgent().agentUnit()");
        writeToLogFile("=============================================================================");
        //JsonElement dbAgentCode = byAgentCode.getAsJsonObject();
        compareDbToApi_String("assistantBranchCode", getAgentDetailsFromPSEAByAgentCode[0].getZDISTRICT(), agentUnit.getAssistantBranchCode());
        compareDbToApi_String("territoryCode", getAgentDetailsFromPSEAByAgentCode[0].getCHDRSTCDA(), agentUnit.getTerritoryCode());
        compareDbToApi_String("branchCode", getAgentDetailsFromPSEAByAgentCode[0].getAGNTBR(), agentUnit.getBranchCode());
        compareDbToApi_String("territoryDescription", getAgentDetailsFromPSEAByAgentCode[0].getLONGDESC(), agentUnit.getTerritoryDescription());
        
        writeToLogFile("=============================================================================");
        PSEAParty pSEAParty = pseaAgent.getPSEAParty();
        writeToLogFile("RetrieveAgentDetailsResponse().PSEAAgent().PSEAParty()");
        writeToLogFile("=============================================================================");
        //JsonElement dbAgentCode = byAgentCode.getAsJsonObject();
        compareDbToApi_String("firstName", getPSEAByClientCode[0].getLGIVNAME(), pSEAParty.getFirstName());
        compareDbToApi_String("lastName", getPSEAByClientCode[0].getLSURNAME(), pSEAParty.getLastName());
        
        for(int x=0; x<pSEAParty.getPSEAAccounts().size(); x++){
        	writeToLogFile("=============================================================================");
            PSEADebitAccounts pda = pSEAParty.getPSEAAccounts().get(x).getPSEADebitAccounts();
            writeToLogFile("PSEAAccounts[" + x + "].PSEADebitAccounts()");
            writeToLogFile("=============================================================================");
            //TODO bankAccountNumber
            compareDbToApi_String("bankAccountNumber", pda.getBankAccountNumber(), pda.getBankAccountNumber());
        }


        writeToLogFile("=============================================================================\n");
        Assert.assertFalse(failedStatus);
        
  
    }

}
