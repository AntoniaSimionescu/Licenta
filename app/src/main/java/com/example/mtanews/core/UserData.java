package com.example.mtanews.core;

public class UserData {

    /**
     * Get the user instance which contains data about authenticate user.
     * @return
     */
    public static UserData GetInstance(){
        if (instance == null)
            instance = new UserData();

        return instance;
    }

    public  static  void DisconnectInstance(){
        instance = null;
    }

    private  static  UserData instance;

    private String nume;
    private String prenume;
    private String email;
    private String batalion;
    private String facultate;

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
