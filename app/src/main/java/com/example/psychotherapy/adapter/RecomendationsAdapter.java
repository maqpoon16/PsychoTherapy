package com.example.psychotherapy.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.psychotherapy.Feedback.FeedBack;
import com.example.psychotherapy.QuestionsRoundActivity;
import com.example.psychotherapy.R;
import com.example.psychotherapy.UserInputActivity;
import com.example.psychotherapy.model.UserRatingData;

public class RecomendationsAdapter extends RecyclerView.Adapter<RecomendationsAdapter.ViewHolder> {


    private Context context;
    private Activity activity;
    private String emotion;
    private String emotionKeyMatched;
    private String userInput;
    private String [] recomendations;

    public RecomendationsAdapter(Context context , String emotion,String emotionKeyMatched, String userInput,String [] recomendations,Activity activity) {
        this.context=context;
        this.activity=activity;
        this.emotion=emotion;
        this.userInput=userInput;
        this.emotionKeyMatched=emotionKeyMatched;
        this.recomendations=recomendations;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recomendation_cardview, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.recomendation_Text.setText(recomendations[position]);
        holder.recomendation_onclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserRatingData ratingData =  new UserRatingData();
                ratingData.setAppliedRecomendation(recomendations[position]);
                ratingData.setEmotions(emotion);
                ratingData.setInputdata(userInput);
                ratingData.setMatchedKeywords(emotionKeyMatched);
                new FeedBack( activity,ratingData).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return recomendations.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView recomendation_Text;
        private LinearLayout recomendation_onclick;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            recomendation_Text=itemView.findViewById(R.id.recomd_text);
            recomendation_onclick=(LinearLayout)itemView.findViewById(R.id.ok_click);
        }
    }
}
