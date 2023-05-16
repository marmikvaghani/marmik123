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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cms.adapter.review_recycler;
import com.example.cms.reviewData.ReviewData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class review_activity extends AppCompatActivity {

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    review_recycler pcRecycler;
    RecyclerView rv_list;
    String name,isCompleted;

    TextView textView;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @SuppressLint({"MissingInflatedId", "ResourceType", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        textView = findViewById(R.id.text);
        getSupportActionBar().setTitle("Review Complaint");

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

        rv_list = findViewById(R.id.rrv_list);
        getData(name, isCompleted);


        //review
       /* reviewcom= findViewById(R.id.review_com);
        reviewcom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.app.AlertDialog.Builder alertDialog = new android.app.AlertDialog.Builder(review_activity.this);
                alertDialog.setTitle("Review Complaint");


                alertDialog.show();
               //Clicking the back button twice to exit an activity
            }
            }
        );*/


        //navigation

        TextView navMachinecount, navComplaintcount, navpendingcount, navcompleteComplaintCount, navreviewComplaintCount, navAmcDateCheck;
        navMachinecount = findViewById(R.id.navmachine);
        navComplaintcount = findViewById(R.id.navcomplain);
        navpendingcount = findViewById(R.id.navpanding);
        navcompleteComplaintCount = findViewById(R.id.navcomplited);
        navreviewComplaintCount = findViewById(R.id.navreview);
        navAmcDateCheck = findViewById(R.id.navamc);

        TextView  navpendingbill=findViewById(R.id.navpendingbill);

        navpendingbill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(review_activity.this, pending_bill.class);
                startActivity(i);
            }
        });
        navMachinecount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(review_activity.this, dashboard.class);
                startActivity(i);
            }
        });
        navComplaintcount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(review_activity.this, totmachine_Details.class);
                startActivity(i);
            }
        });
        navpendingcount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(review_activity.this, party_complaint_Details.class);
                startActivity(i);
            }
        });
        navcompleteComplaintCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(review_activity.this, panding_complaint.class);
                startActivity(i);
            }
        });
        navreviewComplaintCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(review_activity.this, complete_com.class);
                startActivity(i);
            }
        });
        navAmcDateCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(review_activity.this, AMC_Expire.class);
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

        Call<ReviewData> getlast_name = RetrofitApi.getInstance().getMyApi().getreview(name,isCompleted);

        getlast_name.enqueue(new Callback<ReviewData>() {
            @Override
            public void onResponse(@NonNull Call<ReviewData> call, @NonNull Response<ReviewData> response) {

                if (response.body() != null) {
                    if (response.body().getStatusCode() != null) {

                        Log.d("responsedata", String.valueOf(response.body().getData()));
                        if (response.body().getData().size()==0){
                            Toast.makeText(review_activity.this, "Data is Blank", Toast.LENGTH_LONG).show();
                        }else{
                            pcRecycler = new review_recycler(review_activity.this, response.body().getData());
                            rv_list.setLayoutManager(new LinearLayoutManager(review_activity.this));
                            rv_list.setAdapter(pcRecycler);
                        }
                    }
                }
            }
            @Override
            public void onFailure(Call<ReviewData> call, Throwable t) {
                Log.d("error==>>",t.getMessage());
                Toast.makeText(review_activity.this, "એક ભૂલ આવે છે", Toast.LENGTH_SHORT).show();
            }

        });
    }
}
