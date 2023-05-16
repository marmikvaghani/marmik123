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

import com.example.cms.Panding_complaint.pandingComplaintdetails;
import com.example.cms.R;
import com.example.cms.panding_complaint;

import java.util.List;

public class panding_Adapter  extends RecyclerView.Adapter<panding_Adapter.ViewHolder >{

    List<pandingComplaintdetails> datumdata;

    Context contex;

    public panding_Adapter(panding_complaint panding_complaint_details, List<pandingComplaintdetails> pandingComplaintdetails) {
        this.datumdata = pandingComplaintdetails;
        this.contex = panding_complaint_details;
    }
    @NonNull
    @Override
    public panding_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_panding, parent, false);
        return new panding_Adapter.ViewHolder(view);
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull panding_Adapter.ViewHolder holder, int position) {

        holder.cmp_id.setText(" cmdID : "+datumdata.get(position).getCmpId());
        holder.engineerCity.setText(" engineerCity : "+datumdata.get(position).getEngineerCity());
        holder.machineNo.setText(" મશીન નંબર  : "+datumdata.get(position).getMachineNo());
        holder.details.setText(" details : "+datumdata.get(position).getDetails());
        holder.callBy.setText(" callBy : "+datumdata.get(position).getCallBy());
        holder.logBy.setText(" logby: "+datumdata.get(position).getLogBy());
        holder.engineerName.setText(" એન્જિનિયરનું નામ: "+datumdata.get(position).getEngineerName());
        holder.createDateAt.setText(" createDateAt : "+datumdata.get(position).getCreateDateAt());
        holder.createTimeAt.setText(" createTimeAt : "+datumdata.get(position).getCreateTimeAt());
        holder.upadateDateAt.setText(" upadateDateAt : "+datumdata.get(position).getUpadateAt());
        holder.upadateTimeAt.setText(" upadateTimeAt : "+datumdata.get(position).getUpadateTimeAt());
        holder.repeatComplaintNumber.setText(" repeatComplaintNumber : "+datumdata.get(position).getRepeatComplaintNumber());
        holder.machineType.setText(" machineType : "+datumdata.get(position).getMachineType());
        holder.upadateAt.setText(" upadateAt : "+datumdata.get(position).getUpadateAt());

        holder.start.setText(" StartTime : "+datumdata.get(position).getStartTime());
        holder.end.setText(" EndTime : "+datumdata.get(position).getEndTime());
        holder.solution.setText(" solution : "+datumdata.get(position).getSolution());
        holder.startAndEndTimeDuration.setText(" startAndEndTimeDuration : "+datumdata.get(position).getStartAndEndTimeDuration());
        holder.startComplaintLocation.setText(" startComplaintLocation : "+datumdata.get(position).getStartComplaintLocation());
        holder.rating.setText(" rating : "+datumdata.get(position).getRating());
        holder.endComplaintLocation.setText(" endComplaintLocation : "+datumdata.get(position).getEndComplaintLocation());


    }

    @Override
    public int getItemCount() {
        return datumdata.size();

    }
    public class ViewHolder extends RecyclerView.ViewHolder  {

        TextView cmp_id,partyName,machineNo, details,engineerName,logBy,partyCity,engineerCity,end,start,rating,startComplaintLocation,endComplaintLocation,startAndEndTimeDuration,solution;
        TextView  callBy,createDateAt,createTimeAt,upadateDateAt,upadateTimeAt,repeatComplaintNumber,machineType,upadateAt;
        LinearLayout data;

        ViewHolder(View itemView) {
            super(itemView);
            data= itemView.findViewById(R.id.ppdata);


            cmp_id= itemView.findViewById(R.id.pcmp_id);
            engineerCity= itemView.findViewById(R.id.pengineerCity);
            machineNo= itemView.findViewById(R.id.pmachineNo);
            details= itemView.findViewById(R.id.pdetails);
            callBy= itemView.findViewById(R.id.pcallBy);
            logBy= itemView.findViewById(R.id.plogby);
            engineerName= itemView.findViewById(R.id.pengineerName);
            createDateAt= itemView.findViewById(R.id.pcreateDateAt);
            createTimeAt= itemView.findViewById(R.id.pcreateTimeAt);
            upadateDateAt= itemView.findViewById(R.id.pupadateDateAt);
            upadateTimeAt= itemView.findViewById(R.id.pupadateTimeAt);
            repeatComplaintNumber= itemView.findViewById(R.id.prepeatComplaintNumber);
            machineType= itemView.findViewById(R.id.pmachineType);
            upadateAt= itemView.findViewById(R.id.pupadateAt);
            start= itemView.findViewById(R.id.pstarttime);
            end= itemView.findViewById(R.id.pendtime);
            rating= itemView.findViewById(R.id.prating);
            solution= itemView.findViewById(R.id.psolution);
            endComplaintLocation= itemView.findViewById(R.id.pendComplaintLocation);
            startComplaintLocation= itemView.findViewById(R.id.pstartComplaintLocation);
            startAndEndTimeDuration= itemView.findViewById(R.id.pstartAndEndTimeDuration);



        }

    }

}

