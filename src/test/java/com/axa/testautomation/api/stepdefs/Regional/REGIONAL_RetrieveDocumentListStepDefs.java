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
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.ssl.SSLContextBuilder;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
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


import org.apache.commons.codec.binary.Base64;
import org.assertj.core.util.Lists;

import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Map;


public class REGIONAL_RetrieveDocumentListStepDefs extends BaseStepDefs {

    @Autowired
    private String regionalNitRetrieveDocumentList;
    
    @Autowired
    private String wfiSGRetrieveDocumentList;
    @Autowired
    private String wfiMYRetrieveDocumentList;
    @Autowired
    private String wfiTHRetrieveDocumentList;
    @Autowired
    private String wfiPHRetrieveDocumentList;
    @Autowired
    private String wfiHKRetrieveDocumentList;

    private String ns1XMLData = null;
    private String lob;
    private String entity;
    private String policyNumber;
    private String claimNumber;
    private String documentClass;

    @Given("the following http headers are set Retrieve Document List")
    public void set_http_headers(DataTable dt) {
        failedStatus = false;
        httpHeaders.clear();
        writeToLogFile("====== HEADERS ======");
        for(Map<String, String> row : dt.asMaps()) {
            for(Map.Entry<String, String> headerMap : row.entrySet()) {
                httpHeaders.set(headerMap.getKey(), headerMap.getValue());
                writeToLogFile(headerMap.getKey() + ": " + headerMap.getValue());
                switch (headerMap.getKey().toLowerCase()){
	                case "x-axa-entity": entity = headerMap.getValue(); break;
	                case "x-axa-lob": lob = headerMap.getValue(); break;
                }
            }
        }
        writeToLogFile("=====================");
    }


    @And("the following GET input parameters are set for Retrieve Document List")
    public void set_get_parameters(DataTable dt) {
        failedStatus = false;
        getParameters = "/?";
        for(Map<String, String> row : dt.asMaps()) {
            for(Map.Entry<String, String> getParametersMap : row.entrySet()) {
            	if(!getParametersMap.getValue().equalsIgnoreCase("")){
            		getParameters = getParameters + getParametersMap.getKey() + "=" + getParametersMap.getValue() + "&";
            	}
                switch (getParametersMap.getKey()){
                    case "policyNumber": policyNumber = getParametersMap.getValue(); break;
                    case "claimNumber": claimNumber = getParametersMap.getValue(); break;
                    case "documentClass": documentClass = getParametersMap.getValue(); break;
                }
            }
        }
        getParameters = getParameters.substring(0, getParameters.length()-1);
        writeToLogFile("PARAMETER: " + getParameters);
    }

    @When("the api call has been made for Retrieve Document List")
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
            String url = regionalNitRetrieveDocumentList + getParameters;
            writeToLogFile("ENDPOINT: " + regionalNitRetrieveDocumentList);
            System.setProperty("file.encoding", "UTF-8");
            /*
            writeToLogFile("FILE ENCODING: " + System.getProperty("file.encoding"));
            httpHeaders.add("Content-Type", "application/json; charset=utf8");
            */
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

    @When("the call to FILENET has been made for Retrieve Document List")
    public void send_get_request_to_filenet() {
//        if(response == null){
//            failedStatus = true;
//            scenario.write("[API Response]");
//            scenario.write(actualHttpErrorBody);
//            Assert.assertFalse(failedStatus);
//        }

//        if(response.getBody().contains("exception")){
//            failedStatus = true;
//            scenario.write("[API Response]");
//            scenario.write(response.getBody());
//            Assert.assertFalse(failedStatus);
//        }

        String url = null;
        try {
            
            switch (entity.toLowerCase()){
            	case "sg": url = wfiSGRetrieveDocumentList; break;
            	case "my": url = wfiMYRetrieveDocumentList; break;
            	case "th": url = wfiTHRetrieveDocumentList; break;
            	case "ph": url = wfiPHRetrieveDocumentList; break;
            	case "hk": url = wfiHKRetrieveDocumentList; break;
            }

            HttpURLConnection con = null;
            URL obj = new URL(url);
            if(System.getProperty("isCitrix")!=null) {
                con = (HttpURLConnection) obj.openConnection();
            }else{
                Socket socket = new Socket();
                SocketAddress sockaddr = new InetSocketAddress("10.40.249.26", 8080);
                socket.connect(sockaddr, 5000);
                Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(socket.getInetAddress(), 8080));
                con = (HttpURLConnection) obj.openConnection(proxy);
            }

            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type","text/xml; charset=UTF-8");
            con.setRequestProperty("SOAPAction", "");

            String xmlBodyData = "<RequestRetrieveDocumentList>";
            
            if (!policyNumber.equalsIgnoreCase("")){
            	xmlBodyData = xmlBodyData+"<POLICYNUMBER>"+policyNumber+"</POLICYNUMBER>";
            }
            
            if (!claimNumber.equalsIgnoreCase("")){
            	xmlBodyData = xmlBodyData+"<CLAIMNUMBER>"+claimNumber+"</CLAIMNUMBER>";
            }
            
            xmlBodyData = xmlBodyData+"<SYSTEM>"+lob.toUpperCase()+"</SYSTEM>"
            		+"<DOCUMENTCLASS>"+documentClass+"</DOCUMENTCLASS>"
            		+"<COUNTRY>"+entity+"</COUNTRY>"
            		+"<ENTITY>"+entity+"</ENTITY>"
            		+"</RequestRetrieveDocumentList>";
         
            byte[] bytesEncoded = Base64.encodeBase64(xmlBodyData.getBytes());
            String xmlData = new String(bytesEncoded);
            String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"http://services.ecm.scrm.axa.com\" xmlns:bean=\"http://bean.ecm.scrm.axa.com\">"
                    +"   <soapenv:Header>"
                    +"      <ser:retrieveDocumentListHeader>"
                    +"         <ser:userInformation>"
                    +"            <bean:userGroupList>?</bean:userGroupList>"
                    +"            <bean:userID>?</bean:userID>"
                    +"            <bean:userName>?</bean:userName>"
                    +"            <bean:userToken>?</bean:userToken>"
                    +"            <bean:transactionID>?</bean:transactionID>"
                    +"         </ser:userInformation>"
                    +"     </ser:retrieveDocumentListHeader>"
                    +"   </soapenv:Header>"
                    +"   <soapenv:Body>"
                    +"      <ser:retrieveDocumentListBody>"
                    +"         <ser:searchParam>"
                    +"            <bean:XMLData>"+xmlData+"</bean:XMLData>"
                    +"            <bean:name>?</bean:name>"
                    +"            <bean:nameURI>?</bean:nameURI>"
                    +"         </ser:searchParam>"
                    +"      </ser:retrieveDocumentListBody>"
                    +"   </soapenv:Body>"
                    +"</soapenv:Envelope>";

            writeToLogFile("====== FileNet WebService ======");
            writeToLogFile("WSDL: " + url);
            writeToLogFile("XML Data: " + xmlBodyData);
            writeToLogFile("XML Body: " + xml);
            writeToLogFile("================================");
/*
            HttpHost proxy = new HttpHost("10.40.249.26", 8080);
            DefaultProxyRoutePlanner routePlanner = new DefaultProxyRoutePlanner(proxy);

            //SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, (certificate, authType) -> true).build();

            HttpClient httpclient = HttpClients
                    .custom()
                    .setRoutePlanner(routePlanner)
                    //.setSSLContext(sslContext)
                    //.setSSLHostnameVerifier(new NoopHostnameVerifier())
                    .build();

            if(System.getProperty("isCitrix")!=null) {
                httpclient = HttpClients
                        .custom()
                        //.setSSLContext(sslContext)
                      //  .setSSLHostnameVerifier(new NoopHostnameVerifier())
                        .build();
            }

            HttpComponentsClientHttpRequestFactory requestFactory =
                    new HttpComponentsClientHttpRequestFactory();
            requestFactory.setHttpClient(httpclient);

            if(System.getProperty("isCitrix")!=null) {
                restTemplate = new RestTemplate();
            }else{
                restTemplate = new RestTemplate(requestFactory);
            }
            //String url = regionalNitRetrieveDocumentList + getParameters;
            //writeToLogFile("ENDPOINT: " + regionalNitRetrieveDocumentList);
            System.setProperty("file.encoding", "UTF-8");

            httpHeaders.add("Content-Type","text/xml; charset=UTF-8");
            httpHeaders.add("SOAPAction", "");
            httpHeaders.setContentType(MediaType.APPLICATION_XML);
            HttpEntity<String> entity = new HttpEntity<>(xml, httpHeaders);
            response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
*/

            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(xml);
            wr.flush();
            wr.close();

            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            String xmlResponse = response.toString();
            writeToLogFile("[FILENET Response]");
            writeToLogFile(xmlResponse);
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
            DocumentBuilder builder;
            builder = factory.newDocumentBuilder();  
            Document document = builder.parse(new InputSource(new StringReader(xmlResponse)));  
            
            //Normalize the XML Structure; It's just too important !!
            document.getDocumentElement().normalize();
            
            NodeList nList = document.getElementsByTagName("ns1:XMLExtension");
             
            for (int temp = 0; temp < nList.getLength(); temp++) {
	             Node node = nList.item(temp);
	             if (node.getNodeType() == Node.ELEMENT_NODE) {
	                
	                Element eElement = (Element) node;
	                ns1XMLData = eElement.getElementsByTagName("ns1:XMLData").item(0).getTextContent();
	                break;
	             }
            }
                        
            byte[] valueDecoded = Base64.decodeBase64(ns1XMLData.getBytes());
            ns1XMLData = new String(valueDecoded, "UTF-8");
            writeToLogFile("[ns1:XMLData]: " + ns1XMLData);
            
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Then("verify that API and FILENET responses matched for Retrieve Document List")
    public void api_match_filenet() {
        if(response == null){
            failedStatus = true;
            scenario.write("[API Response]");
            scenario.write(actualHttpErrorBody);
            Assert.assertFalse(failedStatus);

            if(ns1XMLData.length()!=0){
                scenario.write("[ns1:XMLData]: " + ns1XMLData);
            }
        }

        if(response.getBody().contains("exception")){
            failedStatus = true;
            scenario.write("[API Response]");
            scenario.write(response.getBody());
            Assert.assertFalse(failedStatus);
            if(ns1XMLData.length()!=0){
                scenario.write("[ns1:XMLData]: " + ns1XMLData);
            }
        }

        JsonObject api = new JsonParser().parse(response.getBody()).getAsJsonObject();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
        DocumentBuilder builder;
         
        try {  
        	builder = factory.newDocumentBuilder();  
        	Document document = builder.parse(new InputSource(new StringReader(ns1XMLData)));
            //Document document = builder.parse(new InputSource(new ByteArrayInputStream(ns1XMLData.getBytes("UTF-8"))));  
            
            //Normalize the XML Structure; It's just too important !!
            document.getDocumentElement().normalize();

            NodeList nList = document.getElementsByTagName("Document");
            
        	writeToLogFile("[Validations]");
            for(int i=0; i<api.get("RetrieveDocumentListResponse").getAsJsonObject().get("documentElement").getAsJsonArray().size(); i++){
            	Node node = nList.item(i);
            	JsonElement a = api.get("RetrieveDocumentListResponse").getAsJsonObject().get("documentElement").getAsJsonArray().get(i);
            	writeToLogFile("=============================================================================");
                writeToLogFile("RetrieveDocumentListResponse().documentElement["+i+"]");
                writeToLogFile("=============================================================================");
                if (node.getNodeType() == Node.ELEMENT_NODE) {
           
                   Element b = (Element) node;
                   compareDbToApi_String("claimNumber", b.getElementsByTagName("CLAIMNUMBER").item(0), a.getAsJsonObject().get("claimNumber"));
                   compareDbToApi_String("MIMEType", b.getElementsByTagName("MIMETYPE").item(0), a.getAsJsonObject().get("MIMEType"));
                   compareDbToApi_String("documentTitle", b.getElementsByTagName("DOCUMENTTITLE").item(0), a.getAsJsonObject().get("documentTitle"));
                   
                   compareDbToApi_String("documentId", b.getElementsByTagName("ID").item(0), a.getAsJsonObject().get("documentId"));
                   compareDbToApi_String("documentType", b.getElementsByTagName("DOCUMENTTYPE").item(0), a.getAsJsonObject().get("documentType"));
                   compareDbToApi_String("createdBy", b.getElementsByTagName("CREATEDBY").item(0), a.getAsJsonObject().get("createdBy"));
                   compareDbToApi_String("lineOfBusiness", b.getElementsByTagName("LINEOFBUSINESS").item(0), a.getAsJsonObject().get("lineOfBusiness"));
                   compareDbToApi_String("policyNumber", b.getElementsByTagName("POLICYNUMBER").item(0), a.getAsJsonObject().get("policyNumber"));
                   compareDbToApi_String("processType", b.getElementsByTagName("PROCESSTYPE").item(0), a.getAsJsonObject().get("processType"));
                   compareDbToApi_String("updatedDate", b.getElementsByTagName("UPDATEDDATE").item(0), a.getAsJsonObject().get("updatedDate"));
                   compareDbToApi_String("updatedBy", b.getElementsByTagName("UPDATEDBY").item(0), a.getAsJsonObject().get("updatedBy"));
                   compareDbToApi_String("fileSize", b.getElementsByTagName("FILESIZE").item(0), a.getAsJsonObject().get("fileSize"));
                   compareDbToApi_String("documentClass", b.getElementsByTagName("DOCUMENTCLASS").item(0), a.getAsJsonObject().get("documentClass"));
                   compareDbToApi_String("caseReferenceNumber", b.getElementsByTagName("CASEREFERENCENUMBER").item(0), a.getAsJsonObject().get("caseReferenceNumber"));

                   //TODO work-around as per implemented and advised by SNM team
                   if(entity.equalsIgnoreCase("ph") || entity.equalsIgnoreCase("hk") || entity.equalsIgnoreCase("th")){
                	   compareDbToApi_Timestamp_DatePart_fromDDMMYYYY_toYYYYMMDD("dateCreated", b.getElementsByTagName("DATECREATED").item(0).getTextContent(), a.getAsJsonObject().get("dateCreated"));
                   }else{
                	   if(documentClass.equalsIgnoreCase("NewBusiness") || documentClass.equalsIgnoreCase("Policy")){
                		   compareDbToApi_Timestamp_DatePart_fromDDMMYYYY_toYYYYMMDD("dateCreated", b.getElementsByTagName("DATECREATED").item(0).getTextContent(), a.getAsJsonObject().get("dateCreated"));
                	   }else{
                		   compareDbToApi_String("dateCreated", b.getElementsByTagName("DATECREATED").item(0).getTextContent(), a.getAsJsonObject().get("dateCreated"));
                	   }
                   }
                   compareDbToApi_String("workType", b.getElementsByTagName("WORKTYPE").item(0), a.getAsJsonObject().get("workType"));
                   compareDbToApi_String("primaryDocumentFlag", b.getElementsByTagName("PRIMARYDOC").item(0), a.getAsJsonObject().get("primaryDocumentFlag"));
                   compareDbToApi_String("productType", b.getElementsByTagName("PRODUCTTYPE").item(0), a.getAsJsonObject().get("productType"));
                   compareDbToApi_String("channelCode", b.getElementsByTagName("CHANNEL").item(0), a.getAsJsonObject().get("channelCode"));
                }
            }
            
             
        } catch (Exception e){ e.printStackTrace(); Assert.assertFalse(true);}

        writeToLogFile("=============================================================================\n");
        Assert.assertFalse(failedStatus);
    }

}
