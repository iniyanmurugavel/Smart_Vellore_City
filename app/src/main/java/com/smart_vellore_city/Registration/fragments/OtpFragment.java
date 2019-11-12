package com.smart_vellore_city.Registration.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.alahammad.otp_view.OTPListener;
import com.alahammad.otp_view.OtpView;
import com.sdsmdg.tastytoast.TastyToast;
import com.smart_vellore_city.R;
import com.smart_vellore_city.Utils.Common;
import com.smart_vellore_city.dashboard.NewDashBoard;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OtpFragment extends Fragment implements  OTPListener{
    String mobileNumber,userName;
    @BindView(R.id.otp) OtpView otpView;
    @BindView(R.id.toolbar_otp)Toolbar toolbar_otp;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_otp,container,false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getActivity().getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }
        ButterKnife.bind(this,view);
        mobileNumber = getArguments().getString("number");
        userName = getArguments().getString("name");
        otpView.setOnOtpFinished(this);
        return view;
    }

    @Override
    public void otpFinished(String s) {
        TastyToast.makeText(getActivity(), "Verified Successfully!!", TastyToast.LENGTH_LONG, TastyToast.SUCCESS);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(Common.USER_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("userName",userName);
        editor.putString("userMobileNo",mobileNumber);
        editor.commit();

        Intent moveToHomeActivity = new Intent(getActivity(),NewDashBoard.class);
        startActivity(moveToHomeActivity);
        getActivity().finish();
    }
}
