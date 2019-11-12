package com.smart_vellore_city.Emergency_Services.appoinments;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.smart_vellore_city.Emergency_Services.appoinments.activity.DoctorListActivity;
import com.smart_vellore_city.Emergency_Services.appoinments.adapters.SpecialityRecyclerAdapter;
import com.smart_vellore_city.Emergency_Services.appoinments.contracts.SpecialityContract;
import com.smart_vellore_city.Emergency_Services.appoinments.presenters.SpecialityPresenter;
import com.smart_vellore_city.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityAppoinment extends AppCompatActivity implements SpecialityContract.view,SpecialityRecyclerAdapter.GetItemCallback {
@BindView(R.id.et_age)EditText et_age;
@BindView(R.id.et_healthConcernContent)EditText et_healthConcernContent;

@BindView(R.id.im_male)ImageView im_male;
@BindView(R.id.im_women)ImageView im_women;

@BindView(R.id.tv_selectSpeciality)TextView tv_selectSpeciality;
@BindView(R.id.tv_male)TextView tv_male;
@BindView(R.id.tv_women)TextView tv_women;
@BindView(R.id.tv_myself)TextView tv_myself;
@BindView(R.id.tv_father)TextView tv_father;
@BindView(R.id.tv_mother)TextView tv_mother;
@BindView(R.id.tv_husband)TextView tv_husband;
@BindView(R.id.tv_daughter)TextView tv_daughter;
@BindView(R.id.tv_others)TextView tv_others;

@BindView(R.id.li_myself)LinearLayout li_myself;
@BindView(R.id.li_father)LinearLayout li_father;
@BindView(R.id.li_mother)LinearLayout li_mother;
@BindView(R.id.li_husband)LinearLayout li_husband;
@BindView(R.id.li_daughter)LinearLayout li_daughter;
@BindView(R.id.li_others)LinearLayout li_others;

@BindView(R.id.btn_submit)Button btn_submit;

SpecialityPresenter specialityPresenter;
RecyclerView rv_speciality;
android.support.v7.app.AlertDialog dialog;

String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appoinment);
        ButterKnife.bind(this);
        getSupportActionBar().setTitle("Appointment");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        specialityPresenter = new SpecialityPresenter(this);
        clickFunctions();

    }

    private void clickFunctions() {
        im_male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                im_male.setImageResource(R.drawable.ic_selected_man);
                tv_male.setTextColor(getResources().getColor(R.color.colorPrimary));
                im_women.setImageResource(R.drawable.ic_woman);
                tv_women.setTextColor(getResources().getColor(R.color.textColor_normal));
                gender = "Male";
            }
        });
        im_women.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                im_male.setImageResource(R.drawable.ic_unselected_man);
                tv_male.setTextColor(getResources().getColor(R.color.textColor_normal));
                im_women.setImageResource(R.drawable.ic_selected_woman);
                tv_women.setTextColor(getResources().getColor(R.color.colorPrimary));
                gender = "Female";
            }
        });
        li_myself.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                li_myself.setBackground(getResources().getDrawable(R.drawable.selected_item_background));
                li_father.setBackground(getResources().getDrawable(R.drawable.nonselected_item_background));
                li_mother.setBackground(getResources().getDrawable(R.drawable.nonselected_item_background));
                li_husband.setBackground(getResources().getDrawable(R.drawable.nonselected_item_background));
                li_daughter.setBackground(getResources().getDrawable(R.drawable.nonselected_item_background));
                li_others.setBackground(getResources().getDrawable(R.drawable.nonselected_item_background));

                tv_myself.setTextColor(getResources().getColor(R.color.colorPrimary));
                tv_father.setTextColor(getResources().getColor(R.color.textColor_normal));
                tv_mother.setTextColor(getResources().getColor(R.color.textColor_normal));
                tv_husband.setTextColor(getResources().getColor(R.color.textColor_normal));
                tv_daughter.setTextColor(getResources().getColor(R.color.textColor_normal));
                tv_others.setTextColor(getResources().getColor(R.color.textColor_normal));
            }
        });
        li_father.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                li_father.setBackground(getResources().getDrawable(R.drawable.selected_item_background));
                li_myself.setBackground(getResources().getDrawable(R.drawable.nonselected_item_background));
                li_mother.setBackground(getResources().getDrawable(R.drawable.nonselected_item_background));
                li_husband.setBackground(getResources().getDrawable(R.drawable.nonselected_item_background));
                li_daughter.setBackground(getResources().getDrawable(R.drawable.nonselected_item_background));
                li_others.setBackground(getResources().getDrawable(R.drawable.nonselected_item_background));

                tv_father.setTextColor(getResources().getColor(R.color.colorPrimary));
                tv_myself.setTextColor(getResources().getColor(R.color.textColor_normal));
                tv_mother.setTextColor(getResources().getColor(R.color.textColor_normal));
                tv_husband.setTextColor(getResources().getColor(R.color.textColor_normal));
                tv_daughter.setTextColor(getResources().getColor(R.color.textColor_normal));
                tv_others.setTextColor(getResources().getColor(R.color.textColor_normal));
            }
        });
        li_mother.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                li_mother.setBackground(getResources().getDrawable(R.drawable.selected_item_background));

                li_myself.setBackground(getResources().getDrawable(R.drawable.nonselected_item_background));
                li_father.setBackground(getResources().getDrawable(R.drawable.nonselected_item_background));
                li_husband.setBackground(getResources().getDrawable(R.drawable.nonselected_item_background));
                li_daughter.setBackground(getResources().getDrawable(R.drawable.nonselected_item_background));
                li_others.setBackground(getResources().getDrawable(R.drawable.nonselected_item_background));

                tv_mother.setTextColor(getResources().getColor(R.color.colorPrimary));
                tv_myself.setTextColor(getResources().getColor(R.color.textColor_normal));
                tv_father.setTextColor(getResources().getColor(R.color.textColor_normal));
                tv_husband.setTextColor(getResources().getColor(R.color.textColor_normal));
                tv_daughter.setTextColor(getResources().getColor(R.color.textColor_normal));
                tv_others.setTextColor(getResources().getColor(R.color.textColor_normal));
            }
        });
        li_husband.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                li_husband.setBackground(getResources().getDrawable(R.drawable.selected_item_background));

                li_myself.setBackground(getResources().getDrawable(R.drawable.nonselected_item_background));
                li_father.setBackground(getResources().getDrawable(R.drawable.nonselected_item_background));
                li_mother.setBackground(getResources().getDrawable(R.drawable.nonselected_item_background));
                li_daughter.setBackground(getResources().getDrawable(R.drawable.nonselected_item_background));
                li_others.setBackground(getResources().getDrawable(R.drawable.nonselected_item_background));

                tv_husband.setTextColor(getResources().getColor(R.color.colorPrimary));

                tv_myself.setTextColor(getResources().getColor(R.color.textColor_normal));
                tv_father.setTextColor(getResources().getColor(R.color.textColor_normal));
                tv_mother.setTextColor(getResources().getColor(R.color.textColor_normal));
                tv_daughter.setTextColor(getResources().getColor(R.color.textColor_normal));
                tv_others.setTextColor(getResources().getColor(R.color.textColor_normal));
            }
        });
        li_daughter.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                li_daughter.setBackground(getResources().getDrawable(R.drawable.selected_item_background));

                li_myself.setBackground(getResources().getDrawable(R.drawable.nonselected_item_background));
                li_father.setBackground(getResources().getDrawable(R.drawable.nonselected_item_background));
                li_mother.setBackground(getResources().getDrawable(R.drawable.nonselected_item_background));
                li_husband.setBackground(getResources().getDrawable(R.drawable.nonselected_item_background));
                li_others.setBackground(getResources().getDrawable(R.drawable.nonselected_item_background));

                tv_daughter.setTextColor(getResources().getColor(R.color.colorPrimary));

                tv_myself.setTextColor(getResources().getColor(R.color.textColor_normal));
                tv_father.setTextColor(getResources().getColor(R.color.textColor_normal));
                tv_mother.setTextColor(getResources().getColor(R.color.textColor_normal));
                tv_husband.setTextColor(getResources().getColor(R.color.textColor_normal));
                tv_others.setTextColor(getResources().getColor(R.color.textColor_normal));
            }
        });
        li_others.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                li_others.setBackground(getResources().getDrawable(R.drawable.selected_item_background));

                li_myself.setBackground(getResources().getDrawable(R.drawable.nonselected_item_background));
                li_father.setBackground(getResources().getDrawable(R.drawable.nonselected_item_background));
                li_mother.setBackground(getResources().getDrawable(R.drawable.nonselected_item_background));
                li_husband.setBackground(getResources().getDrawable(R.drawable.nonselected_item_background));
                li_daughter.setBackground(getResources().getDrawable(R.drawable.nonselected_item_background));

                tv_others.setTextColor(getResources().getColor(R.color.colorPrimary));

                tv_myself.setTextColor(getResources().getColor(R.color.textColor_normal));
                tv_father.setTextColor(getResources().getColor(R.color.textColor_normal));
                tv_mother.setTextColor(getResources().getColor(R.color.textColor_normal));
                tv_husband.setTextColor(getResources().getColor(R.color.textColor_normal));
                tv_daughter.setTextColor(getResources().getColor(R.color.textColor_normal));
            }
        });
        tv_selectSpeciality.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!TextUtils.isEmpty(et_age.getText().toString()) && !et_age.getText().toString().equalsIgnoreCase("e.g : 24")){
                    if(gender!=null){
                        if(!et_healthConcernContent.getText().toString().isEmpty()){
                            Intent moveToDoctorActivity = new Intent(ActivityAppoinment.this,DoctorListActivity.class);
                            startActivity(moveToDoctorActivity);
                            finish();
                        }else{
                            Toast.makeText(ActivityAppoinment.this, "Please Enter health concern!", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(ActivityAppoinment.this, "Please choose the gender!", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(ActivityAppoinment.this, "Please enter the age!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void showDialog(){
        final android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(this);

        LayoutInflater li = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        final View dview = li.inflate(R.layout.activity_speciality, null);
        rv_speciality = (RecyclerView) dview.findViewById(R.id.rv_speciality);
        rv_speciality.setLayoutManager(new LinearLayoutManager(this));
        specialityPresenter.getSpecialityDatas();
        builder.setView(dview);
        dialog = builder.create();
        dialog.show();
        dialog.setCancelable(false);

    }

    @Override
    public void loadSpecialityDatas(List<String> specialityItems) {

        SpecialityRecyclerAdapter specialityRecyclerAdapter = new SpecialityRecyclerAdapter(this,specialityItems,this);
        rv_speciality.setAdapter(specialityRecyclerAdapter);
    }

    @Override
    public void getItemValues(String item) {
        tv_selectSpeciality.setText(item);
        tv_selectSpeciality.setTextColor(getResources().getColor(R.color.colorPrimary));
        dialog.dismiss();
    }
}
