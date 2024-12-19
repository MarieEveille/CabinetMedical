package org.example.dossier_medical;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class PatientServiceClient {
    private static WebClient webClient = null;

    public PatientServiceClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8080/api/patients").build(); // Replace with the actual URL
    }

    public static boolean isPatientExists(int idPatient) {
        return Boolean.TRUE.equals(webClient.get()
                .uri("/{id}", idPatient)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block()); // Blocking call for simplicity
    }
}

