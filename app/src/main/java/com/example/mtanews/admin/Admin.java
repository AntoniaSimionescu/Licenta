package com.example.mtanews.admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.example.mtanews.Autentificare;
import com.example.mtanews.R;
import com.example.mtanews.admin.Cont_Admin;
import com.example.mtanews.client.Cont;
import com.example.mtanews.client.Contact;
import com.example.mtanews.core.UserData;
import com.google.android.material.navigation.NavigationView;

public class Admin extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public String nume, prenume, numeprenume;
    TextView numeprenume_txt;
    Button batalion1, batalion2, batalion3, batalion4, facultateA, facultateB, facultateC, facultateE, interesgeneral, asatm, cabinetmedical, sport;

    private DrawerLayout drawerLayout;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.draweradmin);
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        toolbar = findViewById(R.id.toolbaradmin);

        drawerLayout = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_draw_open, R.string.navigation_draw_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        nume = UserData.GetInstance().getNume();
        prenume = UserData.GetInstance().getPrenume();
        numeprenume = nume + " " + prenume;
        numeprenume_txt = findViewById(R.id.numeprenume_admin);
        numeprenume_txt.setText(numeprenume);

        batalion1 = findViewById(R.id.batalion1btn);
        batalion2 = findViewById(R.id.batalion2btn);
        batalion3 = findViewById(R.id.batalion3btn);
        batalion4 = findViewById(R.id.batalion4btn);
        facultateA = findViewById(R.id.facultateAbtn);
        facultateB = findViewById(R.id.facultateBbtn);
        facultateC = findViewById(R.id.facultateCbtn);
        facultateE = findViewById(R.id.facultateEbtn);
        interesgeneral = findViewById(R.id.interesgeneralbtn);
        asatm = findViewById(R.id.asatmbtn);
        cabinetmedical = findViewById(R.id.cabinetmedicalbtn);
        sport = findViewById(R.id.sportbtn);

        batalion1.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), RedactareStire.class);
            startActivity(intent);
        });
        batalion2.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), RedactareStire.class);
            startActivity(intent);
        });
        batalion3.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), RedactareStire.class);
            startActivity(intent);
        });
        batalion4.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), RedactareStire.class);
            startActivity(intent);
        });
        facultateA.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), RedactareStire.class);
            startActivity(intent);
        });
        facultateB.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), RedactareStire.class);
            startActivity(intent);
        });
        facultateC.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), RedactareStire.class);
            startActivity(intent);
        });
        facultateE.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), RedactareStire.class);
            startActivity(intent);
        });
        interesgeneral.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), RedactareStire.class);
            startActivity(intent);
        });
        asatm.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), RedactareStire.class);
            startActivity(intent);
        });
        cabinetmedical.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), RedactareStire.class);
            startActivity(intent);
        });
        sport.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), RedactareStire.class);
            startActivity(intent);
        });

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.profil:
                Intent intent = new Intent(this, Cont_Admin.class);
                startActivity(intent);
                break;
            case R.id.contact:
                Intent intent2 = new Intent(this, Contact.class);
                startActivity(intent2);
                break;
            case R.id.deconectare:
                UserData.DisconnectInstance();
                Intent intent3 = new Intent(this, Autentificare.class);
                startActivity(intent3);
                break;

        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }

    }
}