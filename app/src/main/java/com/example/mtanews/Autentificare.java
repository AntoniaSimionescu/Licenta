package com.example.mtanews;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import java.io.*;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

public class Autentificare extends AppCompatActivity {

    TextInputEditText textInputEditTextUtilizator, textInputEditTextParola;
    Button buttonLogin;
    TextView textViewCrearecont;
    ProgressBar progressBar;
    public static String resultt;
    public static String batalion, facultate, nume, email, prenume, utilizator;



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


            if (!utilizator.equals("") && !parola.equals("")) {

                progressBar.setVisibility(View.VISIBLE);
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
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
                                JSONArray array = null;
                                try {
                                    array = new JSONArray(result);

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                JSONObject object = null;

                                for (int i = 0; i < (array != null ? array.length() : 0); i++) {
                                    try {
                                        object = array.getJSONObject(i);
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                                try {
                                    assert object != null;
                                    Iterator<String> keys = object.keys();
                                    while (keys.hasNext()) {
                                        String key = keys.next();
                                        if (key.equals("mesaj")) {
                                            break;
                                        } else {
                                            Log.d("Fetchx", key + "===" + object.get(key));
                                            resultt = object.get("prioritate").toString();

                                        }
                                    }
                                    batalion = object.get("batalion").toString();
                                    Log.d("bat",batalion);
                                    facultate = object.get("facultate").toString();
                                    Log.d("bat",facultate);
                                    nume = object.get("nume").toString();
                                    Log.d("bat",nume);
                                    email = object.get("email").toString();
                                    Log.d("bat",email);
                                    prenume = object.get("prenume").toString();
                                    Log.d("bat",prenume);


                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }


                                if (resultt.equals("admin") || resultt.equals("client")) {
                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                    intent.putExtra("prioritate", resultt);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    }

                });
            } else {
                Toast.makeText(getApplicationContext(), "Toate campurile sunt obligatorii!", Toast.LENGTH_SHORT).show();
            }
        });


    }

    public static void setBatalion(String batalion) {
        Autentificare.batalion = batalion;
    }
}