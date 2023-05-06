package com.axa.testautomation.api.stepdefs;


import com.axa.testautomation.api.config.DAPITestConfiguration;

import cucumber.api.java.Before;

import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;


@ContextConfiguration(initializers = ConfigFileApplicationContextInitializer.class,
        classes = DAPITestConfiguration.class)
public class SpringContextLoader {



    @Before("init")
    public void loadSpringContext() {
    }

}
