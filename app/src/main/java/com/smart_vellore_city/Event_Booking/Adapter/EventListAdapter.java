package com.smart_vellore_city.Event_Booking.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.smart_vellore_city.Event_Booking.Activity.BookEvent;
import com.smart_vellore_city.Event_Booking.Model.EventListModel;
import com.smart_vellore_city.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class EventListAdapter extends RecyclerView.Adapter <EventListAdapter.EventList_Holder>
{
    Context context;
    List<EventListModel> itemsList;

    public EventListAdapter(Context context, List<EventListModel> itemsList) {
        this.context = context;
        this.itemsList = itemsList;
    }

    @NonNull
    @Override
    public EventList_Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.eventlist_itemview,viewGroup,false);
        return new EventList_Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventList_Holder viewHolder, int i) {
        final EventListModel item = itemsList.get(i);
        viewHolder.image.setImageResource(item.getImageId());
        viewHolder.name.setText(item.getEventName());
        viewHolder.date.setText(item.getEventDate());
        viewHolder.location.setText(item.getEventLocation());
        viewHolder.comments.setText(item.getEventComments()+" Comments");
        viewHolder.participants.setText(item.getEventPartcicipants()+" Participants");
        viewHolder.bookNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context,BookEvent.class).putExtra("name",item.getEventName()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public class EventList_Holder extends RecyclerView.ViewHolder{
        TextView name,date,location,comments,participants;
        Button bookNow;
        CircleImageView image;
        public EventList_Holder(@NonNull View itemView) {
            super(itemView);
            name = (TextView)itemView.findViewById(R.id.eventName_tv);
            date = (TextView)itemView.findViewById(R.id.eventDate_tv);
            location = (TextView)itemView.findViewById(R.id.eventLocation_tv);
            comments = (TextView)itemView.findViewById(R.id.eventComments_tv);
            participants = (TextView)itemView.findViewById(R.id.eventParticipants_tv);
            image = (CircleImageView)itemView.findViewById(R.id.event_img);
            bookNow = itemView.findViewById(R.id.bookNow);
        }
    }
}
