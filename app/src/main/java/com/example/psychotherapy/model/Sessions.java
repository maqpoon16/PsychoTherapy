package com.example.psychotherapy.model;

import android.content.Context;
import android.content.SharedPreferences;

public class Sessions {
    //this to  getdata from sharedpreference
    private SharedPreferences sharedpreferences;
    //this for to save data to shared preference
    private SharedPreferences.Editor editor;

    public  void SetSharedPrefs(Context context,String PreferenceName){
        sharedpreferences = context.getSharedPreferences(PreferenceName, Context.MODE_PRIVATE);
        editor = sharedpreferences.edit();
    }
    public void SetString(String Keyname,String KeyValue){
        editor.putString(Keyname, KeyValue);
        editor.commit();
    }
    public String GetString(String Keyname){
        return  sharedpreferences.getString(Keyname,null);
    }
    public void SetBoolean(String Keyname,Boolean KeyValue){
        editor.putBoolean(Keyname, KeyValue);
        editor.commit();
    }
    public Boolean GetBoolean(String Keyname){
        return  sharedpreferences.getBoolean(Keyname,false);
    }

}
