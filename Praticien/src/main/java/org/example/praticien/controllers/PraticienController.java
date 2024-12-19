package org.example.praticien.controllers;


import org.example.praticien.models.Praticien;
import org.example.praticien.services.PraticienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/praticiens")
public class PraticienController {


    @Autowired
    private PraticienService praticienService;

    private final List<Praticien> praticiens = new ArrayList<>(List.of(
            new Praticien("Dupont", "Jean", "dupont.jean@mail.com", "0102030405", "10 rue des Lilas"),
            new Praticien("Durand", "Marie", "durand.marie@mail.com", "0607080910", "20 avenue des Roses"),
            new Praticien("Martin", "Pierre", "martin.pierre@mail.com", "0203040506", "30 rue des Lilas")
    ));

    @GetMapping("/all")
    public List<Praticien> getAllPraticiens() {
        return praticienService.getAllPraticiens(praticiens);
    }

    @GetMapping("/getPraticien/{id}")
    public String getPraticienById(@PathVariable int id) {
        return praticienService.getPraticienById(praticiens, id);
    }

    @PostMapping("/create")
    public Praticien createPraticien(@RequestBody Praticien praticien) {
        return praticienService.createPraticien(praticiens, praticien);
    }

    @PutMapping("/update/{id}")
    public Praticien updatePraticien(@PathVariable int id, @RequestBody Praticien updatedPraticien) {
        return praticienService.updatePraticien(praticiens, id, updatedPraticien);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deletePraticien(@PathVariable int id) {
        praticienService.deletePraticien(praticiens, id);
        return true;
    }
}
