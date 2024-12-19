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

    public DossierMedical getDossierMedicalByPatient(int idPatient) {
        String url = "http://localhost:8082/api/dossier-medical/getDossierMedicalByPatient/" + idPatient; // Remplacez par l'URL réelle du microservice
        return restTemplate.getForObject(url, DossierMedical.class);
    }

    public DossierMedical createDossierMedical(int idPatient, String diagnostic) {
        String url = "http://localhost:8082/api/dossier-medical/create/" + idPatient + "/" + diagnostic; // Remplacez par l'URL réelle du microservice
        return restTemplate.postForObject(url, null, DossierMedical.class);
    }

    public DossierMedical updateDossierMedical(int id, DossierMedical updatedDossierMedical) {
        String url = "http://localhost:8082/api/dossier-medical/update/" + id; // Remplacez par l'URL réelle du microservice
        restTemplate.put(url, updatedDossierMedical);
        return updatedDossierMedical;
    }
}
