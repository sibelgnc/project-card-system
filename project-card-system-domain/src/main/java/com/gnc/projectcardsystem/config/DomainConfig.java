package com.gnc.projectcardsystem.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.gnc.projectcardsystem.domain")
public class DomainConfig {

    String field1 = "489789";

    public String getField1(){
        return field1;
    }
}
