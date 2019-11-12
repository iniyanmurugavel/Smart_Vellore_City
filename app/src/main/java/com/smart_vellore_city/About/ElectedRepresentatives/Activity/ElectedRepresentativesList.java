package com.smart_vellore_city.About.ElectedRepresentatives.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.smart_vellore_city.About.ElectedRepresentatives.Model.ElectedRep_Model;
import com.smart_vellore_city.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ElectedRepresentativesList extends AppCompatActivity {

    private Fragment mlaFragment,mpFragment;
    private String[] mlaNames = {"Thiru.A. Nallathambi","Thiru. K.C. Veeramani","Dr. Nilofer Kafeel","Thiru. G. Loganathan",
                             "Thiru. A.P. Nanthakumar","Thiru. P. Karthikeyan","Thiru. J.L. Eswarappan"};
    private String[] mlaConstituency = {"Tirupattur","Jolerpet","Vaniyambadi","Anaikattu","Vellore","Arcot","Ranipet"};
    private String[] mlaPartyName = {"DMK","AIADMK","AIADMK","AIADMK","DMK","DMK","DMK"};

    private String[] mpNames = {"Thiru. G. Hari","Thiru. B. Senguttuvan","Tmt. R. Vanaroja"};
    private String[] mpConstituency = {"Arakkonam","Vellore","Tiruvannamalai"};
    private String[] mpPartyName = {"AIADMK","AIADMK","AIADMK"};
    private List<ElectedRep_Model> mlaList = new ArrayList<>();
    private List<ElectedRep_Model> mpList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_home);

        Toolbar toolbar = findViewById(R.id.htab_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Elected Representatives");

        ImageView imageView = (ImageView) findViewById(R.id.htab_header);
        imageView.setImageResource(R.drawable.erlist);
        setupTabLayout();
    }

    public void setupTabLayout(){
        mlaFragment = new MLA_Fragment(getMLAList());//MLA data
        mpFragment = new MLA_Fragment(getMPList());//MP data
        replaceFragment(mlaFragment);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.htab_tabs);
        tabLayout.addTab(tabLayout.newTab().setText("MLA List"),true);
        tabLayout.addTab(tabLayout.newTab().setText("MP List"));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                setCurrentTabFragment(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setCurrentTabFragment(int tabPosition)
    {
        switch (tabPosition)
        {
            case 0 :
                replaceFragment(mlaFragment);
                break;
            case 1 :
                replaceFragment(mpFragment);
                break;

        }
    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragmentContainer, fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }
    public List<ElectedRep_Model> getMLAList(){
        mlaList.clear();
        for(int i=0;i<mlaNames.length;i++){
            mlaList.add(new ElectedRep_Model(mlaConstituency[i],mlaNames[i],mlaPartyName[i]));
        }
        return mlaList;
    }
    public List<ElectedRep_Model> getMPList(){
        mpList.clear();
        for (int i=0;i<mpNames.length;i++){
            mpList.add(new ElectedRep_Model(mpConstituency[i],mpNames[i],mpPartyName[i]));
        }
        return mpList;
    }
}
