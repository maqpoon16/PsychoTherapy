package com.example.psychotherapy.Profile;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.room.Room;

import com.example.psychotherapy.Database.RoomDB;
import com.example.psychotherapy.LoginActivity;
import com.example.psychotherapy.R;
import com.example.psychotherapy.model.Sessions;
import com.example.psychotherapy.model.SignupUser;

public class UserProfile extends Dialog {

    private Button close  , update ;

   private Activity activity;
    //Database objects
    private SignupUser user;
    private EditText et_fname,et_lname,et_user,et_country,et_city,et_mobile,et_gender;
    String Gender="Male";
    //Database objects
    private RoomDB roomDB;
    Sessions LogInsession;

    public UserProfile(Activity activity ) {
        super(activity);
        this.activity=activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.userprofile_layout);
        try{
            close = (Button) findViewById(R.id.btn_close);
            update = (Button) findViewById(R.id.btn_update);
                //Database initialization
                user = new SignupUser();
            roomDB = Room.databaseBuilder(activity, RoomDB.class, "UserDB").allowMainThreadQueries().build();
            et_fname = (EditText) findViewById(R.id.et_fname);
                et_lname = (EditText) findViewById(R.id.et_lname);
                et_user = (EditText) findViewById(R.id.et_email);
                et_country = (EditText) findViewById(R.id.et_country);
                et_city = (EditText) findViewById(R.id.et_city);
                et_mobile = (EditText) findViewById(R.id.et_mobile);
            et_gender= (EditText) findViewById(R.id.et_gender);
            LoadPreviousData();

            update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                        user.setEmail(et_user.getText().toString());
                        user.setCity(et_city.getText().toString());
                        user.setCountry(et_country.getText().toString());
                        user.setFirstname(et_fname.getText().toString());
                        user.setLastname(et_lname.getText().toString());
                        user.setGender(et_gender.getText().toString());
                        user.setMobile(et_mobile.getText().toString());
                        roomDB.dao().UserDataUpdate(user);
                        Toast.makeText(activity, "Profile Updated!", Toast.LENGTH_SHORT).show();
                        dismiss();

            }
        });

            close.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dismiss();
                }
            });
        }catch (Exception e){
            Toast.makeText(activity, "Exception :"+e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            dismiss();
        }

    }
private void LoadPreviousData(){
    //Sessions
    LogInsession= new Sessions();
    LogInsession.SetSharedPrefs(activity,"LogIn");
    String email = LogInsession.GetString("User");

    if(!email.isEmpty()){
       user =  roomDB.dao().GetUserData(email);
        et_fname.setText(user.getFirstname());
        et_lname.setText(user.getLastname());
        et_user.setText(user.getEmail());
        et_country.setText(user.getCountry());
        et_city.setText(user.getCity());
        et_mobile.setText(user.getMobile());
        et_gender.setText(user.getGender());
    }else {
        Toast.makeText(activity, "Enable to get User Data!", Toast.LENGTH_SHORT).show();
    }

    }

}
