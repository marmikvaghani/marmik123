package com.example.cms;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cms.pro.ProfileData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class profile_activity extends AppCompatActivity {

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    RecyclerView rv_list;

    AlertDialog.Builder builder;
    String name, token;
    ImageView edit_profile;

    TextView partyCity,partyName,mobnumber,address;
    LinearLayout data;
    TextView textView;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @SuppressLint({"MissingInflatedId", "ResourceType", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        textView = findViewById(R.id.profilepannel);
        getSupportActionBar().setTitle("Profile");

        edit_profile=findViewById(R.id.editprofile);
        edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.app.AlertDialog.Builder alertDialog = new android.app.AlertDialog.Builder(profile_activity.this);
                alertDialog.setTitle("You Want to edit your profile..");

                alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String str =partyName.getText().toString();
                        String str1= partyCity.getText().toString();
                        String str2= mobnumber.getText().toString();
                        String str3= address.getText().toString();

                        Intent i =new Intent(profile_activity.this,edit_profile.class);
                        i.putExtra("userName_key",str);
                        i.putExtra("city_key",str1);
                        i.putExtra("mob_key",str2);
                        i.putExtra("add_key",str3);

                        startActivity(i);
                    }
                });
                alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alertDialog.show();
                //Clicking the back button twice to exit an activity
            }
            }
        );
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


       // rv_list = findViewById(R.id.pmrv_list);
        partyName= findViewById(R.id.username);
        mobnumber= findViewById(R.id.mob);
        partyCity= findViewById(R.id.city);
        address=findViewById(R.id.add);
//        machinetype= findViewById(R.id.mmachineType);
//        installationDate= findViewById(R.id.minstallationDate);
//        amcFromDate= findViewById(R.id.mamcFromDate);
//        amcToDate= findViewById(R.id.mamcToDate);
//        data= findViewById(R.id.mdata);

        getcount(name);

        //navigation

        TextView navMachinecount,navComplaintcount,navpendingcount,navcompleteComplaintCount,navreviewComplaintCount,navAmcDateCheck,navamcc;
        navMachinecount = findViewById(R.id.navmachine);
        navComplaintcount = findViewById(R.id.navcomplain);
        navpendingcount = findViewById(R.id.navpanding);
        navcompleteComplaintCount = findViewById(R.id.navcomplited);
        navreviewComplaintCount=findViewById(R.id.navreview);
        navAmcDateCheck = findViewById(R.id.navamc);
        navamcc = findViewById(R.id.navamcc);

        TextView  navpendingbill=findViewById(R.id.navpendingbill);

        navpendingbill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(profile_activity.this, pending_bill.class);
                startActivity(i);
            }
        });

        navMachinecount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(profile_activity.this, dashboard.class);
                startActivity(i);
            }
        });navComplaintcount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(profile_activity.this, totmachine_Details.class);
                startActivity(i);
            }
        });navpendingcount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(profile_activity.this, party_complaint_Details.class);
                startActivity(i);
            }
        });navcompleteComplaintCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(profile_activity.this, panding_complaint.class);
                startActivity(i);
            }
        });navreviewComplaintCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(profile_activity.this, complete_com.class);
                startActivity(i);
            }
        });navAmcDateCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(profile_activity.this, review_activity.class);
                startActivity(i);
            }
        });
        navamcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(profile_activity.this, AMC_Expire.class);
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
        private void getcount(String name) {


        Call<ProfileData> getlast_name = RetrofitApi.getInstance().getMyApi().getprofile(name);

        getlast_name.enqueue(new Callback<ProfileData>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(@NonNull Call<ProfileData> call, @NonNull Response<ProfileData> response) {

                if (response.body() != null) {
                    if (response.body().getStatusCode() != null) {

                        if (response.body() != null) {

                            Log.d("response==>>", String.valueOf(response.body().getPartyProfile()));

//                            recyclerAdapter = new profile_Adapter(profile_activity.this, response.body().getPartyProfile());
//                            rv_list.setLayoutManager(new LinearLayoutManager(profile_activity.this));
//                            rv_list.setAdapter(recyclerAdapter);

                            address.setText(response.body().getPartyProfile().getAddress());
                            partyName.setText(response.body().getPartyProfile().getPartyName());
                            partyCity.setText(response.body().getPartyProfile().getPartyCity());
                            mobnumber.setText(response.body().getPartyProfile().getMobileNumber().toString());

                        } else {
                            Toast.makeText(profile_activity.this, "Fail", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

//                List<Datum> datumList=response.body();
            }

            @Override
            public void onFailure(@NonNull Call<ProfileData> call, @NonNull Throwable t) {
                Log.d("error====>>>",t.getMessage());
                Toast.makeText(profile_activity.this, "એક ભૂલ આવે છે", Toast.LENGTH_SHORT).show();
            }
        });
    }
}