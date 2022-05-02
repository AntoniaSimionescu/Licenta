package com.example.mtanews.client;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.ViewPager2;

import com.example.mtanews.Autentificare;
import com.example.mtanews.R;
import com.example.mtanews.core.UserData;
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

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.profil:
                Intent intent = new Intent(this, Cont.class);
                startActivity(intent);
                break;
            case R.id.model_raport:
                Intent intent2 = new Intent(this, Raport.class);
                startActivity(intent2);
                break;
            case R.id.setari:
                Intent intent3 = new Intent(this, Setari.class);
                startActivity(intent3);
                break;
            case R.id.contact:
                Intent intent4 = new Intent(this, Contact.class);
                startActivity(intent4);
                break;
            case R.id.share:
                Intent intent5 = new Intent(Intent.ACTION_SEND);
                intent5.setType("text/plain");
                intent5.putExtra(Intent.EXTRA_TEXT, "Descarcă aplicația MTA NEWS!\nLink-ul aplicației aici..." );
                startActivity(Intent.createChooser(intent5, "Distribuie folosind: "));
                break;
            case R.id.deconectare:
                UserData.DisconnectInstance();
                Intent intent6= new Intent(this, Autentificare.class);
                startActivity(intent6);
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