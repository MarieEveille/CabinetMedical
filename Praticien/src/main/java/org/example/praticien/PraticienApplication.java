package org.example.praticien;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PraticienApplication {

    public static void main(String[] args) {
        SpringApplication.run(PraticienApplication.class, args);
    }

}
