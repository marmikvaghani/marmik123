package com.example.cms.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cms.FooRequest;
import com.example.cms.R;
import com.example.cms.RetrofitApi;
import com.example.cms.rating_put.Example;
import com.example.cms.reviewData.Datum;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class review_recycler extends RecyclerView.Adapter<review_recycler.ViewHolder> {
        List<Datum> datumdata;

        Context contex;

        public review_recycler(Context review_activity, List<Datum> data) {
        this.datumdata = data;
        this.contex = review_activity;

        }
        @NonNull
        @Override
        public review_recycler.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_review, parent, false);
        return new review_recycler.ViewHolder(view);
        }
        @SuppressLint("SetTextI18n")
        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder,@SuppressLint("RecyclerView") int position) {
            holder.cmp_id.setText(" cmdID : "+datumdata.get(position).getCmpId());
            holder.engineerCity.setText(" engineerCity : "+datumdata.get(position).getEngineerCity());
            holder.machineNo.setText(" મશીન નંબર  : "+datumdata.get(position).getMachineNo());
            holder.details.setText(" details : "+datumdata.get(position).getDetails());
            holder.callBy.setText(" callBy : "+datumdata.get(position).getCallBy());
            holder.logBy.setText(" logby: "+datumdata.get(position).getLogBy());
            holder.id.setText(datumdata.get(position).getId());
            holder.engineerName.setText(" એન્જિનિયરનું નામ: "+datumdata.get(position).getEngineerName());
            holder.createDateAt.setText(" createDateAt : "+datumdata.get(position).getCreateDateAt());
            holder.createTimeAt.setText(" createTimeAt : "+datumdata.get(position).getCreateTimeAt());
            holder.upadateDateAt.setText(" upadateDateAt : "+datumdata.get(position).getUpadateAt());
            holder.upadateTimeAt.setText(" upadateTimeAt : "+datumdata.get(position).getUpadateTimeAt());
            holder.repeatComplaintNumber.setText(" repeatComplaintNumber : "+datumdata.get(position).getRepeatComplaintNumber());
            holder.machineType.setText(" machineType : "+datumdata.get(position).getMachineType());
            holder.upadateAt.setText(" upadateAt : "+datumdata.get(position).getUpadateAt());
            holder.startAndEndTimeDuration.setText(" startAndEndTimeDuration : "+datumdata.get(position).getStartAndEndTimeDuration());
            holder.starttime.setText(" starttime : "+datumdata.get(position).getStartTime());
            holder.endtime.setText(" endtime : "+datumdata.get(position).getEndTime());
            holder.solution.setText(" solution : "+datumdata.get(position).getSolution());

//            holder.startComplaintLocation.setText(" startComplaintLocation : "+datumdata.get(position).getStartComplaintLocation());
//            holder.endComplaintLocation.setText(" endComplaintLocation : "+datumdata.get(position).getEndComplaintLocation());


            holder.review.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  AlertDialog.Builder builder = new AlertDialog.Builder(contex);

                    LayoutInflater inflater = LayoutInflater.from(contex);
                    View view = inflater.inflate(R.layout.rating_bar_layout, null);

                  final RatingBar ratingBar = view.findViewById(R.id.rating_bar);


                    builder.setView(view);

                    builder.setTitle("Rate this item");
                    builder.setMessage("Please rate this item from 1 to 5 stars:");

                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {


                            int rating = (int) ratingBar.getRating();

                            String ratingString = Integer.toString(rating);

                            if (rating == 0.0) {
                                Toast.makeText(contex, "Please give a rating", Toast.LENGTH_SHORT).show();
                            } else {

                                ratingBar.setIsIndicator(true);
                                holder.review.setVisibility(View.GONE);
                                holder.donereview.setVisibility(View.VISIBLE);

                                String _id=holder.id.getText().toString();

                                startsubmitData(_id,ratingString);

                                Log.d("cmdid",ratingString);
                                Log.d("id1",_id);
                                holder.donereview.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        boolean hasRated = true;

                                        if (hasRated) {
                                            AlertDialog.Builder builder = new AlertDialog.Builder(contex);
                                            builder.setTitle("Your rating");

                                            builder.setMessage("You have rated this item " + ratingString + " stars.");
                                            Log.d("rating", String.valueOf(ratingBar));
                                            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    dialog.dismiss();
                                                }
                                            });
                                            AlertDialog dialog = builder.create();
                                            dialog.show();
                                        } else {
                                            Toast.makeText(contex, "You haven't rated this item yet.", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            }
                        }
                    });

// set the negative button action
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });

// create and show the dialog box
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
                });

        }

    private void startsubmitData(String id, String rating) {

        FooRequest fooRequest = new FooRequest(id, rating);

        Call<Example> call = RetrofitApi.getInstance().getMyApi().getrating(id,fooRequest);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(@NonNull Call<Example> call, @NonNull Response<Example> response) {
                if(response.isSuccessful()) {
                    Log.d("response", response.body().toString());
                } else {
                    Log.d("response", "Error: " + response.code());
                }
            }

            @Override
            public void onFailure(@NonNull Call<Example> call, @NonNull Throwable t) {
                Log.e("Error", t.getMessage());
            }
        });
    }

    @Override
    public int getItemCount() {
            return datumdata.size();

            }
    public class ViewHolder extends RecyclerView.ViewHolder  {

        TextView id,cmp_id,partyName,machineNo, details,engineerName,logBy,partyCity,engineerCity,endtime,starttime,solution,startAndEndTimeDuration,endComplaintLocation,startComplaintLocation;;
        TextView  callBy,createDateAt,createTimeAt,upadateDateAt,upadateTimeAt,repeatComplaintNumber,machineType,upadateAt;
        LinearLayout data;
        ImageView review,donereview;
        ViewHolder(View itemView) {
            super(itemView);
            data= itemView.findViewById(R.id.rrdata);
            id=itemView.findViewById(R.id.id);
            cmp_id= itemView.findViewById(R.id.rpcmp_id);
            review= itemView.findViewById(R.id.review_com);
            donereview= itemView.findViewById(R.id.donereview_com);


             engineerCity= itemView.findViewById(R.id.rpengineerCity);
            machineNo= itemView.findViewById(R.id.rpmachineNo);
            details= itemView.findViewById(R.id.rpdetails);
            callBy= itemView.findViewById(R.id.rpcallBy);
            logBy= itemView.findViewById(R.id.rplogby);
            engineerName= itemView.findViewById(R.id.rpengineerName);
            createDateAt= itemView.findViewById(R.id.rpcreateDateAt);
            createTimeAt= itemView.findViewById(R.id.rpcreateTimeAt);
            upadateDateAt= itemView.findViewById(R.id.rpupadateDateAt);
            upadateTimeAt= itemView.findViewById(R.id.rpupadateTimeAt);
            repeatComplaintNumber= itemView.findViewById(R.id.rprepeatComplaintNumber);
            machineType= itemView.findViewById(R.id.rpmachineType);
            upadateAt= itemView.findViewById(R.id.rpupadateAt);

            endtime= itemView.findViewById(R.id.rpendtime);
            starttime= itemView.findViewById(R.id.rpstarttime);
            solution= itemView.findViewById(R.id.rpsolution);
            startAndEndTimeDuration= itemView.findViewById(R.id.rpstartAndEndTimeDuration);
//            endComplaintLocation= itemView.findViewById(R.id.rpendComplaintLocation);
//            startComplaintLocation= itemView.findViewById(R.id.rpstartComplaintLocation);


        }

}
}
