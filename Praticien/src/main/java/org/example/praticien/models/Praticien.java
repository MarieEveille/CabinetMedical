package org.example.praticien.models;

public class Praticien {

    private int idPraticien;
    private static int count = 0;
    private String name;
    private String firstName;
    private String email;
    private String phone;
    private String address;

    public Praticien() {
        count++;
        this.idPraticien = count;
    }

    public Praticien(String name, String firstName, String email, String phone, String address) {
        this.idPraticien = count;
        count++;
        this.name = name;
        this.firstName = firstName;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public int getId() {
        return idPraticien;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
