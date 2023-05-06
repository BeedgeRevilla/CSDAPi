package com.axa.testautomation.api.tests;

import com.axa.testautomation.api.stepdefs.BaseStepDefs;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.SystemUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
//                "classpath:features/Regional",
//                "classpath:features/Regional/REGIONAL_NotifyDocument.feature",
//                "classpath:features/Regional/REGIONAL_RecordCustomer.feature",
//                "classpath:features/Regional/REGIONAL_RecordCustomerContact.feature",    //needs updating for RLS DBMoto
//                "classpath:features/Regional/REGIONAL_RecordDocument.feature",
//                "classpath:features/Regional/REGIONAL_RecordReceiptIssuance.feature",
//                "classpath:features/Regional/REGIONAL_RetrieveAccountDetails.feature",
//                "classpath:features/Regional/REGIONAL_RetrieveAgentDetails.feature",
//                "classpath:features/Regional/REGIONAL_RetrieveClaimDetails.feature",
//                "classpath:features/Regional/REGIONAL_RetrieveClaimList.feature",
//                "classpath:features/Regional/REGIONAL_RetrieveCustomerList.feature",
//                "classpath:features/Regional/REGIONAL_RetrieveCustomerList_Joshua.feature",
//                "classpath:features/Regional/REGIONAL_RetrieveDocumentDetails.feature",
//                "classpath:features/Regional/REGIONAL_RetrieveDocumentList.feature",
//                "classpath:features/Regional/REGIONAL_RetrieveFundList.feature",
//                "classpath:features/Regional/REGIONAL_RetrievePolicyDetails_Health.feature",
//                "classpath:features/Regional/REGIONAL_RetrievePolicyDetails_Life.feature",
//                "classpath:features/Regional/REGIONAL_RetrievePolicyDetails_Life_Joshua.feature",
                "classpath:features/Regional/REGIONAL_RetrievePolicyDetails_Life_Joshua_DASI.feature",
//                "classpath:features/Regional/REGIONAL_RetrievePolicyList.feature",
        },
        tags = {"@0,"
                + "@HK,"
                + "@MY,"
                + "@PH,"
                + "@SG,"
                + "@TH,"
//                + "@TH_SIT,"
//                + "@HK_QA6,"
//                + "@HK_PPE3,"
//                + "@MY_PPE3,"
//                + "@PH_PPE3,"
//                + "@SG_PPE3,"
//                + "@TH_PPE3,"
//                + "@HK_QA6_PPE3,"
        },
        glue = {"com.axa.testautomation.api.stepdefs"},
        //plugin = {"pretty", "html:target/cucumber-reports", "json:target/cucumber.json"}
        plugin = {"pretty", "json:target/cucumber.json", "de.monochromata.cucumber.report.PrettyReports:target/cucumber-reports"},
        strict = true
//        ,dryRun = true
)

public class DASI_NIT_TestRunner {

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    public static String source;

    @BeforeClass
    public static void timeStamp() {
        BaseStepDefs.timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new java.util.Date());

        if (System.getProperty("isCitrix") != null) {
            source = System.getProperty("user.dir") + "\\target\\cucumber-reports\\cucumber-html-reports";
            File srcDir = new File(System.getProperty("user.dir") + "\\target\\cucumber-reports");
            if (!srcDir.exists()) {
                srcDir.mkdir();
            }
        } else {
            source = System.getProperty("user.dir") + "/target/cucumber-reports/cucumber-html-reports";
            File srcDir = new File(System.getProperty("user.dir") + "/target/cucumber-reports");
            if (!srcDir.exists()) {
                srcDir.mkdir();
            }
        }
        File srcDir = new File(source);
        if (!srcDir.exists()) {
            srcDir.mkdir();
        }
        File fList[] = srcDir.listFiles();
        try {
            for (File f : fList) {
                f.delete();
            }
        } catch (Exception e) {
        }

    }

    @AfterClass
    public static void generateReport() {

        Runtime r = Runtime.getRuntime();
        r.addShutdownHook(new Thread() {
            public void run() {
                File srcDir = new File(source);
                String destination = "";
                if (System.getProperty("isCitrix") != null) {
                    destination = System.getProperty("user.dir") + "\\target\\api-test-reports\\" + BaseStepDefs.timeStamp;
                } else {
                    destination = System.getProperty("user.dir") + "/target/api-test-reports/" + BaseStepDefs.timeStamp;
                }
                File destDir = new File(destination);
                try {
                    FileUtils.copyDirectory(srcDir, destDir, true);
                } catch (IOException e) {
                }

            }
        });
    }
}
