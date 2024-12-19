package org.example.praticien.controllers;


import org.example.praticien.models.DossierMedical;
import org.example.praticien.models.Praticien;
import org.example.praticien.services.DossierMedicalClient;
import org.example.praticien.services.PraticienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/praticiens")
public class PraticienController {

    private final DossierMedicalClient dossierMedicalClient;

    @Autowired
    private PraticienService praticienService;

    private final List<Praticien> praticiens = new ArrayList<>();

    public PraticienController(DossierMedicalClient dossierMedicalClient) {
        this.dossierMedicalClient = dossierMedicalClient;
    }

    @GetMapping("/getDossierMedicalFromPraticien/{id}")
    public DossierMedical getDossierMedicalFromPraticien(@PathVariable int id) {
        return dossierMedicalClient.getDossierMedicalById(id);
    }

    @GetMapping("/all")
    public List<Praticien> getAllPraticiens() {
        return praticienService.getAllPraticiens(praticiens);
    }

    @GetMapping("/getPraticien/{id}")
    public Praticien getPraticienById(@PathVariable int id) {
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

    @GetMapping("/{id}")
    public Boolean isPraticienExists(@PathVariable int id) {
        System.out.printf("bool : %b", praticiens.stream().anyMatch(praticien -> praticien.getId() ==id));
        return praticiens.stream().anyMatch(praticien -> praticien.getId() == id);
    }

    @GetMapping("/getDossierForPatient/{id}")
    public DossierMedical getDossierForPatient(@PathVariable int id) {
        return dossierMedicalClient.getDossierMedicalByPatient(id);
    }

    @PostMapping("/createDossierForPatient/{id}/{diagnostic}")
    public DossierMedical createDossierForPatient(@PathVariable int id, @PathVariable String diagnostic) {
        return dossierMedicalClient.createDossierMedical(id, diagnostic);
    }

    @PutMapping("/updateDossierForPatient/{id}")
    public DossierMedical updateDossierForPatient(@PathVariable int id,
                                                  @RequestBody DossierMedical dossierMedical) {
        return dossierMedicalClient.updateDossierMedical(id, dossierMedical);
    }
}
