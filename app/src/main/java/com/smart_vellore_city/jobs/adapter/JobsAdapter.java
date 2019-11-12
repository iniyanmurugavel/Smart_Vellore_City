package com.smart_vellore_city.jobs.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.smart_vellore_city.R;
import com.smart_vellore_city.jobs.pojo.JobsModel;

import java.util.ArrayList;

public class JobsAdapter extends RecyclerView.Adapter<JobsAdapter.ViewHolder> {

    private ArrayList<JobsModel> jobsModelArrayList=new ArrayList<>();
    private Context context;

    public JobsAdapter(ArrayList<JobsModel> jobsModelArrayList, Context context) {
        this.jobsModelArrayList = jobsModelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.jobslistingadapter,viewGroup,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.company_Name.setText(jobsModelArrayList.get(i).getCompanyName());
        viewHolder.designation.setText(jobsModelArrayList.get(i).getRole());
        viewHolder.experience.setText(jobsModelArrayList.get(i).getExperience());
        viewHolder.location.setText(jobsModelArrayList.get(i).getLocation());
        viewHolder.postedDate.setText(jobsModelArrayList.get(i).getPostedDate());

    }

    @Override
    public int getItemCount() {
        return jobsModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView company_Name,designation,experience,location,postedDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        company_Name=itemView.findViewById(R.id.companyname);
        designation=itemView.findViewById(R.id.job_posting);
        experience=itemView.findViewById(R.id.exp_text);
        location=itemView.findViewById(R.id.location_text);
        postedDate=itemView.findViewById(R.id.posteddate_text);
        }
    }
}
