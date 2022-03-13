package com.example.mtanews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class Autentificare extends AppCompatActivity {

    TextInputEditText textInputEditTextUtilizator, textInputEditTextParola;
    Button buttonLogin;
    TextView textViewCrearecont;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autentificare);

        textInputEditTextUtilizator = findViewById(R.id.utilizator);
        textInputEditTextParola = findViewById(R.id.parola);
        buttonLogin = findViewById(R.id.buttonLogin);
        textViewCrearecont = findViewById(R.id.crearecont);
        progressBar = findViewById(R.id.progress);

        textViewCrearecont.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Creare_cont.class);
            startActivity(intent);
            finish();
        });



        buttonLogin.setOnClickListener(v -> {
            String utilizator, parola;
            utilizator = String.valueOf(textInputEditTextUtilizator.getText());
            parola = String.valueOf(textInputEditTextParola.getText());


            if(!utilizator.equals("") && !parola.equals("")) {

                progressBar.setVisibility(View.VISIBLE);
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(() -> {
                    String[] field = new String[2];
                    field[0] = "utilizator";
                    field[1] = "parola";
                    String[] data = new String[2];
                    data[0] = utilizator;
                    data[1] = parola;
                    PutData putData = new PutData("http://10.10.19.129/LoginRegister/login.php", "POST", field, data);
                    if (putData.startPut()) {
                        if (putData.onComplete()) {
                            progressBar.setVisibility(View.GONE);
                            String result = putData.getResult();
                            if (result.equals("admin")||result.equals("client")){
                                //Toast.makeText(getApplicationContext(),"Autentificare " + result + " cu succes!",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                intent.putExtra("prioritate", result);
                                startActivity(intent);
                                finish();
                            }
                            else {
                                Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
            }
            else {
                Toast.makeText(getApplicationContext(), "Toate campurile sunt obligatorii!", Toast.LENGTH_SHORT).show();
            }
        });


    }
}