package com.dmlvkvch.oauth.authenticate;

import java.util.List;

public interface AccessToken {
    String getAccessToken();
    String getRefreshToken();
    Long getExpiresInSeconds();
    String getTokenType();
    TokenType getServiceTokenType();
    String getScope();
}
