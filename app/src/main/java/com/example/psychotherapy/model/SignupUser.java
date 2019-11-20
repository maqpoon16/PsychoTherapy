package com.example.psychotherapy.model;

import android.content.Context;
import android.widget.Toast;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Room;

import com.example.psychotherapy.Database.RoomDB;

@Entity(tableName = "userinfo")
public class SignupUser {

    @PrimaryKey(autoGenerate = true)
    private  int id;
    @ColumnInfo(name ="_email")
    private String email = "" ;
    @ColumnInfo(name ="_password")
    private String password = "";
    @ColumnInfo(name ="_firstname")
    private String firstname = "";
    @ColumnInfo(name ="_lastname")
    private String lastname = "";
    @ColumnInfo(name ="_country")
    private String country = "";
    @ColumnInfo(name ="_city")
    private String city = "";
    @ColumnInfo(name ="_gender")
    private String gender = "";
    @ColumnInfo(name ="_mobile")
    private String mobile = "";


    public SignupUser() {

    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



}
