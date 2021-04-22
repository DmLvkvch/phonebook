package com.starter.main;

import com.dmlvkvch.oauth.domain.OAuth2UserAccessCredential;
import com.dmlvkvch.oauth.domain.ServiceType;
import com.dmlvkvch.oauth.domain.User;
import com.dmlvkvch.oauth.domain.UserServiceInfo;
import com.googleservice.ews.email.google.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@PropertySource(value = {"google.properties", "application.properties"})
@ComponentScan({"com.googleservice", "com.starter"})
@EntityScan(basePackages = "com.dmlvkvch.oauth")
@EnableTransactionManagement
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

}
