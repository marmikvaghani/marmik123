package com.example.cms.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
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
public class partsdetails_recycler extends RecyclerView.Adapter<partsdetails_recycler.ViewHolder> {

    List<Datum> datum;

    Context contex;
    public partsdetails_recycler(partsDetails party_complaint_details, List<Datum> partyCompaintDetails) {
        this.datum = partyCompaintDetails;
        this.contex = party_complaint_details;
    }

    @NonNull
    @Override
    public partsdetails_recycler.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_partsdetails, parent, false);
        return new partsdetails_recycler.ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull partsdetails_recycler.ViewHolder holder, int position) {

        // Bind the data to the views in your ViewHolder
        holder.Biil_ID.setText(datum.get(position).getPartsDetails().toString());
//        holder.CMD_ID.setText(" CMD_ID : "+datum.get(position).getComId());
//        holder.MachineNumber.setText(" MachineNumber : "+datum.get(position).getMachineNumber());
//        holder.MachineType.setText(" MachineType : "+datum.get(position).getMachineType());
//
//        holder.isPaymentsStatus.setText(" isPaymentsStatus : "+datum.get(position).getIsPaymentsStatus());
//        holder.createAt.setText(" createAt : "+datum.get(position).getCreateAt());
     //   Log.d("pendingbill",holder.tvCurrentDate.toString());
    }

    @Override
    public int getItemCount() {
        return datum.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvPartsName, tvPartsQuantity, tvIsWarranty, tvPartsPrice, tvPartsQty, tvCurrentDate;
        TextView Biil_ID ,partsdetails,CMD_ID, MachineNumber, MachineType, partsName, partsQuantity, isWarranty, partsPrice, partsQty, currentDate, isPaymentsStatus, createAt, upadateAt, mainTotal, partsDetails;

        LinearLayout data;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            data = itemView.findViewById(R.id.image_partsdetails);

            Biil_ID = itemView.findViewById(R.id.nameparts1);
//            CMD_ID = itemView.findViewById(R.id.nameparts2);
//            MachineNumber = itemView.findViewById(R.id.nameparts3);
//            MachineType = itemView.findViewById(R.id.nameparts4);
//            createAt = itemView.findViewById(R.id.nameparts5);
//            isPaymentsStatus = itemView.findViewById(R.id.nameparts6);
        }
    }
}
