package com.axa.testautomation.api.stepdefs.Regional;


import com.axa.testautomation.api.regional.RetrieveAccountDetails.response.*;
import com.axa.testautomation.api.regional.RetrieveAccountDetails.dbResult.*;
import com.axa.testautomation.api.regional.RetrieveAccountDetailsLife.dbResult.*;
import com.axa.testautomation.api.regional.RetrieveAccountDetailsLife.response.*;
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

import java.sql.*;
import java.util.Map;


public class REGIONAL_RetrieveAccountDetailsStepDefs extends BaseStepDefs {

    @Autowired
    private String regionalNitRetrieveAccountDetails;
    @Autowired
    private String regionalNitRetrieveAccountDetailsLife;

    @Autowired
    private String sg_MDCAC7QI;
    @Autowired
    private String l_SG_CACHE;
    @Autowired
    private String g_SG_CACHE;
    @Autowired
    private String cachePassword;

    @Autowired
    private String server_195;
    @Autowired
    private String MDCAC7QI;
    @Autowired
    private String L_TH_CACHE;

    @Autowired
    private String server_204;
    @Autowired
    private String MDCRPP2I;
    @Autowired
    private String L_HK_CACHE;

    @Autowired
    private String server_46;
    @Autowired
    private String MDCAC2QI;
    @Autowired
    private String L_PH_CACHE;

    private JSONArray jsonCHDRPF;
    private JSONArray jsoninsPINSPF;
    private JSONArray jsonPINSPF;
    private JSONArray jsonCLINTPF;
    private JSONArray jsonMANDPF;

    private String url;
    private String axaEntity;
    private String axaLOB;
    private String policyNumber;
    private InstallmentEffectiveDates[] installmentEffectiveDates;
    private CHDRPFF[] cHDRPFF;
    private PINSPFF[] pINSPFF;
    private CLINTPFF[] cLINTPFF;
    private MANDPFF[] mANDPFF;
    private RetrieveAccountDetailsResponseContainer retrieveAccountDetailsResponseContainer;
    private RetrieveAccountDetailsResponseContainerLife retrieveAccountDetailsResponseContainerLife;
    private GetFromRLS[] getFromRLS;
    private GetForLFPPML[] getForLFPPML;

    @Given("the following http headers are set Retrieve Account Details")
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
                    axaLOB = headerMap.getValue();
                }
            }
        }
        writeToLogFile("=====================");
    }


    @And("the following GET input parameters are set for Retrieve Account Details")
    public void set_get_parameters(DataTable dt) {
        failedStatus = false;
        getParameters = "?";
        if(axaLOB.equalsIgnoreCase("life")){
            url = regionalNitRetrieveAccountDetailsLife;
        }else{
            url = regionalNitRetrieveAccountDetails;
        }
        for(Map<String, String> row : dt.asMaps()) {
            for(Map.Entry<String, String> getParametersMap : row.entrySet()) {
                if(getParametersMap.getKey().equalsIgnoreCase("policyNumber")){
                    url = url.replace("{policyNumber}", getParametersMap.getValue());
                } else {
                    getParameters = getParameters + getParametersMap.getKey() + "=" + getParametersMap.getValue() + "&";
                }

                switch (getParametersMap.getKey()){
                    case "policyNumber": policyNumber = getParametersMap.getValue(); break;
                }
            }
        }
        getParameters = getParameters.substring(0, getParameters.length()-1);
        writeToLogFile("PARAMETER: " + getParameters);
    }

    @When("the api call has been made for Retrieve Account Details")
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
            String endpoint = url + getParameters;
            writeToLogFile("ENDPOINT: " + url);
            HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
            response = restTemplate.exchange(endpoint, HttpMethod.GET, entity, String.class);
            writeToLogFile("[API Response]");
            writeToLogFile(response.getBody());

            Gson gson = new Gson();
            if(axaLOB.equalsIgnoreCase("life")){
                retrieveAccountDetailsResponseContainerLife = gson.fromJson(response.getBody(), RetrieveAccountDetailsResponseContainerLife.class);
            }else {
                retrieveAccountDetailsResponseContainer = gson.fromJson(response.getBody(), RetrieveAccountDetailsResponseContainer.class);
            }
        }
        catch (HttpClientErrorException | HttpServerErrorException e) {
            actualHttpErrorCode = Integer.toString(e.getStatusCode().value());
            actualHttpErrorPhrase = e.getStatusCode().getReasonPhrase();
            actualHttpErrorBody = e.getResponseBodyAsString().replaceAll("\n","");
            writeToLogFile("[API Response]");
            writeToLogFile(actualHttpErrorBody);
        }
    }

    @When("the Stored Procedure is called for Retrieve Account Details")
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
                case "sg":
                    dbConnection = sg_MDCAC7QI;
                    userName = ((axaLOB.equalsIgnoreCase("Life")?l_SG_CACHE:g_SG_CACHE));
                    password = cachePassword;
                    break;
                case "th":
                    dbConnection = server_195+":1521/"+MDCAC7QI;
                    userName = L_TH_CACHE;
                    password = cachePassword;
                    break;
                case "hk":
                    dbConnection = server_204+":1521/"+MDCRPP2I;
                    userName = L_HK_CACHE;
                    password = cachePassword;
                    break;
                case "ph":
                    dbConnection = server_46+":1521/"+MDCAC2QI;
                    userName = L_PH_CACHE;
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


            if(axaLOB.equalsIgnoreCase("life")){
                filename = "src/sql/Regional/retrieveAccountDetailsLife/getAccountDetailsFromRLSByPolicyNumber.txt";
                text = new String(Files.readAllBytes(Paths.get(filename)));
                query = text.replace("%policyNumber%", policyNumber);
                writeToLogFile("[SQL Query]");
                writeToLogFile(query);
                jsoninsPINSPF = executeQuery(con, query);

                Gson gson = new Gson();
                getFromRLS = gson.fromJson(jsoninsPINSPF.toString(), GetFromRLS[].class);

                filename = "src/sql/Regional/retrieveAccountDetailsLife/getAccountDetailsForLFPPMLFromRLSByPolicyNumber.txt";
                text = new String(Files.readAllBytes(Paths.get(filename)));
                query = text.replace("%policyNumber%", policyNumber);
                writeToLogFile("[SQL Query]");
                writeToLogFile(query);
                jsoninsPINSPF = executeQuery(con, query);

                gson = new Gson();
                getForLFPPML = gson.fromJson(jsoninsPINSPF.toString(), GetForLFPPML[].class);

            }else {
                //insPINSPF
                filename = "src/sql/Regional/retrieveAccountDetails/getInstallmentEffectiveDatesForPINSPFFromPSEAByPolicyNumberSG.txt";
                text = new String(Files.readAllBytes(Paths.get(filename)));
                query = text.replace("%policyNumber%", policyNumber);
                writeToLogFile("[SQL Query]");
                writeToLogFile(query);
                jsoninsPINSPF = executeQuery(con, query);
                Gson gson = new Gson();
                installmentEffectiveDates = gson.fromJson(jsoninsPINSPF.toString(), InstallmentEffectiveDates[].class);

                //CHDRPF
                filename = "src/sql/Regional/retrieveAccountDetails/getAccountDetailsForCHDRPFFromPSEAByPolicyNumber.txt";
                text = new String(Files.readAllBytes(Paths.get(filename)));
                query = text.replace("%policyNumber%", policyNumber);
                writeToLogFile("[SQL Query]");
                writeToLogFile(query);
                jsonCHDRPF = executeQuery(con, query);
                cHDRPFF = gson.fromJson(jsonCHDRPF.toString(), CHDRPFF[].class);

                //PINSPF
                filename = "src/sql/Regional/retrieveAccountDetails/getAccountDetailsForPINSPFFromPSEAByPolicyNumberSG.txt";
                text = new String(Files.readAllBytes(Paths.get(filename)));
                query = text.replace("%policyNumber%", policyNumber);
                writeToLogFile("[SQL Query]");
                writeToLogFile(query);
                jsonPINSPF = executeQuery(con, query);
                pINSPFF = gson.fromJson(jsonPINSPF.toString(), PINSPFF[].class);

                //CLINTPF
                JsonObject dbCHDRPF = new JsonParser().parse(jsonCHDRPF.get(0).toString()).getAsJsonObject();
                JsonElement b = dbCHDRPF.getAsJsonObject();
                String partyId = "";
                if (b.getAsJsonObject().get("PAYRNUM") != null) {
                    partyId = b.getAsJsonObject().get("PAYRNUM").toString();
                } else {
                    partyId = b.getAsJsonObject().get("COWNNUM").toString();
                }
                filename = "src/sql/Regional/retrieveAccountDetails/getAccountDetailsForCLINTPFFromPSEAByValue.txt";
                text = new String(Files.readAllBytes(Paths.get(filename)));
                query = text.replace("%partyId%", partyId.replace("\"", ""));
                writeToLogFile("[SQL Query]");
                writeToLogFile(query);
                jsonCLINTPF = executeQuery(con, query);
                cLINTPFF = gson.fromJson(jsonCLINTPF.toString(), CLINTPFF[].class);

                //MANDPF
                //JsonObject dbCHDRPF = new JsonParser().parse(jsonCHDRPF.get(0).toString()).getAsJsonObject();
                //JsonElement b = dbCHDRPF.getAsJsonObject();
                String mandref = b.getAsJsonObject().get("MANDREF").toString();
                filename = "src/sql/Regional/retrieveAccountDetails/getAccountDetailsForMANDPFFromPSEAByReferenceNumber.txt";
                text = new String(Files.readAllBytes(Paths.get(filename)));
                query = text.replace("%partyId%", partyId.replace("\"", "")).replace("%mandref%", mandref.replace("\"", ""));
                writeToLogFile("[SQL Query]");
                writeToLogFile(query);
                jsonMANDPF = executeQuery(con, query);
                mANDPFF = gson.fromJson(jsonMANDPF.toString(), MANDPFF[].class);
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

    @Then("verify that API and DB responses matched for Retrieve Account Details")
    public void api_match_db() {

        if(axaLOB.equalsIgnoreCase("life")){
            validationLife();
        }else {
            validationNonLife();
        }

        writeToLogFile("=============================================================================\n");
        Assert.assertFalse(failedStatus);

    }

    public void validationLife(){
        writeToLogFile("[Validations]");
        writeToLogFile("=============================================================================");
        writeToLogFile("\nRetrieveAccountDetailsResponse().RLSPolicy()");
        writeToLogFile("=============================================================================");
        RLSPolicy rp = retrieveAccountDetailsResponseContainerLife.getRetrieveAccountDetailsResponse().getRLSPolicy();
        GetFromRLS rls = getFromRLS[0];
        compareDbToApi_String("policyNumber", rls.getPOLICYNO(), rp.getPolicyNumber());
        if(rp.getPremiumPaymentMethod()!=null)
            compareDbToApi_String("premiumPaymentMethod", getForLFPPML[0].getPAYMENTMETHOD(), rp.getPremiumPaymentMethod());
        if(rp.getDebitAccountAuthorization()!=null) {
            writeToLogFile("=============================================================================");
            writeToLogFile("\ndebitAccountAuthorization()");
            writeToLogFile("=============================================================================");
            DebitAccountAuthorization daa = rp.getDebitAccountAuthorization();
            compareDbToApi_String("bankAccountNumber", rls.getBANKACCORCREDITCARD(), daa.getBankAccountNumber());
            compareDbToApi_String("bankAccountStatus", rls.getACCCARDSTATUS(), daa.getBankAccountStatus());
            compareDbToApi_String("accountCurrencyCode", rls.getACCOUNT_CURRENCY(), daa.getAccountCurrencyCode());
            compareDbToApi_Timestamp_DatePart("premiumEffectiveDate", rls.getEFFECTIVEDATE(), daa.getPremiumEffectiveDate());
            compareDbToApi_Timestamp_DatePart("processingDate", rls.getPROCESSINGDATE(), daa.getProcessingDate());
            compareDbToApi_String("rejectionCode", rls.getREJECTION_CODE(), daa.getRejectionCode());
            compareDbToApi_String("rejectionDescription", rls.getREJECTION_REASON(), daa.getRejectionDescription());
            writeToLogFile("=============================================================================");
            writeToLogFile("\ndebitAccountAuthorization().debtor()");
            writeToLogFile("=============================================================================");
            Debtor d = daa.getDebtor();
            compareDbToApi_String("lastName", rls.getDEBITORCARDHOLDER(), d.getLastName());
            writeToLogFile("=============================================================================");
            writeToLogFile("\ndebitAccountAuthorization().depositBankBranch()");
            writeToLogFile("=============================================================================");
            DepositBankBranch dbb = daa.getDepositBankBranch();
            compareDbToApi_String("bankCode", rls.getBANK_CODE(), dbb.getBankCode());
            compareDbToApi_String("bankName", rls.getBANK_NAME(), dbb.getBankName());
            writeToLogFile("=============================================================================");
            writeToLogFile("\ndebitAccountAuthorization().collectionBankBranch()");
            writeToLogFile("=============================================================================");
            CollectionBankBranch cbb = daa.getCollectionBankBranch();
            compareDbToApi_String("branchCode", rls.getBRANCHCODE(), cbb.getBranchCode());
        }
    }

    public void validationNonLife(){
        writeToLogFile("[Validations]");
        writeToLogFile("=============================================================================");
        writeToLogFile("\nRetrieveAccountDetailsResponse().PSEAPolicy().policyInstallment()");
        writeToLogFile("=============================================================================");
        PolicyInstallment pi = retrieveAccountDetailsResponseContainer.getRetrieveAccountDetailsResponse().getPSEAPolicy().getPolicyInstallment();
        for(int i = 0; i < pi.getInstallmentEffectiveDates().size(); i++){
            compareDbToApi_Timestamp_DatePart_toYYYYMMDD("installmentEffectiveDates["+i+"]", installmentEffectiveDates[i].getINSTFROM(), pi.getInstallmentEffectiveDates().get(i));
        }

        compareDbToApi_String("installmentFrequency", pINSPFF[0].getINSTFREQ(), pi.getInstallmentFrequency());
        writeToLogFile("=============================================================================");
        writeToLogFile("\npolicyInstallmentMandate()");
        writeToLogFile("=============================================================================");
        PolicyInstallmentMandate pim = pi.getPolicyInstallmentMandate();
        //TODO - check mapping
        compareDbToApi_String("mandateStatusDescription", "", pim.getMandateStatusDescription());
        compareDbToApi_Timestamp_DatePart_toYYYYMMDD("mandateEffectiveDate", mANDPFF[0].getEFFDATE(), pim.getMandateEffectiveDate());
        compareDbToApi_String("mandateStatusCode", mANDPFF[0].getMANDSTAT(), pim.getMandateStatusCode());
        writeToLogFile("=============================================================================");
        writeToLogFile("\npolicyInstallmentMandate().payor()");
        writeToLogFile("=============================================================================");
        Payor p = pim.getPayor();
        compareDbToApi_String("displayNameFormat", cLINTPFF[0].getETHORIG(), p.getDisplayNameFormat());
        compareDbToApi_String("firstName", cLINTPFF[0].getGIVNAME(), p.getFirstName());
        compareDbToApi_String("lastName", cLINTPFF[0].getSURNAME(), p.getLastName());
        compareDbToApi_String("partyId", cLINTPFF[0].getCLNTNUM(), p.getPartyId());

        for (int i=0; i < p.getPSEAAccounts().size(); i++){
            writeToLogFile("=============================================================================");
            writeToLogFile("\npolicyInstallmentMandate().payor().PSEAAccounts["+i+"]");
            writeToLogFile("=============================================================================");
            PSEAAccount pa = p.getPSEAAccounts().get(i);
            compareDbToApi_String("cardTypeDescription", mANDPFF[i].getBANKDESC().trim(), pa.getCardTypeDescription());
            compareDbToApi_String("cardTypeCode", mANDPFF[i].getBANKKEY(), pa.getCardTypeCode());
            writeToLogFile("=============================================================================");
            writeToLogFile("\nPSEADebitAccounts()");
            writeToLogFile("=============================================================================");
            PSEADebitAccounts pda = pa.getPSEADebitAccounts();
            compareDbToApi_String("bankAccountNumber", mANDPFF[i].getBANK_ACC_NUMBER(), pda.getBankAccountNumber());
            writeToLogFile("=============================================================================");
            writeToLogFile("\nPSEACreditAccounts()");
            writeToLogFile("=============================================================================");
            PSEACreditAccounts pca = pa.getPSEACreditAccounts();
            compareDbToApi_String("creditCardNumber", mANDPFF[i].getCREDITCARDNUMBER(), pca.getCreditCardNumber());

        }
    }

}
