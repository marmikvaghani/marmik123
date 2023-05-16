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
import com.example.cms.amc_exa.AmcDateCheck;

import java.util.List;

public class amc_recycler extends RecyclerView.Adapter<amc_recycler.ViewHolder> {
    List<AmcDateCheck> datum;

    Context contex;
    public amc_recycler(Context amc_expire, List<AmcDateCheck> amcDateCheck) {
        this.datum = amcDateCheck;
        this.contex = amc_expire;

    }

    @NonNull
    @Override
    public amc_recycler.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_amc, parent, false);
        return new amc_recycler.ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.amctodate.setText(" AMC TO Date : "+datum.get(position).getAmcToDate());
       holder.amcfromdate.setText(" AMC From Date: "+datum.get(position).getAmcFromDate());
        holder.machinetype.setText(" Macine type : "+datum.get(position).getMachineType());
        holder.installationdate.setText(" InstallationDate : "+datum.get(position).getInstallationDate());
        holder.extandamcdatearray.setText(" ExtendAmcDateArray : "+datum.get(position).getExtendAmcDateArray());
        holder.warrantyfromdate.setText(" WarrantyFromDate : "+datum.get(position).getWarrantyFromDate());
        holder.machinenumber.setText(" MachineNumber : "+datum.get(position).getMachineNumber());
        holder.warrantytodate.setText(" WarrantyToDate : "+datum.get(position).getWarrantyToDate());
    }

    @Override
    public int getItemCount() {
        return datum.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder  {

        TextView cmp_id,partyName,amctodate,machineid,amcfromdate, machinetype,installationdate,updatedat,extandamcdatearray,warrantyfromdate,createTimeAt,machinenumber,warrantytodate;

        LinearLayout data;

        ViewHolder(View itemView) {
            super(itemView);
            data= itemView.findViewById(R.id.cdata);


            amctodate= itemView.findViewById(R.id.amctodate);
           amcfromdate= itemView.findViewById(R.id.amcfromdate);
            machinetype= itemView.findViewById(R.id.machinetype);
            installationdate= itemView.findViewById(R.id.installationDate);
            extandamcdatearray= itemView.findViewById(R.id.extendamcdatearray);
            warrantyfromdate= itemView.findViewById(R.id.warrantyfrom);
            machinenumber= itemView.findViewById(R.id.machinno);
            warrantytodate= itemView.findViewById(R.id.warrantyto);
        }

    }

}

