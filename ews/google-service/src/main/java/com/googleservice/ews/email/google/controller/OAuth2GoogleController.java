package com.googleservice.ews.email.google.controller;

import com.dmlvkvch.oauth.authenticate.AccessToken;

import java.util.Map;

public interface OAuth2GoogleController {

    String signIn();

    AccessToken getCode(Map<String, String> params);
}
