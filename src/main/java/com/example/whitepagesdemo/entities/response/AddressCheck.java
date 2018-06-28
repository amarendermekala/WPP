package com.example.whitepagesdemo.entities.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AddressCheck {

    @JsonProperty(value = "error")
    private Error error;

    @JsonProperty(value = "warnings")
    private String[] warnings;

    @JsonProperty(value = "is_valid")
    private Boolean isValid;

    @JsonProperty(value = "diagnostics")
    private String[] diagnostics;

    @JsonProperty(value = "is_active")
    private Boolean isActive;

    @JsonProperty(value = "address_to_name")
    private String addressNameMatch;

    @JsonProperty(value = "resident_name")
    private String residentName;

    @JsonProperty(value = "resident_age_range")
    private String residentAgeRange;

    @JsonProperty(value = "is_commercial")
    private Boolean isCommercial;

    @JsonProperty(value = "is_forwarder")
    private Boolean isForwarder;

    @JsonProperty(value = "type")
    private String type;


}
