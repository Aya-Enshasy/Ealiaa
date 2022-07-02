package com.example.eliaacompany.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ResourceCursorAdapter;
import android.widget.Toast;

import com.example.eliaacompany.R;
import com.example.eliaacompany.adapter.ReservationAdapter;
import com.example.eliaacompany.databinding.ActivityReservationDetailsBinding;
import com.example.eliaacompany.model.reservation.ReservationData;
import com.example.eliaacompany.model.reservation.ReservationExample;
import com.example.eliaacompany.service.Service;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.eliaacompany.layout.LoginActivity.PREF_NAME;
import static com.example.eliaacompany.layout.LoginActivity.parseError;

public class ReservationDetailsActivity extends AppCompatActivity {
    ActivityReservationDetailsBinding binding;
    int ReservationId ;
    Service service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityReservationDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getData();
        getRetrofitInstance();
        getChurchesDetails();


    }


    private void getChurchesDetails() {

        LoginActivity.SP = this.getSharedPreferences(PREF_NAME ,MODE_PRIVATE);
        String token = LoginActivity.SP.getString(LoginActivity.TokenKey, "");//"No name defined" is the default value.

//        service.getReservationDataDetails(ReservationId,token).enqueue(new Callback<ReservationExample>() {
//            @Override
//            public void onResponse(Call<ReservationExample> call, Response<ReservationExample> response) {
//                if (response.isSuccessful()){
//
////                    binding.edArea.setText( response.body().getData().getArea());
////                    binding.edArrivalTime.setText( response.body().getData().getReservation_arrival_time());
////                    binding.edArriveComments.setText(response.body().getData().getAvailableTime()+"");
////                    binding.edArriveDus.setText( response.body().getData().getDetails());
////                    binding.edBooking.setText( response.body().getData().getAvailableDay()+"");
////                    binding.edBusCount.setText( response.body().getData().getAreaSpace()+"");
////                    binding.edCollecting.setText( response.body().getData().getVisitorsCount());
////                    binding.edComments.setText( response.body().getData().getDetails());
////                    binding.edCustomerMobile.setText( response.body().getData().getAvailableDay()+"");
////                    binding.edCustomerName.setText( response.body().getData().getAreaSpace()+"");
////                    binding.edDelegate.setText( response.body().getData().getVisitorsCount());
////                    binding.edDriverName.setText( response.body().getData().getVisitorsCount());
////                    binding.edGoPath.setText( response.body().getData().getVisitorsCount());
////                    binding.edPayment.setText( response.body().getData().getVisitorsCount());
////                    binding.edPrice.setText( response.body().getData().getVisitorsCount());
////                    binding.edRemainingPrice.setText( response.body().getData().getVisitorsCount());
////                    binding.edReservationDate.setText( response.body().getData().getVisitorsCount());
////                    binding.edReservationReason.setText( response.body().getData().getVisitorsCount());
////                    binding.edReservationType.setText( response.body().getData().getVisitorsCount());
////                    binding.edReturnBus.setText( response.body().getData().getVisitorsCount());
////                    binding.edReturnComments.setText( response.body().getData().getVisitorsCount());
////                    binding.edReturnData.setText( response.body().getData().getVisitorsCount());
////                    binding.edReturnDate.setText( response.body().getData().getVisitorsCount());
////                    binding.edReturnPath.setText( response.body().getData().getVisitorsCount());
//
//
//                }else {
//
//                    String errorMessage = parseError(response);
//                    Log.e("errorMessage", errorMessage + "");
//                    Toast.makeText(getBaseContext(), response.message()+"", Toast.LENGTH_LONG).show();
//
//                }
//            }
//            @Override
//            public void onFailure(Call<ReservationExample> call, Throwable t) {
//                t.printStackTrace();
//                Toast.makeText(getApplicationContext(), t.getMessage()+"", Toast.LENGTH_LONG).show();
//
//
//            }
//
//        });


    }


    private void getData(){
        if (getIntent() != null) {
            ReservationId = getIntent().getIntExtra(ReservationAdapter.RESERVATION_ID,0);
        }
    }

    private void getRetrofitInstance(){
        service= Service.ApiClient.getRetrofitInstance();
    }

}