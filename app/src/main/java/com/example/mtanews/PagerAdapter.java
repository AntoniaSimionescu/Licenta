package com.example.mtanews;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;


public class PagerAdapter extends FragmentStateAdapter {

    private final String[] valori= new String[]{"Batalion", "Facultate", "Interes General", "AS_ATM", "Cabinet Medical", "Sport"};

    /*String batalion, facultate;


    public String getBatalion() {
        batalion=Client.batalion;
        Log.d("mesaj", batalion);
        return batalion;
    }

    public String getFacultate() {
        facultate=Client.facultate;
        return facultate;
    }

    public void setBatalion(String batalion) {
        this.batalion = batalion;
        Log.d("mesaj", batalion);
    }

    public void setFacultate(String facultate) {
        this.facultate = facultate;
    }*/

    public PagerAdapter(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 0:
                return new Batalion1Fragment();
            case 1:
                return new FacultateAFragment();
            case 2:
                return new InteresGeneralFragment();
            case 3:
                return new AsAtmFragment();
            case 4:
                return new CabinetMedicalFragment();
            case 5:
                return new SportFragment();

            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return valori.length;
    }
}

