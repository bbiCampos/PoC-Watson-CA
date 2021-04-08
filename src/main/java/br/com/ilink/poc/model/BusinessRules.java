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

    @JsonProperty("justifiedAbsence")
    public Boolean justifiedAbsence;

    @JsonProperty("satisfactionSurvey")
    public Boolean satisfactionSurvey;

    @JsonProperty("lastScript")
    public Boolean lastScript;

    @JsonProperty("offense")
    public Boolean offense;

    @JsonProperty("anythingElse")
    public Boolean anythingElse;

}
