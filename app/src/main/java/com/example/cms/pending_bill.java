package com.example.cms;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

import com.example.cms.adapter.pendingbill_Adapter;
import com.example.cms.pending_bills.Example;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class pending_bill extends AppCompatActivity {
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    //bill_detalis bill_detalis;
    pendingbill_Adapter pcRecycler;
    RecyclerView rv_list;
    String name, token;

    TextView textView;
    @Override
    @RequiresApi(api = Build.VERSION_CODES.N)
    @SuppressLint({"MissingInflatedId", "ResourceType", "WrongViewCast"})

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending_bill);

        textView = findViewById(R.id.billpannel);
        getSupportActionBar().setTitle("Pending Bill's");

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


        rv_list = findViewById(R.id.crv_list);
        getData(name);

        //navigation

        TextView navMachinecount,navtotcompalint,navComplaintcount,navpendingcount,navcompleteComplaintCount,navreviewComplaintCount,navAmcDateCheck;
        navMachinecount = findViewById(R.id.navmachine);
        navtotcompalint=findViewById(R.id.navtotcompalint);
        navComplaintcount = findViewById(R.id.navcomplain);
        navpendingcount = findViewById(R.id.navpanding);
        navcompleteComplaintCount = findViewById(R.id.navcomplited);
        navreviewComplaintCount=findViewById(R.id.navreview);
        navAmcDateCheck = findViewById(R.id.navamc);

        navtotcompalint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(pending_bill.this, party_complaint_Details.class);
                startActivity(i);
            }
        });
        navMachinecount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(pending_bill.this, dashboard.class);
                startActivity(i);
            }
        });navComplaintcount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(pending_bill.this, totmachine_Details.class);
                startActivity(i);
            }
        });navpendingcount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(pending_bill.this, panding_complaint.class);
                startActivity(i);
            }
        });navcompleteComplaintCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(pending_bill.this, complete_com.class);
                startActivity(i);
            }
        });navreviewComplaintCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(pending_bill.this, review_activity.class);
                startActivity(i);
            }
        });navAmcDateCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(pending_bill.this, AMC_Expire.class);
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

    private void getData(String name) {

        Call<Example> getlast_name = RetrofitApi.getInstance().getMyApi().getpendingbill(name);

        getlast_name.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(@NonNull Call<Example> call, @NonNull Response<Example> response) {

                if (response.body() != null) {
                    if (response.body().getStatusCode() != null) {

                        Log.d("responsedata", String.valueOf(response.body().getData()));

                        if (response.body().getData().size() == 0) {

                        } else {
                            pcRecycler = new pendingbill_Adapter(pending_bill.this, response.body().getData());
                            rv_list.setLayoutManager(new LinearLayoutManager(pending_bill.this));
                            rv_list.setAdapter(pcRecycler);
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Toast.makeText(pending_bill.this, "એક ભૂલ આવે છે", Toast.LENGTH_SHORT).show();
            }

        });
    }


}
