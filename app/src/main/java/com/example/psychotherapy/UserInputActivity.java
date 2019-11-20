package com.example.psychotherapy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.psychotherapy.Database.RoomDB;
import com.example.psychotherapy.model.LoginUser;
import com.example.psychotherapy.model.Sessions;
import com.example.psychotherapy.model.UserInputData;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class UserInputActivity extends AppCompatActivity {


    EditText UserInputs;
    Button Btn_Save;


    List<String> sadKeywords;
    int sadMatches = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_input);
        UserInputs = (EditText)findViewById(R.id.userInput);
        Btn_Save = (Button) findViewById(R.id.btn_save);
        Btn_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ValidateInputs()){
                    Toast.makeText(UserInputActivity.this, "Please write something!", Toast.LENGTH_SHORT).show();
                }else {
                    SaveInputs();
                }
            }
        });
    }


    private  boolean ValidateInputs(){
        if(UserInputs.getText().toString().isEmpty()){
            return true;
        }
        if(UserInputs.getText().toString().length() <=200){
            return true;
        }
        return false;
    }
    private void SaveInputs(){
        try{
            //Db objects
            //Sessions
            Sessions LogInsession = new Sessions();
            LogInsession.SetSharedPrefs(UserInputActivity.this,"LogIn");
            RoomDB roomDB = Room.databaseBuilder(UserInputActivity.this, RoomDB.class, "UserDB").allowMainThreadQueries().build();
            UserInputData inputs = new UserInputData();
            String date = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
            String email = LogInsession.GetString("User");
            inputs.setDate(date);
            inputs.setEmail(email);
            inputs.setIsAngerMatches("0");
            inputs.setIsAnxietyMatches("0");
            inputs.setIsEnjoyMatches("0");
            inputs.setIsHopeMatches("0");
            inputs.setIsSadMatches(String.valueOf(sadMatches));
            inputs.setInputdata(UserInputs.getText().toString());
            roomDB.dao().UserInputInsert(inputs);
            Toast.makeText(UserInputActivity.this, "Data Saved! Sadness : "+sadMatches, Toast.LENGTH_LONG).show();
            CheckUserEmotion();

        }catch (Exception e){
            Toast.makeText(UserInputActivity.this, "Exception :"+e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
        }

    }

    private void CheckUserEmotion(){
        String UserWrites = UserInputs.getText().toString();
        ArrayList<Emotions> emoArraylist = new ArrayList<Emotions>();
        sadKeywords = Arrays.asList(getResources().getStringArray(R.array.sadness));
        for (String keyword: sadKeywords) {
            if(UserWrites.contains(keyword) || UserWrites.contains(keyword.toUpperCase())){
                sadMatches++;
            }
        }
        Emotions em =new Emotions();
        em.setEmotionName("Sad");
        em.setKeymatch(sadMatches);
        emoArraylist.add(em);

        em = getMax(emoArraylist );
        Intent intent=new Intent(UserInputActivity.this, RecomendationActivity.class);
        intent.putExtra("EmotionName",em.getEmotionName());
        intent.putExtra("KeywordsMatched",String.valueOf(em.getKeymatch()));
        intent.putExtra("InputData",UserWrites);
        startActivity(intent);

    }
    private Emotions getMax( ArrayList<Emotions> list){
        Emotions  max =list.get(0);
        for(int i=0; i<list.size(); i++){
            if(list.get(i).getKeymatch() > max.getKeymatch()){
                max.setKeymatch(list.get(i).getKeymatch());
            }
        }
        return max;
    }
    private class Emotions{
        private String EmotionName;
        private int Keymatch;

        String getEmotionName() {
            return EmotionName;
        }

        void setEmotionName(String emotionName) {
            EmotionName = emotionName;
        }

         int getKeymatch() {
            return Keymatch;
        }

        void setKeymatch(int keymatch) {
            Keymatch = keymatch;
        }
    }
}
