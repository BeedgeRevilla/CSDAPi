package com.axa.testautomation.api.stepdefs.Regional;


import com.axa.testautomation.api.regional.RetrieveFundList.response.*;
import com.axa.testautomation.api.regional.RetrieveFundList.dbResult.*;
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
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import javax.swing.text.html.parser.Entity;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


public class REGIONAL_RetrieveFundListStepDefs extends BaseStepDefs {

    @Autowired
    private String regionalNitRetrieveFundList;

    @Autowired
    private String sg_MDCAC7QI;
    @Autowired
    private String l_SG_CACHE;
    @Autowired
    private String th_MDCAC2QI;
    @Autowired
    private String l_TH_CACHE;
    @Autowired
    private String ph_MDCAC2QI;
    @Autowired
    private String l_PH_CACHE;
    @Autowired
    private String hk_MDCRPP2I;
//    @Autowired
//    private String hk_MDCAC2QI;
    @Autowired
    private String l_HK_CACHE;
    @Autowired
    private String cachePassword;

    private String dbConnection = "";
    private String userName = "";
    private String password = "";
    
    private JSONArray jsonPSEAByGetFundListCount;
    private JSONArray jsonSearchFundCount;
    private JSONArray jsonbidAndOfferPriceCount;
    
    private String axaEntity;
    private String policyNumber;

	private RetrieveFundListContainer retrieveFundListContainer;

	private GetFundListCount[] getFundListCount;
	private SearchFundCount[] searchFundCount;
	private GetBidAndOfferPriceCount[] bidAndOfferPriceCount;

    @Given("the following http headers are set Retrieve Fund List")
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


    @And("the following GET input parameters are set for Retrieve Fund List")
    public void set_get_parameters(DataTable dt) {
        failedStatus = false;
        getParameters = "?";
        for(Map<String, String> row : dt.asMaps()) {
            for(Map.Entry<String, String> getParametersMap : row.entrySet()) {
                getParameters = getParameters + getParametersMap.getKey() + "=" + getParametersMap.getValue() + "&";
               
                switch (getParametersMap.getKey()){
                    case "policyNumber": policyNumber = getParametersMap.getValue(); break;
                }
            }
        }
        getParameters = getParameters.substring(0, getParameters.length()-1);
        writeToLogFile("PARAMETER: " + getParameters);
    }

    @When("the api call has been made for Retrieve Fund List")
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
            String url = regionalNitRetrieveFundList + getParameters;
            writeToLogFile("ENDPOINT: " + regionalNitRetrieveFundList);
            HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
            response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            writeToLogFile("[API Response]");
            writeToLogFile(response.getBody());
            
            Gson gson = new Gson();
            retrieveFundListContainer = gson.fromJson(response.getBody(),RetrieveFundListContainer.class);
        }
        catch (HttpClientErrorException | HttpServerErrorException e) {
            actualHttpErrorCode = Integer.toString(e.getStatusCode().value());
            actualHttpErrorPhrase = e.getStatusCode().getReasonPhrase();
            actualHttpErrorBody = e.getResponseBodyAsString().replaceAll("\n","");
            writeToLogFile("[API Response]");
            writeToLogFile(actualHttpErrorBody);
        }
    }
    @When("the Stored Procedure is called for Retrieve Fund List")
    public void call_stored_procedure(){
    	if(response == null){
    		failedStatus = true;
    		scenario.write ("[API Response]");
    		scenario.write (actualHttpErrorBody);
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

            //step2 create  the connection object
            switch (axaEntity.toLowerCase()){
                case "sg": dbConnection = sg_MDCAC7QI;
                    userName = l_SG_CACHE;
                    password = cachePassword;
                    break;
                case "th": dbConnection = th_MDCAC2QI;
                	userName = l_TH_CACHE;
                	password = cachePassword;
                	break;
                case "ph": dbConnection = ph_MDCAC2QI;
                    userName = l_PH_CACHE;
                    password = cachePassword;
                    break;
                case "hk": dbConnection = hk_MDCRPP2I;
                //case "hk": dbConnection = hk_MDCAC2QI;
                    userName = l_HK_CACHE;
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

            //PolicyNumber
            filename = "src/sql/Regional/retrieveFundList/getFundListCountForLFPPMFNFromLIFEByPolicyNumber.txt";
            text = new String(Files.readAllBytes(Paths.get(filename)));
            query = text.replace("%policyNumber%", policyNumber);
            writeToLogFile("[SQL Query]");
            writeToLogFile(query);
            jsonPSEAByGetFundListCount = executeQuery(con, query);
            
            Gson gson = new Gson();
            getFundListCount = gson.fromJson(jsonPSEAByGetFundListCount.toString(),GetFundListCount[].class);

            filename = "src/sql/Regional/retrieveFundList/searchFundCountForLFPPMFNFromLIFE.txt";
            text = new String(Files.readAllBytes(Paths.get(filename)));
            query = text.replace("%policyNumber%", policyNumber);
            writeToLogFile("[SQL Query]");
            writeToLogFile(query);
            jsonSearchFundCount = executeQuery(con, query);

            gson = new Gson();
            searchFundCount = gson.fromJson(jsonSearchFundCount.toString(),SearchFundCount[].class);
            
            //step5 close the connection object
            con.close();

        }catch(Exception e){
            failedStatus = true;
            scenario.write(e.toString());
            writeToLogFile(e.toString());
            Assert.assertFalse(failedStatus);

        }
    }    
    
    @Then("verify that API and DB responses matched for Retrieve Fund List")
    public void api_match_db() throws ParserConfigurationException, SAXException, IOException {
    	/*String dbConnection = "", userName = "", password = "";*/
    	
    	try {
	    	Class.forName("oracle.jdbc.driver.OracleDriver");

	        /*switch (axaEntity.toLowerCase()){
	            case "sg": dbConnection = sg_MDCAC7QI;
	                userName = l_SG_CACHE;
	                password = cachePassword;
	                break;
	            case "th": dbConnection = th_MDCAC2QI;
	            	userName = l_TH_CACHE;
	            	password = cachePassword;
                break;
	        }*/

	        Connection con=DriverManager.getConnection(
	                "jdbc:oracle:thin:@//"+dbConnection,userName,password);

	        writeToLogFile("[Validations]");
	        writeToLogFile("=============================================================================");
	        writeToLogFile("RetrieveFundListResponse().RLSPolicy()");
	        writeToLogFile("=============================================================================");
	        RLSPolicy rlp = retrieveFundListContainer.getRetrieveFundListResponse().getRLSPolicy();
	         
	        compareDbToApi_String("policyNumber", searchFundCount[0].getpOLICYNUMBER(), rlp.getPolicyNumber());
	         
	        writeToLogFile("=============================================================================");
	        writeToLogFile("RetrieveFundListResponse().RLSPolicy().investmentPolicy()");
	        writeToLogFile("=============================================================================");
	        InvestmentPolicy ip = retrieveFundListContainer.getRetrieveFundListResponse().getRLSPolicy().getInvestmentPolicy();
	        //TODO - check mapping - not found in MTM
	        compareDbToApi_String("subAccountFlag", "N", ip.getSubAccountFlag());

	        if(ip.getTotalAccountValueAmount()!=null) {
                String filename1 = "src/sql/Regional/retrieveFundList/getTotalAccountValueAmount.txt";
                String text1 = new String(Files.readAllBytes(Paths.get(filename1)));
                String query1 = text1.replace("%policyNumber%", policyNumber);

                JSONArray totAcctVal = executeQueryNoLogs(con, query1);

                Gson gson1 = new Gson();
                GetTotalAccountValueAmount[] getTotalAccountValueAmount = gson1.fromJson(totAcctVal.toString(), GetTotalAccountValueAmount[].class);

                DecimalFormat df = new DecimalFormat("#.00");
                compareDbToApi_Decimal("totalAccountValueAmount", df.format(getTotalAccountValueAmount[0].getTOTAL_ACCT_VAL()), ip.getTotalAccountValueAmount());
            }
	         
	        List<FundSubAccountHolding> fsub = retrieveFundListContainer.getRetrieveFundListResponse().getRLSPolicy().getInvestmentPolicy().getFundSubAccountHoldings();
	        for(int i=0; i<fsub.size(); i++){
	            writeToLogFile("=============================================================================");
	            writeToLogFile("fundSubAccountHoldings[" + i + "]");
	            writeToLogFile("=============================================================================");
	        	FundSubAccountHolding fsah = fsub.get(i);
	        	//SearchFundCount sfc = searchFundCount[i];
                String filename1 = "src/sql/Regional/retrieveFundList/getFundSubAccountHoldings.txt";
                String text1 = new String(Files.readAllBytes(Paths.get(filename1)));
                String query1 = text1.replace("%policyNumber%", policyNumber).replace("%fundCode%", fsah.getFundMaster().getFundCode());
                jsonSearchFundCount = executeQueryNoLogs(con, query1);

                Gson gson1 = new Gson();
                SearchFundCount[] searchFundCount1 = gson1.fromJson(jsonSearchFundCount.toString(),SearchFundCount[].class);
                SearchFundCount sfc = searchFundCount1[0];

                if(axaEntity.equalsIgnoreCase("SG")){
                    String filename = "src/sql/Regional/retrieveFundList/getExchangeRate.txt";
                    String text = new String(Files.readAllBytes(Paths.get(filename)));
                    String query = text.replace("%policyNumber%", policyNumber).replace("%fundCode%", fsah.getFundMaster().getFundCode());

                    JSONArray exRate = executeQueryNoLogs(con, query);

                    Gson gson = new Gson();
                    GetExchangeRate[] getExchangeRate = gson.fromJson(exRate.toString(),GetExchangeRate[].class);

                    DecimalFormat df = new DecimalFormat("#.0000");
                    if(getExchangeRate[0].getEXCHANGE_RATE_VALUE()!=null) {
                        compareDbToApi_Timestamp_DatePart_toYYYYMMDD("exchangeRateDate", getExchangeRate[0].getEXCHANGE_RATE_DATE(), fsah.getExchangeRateDate());
                        Double tmp = (double)Math.round(getExchangeRate[0].getEXCHANGE_RATE_VALUE() * 10000d) / 10000d;
                        compareDbToApi_String("exchangeRateValue", df.format(tmp), fsah.getExchangeRateValue());
                    }

                }

	        	compareDbToApi_Integer("fundAllocationPercentage", sfc.getfUNDALLOCATION(), fsah.getFundAllocationPercentage());
                if(sfc.getFUND_BALANCE()!=0) {
                    DecimalFormat df = new DecimalFormat("#.00");
                    compareDbToApi_Decimal("fundCurrencyBalanceAmount", df.format(sfc.getFUND_BALANCE()), fsah.getFundCurrencyBalanceAmount());
                }else{
                    compareDbToApi_Decimal("fundCurrencyBalanceAmount", "0", fsah.getFundCurrencyBalanceAmount());
                }
	        	if(axaEntity.equalsIgnoreCase("SG")) {
                    compareDbToApi_Decimal2("numberOfUnits", sfc.getM4UNIT(), fsah.getNumberOfUnits());
	        	}else{
	        	    if(sfc.getM4UNIT() != 0) {
                        compareDbToApi_Decimal("numberOfUnits", sfc.getM4UNIT(), fsah.getNumberOfUnits());
                    }else{
                        compareDbToApi_Decimal("numberOfUnits", "0", fsah.getNumberOfUnits());
                    }
	        	}

                DecimalFormat df = new DecimalFormat("#.00");
	        	if(axaEntity.equalsIgnoreCase("HK")) {
	        	    if(sfc.getQ47AMTP()==0.0){
                        compareDbToApi_Decimal("policyCurrencyTotalAmount", "0", fsah.getPolicyCurrencyTotalAmount());
                    }else {
                        compareDbToApi_Decimal("policyCurrencyTotalAmount", df.format(sfc.getQ47AMTP()), fsah.getPolicyCurrencyTotalAmount());
                    }
                }else{
                    compareDbToApi_Decimal("policyCurrencyTotalAmount", df.format(sfc.getQ47AMTP()), fsah.getPolicyCurrencyTotalAmount());
                }
	        	 
	        	writeToLogFile("=============================================================================");
	            writeToLogFile("fundMaster");
	            writeToLogFile("=============================================================================");
	            FundMaster fm = fsah.getFundMaster();
	            compareDbToApi_String("fundCode", sfc.getM4CODE(), fm.getFundCode());
	            compareDbToApi_String("fundName", sfc.getfUND_NAME(), fm.getFundName());
	            compareDbToApi_String("fundCurrencyCode", sfc.getfUNDCURRENCY(), fm.getFundCurrencyCode());
	            compareDbToApi_String("unitPriceAmount", sfc.getQ47FPRC(), fm.getUnitPriceAmount());
	             
	            if(axaEntity.equalsIgnoreCase("SG")){
		            String filename = "src/sql/Regional/retrieveFundList/bidAndOfferPriceQuery.txt";
		            String text = new String(Files.readAllBytes(Paths.get(filename)));
		            String query = text.replace("%policyNumber%", policyNumber).replace("%fundCode%", fm.getFundCode());

		            jsonbidAndOfferPriceCount = executeQueryNoLogs(con, query);
		             
		            Gson gson = new Gson();
		            bidAndOfferPriceCount = gson.fromJson(jsonbidAndOfferPriceCount.toString(),GetBidAndOfferPriceCount[].class);
		             
		            GetBidAndOfferPriceCount baopc = bidAndOfferPriceCount[0];
		            df = new DecimalFormat("#.0000");
		             
		            compareDbToApi_String("fundBidPrice", df.format(baopc.getFPBIDP()), fm.getFundBidPrice());
		            compareDbToApi_String("fundOfferPrice", df.format(baopc.getFPOFFP()), fm.getFundOfferPrice());

	            }
	        }
            con.close();
	        writeToLogFile("=============================================================================");
	        writeToLogFile("RetrieveFundListResponse().paginationResult()");
	        writeToLogFile("=============================================================================");
	        PaginationResult pg = retrieveFundListContainer.getRetrieveFundListResponse().getPaginationResult();
	        compareDbToApi_String("position", "0", pg.getPosition());
	        compareDbToApi_Integer("count", getFundListCount[0].getPOLICYCNT(), pg.getCount());
	        compareDbToApi_Integer("totalCount", getFundListCount[0].getPOLICYCNT(), pg.getTotalCount());
	         
	        writeToLogFile("=============================================================================");
	        writeToLogFile("RetrieveFundListResponse().sortResult()");
	        writeToLogFile("=============================================================================");
	        SortResult srt = retrieveFundListContainer.getRetrieveFundListResponse().getSortResult();
	        compareDbToApi_String("sortKey", "FUND_PRICE_DATE", srt.getSortKey());
	        compareDbToApi_String("order", "DESC", srt.getOrder());
    	}catch(Exception e){
            failedStatus = true;
            scenario.write(e.toString());
            writeToLogFile(e.toString());
            Assert.assertFalse(failedStatus);

        }

        writeToLogFile("=============================================================================\n");
        Assert.assertFalse(failedStatus);
    }
    
}