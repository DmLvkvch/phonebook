package com.googleservice.ews.email.google.controller;

import com.googleservice.ews.email.google.oauth.GoogleAccessToken;
import com.googleservice.ews.email.google.service.GoogleRequestApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class GoogleApiRequestControllerImpl implements GoogleApiRequestController {

    @Autowired
    GoogleRequestApiService googleApiService;

    @Override
    @PostMapping("/messages")
    public String getMessages(@RequestBody GoogleAccessToken accessToken) {
        return googleApiService.getMessages(accessToken);
    }
}
