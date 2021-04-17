package com.googleservice.ews.email.google.controller;


import com.dmlvkvch.oauth.authenticate.AccessToken;
import com.dmlvkvch.oauth.service.OAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
//@PropertySource("classpath:google.properties")
@RequestMapping("/api/oauth/${url.oauth}")
public class AuthenticateGoogleControllerImpl implements OAuth2GoogleController {

    @Autowired
    private OAuthService oAuthService;

    @GetMapping("${url.login}")
    public String signIn() {
        return oAuthService.getOAuthUri().toString();
    }


    @GetMapping("${url.logout}")
    public String logOut() {
        return null;
    }

    @GetMapping("${url.redirect}")
    public AccessToken getCode(@RequestParam Map<String, String> params) {
        return oAuthService.getAccessToken(params);
    }
}
