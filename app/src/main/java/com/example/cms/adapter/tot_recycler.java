package com.example.cms.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cms.R;
import com.example.cms.party_details.PartyMachineDetail;
import com.example.cms.totmachine_Details;

import java.util.List;

public class tot_recycler extends RecyclerView.Adapter<tot_recycler.ViewHolder >{

    List<PartyMachineDetail> datumList;

    Context context;

    public tot_recycler(totmachine_Details finalPage, List<PartyMachineDetail> data) {
        this.datumList = data;
        this.context = finalPage;
    }

    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_machine, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        //  holder.id.setText(" ID : "+datumList.get(position).getId());
        holder.machineNumber.setText( " મશીન નંબર : "+datumList.get(position).getMachineNumber());
        holder.machinetype.setText(" મશીન નો પ્રકાર : "+datumList.get(position).getMachineType());
        holder.installationDate.setText(" શરૂક્ર્યા ની તારીખ : "+datumList.get(position).getInstallationDate());
        holder.amcFromDate.setText(" amc તારીખથી: "+datumList.get(position).getAmcFromDate());
        holder.amcToDate.setText(" amc ત્યા સુધી : "+datumList.get(position).getAmcToDate());
        holder.warrantyFromDate.setText(" warrantyFromDate : "+datumList.get(position).getWarrantyFromDate());
        holder.warrantyToDate.setText(" warrantyToDate : "+datumList.get(position).getWarrantyToDate());
        holder.updatedAt.setText(" updatedAt : "+datumList.get(position).getUpdatedAt());

    }
    public int getItemCount() {
        return datumList.size();
    }
    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder  {
        TextView  partyCity,partyName,machineNumber, installationDate,amcFromDate,machinetype,amcToDate;
        LinearLayout data;
        TextView warrantyFromDate,warrantyToDate,updatedAt;


        ViewHolder(View itemView) {
            super(itemView);
            machineNumber= itemView.findViewById(R.id.mmachineNumber);
            machinetype= itemView.findViewById(R.id.mmachineType);
            installationDate= itemView.findViewById(R.id.minstallationDate);
            amcFromDate= itemView.findViewById(R.id.mamcFromDate);
            amcToDate= itemView.findViewById(R.id.mamcToDate);
            warrantyToDate= itemView.findViewById(R.id.mwarrantyToDate);
            warrantyFromDate= itemView.findViewById(R.id.mwarrantyFromDate);
            updatedAt= itemView.findViewById(R.id.mupdatedAt);
            data= itemView.findViewById(R.id.mdata);

        }

    }
}
