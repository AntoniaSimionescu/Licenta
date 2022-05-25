package com.example.mtanews.admin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mtanews.R;
import com.example.mtanews.client.StireFragment;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private final List<UserRequests> userRequests;

    public UserAdapter(List<UserRequests> userRequests, Context context) {
        this.userRequests = userRequests;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext())
               .inflate(R.layout.layout_cereri_clienti,parent, false);
       return new ViewHolder(v);
    }

    //@SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        UserRequests userDatas = userRequests.get(position);
        String numePrenume = userDatas.getNume() + " " + userDatas.getPrenume();
        holder.textViewNumePrenume.setText(numePrenume);
        holder.textViewEmail.setText(userDatas.getEmail());
        holder.textViewBatalion.setText(userDatas.getBatalion());
        holder.textViewFacultate.setText(userDatas.getFacultate());
        holder.btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] field = new String[6];
                field[0] = "nume";
                field[1] = "prenume";
                field[2] = "email";
                field[3] = "batalion";
                field[4] = "facultate";
                field[5] = "type";
                String[] data = new String[6];
                data[0] = userDatas.getNume();
                data[1] = userDatas.getPrenume();
                data[2] = userDatas.getEmail();
                data[3] = userDatas.getBatalion();
                data[4] = userDatas.getFacultate();
                data[5] = "accept";
                PutData putData = new PutData("http://10.10.19.129/LoginRegister/acceptRequest.php", "POST", field, data);
                if (putData.startPut()) {
                    if (putData.onComplete()) {
                        Toast.makeText(v.getContext(), putData.getResult(),Toast.LENGTH_SHORT).show();
                    }
                    }
            }
        });
        holder.btnRefuz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] field = new String[6];
                field[0] = "nume";
                field[1] = "prenume";
                field[2] = "email";
                field[3] = "batalion";
                field[4] = "facultate";
                field[5] = "type";
                String[] data = new String[6];
                data[0] = userDatas.getNume();
                data[1] = userDatas.getPrenume();
                data[2] = userDatas.getEmail();
                data[3] = userDatas.getBatalion();
                data[4] = userDatas.getFacultate();
                data[5] = "refuz";
                PutData putData = new PutData("http://10.10.19.129/LoginRegister/acceptRequest.php", "POST", field, data);
                if (putData.startPut()) {
                    if (putData.onComplete()) {
                        Toast.makeText(v.getContext(), putData.getResult(),Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return userRequests.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewNumePrenume;
        public TextView textViewEmail;
        public TextView textViewBatalion;
        public TextView textViewFacultate;
        public Button btnAccept;
        public Button btnRefuz;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            textViewNumePrenume = (TextView) itemView.findViewById(R.id.numeprenume);
            textViewEmail = (TextView) itemView.findViewById(R.id.adresa_email);
            textViewBatalion = (TextView) itemView.findViewById(R.id.valoarebatalion);
            textViewFacultate = (TextView) itemView.findViewById(R.id.valoarefacultate);
            btnAccept = (Button) itemView.findViewById(R.id.butonAccept);
            btnRefuz = (Button) itemView.findViewById(R.id.butonRefuz);
        }
    }
}
