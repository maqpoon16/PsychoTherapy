package com.example.psychotherapy.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "questionsround")
public class QuestionsRound {

    @ColumnInfo(name ="_question")
    private String question;

    @ColumnInfo(name ="_answer")
    private String answer ;

    @ColumnInfo(name ="_date")
    private  String  datesubmitted;

    @PrimaryKey(autoGenerate = true)
    private  int id;

    public QuestionsRound(String question, String answer, String datesubmitted) {
        this.question = question;
        this.answer = answer;
        this.datesubmitted = datesubmitted;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getDatesubmitted() {
        return datesubmitted;
    }

    public void setDatesubmitted(String datesubmitted) {
        this.datesubmitted = datesubmitted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
