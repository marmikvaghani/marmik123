package com.example.cms;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cms.Panding_complaint.PandingExample;
import com.example.cms.adapter.panding_Adapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class panding_complaint extends AppCompatActivity {

    panding_Adapter ppRecycler;
    RecyclerView rv_list;
    String name, token;
    String iscompleted;
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;

    TextView textView;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @SuppressLint({"MissingInflatedId", "ResourceType", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panding_complaint);
        textView = findViewById(R.id.pandingpannel);
        getSupportActionBar().setTitle("Panding Complaint");

        drawerLayout = findViewById(R.id.my_drawer_layout_panding);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SharedPreferences sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        name = sharedPref.getString("username", "");

        iscompleted= sharedPref.getString("isCompleted","");


                rv_list = findViewById(R.id.prv_list);
                getData(name,iscompleted);


        //navigation

        TextView navMachinecount,navComplaintcount,navpendingcount,navcompleteComplaintCount,navreviewComplaintCount,navAmcDateCheck;
        navMachinecount = findViewById(R.id.navmachine);
        navComplaintcount = findViewById(R.id.navcomplain);
        navpendingcount = findViewById(R.id.navpanding);
        navcompleteComplaintCount = findViewById(R.id.navcomplited);
        navreviewComplaintCount=findViewById(R.id.navreview);
        navAmcDateCheck = findViewById(R.id.navamc);
        TextView  navpendingbill=findViewById(R.id.navpendingbill);

        navpendingbill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(panding_complaint.this, pending_bill.class);
                startActivity(i);
            }
        });
        navMachinecount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(panding_complaint.this, dashboard.class);
                startActivity(i);
            }
        });navComplaintcount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(panding_complaint.this, totmachine_Details.class);
                startActivity(i);
            }
        });navpendingcount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(panding_complaint.this, party_complaint_Details.class);
                startActivity(i);
            }
        });navcompleteComplaintCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(panding_complaint.this, complete_com.class);
                startActivity(i);
            }
        });navreviewComplaintCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(panding_complaint.this, review_activity.class);
                startActivity(i);
            }
        });navAmcDateCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(panding_complaint.this, AMC_Expire.class);
                startActivity(i);
            }
        });


    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

            private void getData(String name,String isCompleted) {

                Call<PandingExample> getlast = RetrofitApi.getInstance().getMyApi().getpandingcomplaint(name,isCompleted);

                getlast.enqueue(new Callback<PandingExample>() {
                    @Override
                    public void onResponse(@NonNull Call<PandingExample> call, @NonNull Response<PandingExample> response) {

                        if (response.body() != null) {
                            if (response.body().getStatusCode() != null) {

                                Log.d("responsedata", String.valueOf(response.body().getData()));

                                if (response.body().getData().size()==0){

                                }else{
                                    ppRecycler = new panding_Adapter(panding_complaint.this, response.body().getData());
                                    rv_list.setLayoutManager(new LinearLayoutManager(panding_complaint.this));
                                    rv_list.setAdapter(ppRecycler);
                                }
                            }
                        }
                    }
                    @Override
                    public void onFailure(Call<PandingExample> call, Throwable t) {
                        Toast.makeText(panding_complaint.this, "એક ભૂલ આવે છે", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }