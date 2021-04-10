package br.com.ilink.poc.resource;

import br.com.ilink.poc.model.IaAnalysis;
import br.com.ilink.poc.model.Request;
import br.com.ilink.poc.service.JsonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WatsonAPI {

    @GetMapping ("/")
    public IaAnalysis getSentence(@RequestBody Request request){

        JsonService jsonHandler = new JsonService();
        IaAnalysis response = jsonHandler.getIaAnalysis(request.sentence, request.credentials);

        return response;
    }

}