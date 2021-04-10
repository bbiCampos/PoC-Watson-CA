package br.com.ilink.poc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WatsonCredentials {

    @JsonProperty("skillId")
    public String SKILL_ID;

    @JsonProperty("apiKey")
    public String API_KEY;

    public String URL = "https://gateway.watsonplatform.net/assistant/api/";  //Default URL
}
