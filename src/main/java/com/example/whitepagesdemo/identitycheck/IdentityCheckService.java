package com.example.whitepagesdemo.identitycheck;

import com.example.whitepagesdemo.entities.request.ApiRequest;
import com.example.whitepagesdemo.entities.request.PrimaryDetails;
import com.example.whitepagesdemo.entities.response.ApiResponse;
import com.example.whitepagesdemo.identitycheck.constants.CommonConstants;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Component
public class IdentityCheckService {

    @Value("${application.name}")
    private String asd;

    private static final String WHITEPAGES_IDENTITY_CHECK_API_BASE_URL = "https://proapi.whitepages.com/3.2/identity_check.json?";

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
                ApiResponse apiResponse = objectMapper.readValue(response, ApiResponse.class);
                apiResponse.setTransactionId(apiRequest.getTransactionId());
                allApiResponses.add(apiResponse);
            } catch (AccessDeniedException e) {
                throw e;
            }
            catch (Exception e) {
                System.out.println("Exception " + e);
            }
        }

        System.out.print(asd);
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
        System.out.println("API Key: " + getWhitePagesApiKey());
        sb.append("api_key=" + getWhitePagesApiKey());
        System.out.println("SB: " + sb.toString());
        return sb.toString();
    }

    private String encodeParam(String param) throws UnsupportedEncodingException {
        if (param != null) {
            return URLEncoder.encode(param, StandardCharsets.UTF_8.toString());
        }
        return "";
    }

    private String getWhitePagesApiKey() {
        String apiKey = System.getenv(CommonConstants.WHITEPAGES_API_KEY);
        if(apiKey == null) {
            try {
                Properties props = new Properties();
                props.load(new FileInputStream("application.properties"));
                apiKey = props.getProperty(CommonConstants.WHITEPAGES_API_KEY);
            } catch(IOException e) {
                System.out.println("Properties file not found" + e.getStackTrace());
            }
        }
        return apiKey;
    }

}
