package com.smart_vellore_city.school.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.smart_vellore_city.R;

public class ReportViewHolder extends RecyclerView.ViewHolder {
     TextView complaintType,studentName,reportDate,reportDescription,showDescription;
     Button reply,send;
    EditText sendText;
    LinearLayout sendLayout;
    public ReportViewHolder(@NonNull View itemView) {
        super(itemView);
        complaintType=itemView.findViewById(R.id.report_type);
        studentName=itemView.findViewById(R.id.student_name);
        reportDate=itemView.findViewById(R.id.report_date);
        reportDescription=itemView.findViewById(R.id.reportdescription);
        showDescription=itemView.findViewById(R.id.desc);
        reply=itemView.findViewById(R.id.reply);
        send=itemView.findViewById(R.id.sendbutton);
        sendText=itemView.findViewById(R.id.replytext);
        sendLayout=itemView.findViewById(R.id.sendlayout);
    }
}
