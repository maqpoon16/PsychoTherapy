package com.example.psychotherapy.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.psychotherapy.R;
import com.example.psychotherapy.model.PatientsListModel;
import com.example.psychotherapy.model.ThrapistProfile;

import java.util.ArrayList;

public class PatientsListAdapter extends RecyclerView.Adapter<PatientsListAdapter.ViewHolder> {
    private ArrayList<PatientsListModel> profiles;
    private Activity context;
    public PatientsListAdapter(Activity context , ArrayList<PatientsListModel> profiles) {
        this.profiles=profiles;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.patientlist_cardview, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        holder.tv_name.setText(profiles.get(position).firstname+" "+profiles.get(position).lastname);
        holder.tv_location.setText(profiles.get(position).city+", "+profiles.get(position).country);
        holder.tv_gender.setText(profiles.get(position).gender);
        holder.tv_mobile.setText(profiles.get(position).mobile);
        holder.tv_email.setText(profiles.get(position).email);
        holder.btn_showmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return profiles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private Button btn_showmore;
        private TextView tv_name;
        private TextView tv_email;
        private TextView tv_gender;
        private TextView tv_location;
        private TextView tv_mobile;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            btn_showmore=itemView.findViewById(R.id.btn_sendreport);
            tv_name=itemView.findViewById(R.id.tv_name);
            tv_email=itemView.findViewById(R.id.tv_email);
            tv_gender=itemView.findViewById(R.id.tv_gender);
            tv_mobile=itemView.findViewById(R.id.tv_mobile);
            tv_location=itemView.findViewById(R.id.tv_location);
        }
    }

}
