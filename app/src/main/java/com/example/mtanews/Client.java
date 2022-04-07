package com.example.mtanews;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import android.widget.LinearLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class Client extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    public static String facultate;
    TabLayout tabLayout;
   // TabItem mbatalion, mfacultate, minteresgeneral, masatm, mcabinetmedical, msport;
    PagerAdapter pagerAdapter;
    Toolbar mtoolbar, toolbar;
    ViewPager2 viewPager2;
    //public static String batalion;
    //public String facultate;
    private final String[] titluri = new String[]{"Batalion", "Facultate", "Interes General", "AS_ATM", "Cabinet Medical", "Sport"};
    private DrawerLayout drawerLayout;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer);

        Button contbutton = (Button) findViewById(R.id.contbtn);


        setSupportActionBar(mtoolbar);
        toolbar = findViewById(R.id.toolbar);
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

        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);


        viewPager2 = findViewById(R.id.fragment);
        tabLayout = findViewById(R.id.meniu);

        pagerAdapter = new PagerAdapter(this);
        viewPager2.setAdapter(pagerAdapter);

        new TabLayoutMediator(tabLayout, viewPager2,((tab, position) -> tab.setText(titluri[position]))).attach();

        drawerLayout = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_draw_open, R.string.navigation_draw_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        contbutton.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Cont.class);
            startActivity(intent);
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.profil:
                Intent intent = new Intent(this, Cont.class);
                startActivity(intent);
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