package com.dmlvkvch.oauth.rest.controller;

import com.dmlvkvch.oauth.authenticate.AccessToken;

import java.util.Map;

public interface OAuth2Controller {

    String signIn();

    String logOut();

    AccessToken getCode(Map<String, String> params);
}
