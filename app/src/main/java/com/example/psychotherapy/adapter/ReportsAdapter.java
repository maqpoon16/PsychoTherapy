package com.example.psychotherapy.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.psychotherapy.QuestionsRoundActivity;
import com.example.psychotherapy.R;
import com.example.psychotherapy.RepotsActivity;
import com.example.psychotherapy.UserInputActivity;
import com.example.psychotherapy.model.UserRatingData;

import java.util.List;

public class ReportsAdapter extends RecyclerView.Adapter<ReportsAdapter.ViewHolder> {


    private Context context;
   private List<UserRatingData> GetRatingData;

    public ReportsAdapter(Context context , List<UserRatingData> GetRatingData) {
        this.context=context;
        this.GetRatingData=GetRatingData;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.reports_cardview, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return new ViewHolder(v);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.userInputs_Text.setText(GetRatingData.get(position).getInputdata());
        holder.userfeelings_Text.setText(GetRatingData.get(position).getEmotions());
        holder.date_Text.setText(GetRatingData.get(position).getDate());
        switch (Integer.valueOf(GetRatingData.get(position).getUserRated())){
            case 1:{

                holder.rateOne.setBackground(ContextCompat.getDrawable(context, R.drawable.roundbuttonfill));
                break;
            }
            case 2:{

                holder.rateOne.setBackground(ContextCompat.getDrawable(context, R.drawable.roundbuttonfill));
                holder.rateTwo.setBackground(ContextCompat.getDrawable(context, R.drawable.roundbuttonfill));
                break;
            }
            case 3:{

                holder.rateOne.setBackground(ContextCompat.getDrawable(context, R.drawable.roundbuttonfill));
                holder.rateTwo.setBackground(ContextCompat.getDrawable(context, R.drawable.roundbuttonfill));
                holder. rateThree.setBackground(ContextCompat.getDrawable(context, R.drawable.roundbuttonfill));
                break;
            }
            case 4:{

                holder.rateOne.setBackground(ContextCompat.getDrawable(context, R.drawable.roundbuttonfill));
                holder.rateTwo.setBackground(ContextCompat.getDrawable(context, R.drawable.roundbuttonfill));
                holder. rateThree.setBackground(ContextCompat.getDrawable(context, R.drawable.roundbuttonfill));
                holder.rateFour.setBackground(ContextCompat.getDrawable(context, R.drawable.roundbuttonfill));
                break;
            }
            case 5:{
                holder.rateOne.setBackground(ContextCompat.getDrawable(context, R.drawable.roundbuttonfill));
                holder.rateTwo.setBackground(ContextCompat.getDrawable(context, R.drawable.roundbuttonfill));
                holder. rateThree.setBackground(ContextCompat.getDrawable(context, R.drawable.roundbuttonfill));
                holder.rateFour.setBackground(ContextCompat.getDrawable(context, R.drawable.roundbuttonfill));
                holder. rateFive.setBackground(ContextCompat.getDrawable(context, R.drawable.roundbuttonfill));
                break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return GetRatingData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView date_Text;
        private TextView userInputs_Text;
        private TextView userfeelings_Text;
        private Button rateOne;
        private Button rateTwo ;
        private Button rateThree;
        private Button rateFour;
        private Button rateFive;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userfeelings_Text=(TextView)itemView.findViewById(R.id.userfeelings_Text);
            userInputs_Text=(TextView)itemView.findViewById(R.id.userInputs_Text);
            date_Text=(TextView)itemView.findViewById(R.id.date_Text);
            rateOne = (Button) itemView.findViewById(R.id.btn_one);
            rateTwo = (Button) itemView.findViewById(R.id.btn_two);
            rateThree = (Button) itemView.findViewById(R.id.btn_three);
            rateFour = (Button) itemView.findViewById(R.id.btn_four);
            rateFive = (Button) itemView.findViewById(R.id.btn_five);
        }
    }
}
