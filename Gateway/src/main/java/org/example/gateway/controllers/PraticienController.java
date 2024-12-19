package org.example.gateway.controllers;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.example.gateway.models.Praticien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@RestController
public class PraticienController {

    @Autowired
    private RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "fallbackGetAllPraticiens")
    @RequestMapping(value = "/api/praticiens/all", method = RequestMethod.GET)
    public List<Praticien> getAllPraticiens() {
        try {
            return this.restTemplate.exchange(
                    "http://praticien-service/api/praticiens/all",
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<Praticien>>() {}
            ).getBody();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public List<Praticien> fallbackGetAllPraticiens() {
        System.err.println("Fallback: Unable to fetch praticiens list");
        return Collections.emptyList();
    }

    @HystrixCommand(fallbackMethod = "fallbackGetPraticienById")
    @RequestMapping(value = "/api/praticiens/getPraticien/{id}", method = RequestMethod.GET)
    public Praticien getPraticienById(@PathVariable int id) {
        try {
            return this.restTemplate.exchange(
                    "http://praticien-service/api/praticiens/getPraticien/{id}",
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<Praticien>() {},
                    id
            ).getBody();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    }

    public Praticien fallbackGetPraticienById(int id) {
        System.err.println("Fallback: Unable to fetch praticien with id " + id);
        return null;
    }

    @HystrixCommand(fallbackMethod = "fallbackCreatePraticien")
    @RequestMapping(value = "/api/praticiens/create", method = RequestMethod.POST)
    public Praticien createPraticien(@RequestBody Praticien praticien) {
        try {
            HttpEntity<Praticien> requestEntity = new HttpEntity<>(praticien);
            return this.restTemplate.exchange(
                    "http://praticien-service/api/praticiens/create",
                    HttpMethod.POST,
                    requestEntity,
                    new ParameterizedTypeReference<Praticien>() {},
                    praticien
            ).getBody();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    }

    public Praticien fallbackCreatePraticien(Praticien praticien) {
        System.err.println("Fallback: Unable to create praticien");
        return null;
    }

    @HystrixCommand(fallbackMethod = "fallbackUpdatePraticien")
    @RequestMapping(value = "/api/praticiens/update/{id}", method = RequestMethod.PUT)
    public Praticien updatePraticien(@PathVariable int id, @RequestBody Praticien updatedPraticien) {
        try {
            HttpEntity<Praticien> requestEntity = new HttpEntity<>(updatedPraticien);
            return this.restTemplate.exchange(
                    "http://praticien-service/api/praticiens/update/{id}",
                    HttpMethod.PUT,
                    requestEntity,
                    new ParameterizedTypeReference<Praticien>() {},
                    id
            ).getBody();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    }

    public Praticien fallbackUpdatePraticien(int id, Praticien updatedPraticien) {
        System.err.println("Fallback: Unable to update praticien with id " + id);
        return null;
    }

    @HystrixCommand(fallbackMethod = "fallbackDeletePraticien")
    @RequestMapping(value = "/api/praticiens/delete/{id}", method = RequestMethod.DELETE)
    public Boolean deletePraticien(@PathVariable int id) {
        try {
            return this.restTemplate.exchange(
                    "http://praticien-service/api/praticiens/delete/{id}",
                    HttpMethod.DELETE,
                    null,
                    new ParameterizedTypeReference<Boolean>() {},
                    id
            ).getBody();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return false;
        }
    }

    public Boolean fallbackDeletePraticien(int id) {
        System.err.println("Fallback: Unable to delete praticien with id " + id);
        return false;
    }

    @HystrixCommand(fallbackMethod = "fallbackIsPraticienExists")
    @RequestMapping(value = "/api/praticiens/{id}", method = RequestMethod.GET)
    public Boolean isPraticienExists(@PathVariable int id) {
        try {
            return this.restTemplate.exchange(
                    "http://praticien-service/api/praticiens/{id}",
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<Boolean>() {},
                    id
            ).getBody();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return false;
        }
    }

    public Boolean fallbackIsPraticienExists(int id) {
        System.err.println("Fallback: Unable to check if praticien with id " + id + " exists");
        return false;
    }

}
