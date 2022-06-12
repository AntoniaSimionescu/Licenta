package com.example.mtanews.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mtanews.R;
import com.example.mtanews.client.Client;
import com.example.mtanews.core.URLs;
import com.example.mtanews.core.UserData;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class SetariAdmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setari_admin);

        Button reseteaza = findViewById(R.id.buttonResetareAdmin);
        Button inapoi = findViewById(R.id.btninapoi);
        inapoi.setOnClickListener(v -> {
            Intent intent = new Intent(SetariAdmin.this, Admin.class);
            startActivity(intent);
        });
        reseteaza.setOnClickListener(v -> {
            EditText ParolaVeche = findViewById(R.id.parola_admin);
            EditText ParolaNoua = findViewById(R.id.parola_noua_admin);
            EditText ParolaConfirm = findViewById(R.id.parola_confirmata_admin);

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
                                Intent intent = new Intent(getApplicationContext(), Admin.class);
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