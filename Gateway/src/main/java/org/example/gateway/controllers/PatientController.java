package org.example.gateway.controllers;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.example.gateway.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@RestController
public class PatientController {

    @Autowired
    private RestTemplate restTemplate;


    // Get all patients
    @HystrixCommand(fallbackMethod = "fallbackGetAllPatients")
    @RequestMapping(value = "/api/patients/all", method = RequestMethod.GET)
    public List<Patient> getAllPatients() {
        return this.restTemplate.exchange(
                "http://patient-service/api/patients/all",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Patient>>() {}
        ).getBody();
    }

    // Fallback for getAllPatients
    public List<Patient> fallbackGetAllPatients() {
        System.err.println("Fallback: Unable to fetch patients list");
        return Collections.emptyList();
    }

    // Get patient by ID
    @HystrixCommand(fallbackMethod = "fallbackGetPatientById")
    @RequestMapping(value = "/api/patients/getPatient/{id}", method = RequestMethod.GET)
    public Patient getPatientById(@PathVariable int id) {
        return this.restTemplate.exchange(
                "http://patient-service/api/patients/getPatient/{id}",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Patient>() {},
                id
        ).getBody();
    }

    // Fallback for getPatientById
    public Patient fallbackGetPatientById(int id) {
        System.err.println("Fallback: No patient available for ID " + id);
        return new Patient(); // Retourne un patient vide
    }

    // Create patient
    @HystrixCommand(fallbackMethod = "fallbackCreatePatient")
    @RequestMapping(value = "/api/patients/create", method = RequestMethod.POST)
    public Patient createPatient(@RequestBody Patient patient) {
        HttpEntity<Patient> requestEntity = new HttpEntity<>(patient);
        return this.restTemplate.exchange(
                "http://patient-service/api/patients/create",
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<Patient>() {}
        ).getBody();
    }

    // Fallback for createPatient
    public Patient fallbackCreatePatient(Patient patient) {
        System.err.println("Fallback: Could not create patient " + patient);
        return new Patient(); // Retourne un patient vide
    }

    // Update patient
    @HystrixCommand(fallbackMethod = "fallbackUpdatePatient")
    @RequestMapping(value = "/api/patients/update/{id}", method = RequestMethod.PUT)
    public Patient updatePatient(@PathVariable int id, @RequestBody Patient updatedPatient) {
        HttpEntity<Patient> requestEntity = new HttpEntity<>(updatedPatient);
        return this.restTemplate.exchange(
                "http://patient-service/api/patients/update/{id}",
                HttpMethod.PUT,
                requestEntity,
                new ParameterizedTypeReference<Patient>() {},
                id
        ).getBody();
    }

    // Fallback for updatePatient
    public Patient fallbackUpdatePatient(int id, Patient updatedPatient) {
        System.err.println("Fallback: Could not update patient with ID " + id);
        return new Patient(); // Retourne un patient vide
    }

    // Delete patient
    @HystrixCommand(fallbackMethod = "fallbackDeletePatient")
    @RequestMapping(value = "/api/patients/delete/{id}", method = RequestMethod.DELETE)
    public Boolean deletePatient(@PathVariable int id) {
        return this.restTemplate.exchange(
                "http://patient-service/api/patients/delete/{id}",
                HttpMethod.DELETE,
                null,
                new ParameterizedTypeReference<Boolean>() {},
                id
        ).getBody();
    }

    // Fallback for deletePatient
    public Boolean fallbackDeletePatient(int id) {
        System.err.println("Fallback: Could not delete patient with ID " + id);
        return false; // Retourne faux en cas d'erreur
    }
}
