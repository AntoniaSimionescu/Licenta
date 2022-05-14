package com.example.mtanews.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

public class FacultateBFragment extends Fragment {

    Adapter adapter;

    private final FragmentActivity fragmentActivity;

    public FacultateBFragment(FragmentActivity fragmentActivity) {
        this.fragmentActivity = fragmentActivity;
    }
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_facultate_b, container, false);
        RecyclerView recyclerViewfacultateB = v.findViewById(R.id.recyclerviewfacultateb);
        if(recyclerViewfacultateB == null) {
            assert false;
            recyclerViewfacultateB.setHasFixedSize(true);
        }
        recyclerViewfacultateB.setLayoutManager(new LinearLayoutManager(getContext()));
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("mtanews-899ff-default-rtdb").child("Facultatea de Sisteme Integrate de Armament, Geniu și Mecatronică");

        Query order = databaseReference.orderByChild("timeStamp");
        FirebaseRecyclerOptions<ModelClass> options =
                new FirebaseRecyclerOptions.Builder<ModelClass>()
                        .setQuery(order, ModelClass.class)
                        .build();

        adapter = new Adapter(options, this.fragmentActivity);
        recyclerViewfacultateB.setAdapter(adapter);
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
