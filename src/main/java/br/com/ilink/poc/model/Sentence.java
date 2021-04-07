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
public class Sentence {

    @JsonProperty("startDateTime")
    public String startDateTime;

    @JsonProperty("start")
    public double start;

    @JsonProperty("end")
    public double end;

    @JsonProperty("sentenceId")
    public int sentenceId;

    @JsonProperty("speaker")
    public int speaker;

    @JsonProperty("message")
    public String message;

    @JsonProperty("iaAnalysis")
    public IaAnalysis iaAnalysis;

}
