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
public class Top2Intent {

    @JsonProperty("primaryIntent")
    public String primaryIntent;

    @JsonProperty("secundaryIntent")
    public String secundaryIntent;

}
