package com.example.mtanews.client;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.mtanews.core.UserData;
import com.example.mtanews.fragment.AsAtmFragment;
import com.example.mtanews.fragment.Batalion1Fragment;
import com.example.mtanews.fragment.Batalion2Fragment;
import com.example.mtanews.fragment.Batalion3Fragment;
import com.example.mtanews.fragment.Batalion4Fragment;
import com.example.mtanews.fragment.CabinetMedicalFragment;
import com.example.mtanews.fragment.FacultateAFragment;
import com.example.mtanews.fragment.FacultateBFragment;
import com.example.mtanews.fragment.FacultateCFragment;
import com.example.mtanews.fragment.FacultateEFragment;
import com.example.mtanews.fragment.InteresGeneralFragment;
import com.example.mtanews.fragment.SportFragment;


public class PagerAdapter extends FragmentStateAdapter {

    private final String[] valori= new String[]{"Batalion", "Facultate", "Interes General", "AS_ATM", "Cabinet Medical", "Sport"};

    public PagerAdapter(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        UserData userData = UserData.GetInstance();
        String batalion, facultate;
        batalion = UserData.GetInstance().getBatalion();
        facultate = UserData.GetInstance().getFacultate();
        switch (position)
        {
            case 0:
                switch (batalion){
                    case "I":
                        return new Batalion1Fragment();
                    case "II":
                        return new Batalion2Fragment();
                    case "III":
                        return new Batalion3Fragment();
                    case "IV":
                        return new Batalion4Fragment();
                }
            case 1:
                switch (facultate){
                    case "A":
                        return new FacultateAFragment();
                    case "B":
                        return new FacultateBFragment();
                    case "C":
                        return new FacultateCFragment();
                    case "E":
                        return new FacultateEFragment();
                }
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

