package com.example.cms;

import com.example.cms.Panding_complaint.PandingExample;
import com.example.cms.amc_exa.AmcClass;
import com.example.cms.complaint.ComComplaint;
import com.example.cms.model.Example;
import com.example.cms.model.homedata;
import com.example.cms.party_complaint.tot_com;
import com.example.cms.party_details.MDExample;
import com.example.cms.party_details.MachineNo;
import com.example.cms.pending_bills.Datum;
import com.example.cms.pro.ProfileData;
import com.example.cms.reviewData.ReviewData;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface api {

    String BASE_URL ="https://cms-sparrow.herokuapp.com/" ;

    @POST("party-apk-api/login")
    @FormUrlEncoded
        //on below line we are creating a method to post our data.
    Call<Example> Login(@Field("name")String name, @Field("passWord")String passWord);

    @POST("party-apk-api/party_count")
    @FormUrlEncoded
    Call<homedata> getcount(@Field("name") String body);

    @POST("party-apk-api/party_machine_details")
    @FormUrlEncoded
    Call<MDExample> getMachineDetails(@Field("name") String name);

    @POST("party-apk-api/party_compaint_details")
    @FormUrlEncoded
    Call<tot_com> getcompaintDetails(@Field("name") String name);

    @POST("party-apk-api/party_pending_compaint")
    @FormUrlEncoded
    Call<PandingExample> getpandingcomplaint(@Field("name") String name,@Field("isCompleted")String isCompleted);

    @POST("party-apk-api/party_complete_compaint")
    @FormUrlEncoded
    Call<ComComplaint> getcomplit_comp(@Field("name") String name,  @Field("isCompleted")String isCompleted);

    @POST("party-apk-api/party_review_compaint")
    @FormUrlEncoded
    Call<ReviewData> getreview(@Field("name") String name, @Field("isCompleted")String isCompleted);

    @POST("party-apk-api/amc_exp_data")
    @FormUrlEncoded
    Call<AmcClass> getAMC(@Field("name") String name, @Field("isCompleted")String isCompleted);

    @POST("party-apk-api/party_profile")
    @FormUrlEncoded
    Call<ProfileData> getprofile(@Field("name") String name);

    @POST("party-apk-api/party_machine_details")
    @FormUrlEncoded
    Call<MDExample> getmachinetype(@Field("name") String name);

    @POST("party-apk-api/party_machine_type_vice_details")
    @FormUrlEncoded
    Call<MachineNo> getmachineNo(@Field("name") String name);

    @POST("party-apk-api/find_complaint_machinetype_problems")
    @FormUrlEncoded
    Call<com.example.cms.machien_problem.Example> getmachineproblem(@Field("machineType") String machineType);

    @Headers({"Content-Type: application/json"})
    @PUT("party-apk-api/complaint_rating/{id}/")
    Call<com.example.cms.rating_put.Example>getrating(@Path("id") String id, @Body FooRequest fooRequest);

    @Headers({"Content-Type: application/json"})
    @PUT("party/party/{id}/")
    Call<com.example.cms.notification.Example>getNotification(@Path("id") String id, @Body FooRequest1 fooRequest);

    @POST("party-apk-api/pending_parts_bill")
    @FormUrlEncoded
    Call<com.example.cms.pending_bills.Example> getpendingbill(@Field("name") String name);

    @POST("party-apk-api/pending_parts_bill")
    @FormUrlEncoded
    Call<com.example.cms.pending_bills.Example> getpartsdetails(@Field("name") String name);

}