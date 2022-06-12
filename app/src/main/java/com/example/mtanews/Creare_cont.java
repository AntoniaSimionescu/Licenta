package com.example.mtanews;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mtanews.core.URLs;
import com.example.mtanews.core.UserData;
import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

public class Creare_cont extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextInputEditText textInputEditTextNume, textInputEditTextPrenume, textInputEditTextEmail, textInputEditTextUtilizator, textInputEditTextParola;
    Button buttonSignUp;
    TextView textViewAutentificare;
    ProgressBar progressBar;
    Spinner spinner, spinner1;

    String getBatalionLetter(String batalion){
        String toBeReturned="";
        switch (batalion){
            case "I Studenți":toBeReturned= "I"; break;
            case "II Studenți":toBeReturned= "II"; break;
            case "III Studenți":toBeReturned= "III"; break;
            case "IV Studenți":toBeReturned= "IV";break;
        }
        return toBeReturned;
    }
    String getFacultateLetter(String facultate){
        String toBeReturned="";
        switch (facultate){
            case "Facultatea de Aeronave și Autovehicule Militare":toBeReturned= "A";break;
            case "Facultatea de Sisteme Integrate de Armament, Geniu și Mecatronică":toBeReturned= "B";break;
            case "Facultatea de Sisteme Informatice și Securitate Cibernetică":toBeReturned= "C";break;
            case "Facultatea de Comunicații și Sisteme Electronice pentru Apărare și Securitate":toBeReturned= "E";break;
        }
        return toBeReturned;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creare_cont);

        spinner = findViewById(R.id.batalion);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.batalion, R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        spinner1 = findViewById(R.id.facultate);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.facultate, R.layout.support_simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter2);

        textInputEditTextNume = findViewById(R.id.nume);
        textInputEditTextPrenume = findViewById(R.id.prenume);
        textInputEditTextEmail = findViewById(R.id.email);
        textInputEditTextUtilizator = findViewById(R.id.utilizator);
        textInputEditTextParola = findViewById(R.id.parola);
        buttonSignUp = findViewById(R.id.buttonSignUp);
        textViewAutentificare = findViewById(R.id.autentificare);
        progressBar = findViewById(R.id.progress);

        textViewAutentificare.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Autentificare.class);
            startActivity(intent);
            finish();

        });

        buttonSignUp.setOnClickListener(v -> {
            String nume, prenume, email, utilizator, parola, batalion, facultate;
            nume = String.valueOf(textInputEditTextNume.getText());
            prenume = String.valueOf(textInputEditTextPrenume.getText());
            email = String.valueOf(textInputEditTextEmail.getText());
            utilizator = String.valueOf(textInputEditTextUtilizator.getText());
            parola = String.valueOf(textInputEditTextParola.getText());
            batalion = spinner.getSelectedItem().toString();
            facultate = spinner1.getSelectedItem().toString();

            if(!nume.equals("") && !prenume.equals("") && !email.equals("") && !utilizator.equals("") && !parola.equals("") && !batalion.equals("") && !facultate.equals("")) {

                progressBar.setVisibility(View.VISIBLE);
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(() -> {
                    String[] field = new String[7];
                    field[0] = "nume";
                    field[1] = "prenume";
                    field[2] = "email";
                    field[3] = "utilizator";
                    field[4] = "parola";
                    field[5] = "batalion";
                    field[6] = "facultate";
                    String[] data = new String[7];
                    data[0] = nume;
                    data[1] = prenume;
                    data[2] = email;
                    data[3] = utilizator;
                    data[4] = parola;
                    data[5] = getBatalionLetter(batalion);
                    data[6] = getFacultateLetter(facultate);

                    PutData putData = new PutData(URLs.REGISTER_URL, "POST", field, data);
                    if (putData.startPut()) {
                        if (putData.onComplete()) {
                            progressBar.setVisibility(View.GONE);
                            String result = putData.getResult();
                            if (result.equals("Asteptati aprobarea adminului!")){
                                Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), Autentificare.class);
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



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}