package com.example.psychotherapy.model;

public class PatientDailyDiary{
    public  String id;
    public String date;
    public String inputdata;

    public PatientDailyDiary() {
    }

    public PatientDailyDiary(String id, String date, String inputdata) {
        this.id = id;
        this.date = date;
        this.inputdata = inputdata;
    }
}