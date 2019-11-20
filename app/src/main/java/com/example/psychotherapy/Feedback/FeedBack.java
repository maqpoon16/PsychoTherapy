package com.example.psychotherapy.Feedback;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.room.Room;

import com.example.psychotherapy.Database.RoomDB;
import com.example.psychotherapy.R;
import com.example.psychotherapy.SignupActivity;
import com.example.psychotherapy.UserInputActivity;
import com.example.psychotherapy.model.Sessions;
import com.example.psychotherapy.model.UserRatingData;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FeedBack extends Dialog {

    private Button done ;
    private Button rateOne;
    private Button rateTwo ;
    private Button rateThree;
    private Button rateFour;
    private Button rateFive;
    private Activity activity;
    private int Rating;
    //Database objects
    private UserRatingData ratingData;
    private RoomDB roomDB;
    public FeedBack(Activity activity,UserRatingData ratingData ) {
        super(activity);
        this.activity=activity;
        this.ratingData=ratingData;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.feedback_layout);
        rateOne = (Button) findViewById(R.id.btn_one);
        rateTwo = (Button) findViewById(R.id.btn_two);
        rateThree = (Button) findViewById(R.id.btn_three);
        rateFour = (Button) findViewById(R.id.btn_four);
        rateFive = (Button) findViewById(R.id.btn_five);
        done = (Button) findViewById(R.id.btn_done);

        Rating = 0 ;
        rateOne.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                if(Rating < 1){
                    rateOne.post(new Runnable() {
                        @Override
                        public void run() {
                            rateOne.setBackground(ContextCompat.getDrawable(activity, R.drawable.roundbuttonfill));
                            rateTwo.setBackground(ContextCompat.getDrawable(activity, R.drawable.roundbutton));
                            rateThree.setBackground(ContextCompat.getDrawable(activity, R.drawable.roundbutton));
                            rateFour.setBackground(ContextCompat.getDrawable(activity, R.drawable.roundbutton));
                            rateFive.setBackground(ContextCompat.getDrawable(activity, R.drawable.roundbutton));
                        }
                    });
                    Rating = 1;
                }else {
                    rateOne.post(new Runnable() {
                        @Override
                        public void run() {
                            rateOne.setBackground(ContextCompat.getDrawable(activity, R.drawable.roundbutton));
                            rateTwo.setBackground(ContextCompat.getDrawable(activity, R.drawable.roundbutton));
                            rateThree.setBackground(ContextCompat.getDrawable(activity, R.drawable.roundbutton));
                            rateFour.setBackground(ContextCompat.getDrawable(activity, R.drawable.roundbutton));
                            rateFive.setBackground(ContextCompat.getDrawable(activity, R.drawable.roundbutton));
                        }
                    });
                    Rating = 0;
                }
                Toast.makeText(activity, ""+Rating, Toast.LENGTH_SHORT).show();
            }
        });
        rateTwo.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                if(Rating < 2){
                    rateTwo.post(new Runnable() {
                        @Override
                        public void run() {
                            rateOne.setBackground(ContextCompat.getDrawable(activity, R.drawable.roundbuttonfill));
                            rateTwo.setBackground(ContextCompat.getDrawable(activity, R.drawable.roundbuttonfill));
                            rateThree.setBackground(ContextCompat.getDrawable(activity, R.drawable.roundbutton));
                            rateFour.setBackground(ContextCompat.getDrawable(activity, R.drawable.roundbutton));
                            rateFive.setBackground(ContextCompat.getDrawable(activity, R.drawable.roundbutton));
                        }
                    });
                    Rating = 2;
                }else {
                    rateTwo.post(new Runnable() {
                        @Override
                        public void run() {
                            rateTwo.setBackground(ContextCompat.getDrawable(activity, R.drawable.roundbutton));
                            rateThree.setBackground(ContextCompat.getDrawable(activity, R.drawable.roundbutton));
                            rateFour.setBackground(ContextCompat.getDrawable(activity, R.drawable.roundbutton));
                            rateFive.setBackground(ContextCompat.getDrawable(activity, R.drawable.roundbutton));
                        }
                    });
                    Rating = 1;
                }
                Toast.makeText(activity, ""+Rating, Toast.LENGTH_SHORT).show();
            }
        });
        rateThree.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                if(Rating < 3){
                    rateThree.post(new Runnable() {
                        @Override
                        public void run() {
                            rateOne.setBackground(ContextCompat.getDrawable(activity, R.drawable.roundbuttonfill));
                            rateTwo.setBackground(ContextCompat.getDrawable(activity, R.drawable.roundbuttonfill));
                            rateThree.setBackground(ContextCompat.getDrawable(activity, R.drawable.roundbuttonfill));
                            rateFour.setBackground(ContextCompat.getDrawable(activity, R.drawable.roundbutton));
                            rateFive.setBackground(ContextCompat.getDrawable(activity, R.drawable.roundbutton));

                        }
                    });
                    Rating = 3;
                }else {
                    rateThree.post(new Runnable() {
                        @Override
                        public void run() {
                            rateThree.setBackground(ContextCompat.getDrawable(activity, R.drawable.roundbutton));
                            rateFour.setBackground(ContextCompat.getDrawable(activity, R.drawable.roundbutton));
                            rateFive.setBackground(ContextCompat.getDrawable(activity, R.drawable.roundbutton));

                        }
                    });
                    Rating = 2;
                }
                Toast.makeText(activity, ""+Rating, Toast.LENGTH_SHORT).show();
            }
        });
        rateFour.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                if(Rating < 4){
                    rateFour.post(new Runnable() {
                        @Override
                        public void run() {
                            rateOne.setBackground(ContextCompat.getDrawable(activity, R.drawable.roundbuttonfill));
                            rateTwo.setBackground(ContextCompat.getDrawable(activity, R.drawable.roundbuttonfill));
                            rateThree.setBackground(ContextCompat.getDrawable(activity, R.drawable.roundbuttonfill));
                            rateFour.setBackground(ContextCompat.getDrawable(activity, R.drawable.roundbuttonfill));
                            rateFive.setBackground(ContextCompat.getDrawable(activity, R.drawable.roundbutton));
                        }
                    });
                    Rating = 4;
                }else {
                    rateFour.post(new Runnable() {
                        @Override
                        public void run() {
                            rateFour.setBackground(ContextCompat.getDrawable(activity, R.drawable.roundbutton));
                            rateFive.setBackground(ContextCompat.getDrawable(activity, R.drawable.roundbutton));

                        }
                    });
                    Rating = 3;
                }
                Toast.makeText(activity, ""+Rating, Toast.LENGTH_SHORT).show();
            }
        });
        rateFive.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                if(Rating < 5){
                    rateFive.post(new Runnable() {
                        @Override
                        public void run() {
                            rateOne.setBackground(ContextCompat.getDrawable(activity, R.drawable.roundbuttonfill));
                            rateTwo.setBackground(ContextCompat.getDrawable(activity, R.drawable.roundbuttonfill));
                            rateThree.setBackground(ContextCompat.getDrawable(activity, R.drawable.roundbuttonfill));
                            rateFour.setBackground(ContextCompat.getDrawable(activity, R.drawable.roundbuttonfill));
                            rateFive.setBackground(ContextCompat.getDrawable(activity, R.drawable.roundbuttonfill));
                        }
                    });
                    Rating = 5;
                }else {
                    rateFive.post(new Runnable() {
                        @Override
                        public void run() {
                            rateFive.setBackground(ContextCompat.getDrawable(activity, R.drawable.roundbutton));
                        }
                    });
                    Rating = 4;
                }
                Toast.makeText(activity, ""+Rating, Toast.LENGTH_SHORT).show();
            }
        });
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sessions LogInsession = new Sessions();
                LogInsession.SetSharedPrefs(activity,"LogIn");
                String date = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
                String email = LogInsession.GetString("User");
                ratingData.setEmail(email);
                ratingData.setDate(date);
                ratingData.setUserRated(String.valueOf(Rating));
                    try{
                    roomDB = Room.databaseBuilder(activity, RoomDB.class, "UserDB").allowMainThreadQueries().build();
                    roomDB.dao().RatingDataInsert(ratingData);
                    Toast.makeText(activity, "Thanks for Rating!", Toast.LENGTH_SHORT).show();
                    dismiss();

                }catch (Exception e){
                    Toast.makeText(activity, "Exception :"+e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                        dismiss();
                    }

            }
        });


    }


}
