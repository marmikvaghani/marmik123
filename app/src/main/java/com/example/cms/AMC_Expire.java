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

import com.example.cms.adapter.amc_recycler;
import com.example.cms.amc_exa.AmcClass;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AMC_Expire extends AppCompatActivity {

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    amc_recycler pcRecycler;
    RecyclerView rv_list;
    String name,isCompleted, token;
    TextView textView;
    @SuppressLint("MissingInflatedId")
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amc_expire);
        textView = findViewById(R.id.amcpannel);
        getSupportActionBar().setTitle("AMC Expire In 2 Days");
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


        isCompleted = sharedPref.getString("isCompleted", "");
        rv_list = findViewById(R.id.crv_list);
        getData(name, isCompleted);


        //navigation

        TextView navMachinecount,navpendingbill, navComplaintcount, navpendingcount, navcompleteComplaintCount, navreviewComplaintCount, navAmcDateCheck;
        navMachinecount = findViewById(R.id.navmachine);
        navComplaintcount = findViewById(R.id.navcomplain);
        navpendingcount = findViewById(R.id.navpanding);
        navcompleteComplaintCount = findViewById(R.id.navcomplited);
        navreviewComplaintCount = findViewById(R.id.navreview);
        navAmcDateCheck = findViewById(R.id.navamc);

          navpendingbill=findViewById(R.id.navpendingbil);

        navpendingbill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AMC_Expire.this, pending_bill.class);
                startActivity(i);
            }
        });
        navMachinecount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AMC_Expire.this, dashboard.class);
                startActivity(i);
            }
        });
        navComplaintcount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AMC_Expire.this, totmachine_Details.class);
                startActivity(i);
            }
        });
        navpendingcount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AMC_Expire.this, party_complaint_Details.class);
                startActivity(i);
            }
        });
        navcompleteComplaintCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AMC_Expire.this, panding_complaint.class);
                startActivity(i);
            }
        });
        navreviewComplaintCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AMC_Expire.this, complete_com.class);
                startActivity(i);
            }
        });
        navAmcDateCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AMC_Expire.this, review_activity.class);
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

        Call<AmcClass> getlast_name = RetrofitApi.getInstance().getMyApi().getAMC(name,isCompleted);

        getlast_name.enqueue(new Callback<AmcClass>() {
            @Override
            public void onResponse(@NonNull Call<AmcClass> call, @NonNull Response<AmcClass> response) {

                if (response.body() != null) {
                    if (response.body().getStatusCode() != null) {

                        Log.d("responsedata", String.valueOf(response.body().getAmcDateCheck()));

                        if (response.body().getAmcDateCheck().size()==0){

                            Toast.makeText(AMC_Expire.this, "Data is Blank", Toast.LENGTH_LONG).show();
                        }else{
                            pcRecycler = new amc_recycler(AMC_Expire.this, response.body().getAmcDateCheck());
                            rv_list.setLayoutManager(new LinearLayoutManager(AMC_Expire.this));
                            rv_list.setAdapter(pcRecycler);
                        }

                    }
                }
            }
            @Override
            public void onFailure(Call<AmcClass> call, Throwable t) {
                Toast.makeText(AMC_Expire.this, "એક ભૂલ આવે છે", Toast.LENGTH_SHORT).show();
            }

        });
    }
}
