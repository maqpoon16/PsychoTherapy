package com.example.psychotherapy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.psychotherapy.Thrapist.AvailableThrapists;
import com.example.psychotherapy.adapter.RecomendationsAdapter;

public class RecomendationActivity extends AppCompatActivity {
    private RecyclerView recycleview;
    private RecyclerView.Adapter adapter;
    private String [] Recomendations ;
    private Button btn_checkThrapists;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recomendation_layout);
        String EmotionName=getIntent().getStringExtra("EmotionName");
        String EmotionKeyMatched = getIntent().getStringExtra("KeywordsMatched");
        String UserInput = getIntent().getStringExtra("InputData");
        recycleview=(RecyclerView)findViewById(R.id.recycleview);
        btn_checkThrapists = (Button) findViewById(R.id.btn_checkThrapists);
        btn_checkThrapists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RecomendationActivity.this, AvailableThrapists.class));
            }
        });
        recycleview.setHasFixedSize(true);
        recycleview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        switch (EmotionName){
            case "Sad":{
                Recomendations = new String[]{
                        "Offer Salah",
                        "Do yoga",
                        "Read a book",
                        "Listen to music a podcast",
                        "Turn off your phone/ tablet/ computer for an hour and so",
                        "Breath deap",
                        "Call a family member",
                        "Drink a glass of water",
                        "Ask someone to sit with you",
                        "Go for a walk",
                        "Clench your toes for muscle relaxation",
                        "Start gardening",
                        "Play sports to get moving",
                        "Help a stranger",
                        "Make a gratitude list",
                        "Take a nap",
                        "Take a bath",
                        "Eat a healthy favourite snack",
                        "Make a list of places you want to visit",
                        "Draw how you are feeling"
                };
              break;
            }
            case "Anger":{

            Toast.makeText(this, "Sorry Work in progress!", Toast.LENGTH_SHORT).show();

             break;
            }
            case "Anxiety":{
            Toast.makeText(this, "Sorry Work in progress!", Toast.LENGTH_SHORT).show();
                break;
            }
            case "Hopeless":{
            Toast.makeText(this, "Sorry Work in progress!", Toast.LENGTH_SHORT).show();
                break;
            }
            case "Enjoy":{
            Toast.makeText(this, "Sorry Work in progress!", Toast.LENGTH_SHORT).show();

                break;
            }
        }

        adapter = new RecomendationsAdapter(this, EmotionName,EmotionKeyMatched,UserInput,Recomendations,RecomendationActivity.this);
        recycleview.setAdapter(adapter);
    }
}
