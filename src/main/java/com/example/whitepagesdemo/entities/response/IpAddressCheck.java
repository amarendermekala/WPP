package com.example.whitepagesdemo.entities.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class IpAddressCheck {

    @JsonProperty("error")
    private Error error;

    @JsonProperty("warnings")
    private String[] warnings;

    @JsonProperty(value = "is_valid", required = true)
    private Boolean isValid;

    @JsonProperty(value = "is_proxy")
    private Boolean isProxy;

    @JsonProperty(value = "geolocation")
    private Object geolocation;

    @JsonProperty(value = "distance_from_address")
    private Integer distanceFromAddress;

    @JsonProperty(value = "distance_from_phone")
    private Integer distanceFromPhone;

    @JsonProperty(value = "connection_type")
    private String connectionType;


}
