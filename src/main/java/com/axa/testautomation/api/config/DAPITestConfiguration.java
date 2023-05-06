package com.axa.testautomation.api.config;


import com.axa.testautomation.api.as400.components.TerminalDriver;
import com.axa.testautomation.api.as400.pages.BaseScreen;
import com.axa.testautomation.api.as400.pages.CommonScreen;
import com.axa.testautomation.api.as400.pages.SignOnScreen;
import com.axa.testautomation.api.as400.pages.SystemMasterMenuScreen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;
import ph.tcoe.security.TcoeCipher;
import ph.tcoe.security.TcoeCipherFactory;
import ph.tcoe.security.TcoeCipherType;


@Configuration
@PropertySource("classpath:application.yml")
@ComponentScan(basePackages = {"com.axa.testautomation"})
public class DAPITestConfiguration {

    @Autowired
    Environment env;

    @Bean(name="restTemplate")
    public RestTemplate restTemplate() throws Exception {
        return new RestTemplate();
    }

    @Bean(name="retrieveAccountDetailsUrl")
    public String retrieveAccountDetailsUrl() throws Exception {
        return new String(env.getProperty("apis.ebxp-retrieve-account-details"));
    }

    @Bean(name="retrieveAccountDetailsValidatorUrl")
    public String retrieveAccountDetailsValidatorUrl() throws Exception {
        return new String(env.getProperty("apis.alake-retrieve-account-details"));
    }

    @Bean(name="retrievePolicyListUrl")
    public String retrievePolicyListUrl() throws Exception {
        return new String(env.getProperty("apis.ebxp-retrieve-policy-list"));
    }

    @Bean(name="retrievePolicyListValidatorUrl")
    public String retrievePolicyListrValidatorUrl() throws Exception {
        return new String(env.getProperty("apis.alake-retrieve-policy-list"));
    }

    @Bean(name="retrievePolicyInformationUrl")
    public String retrievePolicyInformationUrl() throws Exception {
        return new String(env.getProperty("apis.ebxp-retrieve-policy-information"));
    }

    @Bean(name="retrievePolicyInformationValidatorUrl")
    public String retrievePolicyInformationValidatorUrl() throws Exception {
        return new String(env.getProperty("apis.alake-retrieve-policy-information"));
    }

    @Bean(name="hkalRetrieveExchangeRate")
    public String hkalRetrieveExchangeRate() throws Exception {
        return new String(env.getProperty("hkal.retrieve-exchange-rate"));
    }
    
    @Bean(name="hkalRetrieveExchangeRateDev")
    public String hkalRetrieveExchangeRateDev() throws Exception {
        return new String(env.getProperty("hkal.retrieve-exchange-rate-dev"));
    }

    @Bean(name="hkalRetrieveExchangeRateDbConn")
    public String hkalRetrieveExchangeRateDbConn() throws Exception {
        return new String(env.getProperty("hkal.retrieve-exchange-rate-db-conn"));
    }

    @Bean(name="hkalRetrieveExchangeRateDbUser")
    public String hkalRetrieveExchangeRateDbUser() throws Exception {
        return new String(env.getProperty("hkal.retrieve-exchange-rate-db-user"));
    }

    @Bean(name="hkalRetrieveExchangeRateDbMaUser")
    public String hkalRetrieveExchangeRateDbMaUser() throws Exception {
        return new String(env.getProperty("hkal.retrieve-exchange-rate-db-ma-user"));
    }

    @Bean(name="hkalRetrieveExchangeRateDbPwd")
    public String hkalRetrieveExchangeRateDbPwd() throws Exception {
        return new String(env.getProperty("hkal.retrieve-exchange-rate-db-pwd"));
    }

    @Bean(name="regionalNitNotifyDocument")
    public String regionalNitNotifyDocument() throws Exception {
        return new String(env.getProperty("nit.regional-notify-document"));
    }
    
    @Bean(name="regionalNitRecordCustomer")
    public String regionalNitRecordCustomer() throws Exception {
        return new String(env.getProperty("nit.regional-record-customer"));
    }
    
    @Bean(name="regionalNitRecordCustomerContact")
    public String regionalNitRecordCustomerContact() throws Exception {
        return new String(env.getProperty("nit.regional-record-customer-contact"));
    }

    @Bean(name="regionalNitRecordDocument")
    public String regionalNitRecordDocument() throws Exception {
        return new String(env.getProperty("nit.regional-record-document"));
    }

    @Bean(name="regionalNitRecordReceiptIssuance")
    public String regionalNitRecordReceiptIssuance() throws Exception {
        return new String(env.getProperty("nit.regional-record-receipt-issuance"));
    }

    @Bean(name="regionalNitRetrieveClaimList")
    public String regionalNitRetrieveClaimList() throws Exception {
        return new String(env.getProperty("nit.regional-retrieve-claim-list"));
    }

    @Bean(name="regionalNitRetrieveClaimDetails")
    public String regionalNitRetrieveClaimDetails() throws Exception {
        return new String(env.getProperty("nit.regional-retrieve-claim-details"));
    }

    @Bean(name="regionalNitRetrieveAccountDetails")
    public String regionalNitRetrieveAccountDetails() throws Exception {
        return new String(env.getProperty("nit.regional-retrieve-account-details"));
    }
    @Bean(name="regionalNitRetrieveAccountDetailsLife")
    public String regionalNitRetrieveAccountDetailsLife() throws Exception {
        return new String(env.getProperty("nit.regional-retrieve-account-details-life"));
    }

    @Bean(name="regionalNitRetrievePolicyList")
    public String regionalNitRetrievePolicyList() throws Exception {
        return new String(env.getProperty("nit.regional-retrieve-policy-list"));
    }

    @Bean(name="regionalNitRetrievePolicyDetails")
    public String regionalNitRetrievePolicyDetails() throws Exception {
        return new String(env.getProperty("nit.regional-retrieve-policy-details"));
    }

    @Bean(name="regionalRetrievePolicyDetailsSIT")
    public String regionalRetrievePolicyDetailsSIT() throws Exception {
        return new String(env.getProperty("sit.regional-retrieve-policy-details"));
    }

    @Bean(name="regionalRetrievePolicyDetailsQA")
    public String regionalRetrievePolicyDetailsQA() throws Exception {
        return new String(env.getProperty("qa.regional-retrieve-policy-details"));
    }

    @Bean(name="regionalRetrievePolicyDetailsPPE3")
    public String regionalRetrievePolicyDetailsPPE3() throws Exception {
        return new String(env.getProperty("ppe3.regional-retrieve-policy-details"));
    }

    @Bean(name="regionalNitRetrieveDocumentList")
    public String regionalNitRetrieveDocumentList() throws Exception {
        return new String(env.getProperty("nit.regional-retrieve-document-list"));
    }
    
    @Bean(name="regionalNitRetrieveDocumentDetails")
    public String regionalNitRetrieveDocumentDetails() throws Exception {
        return new String(env.getProperty("nit.regional-retrieve-document-details"));
    }
    
    @Bean(name="regionalNitRetrieveAgentDetails")
    public String regionalNitRetrieveAgentDetails() throws Exception {
        return new String(env.getProperty("nit.regional-retrieve-agent-details"));
    }

    @Bean(name="regionalNitRetrieveCustomerList")
    public String regionalNitRetrieveCustomerList() throws Exception {
        return new String(env.getProperty("nit.regional-retrieve-customer-list"));
    }

    @Bean(name="regionalNitRetrieveFundList")
    public String regionalNitRetrieveFundList() throws Exception {
        return new String(env.getProperty("nit.regional-retrieve-fund-list"));
    }
    
    @Bean(name="wfiSGRetrieveDocumentList")
    public String wfiSGRetrieveDocumentList() throws Exception {
        return new String(env.getProperty("filenet.sg-retrieve-document-list"));
    }
    
    @Bean(name="wfiMYRetrieveDocumentList")
    public String wfiMYRetrieveDocumentList() throws Exception {
        return new String(env.getProperty("filenet.my-retrieve-document-list"));
    }
    
    @Bean(name="wfiTHRetrieveDocumentList")
    public String wfiTHRetrieveDocumentList() throws Exception {
        return new String(env.getProperty("filenet.th-retrieve-document-list"));
    }
    
    @Bean(name="wfiPHRetrieveDocumentList")
    public String wfiPHRetrieveDocumentList() throws Exception {
        return new String(env.getProperty("filenet.ph-retrieve-document-list"));
    }
    
    @Bean(name="wfiHKRetrieveDocumentList")
    public String wfiHKRetrieveDocumentList() throws Exception {
        return new String(env.getProperty("filenet.hk-retrieve-document-list"));
    }
    

    @Bean(name="sg_MDCAC7QI")
    public String sg_MDCAC7QI() throws Exception {
        return new String(env.getProperty("db.sg-mdcac7qi"));
    }

    @Bean(name="l_SG_CACHE")
    public String l_SG_CACHE() throws Exception {
        return new String(env.getProperty("db.sg-l-sg-cache"));
    }

    @Bean(name="g_SG_CACHE")
    public String g_SG_CACHE() throws Exception {
        return new String(env.getProperty("db.sg-g-sg-cache"));
    }
    
    @Bean(name="gA_SG_CACHE")
    public String gA_SG_CACHE() throws Exception {
        return new String(env.getProperty("db.sg-ga-sg-cache"));
    }

    @Bean(name="th_MDCAC2QI")
    public String th_MDCAC2QI() throws Exception {
        return new String(env.getProperty("db.th-mdcac2qi"));
    }

    @Bean(name="th_MDCAC6QI")
    public String th_MDCAC6QI() throws Exception {
        return new String(env.getProperty("db.th-mdcac6qi"));
    }

    @Bean(name="th_MDCAC7QI")
    public String th_MDCAC7QI() throws Exception {
        return new String(env.getProperty("db.th-mdcac7qi"));
    }

    @Bean(name="l_TH_CACHE")
    public String l_TH_CACHE() throws Exception {
        return new String(env.getProperty("db.th-l-th-cache"));
    }

    @Bean(name="g_TH_CUST")
    public String g_TH_CUST() throws Exception {
        return new String(env.getProperty("db.th-g-th-cust"));
    }

    @Bean(name="hk_MDCAC2QI")
    public String hk_MDCAC2QI() throws Exception {
        return new String(env.getProperty("db.hk-mdcac2qi"));
    }

    @Bean(name="hk_MDCRPP2I")
    public String hk_MDCRPP2I() throws Exception {
        return new String(env.getProperty("db.hk-mdcrpp2i"));
    }

    @Bean(name="hk_MDCRPP2I_204")
    public String hk_MDCRPP2I_204() throws Exception {
        return new String(env.getProperty("db.hk-mdcrpp2i-204"));
    }

    @Bean(name="l_HK_CACHE")
    public String l_HK_CACHE() throws Exception {
        return new String(env.getProperty("db.hk-l-hk-cache"));
    }

    @Bean(name="ph_MDCAC2QI")
    public String ph_MDCAC2QI() throws Exception {
        return new String(env.getProperty("db.ph-mdcac2qi"));
    }

    @Bean(name="ph_MDCRPP2I")
    public String ph_MDCRPP2I() throws Exception {
        return new String(env.getProperty("db.ph-mdcrpp2i"));
    }

    @Bean(name="l_PH_CACHE")
    public String l_PH_CACHE() throws Exception {
        return new String(env.getProperty("db.ph-l-ph-cache"));
    }

    @Bean(name="cachePassword")
    public String cachePassword() throws Exception {
        TcoeCipher<String, String> cipher = TcoeCipherFactory.getCipher(TcoeCipherType.CONSOLE);
        return new String(cipher.decrypt(env.getProperty("db.cache-password")));
    }

    @Bean(name="sg_MDCOR7QI")
    public String sg_MDCOR7QI() throws Exception {
        return new String(env.getProperty("db.sg-mdcor7qi"));
    }

    @Bean(name="g_SG_CUST")
    public String g_SG_CUST() throws Exception {
        return new String(env.getProperty("db.sg-g-sg-cust"));
    }

    @Bean(name="hk_MDCOR2QI")
    public String hk_MDCOR2QI() throws Exception {
        return new String(env.getProperty("db.hk-mdcor2qi"));
    }

    @Bean(name="hk_MDCOR7QI")
    public String hk_MDCOR7QI() throws Exception {
        return new String(env.getProperty("db.hk-mdcor7qi"));
    }

    @Bean(name="g_HK_CUST")
    public String g_HK_CUST() throws Exception {
        return new String(env.getProperty("db.hk-g-hk-cust"));
    }

    @Bean(name="ph_MDCOR7QI")
    public String ph_MDCOR7QI() throws Exception {
        return new String(env.getProperty("db.ph-mdcor7qi"));
    }

    @Bean(name="ph_MDCOR8QI")
    public String ph_MDCOR8QI() throws Exception {
        return new String(env.getProperty("db.ph-mdcor8qi"));
    }

    @Bean(name="g_PH_CUST")
    public String g_PH_CUST() throws Exception {
        return new String(env.getProperty("db.ph-g-ph-cust"));
    }

    @Bean(name="l_PH_CUST")
    public String l_PH_CUST() throws Exception {
        return new String(env.getProperty("db.ph-l-ph-cust"));
    }

    @Bean(name="th_MDCOR6QI")
    public String th_MDCOR6QI() throws Exception {
        return new String(env.getProperty("db.th-mdcor6qi"));
    }

    @Bean(name="th_MDCOR3QI")
    public String th_MDCOR3QI() throws Exception {
        return new String(env.getProperty("db.th-mdcor3qi"));
    }

    @Bean(name="l_TH_CUST")
    public String l_TH_CUST() throws Exception {
        return new String(env.getProperty("db.th-l-th-cust"));
    }

    @Bean(name="my_MDCOR7QI")
    public String my_MDCOR7QI() throws Exception {
        return new String(env.getProperty("db.my-mdcor7qi"));
    }

    @Bean(name="g_MY_CUST")
    public String g_MY_CUST() throws Exception {
        return new String(env.getProperty("db.my-g-my-cust"));
    }

    @Bean(name="corePassword")
    public String corePassword() throws Exception {
        TcoeCipher<String, String> cipher = TcoeCipherFactory.getCipher(TcoeCipherType.CONSOLE);
        return new String(cipher.decrypt(env.getProperty("db.core-password")));
    }

    @Bean(name="server_46")
    public String server_46() throws Exception {
        return new String(env.getProperty("db.server-name.server_46"));
    }

    @Bean(name="server_47")
    public String server_47() throws Exception {
        return new String(env.getProperty("db.server-name.server_47"));
    }

    @Bean(name="server_120")
    public String server_120() throws Exception {
        return new String(env.getProperty("db.server-name.server_120"));
    }

    @Bean(name="server_195")
    public String server_195() throws Exception {
        return new String(env.getProperty("db.server-name.server_195"));
    }

    @Bean(name="server_204")
    public String server_204() throws Exception {
        return new String(env.getProperty("db.server-name.server_204"));
    }

    @Bean(name="MDCAC2QI")
    public String MDCAC2QI() throws Exception {
        return new String(env.getProperty("db.database-name.MDCAC2QI"));
    }
    @Bean(name="MDCAC6QI")
    public String MDCAC6QI() throws Exception {
        return new String(env.getProperty("db.database-name.MDCAC6QI"));
    }
    @Bean(name="MDCAC7QI")
    public String MDCAC7QI() throws Exception {
        return new String(env.getProperty("db.database-name.MDCAC7QI"));
    }
    @Bean(name="MDCOR2QI")
    public String MDCOR2QI() throws Exception {
        return new String(env.getProperty("db.database-name.MDCOR2QI"));
    }
    @Bean(name="MDCOR6QI")
    public String MDCOR6QI() throws Exception {
        return new String(env.getProperty("db.database-name.MDCOR6QI"));
    }
    @Bean(name="MDCOR7QI")
    public String MDCOR7QI() throws Exception {
        return new String(env.getProperty("db.database-name.MDCOR7QI"));
    }
    @Bean(name="MDCOR8QI")
    public String MDCOR8QI() throws Exception {
        return new String(env.getProperty("db.database-name.MDCOR8QI"));
    }
    @Bean(name="MDCRPP2I")
    public String MDCRPP2I() throws Exception {
        return new String(env.getProperty("db.database-name.MDCRPP2I"));
    }

    @Bean(name="G_HK_CUST")
    public String G_HK_CUST() throws Exception {
        return new String(env.getProperty("db.user.G_HK_CUST"));
    }
    @Bean(name="G_MY_CUST")
    public String G_MY_CUST() throws Exception {
        return new String(env.getProperty("db.user.G_MY_CUST"));
    }
    @Bean(name="G_PH_CUST")
    public String G_PH_CUST() throws Exception {
        return new String(env.getProperty("db.user.G_PH_CUST"));
    }
    @Bean(name="G_SG_CACHE")
    public String G_SG_CACHE() throws Exception {
        return new String(env.getProperty("db.user.G_SG_CACHE"));
    }
    @Bean(name="G_SG_CUST")
    public String G_SG_CUST() throws Exception {
        return new String(env.getProperty("db.user.G_SG_CUST"));
    }
    @Bean(name="G_TH_CUST")
    public String G_TH_CUST() throws Exception {
        return new String(env.getProperty("db.user.G_TH_CUST"));
    }
    @Bean(name="GA_SG_CACHE")
    public String GA_SG_CACHE() throws Exception {
        return new String(env.getProperty("db.user.GA_SG_CACHE"));
    }
    @Bean(name="L_HK_CACHE")
    public String L_HK_CACHE() throws Exception {
        return new String(env.getProperty("db.user.L_HK_CACHE"));
    }
    @Bean(name="L_PH_CACHE")
    public String L_PH_CACHE() throws Exception {
        return new String(env.getProperty("db.user.L_PH_CACHE"));
    }
    @Bean(name="L_PH_CUST")
    public String L_PH_CUST() throws Exception {
        return new String(env.getProperty("db.user.L_PH_CUST"));
    }
    @Bean(name="L_SG_CACHE")
    public String L_SG_CACHE() throws Exception {
        return new String(env.getProperty("db.user.L_SG_CACHE"));
    }
    @Bean(name="L_TH_CACHE")
    public String L_TH_CACHE() throws Exception {
        return new String(env.getProperty("db.user.L_TH_CACHE"));
    }
    @Bean(name="L_TH_CUST")
    public String L_TH_CUST() throws Exception {
        return new String(env.getProperty("db.user.L_TH_CUST"));
    }

    /* PSEA */
    @Bean
    public TerminalDriver PSEA_TerminalDriver() throws Exception {
        String host = env.getProperty("psea-server.host");
        String port = env.getProperty("psea-server.port");
        return new TerminalDriver(host, port);
    }

    @Bean
    public String PSEA_SG_Username() {
        return env.getProperty("psea-server.sg.username");
    }

    @Bean
    public String PSEA_SG_Password() {
        return env.getProperty("psea-server.sg.password");
    }

    @Bean
    public String PSEA_MY_Username() {
        return env.getProperty("psea-server.my.username");
    }

    @Bean
    public String PSEA_MY_Password() {
        return env.getProperty("psea-server.my.password");
    }

}
