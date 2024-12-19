package org.example.rendezvous.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CalendarificService {

    private static final String API_KEY = "JLu4KnZtB1DhMOIeJh30CiAMb7qqpUcs"; // Remplacez par votre clé d'API
    private static final String BASE_URL = "https://calendarific.com/api/v2/holidays";

    public static String getHolidays(String country, String year) {
        String url = String.format("%s?api_key=%s&country=%s&year=%s", BASE_URL, API_KEY, country, year);

        RestTemplate restTemplate = new RestTemplate();
        try {
            return restTemplate.getForObject(url, String.class);
        } catch (Exception e) {
            e.printStackTrace();
            return "Erreur lors de la récupération des données depuis Calendarific.";
        }
    }
}

