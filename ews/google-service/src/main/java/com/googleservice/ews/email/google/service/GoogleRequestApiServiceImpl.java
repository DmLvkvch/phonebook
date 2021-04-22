package com.googleservice.ews.email.google.service;

import com.dmlvkvch.oauth.authenticate.AccessToken;
import com.google.api.services.gmail.model.Message;
import com.googleservice.ews.email.google.requests.GoogleApiRequestUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("googleApiService")
public class GoogleRequestApiServiceImpl implements GoogleRequestApiService {

    @Override
    public String getMessages(AccessToken accessToken) {
        List<Message> userMessages = GoogleApiRequestUtils.getUserMessages(accessToken);
        return userMessages.toString();
    }

}
