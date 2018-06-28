package com.example.whitepagesdemo.entities.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ApiResponse {

    @JsonProperty("identity_check_score")
    private String identityCheckScore;

    @JsonProperty("transaction_id")
    private String transactionId;

    @JsonProperty("ip_address_checks")
    private IpAddressCheck ipAddressCheck;

    @JsonProperty("email_address_checks")
    private EmailAddressCheck emailAddressCheck;

    @JsonProperty("primary_address_checks")
    private AddressCheck primaryAddressCheck;

    @JsonProperty("secondary_address_checks")
    private AddressCheck secondaryAddressCheck;

    @JsonProperty("primary_phone_checks")
    private PhoneCheck primaryPhoneCheck;

    @JsonProperty("secondary_phone_checks")
    private PhoneCheck secondaryPhoneCheck;

    public String getIdentityCheckScore() {
        return identityCheckScore;
    }

    public void setIdentityCheckScore(String identityCheckScore) {
        this.identityCheckScore = identityCheckScore;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
