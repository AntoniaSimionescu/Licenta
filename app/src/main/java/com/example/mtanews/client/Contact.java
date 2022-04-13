package com.example.mtanews.client;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mtanews.R;

public class Contact extends AppCompatActivity {

    TextView link, phone1, phone2, phone3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        link = findViewById(R.id.link_mail);
        phone1 = findViewById(R.id.phone1);
        phone2 = findViewById(R.id.phone2);
        phone3 = findViewById(R.id.phone3);
        link.setMovementMethod(LinkMovementMethod.getInstance());
        phone1.setMovementMethod(LinkMovementMethod.getInstance());
        phone2.setMovementMethod(LinkMovementMethod.getInstance());
        phone3.setMovementMethod(LinkMovementMethod.getInstance());


    }
}