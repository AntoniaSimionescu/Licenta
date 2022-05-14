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

public class SportFragment extends Fragment {

    Adapter adapter;
    private final FragmentActivity fragmentActivity;

    public SportFragment(FragmentActivity fragmentActivity) {
        this.fragmentActivity = fragmentActivity;
    }
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sport, container, false);
        RecyclerView recyclerViewsport = v.findViewById(R.id.recyclerviewsport);
        if(recyclerViewsport == null) {
            assert false;
            recyclerViewsport.setHasFixedSize(true);
        }
        recyclerViewsport.setLayoutManager(new LinearLayoutManager(getContext()));
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("mtanews-899ff-default-rtdb").child("Sport");

        Query order = databaseReference.orderByChild("timeStamp");
        FirebaseRecyclerOptions<ModelClass> options =
                new FirebaseRecyclerOptions.Builder<ModelClass>()
                        .setQuery(order, ModelClass.class)
                        .build();

        adapter = new Adapter(options, this.fragmentActivity);
        recyclerViewsport.setAdapter(adapter);
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
