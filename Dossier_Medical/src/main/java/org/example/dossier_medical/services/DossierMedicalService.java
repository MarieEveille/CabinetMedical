package org.example.dossier_medical.services;


import org.example.dossier_medical.models.DossierMedical;
import org.springframework.stereotype.Service;
import org.example.dossier_medical.PatientServiceClient;

import java.util.List;

@Service
public class DossierMedicalService {

    public List<DossierMedical> getAllDossiersMedicaux(List<DossierMedical> dossiersMedicaux) {
        return dossiersMedicaux;
    }

    public DossierMedical getDossierMedicalById(List<DossierMedical> dossiersMedicaux, int id) {
        return dossiersMedicaux.stream()
                .filter(dossierMedical -> dossierMedical.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Dossier médical introuvable avec l'ID : " + id));
    }

    public DossierMedical getDossierMedicalByPatient(List<DossierMedical> dossiersMedicaux, int idPatient) {
        return dossiersMedicaux.stream()
                .filter(dossierMedical -> dossierMedical.getIdPatient() == idPatient)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Dossier médical introuvable pour le patient avec l'ID : " + idPatient));
    }

    public DossierMedical createDossierMedical(List<DossierMedical> dossiersMedicaux, int idPatient, String diagnostic) {
        if (!PatientServiceClient.isPatientExists(idPatient)) {
            throw new IllegalArgumentException("Patient with id " + idPatient + " does not exist");
        }
        if(dossiersMedicaux.stream().anyMatch(dossierMedical -> dossierMedical.getIdPatient() == idPatient)) {
            throw new IllegalArgumentException("Dossier médical déjà existant pour le patient avec l'ID : " + idPatient);
        }
        DossierMedical dossierMedical = new DossierMedical(idPatient, diagnostic);
        dossiersMedicaux.add(dossierMedical);
        return dossierMedical;
    }

    public DossierMedical updateDossierMedical(List<DossierMedical> dossiersMedicaux, int id, DossierMedical updatedDossierMedical) {
        DossierMedical existingDossierMedical = getDossierMedicalById(dossiersMedicaux, id);
        existingDossierMedical.setDiagnostic(updatedDossierMedical.getDiagnostic());
        return existingDossierMedical;
    }

    public void deleteDossierMedical(List<DossierMedical> dossiersMedicaux, int id) {
        DossierMedical dossierMedical = getDossierMedicalById(dossiersMedicaux, id);
        dossiersMedicaux.remove(dossierMedical);
    }


}
