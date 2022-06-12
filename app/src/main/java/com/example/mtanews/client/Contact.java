package com.example.mtanews.client;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mtanews.R;

public class Contact extends AppCompatActivity {

    TextView link, phone1, phone2, phone3, facebook, mail_atm;
    ImageView locatie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        Button inapoi = findViewById(R.id.btninapoi);
        link = findViewById(R.id.link_mail);
        phone1 = findViewById(R.id.phone1);
        phone2 = findViewById(R.id.phone2);
        phone3 = findViewById(R.id.phone3);
        locatie = findViewById(R.id.imaginelocatie);
        facebook = findViewById(R.id.facebook);
        mail_atm = findViewById(R.id.mail_atm);

        inapoi.setOnClickListener(v -> {
            Intent intent = new Intent(Contact.this, Client.class);
            startActivity(intent);
        });
        link.setMovementMethod(LinkMovementMethod.getInstance());
        phone1.setMovementMethod(LinkMovementMethod.getInstance());
        phone2.setMovementMethod(LinkMovementMethod.getInstance());
        phone3.setMovementMethod(LinkMovementMethod.getInstance());

        locatie.setOnClickListener(v -> gotoUrl("https://www.google.ro/maps/place/Academia+Tehnic%C4%83+Militar%C4%83+Ferdinand+I/@44.4181864,26.0776755,15z/data=!3m1!4b1!4m5!3m4!1s0x40b1ff0b54881f97:0xae84d2f47f65a3a7!8m2!3d44.4181867!4d26.0864088"));
        facebook.setOnClickListener(v -> gotoUrl("https://www.facebook.com/AcademiaTehnicaMilitara/"));
        mail_atm.setOnClickListener(v -> gotoUrl("https://main.mta.ro/SOGo/so/"));

    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}