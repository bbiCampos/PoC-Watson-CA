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
public class Intent {

    @JsonProperty("top2Intents")
    public String top2Intents;

    @JsonProperty("confidence")
    public Double confidence;

}
