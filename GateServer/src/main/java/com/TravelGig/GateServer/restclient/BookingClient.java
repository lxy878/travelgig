package com.TravelGig.GateServer.restclient;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class BookingClient {
    private String baseUrl = "http://localhost:8484";

    public JsonNode postRequest(JsonNode json, String path){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(json.toString(), headers);
        
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> responseEntity = restTemplate.postForEntity(baseUrl+path, entity, Object.class);
        Object body = responseEntity.getBody();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode respond = mapper.convertValue(body, JsonNode.class);
        
        return respond;
    }
}
