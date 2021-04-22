package com.googleservice.ews.email.google.service;

import com.dmlvkvch.oauth.authenticate.AccessToken;

public interface GoogleRequestApiService {
    String getMessages(AccessToken accessToken);
}
