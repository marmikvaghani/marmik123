package com.example.cms.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cms.R;
import com.example.cms.pending_bills.Datum;

import java.util.List;

public class TargetRecyclerViewAdapter extends RecyclerView.Adapter<TargetRecyclerViewAdapter.ViewHolder> {

    private List<Datum.PartsDetail> partsDetailsList;

    public TargetRecyclerViewAdapter(List<Datum.PartsDetail> partsDetailsList) {
        this.partsDetailsList = partsDetailsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_partsdetails, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Datum.PartsDetail partsDetail = partsDetailsList.get(position);
        holder.partsDetails.setText("partsDetails: " + partsDetail.getPartsName());
        // Set other views and data as needed
    }

    @Override
    public int getItemCount() {
        return partsDetailsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView partsDetails;
        LinearLayout image_partsdetails;
        // Declare other views in the item layout

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image_partsdetails=itemView.findViewById(R.id.image_partsdetails);
            partsDetails = itemView.findViewById(R.id.nameparts1);
            // Initialize other views in the item layout
        }
    }
}
