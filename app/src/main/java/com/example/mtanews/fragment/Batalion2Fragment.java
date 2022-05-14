package com.example.mtanews.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mtanews.R;
import com.example.mtanews.client.Adapter;
import com.example.mtanews.client.ModelClass;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;

public class Batalion2Fragment extends Fragment {

    Adapter adapter;

    private final FragmentActivity fragmentActivity;

    public Batalion2Fragment(FragmentActivity fragmentActivity) {
        this.fragmentActivity = fragmentActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_batalion2, container, false);
        RecyclerView recyclerViewbatalion2 = v.findViewById(R.id.recyclerviewbatalion2);
        if(recyclerViewbatalion2 == null) {
            assert false;
            recyclerViewbatalion2.setHasFixedSize(true);
        }
        recyclerViewbatalion2.setLayoutManager(new LinearLayoutManager(getContext()));
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("mtanews-899ff-default-rtdb").child("Batalionul II Studenți");

        Query order = databaseReference.orderByChild("timeStamp");
        FirebaseRecyclerOptions<ModelClass> options =
                new FirebaseRecyclerOptions.Builder<ModelClass>()
                        .setQuery(order, ModelClass.class)
                        .build();

        adapter = new Adapter(options, this.fragmentActivity);
        recyclerViewbatalion2.setAdapter(adapter);
        return v;
    }
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
