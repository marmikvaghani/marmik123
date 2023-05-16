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
import com.example.cms.party_complaint.PartyCompaintDetail;
import com.example.cms.party_complaint_Details;

import java.util.List;

public class complaint_recycler extends RecyclerView.Adapter<complaint_recycler.ViewHolder >{
    List<PartyCompaintDetail> datum;

    Context contex;
    public complaint_recycler(party_complaint_Details party_complaint_details, List<PartyCompaintDetail> partyCompaintDetails) {
        this.datum = partyCompaintDetails;
        this.contex = party_complaint_details;
    }

    @NonNull
    @Override
    public complaint_recycler.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_complaint, parent, false);
        return new complaint_recycler.ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override

    public void onBindViewHolder(@NonNull  complaint_recycler.ViewHolder holder, int position) {

        holder.cmp_id.setText(" cmdID : "+datum.get(position).getCmpId());
        holder.engineerCity.setText(" eng city : "+datum.get(position).getEngineerCity());
        holder.machineNo.setText(" મશીન નંબર : "+datum.get(position).getMachineNo());
        holder.details.setText(" details: "+datum.get(position).getDetails());
        holder.callBy.setText(" Callby : "+datum.get(position).getCallBy());
        holder.logby.setText(" logby : "+datum.get(position).getLogBy());
        holder.engineerName.setText(" eng name : "+datum.get(position).getEngineerName());
        holder.createDateAt.setText(" createDateAt : "+datum.get(position).getCreateDateAt());
        holder.createTimeAt.setText(" createTimeAt : "+datum.get(position).getCreateTimeAt());
        holder.upadateDateAt.setText(" upadateDateAt : "+datum.get(position).getUpadateAt());
        holder.upadateTimeAt.setText(" upadateTimeAt : "+datum.get(position).getUpadateTimeAt());
        holder.repeatComplaintNumber.setText(" repeatComplaintNumber : "+datum.get(position).getRepeatComplaintNumber());
        holder.machineType.setText(" machineType : "+datum.get(position).getMachineType());
        holder.endTime.setText(" endTime : "+datum.get(position).getEndTime());
        holder.startTime.setText(" startTime : "+datum.get(position).getStartTime());
        holder.solution.setText(" solution : "+datum.get(position).getSolution());
        holder.upadateAt.setText(" upadateAt : "+datum.get(position).getUpadateAt());
        holder.rating.setText(" rating : "+datum.get(position).getRating());


    }


    @Override
    public int getItemCount() {
        return datum.size();

    }
    public static class ViewHolder extends RecyclerView.ViewHolder  {

        TextView cmp_id,partyCity,engineerCity,machineNo, details,callBy,logby,engineerName,createDateAt,createTimeAt,upadateDateAt;
        TextView upadateTimeAt,repeatComplaintNumber,machineType,endTime,startTime,solution,upadateAt,rating;
        LinearLayout data;

        ViewHolder(View itemView) {
            super(itemView);
            data= itemView.findViewById(R.id.cdata);


            cmp_id= itemView.findViewById(R.id.ccmpid);

            engineerCity= itemView.findViewById(R.id.cengineerCity);
            machineNo= itemView.findViewById(R.id.cmachineNo);
            details= itemView.findViewById(R.id.cdetails);
            callBy= itemView.findViewById(R.id.ccallBy);
            logby= itemView.findViewById(R.id.clogby);
            engineerName= itemView.findViewById(R.id.cengineerName);
            createDateAt= itemView.findViewById(R.id.ccreateDateAt);
            createTimeAt= itemView.findViewById(R.id.ccreateTimeAt);
            upadateDateAt= itemView.findViewById(R.id.cupadateDateAt);
            upadateTimeAt= itemView.findViewById(R.id.cupadateTimeAt);
            repeatComplaintNumber= itemView.findViewById(R.id.crepeatComplaintNumber);
            machineType= itemView.findViewById(R.id.cmachineType);
            endTime= itemView.findViewById(R.id.cendTime);
            startTime= itemView.findViewById(R.id.cstartTime);
            solution= itemView.findViewById(R.id.csolution);
            upadateAt= itemView.findViewById(R.id.cupadateAt);
            rating=itemView.findViewById(R.id.crating);



        }

    }

}
