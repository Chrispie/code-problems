package com.chrispie;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.PropertySource;

@TestConfiguration
@PropertySource("classpath:application-api.properties")
public class TestConfig {

    @Value("${my.property}")
    private String property;

    public TestConfig() {
        System.out.println("TestConfig");
    }
    
    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }
}
