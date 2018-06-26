package com.example.whitepagesdemo.entities.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressCheck {

    private Error error;
    private String[] warnings;

    @JsonProperty(value = "is_valid", required = true)
    private boolean isValid;

    private String[] diagnostics;
}
