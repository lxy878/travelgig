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
public class HotelManagementClient {
    private String baseUrl = "http://localhost:8282";

    public JsonNode getRequest(String path){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate template = new RestTemplate();
        ResponseEntity<Object> entity = template.getForEntity(baseUrl+path, Object.class);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(entity.getBody(), JsonNode.class);
    }

    public JsonNode postRequest(String path, JsonNode json){
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
