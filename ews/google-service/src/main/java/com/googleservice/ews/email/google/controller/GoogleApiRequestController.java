package com.googleservice.ews.email.google.controller;

import com.googleservice.ews.email.google.oauth.GoogleAccessToken;


public interface GoogleApiRequestController {
    String getMessages(GoogleAccessToken accessToken);
}
