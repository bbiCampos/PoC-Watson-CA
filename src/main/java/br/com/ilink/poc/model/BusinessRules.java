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
public class BusinessRules {

    @JsonProperty("firstScript")
    public Boolean firstScript;

    @JsonProperty("userDataValid")
    public Boolean userDataValid;

}
