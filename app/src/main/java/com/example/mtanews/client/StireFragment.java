package com.example.mtanews.client;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.example.mtanews.R;

public class StireFragment extends Fragment {

    public String autor, descriere, titlu, stire, data;

    public StireFragment(String autor, String descriere, String titlu, String stire, String data) {
        this.autor = autor;
        this.descriere = descriere;
        this.titlu = titlu;
        this.stire = stire;
        this.data = data;
    }

    public StireFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_stire, container, false);

        TextView Titlu = view.findViewById(R.id.titlu);
        TextView Descriere = view.findViewById(R.id.descriere);
        TextView Autor = view.findViewById(R.id.autor);
        TextView Stire = view.findViewById(R.id.stire);
        TextView Data = view.findViewById(R.id.data);
        Button btn = view.findViewById(R.id.btninapoistire);

        btn.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), Client.class);
            startActivity(intent);
        });

        Titlu.setText(titlu);
        Descriere.setText(descriere);
        Autor.setText(autor);
        Stire.setText(stire);
        Data.setText(data);
        return view;
    }
}