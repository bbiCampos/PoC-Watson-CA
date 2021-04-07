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
public class Entities {
    @JsonProperty("cnpj")
    public String cnpj;

    @JsonProperty("cpf")
    public String cpf;

    @JsonProperty("currency")
    public String currency;

    @JsonProperty("date")
    public String date;

    @JsonProperty("email")
    public String email;





}
