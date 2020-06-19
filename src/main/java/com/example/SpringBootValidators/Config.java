/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.SpringBootValidators;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 *
 * @author glamb
 */
@Configuration
public class Config {

    //MessageSource interface
    @Bean
    /*
    auto p tha kn return h methodos thelw na xrisimopoihthei sa springbean.
    Auto t object (messageSource) tha t parei stn controller k tha t
    to onoma ts methodou prepei na einai opws k to object p epistrefei, opws k ths class t onject autou
     */
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:message");
        //to default classpath einai to Other Sources/src/main/resources/<default package>
        //diavazei to message.properties
        messageSource.setCacheSeconds(10); //reload messages every 10 seconds
        //ksanadiavazei kathe 10 deutera to message.properties g allages

        return messageSource;
    }

}
