package com.smart_vellore_city.school.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smart_vellore_city.R;
import com.smart_vellore_city.school.pojo.ListChildData;
import com.smart_vellore_city.school.TeacherReports;

import java.util.ArrayList;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

/**
 * Created by Murugan on 11-12-2018.
 */

public class ListChildAdapter extends RecyclerView.Adapter<ListchildViewHolder> {
    Context context;
    ArrayList<ListChildData> listChildDataArrayList;

    public ListChildAdapter(Context context, ArrayList<ListChildData> listChildDataArrayList) {
        this.context = context;
        this.listChildDataArrayList = listChildDataArrayList;
    }

    @NonNull
    @Override
    public ListchildViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.child_adapter,null,false);
        return new ListchildViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListchildViewHolder listchildViewHolder, int i) {
        listchildViewHolder.childAge.setText(listChildDataArrayList.get(i).getChildAge());
        listchildViewHolder.childName.setText(listChildDataArrayList.get(i).getChildName());
        listchildViewHolder.childPlace.setText(listChildDataArrayList.get(i).getChildPlace());
        listchildViewHolder.childSchool.setText(listChildDataArrayList.get(i).getSchoolName());
        listchildViewHolder.childPhoto.setImageResource(listChildDataArrayList.get(i).getChildPic());
        listchildViewHolder.studentDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context, TeacherReports.class);
                i.addFlags(FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });
    }


    @Override
    public int getItemCount() {
        return listChildDataArrayList.size();
    }
}
