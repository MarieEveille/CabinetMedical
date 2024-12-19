package org.example.rendezvous.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalServiceClient {

    private final RestTemplate restTemplate;


    public ExternalServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean isPatientExists(int id) {
        String url = "http://localhost:8080/api/patients/" + id; // URL du service Patient
        try {
            return restTemplate.getForObject(url, Boolean.class);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isPraticienExists(int id) {
        String url = "http://localhost:8081/api/praticiens/" + id; // URL du service Praticien
        try {
            System.out.printf("bool %b\n", restTemplate.getForObject(url, Boolean.class));
            return restTemplate.getForObject(url, Boolean.class);
        } catch (Exception e) {
            return false;
        }
    }
}

