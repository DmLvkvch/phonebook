package com.googleservice.ews.email.google.oauth;

import com.dmlvkvch.oauth.authenticate.AccessToken;
import com.dmlvkvch.oauth.authenticate.OAuth2;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeRequestUrl;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.googleservice.ews.EwsApplication;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.gmail.GmailScopes;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Map;

@Component
@Qualifier("googleAuthenticate")
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Lazy
public class GoogleAuthenticate implements OAuth2 {

    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final List<String> SCOPES = List.of(GmailScopes.GMAIL_LABELS, GmailScopes.GMAIL_MODIFY);
    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";
    private static final GoogleAuthorizationCodeFlow GOOGLE_AUTHORIZATION = getGoogleAuthorizationCredentials();

    public GoogleAuthenticate(){
    }

    private static GoogleAuthorizationCodeFlow getGoogleAuthorizationCredentials() {
        InputStream in = EwsApplication.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
        if (in == null) {
            try {
                throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        }
        GoogleAuthorizationCodeFlow flow = null;
        try {
            GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
            flow = new GoogleAuthorizationCodeFlow.Builder(
                    GoogleNetHttpTransport.newTrustedTransport(), JSON_FACTORY, clientSecrets, SCOPES)
                    .setAccessType("offline")
                    .build();
        } catch (GeneralSecurityException | IOException e) {
            e.printStackTrace();
        }
        return flow;
    }

    @Override
    public URI getAuthenticateUrl() {
        assert GOOGLE_AUTHORIZATION != null;
        GoogleAuthorizationCodeRequestUrl googleAuthorizationCodeRequestUrl = GOOGLE_AUTHORIZATION.newAuthorizationUrl();
        googleAuthorizationCodeRequestUrl.setRedirectUri("http://localhost:8080/api/oauth/google/code");
        return googleAuthorizationCodeRequestUrl.toURI();
    }

    @Override
    public AccessToken getAccessToken(Map<String, String> authCodeResponse) {
        assert GOOGLE_AUTHORIZATION != null;
        GoogleAuthorizationCodeTokenRequest code = GOOGLE_AUTHORIZATION.newTokenRequest(authCodeResponse.get("code"));
        GoogleAccessToken googleAccessToken = null;
        code.setRedirectUri("http://localhost:8080/api/oauth/google/code");
        try {
            googleAccessToken = new GoogleAccessToken(code.execute());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return googleAccessToken;
    }
}
