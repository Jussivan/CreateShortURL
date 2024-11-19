package com.mycompany.createshorturl;
import java.util.Map;
import java.util.HashMap;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.Context;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CreateShortURL implements RequestHandler<Map<String, Object>, Map<String, String>> {
    
    private final ObjectMapper objectMapper = new ObjectMapper();
    
    @Override
    public Map<String, String> handleRequest(Map<String, Object> input, Context context) {
        String body = input.get("body").toString();
        
        Map<String, String> bodyMap;
        try {
            bodyMap = objectMapper.readValue(body, Map.class);
        } catch(Exception exception) {
            throw new RuntimeException("Error parsing JSON body:" + exception.getMessage(), exception);
        }
        
        String originalUrl = bodyMap.get("originalUrl");
        String expirationTime = bodyMap.get("expirationTime");
        
        String shortUrlCode = java.util.UUID.randomUUID().toString().substring(0,8);
        Map<String, String> response = new HashMap<>();
        response.put("code", shortUrlCode);
        
        return response;
    }
}
