package com.example.psychotherapy.model;

import java.util.List;

public class PatientsListModel {
    public  String id;
    public String email;
    public String password ;
    public String firstname ;
    public String lastname ;
    public String country;
    public String city;
    public String gender;
    public String mobile ;
    public List<PatientDailyDiary>  PateintDiary;
    public PatientsListModel(String id, String email, String password, String firstname, String lastname, String country, String city, String gender, String mobile,List<PatientDailyDiary> pateintDiary) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.country = country;
        this.city = city;
        this.gender = gender;
        this.mobile = mobile;
        this.PateintDiary = pateintDiary;
    }

    public PatientsListModel() {

    }

}
