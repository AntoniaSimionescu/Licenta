package com.example.mtanews;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class Client extends AppCompatActivity {

    public static String facultate;
    TabLayout tabLayout;
   // TabItem mbatalion, mfacultate, minteresgeneral, masatm, mcabinetmedical, msport;
    PagerAdapter pagerAdapter;
    Toolbar mtoolbar;
    ViewPager2 viewPager2;
    //public static String batalion;
    //public String facultate;
    private final String[] titluri = new String[]{"Batalion", "Facultate", "Interes General", "AS_ATM", "Cabinet Medical", "Sport"};

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

        Button contbutton = findViewById(R.id.contbtn);
        //Button meniubutton = (Button) findViewById(R.id.meniubtn);

        mtoolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);
        /*mbatalion = findViewById(R.id.batalion);
        mfacultate = findViewById(R.id.facultate);
        minteresgeneral = findViewById(R.id.interesgeneral);
        masatm = findViewById(R.id.asatm);
        mcabinetmedical = findViewById(R.id.cabinetmedical);
        msport = findViewById(R.id.sport);*/

       /*batalion = Autentificare.batalion;
       facultate = Autentificare.facultate;
        Log.d("messs", batalion);
        Log.d("messs", facultate);*/

        contbutton.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Cont.class);
            startActivity(intent);
        });
        viewPager2 = findViewById(R.id.fragment);
        tabLayout = findViewById(R.id.meniu);

        pagerAdapter = new PagerAdapter(this);
        viewPager2.setAdapter(pagerAdapter);


        new TabLayoutMediator(tabLayout, viewPager2,((tab, position) -> tab.setText(titluri[position]))).attach();
    }
}