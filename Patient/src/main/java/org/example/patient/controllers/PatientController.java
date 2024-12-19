package org.example.patient.controllers;


import org.example.patient.models.DossierMedical;
import org.example.patient.models.Patient;
import org.example.patient.services.DossierMedicalClient;
import org.example.patient.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final DossierMedicalClient dossierMedicalClient;

    @Autowired
    private PatientService patientService;

    public PatientController(DossierMedicalClient dossierMedicalClient) {
        this.dossierMedicalClient = dossierMedicalClient;
    }

    @GetMapping("/getDossierMedicalFromPatient/{id}")
    public DossierMedical getDossierMedicalFromPatient(@PathVariable int id) {
        return dossierMedicalClient.getDossierMedicalById(id);
    }

    // Liste en mémoire
    private final List<Patient> patients = new ArrayList<>();

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

    @GetMapping("/{id}")
    public boolean isPatientExists(@PathVariable int id) {
        return patients.stream().anyMatch(patient -> patient.getId() == id);
    }
}
