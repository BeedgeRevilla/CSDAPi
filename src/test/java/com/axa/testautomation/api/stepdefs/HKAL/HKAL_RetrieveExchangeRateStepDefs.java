package com.axa.testautomation.api.stepdefs.HKAL;


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
import oracle.jdbc.OracleTypes;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.sql.*;


public class HKAL_RetrieveExchangeRateStepDefs extends BaseStepDefs {

    @Autowired
    private String hkalRetrieveExchangeRate;
    @Autowired
    private String hkalRetrieveExchangeRateDbConn;
    @Autowired
    private String hkalRetrieveExchangeRateDbUser;
    @Autowired
    private String hkalRetrieveExchangeRateDbMaUser;
    @Autowired
    private String hkalRetrieveExchangeRateDbPwd;
    
    private String currencyCd;
    private String baseCurrencyCd;
    private String effectiveDt;
    private JSONArray json;

    @Given("the following http headers are set for HKAL Retrieve Exchange Rate")
    public void set_http_headers(DataTable dt) {
        failedStatus = false;
        httpHeaders.clear();
        writeToLogFile("====== HEADERS ======");
        for(Map<String, String> row : dt.asMaps()) {
            for(Map.Entry<String, String> headerMap : row.entrySet()) {
                httpHeaders.set(headerMap.getKey(), headerMap.getValue());
                writeToLogFile(headerMap.getKey() + ": " + headerMap.getValue());
            }
        }
        writeToLogFile("=====================");
    }


    @And("the following GET input parameters are set for HKAL Retrieve Exchange Rate")
    public void set_get_parameters(DataTable dt) {
        failedStatus = false;
        getParameters = "?";
        for(Map<String, String> row : dt.asMaps()) {
            for(Map.Entry<String, String> getParametersMap : row.entrySet()) {
                if(!getParametersMap.getValue().equalsIgnoreCase("")) {
                	getParameters = getParameters + getParametersMap.getKey() + "=" + getParametersMap.getValue() + "&";
                }
                
                switch (getParametersMap.getKey()) {
                	case "currencyCode": currencyCd = getParametersMap.getValue(); break;
                	case "baseCurrencyCode": baseCurrencyCd = getParametersMap.getValue(); break;
                	case "effectiveDate": effectiveDt = getParametersMap.getValue(); break;
                }
                
            }
        }
        getParameters = getParameters.substring(0, getParameters.length()-1);
        writeToLogFile("PARAMETER: " + getParameters);
    }

    @When("the api call has been made for HKAL Retrieve Exchange Rate")
    public void send_get_request_for_HKAL() {
        try {
            restTemplate = new RestTemplate();
            String url = hkalRetrieveExchangeRate + getParameters;
            writeToLogFile("ENDPOINT: " + hkalRetrieveExchangeRate);
            HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
            response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            writeToLogFile("[API Response]");
            writeToLogFile(response.getBody());
        }
        catch (HttpClientErrorException e) {
            actualHttpErrorCode = Integer.toString(e.getStatusCode().value());
            actualHttpErrorPhrase = e.getStatusCode().getReasonPhrase();
            actualHttpErrorBody = e.getResponseBodyAsString().replaceAll("\n","");
        }
        catch(HttpServerErrorException e ) {
            actualHttpErrorCode = Integer.toString(e.getStatusCode().value());
            actualHttpErrorPhrase = e.getStatusCode().getReasonPhrase();
            actualHttpErrorBody = e.getResponseBodyAsString().replaceAll("\n","");
        }
    }

    @When("the Stored Procedure is called for HKAL Retrieve Exchange Rate")
    public void call_stored_procedure(){
        String userName = hkalRetrieveExchangeRateDbUser;

        try{
            //step1 load the driver class
            Class.forName("oracle.jdbc.driver.OracleDriver");
            if (baseCurrencyCd.equalsIgnoreCase("MOP")) userName = hkalRetrieveExchangeRateDbMaUser;
            //step2 create  the connection object
            Connection con=DriverManager.getConnection(
                    "jdbc:oracle:thin:@//"+hkalRetrieveExchangeRateDbConn,userName,hkalRetrieveExchangeRateDbPwd);

            String query = "{CALL PKG_RETRIEVE.SP_RETRIEVE_EXCHANGE_RATE(?,?,?,?)}";
            CallableStatement stmt = con.prepareCall(query);
            
            stmt.setString(1, currencyCd);
            stmt.setString(2, baseCurrencyCd);
            if(effectiveDt.isEmpty()){
            	stmt.setNull(3, Types.VARCHAR);
            }else{
            	stmt.setString(3, effectiveDt);
            }
            stmt.registerOutParameter(4, OracleTypes.CURSOR);
            stmt.executeUpdate();
           
            ResultSet rs = (ResultSet) stmt.getObject(4);

            writeToLogFile("[DB ResultSet]");
            json = new JSONArray();
            ResultSetMetaData rsmd = rs.getMetaData();
            while(rs.next()) {
              int numColumns = rsmd.getColumnCount();
              JSONObject obj = new JSONObject();
              for (int i=1; i<=numColumns; i++) {
                String column_name = rsmd.getColumnName(i);
                obj.put(column_name, rs.getObject(column_name));
              }
              json.put(obj);
              writeToLogFile(json.toString());
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
    
    @Then("verify that API and DB responses matched for HKAL Retrieve Exchange Rate")
    public void hkal_match_db() {
        JsonObject hkal = new JsonParser().parse(response.getBody()).getAsJsonObject();
        JsonObject db = null;
		try {
			db = new JsonParser().parse(json.get(0).toString()).getAsJsonObject();
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        writeToLogFile("[Validations]");
        writeToLogFile("=============================================================================");
        JsonElement a = hkal.get("retrieveExchangeRateDetailsResponse").getAsJsonObject().get("exchangeRateReference");
        JsonElement b = db.getAsJsonObject();
        compareDBtoAPI("currencyCode", b.getAsJsonObject().get("CURRENCY").toString(), a.getAsJsonObject().get("currencyCode").toString());
        compareDBtoAPI("effectiveDate", "\""+b.getAsJsonObject().get("EFFECTIVE_DATE")+"\"", a.getAsJsonObject().get("effectiveDate").toString());
        compareDBtoAPI("sellRate", "\""+b.getAsJsonObject().get("SELLING_RATE")+"\"", a.getAsJsonObject().get("sellRate").toString());
        compareDBtoAPI("buyRate", "\""+b.getAsJsonObject().get("BUYING_RATE")+"\"", a.getAsJsonObject().get("buyRate").toString());
        compareDBtoAPI("bookRate", "\""+b.getAsJsonObject().get("BOOK_RATE")+"\"", a.getAsJsonObject().get("bookRate").toString());
        compareDBtoAPI("baseCurrencyCode", b.getAsJsonObject().get("BASE_CURRENCY").toString(), a.getAsJsonObject().get("baseCurrencyCode").toString());

        writeToLogFile("=============================================================================\n");
		Assert.assertFalse(failedStatus);
    }

}
