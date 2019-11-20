package com.example.psychotherapy.Thrapist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.psychotherapy.R;
import com.example.psychotherapy.adapter.ThrapistProfileAdapter;
import com.example.psychotherapy.model.PatientDailyDiary;
import com.example.psychotherapy.model.PatientsListModel;
import com.example.psychotherapy.model.SignupUser;
import com.example.psychotherapy.model.ThrapistProfile;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PatientsList extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    //  database
    private DatabaseReference myRef ;
    private ArrayList<PatientsListModel> profiles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patientslist_layout);
        //To Authenticate
        FirebaseApp.initializeApp(this);
        recyclerView=(RecyclerView)findViewById(R.id.patientlist_recycleview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        myRef = FirebaseDatabase.getInstance().getReference();
        //Calling Firebase Data
        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    if(snapshot!=null) {
                        String Id = snapshot.child("id").getValue(String.class);
                        String Email = snapshot.child("email").getValue(String.class);
                        String firstname = snapshot.child("firstname").getValue(String.class);
                        String lastname = snapshot.child("lastname").getValue(String.class);
                        String country = snapshot.child("country").getValue(String.class);
                        String city = snapshot.child("city").getValue(String.class);
                        String gender = snapshot.child("gender").getValue(String.class);
                        String mobile = snapshot.child("mobile").getValue(String.class);
                        List<PatientDailyDiary> patient_diaries = new ArrayList<>();
                        for (DataSnapshot diaries : dataSnapshot.child("Diaries").getChildren()){
                            String pid = diaries.child("id").getValue(String.class);
                            String pdate = diaries.child("date").getValue(String.class);
                            String pdata = diaries.child("inputdata").getValue(String.class);
                            PatientDailyDiary pdiary = new PatientDailyDiary(pid,pdate,pdata);
                            patient_diaries.add(pdiary);
                        }
                        PatientsListModel pateintdetail = new PatientsListModel(Id, Email, "", firstname, lastname, country, city, gender, mobile,patient_diaries);
                        profiles.add(pateintdetail);
                    }
                }
                SetAdapter();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w("Firebase_error", "loadPost:onCancelled", databaseError.toException());
            }
        };
        //This will be Initialize Firebase
        myRef.child("PatientLists").addValueEventListener(postListener);

    }
    private void SetAdapter(){
       // adapter = new ThrapistProfileAdapter(PatientsList.this,profiles);
     //   recyclerView.setAdapter(adapter);
    }
}
