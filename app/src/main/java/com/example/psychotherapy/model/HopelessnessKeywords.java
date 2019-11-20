package com.example.psychotherapy.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "hopelessness_keywords")
public class HopelessnessKeywords {
    @PrimaryKey(autoGenerate = true)
    private  int id;

    @ColumnInfo(name ="_keyname")
    private String keyname;

    public HopelessnessKeywords() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKeyname() {
        return keyname;
    }

    public void setKeyname(String keyname) {
        this.keyname = keyname;
    }
}
