package com.example.cms;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.cms.machien_problem.Data;
import com.example.cms.machien_problem.Example;
import com.example.cms.machien_problem.MachineProblem;
import com.example.cms.party_details.MDExample;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.crypto.Mac;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class taskadd extends AppCompatActivity {
    List<String> ModelName = new ArrayList<>();
    List<String> ModelID = new ArrayList<>();
    List<String> MachineNo = new ArrayList<>();
    List<String> MachinePro = new ArrayList<>();

    String model_name,name,machineType;
    AutoCompleteTextView selectmachine;
    AutoCompleteTextView selectmachineno;

    AutoCompleteTextView selectmachinePro;

    Button cancel_button,submit_button;
    LinearLayout otherproblemlayout;

    EditText otherproblemtext;
    private AutoCompleteTextView selectMachineProTextView;
    private String[] machineProblemsArray;
    private boolean[] checkedMachineProblems;
    private List<String> selectedMachineProblemsList = new ArrayList<>();



    TextView textView;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @SuppressLint({"MissingInflatedId", "ResourceType", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taskadd);

        getSupportActionBar().setTitle("Add Complaint");

        SharedPreferences sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        name = sharedPref.getString("username", "");
        machineType = sharedPref.getString("machineType", "");

        selectmachine=findViewById(R.id.selectmachine);
        selectmachineno=findViewById(R.id.selectmachineno);
        //selectmachinePro=findViewById(R.id.selectmachinepro);
        selectMachineProTextView = findViewById(R.id.selectmachinepro);

        otherproblemtext=findViewById(R.id.otherproblemtextview);

        //Botton
        cancel_button=findViewById(R.id.cancel_button);
        submit_button=findViewById(R.id.submit_button);

        cancel_button.setVisibility(View.INVISIBLE);
        submit_button.setVisibility(View.INVISIBLE);


        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.app.AlertDialog.Builder alertDialog = new android.app.AlertDialog.Builder(taskadd.this);
                alertDialog.setTitle("Chose Yes Complaint Don't Add Going Back Screen");
                alertDialog.setMessage("Chose No Stay This Screen");

                alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       // Toast.makeText(taskadd.this, "બહાર નિકલી ગયા", Toast.LENGTH_SHORT).show();
                        Intent a = new Intent(taskadd.this,dashboard.class);
                        startActivity(a);
                        //  finishAffinity();
                    }
                });
                alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                      //  Toast.makeText(taskadd.this, "તમે બહાર નથી નિકલ્યા.", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
                alertDialog.show();
            }
        });
        //otherproblemlayout
        otherproblemlayout=findViewById(R.id.otherproblemlayout);
        otherproblemlayout.setVisibility(View.INVISIBLE);

        // MACHINE TYPE

        Call<MDExample> getlast_name = RetrofitApi.getInstance().getMyApi().getmachinetype(name);
        getlast_name.enqueue(new Callback<MDExample>() {
            @Override
            public void onResponse(@NonNull Call<MDExample> call, @NonNull retrofit2.Response<MDExample> response) {

                Log.d("response==>>>",response.body().getPartyMachineDetails().toString());
                if(response.isSuccessful())
                {
                    if (response.body() != null)
                    {
                        ModelName.clear();

                        for (int i = 0; i < response.body().getPartyMachineDetails().size(); i++)
                        {
                            ModelName.add(response.body().getPartyMachineDetails().get(i).getMachineType());
                            removeDuplicates(ModelName);
                            Log.d("ModelNameremove", String.valueOf(ModelName));
                        }
                        Log.d("ProductS", "onResponse: "+response.body().getPartyMachineDetails().size());

                        Log.d("MProduct", ModelName.toString());

                        ArrayAdapter adapter2 = new ArrayAdapter(taskadd.this, android.R.layout.simple_spinner_dropdown_item, ModelName);

                        selectmachine.setAdapter(adapter2);

                        selectmachine.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                model_name = ModelName.get(i);
                                Log.d("model_name", model_name);
  // MACHINE NO
                                Call<com.example.cms.party_details.MachineNo> getlast_name = RetrofitApi.getInstance().getMyApi().getmachineNo(name);
                                getlast_name.enqueue(new Callback<com.example.cms.party_details.MachineNo>() {
                                    @Override
                                    public void onResponse(Call<com.example.cms.party_details.MachineNo> call, Response<com.example.cms.party_details.MachineNo> response) {
                                        if(response.isSuccessful())
                                        {
                                            if (response.body() != null)
                                            {
                                                MachineNo.clear();
                                                 Log.d("product123333", response.body().toString());

                                                 for (int i=0;i<response.body().getPartyMachineDetails().size();i++){

                                                     if (model_name.equals(response.body().getPartyMachineDetails().get(i).getMachineType())) {

                                                         List<com.example.cms.party_details.MachineNo.MachineNumberDetail> machineNumberDetails = response.body().getPartyMachineDetails().get(i).getMachineNumberDetails();
                                                         for (int j = 0; j < machineNumberDetails.size(); j++)
                                                         {
                                                             String machineNumber = machineNumberDetails.get(j).getMachineNumber();
                                                             Log.d("machineNumber123", machineNumber);
                                                             MachineNo.add(machineNumber);

                                                         }
                                                         Log.d("MachineNo1233333", MachineNo.toString());
                                                     }

                                                     ArrayAdapter adapter2 = new ArrayAdapter(taskadd.this, android.R.layout.simple_spinner_dropdown_item, MachineNo);

                                                         selectmachineno.setAdapter(adapter2);
                                                         selectmachineno.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                                             @Override
                                                             public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                                                                 Retrofit retrofit = new Retrofit.Builder()
                                                                         .baseUrl(api.BASE_URL)
                                                                         .addConverterFactory(GsonConverterFactory.create())
                                                                         .build();

                                                                 // Create an instance of the "api" interface
                                                                 api apiService = retrofit.create(api.class);

                                                                 // Call the "getmachineproblem()" method on the API service instance
                                                                 Call<Example> call = apiService.getmachineproblem(model_name);

                                                                 // Enqueue the API call
                                                                 call.enqueue(new Callback<Example>() {
                                                                     @Override
                                                                     public void onResponse(Call<Example> call, Response<Example> response) {
                                                                         // Handle the API response
                                                                         Example machineProb = response.body();
                                                                         if (machineProb != null && machineProb.getData() != null) {
                                                                             List<MachineProblem> machineProblems = machineProb.getData().getMachineProblems();

                                                                             // Extract machine problem names from the response data
                                                                             machineProblemsArray = new String[machineProblems.size()];
                                                                             for (int i = 0; i < machineProblems.size(); i++) {
                                                                                 machineProblemsArray[i] = machineProblems.get(i).getMachineProblem();
                                                                             }
                                                                             // Initialize boolean array for checked items
                                                                             checkedMachineProblems = new boolean[machineProblemsArray.length];

                                                                             // Set up click listener for the "Select machine problems" text view
                                                                             selectMachineProTextView.setOnClickListener(new View.OnClickListener() {
                                                                                 @Override
                                                                                 public void onClick(View view) {
                                                                                     // Show alert dialog with machine problem options
                                                                                     AlertDialog.Builder builder = new AlertDialog.Builder(taskadd.this);
                                                                                     builder.setTitle("Select machine problems");



                                                                                     builder.setMultiChoiceItems(machineProblemsArray, checkedMachineProblems, new DialogInterface.OnMultiChoiceClickListener() {
                                                                                         @Override
                                                                                         public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {
                                                                                             if (isChecked) {
                                                                                                 selectedMachineProblemsList.add(machineProblemsArray[position]);
                                                                                             } else {
                                                                                                 selectedMachineProblemsList.remove(machineProblemsArray[position]);
                                                                                             }
                                                                                         }
                                                                                     });

                                                                                         builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                                                             @Override
                                                                                             public void onClick(DialogInterface dialogInterface, int i) {
                                                                                                 // Update the text view with selected machine problems
                                                                                                 Log.d("selectMachinePrextView", selectMachineProTextView.getText().toString());

                                                                                                 String selectedMachineProblemsText = "";

                                                                                                 for (String selectedMachineProblem : selectedMachineProblemsList) {
                                                                                                     selectedMachineProblemsText += selectedMachineProblem + ", ";
                                                                                                 }
                                                                                                 if (selectedMachineProblemsText.length() > 2) {
                                                                                                     selectedMachineProblemsText = selectedMachineProblemsText.substring(0, selectedMachineProblemsText.length() - 2);
                                                                                                 }
                                                                                                 selectMachineProTextView.setText(selectedMachineProblemsText);
                                                                                                 if (selectMachineProTextView.getText().toString().equals(""))
                                                                                                 {
                                                                                                     Toast.makeText(taskadd.this, "First Add Problmes", Toast.LENGTH_SHORT).show();
                                                                                                 }
                                                                                                 else {
                                                                                                     cancel_button.setVisibility(View.VISIBLE);
                                                                                                     submit_button.setVisibility(View.VISIBLE);

                                                                                                     submit_button.setOnClickListener(new View.OnClickListener() {
                                                                                                         @Override
                                                                                                         public void onClick(View v) {
                                                                                                             if ( otherproblemtext.getText().toString().equals("")){
                                                                                                                 Toast.makeText(taskadd.this, "Add Complaint First", Toast.LENGTH_SHORT).show();
                                                                                                             } else {
                                                                                                                 Toast.makeText(taskadd.this, "Complaint Added", Toast.LENGTH_SHORT).show();
                                                                                                             }
                                                                                                             selectmachineno.setText("");
                                                                                                             MachineNo.equals("");
                                                                                                             selectmachine.setText("");
                                                                                                             ModelName.equals("");
                                                                                                             machineProblems.equals("");
                                                                                                             selectMachineProTextView.setText("");
                                                                                                             otherproblemtext.setText("");
                                                                                                         }
                                                                                                     });
                                                                                                 }
                                                                                             }
                                                                                         });

                                                                                     builder.setNegativeButton("Clear All", new DialogInterface.OnClickListener() {
                                                                                         @Override
                                                                                         public void onClick(DialogInterface dialogInterface, int i) {
                                                                                             // dismiss dialog
                                                                                             for (int j = 0; j < machineProblemsArray.length; j++) {
                                                                                                 // remove all selection
                                                                                                 checkedMachineProblems[j] = false;
                                                                                                 // clear language list
                                                                                                 selectedMachineProblemsList.clear();
                                                                                                 // clear text view value
                                                                                                 selectMachineProTextView.setText("");
                                                                                             }
                                                                                             otherproblemlayout.setVisibility(View.INVISIBLE);
                                                                                             cancel_button.setVisibility(View.INVISIBLE);
                                                                                             submit_button.setVisibility(View.INVISIBLE);
                                                                                         }
                                                                                     });
                                                                                     builder.setNeutralButton("Other Problem", new DialogInterface.OnClickListener() {
                                                                                         @Override
                                                                                         public void onClick(DialogInterface dialogInterface, int i) {
                                                                                             // use for loop


                                                                                             String selectedMachineProblemsText = "";

                                                                                             for (String selectedMachineProblem : selectedMachineProblemsList) {
                                                                                                 selectedMachineProblemsText += selectedMachineProblem + ", ";
                                                                                             }
                                                                                             if (selectedMachineProblemsText.length() > 2) {
                                                                                                 selectedMachineProblemsText = selectedMachineProblemsText.substring(0, selectedMachineProblemsText.length() - 2);
                                                                                             }
                                                                                             selectMachineProTextView.setText(selectedMachineProblemsText);
                                                                                             dialogInterface.dismiss();

                                                                                             otherproblemlayout.setVisibility(View.VISIBLE);
                                                                                             cancel_button.setVisibility(View.VISIBLE);
                                                                                             submit_button.setVisibility(View.VISIBLE);

                                                                                             submit_button.setOnClickListener(new View.OnClickListener() {
                                                                                                 @Override
                                                                                                 public void onClick(View v) {
                                                                                                     if ( otherproblemtext.getText().toString().equals("")){

                                                                                                         Toast.makeText(taskadd.this, "Add Complaint First", Toast.LENGTH_SHORT).show();
                                                                                                     } else {
                                                                                                         Toast.makeText(taskadd.this, "Complaint Added", Toast.LENGTH_SHORT).show();
                                                                                                     }
                                                                                                 }
                                                                                             });
                                                                                         }
                                                                                     });
                                                                                     builder.show();
                                                                                 }
                                                                             });
                                                                         }
                                                                     }

                                                                     @Override
                                                                     public void onFailure(Call<Example> call, Throwable t) {
                                                                         // Handle API call failure
                                                                         t.printStackTrace();
                                                                     }
                                                                 });




                                                             }
                                                     });
                                                 }
                                            }
                                        }
                                    }
                                    @Override
                                    public void onFailure(Call<com.example.cms.party_details.MachineNo> call, Throwable t) {

                                    }
                                });



                            }
                        }
                        );
            }

                }
            }
            @Override
            public void onFailure(@NotNull Call<MDExample> call, @NotNull Throwable t) {
                Toast.makeText(taskadd.this, "Inter Net", Toast.LENGTH_SHORT).show();
            }
        });

        // Define the list of items to show in the alert dialog box



    }
    public void removeDuplicates(List<String> list)

    {
        int count = list.size();

        for (int i = 0; i < count; i++)
        {
            for (int j = i + 1; j < count; j++)
            {
                if (list.get(i).equals(list.get(j)))
                {
                    list.remove(j--);
                    count--;
                }
            }
        }
    }
}