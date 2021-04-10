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
public class Request {

    @JsonProperty("sentence")
    public Sentence sentence;

    @JsonProperty("credentials")
    public WatsonCredentials credentials;
}
