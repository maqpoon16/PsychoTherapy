package com.example.psychotherapy;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.app.Activity;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.psychotherapy.Database.RoomDB;
import com.example.psychotherapy.OTP.OTPGenerator;
import com.example.psychotherapy.PasswordDialogue.ForgotPassword;
import com.example.psychotherapy.Thrapist.ThrapistLogin;
import com.example.psychotherapy.model.LoginUser;
import com.example.psychotherapy.model.Sessions;
import com.google.firebase.FirebaseApp;

public class LoginActivity extends AppCompatActivity {
    private EditText et_username;
    private EditText et_password;
    //Thrapist Login
    private ImageView TLogin;
    private TextView tv_create_account;
    private Button btn_login;
    //Db objects
    private RoomDB roomDB;
    private LoginUser loginUser;

    Sessions LogInsession;

    private CheckBox IsRemeber;

    private TextView forget_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //To Authenticate
        FirebaseApp.initializeApp(this);
        //Initialization for db
        loginUser= new LoginUser();
        //Sessions
        LogInsession= new Sessions();
        LogInsession.SetSharedPrefs(LoginActivity.this,"LogIn");
        //If user already loggIn then open Index Activity
        if(LogInsession.GetBoolean("IsLoggedIn")){
            Intent intent=new Intent(LoginActivity.this, MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }
        IsRemeber = (CheckBox) findViewById(R.id.IsRememberMeChecked);
        et_username=(EditText)findViewById(R.id.et_user);
        et_password=(EditText)findViewById(R.id.et_password);
        forget_pass=(TextView) findViewById(R.id.forget_pass);
        tv_create_account=(TextView)findViewById(R.id.tv_create_account);
        btn_login=(Button)findViewById(R.id.btn_login);
        TLogin =(ImageView) findViewById(R.id.login_logo);

        tv_create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this, SignupActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!IsValid()){
                    GenerateOTP();
                    loginUser.setEmail(et_username.getText().toString());
                    loginUser.setPassword(et_password.getText().toString());
                    IsValidUser(loginUser);
                }else {
                    Toast.makeText(LoginActivity.this, "Fill Username and Password Correctly!", Toast.LENGTH_SHORT).show();
                }

            }
        });
        forget_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new ForgotPassword(LoginActivity.this).show();
            }
        });
        TLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new ThrapistLogin(LoginActivity.this).show();
            }
        });
    }
    private  boolean IsValid(){
        if(et_username.getText().toString().isEmpty()){
            return true;
        }
        if(et_password.getText().toString().isEmpty()){
            return true;
        }
        return false;
    }

    private void IsValidUser(LoginUser user){
        try{
            roomDB = Room.databaseBuilder(LoginActivity.this, RoomDB.class, "UserDB").allowMainThreadQueries().build();
            String result= roomDB.dao().GetUserAuthentication(user.getEmail());
            if(result!=null){
                if(user.getPassword().equals(result)){
                    if(IsRemeber.isChecked()) {
                        LogInsession.SetBoolean("IsLoggedIn", true);
                        LogInsession.SetString("User",user.getEmail());
                    }
                    LogInsession.SetString("User",user.getEmail());
                    Toast.makeText(LoginActivity.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(LoginActivity.this, MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();

                }else{
                    Toast.makeText(LoginActivity.this, "Incorrect Username/Password!", Toast.LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(LoginActivity.this, "User is not registered!", Toast.LENGTH_SHORT).show();
            }

        }catch (Exception e){
            Toast.makeText(LoginActivity.this, "Exception :"+e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
        }

    }
    private void GenerateOTP(){
        new OTPGenerator("+923133106243");
    }
}
