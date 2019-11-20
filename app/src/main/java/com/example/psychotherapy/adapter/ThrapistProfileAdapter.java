package com.example.psychotherapy.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.psychotherapy.R;
import com.example.psychotherapy.model.ThrapistProfile;
import java.util.ArrayList;

public class ThrapistProfileAdapter extends RecyclerView.Adapter<ThrapistProfileAdapter.ViewHolder> {
    private ArrayList<ThrapistProfile> profiles;
    private Activity context;
    public ThrapistProfileAdapter( Activity context ,ArrayList<ThrapistProfile> profiles) {
        this.profiles=profiles;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.thrapistprofile_cardview, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        holder.tv_name.setText(profiles.get(position).getName());
        holder.tv_age.setText(profiles.get(position).getAge());
        holder.tv_qualification.setText(profiles.get(position).getQualification());
        holder.tv_experience.setText(profiles.get(position).getExperience());
        holder.tv_location.setText(profiles.get(position).getLocation());
        holder.tv_status.setText(profiles.get(position).getName());
        holder.btn_sendreport.setOnClickListener(new View.OnClickListener() {
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
        private Button btn_sendreport;
        private TextView tv_name;
        private TextView tv_age;
        private TextView tv_qualification;
        private TextView tv_experience;
        private TextView tv_location;
        private TextView tv_status;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            btn_sendreport=itemView.findViewById(R.id.btn_sendreport);
            tv_name=itemView.findViewById(R.id.tv_name);
            tv_age=itemView.findViewById(R.id.tv_age);
            tv_qualification=itemView.findViewById(R.id.tv_qualification);
            tv_experience=itemView.findViewById(R.id.tv_experience);
            tv_location=itemView.findViewById(R.id.tv_location);
            tv_status=itemView.findViewById(R.id.tv_status);
        }
    }

}
