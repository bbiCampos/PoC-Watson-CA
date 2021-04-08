package br.com.ilink.poc.service;

import br.com.ilink.poc.model.*;
import com.ibm.watson.assistant.v1.model.MessageResponse;

public class JsonService {

    public Sentence getSentence (Sentence input){

        WatsonService watsonService = new WatsonService();
        MessageResponse response = watsonService.callWatson(input.getMessage());

        Sentence sentence = new Sentence();

        sentence.setStartDateTime(input.getStartDateTime());
        sentence.setStart(input.getStart());
        sentence.setEnd(input.getEnd());
        sentence.setSentenceId(input.getSentenceId());
        sentence.setSpeaker(input.getSpeaker());
        sentence.setMessage(input.getMessage());

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
        if (response.getContext().get("dados_ok") != null){
            businessRules.setUserDataValid(true);
        }
        iaAnalysis.getBusinessRules().add(businessRules);

        sentence.setIaAnalysis(iaAnalysis);

        return sentence;
    }
}
