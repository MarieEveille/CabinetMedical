package org.example.patient.controllers;


import org.example.patient.models.Patient;
import org.example.patient.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;



    // Liste en mémoire
    private final List<Patient> patients = new ArrayList<>(List.of(
            new Patient("Dupont", "Jean", "jean.dupont@example.com", "0102030405", "10 rue des Lilas"),
            new Patient("Durand", "Marie", "marie.durand@example.com", "0607080910", "20 avenue des Roses")
    ));

    @GetMapping("/all")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients(patients);
    }

    @GetMapping("/getPatient/{id}")
    public Patient getPatientById(@PathVariable int id) {
        return patientService.getPatientById(patients, id);
    }

    @PostMapping("/create")
    public Patient createPatient(@RequestBody Patient patient) {
        return patientService.createPatient(patients, patient);
    }

    @PutMapping("/update/{id}")
    public Patient updatePatient(@PathVariable int id, @RequestBody Patient updatedPatient) {
        return patientService.updatePatient(patients, id, updatedPatient);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deletePatient(@PathVariable int id) {
        patientService.deletePatient(patients, id);
        return true;
    }
}
