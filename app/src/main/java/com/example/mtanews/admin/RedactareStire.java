package com.example.mtanews.admin;

import androidx.appcompat.app.AppCompatActivity;
import com.example.mtanews.R;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class RedactareStire extends AppCompatActivity {

    String idbatalion;
    TextView idbatalion_txt;
    Button buttonInapoi;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redactare_stire);

        idbatalion_txt = findViewById(R.id.textcategorie);
        idbatalion = Admin.idbatalion;
        switch (idbatalion)
        {
            case "Batalionul 1 Studenți":
                idbatalion_txt.setText("Batalionul I Studenți");
                break;
            case "Batalionul 2 Studenți":
                idbatalion_txt.setText("Batalionul II Studenți");
                break;
            case "Batalionul 3 Studenți":
                idbatalion_txt.setText("Batalionul III Studenți");
                break;
            case "Batalionul 4 Studenți":
                idbatalion_txt.setText("Batalionul IV Studenți");
                break;
            case "Facultatea A":
                idbatalion_txt.setText("Facultatea de Aeronave si Autovehicule Militare");
                break;
            case "Facultatea B":
                idbatalion_txt.setText("Facultatea de Sisteme Integrate de Armament, Geniu și Mecatronică");
                break;
            case "Facultatea C":
                idbatalion_txt.setText("Facultatea de Sisteme Informatice și Securitate Cibernetică");
                break;
            case "Facultatea E":
                idbatalion_txt.setText("Facultatea de Comunicații și Sisteme Electronice pentru Aparare și Securitate");
                break;
            case "Interes General":
                idbatalion_txt.setText("Interes General");
                break;
            case "As Atm":
                idbatalion_txt.setText("AS ATM");
                break;
            case "Cabinet Medical":
                idbatalion_txt.setText("Cabinet Medical");
                break;
            case "Sport":
                idbatalion_txt.setText("Sport");
                break;
        }
        buttonInapoi = findViewById(R.id.buttonInapoi);
        buttonInapoi.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Admin.class);
            startActivity(intent);
        });
    }
}