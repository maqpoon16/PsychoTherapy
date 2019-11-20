package com.example.psychotherapy.Thrapist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.psychotherapy.R;
import com.example.psychotherapy.adapter.QuestionsRoundAdapter;
import com.example.psychotherapy.adapter.ThrapistProfileAdapter;
import com.example.psychotherapy.model.ThrapistProfile;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AvailableThrapists extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    //  database
        private DatabaseReference myRef ;
        private ArrayList<ThrapistProfile> profiles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thrapist_layout);
        //To Authenticate
        FirebaseApp.initializeApp(this);
        recyclerView=(RecyclerView)findViewById(R.id.thrapists_recycleview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        myRef = FirebaseDatabase.getInstance().getReference();
        profiles = new ArrayList<>();
        //Calling Firebase Data
        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    String Name = snapshot.child("Name").getValue(String.class);
                    String Age = snapshot.child("Age").getValue(String.class);
                    String Qualification = snapshot.child("Qualification").getValue(String.class);
                    String Experience = snapshot.child("Experience").getValue(String.class);
                    String Status = snapshot.child("Status").getValue(String.class);
                    String Location = snapshot.child("Location").getValue(String.class);
                    ThrapistProfile thrapistProfile =new ThrapistProfile(Age,Experience,Location,Name,Qualification,Status);
                    profiles.add(thrapistProfile);
                }
                Log.d("Firebase_data", "Data ; "+profiles.get(0).getName());
                SetAdapter();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w("Firebase_error", "loadPost:onCancelled", databaseError.toException());
            }
        };
        //This will be Initialize Firebase
        myRef.child("Psychthrapy").addValueEventListener(postListener);
    }
    private void SetAdapter(){
        adapter = new ThrapistProfileAdapter(AvailableThrapists.this,profiles);
        recyclerView.setAdapter(adapter);
    }
    private void AddNewThrapist(String age, String experience, String location, String name, String qualification, String status) {
        ThrapistProfile thrapistProfile = new ThrapistProfile();
        myRef.child("Psychthrapy").child("2").setValue(thrapistProfile);
    }

}
