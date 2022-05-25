package com.example.mtanews.client;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mtanews.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;


public class Adapter extends FirebaseRecyclerAdapter<ModelClass, Adapter.ViewHolder> {

    private final FragmentActivity fragmentActivity;

    public Adapter(FirebaseRecyclerOptions<ModelClass> options, FragmentActivity fragmentActivity) {
        super(options);
        this.fragmentActivity = fragmentActivity;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_items, parent, false);
        return new ViewHolder(view);
    }


    @Override
    protected void onBindViewHolder(@NonNull ViewHolder viewHolder, int i, @NonNull ModelClass modelClass) {

        viewHolder.titlu.setText(modelClass.getTitlu());
        viewHolder.descriere.setText(modelClass.getDescriere());
        viewHolder.autor.setText(modelClass.getAutor());
        viewHolder.stire.setText(modelClass.getStire());
        viewHolder.data.setText(modelClass.getData());
        viewHolder.butonStire.setOnClickListener(v -> fragmentActivity.getSupportFragmentManager().beginTransaction().replace(R.id.client,
                new StireFragment(modelClass.getAutor(), modelClass.getDescriere(),
                modelClass.getTitlu(), modelClass.getStire(), modelClass.getData())).addToBackStack(null).commit());
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView titlu, descriere, autor, stire, data ;
        Button butonStire;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titlu = itemView.findViewById(R.id.titlu);
            descriere = itemView.findViewById(R.id.descriere);
            autor = itemView.findViewById(R.id.autor);
            stire = itemView.findViewById(R.id.stire);
            butonStire = itemView.findViewById(R.id.butonStire);
            cardView = itemView.findViewById(R.id.cardview);
            data = itemView.findViewById(R.id.data);
        }
    }
}
