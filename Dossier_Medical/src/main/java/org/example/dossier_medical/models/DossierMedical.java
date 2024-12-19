package org.example.dossier_medical.models;

import java.util.List;

public class DossierMedical {

    private int idDossierMedical;
    private static int count = 0;
    private int idPatient;
    private String diagnostic;



    public DossierMedical(int idPatient, String diagnostic) {
        System.out.println("DossierMedical constructor 1");
        this.idDossierMedical = count;
        count++;
        this.idPatient = idPatient;
        this.diagnostic = diagnostic;
    }

    public DossierMedical() {
        System.out.println("DossierMedical constructor 0");
        this.idDossierMedical = count;
        count++;

    }

    public int getId() {
        return idDossierMedical;
    }

    public int getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }



}
