package com.googleservice.ews.email.google.oauth;


import com.dmlvkvch.oauth.authenticate.AccessToken;
import com.dmlvkvch.oauth.domain.ServiceType;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class GoogleAccessToken implements AccessToken {

    private String refreshToken;
    private String accessToken;
    private Long expiresInSeconds;
    private String tokenType;
    private ServiceType serviceTokenType;
    private String scope;

    public GoogleAccessToken(GoogleTokenResponse googleTokenResponse) {
        this.refreshToken = googleTokenResponse.getRefreshToken();
        this.accessToken = googleTokenResponse.getAccessToken();
        this.serviceTokenType = ServiceType.GMAIL;
        this.expiresInSeconds = googleTokenResponse.getExpiresInSeconds();
        this.tokenType = googleTokenResponse.getTokenType();
        this.scope = googleTokenResponse.getScope();
    }
}
