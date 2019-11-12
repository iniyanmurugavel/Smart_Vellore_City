package com.smart_vellore_city.SchoolColleges.adapter;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.request.RequestOptions;
import com.smart_vellore_city.R;
import com.smart_vellore_city.SchoolColleges.beans.SchoolCollegeBean;
import com.smart_vellore_city.SchoolColleges.viewholders.SchoolCollegeViewHolder;
import com.smart_vellore_city.Tourism.activity.TourismMapsActivity;
import com.smart_vellore_city.Utils.Common;
import com.smart_vellore_city.Utils.GlideApp;

import java.util.List;

public class SchoolCollegeAdapter extends RecyclerView.Adapter<SchoolCollegeViewHolder> implements ActivityCompat.OnRequestPermissionsResultCallback{
    int type;
    Context context;
    List<SchoolCollegeBean> schoolCollegeBeanList;

    private static final String CALL_PHONE = Manifest.permission.CALL_PHONE;
    private static final int CALL_PERMISSION_REQUEST_CODE = 12346;

    public SchoolCollegeAdapter(Context context, List<SchoolCollegeBean> schoolCollegeBeanList) {
        this.context = context;
        this.schoolCollegeBeanList = schoolCollegeBeanList;
    }

    @NonNull
    @Override
    public SchoolCollegeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_school_college,viewGroup,false);
        return new SchoolCollegeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final SchoolCollegeViewHolder schoolCollegeViewHolder, final int i) {
        schoolCollegeViewHolder.tv_name.setText(schoolCollegeBeanList.get(i).getmName());
        schoolCollegeViewHolder.tv_address.setText(schoolCollegeBeanList.get(i).getmAddress());
        schoolCollegeViewHolder.tv_phno.setText(schoolCollegeBeanList.get(i).getmMobileNo());

        GlideApp
                .with(context)
                .load(schoolCollegeBeanList.get(i).getmUrl())
                .apply(new RequestOptions()
                        .placeholder(R.drawable.ic_school)
                        .fitCenter())
                .into(schoolCollegeViewHolder.img_school);
        schoolCollegeViewHolder.tv_phno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Common.ISCALLPERMISSIONENABLED){
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:"+schoolCollegeBeanList.get(i).getmMobileNo()));
                    context.startActivity(callIntent);
                }else{
                    getLocationPermission();
                }

            }
        });
        schoolCollegeViewHolder.tv_locate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, TourismMapsActivity.class);
                i.putExtra("title", "schoolsColleges");
                i.putExtra("lat",12.930825);
                i.putExtra("lng",79.158211);
                i.putExtra("schoolName",schoolCollegeViewHolder.tv_name.getText().toString());
                context.startActivity(i);
            }
        });


    }


    public void getLocationPermission() {
        String[] permissions = {Manifest.permission.CALL_PHONE};
        if (ContextCompat.checkSelfPermission(context.getApplicationContext(), CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            Common.ISCALLPERMISSIONENABLED = true;

        } else {
            ActivityCompat.requestPermissions((Activity) context, permissions, CALL_PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    public int getItemCount() {
        return schoolCollegeBeanList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(type == 0){
            return 0;
        }else{
            return 1;
        }
    }

    @Override
    public void onRequestPermissionsResult(int i, @NonNull String[] strings, @NonNull int[] ints) {
        switch (i) {
            case CALL_PERMISSION_REQUEST_CODE: {

                // If request is cancelled, the result arrays are empty.
                if (ints.length > 0
                        && ints[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    Common.ISCALLPERMISSIONENABLED = true;
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Common.ISCALLPERMISSIONENABLED = false;
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }
}
