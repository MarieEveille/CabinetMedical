package org.example.gateway.controllers;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.example.gateway.models.Rendezvous;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@RestController
public class RendezvousController {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallbackGetAllRendezvous")
    @RequestMapping(value = "/api/rendezvous/all", method = RequestMethod.GET)
    public List<Rendezvous> getAllRendezvous() {
        try {
            return this.restTemplate.exchange(
                    "http://rendez-vous-service/api/rendezvous/all",
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<Rendezvous>>() {}
            ).getBody();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public List<Rendezvous> fallbackGetAllRendezvous() {
        System.err.println("Fallback: Unable to fetch rendezvous list");
        return Collections.emptyList();
    }

    @HystrixCommand(fallbackMethod = "fallbackGetRendezvousById")
    @RequestMapping(value = "/api/rendezvous/getRendezvous/{id}", method = RequestMethod.GET)
    public Rendezvous getRendezvousById(@PathVariable int id) {
        return this.restTemplate.exchange(
                "http://rendez-vous-service/api/rendezvous/getRendezvous/{id}",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Rendezvous>() {},
                id
        ).getBody();
    }

    public Rendezvous fallbackGetRendezvousById(int id) {
        System.err.println("Fallback: No rendezvous available for ID " + id);
        return new Rendezvous(); // Retourne un rendezvous vide
    }

    @HystrixCommand(fallbackMethod = "fallbackGetRendezvousByPatient")
    @RequestMapping(value = "/api/rendezvous/getRendezvousByPatient/{idPatient}", method = RequestMethod.GET)
    public List<Rendezvous> getRendezvousByPatient(@PathVariable int idPatient) {
        return this.restTemplate.exchange(
                "http://rendez-vous-service/api/rendezvous/getRendezvousByPatient/{idPatient}",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Rendezvous>>() {},
                idPatient
        ).getBody();
    }

    public List<Rendezvous> fallbackGetRendezvousByPatient(int idPatient) {
        System.err.println("Fallback: No rendezvous available for patient ID " + idPatient);
        return Collections.emptyList();
    }

    @HystrixCommand(fallbackMethod = "fallbackGetRendezvousByPraticien")
    @RequestMapping(value = "/api/rendezvous/getRendezvousByPraticien/{idPraticien}", method = RequestMethod.GET)
    public List<Rendezvous> getRendezvousByPraticien(@PathVariable int idPraticien) {
        return this.restTemplate.exchange(
                "http://rendez-vous-service/api/rendezvous/getRendezvousByPraticien/{idPraticien}",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Rendezvous>>() {},
                idPraticien
        ).getBody();
    }

    public List<Rendezvous> fallbackGetRendezvousByPraticien(int idPraticien) {
        System.err.println("Fallback: No rendezvous available for praticien ID " + idPraticien);
        return Collections.emptyList();
    }

    @HystrixCommand(fallbackMethod = "fallbackCreateRendezvous")
    @RequestMapping(value = "/api/rendezvous/create", method = RequestMethod.POST)
    public Rendezvous createRendezvous(@RequestBody Rendezvous rendezvous1) {
        HttpEntity<Rendezvous> requestEntity = new HttpEntity<>(rendezvous1);
        return this.restTemplate.exchange(
                "http://rendez-vous-service/api/rendezvous/create",
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<Rendezvous>() {}
        ).getBody();
    }

    public Rendezvous fallbackCreateRendezvous(Rendezvous rendezvous1) {
        System.err.println("Fallback: Could not create rendezvous " + rendezvous1);
        return new Rendezvous(); // Retourne un rendezvous vide
    }

    @HystrixCommand(fallbackMethod = "fallbackUpdateRendezvous")
    @RequestMapping(value = "/api/rendezvous/update/{id}", method = RequestMethod.PUT)
    public Rendezvous updateRendezvous(@PathVariable int id, @RequestBody Rendezvous updatedRendezvous) {
        HttpEntity<Rendezvous> requestEntity = new HttpEntity<>(updatedRendezvous);
        return this.restTemplate.exchange(
                "http://rendez-vous-service/api/rendezvous/update/{id}",
                HttpMethod.PUT,
                requestEntity,
                new ParameterizedTypeReference<Rendezvous>() {},
                id
        ).getBody();
    }

    public Rendezvous fallbackUpdateRendezvous(int id, Rendezvous updatedRendezvous) {
        System.err.println("Fallback: Could not update rendezvous with ID " + id);
        return new Rendezvous(); // Retourne un rendezvous vide
    }

    @HystrixCommand(fallbackMethod = "fallbackDeleteRendezvous")
    @RequestMapping(value = "/api/rendezvous/delete/{id}", method = RequestMethod.DELETE)
    public Boolean deleteRendezvous(@PathVariable int id) {
        this.restTemplate.exchange(
                "http://rendez-vous-service/api/rendezvous/delete/{id}",
                HttpMethod.DELETE,
                null,
                new ParameterizedTypeReference<Boolean>() {},
                id
        );
        return true;
    }

    public Boolean fallbackDeleteRendezvous(int id) {
        System.err.println("Fallback: Could not delete rendezvous with ID " + id);
        return false;
    }
}
