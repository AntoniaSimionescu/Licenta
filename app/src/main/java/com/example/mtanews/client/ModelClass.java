package com.example.mtanews.client;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.mtanews.AESCryptoManager;
import com.example.mtanews.admin.RedactareStire;

import java.util.Map;

public class ModelClass {

    private String autor;
    private String descriere;
    private String titlu;
    private String stire;
    private String data;

    String secret = RedactareStire.secret;


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

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String getAutor() {
        return AESCryptoManager.decrypt(autor, secret);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String getDescriere() {
        return AESCryptoManager.decrypt(descriere, secret);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String getTitlu() {
        return AESCryptoManager.decrypt(titlu, secret);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String getStire() {
        return AESCryptoManager.decrypt(stire, secret);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String getData() {
        return AESCryptoManager.decrypt(data, secret);
    }

}

