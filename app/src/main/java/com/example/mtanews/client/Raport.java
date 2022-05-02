package com.example.mtanews.client;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mtanews.R;

public class Raport extends AppCompatActivity {

    public static String raport;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raport);

        Button inapoi = findViewById(R.id.btninapoi);
        Button raport_permisie = findViewById(R.id.raport_permisie);
        Button raport_invoire = findViewById(R.id.raport_invoire);
        Button raport_descazarmare = findViewById(R.id.raport_descazarmare);
        Button raport_parasire_tara = findViewById(R.id.raport_parasire_tara);
        Button raport_decontare_medicamente = findViewById(R.id.raport_decontare_medicamente);
        Button raport_revendicare_laptop = findViewById(R.id.raport_revendicare_laptop);
        Button raport_transport_laptop = findViewById(R.id.raport_transport_laptop);
        Button raport_restanta = findViewById(R.id.raport_restanta);
        Button raport_contestatie = findViewById(R.id.raport_contestatie);
        Button raport_transfer = findViewById(R.id.raport_transfer);
        Button raport_emitere_documente = findViewById(R.id.raport_emitere_documente);
        Button raport_adeverinta_student = findViewById(R.id.raport_adeverinta_student);

        inapoi.setOnClickListener(v -> {
            Intent intent = new Intent(Raport.this, Client.class);
            startActivity(intent);
        });
        raport_permisie.setOnClickListener(v -> {
            Intent intent = new Intent(Raport.this, PDFActivity.class);
            raport = "raport_permisie";
            startActivity(intent);
        });
        raport_invoire.setOnClickListener(v -> {
            Intent intent = new Intent(Raport.this, PDFActivity.class);
            raport = "raport_invoire";
            startActivity(intent);
        });
        raport_descazarmare.setOnClickListener(v -> {
            Intent intent = new Intent(Raport.this, PDFActivity.class);
            raport = "raport_descazarmare";
            startActivity(intent);
        });
        raport_parasire_tara.setOnClickListener(v -> {
            Intent intent1 = new Intent(Raport.this, PDFActivity.class);
            raport = "raport_parasire_tara";
            startActivity(intent1);
        });
        raport_decontare_medicamente.setOnClickListener(v -> {
            Intent intent1 = new Intent(Raport.this, PDFActivity.class);
            raport = "raport_decontare_medicamente";
            startActivity(intent1);
        });
        raport_revendicare_laptop.setOnClickListener(v -> {
            Intent intent1 = new Intent(Raport.this, PDFActivity.class);
            raport = "raport_revendicare_laptop";
            startActivity(intent1);
        });
        raport_transport_laptop.setOnClickListener(v -> {
            Intent intent1 = new Intent(Raport.this, PDFActivity.class);
            raport = "raport_transport_laptop";
            startActivity(intent1);
        });
        raport_restanta.setOnClickListener(v -> {
            Intent intent1 = new Intent(Raport.this, PDFActivity.class);
            raport = "raport_restanta";
            startActivity(intent1);
        });
        raport_contestatie.setOnClickListener(v -> {
            Intent intent1 = new Intent(Raport.this, PDFActivity.class);
            raport = "raport_contestatie";
            startActivity(intent1);
        });
        raport_transfer.setOnClickListener(v -> {
            Intent intent1 = new Intent(Raport.this, PDFActivity.class);
            raport = "raport_transfer";
            startActivity(intent1);
        });
        raport_emitere_documente.setOnClickListener(v -> {
            Intent intent1 = new Intent(Raport.this, PDFActivity.class);
            raport = "raport_emitere_documente";
            startActivity(intent1);
        });
        raport_adeverinta_student.setOnClickListener(v -> {
            Intent intent1 = new Intent(Raport.this, PDFActivity.class);
            raport = "raport_adeverinta_student";
            startActivity(intent1);
        });
    }
}