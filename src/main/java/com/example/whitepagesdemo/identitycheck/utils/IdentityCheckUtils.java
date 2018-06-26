package com.example.whitepagesdemo.identitycheck.utils;

import com.example.whitepagesdemo.entities.request.ApiRequest;

import java.util.Arrays;
import java.util.List;

public class IdentityCheckUtils {

    public static boolean validateAPIRequest(List<ApiRequest> apiRequests) {

        // TODO return an properly formatted APIError object which has status code, exception message

        // Check for Primary Details Existence
        // Check for duplicate transactionIds in the same batch
       return true;
    }

    public static ApiRequest[] convertCsvToApiRequest(String csvContent) {
        String[] csvLines = csvContent.split("\n");
        ApiRequest[] apiRequests = new ApiRequest[csvLines.length];

        Arrays.stream(csvLines).map(csvLine -> {
            ApiRequest apiRequest = new ApiRequest();

            return apiRequest;
        });

        return apiRequests;
    }
}
