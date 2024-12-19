package org.example.patient.services;


import org.example.patient.models.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    public List<Patient> getAllPatients(List<Patient> patients) {
        return patients;
    }

    public Patient getPatientById(List<Patient> patients, int id) {
        return patients.stream()
                .filter(patient -> patient.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Patient introuvable avec l'ID : " + id));
    }

    public Patient createPatient(List<Patient> patients, Patient patient) {
        patients.add(patient);
        return patient;
    }

    public Patient updatePatient(List<Patient> patients, int id, Patient updatedPatient) {
        Patient existingPatient = getPatientById(patients, id);
        existingPatient.setName(updatedPatient.getName());
        existingPatient.setFirstName(updatedPatient.getFirstName());
        existingPatient.setEmail(updatedPatient.getEmail());
        existingPatient.setPhone(updatedPatient.getPhone());
        existingPatient.setAddress(updatedPatient.getAddress());
        return existingPatient;
    }

    public void deletePatient(List<Patient> patients, int id) {
        Patient patient = getPatientById(patients, id);
        patients.remove(patient);
    }
}
