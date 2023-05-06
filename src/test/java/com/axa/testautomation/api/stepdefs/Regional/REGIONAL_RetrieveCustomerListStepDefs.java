package com.axa.testautomation.api.stepdefs.Regional;


import com.axa.testautomation.api.regional.RetrieveCustomerList.response.*;
import com.axa.testautomation.api.regional.RetrieveCustomerList.dbResult.*;
import com.axa.testautomation.api.stepdefs.BaseStepDefs;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
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
import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class REGIONAL_RetrieveCustomerListStepDefs extends BaseStepDefs {

    @Autowired
    private String regionalNitRetrieveCustomerList;

    @Autowired
    private String sg_MDCOR7QI;
    @Autowired
    private String g_SG_CUST;
    @Autowired
    private String hk_MDCOR2QI;
    @Autowired
    private String g_HK_CUST;
    @Autowired
    private String my_MDCOR7QI;
    @Autowired
    private String g_MY_CUST;
    @Autowired
    private String th_MDCOR6QI;
    @Autowired
    private String l_TH_CUST;
    @Autowired
    private String ph_MDCOR8QI;
    @Autowired
    private String l_PH_CUST;
    @Autowired
    private String corePassword;

    private String axaEntity;
    private String axaLob;
    private String idDocumentNumber;
    private RetrieveCustomerListResponseContainer retrieveCustomerListResponseContainer;
    private CountQuery[] countQuery;
    private MainQuery[] mainQuery;
    private List<String> strID_DOC_XML_VALUE;
    private List<String> strPARTY_XML_VALUE;


    @Given("the following http headers are set Retrieve Customer List")
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
                if(headerMap.getKey().equalsIgnoreCase("X-Axa-LOB")) {
                    axaLob = headerMap.getValue();
                }
            }
        }
        writeToLogFile("=====================");
    }


    @And("the following GET input parameters are set for Retrieve Customer List")
    public void set_get_parameters(DataTable dt) {
        failedStatus = false;
        getParameters = "?";
        for(Map<String, String> row : dt.asMaps()) {
            for(Map.Entry<String, String> getParametersMap : row.entrySet()) {
                getParameters = getParameters + getParametersMap.getKey() + "=" + getParametersMap.getValue() + "&";

                switch (getParametersMap.getKey()){
                    case "idDocumentNumber": idDocumentNumber = getParametersMap.getValue(); break;
                }
            }
        }

        if(axaEntity.equalsIgnoreCase("TH")) getParameters = getParameters + "LOBTypeCode=Life&";

        getParameters = getParameters.substring(0, getParameters.length()-1);
        writeToLogFile("PARAMETER: " + getParameters);
    }

    @When("the api call has been made for Retrieve Customer List")
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
            String url = regionalNitRetrieveCustomerList + getParameters;
            writeToLogFile("ENDPOINT: " + regionalNitRetrieveCustomerList);
            HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
            response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            writeToLogFile("[API Response]");
            writeToLogFile(response.getBody());

            Gson gson = new Gson();
            retrieveCustomerListResponseContainer = gson.fromJson(response.getBody(), RetrieveCustomerListResponseContainer.class);
        }
        catch (HttpClientErrorException | HttpServerErrorException e) {
            actualHttpErrorCode = Integer.toString(e.getStatusCode().value());
            actualHttpErrorPhrase = e.getStatusCode().getReasonPhrase();
            actualHttpErrorBody = e.getResponseBodyAsString().replaceAll("\n","");
            writeToLogFile("[API Response]");
            writeToLogFile(actualHttpErrorBody);
        }
    }

    @When("the Stored Procedure is called for Retrieve Customer List")
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
                case "sg": dbConnection = sg_MDCOR7QI;
                    userName = g_SG_CUST;
                    password = corePassword;
                    break;
                case "hk": dbConnection = hk_MDCOR2QI;
                    userName = g_HK_CUST;
                    password = corePassword;
                    break;
                case "my": dbConnection = my_MDCOR7QI;
                    userName = g_MY_CUST;
                    password = corePassword;
                    break;
                case "th": dbConnection = th_MDCOR6QI;
                    userName = l_TH_CUST;
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

            if(axaEntity.equalsIgnoreCase("SG")) {
                filename = "src/sql/Regional/retrieveCustomerList/countQueryForSG.txt";
            }else{
                filename = "src/sql/Regional/retrieveCustomerList/countQuery.txt";
            }
            text = new String(Files.readAllBytes(Paths.get(filename)));
            query = text.replace("%idDocumentNumber%", idDocumentNumber);
            writeToLogFile("[SQL Query]");
            writeToLogFile(query);
            JSONArray jsonCountQuery = executeQuery(con, query);
            Gson gson = new Gson();
            countQuery = gson.fromJson(jsonCountQuery.toString(), CountQuery[].class);
            String cnt = countQuery[0].getCNTPARTY().toString().replace("\"", "");

            if(axaEntity.equalsIgnoreCase("SG")) {
                filename = "src/sql/Regional/retrieveCustomerList/mainQueryForSG.txt";
            }else{
                filename = "src/sql/Regional/retrieveCustomerList/mainQuery.txt";
            }
            text = new String(Files.readAllBytes(Paths.get(filename)));
            query = text.replace("%idDocumentNumber%", idDocumentNumber).replace("%count%", cnt);
            writeToLogFile("[SQL Query]");
            writeToLogFile(query);
            JSONArray jsonMainQuery = executeQuery(con, query);
            gson = new Gson();
            mainQuery = gson.fromJson(jsonMainQuery.toString(), MainQuery[].class);

            //For XML field values
            strID_DOC_XML_VALUE = executeQuery2(con, query, "ID_DOC_XML_VALUE");
            strPARTY_XML_VALUE = executeQuery2(con, query, "PARTY_XML_VALUE");

            //step5 close the connection object
            con.close();

        }catch(Exception e){
            writeToLogFile(e.toString());
            Assert.assertFalse(failedStatus);
        }
    }

    @Then("verify that API and DB responses matched for Retrieve Customer List")
    public void api_match_db() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        Document document = null;

        writeToLogFile("[Validations]");
        writeToLogFile("=============================================================================");
        writeToLogFile("\nRetrieveCustomerListResponse().paginationResult()");
        writeToLogFile("=============================================================================");
        RetrieveCustomerListResponse rclr = retrieveCustomerListResponseContainer.getRetrieveCustomerListResponse();
        PaginationResult pr = rclr.getPaginationResult();
        compareDbToApi_String("position", "0", pr.getPosition());
        compareDbToApi_Integer("count", ((countQuery[0].getCNTPARTY()>50)?50:countQuery[0].getCNTPARTY()), pr.getCount());
        compareDbToApi_Integer("totalCount", countQuery[0].getCNTPARTY(), pr.getTotalCount());

        writeToLogFile("=============================================================================");
        writeToLogFile("\nRetrieveCustomerListResponse().sortResponse()");
        writeToLogFile("=============================================================================");
        SortResponse sr = rclr.getSortResponse();
        compareDbToApi_String("sortKey", "CORE_DB_PARTY_ID", sr.getSortKey());
        compareDbToApi_String("order", "DESC", sr.getOrder());

        List<CoreParty> coreParty = rclr.getCoreParty();
        coreParty.sort(CoreParty.CorePartyComparator);
        for(int i=0; i < coreParty.size(); i++){
            writeToLogFile("=============================================================================");
            writeToLogFile("\nRetrieveCustomerListResponse().coreParty()["+i+"]");
            writeToLogFile("=============================================================================");
            CoreParty cp = rclr.getCoreParty().get(i);
            MainQuery mq = mainQuery[i];
            compareDbToApi_Timestamp_DatePart("birthDate", mq.getBIRTHDATE(), cp.getBirthDate());
            compareDbToApi_String("displayNameFormat", mq.getDISPLAYNAMEFORMAT(), cp.getDisplayNameFormat());
            //compareDbToApi_String("entityCode", mq.getENTITYCODE(), cp.getEntityCode());
            compareDbToApi_String("firstName", mq.getFIRSTNAME(), cp.getFirstName());
            compareDbToApi_String("genderCode", mq.getSTDGENDERCODE(), cp.getGenderCode());
            compareDbToApi_String("lastName", mq.getLASTNAME(), cp.getLastName());
            compareDbToApi_String("maritalStatusCode", mq.getSTDMARITALSTATCODE(), cp.getMaritalStatusCode());
            compareDbToApi_String("middleName", mq.getmIDDLE_NAME(), cp.getMiddleName());
            compareDbToApi_String("partyTypeCode", mq.getPARTYTYPECODE(), cp.getPartyTypeCode());
            compareDbToApi_String("sourceSystemCode", mq.getSOURCESYSTEMCODE(), cp.getSourceSystemCode());
            compareDbToApi_String("partyId", mq.getSOURCESYSTEMPARTYID(), cp.getPartyId());
            compareDbToApi_String("localFirstName", mq.getlOCAL_FIRST_NAME(), cp.getLocalFirstName());
            compareDbToApi_String("localLastName", mq.getlOCAL_LAST_NAME(), cp.getLocalLastName());
            compareDbToApi_String("localDisplayNameFormat", mq.getlOCAL_DISPLAY_NAME_FORMAT(), cp.getLocalDisplayNameFormat());
            compareDbToApi_String("form60Flag", mq.getFORM_60_FLAG(), cp.getForm60Flag());
            compareDbToApi_String("identityProofIndicator", mq.getIDENTITY_PROOF_INDICATOR(), cp.getIdentityProofIndicator());
            compareDbToApi_String("partyStatusCode", mq.getPARTYSTATCODE(), cp.getPartyStatusCode());
            compareDbToApi_String("salutationText", mq.getSALUTATIONTEXT(), cp.getSalutationText());
            compareDbToApi_String("nationalityCode", mq.getSTDNATIONALITYCODE(), cp.getNationalityCode());
            compareDbToApi_String("geoDemographicCode", mq.getSTD_GEO_DEMOGRAPHIC_CODE(), cp.getGeoDemographicCode());
            compareDbToApi_String("countryOfResidenceCode", mq.getCOUNTRYOFRESIDENCECODE(), cp.getCountryOfResidenceCode());
            compareDbToApi_String("occupationClassCode", mq.getSTD_OCCUPATION_CLASS_CODE(), cp.getOccupationClassCode());
            compareDbToApi_String("deceasedFlag", mq.getDECEASED_FLAG(), cp.getDeceasedFlag());
            compareDbToApi_String("deathDate", mq.getDEATHDATE(), cp.getDeathDate());
            compareDbToApi_String("sourceofIncome", mq.getSOURCE_OF_INCOME(), cp.getSourceofIncome());
            compareDbToApi_String("annualIncomeAmount", mq.getANNUAL_INCOME_AMOUNT(), cp.getAnnualIncomeAmount());
            compareDbToApi_String("annualIncomeRangeCode", mq.getANNUAL_INCOME_AMNT_RANGE_CODE(), cp.getAnnualIncomeRangeCode());
            compareDbToApi_String("educationLevelCode", mq.getSTD_EDUCATION_LEVEL_CODE(), cp.getEducationLevelCode());
            compareDbToApi_String("heightMtr", mq.getHEIGHT_IN_METER(), cp.getHeightMtr());
            compareDbToApi_String("weightKg", mq.getWEIGHT_IN_KILOGRAM(), cp.getWeightKg());
            compareDbToApi_String("staffNumber", mq.getSTAFF_NUMBER(), cp.getStaffNumber());
            compareDbToApi_String("staffFlag", mq.getSTAFF_FLAG(), cp.getStaffFlag());
            compareDbToApi_String("alertReceiverName", mq.getALERT_RECEIVER_NAME(), cp.getAlertReceiverName());
            compareDbToApi_String("primaryLanguageCode", mq.getSTDPRIMARYLANGUAGECODE(), cp.getPrimaryLanguageCode());
            compareDbToApi_String("specialNeedCode", mq.getSTD_SPECIAL_NEED_CODE(), cp.getSpecialNeedCode());
            compareDbToApi_String("preferredContactMethodCode", mq.getSTD_PREFFERED_CONTACT_MTHD_CD(), cp.getPreferredContactMethodCode());
            compareDbToApi_String("companyCode", mq.getCOMPANYCODE(), cp.getCompanyCode());
            compareDbToApi_String("coreDBPartyId", mq.getCOREDBPARTYID(), cp.getCoreDBPartyId());
            compareDbToApi_String("vipFlag", mq.getVIP_FLAG(), cp.getVipFlag());
            compareDbToApi_String("bankruptcyFlag", mq.getBANKRUPTCY_FLAG(), cp.getBankruptcyFlag());
            compareDbToApi_String("fraudCode", mq.getFRAUD_CODE(), cp.getFraudCode());
            compareDbToApi_String("smokingHabitFlag", mq.getSMOKING_HABIT(), cp.getSmokingHabitFlag());
            compareDbToApi_String("localMiddleName", mq.getLOCAL_MIDDLE_NAME(), cp.getLocalMiddleName());
            compareDbToApi_String("specialCaseCode", mq.getSPECIAL_CASE_CODE(), cp.getSpecialNeedCode());
            compareDbToApi_String("masterIndividualId", mq.getMASTERINDIVIDUALID(), cp.getMasterIndividualId());
            String lob = "";
            if(axaEntity.equalsIgnoreCase("SG")) {
                switch (mq.getSOURCESYSTEMCODE()) {
                    case "PSEA":
                        lob = "GI";
                        break;
                    case "RLS":
                        lob = "Life";
                        break;
                    default:
                        lob = "";
                        break;
                }
            }
            if(axaLob.equalsIgnoreCase("Life")){
            	lob = "Life";
            }
            compareDbToApi_String("LOBCode", lob, cp.getLOBCode());
            compareDbToApi_String("serviceTaxApplicabilityFlag", mq.getSTAXAPPLICABILITYIND(), cp.getServiceTaxApplicabilityFlag());

            if(cp.getTelephoneContacts().size() > 0) {
                writeToLogFile("=============================================================================");
                writeToLogFile("\ncoreParty()[" + i + "].telephoneContacts[0]");
                writeToLogFile("=============================================================================");
                TelephoneContact tc = cp.getTelephoneContacts().get(0);
                compareDbToApi_String("telephoneAddressTypeCode", mq.getTELEPHONEADDRTYPECD(), tc.getTelephoneAddressTypeCode());
                if((tc.getTelephoneNumber()!=null) && (mq.getTELEPHONENO()!=null))
                    compareDbToApi_String("telephoneNumber", mq.getTELEPHONENO(), tc.getTelephoneNumber());
            }

            if(cp.getPhysicalContacts()!=null) {
                if (cp.getPhysicalContacts().size() > 0) {
                    String xmlData = strPARTY_XML_VALUE.get(i).replace("\"", "");
                    try {
                        builder = factory.newDocumentBuilder();
                        document = builder.parse(new InputSource(new StringReader(xmlData)));
                    } catch (ParserConfigurationException | SAXException | IOException e) {
                        writeToLogFile(e.toString());
                        Assert.assertFalse(failedStatus);
                    }

                    document.getDocumentElement().normalize();

                    NodeList nList = document.getElementsByTagName("PHYSICALCONTACTS");

                    Node node = null;
                    for (int x = 0; x < cp.getPhysicalContacts().size(); x++) {
                        writeToLogFile("=============================================================================");
                        writeToLogFile("\ncoreParty()[" + i + "].physicalContacts[" + x + "]");
                        writeToLogFile("=============================================================================");
                        PhysicalContact pc = cp.getPhysicalContacts().get(x);
                        node = nList.item(x);

                        if (node.getNodeType() == Node.ELEMENT_NODE) {
                            Element n = (Element) node;
                            if(n.getElementsByTagName("ADDRESS_LINE_1").item(0)!=null)
                                compareDbToApi_String("addressLine1", n.getElementsByTagName("ADDRESS_LINE_1").item(0).getTextContent(), pc.getAddressLine1());
                            if(n.getElementsByTagName("ADDRESS_LINE_2").item(0)!=null)
                                compareDbToApi_String("addressLine2", n.getElementsByTagName("ADDRESS_LINE_2").item(0).getTextContent(), pc.getAddressLine2());
                            if(n.getElementsByTagName("ADDRESS_LINE_3").item(0)!=null)
                                compareDbToApi_String("addressLine3", n.getElementsByTagName("ADDRESS_LINE_3").item(0).getTextContent(), pc.getAddressLine3());
                            if(n.getElementsByTagName("ADDRESS_LINE_4").item(0)!=null)
                                compareDbToApi_String("addressLine4", n.getElementsByTagName("ADDRESS_LINE_4").item(0).getTextContent(), pc.getAddressLine4());
                            if(n.getElementsByTagName("ADDRESS_LINE_5").item(0)!=null)
                                compareDbToApi_String("addressLine5", n.getElementsByTagName("ADDRESS_LINE_5").item(0).getTextContent(), pc.getAddressLine5());
                            if(n.getElementsByTagName("COUNTRY_CODE").item(0)!=null)
                                compareDbToApi_String("countryCode", n.getElementsByTagName("COUNTRY_CODE").item(0).getTextContent(), pc.getCountryCode());
                            if(n.getElementsByTagName("PHYSICAL_ADDRESS_TYPE_CODE").item(0)!=null)
                                compareDbToApi_String("physicalAddressTypeCode", n.getElementsByTagName("PHYSICAL_ADDRESS_TYPE_CODE").item(0).getTextContent(), pc.getPhysicalAddressTypeCode());
                            if(n.getElementsByTagName("POSTAL_CODE").item(0)!=null)
                                compareDbToApi_String("postalCode", n.getElementsByTagName("POSTAL_CODE").item(0).getTextContent(), pc.getPostalCode());
                        }
                    }
                }
            }

            writeToLogFile("=============================================================================");
            writeToLogFile("\ncoreParty()["+i+"].electronicContacts[0]");
            writeToLogFile("=============================================================================");
            ElectronicContact ec = cp.getElectronicContacts().get(0);
            compareDbToApi_String("electronicAddressTypeCode", "EMAIL", ec.getElectronicAddressTypeCode());
            compareDbToApi_String("electronicAddress", mq.getELECTRONICADDR(), ec.getElectronicAddress());

            if(cp.getPartyIdentifiers()!=null) {
                if (cp.getPartyIdentifiers().size() > 0) {
                    String xmlData = strID_DOC_XML_VALUE.get(i).replace("\"", "");
                    try {
                        builder = factory.newDocumentBuilder();
                        document = builder.parse(new InputSource(new StringReader(xmlData)));
                    } catch (ParserConfigurationException | SAXException | IOException e) {
                        writeToLogFile(e.toString());
                        Assert.assertFalse(failedStatus);
                    }

                    document.getDocumentElement().normalize();

                    NodeList nList = document.getElementsByTagName("PARTYIDENTIFERS");

                    for (int x = 0; x < cp.getPartyIdentifiers().size(); x++) {
                        writeToLogFile("=============================================================================");
                        writeToLogFile("\ncoreParty()[" + i + "].partyIdentifiers[" + x + "]");
                        writeToLogFile("=============================================================================");
                        PartyIdentifier pi = cp.getPartyIdentifiers().get(x);
                        Node node = nList.item(x);
                        if (node.getNodeType() == Node.ELEMENT_NODE) {
                            Element n = (Element) node;
                            if(n.getElementsByTagName("ID_DOC_NO").item(0)!=null)
                                compareDbToApi_String("idDocumentNumber", n.getElementsByTagName("ID_DOC_NO").item(0).getTextContent(), pi.getIdDocumentNumber());
                            if(n.getElementsByTagName("ID_DOC_TYPE_CD").item(0)!=null)
                                compareDbToApi_String("idDocumentType", n.getElementsByTagName("ID_DOC_TYPE_CD").item(0).getTextContent(), pi.getIdDocumentType());
                        }
                    }
                }
            }
        }

        writeToLogFile("=============================================================================\n");
        Assert.assertFalse(failedStatus);
    }

}
