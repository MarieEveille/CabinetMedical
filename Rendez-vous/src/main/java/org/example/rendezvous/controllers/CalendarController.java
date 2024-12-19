package org.example.rendezvous.controllers;

import org.example.rendezvous.services.CalendarificService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calendar")
public class CalendarController {

    @Autowired
    private CalendarificService calendarificService;

    @GetMapping("/holidays")
    public String getHolidays(
            @RequestParam String country,
            @RequestParam String year) {
        return CalendarificService.getHolidays(country, year);
    }
}
