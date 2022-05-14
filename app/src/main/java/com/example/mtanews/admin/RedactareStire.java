package com.example.mtanews.admin;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mtanews.R;
import com.example.mtanews.core.UserData;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class RedactareStire extends AppCompatActivity {

    private FirebaseDatabase database;
    @SuppressLint({"SetTextI18n", "SimpleDateFormat"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redactare_stire);

        final EditText titlu = findViewById(R.id.texttitlu);
        final EditText descriere = findViewById(R.id.textdescriere);
        final TextView categorie = findViewById(R.id.textcategorie);
        final EditText stire = findViewById(R.id.textstire);
        final String nume = UserData.GetInstance().getNume();
        final String prenume = UserData.GetInstance().getPrenume();
        final String autortxt = nume + " " + prenume;

        final Button posteazaBtn = findViewById(R.id.buttonPostare);
        final Button inapoiBtn = findViewById(R.id.btninapoi);
        final String categorie_txt = Admin.categorie;
        switch (categorie_txt)
        {
            case "Batalionul 1 Studenți":
                categorie.setText("Batalionul I Studenți");
                break;
            case "Batalionul 2 Studenți":
                categorie.setText("Batalionul II Studenți");
                break;
            case "Batalionul 3 Studenți":
                categorie.setText("Batalionul III Studenți");
                break;
            case "Batalionul 4 Studenți":
                categorie.setText("Batalionul IV Studenți");
                break;
            case "Facultatea A":
                categorie.setText("Facultatea de Aeronave și Autovehicule Militare");
                break;
            case "Facultatea B":
                categorie.setText("Facultatea de Sisteme Integrate de Armament, Geniu și Mecatronică");
                break;
            case "Facultatea C":
                categorie.setText("Facultatea de Sisteme Informatice și Securitate Cibernetică");
                break;
            case "Facultatea E":
                categorie.setText("Facultatea de Comunicații și Sisteme Electronice pentru Aparare și Securitate");
                break;
            case "Interes General":
                categorie.setText("Interes General");
                break;
            case "As Atm":
                categorie.setText("AS ATM");
                break;
            case "Cabinet Medical":
                categorie.setText("Cabinet Medical");
                break;
            case "Sport":
                categorie.setText("Sport");
                break;
        }

        inapoiBtn.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Admin.class);
            startActivity(intent);
        });


        posteazaBtn.setOnClickListener(v -> {


            final String titluTxt = titlu.getText().toString();
            final String descriereTxt = descriere.getText().toString();
            final String categorieTxt = categorie.getText().toString();
            final String stireTxt = stire.getText().toString();
            @SuppressLint("SimpleDateFormat") DateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy");
            String dataTxt = dateFormat.format(Calendar.getInstance().getTime());
            int ts = (int) new Date().getTime();
            ts = (-1)*ts;
            String timeStamp = String.valueOf(ts);

            if(titluTxt.isEmpty() || descriereTxt.isEmpty() || categorieTxt.isEmpty() || stireTxt.isEmpty())
            {
                Toast.makeText(RedactareStire.this, "Vă rugăm completați toate câmpurile!",Toast.LENGTH_SHORT).show();
            }
            else
            {
                database = FirebaseDatabase.getInstance();
                DatabaseReference Ref = (DatabaseReference) database.getReference("mtanews-899ff-default-rtdb");
                Ref.keepSynced(true);
                Ref.child("mtanews-899ff-default-rtdb").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChild(titluTxt))
                        {
                            Toast.makeText(RedactareStire.this,"Știrea deja există!",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(RedactareStire.this,"Știre postată cu succes!",Toast.LENGTH_SHORT).show();
                            Ref.child(categorieTxt).child(titluTxt).child("titlu").setValue(titluTxt);
                            Ref.child(categorieTxt).child(titluTxt).child("descriere").setValue(descriereTxt);
                            Ref.child(categorieTxt).child(titluTxt).child("categorie").setValue(categorieTxt);
                            Ref.child(categorieTxt).child(titluTxt).child("autor").setValue(autortxt);
                            Ref.child(categorieTxt).child(titluTxt).child("stire").setValue(stireTxt);
                            Ref.child(categorieTxt).child(titluTxt).child("data").setValue(dataTxt);
                            Ref.child(categorieTxt).child(titluTxt).child("timeStamp").setValue(timeStamp);
                            startActivity(new Intent(RedactareStire.this, Admin.class));
                            finish();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }
}