package com.example.psychotherapy.ExitDialouge;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.room.Room;

import com.example.psychotherapy.Database.RoomDB;
import com.example.psychotherapy.R;
import com.example.psychotherapy.model.SignupUser;

public class Exits extends Dialog {

    private Button no,yes ;
   private Activity activity;

    public Exits(Activity activity ) {
        super(activity);
        this.activity=activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.exit_layout);
        try{
            no = (Button) findViewById(R.id.btn_no);
            yes = (Button) findViewById(R.id.btn_yes);
           no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 dismiss();
            }
        });
           yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.finish();
            }
        });
        }catch (Exception e){
            Toast.makeText(activity, "Exception :"+e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            dismiss();
        }

    }

}
