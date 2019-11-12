package com.smart_vellore_city.Registration.fragments;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.smart_vellore_city.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Registration extends Fragment {
    @BindView(R.id.btn_sentOtp)Button btn_sentOtp;
    @BindView(R.id.et_mobileNo)EditText et_mobileNo;
    @BindView(R.id.et_username)EditText et_username;
    @BindView(R.id.li_parent_lay)LinearLayout li_parent_lay;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registration,container,false);
        ButterKnife.bind(this,view);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getActivity().getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.WHITE);
        }
        btn_sentOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!et_username.getText().toString().isEmpty()){
                    if(!et_mobileNo.getText().toString().isEmpty() && et_mobileNo.getText().toString().length() == 10){
                        Fragment fragment = new OtpFragment();
                        Bundle arguments = new Bundle();
                        arguments.putString("number", et_mobileNo.getText().toString());
                        arguments.putString("name", et_username.getText().toString());
                        fragment.setArguments(arguments);
                        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.container, fragment);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                    }else{
                        Snackbar.make(li_parent_lay,"Please Enter Valid Mobile Number!",Snackbar.LENGTH_SHORT).show();
                    }
                }else{
                    Snackbar.make(li_parent_lay,"Please Enter UserName!",Snackbar.LENGTH_SHORT).show();
                }


            }
        });
        return view;
    }

}
