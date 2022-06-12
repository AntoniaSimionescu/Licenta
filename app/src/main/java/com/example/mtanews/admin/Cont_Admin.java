package com.example.mtanews.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mtanews.R;
import com.example.mtanews.core.UserData;

public class Cont_Admin extends AppCompatActivity {

    public String email, nume, prenume, numeprenume;
    TextView nume_txt, email_txt, email_txt2, prenume_txt, numeprenume_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cont_admin);

        Button inapoi = findViewById(R.id.btninapoi);
        inapoi.setOnClickListener(v -> {
            Intent intent = new Intent(Cont_Admin.this, Admin.class);
            startActivity(intent);
        });

        email = UserData.GetInstance().getEmail();
        nume = UserData.GetInstance().getNume();
        prenume = UserData.GetInstance().getPrenume();

        numeprenume_txt = findViewById(R.id.numeprenume_cont);
        email_txt = findViewById(R.id.email_cont);
        email_txt2 = findViewById(R.id.email_cont2);
        nume_txt = findViewById(R.id.nume_cont);
        prenume_txt = findViewById(R.id.prenume_cont);


        numeprenume = nume + " " + prenume;
        numeprenume_txt.setText(numeprenume);
        email_txt.setText(email);
        email_txt2.setText(email);
        nume_txt.setText(nume);
        prenume_txt.setText(prenume);
    }
}