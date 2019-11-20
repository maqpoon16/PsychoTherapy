package com.example.psychotherapy.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_ratings")
public class UserRatingData {

    @PrimaryKey(autoGenerate = true)
    private  int id;

    @ColumnInfo(name ="_email")
    private String email = "" ;

    @ColumnInfo(name ="_date")
    private String date;

    @ColumnInfo(name ="_inputdata")
    private String inputdata;

    @ColumnInfo(name ="_emotion")
    private String emotions;

    @ColumnInfo(name ="_matchingkeyword")
    private String matchedKeywords;

    @ColumnInfo(name ="_applied_recomendation")
    private String appliedRecomendation;

    @ColumnInfo(name ="_rating")
    private String userRated;

    public UserRatingData() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getInputdata() {
        return inputdata;
    }

    public void setInputdata(String inputdata) {
        this.inputdata = inputdata;
    }

    public String getEmotions() {
        return emotions;
    }

    public void setEmotions(String emotions) {
        this.emotions = emotions;
    }

    public String getMatchedKeywords() {
        return matchedKeywords;
    }

    public void setMatchedKeywords(String matchedKeywords) {
        this.matchedKeywords = matchedKeywords;
    }

    public String getUserRated() {
        return userRated;
    }

    public void setUserRated(String userRated) {
        this.userRated = userRated;
    }


    public String getAppliedRecomendation() {
        return appliedRecomendation;
    }

    public void setAppliedRecomendation(String appliedRecomendation) {
        this.appliedRecomendation = appliedRecomendation;
    }
}
