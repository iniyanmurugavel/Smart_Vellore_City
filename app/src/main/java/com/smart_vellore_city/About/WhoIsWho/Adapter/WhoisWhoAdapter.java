package com.smart_vellore_city.About.WhoIsWho.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableRow;
import android.widget.TextView;
import com.smart_vellore_city.About.Collectors.Model.CollectorsModel;
import com.smart_vellore_city.About.ElectedRepresentatives.Model.ElectedRep_Model;
import com.smart_vellore_city.About.WhoIsWho.Model.WhoisWhoModel;
import com.smart_vellore_city.R;

import java.util.List;

public class WhoisWhoAdapter extends RecyclerView.Adapter <WhoisWhoAdapter.WhoisWho_ViewHolder>
{
    private Context context;
    private List<WhoisWhoModel> itemsList ;
    private List<CollectorsModel> collectorsList;
    private List<ElectedRep_Model> electedRepList;
    private int viewType = 0;

    public WhoisWhoAdapter( List<WhoisWhoModel> itemsList,int viewType) {
        this.itemsList = itemsList;
        this.viewType = viewType;
    }
    public WhoisWhoAdapter(Context context, List<CollectorsModel> collectorsList,int viewType) {
        this.context = context;
        this.collectorsList = collectorsList;
        this.viewType = viewType;
    }
    public WhoisWhoAdapter(Context context, List<ElectedRep_Model> electedRepList, int viewType,String tag) {
        this.context = context;
        this.electedRepList = electedRepList;
        this.viewType = viewType;
    }

    @NonNull
    @Override
    public WhoisWho_ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.whoiswho_itemview,viewGroup,false);
        return new WhoisWho_ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WhoisWho_ViewHolder viewHolder, int i) {
        if(viewType==0) {
            WhoisWhoModel item = itemsList.get(i);
            viewHolder.name_tv.setText(item.getName());
            viewHolder.designation_tv.setText(item.getDesignation());
            viewHolder.phone_tv.setText(item.getPhone());
            viewHolder.email_tv.setText(item.getEmail());
            viewHolder.emailRow.setVisibility(View.VISIBLE);
        }else if(viewType==1){
            CollectorsModel item = collectorsList.get(i);
            viewHolder.designation.setText("From");
            viewHolder.phone.setText("To");
            viewHolder.name_tv.setText(item.getName());
            viewHolder.name_tv.setTextColor(context.getResources().getColor(R.color.colorPrimaryDark));
            viewHolder.designation_tv.setText(item.getFrom());
            viewHolder.phone_tv.setText(item.getTo());
            viewHolder.emailRow.setVisibility(View.GONE);
        }else if(viewType==2){
            ElectedRep_Model item = electedRepList.get(i);
            viewHolder.designation.setText("Constituency");
            viewHolder.phone.setText("Party Name");
            viewHolder.name_tv.setText(item.getMemberName());
            viewHolder.name_tv.setTextColor(context.getResources().getColor(R.color.colorPrimaryDark));
            viewHolder.designation_tv.setText(item.getConstituency());
            viewHolder.phone_tv.setText(item.getPartyName());
            viewHolder.emailRow.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemViewType(int position) {
        switch(position){
            case 0: return 0; //
            case 1: return 1; //collectors
            case 2: return 2; //mla,mp

        }
        return 0;
    }

    @Override
    public int getItemCount() {
        if(viewType==0)
           return itemsList.size();
        else if(viewType==1)
           return collectorsList.size();
        else if(viewType==2)
            return electedRepList.size();
        return itemsList.size();
    }

    public class WhoisWho_ViewHolder extends RecyclerView.ViewHolder{
        TextView name_tv,designation_tv,phone_tv,email_tv;
        TextView name,designation,phone,email;
        TableRow emailRow;
        public WhoisWho_ViewHolder(@NonNull View itemView) {
            super(itemView);
            name_tv = (TextView)itemView.findViewById(R.id.name_tv);
            designation_tv = (TextView)itemView.findViewById(R.id.designation_tv);
            phone_tv = (TextView)itemView.findViewById(R.id.phone_tv);
            email_tv = (TextView)itemView.findViewById(R.id.email_tv);

            name = (TextView)itemView.findViewById(R.id.name);
            designation= (TextView)itemView.findViewById(R.id.designation);
            phone = (TextView)itemView.findViewById(R.id.phone);
            email = (TextView)itemView.findViewById(R.id.email);
            emailRow = (TableRow)itemView.findViewById(R.id.emailRow);

        }
    }
}
