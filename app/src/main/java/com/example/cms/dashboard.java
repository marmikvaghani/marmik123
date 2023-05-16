package com.example.cms;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.cms.model.homedata;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class dashboard extends AppCompatActivity /* implements   AdapterView.OnItemSelectedListener*/ {

    TextView Machinecount, Complaintcount,pendingcount,completeComplaintCount,reviewComplaintCount,AmcDateCheck;
    // RecyclerAdapter recyclerAdapter;
    String name1;
    ImageView profile_img,addtask;

    //refresh
    SwipeRefreshLayout swipeRefreshLayout;
    TextView refe;
    //
    Button Logout;

    TextView profilename;
    //  RecyclerView rv_list;
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;

    CardView dmtotalmachine, dmtotalcomplaint, dmpandingcomplaint, dmaddcomplaint,reviewcard,amcex;
    LinearLayout dtotalmachine,dtotalcomplaint, dpandingcomplaint, daddcomplaint,reviewlin;

    EditText editText;

    TextView textView;
   @RequiresApi(api = Build.VERSION_CODES.N)
    @SuppressLint({"MissingInflatedId", "ResourceType", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        textView = findViewById(R.id.text);
       getSupportActionBar().setTitle("DashBoard");

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


       if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
           NotificationChannel channel = new NotificationChannel("notification_channel", "notification_channel", NotificationManager.IMPORTANCE_DEFAULT);
           NotificationManager manager = getSystemService(NotificationManager.class);
           manager.createNotificationChannel(channel);
       }

       FirebaseMessaging.getInstance().subscribeToTopic("general")
               .addOnCompleteListener(new OnCompleteListener<Void>() {
                   @Override
                   public void onComplete(@NonNull Task<Void> task) {
                       String msg = "Subscribed Successfully";
                       if (!task.isSuccessful()) {
                           msg = "Subscription failed";
                       }
                       Toast.makeText(dashboard.this, msg, Toast.LENGTH_SHORT).show();
                   }
               });

        profilename=findViewById(R.id.profilename);
        profilename.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(dashboard.this,profile_activity.class);
                startActivity(i);
            }
        });
        // drawer and back button to close drawer
        drawerLayout = findViewById(R.id.my_drawer_layout_dashboard);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        addtask=findViewById(R.id.addtask);
        addtask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(dashboard.this,taskadd.class);
                startActivity(i);
            }
        });
        //  rv_list = findViewById(R.id.rv_list);
        profile_img=findViewById(R.id.img_profile);
        profile_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(dashboard.this,profile_activity.class);
                startActivity(i);
            }
        });
        dmtotalmachine = findViewById(R.id.mtotalmachine);
        dmtotalcomplaint = findViewById(R.id.mtotalcomplaint);
        dmpandingcomplaint = findViewById(R.id.mpandingcomplaint);
        dmaddcomplaint = findViewById(R.id.maddcomplaint);
        reviewcard=findViewById(R.id.reviercard);
        amcex=findViewById(R.id.amcex);

        reviewlin=findViewById(R.id.linereview);
        dtotalmachine = findViewById(R.id.totalmachine);
        dtotalcomplaint = findViewById(R.id.totalcomplaint);
        dpandingcomplaint = findViewById(R.id.pandingcomplaint);
        daddcomplaint = findViewById(R.id.completeComplaint);

        Machinecount = findViewById(R.id.machineCountno);
        Complaintcount = findViewById(R.id.complaintCountno);
        pendingcount = findViewById(R.id.pandingcount);
        completeComplaintCount = findViewById(R.id.completeComplaintCount);
        reviewComplaintCount=findViewById(R.id.review);
        AmcDateCheck = findViewById(R.id.AmcDate);


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
               Intent i = new Intent(dashboard.this, pending_bill.class);
               startActivity(i);
           }
       }); navMachinecount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(dashboard.this, totmachine_Details.class);
                startActivity(i);
            }
        });navComplaintcount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(dashboard.this, party_complaint_Details.class);
                startActivity(i);
            }
        });navpendingcount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(dashboard.this, panding_complaint.class);
                startActivity(i);
            }
        });navcompleteComplaintCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(dashboard.this, complete_com.class);
                startActivity(i);
            }
        });navreviewComplaintCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(dashboard.this, review_activity.class);
                startActivity(i);
            }
        });navAmcDateCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(dashboard.this, AMC_Expire.class);
                startActivity(i);
            }
        });

        SharedPreferences sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        name1 = sharedPref.getString("username", "");

        getcount(name1);

        dmtotalmachine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(dashboard.this, totmachine_Details.class);
            startActivity(i);
        }
    });
    amcex.setOnClickListener(new View.OnClickListener() {
        @Override
            public void onClick(View v) {
                Intent i = new Intent(dashboard.this, AMC_Expire.class);
                startActivity(i);
            }
        });
        dmtotalcomplaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(dashboard.this, party_complaint_Details.class);
                startActivity(i);
            }
        });
        dmpandingcomplaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(dashboard.this, panding_complaint.class);
                startActivity(i);
            }
        });
        reviewcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(dashboard.this, review_activity.class);
                startActivity(i);
            }
        });
        dmaddcomplaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(dashboard.this, complete_com.class);
                startActivity(i);
            }
        });
        dtotalmachine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(dashboard.this, totmachine_Details.class);
                startActivity(i);
            }
        });
        reviewlin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(dashboard.this, review_activity.class);
                startActivity(i);
            }
        });
        dtotalcomplaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(dashboard.this, party_complaint_Details.class);
                startActivity(i);
            }
        });
        dpandingcomplaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(dashboard.this, panding_complaint.class);
                startActivity(i);
            }
        });
        daddcomplaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(dashboard.this, complete_com.class);
                startActivity(i);
            }
        });
        Logout = findViewById(R.id.Logout);
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(dashboard.this);
                alertDialog.setTitle(" શું તમે ખરેખર લોગઆઉટ કરવા માંગો છો ?");

                alertDialog.setPositiveButton("હા", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.clear();
                        editor.apply();
                        finish();

// Start the LoginActivity
                        Intent intent = new Intent(dashboard.this, Splash_Screen.class);
                        startActivity(intent);
                    }
                });
                alertDialog.setNegativeButton("ના", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(dashboard.this, "તમે બહાર નથી નિકલ્યા.", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();

                    }
                });
                alertDialog.show();
            }
        });

       swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.refreshLayout);
       refe=findViewById(R.id.tv1);
        // Refresh  the layout
        swipeRefreshLayout.setVisibility(View.GONE);
        refe.setVisibility(View.GONE);

        }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void getcount(String name) {

        FooRequest fooRequest = new FooRequest(name);

        Call<homedata> getlast_name = RetrofitApi.getInstance().getMyApi().getcount(name);

        getlast_name.enqueue(new Callback<homedata>() {
            @Override
            public void onResponse(@NonNull Call<homedata> call, @NonNull Response<homedata> response) {

                if (response.body() != null) {
                    if (response.body().getStatusCode() != null) {

                        if (response.body() != null) {

                            swipeRefreshLayout.setVisibility(View.GONE);
                            refe.setVisibility(View.GONE);
                            profilename.setText((name1));


                            Machinecount.setText(String.valueOf(response.body().getTotalMachineCount()));
                            Complaintcount.setText(String.valueOf(response.body().getTotalComplaintCount()));
                            pendingcount.setText(String.valueOf(response.body().getPendingComplaintCount()));
                            completeComplaintCount.setText(String.valueOf(response.body().getCompleteComplaintCount()));
                            reviewComplaintCount.setText(String.valueOf(response.body().getReviewComplaintCount()));
                            AmcDateCheck.setText(String.valueOf(response.body().getAmcDateCheck()));


                        } else {
                            Toast.makeText(dashboard.this, "Fail", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

//                List<Datum> datumList=response.body();
            }

            @Override
            public void onFailure(@NonNull Call<homedata> call, @NonNull Throwable t) {
                Toast.makeText(dashboard.this, "Turn On InterNet", Toast.LENGTH_SHORT).show();
                swipeRefreshLayout.setVisibility(View.VISIBLE);
                refe.setVisibility(View.VISIBLE);

                swipeRefreshLayout.setOnRefreshListener(
                        new SwipeRefreshLayout.OnRefreshListener() {
                            @Override
                            public void onRefresh() {
                                getcount(name1);
                                swipeRefreshLayout.setRefreshing(false);
                                Toast.makeText(dashboard.this, "Wait Few Second", Toast.LENGTH_LONG).show();
                            }
                        }
                );
            }

        });

    }
    @Override
    public void onBackPressed() {
        android.app.AlertDialog.Builder alertDialog = new android.app.AlertDialog.Builder(dashboard.this);
        alertDialog.setTitle("શું તમે ખરેખર અરજી કરવા માંગો છો ?");

        alertDialog.setPositiveButton("હા", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(dashboard.this, "બહાર નિકલી ગયા", Toast.LENGTH_SHORT).show();
                Intent a = new Intent(Intent.ACTION_MAIN);
                a.addCategory(Intent.CATEGORY_HOME);
                a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(a);
                //  finishAffinity();
            }
        });
        alertDialog.setNegativeButton("ના", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(dashboard.this, "તમે બહાર નથી નિકલ્યા.", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        alertDialog.show();
        //Clicking the back button twice to exit an activity
    }
}