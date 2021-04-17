package com.googleservice.ews.email.google.controller;

import com.dmlvkvch.oauth.authenticate.AccessToken;
import com.dmlvkvch.oauth.rest.controller.OAuth2Controller;

import java.util.Map;


public interface OAuth2GoogleController extends OAuth2Controller {

    String signIn();

    String logOut();

    AccessToken getCode(Map<String, String> params);
}
