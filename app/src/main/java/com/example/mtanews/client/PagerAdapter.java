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

    private final FragmentActivity fragmentActivity;
    public PagerAdapter(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        this.fragmentActivity = fragmentActivity;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        String batalion, facultate;
        batalion = UserData.GetInstance().getBatalion();
        facultate = UserData.GetInstance().getFacultate();
        switch (position)
        {
            case 0:
                switch (batalion){
                    case "I":
                        return new Batalion1Fragment(this.fragmentActivity);
                    case "II":
                        return new Batalion2Fragment(this.fragmentActivity);
                    case "III":
                        return new Batalion3Fragment(this.fragmentActivity);
                    case "IV":
                        return new Batalion4Fragment(this.fragmentActivity);
                }
            case 1:
                switch (facultate){
                    case "A":
                        return new FacultateAFragment(this.fragmentActivity);
                    case "B":
                        return new FacultateBFragment(this.fragmentActivity);
                    case "C":
                        return new FacultateCFragment(this.fragmentActivity);
                    case "E":
                        return new FacultateEFragment(this.fragmentActivity);
                }
            case 2:
                return new InteresGeneralFragment(this.fragmentActivity);
            case 3:
                return new AsAtmFragment(this.fragmentActivity);
            case 4:
                return new CabinetMedicalFragment(this.fragmentActivity);
            case 5:
                return new SportFragment(this.fragmentActivity);

            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {return valori.length;}
}

