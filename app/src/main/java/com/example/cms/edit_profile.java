package com.example.cms;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class edit_profile extends AppCompatActivity {

    Button save, cancel;
    String name;
    TextInputEditText login_username, city_username, mob_username, add_username;
    TextView textView;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @SuppressLint({"MissingInflatedId", "ResourceType", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        textView = findViewById(R.id.editpannel);
        getSupportActionBar().setTitle("Edit Profile");
        SharedPreferences sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        name = sharedPref.getString("username", "");
        //button
        save = findViewById(R.id.save);
        cancel = findViewById(R.id.cancel);
        //text
        login_username = findViewById(R.id.login_username);
        city_username = findViewById(R.id.city_username);
        mob_username = findViewById(R.id.mob_username);
        add_username = findViewById(R.id.add_username);

        Intent intent = getIntent();
        String str = intent.getStringExtra("userName_key");
        String str1 = intent.getStringExtra("city_key");
        String str2 = intent.getStringExtra("mob_key");
        String str3 = intent.getStringExtra("add_key");
        login_username.setText(str);
        city_username.setText(str1);
        mob_username.setText(str2);
        add_username.setText(str3);

        String uname = login_username.getText().toString();
        String city = city_username.getText().toString();
        String add = add_username.getText().toString();
        String stime = mob_username.toString();

        Log.d("Uname1", add);
        Log.d("Uname1", uname);
        Log.d("Uname1", city);
        Log.d("Uname1", stime);


     /*   save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startsubmitData(uname, city,mob_username,add);

            }
        });

    }

    private void startsubmitData(String name, String status, String time, String currentDate, String address, String longitude, String latitude) {


        Call<ProfileData> getlast_name = RetrofitApi.getInstance().getMyApi().getprofile(uname, city,mob_username,add);

        getlast_name.enqueue(new Callback<ProfileData>() {
            @Override
            public void onResponse(@NonNull Call<ProfileData> call, @NonNull Response<ProfileData> response) {

                if (response.body() != null) {
                    if (response.body().getStatusCode() != null) {

                        Log.d("responsedata", String.valueOf(response.body().getPartyProfile()));

                        if (response.body().getPartyProfile() != null) {

                        } else {
                            Toast.makeText(edit_profile.this, "Fail", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

             }

            @Override
            public void onFailure(@NonNull Call<ProfileData> call, @NonNull Throwable t) {
                Toast.makeText(edit_profile.this, "એક ભૂલ આવે છે", Toast.LENGTH_SHORT).show();
            }
        });*/

    }
}