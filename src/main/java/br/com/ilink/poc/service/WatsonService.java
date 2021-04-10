package br.com.ilink.poc.service;

import br.com.ilink.poc.model.WatsonCredentials;
import com.ibm.cloud.sdk.core.http.HttpConfigOptions;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.assistant.v1.Assistant;
import com.ibm.watson.assistant.v1.model.MessageInput;
import com.ibm.watson.assistant.v1.model.MessageOptions;
import com.ibm.watson.assistant.v1.model.MessageResponse;

import static br.com.ilink.poc.service.ControlContext.getNLUContext;
import static br.com.ilink.poc.service.MessageHandling.parseMessage;


public class WatsonService {

    public MessageResponse callWatson(String userMessage, WatsonCredentials credentials) {

        Authenticator authenticator = new IamAuthenticator(credentials.API_KEY);

        Assistant service = new Assistant("2021-01-15", authenticator);

        service.setEndPoint(credentials.URL);

        HttpConfigOptions configOptions = new HttpConfigOptions.Builder()
                .disableSslVerification(true)
                .build();
        service.configureClient(configOptions);

        MessageInput input = new MessageInput();
        input.setText(parseMessage(userMessage));

        MessageOptions options = new MessageOptions
                .Builder(credentials.SKILL_ID)
                .input(input)
                .alternateIntents(true)
                .context(getNLUContext())
                .build();

        MessageResponse response = service.message(options).execute().getResult();

        //botContext = response.getContext();

        System.out.println(response);
        System.out.println("---------------------------");

        return response;
    }
}
