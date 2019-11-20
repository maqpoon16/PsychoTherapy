package com.example.psychotherapy.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "userinputdata")
public class UserInputData {

    @PrimaryKey(autoGenerate = true)
    private  int id;

    @ColumnInfo(name ="_email")
    private String email = "" ;

    @ColumnInfo(name ="_date")
    private String date;

    @ColumnInfo(name ="_inputdata")
    private String inputdata;

    @ColumnInfo(name ="_sadmatching")
    private String isSadMatches;

    @ColumnInfo(name ="_angermatching")
    private String isAngerMatches;

    @ColumnInfo(name ="_ianxietymatching")
    private String isAnxietyMatches;

    @ColumnInfo(name ="_enjoymatching")
    private String isEnjoyMatches;

    @ColumnInfo(name ="_hopematching")
    private String isHopeMatches;


    public UserInputData() {
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

    public String getIsSadMatches() {
        return isSadMatches;
    }

    public void setIsSadMatches(String isSadMatches) {
        this.isSadMatches = isSadMatches;
    }

    public String getIsAngerMatches() {
        return isAngerMatches;
    }

    public void setIsAngerMatches(String isAngerMatches) {
        this.isAngerMatches = isAngerMatches;
    }

    public String getIsAnxietyMatches() {
        return isAnxietyMatches;
    }

    public void setIsAnxietyMatches(String isAnxietyMatches) {
        this.isAnxietyMatches = isAnxietyMatches;
    }

    public String getIsEnjoyMatches() {
        return isEnjoyMatches;
    }

    public void setIsEnjoyMatches(String isEnjoyMatches) {
        this.isEnjoyMatches = isEnjoyMatches;
    }

    public String getIsHopeMatches() {
        return isHopeMatches;
    }

    public void setIsHopeMatches(String isHopeMatches) {
        this.isHopeMatches = isHopeMatches;
    }
}
