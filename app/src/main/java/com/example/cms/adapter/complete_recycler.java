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
import com.example.cms.complaint.Datum;

import java.util.List;

public class complete_recycler extends RecyclerView.Adapter<complete_recycler.ViewHolder> {

    List<Datum>datumdata;

    Context contex;
    public complete_recycler(Context complete_com, List<Datum> data) {
        this.datumdata = data;
        this.contex = complete_com;
    }

    @NonNull
    @Override
    public complete_recycler.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_completed, parent, false);
        return new complete_recycler.ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,@SuppressLint("RecyclerView") int position) {
        holder.cmp_id.setText(" cmdID : "+datumdata.get(position).getCmpId());
        holder.engineerCity.setText(" engineerCity : "+datumdata.get(position).getEngineerCity());
        holder.machineNo.setText(" મશીન નંબર  : "+datumdata.get(position).getMachineNo());
        holder.details.setText(" details : "+datumdata.get(position).getDetails());
        holder.rating.setText(" Rating : "+datumdata.get(position).getRating());
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
        holder.repeatComplaintNumber.setText(" repeatComplaintNumber : "+datumdata.get(position).getRepeatComplaintNumber());
        holder.machineType.setText(" machineType : "+datumdata.get(position).getMachineType());
        holder.upadateAt.setText(" upadateAt : "+datumdata.get(position).getUpadateAt());
        holder.endtime.setText(" End Time : "+datumdata.get(position).getEndTime());
        holder.starttime.setText(" Start Time : "+datumdata.get(position).getStartTime());
        holder.solution.setText(" solution : "+datumdata.get(position).getSolution());
    }

    @Override
    public int getItemCount() {
        return datumdata.size();

    }
    public class ViewHolder extends RecyclerView.ViewHolder  {

        TextView rating,cmp_id,partyName,machineNo, details,engineerName,logBy,partyCity,engineerCity,endtime,starttime,solution;
        TextView  callBy,createDateAt,createTimeAt,upadateDateAt,upadateTimeAt,repeatComplaintNumber,machineType,upadateAt;
        LinearLayout data;

        ViewHolder(View itemView) {
            super(itemView);
            data= itemView.findViewById(R.id.pdata);


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
            rating= itemView.findViewById(R.id.prating);
            repeatComplaintNumber= itemView.findViewById(R.id.prepeatComplaintNumber);
            machineType= itemView.findViewById(R.id.pmachineType);
            upadateAt= itemView.findViewById(R.id.pupadateAt);
            endtime= itemView.findViewById(R.id.ppendtime);
            starttime= itemView.findViewById(R.id.ppstarttime);
            solution= itemView.findViewById(R.id.ppsolution);
        }

    }
}