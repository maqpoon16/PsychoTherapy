package com.example.psychotherapy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;

import com.example.psychotherapy.Database.DAO;
import com.example.psychotherapy.Database.RoomDB;
import com.example.psychotherapy.adapter.QuestionsRoundAdapter;
import com.example.psychotherapy.model.GlobalVariable;
import com.example.psychotherapy.model.QuestionsRound;

public class QuestionsRoundActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private String [] Question={
            "How are you feeling today?",
            "Could you please explain your problem briefly?",
            "Do you have any diseases which make you to think alot?",
            "Have you ever faced any trouble in school or college?",
            "What do you do for living",
            "How much qulification do you have?",
            "Describe you job and its responsibilities?",
            "What is your future plans?",
            "What you want to do in your life which will make you happy?",
            "Are you elder one child at your home?",
            "Do you have girlfriend?",
            "Are you married?"
    };
    ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_round);
        GlobalVariable.activity= QuestionsRoundActivity.this;

        recyclerView=(RecyclerView)findViewById(R.id.questions_round_recycleview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = new QuestionsRoundAdapter(this, Question);
        recyclerView.setAdapter(adapter);
    }

}
