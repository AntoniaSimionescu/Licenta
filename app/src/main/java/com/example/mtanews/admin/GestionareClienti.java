package com.example.mtanews.admin;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mtanews.R;
import com.example.mtanews.core.URLs;
import com.vishnusivadas.advanced_httpurlconnection.FetchData;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class GestionareClienti extends AppCompatActivity {

    ArrayList<UserRequests> userRequestsList ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestionare_clienti);


        Button inapoi = findViewById(R.id.btninapoi);
        inapoi.setOnClickListener(v -> {
            Intent intent = new Intent(GestionareClienti.this, Admin.class);
            startActivity(intent);
        });
        userRequestsList = new ArrayList<UserRequests>();
        getUserRequests();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RecyclerView.Adapter<UserAdapter.ViewHolder> adapter = new UserAdapter(userRequestsList, this);
        recyclerView.setAdapter(adapter);

    }

    public void getUserRequests() {
        FetchData ftData = new FetchData(URLs.USERS_URL);
        JSONArray jsonUseri = null;
        JSONArray obiect = null;
        if (ftData.startFetch()) {
            if (ftData.onComplete()) {
                String result = ftData.getResult();
                try {
                    jsonUseri = new JSONArray(result);
                    for (int i = 0; i < jsonUseri.length(); ++i) {
                        obiect = jsonUseri.getJSONArray(i);
                        JSONObject request = obiect.getJSONObject(0);
                        UserRequests usr = new UserRequests(request.getString("nume"),request.getString("prenume"), request.getString("email"),request.getString("batalion"),request.getString("facultate"));
                        userRequestsList.add(usr);
                    }
                } catch (Exception e) {
                    Log.d("eroare", e.toString());
                }
            }
        }
    }

    public void doAcceptare(View v)
    {

    }
}
