package com.smart_vellore_city.school.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.smart_vellore_city.R;

import org.w3c.dom.Text;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Murugan on 11-12-2018.
 */

public class ListchildViewHolder extends RecyclerView.ViewHolder {
 CircleImageView childPhoto;
 TextView childName,childAge,childSchool,childPlace;
        CardView studentDetails;
    public ListchildViewHolder(@NonNull View itemView) {
        super(itemView);
        childAge=itemView.findViewById(R.id.childAge);
        childName=itemView.findViewById(R.id.childName);
        childSchool=itemView.findViewById(R.id.childSchool);
        childPlace=itemView.findViewById(R.id.childPlace);
        childPhoto=itemView.findViewById(R.id.childPhoto);
        studentDetails=itemView.findViewById(R.id.studentdetails);
    }
}
