package com.example.cms;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.cms.model.Example;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Splash_Screen extends AppCompatActivity {

    EditText userName, password;
    Button btnSubmit;
    android.widget.ProgressBar ProgressBar;
    int counter=0;
    String userName1=null,pass1=null;

    TextView id;

    SharedPreferences shp;
    SharedPreferences.Editor shpEditor;
    SharedPreferences sharedPreferences;

    EditText editText;

    TextView textView;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @SuppressLint({"MissingInflatedId", "ResourceType", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        textView = findViewById(R.id.loginepannel);
        getSupportActionBar().setTitle("User Login");
//            requestWindowFeature(Window.FEATURE_NO_TITLE);
//            getSupportActionBar().hide();

        editText=findViewById(R.id.etToken);

        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            System.out.println("Fetching FCM registration token failed");
                            return;
                        }

                        // Get new FCM registration token
                        String token = task.getResult();

                        // Log and toast
                        System.out.println(token);
                        //Toast.makeText(party_complaint_Details.this, "Tokan Is"+token, Toast.LENGTH_SHORT).show();

                        editText.setText(token);

                        Log.d("tokan",token);
                    }
                });


        id=findViewById(R.id.id);
        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        boolean isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false);

        if (isLoggedIn) {
            // The user is already logged in, so start the HomeActivity

            // noti_tokan(id.getText().toString(),editText.getText().toString());

            Intent intent = new Intent(Splash_Screen.this, dashboard.class);
            startActivity(intent);
            finish(); // call finish() to prevent the user from going back to the login screen
        } else {
            // The user is not logged in, so show the login screen
            setContentView(R.layout.activity_splash_screen);

            // ... other code ...
        }

        userName =findViewById(R.id.login_username);
        password=findViewById(R.id.login_pass);
        ProgressBar = findViewById(R.id.progressbar);

        btnSubmit = findViewById(R.id.btnSubmit_login);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                userName1 = userName.getText().toString();
                pass1 = password.getText().toString();


                if (userName1.equals("") || userName1==null){
                    Toast.makeText(Splash_Screen.this,"નામ દાખલ કરો",Toast.LENGTH_LONG).show();
                }else if (pass1.equals("") || pass1==null){
                    Toast.makeText(Splash_Screen.this,"પાસવર્ડ દાખલ કરો",Toast.LENGTH_LONG).show();
                }else{
                    ProgressBar.setVisibility(View.VISIBLE);

                    apiCall(userName1,pass1);
                }
            }
            private void apiCall(String userName1, String pass1) {

                Call<Example> getlast_name= RetrofitApi.getInstance().getMyApi().Login(userName1,pass1);
                getlast_name.enqueue(new Callback<Example>() {
                    @Override
                    public void onResponse(@NonNull Call<Example> call, @NonNull Response<Example> response) {
                        Log.d("tresponse",response.body().toString());

                        if(response.body()!=null){
                            if (response.body().getStatusCode()!=null){

                                if (response.body().getStatusCode().equals(200)){

                                    id.setText(String.valueOf(response.body().getId()));

                                    Log.d("dddd",id.toString());

                                    noti_tokan(id.getText().toString(),editText.getText().toString());

                                    Log.d("asdfghjkl",id.getText().toString());
                                    Log.d("asdfghjkl",editText.getText().toString());

                                    AlertDialog.Builder builder = new AlertDialog.Builder(Splash_Screen.this);
                                    LayoutInflater inflater = getLayoutInflater();
                                    View dialogView = inflater.inflate(R.layout.progress_dialog, null);
                                    builder.setView(dialogView);
                                    builder.setTitle("Progress Dialog");
                                    builder.setMessage("Please wait...");
//                                   ProgressBar.setProgress(50);
                                    AlertDialog dialog = builder.create();
                                    dialog.show();


                                    Intent intent = new Intent(Splash_Screen.this,dashboard.class);
                                    startActivity(intent);


                                    ProgressBar.setVisibility(View.INVISIBLE);
                                    SharedPreferences.Editor editor = sharedPreferences.edit();
                                    editor.putString("username", userName1);
                                    editor.putString("password", pass1);
                                    editor.putBoolean("isLoggedIn", true);
                                    editor.apply();

                                    dialog.dismiss();


//   Toast.makeText(loginpage.this,"એન્જિનિયર સફળતાપૂર્વક લૉગિન થઈ ગયો.",Toast.LENGTH_SHORT).show();
//                                    ProgressBar.setVisibility(View.INVISIBLE);

                                }else{
                                    ProgressBar.setVisibility(View.INVISIBLE);
                                    AlertDialog.Builder alertDialog=new AlertDialog.Builder(Splash_Screen.this);
                                    alertDialog.setTitle("ERROR");
                                    alertDialog.setMessage("UserName or Password is Wrong.");

                                    alertDialog.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    });
                                    alertDialog.show();
                                    //  Toast.makeText(loginpage.this,"એન્જિનિયરનું નામ કે પાસવર્ડ ખોટો છે!",Toast.LENGTH_LONG).show();
                                }
                            }
                        }
//                List<Datum> datumList=response.body();
                    }
                    @Override
                    public void onFailure(@NonNull Call<Example> call, Throwable t) {
                        Toast.makeText(Splash_Screen.this, "તમારું ઇન્ટરનેટ શરૂ કરો", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

    }
    private void noti_tokan(String id, String tokan) {

        FooRequest1 fooRequest = new FooRequest1(id, tokan);

        Call<com.example.cms.notification.Example> call = RetrofitApi.getInstance().getMyApi().getNotification(id,fooRequest);
        call.enqueue(new Callback<com.example.cms.notification.Example>() {

            @Override
            public void onResponse(Call<com.example.cms.notification.Example> call, Response<com.example.cms.notification.Example> response) {
                if(response.isSuccessful()) {
                    Log.d("response", response.body().toString());
                } else {
                    Log.d("response", "Error: " + response.code());
                }
            }

            @Override
            public void onFailure(@NonNull Call<com.example.cms.notification.Example> call, @NonNull Throwable t) {
                Log.e("Error", t.getMessage());
            }
        });
    }
 /*   @Override
    public void onBackPressed() {


        super.onBackPressed();

        try {
            if (shp == null)
                shp = getSharedPreferences("Login", MODE_PRIVATE);

            shpEditor = shp.edit();
            shpEditor.putString("name", "");
            shpEditor.commit();

            Intent i = new Intent(Splash_Screen.this, dashboard.class);
            startActivity(i);
            finish();

        } catch (Exception ex) {
            Toast.makeText(Splash_Screen.this, ex.getMessage().toString(), Toast.LENGTH_LONG).show();
        }
    }
*/
}