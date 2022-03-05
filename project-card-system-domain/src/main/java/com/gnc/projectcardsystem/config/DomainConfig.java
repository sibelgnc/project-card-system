package com.gnc.projectcardsystem.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.gnc.projectcardsystem.domain")
public class DomainConfig {

    //Deneme amaçlı yazıldı
    String field1 = "1234560";

    public String getField1(){
        return field1;
    }
}
