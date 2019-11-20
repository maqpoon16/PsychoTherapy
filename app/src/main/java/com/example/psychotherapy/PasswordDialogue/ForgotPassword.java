package com.example.psychotherapy.PasswordDialogue;

import android.app.Activity;
import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.room.Room;

import com.example.psychotherapy.Database.RoomDB;
import com.example.psychotherapy.R;
import com.example.psychotherapy.model.Sessions;
import com.example.psychotherapy.model.SignupUser;
import com.example.psychotherapy.model.UserRatingData;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ForgotPassword extends Dialog {

    private Button save ;
    private EditText et_user,et_pass;
   private Activity activity;
    //Database objects
    private SignupUser user;
    private RoomDB roomDB;
    public ForgotPassword(Activity activity ) {
        super(activity);
        this.activity=activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.forgetpassword_layout);
        try{
        save = (Button) findViewById(R.id.btn_done);
            et_user=(EditText)findViewById(R.id.et_user) ;
            et_pass=(EditText)findViewById(R.id.et_password) ;
            
        roomDB = Room.databaseBuilder(activity, RoomDB.class, "UserDB").allowMainThreadQueries().build();
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    isUserValid();
                    if(user!=null){
                        user.setPassword(et_pass.getText().toString().trim());
                        roomDB.dao().UserDataUpdate(user);
                        Toast.makeText(activity, "New Password saved!", Toast.LENGTH_SHORT).show();
                        dismiss();
                    }else {
                        Toast.makeText(activity, "User not found!", Toast.LENGTH_SHORT).show();
                    }
            }
        });
        }catch (Exception e){
            Toast.makeText(activity, "Exception :"+e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            dismiss();
        }

    }
private void isUserValid(){
    if(!et_user.getText().toString().isEmpty()){
       user =  roomDB.dao().GetUserData(et_user.getText().toString().trim());
    }else {
        Toast.makeText(activity, "Enter User id / email!", Toast.LENGTH_SHORT).show();
    }
    if(et_pass.getText().toString().isEmpty()){
        Toast.makeText(activity, "Enter password", Toast.LENGTH_SHORT).show();
    }
}

}
