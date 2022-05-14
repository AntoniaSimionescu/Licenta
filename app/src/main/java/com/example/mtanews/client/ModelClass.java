package com.example.mtanews.client;

import java.util.Map;

public class ModelClass {

    private String autor;
    private String descriere;
    private String titlu;
    private String stire;
    private String data;


    public static ModelClass getInstance() {
        if (instance == null)
            instance = new ModelClass();


        return instance;
    }

    private static ModelClass instance;

    public ModelClass() {
    }

    public ModelClass(String autor, String descriere, String titlu, String stire, String data) {
        this.autor = autor;
        this.descriere = descriere;
        this.titlu = titlu;
        this.stire = stire;
        this.data = data;
    }


    public void setData(String data) {
        this.data = data;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public void setStire(String stire) {
        this.stire = stire;
    }

    public String getAutor() {
        return autor;
    }

    public String getDescriere() {
        return descriere;
    }

    public String getTitlu() {
        return titlu;
    }

    public String getStire() {
        return stire;
    }

    public String getData() {
        return data;
    }

}

