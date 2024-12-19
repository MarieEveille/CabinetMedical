package org.example.gateway.controllers;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.http.HttpEntity;
import org.example.gateway.models.DossierMedical;
import org.example.gateway.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@RestController
public class DossierMedicalController {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallbackGetAllDossiersMedicaux")
    @RequestMapping(value = "/api/dossier-medical/all", method = RequestMethod.GET)
    public List<DossierMedical> getAllDossiersMedicaux() {
        return this.restTemplate.exchange(
                "http://dossier-medical-service/api/dossier-medical/all",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<DossierMedical>>() {}
        ).getBody();
    }

    public List<DossierMedical> fallbackGetAllDossiersMedicaux() {
        System.err.println("Fallback: Unable to fetch dossiers medicaux list");
        return Collections.emptyList();
    }

    @HystrixCommand(fallbackMethod = "fallbackGetDossierMedicalById")
    @RequestMapping(value = "/api/dossier-medical/getDossierMedical/{id}", method = RequestMethod.GET)
    public DossierMedical getDossierMedicalById(@PathVariable int id) {
        return this.restTemplate.exchange(
                "http://dossier-medical-service/api/dossier-medical/getDossierMedical/{id}",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<DossierMedical>() {},
                id
        ).getBody();
    }

    public DossierMedical fallbackGetDossierMedicalById(@PathVariable int id) {
        System.err.println("Fallback: No dossier medical available for ID " + id);
        return new DossierMedical(); // Retourne un dossier medical vide
    }

    @HystrixCommand(fallbackMethod = "fallbackGetDossierMedicalByPatient")
    @RequestMapping(value = "/api/dossier-medical/getDossierMedicalByPatient/{idPatient}", method = RequestMethod.GET)
    public DossierMedical getDossierMedicalByPatient(@PathVariable int idPatient) {
        return this.restTemplate.exchange(
                "http://dossier-medical-service/api/dossier-medical/getDossierMedicalByPatient/{idPatient}",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<DossierMedical>() {},
                idPatient
        ).getBody();
    }

    public DossierMedical fallbackGetDossierMedicalByPatient(int idPatient) {
        System.err.println("Fallback: No dossier medical available for patient ID " + idPatient);
        return new DossierMedical(); // Retourne un dossier medical vide
    }

    @HystrixCommand(fallbackMethod = "fallbackCreateDossierMedical")
    @RequestMapping(value = "/api/dossier-medical/create/{idPatient}/{diagnostic}", method = RequestMethod.POST)
    public DossierMedical createDossierMedical(
            @PathVariable int idPatient,
            @PathVariable String diagnostic) {
        return this.restTemplate.exchange(
                "http://dossier-medical-service/api/dossier-medical/create/{idPatient}/{diagnostic}",
                HttpMethod.POST,
                null,
                new ParameterizedTypeReference<DossierMedical>() {},
                idPatient,
                diagnostic
        ).getBody();
    }

    public DossierMedical fallbackCreateDossierMedical(int idPatient, String diagnostic) {
        System.err.println("Fallback: Could not create dossier medical for patient ID " + idPatient);
        return new DossierMedical(); // Retourne un dossier medical vide
    }

    @HystrixCommand(fallbackMethod = "fallbackUpdateDossierMedical")
    @RequestMapping(value = "/api/dossier-medical/update/{id}", method = RequestMethod.PUT)
    public DossierMedical updateDossierMedical(
            @PathVariable int id,
            @RequestBody DossierMedical updatedDossierMedical) {
        HttpEntity<DossierMedical> requestEntity = new HttpEntity<>(updatedDossierMedical);
        return this.restTemplate.exchange(
                "http://dossier-medical-service/api/dossier-medical/update/{id}",
                HttpMethod.PUT,
                requestEntity,
                new ParameterizedTypeReference<DossierMedical>() {},
                id
        ).getBody();
    }

    public DossierMedical fallbackUpdateDossierMedical(int id, DossierMedical updatedDossierMedical) {
        System.err.println("Fallback: Could not update dossier medical with ID " + id);
        return new DossierMedical(); // Retourne un dossier medical vide
    }

    @HystrixCommand(fallbackMethod = "fallbackDeleteDossierMedical")
    @RequestMapping(value = "/api/dossier-medical/delete/{id}", method = RequestMethod.DELETE)
    public Boolean deleteDossierMedical(@PathVariable int id) {
        this.restTemplate.exchange(
                "http://dossier-medical-service/api/dossier-medical/delete/{id}",
                HttpMethod.DELETE,
                null,
                new ParameterizedTypeReference<Boolean>() {},
                id
        );
        return true;
    }

    public Boolean fallbackDeleteDossierMedical(int id) {
        System.err.println("Fallback: Could not delete dossier medical with ID " + id);
        return false;
    }
}
