package com.smart_vellore_city.Movie_Booking.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.smart_vellore_city.R;


public class SelectSeatAdapter extends RecyclerView.Adapter <SelectSeatAdapter.MyViewHolder>{
    Context context;

    public SelectSeatAdapter(Context context) {
        this.context = context;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.holder_unchosen_seat,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder viewHolder,final int i) {
        viewHolder.seatNumber.setText(String.valueOf(i+1));
        viewHolder.seat.setTag("false");
        viewHolder.seat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(viewHolder.seat.getTag().equals("true")) {
                     viewHolder.seat.setTag("false");
                     viewHolder.seat.setBackground(context.getResources().getDrawable(R.drawable.seat_notselected));
                    }else{
                     viewHolder.seat.setTag("true");
                     viewHolder.seat.setBackground(context.getResources().getDrawable(R.drawable.seatselected));
                    }
            }

        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        FrameLayout seat;
        TextView seatNumber;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            seat = (FrameLayout)itemView.findViewById(R.id.seat);
            seatNumber = (TextView) itemView.findViewById(R.id.seatNumber);

        }
    }

}
