package com.example.eliaacompany.layout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.eliaacompany.R;
import com.example.eliaacompany.adapter.ReservationAdapter;
import com.example.eliaacompany.databinding.ActivityReservationsBinding;
import com.example.eliaacompany.model.reservation.ReservationData;
import com.example.eliaacompany.service.Service;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.eliaacompany.layout.LoginActivity.PREF_NAME;
import static com.example.eliaacompany.layout.LoginActivity.parseError;

public class ReservationsActivity extends AppCompatActivity {
    ReservationAdapter reservationAdapter;
    ActivityReservationsBinding binding;
    List<ReservationData> list;
    Service service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityReservationsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        list = new ArrayList<>() ;

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        binding.recyclerview.setLayoutManager(linearLayoutManager);

        reservationAdapter = new ReservationAdapter(this);

        binding.recyclerview.setAdapter(reservationAdapter);

        service = Service.ApiClient.getRetrofitInstance();

        getReservation();

    }
    private void getReservation() {

        LoginActivity.SP = getSharedPreferences(PREF_NAME ,MODE_PRIVATE);
        String token = LoginActivity.SP.getString(LoginActivity.TokenKey, "");


        service.getReservationData(token).enqueue(new Callback<List<ReservationData>>() {
            @Override
            public void onResponse(Call<List<ReservationData>> call, Response<List<ReservationData>> response) {

                if (response.isSuccessful()) {

                    list = response.body();
                    reservationAdapter.setData(list);

                }else {
                    String errorMessage = parseError(response);
                    Log.e("errorMessage", errorMessage + "");
                    Toast.makeText(getBaseContext(), response.message()+"", Toast.LENGTH_LONG).show();

                }
            }
            @Override
            public void onFailure(Call<List<ReservationData>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }


}