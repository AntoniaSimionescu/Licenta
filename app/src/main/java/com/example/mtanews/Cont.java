package com.example.mtanews;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Cont extends AppCompatActivity {

    public String batalion, facultate, email, nume, prenume, numeprenume;
    TextView nume_txt, email_txt, email_txt2, prenume_txt, numeprenume_txt, batalion_txt, facultate_txt;
    @SuppressLint({"CutPasteId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cont);

        batalion = Autentificare.batalion;
        facultate = Autentificare.facultate;
        email = Autentificare.email;
        nume = Autentificare.nume;
        prenume = Autentificare.prenume;

        numeprenume_txt = findViewById(R.id.numeprenume_cont);
        email_txt = findViewById(R.id.email_cont);
        email_txt2 = findViewById(R.id.email_cont2);
        nume_txt = findViewById(R.id.nume_cont);
        prenume_txt = findViewById(R.id.prenume_cont);
        batalion_txt = findViewById(R.id.batalion_cont);
        facultate_txt = findViewById(R.id.facultate_cont);

        numeprenume = nume + " " + prenume;
        numeprenume_txt.setText(numeprenume);
        email_txt.setText(email);
        email_txt2.setText(email);
        nume_txt.setText(nume);
        prenume_txt.setText(prenume);

        switch (batalion){
            case "I":
                batalion_txt.setText("I Studenti"); break;
            case "II":
                batalion_txt.setText("II Studenti"); break;
            case "III":
                batalion_txt.setText("III Studenti"); break;
            case "IV":
                batalion_txt.setText("IV Studenti"); break;
        }
        switch (facultate){
            case "A":
                facultate_txt.setText("Facultatea de Aeronave si Autovehicule Militare"); break;
            case "B":
                facultate_txt.setText("Facultatea de Sisteme Integrate de Armament, Geniu si Mecatronica"); break;
            case "C":
                facultate_txt.setText("Facultatea de Sisteme Informatice si Securitate Cibernetica"); break;
            case "E":
                facultate_txt.setText("Facultatea de Comunicatii si Sisteme Electronice pentru Aparare si Securitate"); break;
        }







    }
}