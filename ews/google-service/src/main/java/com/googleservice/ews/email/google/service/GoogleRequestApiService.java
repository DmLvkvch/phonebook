package com.googleservice.ews.email.google.service;

import com.dmlvkvch.oauth.authenticate.AccessToken;
import com.googleservice.ews.email.google.api.Response;

public interface GoogleRequestApiService {
    Response getNewMessages(AccessToken accessToken);
}
