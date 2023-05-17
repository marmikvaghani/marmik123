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
import com.example.cms.partsDetails;
import com.example.cms.pending_bill;
import com.example.cms.pending_bills.Datum;

import java.util.List;

public class pendingbill_Adapter extends RecyclerView.Adapter<pendingbill_Adapter.ViewHolder >{

    List<Datum> datum;

    Context contex;

    public pendingbill_Adapter(pending_bill party_complaint_details, List<Datum> partyCompaintDetails) {
        this.datum = partyCompaintDetails;
        this.contex = party_complaint_details;
    }
    @Override
    public pendingbill_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_pendingbill, parent, false);
        return new pendingbill_Adapter.ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull pendingbill_Adapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {


        holder.Biil_ID.setText(" Biil_ID : "+datum.get(position).getBillId());
        holder.CMD_ID.setText(" CMD_ID : "+datum.get(position).getComId());
        holder.MachineNumber.setText(" MachineNumber : "+datum.get(position).getMachineNumber());
        holder.MachineType.setText(" MachineType : "+datum.get(position).getMachineType());

        holder.isPaymentsStatus.setText(" isPaymentsStatus : "+datum.get(position).getIsPaymentsStatus());
        holder.createAt.setText(" createAt : "+datum.get(position).getCreateAt());
        holder.upadateAt.setText(" upadateAt : "+datum.get(position).getUpadateAt());
        holder.mainTotal.setText(" mainTotal : "+datum.get(position).getMainTotal());

        holder.partsDetails.setText(" partsDetails : "+datum.get(position).getPartsDetails());

        holder.partsdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the selected PartsDetail object
                List<Datum.PartsDetail> selectedPartsDetail = datum.get(position).getPartsDetails();

                // Create an intent to start the target RecyclerView's activity
                Intent intent = new Intent(v.getContext(), partsDetails.class);

                // Pass the selected PartsDetail object to the intent
                intent.putExtra("partsDetails", selectedPartsDetail.toString());

                // Start the target RecyclerView's activity
                v.getContext().startActivity(intent);
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
            isPaymentsStatus = itemView.findViewById(R.id.isPaymentsStatus);
            createAt = itemView.findViewById(R.id.createAt);
            upadateAt = itemView.findViewById(R.id.upadateAt);
            mainTotal = itemView.findViewById(R.id.mainTotal);


              partsdetails=itemView.findViewById(R.id.partd122);

        }

    }

}

