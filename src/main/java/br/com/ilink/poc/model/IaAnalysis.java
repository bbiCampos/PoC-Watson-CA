package br.com.ilink.poc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IaAnalysis {

    @JsonProperty("top2Intents")
    public List<Top2Intent> top2Intents = new ArrayList<>();

    @JsonProperty("entities")
    public List<Entities> entities = new ArrayList<>();

}
