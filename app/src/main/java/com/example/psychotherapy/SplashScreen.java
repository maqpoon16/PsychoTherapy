package com.example.psychotherapy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Thread thread=new Thread(){
            @Override
            public void run() {
                try{

                    sleep(1000);
                }catch (Exception ex){

                }
                finally {

                    Intent intent=new Intent(SplashScreen.this,LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();

                }
            }
        };
        thread.start();
    }
}
