package com.example.whitepagesdemo.identitycheck;

import com.example.whitepagesdemo.entities.request.ApiRequest;
import com.example.whitepagesdemo.entities.request.PrimaryDetails;
import com.example.whitepagesdemo.entities.response.ApiResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Component
public class IdentityCheckService {

    private static final String WHITEPAGES_IDENTITY_CHECK_API_BASE_URL = "https://proapi.whitepages.com/3.2/identity_check.json?";
    private static final String API_KEY = "1935586a1cca45b191e0e382e99f27d7";


    public List<ApiResponse> performIdCheck(List<ApiRequest> apiRequests) throws IOException {
        List<ApiResponse> allApiResponses = new ArrayList<>();

        for (ApiRequest apiRequest : apiRequests) {
            URL url = new URL(constructURL(apiRequest.getPrimaryDetails()));
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            String response;
            try {
                InputStream in = url.openStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String line = reader.readLine();
                response = line;
                while ((line = reader.readLine()) != null) {
                    response += line;
                }

                ObjectMapper objectMapper = new ObjectMapper();
                // JSONParser parser = new JSONParser();
                // JSONObject o = (JSONObject) parser.parse(response);
                // JSONObject newObject = new JSONObject();
                // newObject.put("ip_address_checks", o.get("ip_address_checks"));
                // newObject.addProperty(); // o.get("ip_address_checks");

                // convert json string to object
                // ApiResponse apiResponse = objectMapper.readValue(objectMapper.writeValueAsString(o), ApiResponse.class);
                ApiResponse apiResponse = objectMapper.readValue(response, ApiResponse.class);
                apiResponse.setTransactionId(apiRequest.getTransactionId());
                allApiResponses.add(apiResponse);
            } catch (Exception e) {
                System.out.println("Exception " + e);
            }
        }

        return allApiResponses;
    }


    private String constructURL(PrimaryDetails primaryDetails) throws UnsupportedEncodingException {

        // TODO Add Secondary Fields
        // TODO Add query based on requirements only eg: IP_Address,
        StringBuilder sb = new StringBuilder(WHITEPAGES_IDENTITY_CHECK_API_BASE_URL);
        sb.append("primary.name=" + encodeParam(primaryDetails.getName()) + "&");
        sb.append("primary.phone=" + encodeParam(primaryDetails.getPhone()) + "&");
        sb.append("primary.address.street_line_1=" + encodeParam(primaryDetails.getAddress().getStreetAddressLine1()) + "&");
        sb.append("primary.address.street_line_2=" + encodeParam(primaryDetails.getAddress().getStreetAddressLine2()) + "&");
        sb.append("primary.address.city=" + encodeParam(primaryDetails.getAddress().getCity()) + "&");
        sb.append("primary.address.state_code=" + encodeParam(primaryDetails.getAddress().getStateCode()) + "&");
        sb.append("primary.address.postal_code=" + encodeParam(primaryDetails.getAddress().getPostalCode()) + "&");
        sb.append("primary.address.country_code=" + encodeParam(primaryDetails.getAddress().getCountryCode()) + "&");
        sb.append("email_address=" + encodeParam(primaryDetails.getEmailAddress()) + "&");
        sb.append("ip_address=" + encodeParam(primaryDetails.getIpAddress()) + "&");
        sb.append("api_key=" + API_KEY);
        System.out.println("SB: " + sb.toString());
        return sb.toString();
    }

    private String encodeParam(String param) throws UnsupportedEncodingException {
        if (param != null) {
            return URLEncoder.encode(param, StandardCharsets.UTF_8.toString());
        }
        return "";

    }
}
