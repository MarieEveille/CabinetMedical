package org.example.patient.models;

public class Patient {

    private int idPatient;

    private static int count = 0;
    private String name;

    private String firstName;

    private String email;
    private String phone;
    private String address;



    public Patient() {
        count++;
        this.idPatient = count;
    }

    public Patient(String name, String firstName, String email, String phone, String address) {
        this.idPatient = count;
        count++;
        this.name = name;
        this.firstName = firstName;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public int getId() {
        return idPatient;
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
