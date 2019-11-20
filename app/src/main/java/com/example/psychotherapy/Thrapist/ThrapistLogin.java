package com.example.psychotherapy.Thrapist;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.room.Room;

import com.example.psychotherapy.Database.RoomDB;
import com.example.psychotherapy.R;
import com.example.psychotherapy.model.LoginUser;
import com.example.psychotherapy.model.Sessions;
import com.example.psychotherapy.model.UserRatingData;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ThrapistLogin extends Dialog {

    private EditText et_username;
    private EditText et_password;
    private TextView tv_create_account;
    private Button btn_login;
    private Activity activity;
    private CheckBox IsRemeber;
    private TextView forget_pass;
    private LoginUser loginUser;
    //  database
    private DatabaseReference myRef ;
    public ThrapistLogin(Activity activity) {
        super(activity);
        this.activity=activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.therapistlogin_layout);
        IsRemeber = (CheckBox) findViewById(R.id.IsRememberMeChecked);
        et_username=(EditText)findViewById(R.id.et_user);
        et_password=(EditText)findViewById(R.id.et_password);
        forget_pass=(TextView) findViewById(R.id.forget_pass);
        tv_create_account=(TextView)findViewById(R.id.tv_create_account);
        btn_login=(Button)findViewById(R.id.btn_login);
        loginUser= new LoginUser();
        myRef = FirebaseDatabase.getInstance().getReference();

        tv_create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Coming Soon!", Toast.LENGTH_SHORT).show();

            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!IsValid()){
                    loginUser.setEmail(et_username.getText().toString());
                    loginUser.setPassword(et_password.getText().toString());
                    IsValidUser(loginUser);
                }else {
                    Toast.makeText(activity, "Fill Username and Password Correctly!", Toast.LENGTH_SHORT).show();
                }

            }
        });
        forget_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "Coming Soon!", Toast.LENGTH_SHORT).show();
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
    private void IsValidUser(final LoginUser loginUser){
        if(isNetworkConnected()) {
            try {
                //Calling Firebase Data
                final ValueEventListener postListener = new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String id ="";
                        String pass ="";
                        // Get Post object and use the values to update the UI
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                             id = snapshot.child("id").getValue(String.class);
                            if(id.equals(loginUser.getEmail())){
                                pass = snapshot.child("pass").getValue(String.class);
                                break;
                            }
                        }
                        if(pass!="" && pass.equals(loginUser.getPassword())){
                            Toast.makeText(activity, "Password Matched!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Getting Post failed, log a message
                        Log.w("Firebase_error", "loadPost:onCancelled", databaseError.toException());
                    }
                };
                //This will be Initialize Firebase
                myRef.child("Psychthrapy").addValueEventListener(postListener);

            } catch (Exception e) {
                Toast.makeText(activity, "Exception :" + e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        }else {
            Toast.makeText(activity, "No Internet Available!", Toast.LENGTH_LONG).show();
        }

    }
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }
}
