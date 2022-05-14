package com.example.mtanews.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mtanews.R;
import com.example.mtanews.client.Adapter;
import com.example.mtanews.client.ModelClass;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ServerValue;
import com.google.firebase.firestore.core.OrderBy;
import com.google.firestore.v1.StructuredQuery;
import com.google.firebase.firestore.Query.Direction;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Batalion1Fragment extends Fragment {

    Adapter adapter;

    private final FragmentActivity fragmentActivity;

    public Batalion1Fragment(FragmentActivity fragmentActivity) {
        this.fragmentActivity = fragmentActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_batalion1, container, false);
        RecyclerView recyclerViewbatalion1 = v.findViewById(R.id.recyclerviewbatalion1);
        if(recyclerViewbatalion1 == null) {
            assert false;
            recyclerViewbatalion1.setHasFixedSize(true);
        }
        recyclerViewbatalion1.setLayoutManager(new LinearLayoutManager(getContext()));

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("mtanews-899ff-default-rtdb").child("Batalionul I Studenți");
        Query order = databaseReference.orderByChild("timeStamp");

        FirebaseRecyclerOptions<ModelClass> options =
                new FirebaseRecyclerOptions.Builder<ModelClass>()
                        .setQuery(order, ModelClass.class)
                        .build();



        adapter = new Adapter(options, this.fragmentActivity);
        recyclerViewbatalion1.setAdapter(adapter);
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
