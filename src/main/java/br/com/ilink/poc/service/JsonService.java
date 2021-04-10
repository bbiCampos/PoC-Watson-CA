package br.com.ilink.poc.service;

import br.com.ilink.poc.model.*;
import com.ibm.watson.assistant.v1.model.MessageResponse;

public class JsonService {

    public IaAnalysis getIaAnalysis (Sentence input, WatsonCredentials credentials){

        WatsonService watsonService = new WatsonService();
        MessageResponse response = watsonService.callWatson(input.getMessage(), credentials);

        Top2Intent intents = new Top2Intent();
        intents.setPrimaryIntent(response.getIntents().get(0).intent());
        intents.setSecundaryIntent(response.getIntents().get(1).intent());

        IaAnalysis iaAnalysis = new IaAnalysis();
        iaAnalysis.getTop2Intents().add(intents);

        Entities entities = new Entities();
        if (response.getContext().get("cpf") != null){
            entities.setCpf(String.valueOf(response.getContext().get("cpf")));
        }
        if (response.getContext().get("cnpj") != null){
            entities.setCnpj(String.valueOf(response.getContext().get("cnpj")));
        }
        if (response.getContext().get("email") != null){
            entities.setEmail(String.valueOf(response.getContext().get("email")));
        }
        if (response.getContext().get("currency") != null){
            entities.setCurrency(String.valueOf(response.getContext().get("currency")));
        }
        if (response.getContext().get("date") != null){
            entities.setDate(String.valueOf(response.getContext().get("date")));
        }
        iaAnalysis.getEntities().add(entities);

        BusinessRules businessRules = new BusinessRules();
        if (response.getContext().get("first_script") != null){
            businessRules.setFirstScript(true);
        }
        if (response.getContext().get("user_data_valid") != null){
            businessRules.setUserDataValid(true);
        }
        if (response.getContext().get("justified_absence") != null){
            businessRules.setJustifiedAbsence(true);
        }
        if (response.getContext().get("satisfaction_survey") != null){
            businessRules.setSatisfactionSurvey(true);
        }
        if (response.getContext().get("last_script") != null){
            businessRules.setLastScript(true);
        }
        if (response.getContext().get("offense") != null){
            businessRules.setOffense(true);
        }
        if (response.getContext().get("anything_else") != null){
            businessRules.setAnythingElse(true);
        }
        iaAnalysis.getBusinessRules().add(businessRules);

        return iaAnalysis;
    }
}
