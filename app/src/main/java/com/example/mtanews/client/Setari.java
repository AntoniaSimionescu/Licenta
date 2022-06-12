package com.example.mtanews.client;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mtanews.R;
import com.example.mtanews.core.URLs;
import com.example.mtanews.core.UserData;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class Setari extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setari);

        Button inapoi = findViewById(R.id.btninapoi);
        Button reseteaza = findViewById(R.id.buttonResetareClient);
        inapoi.setOnClickListener(v -> {
            Intent intent = new Intent(Setari.this, Client.class);
            startActivity(intent);
        });

        reseteaza.setOnClickListener(v -> {
            EditText ParolaVeche = findViewById(R.id.parola_client);
            EditText ParolaNoua = findViewById(R.id.parola_noua_client);
            EditText ParolaConfirm = findViewById(R.id.parola_confirmata_client);

            String utilizator = UserData.GetInstance().getUtilizator();
            String parolaVeche = ParolaVeche.getText().toString();
            String parolaNoua = ParolaNoua.getText().toString();
            String parolaConfirm = ParolaConfirm.getText().toString();

            if (parolaVeche.isEmpty() || parolaNoua.isEmpty() || parolaConfirm.isEmpty()){
                Toast.makeText(getApplicationContext(), "Toate câmpurile sunt obligatorii", Toast.LENGTH_SHORT).show();
            } else {
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(() -> {
                   String[] field = new String[4];
                   field[0] ="utilizator";
                   field[1] = "parola";
                   field[2] = "parolaNoua";
                   field[3] = "parolaConfirm";
                   String[] data = new String[4];
                   data[0] = utilizator;
                   data[1] = parolaVeche;
                   data[2] = parolaNoua;
                   data[3] = parolaConfirm;
                   PutData putData = new PutData(URLs.CHANGEPASS_URL,"POST", field, data);
                   if (putData.startPut()){
                       if (putData.onComplete()) {
                           String result = putData.getResult();
                           Log.d("mesaj",result);
                           Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                           if(result.equals("Parola modificata cu succes!")) {
                               Intent intent = new Intent(getApplicationContext(),Client.class);
                               startActivity(intent);
                               finish();
                           }
                       }
                   }
                });

            }

        });
    }
}