package br.com.ilink.poc.service;

import com.ibm.cloud.sdk.core.http.HttpConfigOptions;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.assistant.v1.Assistant;
import com.ibm.watson.assistant.v1.model.MessageInput;
import com.ibm.watson.assistant.v1.model.MessageOptions;
import com.ibm.watson.assistant.v1.model.MessageResponse;

import static br.com.ilink.poc.service.ControlContext.*;
import static br.com.ilink.poc.service.MessageHandling.parseMessage;


public class WatsonService {


    private static final String WORKSPACE_ID = "26584390-daac-4850-b97b-6d1b2d609b30";
    private static final String API_KEY = "rJLq5s2EFJkrJ_DxRpqK4TkfPtSlib0utGTQOdQDh4ja";
    private static final String URL = "https://gateway.watsonplatform.net/assistant/api/";  //Default URL


    public MessageResponse callWatson(String userMessage) {

        Authenticator authenticator = new IamAuthenticator(API_KEY);

        Assistant service = new Assistant("2021-01-15", authenticator);

        service.setEndPoint(URL);

        HttpConfigOptions configOptions = new HttpConfigOptions.Builder()
                .disableSslVerification(true)
                .build();
        service.configureClient(configOptions);

        MessageInput input = new MessageInput();
        input.setText(parseMessage(userMessage));

        MessageOptions options = new MessageOptions
                .Builder(WORKSPACE_ID)
                .input(input)
                .alternateIntents(true)
                .context(getNLUContext())
                .build();

        MessageResponse response = service.message(options).execute().getResult();

        //botContext = response.getContext();

        return response;
    }
}
