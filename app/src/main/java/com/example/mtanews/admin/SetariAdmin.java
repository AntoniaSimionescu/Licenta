package com.example.mtanews.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mtanews.R;

public class SetariAdmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setari_admin);

        Button inapoi = findViewById(R.id.btninapoi);
        inapoi.setOnClickListener(v -> {
            Intent intent = new Intent(SetariAdmin.this, Admin.class);
            startActivity(intent);
        });
    }
}