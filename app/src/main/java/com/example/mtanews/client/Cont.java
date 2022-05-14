package com.example.mtanews.client;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mtanews.Autentificare;
import com.example.mtanews.R;
import com.example.mtanews.core.UserData;

public class Cont extends AppCompatActivity {

    public String batalion, facultate, email, nume, prenume, numeprenume;
    TextView nume_txt, email_txt, email_txt2, prenume_txt, numeprenume_txt, batalion_txt, facultate_txt;

    @SuppressLint({"CutPasteId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cont);


        Button inapoi = findViewById(R.id.btninapoi);
        batalion = UserData.GetInstance().getBatalion();
        facultate = UserData.GetInstance().getFacultate();
        email = UserData.GetInstance().getEmail();
        nume = UserData.GetInstance().getNume();
        prenume = UserData.GetInstance().getPrenume();

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

        inapoi.setOnClickListener(v -> {
            Intent intent = new Intent(Cont.this, Client.class);
            startActivity(intent);
        });
        switch (batalion){
            case "I":
                batalion_txt.setText("Batalionul I Studenți"); break;
            case "II":
                batalion_txt.setText("Batalionul II Studenți"); break;
            case "III":
                batalion_txt.setText("Batalionul III Studenți"); break;
            case "IV":
                batalion_txt.setText("Batalionul IV Studenți"); break;
        }
        switch (facultate){
            case "A":
                facultate_txt.setText("Facultatea de Aeronave și Autovehicule Militare"); break;
            case "B":
                facultate_txt.setText("Facultatea de Sisteme Integrate de Armament, Geniu și Mecatronică"); break;
            case "C":
                facultate_txt.setText("Facultatea de Sisteme Informatice și Securitate Cibernetică"); break;
            case "E":
                facultate_txt.setText("Facultatea de Comunicații și Sisteme Electronice pentru Apărare și Securitate"); break;
        }







    }
}