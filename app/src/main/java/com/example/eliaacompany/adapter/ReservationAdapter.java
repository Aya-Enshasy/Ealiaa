package com.example.eliaacompany.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.eliaacompany.databinding.AddItemBinding;
import com.example.eliaacompany.layout.ReservationDetailsActivity;
import com.example.eliaacompany.model.reservation.ReservationData;
import com.example.eliaacompany.service.MyInterface;

import java.util.List;

public class ReservationAdapter extends RecyclerView.Adapter<ReservationAdapter.ViewHolder> {
    private List<ReservationData> list  ;
    Context context;
    public final static String RESERVATION_ID = "reservation_id" ;


    public ReservationAdapter(Context context){
        this.context= context;
    }
    public void setData(List<ReservationData> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public ReservationAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        AddItemBinding binding = AddItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ReservationAdapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ReservationAdapter.ViewHolder holder, int position) {

        holder.binding.tvCustomerName.setText(list.get(position).getCustomer_name());
        holder.binding.tvCustomerNumber.setText(list.get(position).getCustomer_number());
        holder.binding.tvArea.setText(list.get(position).getArea());
        holder.binding.tvBookingSide.setText(list.get(position).getBooking_side());
        holder.binding.tvBusCount.setText(list.get(position).getBus_count());
        holder.binding.tvCollectingSide.setText(list.get(position).getCollecting_side());
        holder.binding.tvDriverName.setText(list.get(position).getDriver_name());
        holder.binding.tvPrice.setText(list.get(position).getPrice());
        holder.binding.tvRemaining.setText(list.get(position).getRemaining());
        holder.binding.tvReservationArrivalTime.setText(list.get(position).getReservation_arrival_time());
        holder.binding.tvReservationDate.setText(list.get(position).getReservation_date());
        holder.binding.tvReservationReason.setText(list.get(position).getReservation_reason());
        holder.binding.tvReservationReturnTime.setText(list.get(position).getReservation_return_time());
        holder.binding.tvReservationType.setText(list.get(position).getReservation_type());


        setUpActions(holder, position);

    }

    private void setUpActions(ReservationAdapter.ViewHolder holder, int position) {
        holder.binding.details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, ReservationDetailsActivity.class);
                intent.putExtra(RESERVATION_ID, list.get(position).getId());
                context.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return list!=null?list.size():0;
    }




    public static class ViewHolder extends RecyclerView.ViewHolder  {
        AddItemBinding binding;
        public ViewHolder(AddItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }


    }

}
