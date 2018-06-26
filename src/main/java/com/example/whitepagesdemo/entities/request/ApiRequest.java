package com.example.whitepagesdemo.entities.request;

import java.util.Objects;

public class ApiRequest {

    private String transactionId;
    private String customerId;
    private PrimaryDetails primaryDetails;
    private SecondaryDetails secondaryDetails;
    private String[] requiredChecks;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public PrimaryDetails getPrimaryDetails() {
        return primaryDetails;
    }

    public void setPrimaryDetails(PrimaryDetails primaryDetails) {
        this.primaryDetails = primaryDetails;
    }

    public SecondaryDetails getSecondaryDetails() {
        return secondaryDetails;
    }

    public void setSecondaryDetails(SecondaryDetails secondaryDetails) {
        this.secondaryDetails = secondaryDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ApiRequest)) return false;
        ApiRequest that = (ApiRequest) o;
        return Objects.equals(getTransactionId(), that.getTransactionId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTransactionId());
    }

    @Override
    public String toString() {
        return "ApiRequest{" +
                "transactionId='" + transactionId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", primaryDetails=" + primaryDetails +
                ", secondaryDetails=" + secondaryDetails +
                '}';
    }
}
