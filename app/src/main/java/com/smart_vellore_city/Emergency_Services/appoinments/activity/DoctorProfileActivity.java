package com.smart_vellore_city.Emergency_Services.appoinments.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.request.RequestOptions;
import com.smart_vellore_city.Emergency_Services.appoinments.models.DocBean;
import com.smart_vellore_city.R;
import com.smart_vellore_city.Utils.Common;
import com.smart_vellore_city.Utils.GlideApp;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DoctorProfileActivity extends AppCompatActivity {
    @BindView(R.id.dp_toolbar) Toolbar dp_toolbar;
    @BindView(R.id.img_doc)ImageView img_doc;
    @BindView(R.id.img_call)ImageView img_call;
    @BindView(R.id.tv_ratings)TextView tv_ratings;
    @BindView(R.id.tv_doc_name)TextView tv_doc_name;
    @BindView(R.id.tv_doc_speciality)TextView tv_doc_speciality;
    @BindView(R.id.tv_doc_about)TextView tv_doc_about;
    @BindView(R.id.tv_doc_hos_name)TextView tv_doc_hos_name;
    @BindView(R.id.tv_doc_hos_address)TextView tv_doc_hos_address;
    @BindView(R.id.map_hospital)ImageView map_hospital;
    @BindView(R.id.tv_lang_known)TextView tv_lang_known;
    @BindView(R.id.tv_package)TextView tv_package;
    @BindView(R.id.tv_booknow)TextView tv_booknow;

    private static final String CALL_PHONE = Manifest.permission.CALL_PHONE;
    private static final int CALL_PERMISSION_REQUEST_CODE = 12346;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_profile);
        ButterKnife.bind(this);

        setSupportActionBar(dp_toolbar);
        getSupportActionBar().setTitle("Doctor Profile");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle data = getIntent().getExtras();
        DocBean docBean = (DocBean) data.getParcelable("doctor");

        GlideApp
                .with(this)
                .load(docBean.getDocImgUrl())
                .apply(new RequestOptions()
                        .placeholder(R.drawable.ic_doctor)
                        .fitCenter())
                .into(img_doc);

        tv_ratings.setText(docBean.getDocRating());
        tv_doc_name.setText(docBean.getDocName());
        tv_doc_speciality.setText(docBean.getDocSpeciality());
        tv_doc_about.setText(docBean.getDocGeneralIntro());
        tv_doc_hos_name.setText(docBean.getDocHospital());
        tv_doc_hos_address.setText(docBean.getDocAddress());
        tv_lang_known.setText(docBean.getDocKnownLanguages());
        tv_package.setText("₹ "+docBean.getDocPackage()+" / Per Session");

        tv_booknow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToBook = new Intent(DoctorProfileActivity.this,DoctorBookingActivity.class);
                moveToBook.putExtra("sessionamount",tv_package.getText().toString());
                startActivity(moveToBook);
            }
        });
        img_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Common.ISCALLPERMISSIONENABLED){
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:"+Common.USER_PHONE_NO));
                    startActivity(callIntent);
                }else{
                    getCallPermission();
                }
            }
        });
    }
    public void getCallPermission() {
        String[] permissions = {CALL_PHONE};
        if (ContextCompat.checkSelfPermission(getApplicationContext(), CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            Common.ISCALLPERMISSIONENABLED = true;

        } else {
            ActivityCompat.requestPermissions(this, permissions, CALL_PERMISSION_REQUEST_CODE);
        }
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case CALL_PERMISSION_REQUEST_CODE: {

                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

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
