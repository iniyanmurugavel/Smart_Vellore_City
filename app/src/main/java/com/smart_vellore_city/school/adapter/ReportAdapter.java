package com.smart_vellore_city.school.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.smart_vellore_city.R;
import com.smart_vellore_city.school.pojo.ReportList;

import java.util.ArrayList;

/**
 * Created by Murugan on 10-12-2018.
 */

public class ReportAdapter extends RecyclerView.Adapter<ReportViewHolder> {
  private   ArrayList<ReportList> reportListArrayList;
  private Context context;
  private boolean isClicked=true;
    public ReportAdapter(ArrayList<ReportList> reportListArrayList, Context context) {
        this.reportListArrayList = reportListArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ReportViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.report_adapter,null,false);
        return new ReportViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ReportViewHolder reportViewHolder, int i) {

        reportViewHolder.complaintType.setText(reportListArrayList.get(i).getReportType());
        reportViewHolder.studentName.setText(reportListArrayList.get(i).getFacultyName());
        reportViewHolder.reportDate.setText(reportListArrayList.get(i).getReportDate());
        reportViewHolder.showDescription.setText(reportListArrayList.get(i).getReportDescription());
        reportViewHolder.reportDescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isClicked){
                    reportViewHolder.showDescription.setVisibility(View.VISIBLE);
                    reportViewHolder.reply.setVisibility(View.VISIBLE);
                    isClicked=false;
                }else{
                    reportViewHolder.showDescription.setVisibility(View.GONE);
                    reportViewHolder.reply.setVisibility(View.GONE);
                    isClicked=true;
                }
            }
        });

        reportViewHolder.reply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reportViewHolder.reply.setVisibility(View.GONE);
                reportViewHolder.sendLayout.setVisibility(View.VISIBLE);
            }
        });
        reportViewHolder.send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(reportViewHolder.sendText.getText().toString().isEmpty()){
                    Toast.makeText(context, "Reply cannot be Empty", Toast.LENGTH_SHORT).show();
                }else
                {
                    Toast.makeText(context, "Reply send successfully", Toast.LENGTH_SHORT).show();
                    reportViewHolder.sendLayout.setVisibility(View.GONE);
                    reportViewHolder.showDescription.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return reportListArrayList.size();
    }


}
