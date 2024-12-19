package org.example.praticien.services;

import org.example.praticien.models.DossierMedical;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DossierMedicalClient {

    private final RestTemplate restTemplate;

    public DossierMedicalClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public DossierMedical getDossierMedicalById(int id) {
        String url = "http://localhost:8082/api/dossier-medical/getDossierMedical/" + id; // Remplacez par l'URL réelle du microservice
        return restTemplate.getForObject(url, DossierMedical.class);
    }
}
