package org.example.rendezvous.models;

import java.time.LocalDateTime;

public class Rendezvous {

    private int idRendezvous;

    private static int count = 0;

    private int idPatient;

    private int idPraticien;

    private LocalDateTime dateHeure;

    public Rendezvous() {
        this.idRendezvous = count;
        count++;
    }

    public Rendezvous(int idPatient, int idPraticien, LocalDateTime date) {
        this.idRendezvous = count;
        count++;
        this.idPatient = idPatient;
        this.idPraticien = idPraticien;
        this.dateHeure = date;
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

    public LocalDateTime getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(LocalDateTime date) {
        this.dateHeure = date;
    }

}
