package com.example.psychotherapy;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.example.psychotherapy.Database.DAO;
import com.example.psychotherapy.Database.RoomDB;
import com.example.psychotherapy.model.Country;
import com.example.psychotherapy.model.CountryList;
import com.example.psychotherapy.model.GlobalVariable;
import com.example.psychotherapy.model.SignupUser;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class SignupActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText et_fname,et_lname,et_user,et_pass,et_cpass,et_city,et_mcode,et_mobile;
    private RadioButton rb_female,rb_male;
    String Gender="Male",et_country;
    //Database objects
    private SignupUser user;
    private RoomDB roomDB;

    private Spinner CountryNameSpinner;
    private List<String> CountriesCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        try {
            GlobalVariable.activity = SignupActivity.this;
            //Database objects
            roomDB = RoomDB.getDatabase(SignupActivity.this);
            user = new SignupUser();
            CountryNameSpinner  = (Spinner) findViewById(R.id.et_country);
            CountryNameSpinner.setOnItemSelectedListener(this);
            SetCountryAndCodes();
            et_fname = (EditText) findViewById(R.id.et_fname);
            et_lname = (EditText) findViewById(R.id.et_lname);
            et_user = (EditText) findViewById(R.id.et_email);
            et_pass = (EditText) findViewById(R.id.et_password);
            et_cpass = (EditText) findViewById(R.id.et_cpassword);
          //  et_country = (EditText) findViewById(R.id.et_country);
            et_city = (EditText) findViewById(R.id.et_city);
            et_mobile = (EditText) findViewById(R.id.et_mobile);
            et_mcode = (EditText) findViewById(R.id.et_code);
            rb_female = (RadioButton) findViewById(R.id.rb_female);
            rb_male = (RadioButton) findViewById(R.id.rb_male);
            TextView tv_login_account = (TextView) findViewById(R.id.tv_login_account);
            Button btn_signup = (Button) findViewById(R.id.btn_signup);

            tv_login_account.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(SignupActivity.this, LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                }
            });

            btn_signup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (DataVerification()) {
                        Toast.makeText(SignupActivity.this, "Fill all fields!", Toast.LENGTH_LONG).show();
                    }else {
                        Datasaving();
                    }
                }
            });
        }catch (Exception e){
            Toast.makeText(this, ""+e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void Datasaving(){
        String mobile=et_mcode.getText().toString()+""+et_mobile.getText().toString();
        user.setFirstname(et_fname.getText().toString());
        user.setLastname(et_lname.getText().toString());
        user.setEmail(et_user.getText().toString());
        user.setPassword(et_pass.getText().toString());
      //  user.setCountry(et_country.getText().toString());
        user.setCity(et_city.getText().toString());
        user.setMobile(mobile);
        user.setGender(Gender);
        new insertAsyncTask().execute(user);

    }
    private boolean DataVerification(){
        if(et_fname.getText().toString().isEmpty()){
            return true;
        }
        if(et_lname.getText().toString().isEmpty()){
            return true;
        }
        if(et_user.getText().toString().isEmpty()){
            return true;
        }
        //to check user already exist
        if(IsUserExist()){
            return true;
        }
        if(et_pass.getText().toString().isEmpty()){
            return true;
        }if(et_cpass.getText().toString().isEmpty()){
            return true;
        }if(et_country.isEmpty()){
            return true;
        }if(et_city.getText().toString().isEmpty()){
            return true;
        }
        if(et_mobile.getText().toString().isEmpty()){
            return true;
        }
        if(et_mcode.getText().toString().isEmpty()){
            return true;
        }
        if(!et_pass.getText().toString().equals(et_cpass.getText().toString())){
            Toast.makeText(this, "Password and Confirm  Password does not matched!", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }

    private boolean IsUserExist(){
      //  roomDB = Room.databaseBuilder(SignupActivity.this, RoomDB.class, "UserDB").allowMainThreadQueries().build();
        SignupUser user =roomDB.dao().GetUserData(et_user.getText().toString());
        if(user!=null){
            if(!user.getEmail().isEmpty()){
                Toast.makeText(this, "User is already registered!", Toast.LENGTH_SHORT).show();
                return true;
            }

        }
        return false;
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rb_male:
                if (checked)
                    Gender="Male";
                rb_female.setChecked(false);
                    break;
            case R.id.rb_female:
                if (checked)
                    Gender="Female";
                rb_male.setChecked(false);
                    break;
        }
    }

    private void SetCountryAndCodes(){
        Gson gson = new Gson();
        CountryList countryList = gson.fromJson(GlobalVariable.CountryJson, CountryList.class);
        if(countryList!=null) {
            List<String> Countries  = new ArrayList<>();
            CountriesCode  = new ArrayList<>();
            for(Country country :countryList.getCountries()){
                Countries.add(country.getName());
                CountriesCode.add(""+country.getCode());
            }
            ArrayAdapter<String> CountriesAdapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_spinner_item, Countries);
            CountriesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            CountryNameSpinner.setAdapter(CountriesAdapter);

        }
    }

    // on country Selection Item,
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        et_country = CountryNameSpinner.getSelectedItem().toString();
        et_mcode.setText("+"+CountriesCode.get(position));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    @SuppressLint("StaticFieldLeak")
    private class insertAsyncTask extends AsyncTask<SignupUser, Void, Void> {
        private DAO mAsyncTaskDao;
        public insertAsyncTask() {
            mAsyncTaskDao = roomDB.dao();
        }
        @Override
        protected Void doInBackground(final SignupUser... params) {
            mAsyncTaskDao.UserDataInsert(params[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Toast.makeText(GlobalVariable.activity, "Data Saved!", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(SignupActivity.this, LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }
    }

}
