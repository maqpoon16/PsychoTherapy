package com.example.psychotherapy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.psychotherapy.Database.RoomDB;
import com.example.psychotherapy.adapter.RecomendationsAdapter;
import com.example.psychotherapy.adapter.ReportsAdapter;
import com.example.psychotherapy.model.UserRatingData;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class RepotsActivity extends AppCompatActivity {
    private RecyclerView recycleview;
    private RecyclerView.Adapter adapter;
    private Spinner spinner_dates;
    //Database objects
    private List<UserRatingData> GetRatingData;
    private RoomDB roomDB;
    @SuppressLint("SimpleDateFormat")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reports_layout);
        try{
            roomDB = Room.databaseBuilder(RepotsActivity.this, RoomDB.class, "UserDB").allowMainThreadQueries().build();
            spinner_dates = (Spinner) findViewById(R.id.spinner_dates);
            //Papolates Spinner Dates
            SetDates();

            recycleview=(RecyclerView)findViewById(R.id.recycleview);
            recycleview.setHasFixedSize(true);
            recycleview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            adapter = new ReportsAdapter(RepotsActivity.this, GetRatingData);
            recycleview.setAdapter(adapter);
            spinner_dates.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    String selectedDate =spinner_dates.getSelectedItem().toString();
                    if(spinner_dates.getSelectedItemId()>0) {
                        GetRatingData = roomDB.dao().GetRatingData(selectedDate);
                        adapter = new ReportsAdapter(RepotsActivity.this, GetRatingData);
                        recycleview.setAdapter(adapter);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        }catch (Exception e){
            Toast.makeText(RepotsActivity.this, "Exception :"+e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
        }

    }

    private  void SetDates(){
        GetRatingData = roomDB.dao().GetAllRatingData();
        if(GetRatingData!=null) {
            List<String> dates = new ArrayList<>();
            dates.add("~~ Select Date ~~");
            for (UserRatingData d : GetRatingData) {
                dates.add(d.getDate());
            }
            ArrayAdapter<String> addapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dates);
            spinner_dates.setAdapter(addapter);
        }
    }
}
