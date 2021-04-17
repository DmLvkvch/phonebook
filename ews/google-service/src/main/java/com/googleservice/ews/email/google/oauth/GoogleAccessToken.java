package com.googleservice.ews.email.google.oauth;


import com.dmlvkvch.oauth.authenticate.AccessToken;
import com.dmlvkvch.oauth.authenticate.TokenType;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;

public class GoogleAccessToken implements AccessToken {

    private final GoogleTokenResponse googleTokenResponse;

    public GoogleAccessToken(GoogleTokenResponse googleTokenResponse){
        this.googleTokenResponse = googleTokenResponse;
    }

    @Override
    public String getAccessToken() {
        return googleTokenResponse.getAccessToken();
    }

    @Override
    public String getRefreshToken() {
        return googleTokenResponse.getRefreshToken();
    }

    @Override
    public Long getExpiresInSeconds() {
        return googleTokenResponse.getExpiresInSeconds();
    }

    @Override
    public String getTokenType() {
        return googleTokenResponse.getTokenType();
    }

    @Override
    public TokenType getServiceTokenType() {
        return TokenType.GOOGLE_TOKEN;
    }

    @Override
    public String getScope() {
        return googleTokenResponse.getScope();
    }
}
