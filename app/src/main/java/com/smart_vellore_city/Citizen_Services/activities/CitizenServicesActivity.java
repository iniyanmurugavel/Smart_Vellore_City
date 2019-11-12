package com.smart_vellore_city.Citizen_Services.activities;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.smart_vellore_city.Bills.BillFragment;
import com.smart_vellore_city.Citizen_Services.fragments.CitizenServiceFragment;
import com.smart_vellore_city.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CitizenServicesActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
@BindView(R.id.container)FrameLayout container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citizen_services);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_eservices);

        Fragment fragment = new BillFragment();
        Bundle arguments = new Bundle();
//            arguments.putString("url", "http://tnsta.gov.in/transport/");
//        arguments.putString("url", "https://www.netexpress.co.in/yellowpages/display-l-case/transport/tamil-nadu/vellore/12/display.aspx");
        fragment.setArguments(arguments);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
        getSupportActionBar().setTitle("Bill Payment");

//        Fragment fragment = new CitizenServiceFragment();
//        Bundle arguments = new Bundle();
//        arguments.putString("url", "http://eservices.tn.gov.in/eservicesnew/home.html");
//        fragment.setArguments(arguments);
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.container, fragment);
//        fragmentTransaction.commit();
//        getSupportActionBar().setTitle("E services - Land");
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.citizen_services, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_eservices) {
            Fragment fragment = new CitizenServiceFragment();
            Bundle arguments = new Bundle();
            arguments.putString("url", "http://eservices.tn.gov.in/eservicesnew/home.html");
            fragment.setArguments(arguments);
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();
            getSupportActionBar().setTitle("E services - Land");
        } else if (id == R.id.nav_applicationstatus) {
            Fragment fragment = new CitizenServiceFragment();
            Bundle arguments = new Bundle();
//            arguments.putString("url", "https://edistricts.tn.gov.in/revenue/status.html");
            arguments.putString("url", "https://tnvelaivaaippu.gov.in/Empower/");
            fragment.setArguments(arguments);
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();
            getSupportActionBar().setTitle("Application Status");
        } else if (id == R.id.nav_genuinenessofcertificates) {
            Fragment fragment = new CitizenServiceFragment();
            Bundle arguments = new Bundle();
//            arguments.putString("url", "https://edistricts.tn.gov.in/revenue/verifyCertificate.html");
            arguments.putString("url", "https://tnvelaivaaippu.gov.in/Empower/");
            fragment.setArguments(arguments);
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();
            getSupportActionBar().setTitle("Genuineness of Certificates");
        } else if (id == R.id.nav_pds) {
            Fragment fragment = new CitizenServiceFragment();
            Bundle arguments = new Bundle();
            arguments.putString("url", " https://tnpds.gov.in/home.xhtml");
            fragment.setArguments(arguments);
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();
            getSupportActionBar().setTitle("Public Distribution Systems");
        } else if (id == R.id.nav_election) {
            Fragment fragment = new CitizenServiceFragment();
            Bundle arguments = new Bundle();
            arguments.putString("url", "http://elections.tn.gov.in/");
            fragment.setArguments(arguments);
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();
            getSupportActionBar().setTitle("Online Election Services");
        } else if (id == R.id.nav_transport) {
            Fragment fragment = new BillFragment();
            Bundle arguments = new Bundle();
//            arguments.putString("url", "http://tnsta.gov.in/transport/");
            arguments.putString("url", "https://www.netexpress.co.in/yellowpages/display-l-case/transport/tamil-nadu/vellore/12/display.aspx");
            fragment.setArguments(arguments);
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();
            getSupportActionBar().setTitle("Bill Payment");
        } else if (id == R.id.nav_aadhar) {
            Fragment fragment = new CitizenServiceFragment();
            Bundle arguments = new Bundle();
            arguments.putString("url", "https://uidai.gov.in/");
            fragment.setArguments(arguments);
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();
            getSupportActionBar().setTitle("Aadhar Online Services");
        } else if (id == R.id.nav_employee) {
            Fragment fragment = new CitizenServiceFragment();
            Bundle arguments = new Bundle();
            arguments.putString("url", "https://tnvelaivaaippu.gov.in/Empower/");
            fragment.setArguments(arguments);
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();
            getSupportActionBar().setTitle("Employee Exchange Services");
        } else if (id == R.id.nav_electricity) {
            Fragment fragment = new CitizenServiceFragment();
            Bundle arguments = new Bundle();
            arguments.putString("url", "https://www.tnebnet.org/awp/login");
            fragment.setArguments(arguments);
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();
            getSupportActionBar().setTitle("Electricity Bill");
        }else if (id == R.id.nav_police) {
            Fragment fragment = new CitizenServiceFragment();
            Bundle arguments = new Bundle();
            arguments.putString("url", "http://www.tnpolice.gov.in/CCTNSNICSDC/");
            fragment.setArguments(arguments);
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();
            getSupportActionBar().setTitle("Police Portal");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
