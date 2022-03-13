package com.example.mtanews;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String prioritate = getIntent().getStringExtra("prioritate");
        if(prioritate.equals("admin")) {
            new Handler().postDelayed(() -> {

                Intent i = new Intent(MainActivity.this, Admin.class);
                startActivity(i);

                finish();
            }, 2000);
        } else {
            new Handler().postDelayed(() -> {

                Intent i = new Intent(MainActivity.this, Client.class);
                startActivity(i);

                finish();
            }, 2000);
        }

    }
}