package com.example.cms;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
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

import com.example.cms.adapter.complete_recycler;
import com.example.cms.complaint.ComComplaint;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class complete_com extends AppCompatActivity {
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;

    complete_recycler pcRecycler;
    RecyclerView rv_list;
    String isCompleted;
    String name, token;
    TextView textView;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @SuppressLint({"MissingInflatedId", "ResourceType", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_com);
        textView = findViewById(R.id.completepannel);
        getSupportActionBar().setTitle("completed Complaint");

        drawerLayout = findViewById(R.id.my_drawer_layout_machine);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SharedPreferences sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        name = sharedPref.getString("username", "");
        isCompleted=sharedPref.getString("isCompleted","");
        rv_list = findViewById(R.id.crv_list);
        getData(name,isCompleted);



        //navigation

        TextView navMachinecount,navComplaintcount,navpendingcount,navcompleteComplaintCount,navreviewComplaintCount,navAmcDateCheck;
        navMachinecount = findViewById(R.id.navmachine);

        navComplaintcount = findViewById(R.id.navcomplain);
        navpendingcount = findViewById(R.id.navpanding);
        navcompleteComplaintCount = findViewById(R.id.navcomplited);
        navreviewComplaintCount=findViewById(R.id.navreview);
        navAmcDateCheck = findViewById(R.id.navamc);
        // complete_com.setBackgroundColor(Color.parseColor("#00A5FF"));

        TextView  navpendingbill=findViewById(R.id.navpendingbill);

        navpendingbill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(complete_com.this, pending_bill.class);
                startActivity(i);
            }
        });
        navMachinecount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(complete_com.this, dashboard.class);
                startActivity(i);
            }
        });navComplaintcount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(complete_com.this, totmachine_Details.class);
                startActivity(i);
            }
        });navpendingcount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(complete_com.this, party_complaint_Details.class);
                startActivity(i);
            }
        });navcompleteComplaintCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(complete_com.this, panding_complaint.class);
                startActivity(i);
            }
        });navreviewComplaintCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(complete_com.this, review_activity.class);
                startActivity(i);
            }
        });navAmcDateCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(complete_com.this, AMC_Expire.class);
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

        Call<ComComplaint> getlast_name = RetrofitApi.getInstance().getMyApi().getcomplit_comp(name,isCompleted);

        getlast_name.enqueue(new Callback<ComComplaint>() {
            @Override
            public void onResponse(@NonNull Call<ComComplaint> call, @NonNull Response<ComComplaint> response) {

                if (response.body() != null) {
                    if (response.body().getStatusCode() != null) {

                        Log.d("responsedata", String.valueOf(response.body().getData()));

                        if (response.body().getData().size()==0){

                            Toast.makeText(complete_com.this, "Fail", Toast.LENGTH_SHORT).show();

                        }else{

                            pcRecycler = new complete_recycler(complete_com.this, response.body().getData());
                            rv_list.setLayoutManager(new LinearLayoutManager(complete_com.this));
                            rv_list.setAdapter(pcRecycler);
                        }
                    }
                }
            }
            @Override
            public void onFailure(Call<ComComplaint> call, Throwable t) {
                Toast.makeText(complete_com.this, "એક ભૂલ આવે છે", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
