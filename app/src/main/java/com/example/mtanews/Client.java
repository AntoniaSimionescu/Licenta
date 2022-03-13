package com.example.mtanews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class Client extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem mbatalion, mfacultate, minteresgeneral, masatm, mcabinetmedical, msport;

    PagerAdapter pagerAdapter;
    Toolbar mtoolbar;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

        mtoolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);

        mbatalion = findViewById(R.id.batalion);
        mfacultate = findViewById(R.id.facultate);
        minteresgeneral = findViewById(R.id.interesgeneral);
        masatm = findViewById(R.id.asatm);
        mcabinetmedical = findViewById(R.id.cabinetmedical);
        msport = findViewById(R.id.sport);

        ViewPager viewPager = findViewById(R.id.fragment);
        tabLayout = findViewById(R.id.meniu);

        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), 6);
        viewPager.setAdapter(pagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0||tab.getPosition()==1||tab.getPosition()==2||tab.getPosition()==3||tab.getPosition()==4||tab.getPosition()==5)
                {
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}