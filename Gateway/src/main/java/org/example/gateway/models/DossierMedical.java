package org.example.gateway.models;

public class DossierMedical {

    private int id;
    private static int count = 0;
    private int idPatient;
    private String diagnostic;



    public DossierMedical(int idPatient, String diagnostic) {
        this.id = count;
        count++;
        this.idPatient = idPatient;
        this.diagnostic = diagnostic;
    }

    public DossierMedical() {
        System.out.println("DossierMedical constructor 0");
        this.id = count;
        count++;

    }

    public int getId() {
        return id;
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
