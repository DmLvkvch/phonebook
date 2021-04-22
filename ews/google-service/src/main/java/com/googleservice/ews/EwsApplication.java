package com.googleservice.ews;

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
import org.springframework.context.annotation.PropertySource;


@SpringBootApplication
@EntityScan(
        basePackages = "com.dmlvkvch.oauth",
        basePackageClasses = {User.class, OAuth2UserAccessCredential.class,
                ServiceType.class, UserServiceInfo.class}
)
@PropertySource(value = {"google.properties"})
public class EwsApplication {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(EwsApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo() {

        return (args) -> {
            User u = new User();
            u.setOAuth2UserAccessCredential(new OAuth2UserAccessCredential());
            u.getOAuth2UserAccessCredential().setUser(u);
            userRepository.save(u);
        };
    }
}
