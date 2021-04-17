package com.dmlvkvch.oauth.service;

import com.dmlvkvch.oauth.authenticate.AccessToken;
import com.dmlvkvch.oauth.domain.User;

import java.net.URI;
import java.util.Map;

public interface OAuthService {
    URI getOAuthUri();
    AccessToken getAccessToken(Map<String, String> authCode);
    void saveAccessToken(User user, AccessToken accessToken);
    void updateAccessToken(User user, AccessToken accessToken);
    void deleteAccessToken(User user, AccessToken accessToken);
}
