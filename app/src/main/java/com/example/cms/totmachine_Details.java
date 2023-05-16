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
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cms.adapter.tot_recycler;
import com.example.cms.party_details.MDExample;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class totmachine_Details extends AppCompatActivity {
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    tot_recycler recyclerAdapter;
    RecyclerView rv_list;

    AlertDialog.Builder builder;
    String name, token;

    TextView textView;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @SuppressLint({"MissingInflatedId", "ResourceType", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_totmachine_details);
        textView = findViewById(R.id.totmachinepannel);
        getSupportActionBar().setTitle("Total Machine");
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


        rv_list = findViewById(R.id.mrv_list);
        getData(name);


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
                Intent i = new Intent(totmachine_Details.this, pending_bill.class);
                startActivity(i);
            }
        });
        navMachinecount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(totmachine_Details.this, dashboard.class);
                startActivity(i);
            }
        });navComplaintcount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(totmachine_Details.this, party_complaint_Details.class);
                startActivity(i);
            }
        });navpendingcount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(totmachine_Details.this, panding_complaint.class);
                startActivity(i);
            }
        });navcompleteComplaintCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(totmachine_Details.this, complete_com.class);
                startActivity(i);
            }
        });navreviewComplaintCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(totmachine_Details.this, review_activity.class);
                startActivity(i);
            }
        });navAmcDateCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(totmachine_Details.this, AMC_Expire.class);
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

        Call<MDExample> getlast_name = RetrofitApi.getInstance().getMyApi().getMachineDetails(name);

        getlast_name.enqueue(new Callback<MDExample>() {
            @Override
            public void onResponse(@NonNull Call<MDExample> call, @NonNull Response<MDExample> response) {

                if (response.body() != null) {
                    if (response.body().getStatusCode() != null) {

                        Log.d("responsedata", String.valueOf(response.body().getPartyMachineDetails()));

                        if (response.body().getPartyMachineDetails() != null) {
                            recyclerAdapter = new tot_recycler(totmachine_Details.this, response.body().getPartyMachineDetails());
                            rv_list.setLayoutManager(new LinearLayoutManager(totmachine_Details.this));
                            rv_list.setAdapter(recyclerAdapter);

                        } else {
                            Toast.makeText(totmachine_Details.this, "Fail", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

//                List<Datum> datumList=response.body();
            }

            @Override
            public void onFailure(Call<MDExample> call, Throwable t) {
                Toast.makeText(totmachine_Details.this, "એક ભૂલ આવે છે", Toast.LENGTH_SHORT).show();

            }

        });
    }
}
