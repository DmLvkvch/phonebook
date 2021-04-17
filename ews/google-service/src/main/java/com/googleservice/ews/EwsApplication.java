package com.googleservice.ews;

import com.dmlvkvch.oauth.domain.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
@EntityScan(
        basePackages = "com.dmlvkvch.oauth",
        basePackageClasses = {User.class, OAuth2UserAccessCredential.class,
                              ServiceType.class, UserServiceInfo.class}
)
public class EwsApplication {

    public static void main(String[] args) {
        SpringApplication.run(EwsApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo() {

        return (args) -> {
            User u = new User();
            ArrayList<OAuth2UserAccessCredential> objects = new ArrayList<>() {{
                add(new OAuth2UserAccessCredential());
                add(new OAuth2UserAccessCredential());
            }};
            u.setOAuth2UserAccessCredentialList(objects);
            u.getOAuth2UserAccessCredentialList().forEach(o->o.setUser(u));
        };
    }
}
