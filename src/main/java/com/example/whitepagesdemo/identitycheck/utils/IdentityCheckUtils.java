package com.example.whitepagesdemo.identitycheck.utils;

import com.example.whitepagesdemo.entities.request.Address;
import com.example.whitepagesdemo.entities.request.ApiRequest;
import com.example.whitepagesdemo.entities.request.PrimaryDetails;
import com.example.whitepagesdemo.identitycheck.constants.CSVIndexes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IdentityCheckUtils {

    public static boolean validateAPIRequest(List<ApiRequest> apiRequests) {

        // TODO return an properly formatted APIError object which has status code, exception message

        // Check for Primary Details Existence
        // Check for duplicate transactionIds in the same batch
       return true;
    }

    public static List<ApiRequest> convertCsvToApiRequest(String csvContent) {
        String[] csvLines = csvContent.split("\n");

        List<ApiRequest> apiRequests = Arrays.stream(csvLines).map(csvLine -> {
            String[] properties = csvLine.split(",");

            ApiRequest apiRequest = new ApiRequest();
            apiRequest.setTransactionId(getIdBasedOnCSVLine(properties));

            PrimaryDetails primaryDetails = new PrimaryDetails();
            primaryDetails.setName(properties[CSVIndexes.PRIMARY_NAME]);
            primaryDetails.setPhone(properties[CSVIndexes.PRIMARY_PHONE]);
            primaryDetails.setEmailAddress(properties[CSVIndexes.EMAIL_ADDRESS]);
            primaryDetails.setIpAddress(properties[CSVIndexes.IP_ADDRESS]);
            primaryDetails.setAddress(getAddressFromCSVLine(properties));

            apiRequest.setPrimaryDetails(primaryDetails);
            return apiRequest;
        }).collect(Collectors.toList());

        return apiRequests;
    }

    private static String getIdBasedOnCSVLine(String[] properties) {
        String id = properties[CSVIndexes.ID];
        if(StringUtils.isBlank(id)) {
            id = String.join(",", Arrays.asList(properties));
            id = id.substring(1);
        }
        return id;
    }

    private static Address getAddressFromCSVLine(String[] properties) {
        Address ad = new Address();
        ad.setStreetAddressLine1(properties[CSVIndexes.PRIMARY_ADDRESS_STREET_LINE_1]);
        ad.setStreetAddressLine2(properties[CSVIndexes.PRIMARY_ADDRESS_STREET_LINE_2]);
        ad.setCity(properties[CSVIndexes.PRIMARY_ADDRESS_CITY]);
        ad.setPostalCode(properties[CSVIndexes.PRIMARY_ADDRESS_POSTAL_CODE]);
        ad.setStateCode(properties[CSVIndexes.PRIMARY_ADDRESS_STATE_CODE]);
        ad.setCountryCode(properties[CSVIndexes.PRIMARY_ADDRESS_COUNTRY_CODE]);
        return ad;
    }
}
