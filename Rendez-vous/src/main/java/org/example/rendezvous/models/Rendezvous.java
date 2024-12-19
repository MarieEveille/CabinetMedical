package org.example.rendezvous.models;

public class Rendezvous {

    private int idRendezvous;

    private static int count = 0;

    private int idPatient;

    private int idPraticien;

    private String date;

    private String heure;

    public Rendezvous() {
        this.idRendezvous = count;
        count++;
    }

    public Rendezvous(int idPatient, int idPraticien, String date, String heure) {
        this.idRendezvous = count;
        count++;
        this.idPatient = idPatient;
        this.idPraticien = idPraticien;
        this.date = date;
        this.heure = heure;
    }

    public int getId() {
        return idRendezvous;
    }

    public int getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    public int getIdPraticien() {
        return idPraticien;
    }

    public void setIdPraticien(int idPraticien) {
        this.idPraticien = idPraticien;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }
}
