package com.example.cms.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cms.R;
import com.example.cms.Splash_Screen;
import com.example.cms.dashboard;
import com.example.cms.edit_profile;
import com.example.cms.partsDetails;
import com.example.cms.party_complaint.PartyCompaintDetail;
import com.example.cms.party_complaint_Details;
import com.example.cms.pending_bill;
import com.example.cms.pending_bills.Datum;
import com.example.cms.profile_activity;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class pendingbill_Adapter extends RecyclerView.Adapter<pendingbill_Adapter.ViewHolder >{

    List<Datum> datum;

    Context contex;

    public pendingbill_Adapter(pending_bill party_complaint_details, List<Datum> partyCompaintDetails) {
        this.datum = partyCompaintDetails;
        this.contex = party_complaint_details;
    }
    @NonNull
    @Override
    public pendingbill_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_pendingbill, parent, false);
        return new pendingbill_Adapter.ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull pendingbill_Adapter.ViewHolder holder, int position) {



        holder.Biil_ID.setText(" Biil_ID : "+datum.get(position).getBillId());
        holder.CMD_ID.setText(" CMD_ID : "+datum.get(position).getComId());
        holder.MachineNumber.setText(" MachineNumber : "+datum.get(position).getMachineNumber());
        holder.MachineType.setText(" MachineType : "+datum.get(position).getMachineType());

        holder.partsDetails.setText(" partsDetails : "+datum.get(position).getPartsDetails());

        holder.isPaymentsStatus.setText(" isPaymentsStatus : "+datum.get(position).getIsPaymentsStatus());
        holder.createAt.setText(" createAt : "+datum.get(position).getCreateAt());
        holder.upadateAt.setText(" upadateAt : "+datum.get(position).getUpadateAt());
        holder.mainTotal.setText(" mainTotal : "+datum.get(position).getMainTotal());


        String partsName1 = "";
        String partsName2 = "";
        String partsName3 = "";
        String partsName4 = "";
        String partsName5 = "";
        String partsName6 = "";

        List<Datum.PartsDetail> partsDetailsList = datum.get(position).getPartsDetails();
        if (partsDetailsList.size() > 0) {
            partsName1 = partsDetailsList.get(0).getPartsName();
            partsName2 = partsDetailsList.get(0).getCurrentDate();
            partsName3 = partsDetailsList.get(0).getIsWarranty();
            partsName4 = partsDetailsList.get(0).getPartsPrice().toString();
            partsName5 = partsDetailsList.get(0).getPartsQty().toString();
            partsName6 = partsDetailsList.get(0).getPartsQuantity().toString();

        }

// Use the `partsName` variable as needed
      //  TextView  settet (datum.get(position).getPartsDetails().get(position).getPartsName());
        String finalPartsName1 = partsName1;
        String finalPartsName2 = partsName2;
        String finalPartsName3= partsName3;
        String finalPartsName4 = partsName4;
        String finalPartsName5 = partsName5;
        String finalPartsName6 = partsName6;

        holder.partsdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(v.getContext(), partsDetails.class);

                String str =holder.partsDetails.getText().toString();
               //  i.putExtra("userName_key",str);
                i.putExtra("name1", finalPartsName1);
                i.putExtra("name2", finalPartsName2);
                i.putExtra("name3", finalPartsName3);
                i.putExtra("name4", finalPartsName4);
                i.putExtra("name5", finalPartsName5);
                i.putExtra("name6", finalPartsName6);


                v.getContext().startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount() {
        return datum.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder  {

        TextView Biil_ID ,partsdetails,CMD_ID, MachineNumber, MachineType, partsName, partsQuantity, isWarranty, partsPrice, partsQty, currentDate, isPaymentsStatus, createAt, upadateAt, mainTotal, partsDetails;
        LinearLayout data;

        ViewHolder(View itemView) {
            super(itemView);
            data = itemView.findViewById(R.id.cdata);

            Biil_ID = itemView.findViewById(R.id.Biil_ID);
            CMD_ID = itemView.findViewById(R.id.CMD_ID);
            MachineNumber = itemView.findViewById(R.id.MachineNumber);
            MachineType = itemView.findViewById(R.id.MachineType);
            partsDetails = itemView.findViewById(R.id.partsDetails);
//            partsDetails = itemView.findViewById(R.id.partsQuantity);
//            isWarranty = itemView.findViewById(R.id.isWarranty);
//            partsPrice = itemView.findViewById(R.id.partsPrice);
//            partsQty = itemView.findViewById(R.id.partsQty);
//            currentDate = itemView.findViewById(R.id.currentDate);
            isPaymentsStatus = itemView.findViewById(R.id.isPaymentsStatus);
            createAt = itemView.findViewById(R.id.createAt);
            upadateAt = itemView.findViewById(R.id.upadateAt);
            mainTotal = itemView.findViewById(R.id.mainTotal);
//            solution= itemView.findViewById(R.id.csolution);
//            upadateAt= itemView.findViewById(R.id.cupadateAt);
//            rating=itemView.findViewById(R.id.crating);



              partsdetails=itemView.findViewById(R.id.partsdetails);

        }

    }

}

