package org.example.gateway.controllers;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class PatientController {


    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback")
    @RequestMapping(value = "/api/patients/all", method = RequestMethod.GET)
    public List<String> getAllPatients() {

        List<String> response = this.restTemplate.exchange("http://patient-service/api/patients/all"
                , HttpMethod.GET
                , null
                , new ParameterizedTypeReference<List<String>>() {
                }
                , "100")
                .getBody();


        return response;
    }


    // TODO expose fallback method (free impl)
    public String fallback(int employeeid) {
        return "Fallback response: No patient details available";
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
