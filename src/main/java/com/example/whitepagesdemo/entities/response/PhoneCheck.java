package com.example.whitepagesdemo.entities.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PhoneCheck {

    @JsonProperty("error")
    private Error error;

    @JsonProperty("warnings")
    private String[] warnings;

    @JsonProperty("is_valid")
    private boolean isValid;

    @JsonProperty("phone_to_name")
    private String phoneNameMatch;

    @JsonProperty("phone_to_address")
    private String phoneAddressMatch;

    @JsonProperty("subscriber_name")
    private String subscriberName;

    @JsonProperty("subscriber_age_range")
    private String subscriberAgeRange;

    @JsonProperty("country_code")
    private String countryCode;

    @JsonProperty("is_commercial")
    private String isCommercial;

    @JsonProperty("line_type")
    private String lineType;

    private String carrier;

    @JsonProperty("is_prepaid")
    private String isPrepaid;

}
