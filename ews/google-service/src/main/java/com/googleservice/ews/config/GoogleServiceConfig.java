package com.googleservice.ews.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(
        ignoreResourceNotFound = false,
        value = "classpath:google.properties")
public class GoogleServiceConfig {

}
