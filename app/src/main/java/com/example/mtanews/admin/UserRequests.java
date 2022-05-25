package com.example.mtanews.admin;

public class UserRequests {

    private String nume;
    private String prenume;
    private String email;
    private String batalion;
    private String facultate;


    UserRequests(String nume,String prenume,String email,String bat,String facultate)
    {
        this.nume = nume;
        this.prenume=prenume;
        this.email = email;
        this.batalion=bat;
        this.facultate = facultate;
    }
    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBatalion() {
        return batalion;
    }

    public void setBatalion(String batalion) {
        this.batalion = batalion;
    }

    public String getFacultate() {
        return facultate;
    }

    public void setFacultate(String facultate) {
        this.facultate = facultate;
    }
}
