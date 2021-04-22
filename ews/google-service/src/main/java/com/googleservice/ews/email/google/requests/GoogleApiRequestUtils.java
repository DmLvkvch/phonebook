package com.googleservice.ews.email.google.requests;

import com.dmlvkvch.oauth.authenticate.AccessToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.Message;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GoogleApiRequestUtils {
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

    public static List<Message> getUserMessages(AccessToken accessToken) {
        GoogleCredential credential = new GoogleCredential.Builder().build();
        credential.setAccessToken(accessToken.getAccessToken())
                .setExpiresInSeconds(accessToken.getExpiresInSeconds());
        final NetHttpTransport HTTP_TRANSPORT;
        List<Message> messages = null;
        try {
            HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            Gmail service = new Gmail(HTTP_TRANSPORT, JSON_FACTORY, credential);
            messages = service.users().messages().list("me").execute().getMessages()
                    .stream().map(p -> getMailSnippet(service, p)).filter(Objects::nonNull).collect(Collectors.toList());
        } catch (GeneralSecurityException | IOException e) {
            e.printStackTrace();
        }
        return messages;
    }

    private static Message getMailSnippet(Gmail service, Message message) {
        Message msg = null;
        try {
            msg = service.users().messages().get("me", message.getId()).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return msg;
    }
}
