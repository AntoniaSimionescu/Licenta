package com.example.mtanews.client;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.mtanews.R;
import com.github.barteksc.pdfviewer.PDFView;

public class PDFActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfactivity);

        String raport = Raport.raport;
        Button inapoi = findViewById(R.id.btninapoi);
        PDFView pdfView = findViewById(R.id.pdfView);

        inapoi.setOnClickListener(v -> {
            Intent intent = new Intent(PDFActivity.this, Raport.class);
            startActivity(intent);
        });

        if (raport.equals("raport_permisie"))
            pdfView.fromAsset("Raport permisie.pdf").load();
        if (raport.equals("raport_invoire"))
            pdfView.fromAsset("Raport invoire.pdf").load();
        if (raport.equals("raport_descazarmare"))
            pdfView.fromAsset("Raport descazarmare.pdf").load();
        if (raport.equals("raport_parasire_tara"))
            pdfView.fromAsset("Raport parasire tara.pdf").load();
        if (raport.equals("raport_decontare_medicamente"))
            pdfView.fromAsset("Raport decontare medicamente.pdf").load();
        if (raport.equals("raport_revendicare_laptop"))
            pdfView.fromAsset("Raport laptop.pdf").load();
        if (raport.equals("raport_transport_laptop"))
            pdfView.fromAsset("Raport transport laptop.pdf").load();
        if (raport.equals("raport_restanta"))
            pdfView.fromAsset("Raport restanta.pdf").load();
        if (raport.equals("raport_contestatie"))
            pdfView.fromAsset("Raport contestatie.pdf").load();
        if (raport.equals("raport_transfer"))
            pdfView.fromAsset("Raport transfer.pdf").load();
        if (raport.equals("raport_emitere_documente"))
            pdfView.fromAsset("Raport emitere documente.pdf").load();
        if (raport.equals("raport_adeverinta_student"))
            pdfView.fromAsset("Raport adeverinta student.pdf").load();
    }
}