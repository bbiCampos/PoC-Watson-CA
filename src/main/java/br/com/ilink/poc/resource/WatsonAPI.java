package br.com.ilink.poc.resource;

import br.com.ilink.poc.model.Sentence;
import br.com.ilink.poc.service.JsonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WatsonAPI {

    @GetMapping ("/")
    public Sentence getSentence(@RequestBody Sentence input){

        JsonService jsonHandler = new JsonService();
        Sentence response = jsonHandler.getSentence(input);

        return response;
    }

}