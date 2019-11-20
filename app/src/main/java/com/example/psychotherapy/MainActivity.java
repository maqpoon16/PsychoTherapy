package com.example.psychotherapy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.psychotherapy.ExitDialouge.Exits;
import com.example.psychotherapy.Profile.UserProfile;
import com.example.psychotherapy.adapter.MainItemAdapter;

public class MainActivity extends AppCompatActivity {
   private RecyclerView recycleview;
    private RecyclerView.Adapter adapter;

    private TextView Userprofile;
    private String [] Menu={
            "Your Private Space anonymous & Secure",
            "You are doing great !\n Contine with same spirit",
            "Look what we found? \n You seem sad!",
            "Talk to your Coach right away.",
            "Look what we suggest you",
            "Let me ask you some more question"


    };

    private String [] menu_click={

            "Daily Dairies",
            "Check Your Results",
            "Your Weekly Report",
            "Start Chating",
            "Suggestion",
            "Questions Round"


    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    Userprofile = (TextView) findViewById(R.id.userprofile) ;
    Userprofile.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            new UserProfile(MainActivity.this).show();
        }
    });

recycleview=(RecyclerView)findViewById(R.id.recycleview);
        recycleview.setHasFixedSize(true);
        recycleview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = new MainItemAdapter(this, Menu,menu_click);
        recycleview.setAdapter(adapter);


    }

    @Override
    public void onBackPressed() {
        new Exits(this).show();
    }
}
