package com.axa.testautomation.api.stepdefs;

import com.google.gson.JsonElement;

import cucumber.api.Scenario;

import org.apache.commons.lang.StringUtils;
import org.apache.tika.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Node;

import java.io.*;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class BaseStepDefs {

    @Autowired
    public RestTemplate restTemplate;

    @Autowired
    public RestTemplate restTemplateValidator;

    public static HttpHeaders httpHeaders = new HttpHeaders();
    public static String getParameters;
    public static HttpHeaders validatorHttpHeaders = new HttpHeaders();
    public static String getValidatorParameters;
    public ResponseEntity<String> response;
    public ResponseEntity<String> validatorResponse;
    public static String actualHttpErrorCode = "";
    public static String actualHttpErrorPhrase = "";
    public static String actualHttpErrorBody = "";
    public static boolean failedStatus = false;
    public static Scenario scenario;
    public static String timeStamp;
    public static String logFilename;

    private static Logger logger = LoggerFactory.getLogger(BaseStepDefs.class);

    public void compareDbToApi_String(String fieldName, @Nullable String expectedValue, @Nullable String actualValue){
        compareDBtoAPI(fieldName, expectedValue, actualValue);
    }
    
    public void compareDbToApi_StringTrim(String fieldName, String expectedValue, String actualValue){
        if (actualValue!=null)  {
            if(expectedValue!=null) {
            	String value = expectedValue.trim();
            	compareDBtoAPI(fieldName, value, actualValue);
            }else{
                compareDBtoAPI(fieldName, "", actualValue);
            }
        } else {
            compareAPItoDB(fieldName, null, null);
        }
    }

    public void compareDbToApi_String(String fieldName, JsonElement expectedValue, JsonElement actualValue){
    	if (actualValue!=null) {
            if (!actualValue.isJsonNull()) {
                compareDBtoAPI(fieldName, expectedValue.toString(), actualValue.toString());
            } else {
                compareAPItoDB(fieldName, expectedValue, actualValue);
            }
        }
    }

    public void compareDbToApi_String(String fieldName, JsonElement expectedValue, String actualValue){
        if (actualValue!=null) {
            compareDBtoAPI(fieldName, expectedValue.toString(), actualValue.toString());
        }else{
            compareAPItoDB(fieldName, expectedValue, null);
        }
    }
    
    public void compareDbToApi_String(String fieldName, String expectedValue, JsonElement actualValue){
    	if (actualValue!=null) {
            if (!actualValue.isJsonNull()) {
                compareDBtoAPI(fieldName, "\"" + expectedValue + "\"", actualValue.toString());
            } 
        }
    }
    
    public void compareDbToApi_String(String fieldName, Node expectedValue, JsonElement actualValue){
    	if (actualValue!=null) {
            if (!actualValue.isJsonNull()) {
                compareDBtoAPI(fieldName, "\"" + expectedValue.getTextContent() + "\"", actualValue.toString());
            } 
        }
    }
    
    public void compareDbToApi_Integer(String fieldName, JsonElement expectedValue, JsonElement actualValue){
    	if (actualValue!=null) {
            if (!actualValue.isJsonNull()) {
            	compareDBtoAPI(fieldName, "\""+expectedValue.toString()+"\"", actualValue.toString());
            } else {
                compareAPItoDB(fieldName, expectedValue, actualValue);
            }
        }
    }
    
    public void compareDbToApi_Integer(String fieldName, int expectedValue, JsonElement actualValue){
    	if (actualValue!=null) {
            if (!actualValue.isJsonNull()) {
            	compareDBtoAPI(fieldName, "\""+Integer.toString(expectedValue)+"\"", actualValue.toString());
            } 
        } else {
            compareAPItoDB(fieldName, null, null);
        }
    }

    public void compareDbToApi_Integer(String fieldName, int expectedValue, String actualValue){
        if (actualValue!=null) {
            compareDBtoAPI(fieldName, Integer.toString(expectedValue), actualValue.toString());
        } else {
            compareAPItoDB(fieldName, null, null);
        }
    }
    
    public void compareDbToApi_Decimal(String fieldName, JsonElement expectedValue, JsonElement actualValue){
    	if (actualValue!=null) {
            if (!actualValue.isJsonNull()) {
                compareDBtoAPI(fieldName, getConvertedDecimal(expectedValue.getAsDouble()), actualValue.toString());
            } else {
                compareAPItoDB(fieldName, expectedValue, actualValue);
            }
        }
    }
    
    public void compareDbToApi_Decimal(String fieldName, Double expectedValue, JsonElement actualValue){
    	if (actualValue!=null) {
            if (!actualValue.isJsonNull()) {
                compareDBtoAPI(fieldName, getConvertedDecimal(expectedValue), actualValue.toString());
            } 
        }else {
            compareAPItoDB(fieldName, null, null);
        }
    }

    public void compareDbToApi_Decimal(String fieldName, Double expectedValue, String actualValue){
        if (actualValue!=null) {
            compareDBtoAPI(fieldName, expectedValue.toString(), actualValue.toString());
        }else {
            compareAPItoDB(fieldName, null, null);
        }
    }

    public void compareDbToApi_Decimal2(String fieldName, Double expectedValue, String actualValue){
        if (actualValue!=null) {
            compareDBtoAPI(fieldName, getConvertedDecimal2DP(expectedValue), actualValue.toString());
        }else {
            compareAPItoDB(fieldName, null, null);
        }
    }
    
    public void compareDbToApi_Decimal2DP(String fieldName, Double expectedValue, String actualValue){
        if (actualValue!=null) {
            compareDBtoAPI(fieldName, getConvertedDecimal2DP(expectedValue), actualValue.toString());
        }else {
            compareAPItoDB(fieldName, null, null);
        }
    }

    public void compareDbToApi_Decimal3(String fieldName, Double expectedValue, String actualValue){
        if (actualValue!=null) {
            double x = expectedValue - Math.floor(expectedValue);
            if(x!=0) {
                compareDBtoAPI(fieldName, getConvertedDecimal2(expectedValue), actualValue.toString());
            }else{
                compareDBtoAPI(fieldName, Integer.toString(expectedValue.intValue()), actualValue.toString());
            }

        }else {
            compareAPItoDB(fieldName, null, null);
        }
    }

    public void compareDbToApi_Decimal(String fieldName, Integer expectedValue, JsonElement actualValue){
        if (actualValue!=null) {
            if (!actualValue.isJsonNull()) {
                compareDBtoAPI(fieldName, getConvertedDecimal(expectedValue), actualValue.toString());
            }
        }else {
            compareAPItoDB(fieldName, null, null);
        }
    }

    public void compareDbToApi_Decimal(String fieldName, Integer expectedValue, String actualValue){
        if (actualValue!=null) {
            compareDBtoAPI(fieldName, getConvertedDecimal(expectedValue), actualValue.toString());
        }else {
            compareAPItoDB(fieldName, null, null);
        }
    }

    public void compareDbToApi_Decimal(String fieldName, @Nullable String expectedValue, @Nullable String actualValue){
        if (actualValue!=null) {
            compareDBtoAPI(fieldName, expectedValue, actualValue.toString());
        }else {
            compareAPItoDB(fieldName, null, null);
        }
    }

    public void compareDbToApi_Decimal0DP(String fieldName, String expectedValue, String actualValue){
        if (actualValue!=null) {
            if(expectedValue.equalsIgnoreCase("0.0")) {
                compareDBtoAPI(fieldName, "0", actualValue.toString());
            }else{
                compareDBtoAPI(fieldName, expectedValue, actualValue.toString());
            }
        }else {
            compareAPItoDB(fieldName, null, null);
        }
    }

    public void compareDbToApi_Timestamp_DatePart(String fieldName, @Nullable String expectedValue, @Nullable String actualValue){
        if (actualValue!=null) {
            if(expectedValue!=null) {
                compareDBtoAPI(fieldName, getDatePartInTimeStamp(expectedValue.toString()).replace("\"", ""), actualValue.toString());
            }
        }
    }
    
    public void compareDbToApi_Timestamp_DatePart(String fieldName, JsonElement expectedValue, JsonElement actualValue){
    	if (actualValue!=null) {
            if (!actualValue.isJsonNull()) {
            	compareDBtoAPI(fieldName, getDatePartInTimeStamp(expectedValue.toString()), actualValue.toString());
            } 
        }
    }
    
    public void compareDbToApi_Timestamp_DatePart_fromDDMMYYYY_toYYYYMMDD(String fieldName, String expectedValue, JsonElement actualValue){
    	if (actualValue!=null) {
            if (!actualValue.isJsonNull()) {
            	compareDBtoAPI(fieldName, getDatePartInTimeStamp_yyyy_mm_dd(expectedValue), actualValue.toString());
            } 
        }
    }

    public void compareDbToApi_Timestamp_DatePart_toYYYYMMDD(String fieldName, String expectedValue, String actualValue){
        if (actualValue!=null) {
            compareDBtoAPI(fieldName, getConvertedDate_yyyy_mm_dd(expectedValue.toString()).replace("\"", ""), actualValue.toString());
        }
    }
    
    public void compareDbToApi_Timestamp_DatePart_toYYYYMMDD(String fieldName, String expectedValue, JsonElement actualValue){
    	if (actualValue!=null) {
            if (!actualValue.isJsonNull()) {
            	compareDBtoAPI(fieldName, getConvertedDate_yyyy_mm_dd(expectedValue.toString()), actualValue.toString());
            } 
        }
    }

    public void compareDbToApi_Timestamp_DatePart_toYYYYMMDD(String fieldName, JsonElement expectedValue, JsonElement actualValue){
        if (actualValue!=null) {
            if (!actualValue.isJsonNull()) {
                compareDBtoAPI(fieldName, getConvertedDate_yyyy_mm_dd(expectedValue.toString()), actualValue.toString());
            }
        }
    }

    public void compareDBtoAPI(String fieldName, @Nullable String expectedValue, @Nullable String actualValue){
    	boolean mismatched = false;
        writeToLogFile("-----------------------------------------------------------------------------");
        String expected = ((expectedValue==null)?"":expectedValue);
        String actual = ((actualValue==null)?"":actualValue);

        if (!expected.contentEquals(actual)) {
            failedStatus = true;
            mismatched = true;
            writeToLogFile("Field Name    : " + fieldName + " - [FAILED]");
        } else {
            writeToLogFile("Field Name    : " + fieldName);
        }

        writeToLogFile("Expected Value: " + expected);
        writeToLogFile("Actual Value  : " + actual);

        if(mismatched){
        	scenario.write("Field Name    : " + fieldName + " - [FAILED]");
        	scenario.write("Expected Value: " + expected);
        	scenario.write("Actual Value  : " + actual);
        }
    }

    public void compareAPItoDB(String fieldName, JsonElement expectedValue, JsonElement actualValue) {
        String retExpected = "";
        String retActual = "";
        boolean isConverted = false;
        boolean mismatched = false;
        writeToLogFile("-----------------------------------------------------------------------------");
        if (expectedValue != null){
            if (!expectedValue.toString().contentEquals(actualValue.toString())) {
                retExpected = "\""+expectedValue.toString().replace("\"", "").trim()+"\"";
                retActual = "\""+actualValue.toString().replace("\"", "").trim()+"\"";
                if (retExpected.contentEquals(retActual)) {
                    writeToLogFile("Field Name    : " + fieldName);
                    isConverted = true;
                }else {
                    failedStatus = true;
                    mismatched = true;
                    writeToLogFile("Field Name    : " + fieldName + " - [FAILED]");
                }
            } else {
                writeToLogFile("Field Name    : " + fieldName);
            }

            if(isConverted){
                writeToLogFile("Expected Value: " + retExpected);
                writeToLogFile("Actual Value  : " + retActual);
            }else{
                writeToLogFile("Expected Value: " + expectedValue);
                writeToLogFile("Actual Value  : " + actualValue);
            }
        }else{
            if(actualValue==null) {
                writeToLogFile("Field Name    : " + fieldName);
                writeToLogFile("Expected Value: " + null);
                writeToLogFile("Actual Value  : " + null);
            }else {
                if (!actualValue.isJsonNull()) {
                    failedStatus = true;
                    mismatched = true;
                    writeToLogFile("Field Name    : " + fieldName + " - [FAILED]");
                } else {
                    writeToLogFile("Field Name    : " + fieldName);
                }
                writeToLogFile("Expected Value: " + expectedValue);
                writeToLogFile("Actual Value  : " + actualValue);
            }
        }

        if(mismatched){
        	scenario.write("Field Name    : " + fieldName + " - [FAILED]");
        	scenario.write("Expected Value: " + expectedValue);
        	scenario.write("Actual Value  : " + actualValue);
        }
    }

    public void compareAPItoAPI(String fieldName, @Nullable String expectedValue, @Nullable String actualValue){
        writeToLogFile("-----------------------------------------------------------------------------");
        String expected = expectedValue;
        String actual = actualValue;
        boolean mismatched = false;
        if(expectedValue.equalsIgnoreCase("null")) {
            expected = "\"\"";
        }
        if(!expected.contentEquals(actual)) {
            failedStatus = true;
            mismatched = true;
            writeToLogFile("Field Name    : " + fieldName + " - [FAILED]");
        }else{
            writeToLogFile("Field Name    : " + fieldName);
        }

        writeToLogFile("Expected Value: " + expectedValue);
        writeToLogFile("Actual Value  : " + actualValue);

        if(mismatched){
        	scenario.write("Field Name    : " + fieldName + " - [FAILED]");
        	scenario.write("Expected Value: " + expectedValue);
        	scenario.write("Actual Value  : " + actualValue);
        }
    }

    public void compareAPItoTable(String fieldName, @Nullable String expectedValue, @Nullable String actualValue){
    	boolean mismatched = false;
        writeToLogFile("-----------------------------------------------------------------------------");
        if(!expectedValue.contentEquals(actualValue)) {
            failedStatus = true;
            mismatched = true;
            writeToLogFile("Field Name    : " + fieldName + " - [FAILED]");
        }else{
            writeToLogFile("Field Name    : " + fieldName);
        }

        writeToLogFile("Expected Value: " + expectedValue);
        writeToLogFile("Actual Value  : " + actualValue);

        if(mismatched){
        	scenario.write("Field Name    : " + fieldName + " - [FAILED]");
        	scenario.write("Expected Value: " + expectedValue);
        	scenario.write("Actual Value  : " + actualValue);
        }
    }

    public static void printScreenDump(List<String> screen){
        writeToLogFile("----------------------------------------------------------------------------------");
        writeToLogFile("|                             AS400 SCREEN DUMP                                  |");
        writeToLogFile("|--------------------------------------------------------------------------------|");
        for (String line : screen) {
            writeToLogFile("|" + StringUtils.rightPad(line.replace("\u0000", " " ), 80, " ") + "|");
        }
        writeToLogFile("----------------------------------------------------------------------------------");
    }

    public static void printScreenDump(Scenario sceanrio, List<String> screen){
        writeToLogAndScenario(scenario, "----------------------------------------------------------------------------------");
        writeToLogAndScenario(scenario, "|                             AS400 SCREEN DUMP                                  |");
        writeToLogAndScenario(scenario, "|--------------------------------------------------------------------------------|");
        for (String line : screen) {
            writeToLogAndScenario(scenario, "|" + StringUtils.rightPad(line.replace("\u0000", " " ), 80, " ") + "|");
        }
        writeToLogAndScenario(scenario, "----------------------------------------------------------------------------------");
    }

    public static void writeToLogAndScenario(Scenario scenario, String line){
        writeToLogFile(line);
        scenario.write(line);
    }

    public static void writeToLogFile(String consoleText) {
        String[] feature = scenario.getId().split(":");
        String filename = "";
        String[] temp = feature[1].split("/");
        String featureFilename = temp[temp.length - 1];
        if(System.getProperty("isCitrix")!=null) {
            filename = "target\\cucumber-reports\\cucumber-html-reports\\"+featureFilename.replace(".feature", "");
        }else{

            filename = "target/cucumber-reports/cucumber-html-reports/"+featureFilename.replace(".feature", "");
        }

        logFilename = filename +"_"+timeStamp+".txt";
        File file = new File(logFilename);
        FileWriter fr = null;
        BufferedWriter bw = null;

        try {
            // Below constructor argument decides whether to append or override
            fr = new FileWriter(file, true);
            bw = new BufferedWriter(fr);
            bw.append(consoleText);
            bw.newLine();

        } catch (IOException e) {
            //e.printStackTrace();
            logger.error("Exception occur: " + e);
        } finally {
            try {
                bw.close();
                fr.close();
            } catch (IOException e) {
                //e.printStackTrace();
                logger.error("Exception occur: " + e);
            }
        }
//        System.out.println(consoleText);
        logger.info(consoleText);
    }

    public String getDatePartInTimeStamp(String dateTimeStamp) {
        String[] temp = dateTimeStamp.split(" ");
        return temp[0]+"\"";
    }
    
    public String getDatePartInTimeStamp_yyyy_mm_dd(String dateTimeStamp) {
        String[] temp = dateTimeStamp.split(" ");
        String[] dtValue = temp[0].split("-");
        return "\""+dtValue[2]+"-"+dtValue[1]+"-"+dtValue[0]+"\"";
    }

    public String getConvertedDecimal(Double dblValue){
        DecimalFormat df = new DecimalFormat("#0.00");
        return "\"" + df.format(dblValue) + "\"";
    }
    
    public String getConvertedDecimal2DP(Double dblValue){
        DecimalFormat df = new DecimalFormat("#0.00");
        return df.format(dblValue);
    }

    public String getConvertedDecimal2(Double dblValue){
        DecimalFormat df = new DecimalFormat("#0.0#");
        return df.format(dblValue);
    }

    public String getConvertedDecimal(Integer dblValue){
        DecimalFormat df = new DecimalFormat("#0.00");
        return "\""+df.format(dblValue)+"\"";
    }

    public String getConvertedDate_yyyy_mm_dd(String dtValue){
        return "\""+dtValue.substring(0,4)+"-"+dtValue.substring(4,6)+"-"+dtValue.substring(6)+"\"";
    }

    public JSONArray executeQuery(Connection con, String query){
        JSONArray jsonReturn = new JSONArray();
        try {
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            writeToLogFile("[DB ResultSet]");

            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next()) {
                int numColumns = rsmd.getColumnCount();
                JSONObject obj = new JSONObject();
                for (int i = 1; i <= numColumns; i++) {
                    String column_name = rsmd.getColumnName(i);
                    obj.put(column_name, rs.getObject(column_name));
                }
                jsonReturn.put(obj);
            }

            rs.close();
            stmt.close();

        }catch(Exception e){
            failedStatus = true;
            scenario.write(e.toString());
            writeToLogFile(e.toString());
            Assert.assertFalse(failedStatus);

        }

        writeToLogFile(jsonReturn.toString());
        return jsonReturn;
    }

    public JSONArray executeQueryNoLogs(Connection con, String query){
        JSONArray jsonReturn = new JSONArray();
        try {
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next()) {
                int numColumns = rsmd.getColumnCount();
                JSONObject obj = new JSONObject();
                for (int i = 1; i <= numColumns; i++) {
                    String column_name = rsmd.getColumnName(i);
                    obj.put(column_name, rs.getObject(column_name));
                }
                jsonReturn.put(obj);
            }
            rs.close();
            stmt.close();

        }catch(Exception e){
            failedStatus = true;
            scenario.write(e.toString());
            writeToLogFile(e.toString());
            Assert.assertFalse(failedStatus);

        }

        return jsonReturn;
    }

    public List<String> executeQuery2(Connection con, String query){
        List<String> data = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            writeToLogFile("[DB ResultSet]");

            ResultSetMetaData rsmd = rs.getMetaData();
            String[] type = new String[rsmd.getColumnCount()];

            for (int col = 0;col < rsmd.getColumnCount();col++)
                type[col] = rsmd.getColumnTypeName(col + 1);

            int row = 0;
            while (rs.next()) {
                for (int col = 0;col < rsmd.getColumnCount();col++) {
                    if (type[col] == "CLOB") {

                        // Assign result set to CLOB variable.
                        Clob clob = rs.getClob(col + 1);

                        // Check that it is not null and read the character stream.
                        if (clob != null) {

                            data.add(clobToString(clob));
                        }
                    }

                }
                row = row + 1;
            }

            rs. close();
            stmt.close();



        }catch(Exception e){
            failedStatus = true;
            scenario.write(e.toString());
            writeToLogFile(e.toString());
            Assert.assertFalse(failedStatus);

        }
        writeToLogFile(data.toString());
        return data;
    }

    public List<String> executeQuery2(Connection con, String query, String fieldName){
        List<String> data = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            writeToLogFile("[DB ResultSet]");

            ResultSetMetaData rsmd = rs.getMetaData();
            String[] type = new String[rsmd.getColumnCount()];

            for (int col = 0;col < rsmd.getColumnCount();col++)
                type[col] = rsmd.getColumnTypeName(col + 1);

            int row = 0;
            while (rs.next()) {
                for (int col = 0;col < rsmd.getColumnCount();col++) {
                    if ((type[col] == "CLOB") && (rsmd.getColumnName(col+1).equalsIgnoreCase(fieldName))) {
                    //if ((type[col] == "CLOB")) {
                        // Assign result set to CLOB variable.
                        Clob clob = rs.getClob(col + 1);

                        // Check that it is not null and read the character stream.
                        if (clob != null) {

                            data.add(clobToString(clob));
                        }
                    }

                }
                row = row + 1;
            }

            rs. close();
            stmt.close();



        }catch(Exception e){
            failedStatus = true;
            scenario.write(e.toString());
            writeToLogFile(e.toString());
            Assert.assertFalse(failedStatus);

        }
        writeToLogFile(data.toString());
        return data;
    }

    private String clobToString(Clob data) {
        InputStream in = null;
        try {
            in = data.getAsciiStream();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        StringWriter w = new StringWriter();
        try {
            IOUtils.copy(in, w);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String clobAsString = w.toString();

        return clobAsString;
    }

    public static void writetopdf(String consoleText,String msgId) {
        String[] feature = scenario.getId().split(":");
        //String filename = "target/cucumber-reports/"+feature[1].replace("features/", "").replace(".feature", "");
        String filename = System.getProperty("user.dir");
        if(System.getProperty("isCitrix")!=null) {
            //filename = "target/cucumber-report-html/cucumber-html-reports/"+feature[1].replace("features/", "").replace(".feature", "");
            filename = filename+"\\target\\cucumber-reports\\cucumber-html-reports\\"+feature[1].replace("features/", "").replace(".feature", "");
        }else{
            filename = filename+"/target/cucumber-reports/cucumber-html-reports/"+feature[1].replace("features/", "").replace(".feature", "");
        }
        
        logFilename = filename+"_"+msgId +"_"+timeStamp+".pdf";
        File file = new File(logFilename);
        try ( FileOutputStream fos = new FileOutputStream(file); ) {
            byte[] decoder = Base64.getDecoder().decode(consoleText);
            
            fos.write(decoder);
            fos.flush();
            fos.close();
          } catch (Exception e) {
            e.printStackTrace();
          }
        System.out.println(consoleText);
    }

    public static void convertToFile(String consoleText,String msgId, String mimeType) {
        String[] feature = scenario.getId().split(":");
        String filename = System.getProperty("user.dir");
        String[] tmp = feature[1].split("/");
        String featureFilename = tmp[tmp.length - 1];
        if(System.getProperty("isCitrix")!=null) {
            filename = filename+"\\target\\cucumber-reports\\cucumber-html-reports\\"+featureFilename.replace(".feature", "");
        }else{
            filename = filename+"/target/cucumber-reports/cucumber-html-reports/"+featureFilename.replace(".feature", "");
        }

        String extn = "";
        if(mimeType.contains("tiff")) extn = ".tiff";
        if(mimeType.contains("jpeg")) extn = ".jpeg";
        if(mimeType.contains("pdf")) extn = ".pdf";
        if(mimeType.contains("octet-stream")) extn = ".csv";

        //logFilename = filename+"_"+msgId +"_"+timeStamp+extn;
        logFilename = filename+"_"+ msgId +extn;
        File file = new File(logFilename);
        try ( FileOutputStream fos = new FileOutputStream(file); ) {
            byte[] decoder = Base64.getDecoder().decode(consoleText);

            fos.write(decoder);
            fos.flush();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        writeToLogFile("\n[File Created] " + logFilename);

    }

}
