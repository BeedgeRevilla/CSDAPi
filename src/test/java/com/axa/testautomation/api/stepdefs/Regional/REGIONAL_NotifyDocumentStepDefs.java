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
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.net.ssl.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.codec.binary.Base64;
import org.assertj.core.util.Lists;

import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


public class REGIONAL_NotifyDocumentStepDefs extends BaseStepDefs {

    @Autowired
    private String regionalNitNotifyDocument;

    private String ns1XMLData = null;
    private String countryCD;
    private String entityCD;
    private String lobCD;
    private String targetSystem;

    @Given("the following parameters on the payload that are set Notify Document")
    public void set_http_headers(DataTable dt) {
        failedStatus = false;
        //httpHeaders.clear();
        writeToLogFile("====== PARAMETERS ======");
        for(Map<String, String> row : dt.asMaps()) {
            for(Map.Entry<String, String> headerMap : row.entrySet()) {
                //httpHeaders.set(headerMap.getKey(), headerMap.getValue());
                writeToLogFile(headerMap.getKey() + ": " + headerMap.getValue());
                switch (headerMap.getKey()){
	                case "countryCD": countryCD = headerMap.getValue(); break;
	                case "entityCD": entityCD = headerMap.getValue(); break;
	                case "lobCD": lobCD = headerMap.getValue(); break;
	                case "targetSystem":
	                    if(headerMap.getValue().equalsIgnoreCase("DLFE")){
	                        targetSystem = "iConnect";
                        }else {
                            targetSystem = headerMap.getValue();
                        } break;
                }
            }
        }
        writeToLogFile("=====================");
    }


    

    @When("the api call has been made for Notify Document")
    public void send_api_request() {

        try {
            
            HttpsURLConnection con = null;
            URL obj = new URL(regionalNitNotifyDocument);

            SSLContext sslContext = SSLContext.getInstance("SSL");
            TrustManager[] trustAll = new TrustManager[] {new TrustAllCertificates()};
            sslContext.init(null, trustAll, new java.security.SecureRandom());
            // Set trust all certificates context to HttpsURLConnection
            HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());

            con = (HttpsURLConnection) obj.openConnection();
            con.setHostnameVerifier(new TrustAllHosts());

            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type","application/soap+xml; charset=UTF-8");
            con.setRequestProperty("SOAPAction", "AXAAsia_BusinessAPI_Common_ws_provider_documentServices_Binder_notifyDocument");
            
            String filename = "src/payload/Regional/notifyDocument/notifyDocument_template.txt";

            String text = new String(Files.readAllBytes(Paths.get(filename)));
            String xml = text.replace("%countryCD%", countryCD)
            		.replace("%entityCD%", entityCD)
            		.replace("%lobCD%", lobCD)
            		.replace("%targetSystem%", targetSystem)
            		.replace("%timeStamp%", new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()))
            		;

            writeToLogFile("========== API Request =========");
            writeToLogFile("URL: " + regionalNitNotifyDocument);
            writeToLogFile("Payload: \n" + xml);
            writeToLogFile("=============================================================================\n");
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(xml);
            wr.flush();
            wr.close();

            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer strResponse = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
            	strResponse.append(inputLine);
            }
            in.close();
            String xmlResponse = strResponse.toString();
            writeToLogFile("[API Response]");
            writeToLogFile(xmlResponse);
            writeToLogFile("[Validations]");
            if(xmlResponse.contains("<transactionResponseFlag>Success</transactionResponseFlag>")){
            	writeToLogFile("transactionResponseFlag: Success");
            }else{
            	writeToLogFile("transactionResponseFlag: [null] - [FAILED]");
            	failedStatus = true;
            }
            
            writeToLogFile("=============================================================================\n");
            Assert.assertFalse(failedStatus);

        }catch(Exception e){
            failedStatus = true;
            scenario.write(e.toString());
            writeToLogFile(e.toString());
            Assert.assertFalse(failedStatus);

        }
        

    }
    
    private static class TrustAllHosts implements HostnameVerifier {
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }
    
    private static class TrustAllCertificates implements X509TrustManager {
        public void checkClientTrusted(X509Certificate[] certs, String authType) {
        }
     
        public void checkServerTrusted(X509Certificate[] certs, String authType) {
        }
     
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }

}
