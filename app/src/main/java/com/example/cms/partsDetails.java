
package com.example.cms;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cms.adapter.parts_adapter;
import com.example.cms.pending_bills.Datum;
import com.example.cms.pending_bills.Example;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class partsDetails extends AppCompatActivity {

    private RecyclerView partsRecyclerView;
    private parts_adapter partsAdapter;

    String name;

    RecyclerView rv_list;
    TextView textView,nameparts1,nameparts2,nameparts3,nameparts4,nameparts5,nameparts6;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @SuppressLint({"MissingInflatedId", "ResourceType", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parts_details);
        textView = findViewById(R.id.billpannel);
        getSupportActionBar().setTitle("Parts Details");

        SharedPreferences sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        name = sharedPref.getString("username", "");
    //   rv_list = findViewById(R.id.crv_list);


        partsRecyclerView = findViewById(R.id.crv_list);
        partsAdapter = new parts_adapter();
        partsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        partsRecyclerView.setAdapter(partsAdapter);

        Intent intent = getIntent();
        String partsDetailsJson = intent.getStringExtra("partsDetails");
        List<Datum.PartsDetail> partsDetails = new Gson().fromJson(partsDetailsJson, new TypeToken<List<Datum.PartsDetail>>(){}.getType());
        partsAdapter.setPartsDetails(partsDetails);
       /* parts_adapter partsAdapter = new parts_adapter();
        rv_list.setAdapter(partsAdapter);

        Intent intent = getIntent();
        String str1 = intent.getStringExtra("name1");
        String str2 = intent.getStringExtra("name2");
        String str3 = intent.getStringExtra("name3");
        String str4 = intent.getStringExtra("name4");
        String str5 = intent.getStringExtra("name5");
        String str6 = intent.getStringExtra("name6");

        List<Datum.PartsDetail> partsDetailsList = new ArrayList<>();
        Datum.PartsDetail partsDetail = new Datum.PartsDetail(str1, Integer.parseInt(str2), str3, Double.parseDouble(str4), Integer.parseInt(str5), str6);
        partsDetailsList.add(partsDetail);

        partsAdapter.setPartsDetails(partsDetailsList);
*/
     /*   nameparts1 = findViewById(R.id.nameparts1);
        nameparts2 = findViewById(R.id.nameparts2);
        nameparts3 = findViewById(R.id.nameparts3);
        nameparts4 = findViewById(R.id.nameparts4);
        nameparts5 = findViewById(R.id.nameparts5);
        nameparts6 = findViewById(R.id.nameparts6);

        Intent intent = getIntent();
        String str1 = intent.getStringExtra("name1");
        String str2 = intent.getStringExtra("name2");
        String str3 = intent.getStringExtra("name3");
        String str4 = intent.getStringExtra("name4");
        String str5 = intent.getStringExtra("name5");
        String str6 = intent.getStringExtra("name6");

        nameparts1.setText(" partsName : "+str1);
        String uname1 = nameparts1.getText().toString();
        Log.d("Uname1", uname1);

        nameparts2.setText(" partsQuantity : "+str2);
        String uname2 = nameparts2.getText().toString();
        Log.d("Uname1", uname2);

        nameparts3.setText(" isWarranty : "+str3);
        String uname3 = nameparts3.getText().toString();
        Log.d("Uname1", uname3);

        nameparts4.setText(" partsPrice : "+str4);
        String uname4 = nameparts4.getText().toString();
        Log.d("Uname1", uname4);

        nameparts5.setText(" partsQty : "+str5);
        String uname5 = nameparts5.getText().toString();
        Log.d("Uname1", uname5);

        nameparts6.setText(" currentDate : "+str6);

        String uname6 = nameparts6.getText().toString();
        Log.d("Uname1", uname6);
*/

    }


  /*  private void getData(String name) {

        Call<Example> getlast_name = RetrofitApi.getInstance().getMyApi().getpartsdetails(name);

        getlast_name.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(@NonNull Call<Example> call, @NonNull Response<Example> response) {

                if (response.body() != null) {
                    if (response.body().getStatusCode() != null) {

                        Log.d("responsedata", String.valueOf(response.body().getData()));

                        if (response.body().getData().size() == 0) {

                        } else {


                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Toast.makeText(partsDetails.this, "એક ભૂલ આવે છે", Toast.LENGTH_SHORT).show();
            }

        });
    }
*/
}
