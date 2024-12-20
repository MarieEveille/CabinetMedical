package org.example.dossier_medical.controllers;


import org.example.dossier_medical.models.DossierMedical;
import org.example.dossier_medical.services.DossierMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/dossier-medical")
public class DossierMedicalController {

    @Autowired
    private DossierMedicalService dossierMedicalService;

    private final List<DossierMedical> dossiersMedicaux = new ArrayList<>();

    @GetMapping("/all")
    public List<DossierMedical> getAllDossiersMedicaux() {
        return dossierMedicalService.getAllDossiersMedicaux(dossiersMedicaux);
    }

    @GetMapping("/getDossierMedical/{id}")
    public DossierMedical getDossierMedicalById(@PathVariable int id) {
        return dossierMedicalService.getDossierMedicalById(dossiersMedicaux, id);
    }

    @GetMapping("/getDossierMedicalByPatient/{idPatient}")
    public DossierMedical getDossierMedicalByPatient(@PathVariable int idPatient) {
        return dossierMedicalService.getDossierMedicalByPatient(dossiersMedicaux, idPatient);
    }

    @PostMapping("/create/{idPatient}/{diagnostic}")
    public DossierMedical createDossierMedical(@PathVariable int idPatient, @PathVariable String diagnostic) {
        return dossierMedicalService.createDossierMedical(dossiersMedicaux, idPatient, diagnostic);
    }

    @PutMapping("/update/{id}")
    public DossierMedical updateDossierMedical(@PathVariable int id, @RequestBody DossierMedical updatedDossierMedical) {
        return dossierMedicalService.updateDossierMedical(dossiersMedicaux, id, updatedDossierMedical);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteDossierMedical(@PathVariable int id) {
        dossierMedicalService.deleteDossierMedical(dossiersMedicaux, id);
        return true;
    }


}
