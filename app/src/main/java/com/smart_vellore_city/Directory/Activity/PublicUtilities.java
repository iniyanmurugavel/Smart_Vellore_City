package com.smart_vellore_city.Directory.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.smart_vellore_city.Directory.Adapter.BloodBanksAdapter;
import com.smart_vellore_city.Directory.Adapter.CollegeUnivAdapter;
import com.smart_vellore_city.Directory.Adapter.HospitalAdapter;
import com.smart_vellore_city.Directory.Adapter.MunicipalityAdapter;
import com.smart_vellore_city.Directory.Adapter.PostOfficeAdapter;
import com.smart_vellore_city.Directory.Model.BloodBanks;
import com.smart_vellore_city.Directory.Model.CollegeUniv;
import com.smart_vellore_city.Directory.Model.Hospital;
import com.smart_vellore_city.Directory.Model.Municipalities;
import com.smart_vellore_city.Directory.Model.PostOffice;
import com.smart_vellore_city.R;

import java.util.ArrayList;

public class PublicUtilities extends AppCompatActivity {

    RecyclerView recyclerViewHospitals,recyclerViewBloodBanks,recyclerViewMunicipalities,
    recyclerViewTransportOff,recyclerViewRegistrarOff,recyclerViewCollUniv,recyclerViewPostOffices,
            recyclerViewNGOs;

    ArrayList arrayListHospitals,arrayListBloodBanks,arrayListMunicipalities,arrayListCollegeUniv,
    arrayListPostOffices;

    LinearLayout llHospitals,llBloodBank,llMunicipalities,llTransportOffices,llRegistratOff,
    llCollegeUniversity,llPostOffices,llNGOs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_public_utilities);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerViewHospitals = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerViewBloodBanks = (RecyclerView) findViewById(R.id.recyclerView_bloodbank);
        recyclerViewMunicipalities = (RecyclerView) findViewById(R.id.recyclerView_municipalities);
        recyclerViewTransportOff = (RecyclerView) findViewById(R.id.recyclerView_transport_off);
        recyclerViewRegistrarOff = (RecyclerView) findViewById(R.id.recyclerView_registrar_off);
        recyclerViewCollUniv = (RecyclerView) findViewById(R.id.recyclerView_coll_univ);
        recyclerViewPostOffices = (RecyclerView) findViewById(R.id.recyclerView_postoffices);
        recyclerViewNGOs = (RecyclerView) findViewById(R.id.recyclerView_ngos);

        llHospitals = (LinearLayout) findViewById(R.id.ll_hospitals);
        llBloodBank = (LinearLayout) findViewById(R.id.ll_bloodbank);
        llMunicipalities = (LinearLayout) findViewById(R.id.ll_municipalities);
        llTransportOffices = (LinearLayout) findViewById(R.id.ll_transport_off);
        llRegistratOff = (LinearLayout) findViewById(R.id.ll_registrar_off);
        llCollegeUniversity = (LinearLayout) findViewById(R.id.ll_coll_univ);
        llPostOffices = (LinearLayout) findViewById(R.id.ll_post_offices);
        llNGOs = (LinearLayout) findViewById(R.id.ll_ngos);

        arrayListHospitals = new ArrayList();
        arrayListBloodBanks = new ArrayList();
        arrayListMunicipalities = new ArrayList();
        arrayListCollegeUniv = new ArrayList();
        arrayListPostOffices = new ArrayList();

        Intent i = getIntent();

        String type = i.getStringExtra("Type");

        init(type);

    }

    public void init(String type){

        if (type.equalsIgnoreCase("Hospitals")){

            llHospitals.setVisibility(View.VISIBLE);
            llBloodBank.setVisibility(View.GONE);
            llMunicipalities.setVisibility(View.GONE);
            llTransportOffices.setVisibility(View.GONE);
            llRegistratOff.setVisibility(View.GONE);
            llCollegeUniversity.setVisibility(View.GONE);
            llPostOffices.setVisibility(View.GONE);
            llNGOs.setVisibility(View.GONE);

            getSupportActionBar().setTitle("Hospitals");

            arrayListHospitals.add(new Hospital("Government Head Quarters Hospital, Walaja",
                    "04172-232538","tnhspwalaja@gmail.com","632513","District Hospital"));

            arrayListHospitals.add(new Hospital("Government Hospital, Ambur",
                    "04174-242636","tnhspambur@gmail.com ","635802","Taluk Hospitals"));

            arrayListHospitals.add(new Hospital("Government Hospital, Kalavai",
                    "04173-242328","tnhspkalavai@gmail.com","632506","Taluk Hospitals"));

            arrayListHospitals.add(new Hospital("Government Hospital, Arakkonam",
                    "04177-232270","ttnhsparakkonam@gmail.com ","631001","Taluk Hospitals"));

            arrayListHospitals.add(new Hospital("Government Hospital, Arcot",
                    "04172-235120","tnhsparcot@gmail.com","632503","Taluk Hospitals"));

            arrayListHospitals.add(new Hospital("Government Hospital, Gudiyatham",
                    "04171-221111","tnhspgudiyatham@gmail.com","632602","Taluk Hospitals"));

            HospitalAdapter hospitalAdapter = new HospitalAdapter(this, arrayListHospitals);
            recyclerViewHospitals.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            recyclerViewHospitals.setAdapter(hospitalAdapter);

        }else if (type.equalsIgnoreCase("Blood Banks")){

            llHospitals.setVisibility(View.GONE);
            llBloodBank.setVisibility(View.VISIBLE);
            llMunicipalities.setVisibility(View.GONE);
            llTransportOffices.setVisibility(View.GONE);
            llRegistratOff.setVisibility(View.GONE);
            llCollegeUniversity.setVisibility(View.GONE);
            llPostOffices.setVisibility(View.GONE);
            llNGOs.setVisibility(View.GONE);

            getSupportActionBar().setTitle("Blood Banks");

            arrayListBloodBanks.add(new BloodBanks("Ambur Blood Bank","04174-246636",
                    "amburictc@gmail.com","635802","Blood Bank,Government Hospital,Nethaji Road"));

            arrayListBloodBanks.add(new BloodBanks("Arakkonam Blood Bank","04177-232270",
                    "gharakonam@gmail.com ","631001","Government Hospital,Gandhi Road, Arakkonam"));

            arrayListBloodBanks.add(new BloodBanks("Gudiyatham Blood Bank","04171-221111",
                    "ghgudiyatham@gmail.com","632602","Government Hospital, Gudiyatham"));

            arrayListBloodBanks.add(new BloodBanks("Thirupattur Blood Bank","04179-220080",
                    "ghthirupathur@gmail.com","635601","Government Hospital,Railway station Road, Thirupattur"));

            arrayListBloodBanks.add(new BloodBanks("Vaniyambadi Blood Bank","04174-225700",
                    "ghvaniyambadi@gmail.com","635751","Government Hospital,Vaniyambadi"));

            arrayListBloodBanks.add(new BloodBanks("Walaja Blood Bank","04172-232538",
                    "ghwalajah@gmail.com","632513","Government Head Quarters Hospital, Walaja"));

            BloodBanksAdapter bloodBanksAdapter = new BloodBanksAdapter(this, arrayListBloodBanks);
            recyclerViewBloodBanks.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            recyclerViewBloodBanks.setAdapter(bloodBanksAdapter);

        }else if (type.equalsIgnoreCase("Municipalities")){

            llHospitals.setVisibility(View.GONE);
            llBloodBank.setVisibility(View.GONE);
            llMunicipalities.setVisibility(View.VISIBLE);
            llTransportOffices.setVisibility(View.GONE);
            llRegistratOff.setVisibility(View.GONE);
            llCollegeUniversity.setVisibility(View.GONE);
            llPostOffices.setVisibility(View.GONE);
            llNGOs.setVisibility(View.GONE);

            getSupportActionBar().setTitle("Municipalities");


            arrayListMunicipalities.add(new Municipalities("Ambur Municipality","04174-242740",
                    "commr.ambur@tn.gov.in","635 802",
                    " Ambur Municipality, Ambur, Vellore District","http://123.63.242.116/ambur/"));

            arrayListMunicipalities.add(new Municipalities("Arakonam Municipality","04177-236236",
                    "commr.arakkonam@tn.gov.in","631003",
                    "110, Gandhi Road, Arakkonam, Arakonam Municipality, Vellore District",
                    "http://123.63.242.116/arakkonam/"));


            arrayListMunicipalities.add(new Municipalities("Arcot Municipality","04172-235708",
                    "commr.arcot@tn.gov.in","632503",
                    "No.5, Santhapettai street, Arcot, Vellore District.",
                    "http://123.63.242.116/arcot/"));

            arrayListMunicipalities.add(new Municipalities("Gudiyatham Municipality","04171-220051",
                    "commr.gudiyatham@tn.gov.in","632 602",
                    "No.1. R.S.Road, Gudiyatham,Gudiyatham Municipality, Vellore District",
                    "http://123.63.242.116/gudiyatham/"));

            arrayListMunicipalities.add(new Municipalities("Jolarpet Municipality","04179-241268",
                    "commr.jolarpet@tn.gov.in","635 851",
                    "131, Parthasarathy Street, Natrampalli Road,Jolarpet, Jolarpet Municipality, Vellore District",
                    "http://123.63.242.116/jolarpet/"));

            arrayListMunicipalities.add(new Municipalities("Melvisharam Municipality","04172-266049",
                    "commr.melvisharam@tn.gov.in","632 509",
                    "No.1, Railwaystation Road, Ranipet, Ranipet Municipality, Vellore District",
                    "http://123.63.242.116/melvisharam/"));

            MunicipalityAdapter municipalityAdapter = new MunicipalityAdapter(this, arrayListMunicipalities);
            recyclerViewMunicipalities.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            recyclerViewMunicipalities.setAdapter(municipalityAdapter);

        }else if (type.equalsIgnoreCase("Regional Transport Offices")){

            llHospitals.setVisibility(View.GONE);
            llBloodBank.setVisibility(View.GONE);
            llMunicipalities.setVisibility(View.GONE);
            llTransportOffices.setVisibility(View.VISIBLE);
            llRegistratOff.setVisibility(View.GONE);
            llCollegeUniversity.setVisibility(View.GONE);
            llPostOffices.setVisibility(View.GONE);
            llNGOs.setVisibility(View.GONE);

            getSupportActionBar().setTitle("Regional Transport Offices");

            arrayListBloodBanks.add(new BloodBanks("Regional Transport Office, Ranipet",
                    " 04172-273087","Rtotn73@nic.in","632401",
                    "Regional Transport office, National High Way-4, Bharathi Nagar, Ranipet"));

            arrayListBloodBanks.add(new BloodBanks("Regional Transport Office, Vaniyambadi",
                    "No number","Rtotn83@nic.in","635751",
                    "Thirpattur Salai, Opposite Jain Ladies College, Chinnavepampattu, Vaniyambadi"));

            arrayListBloodBanks.add(new BloodBanks("Regional Transport Office, Vellore",
                    "No number","Rtotn23@nic.in","632009",
                    "No 482, Phase II, TNHB Sathuvachari, Vellore"));

            arrayListBloodBanks.add(new BloodBanks("Unit Office, Ambur","04174-247615",
                    "Rtotn83y@nic.in","635802",
                    "No 78/1,M C Road, opposite to Oriental School, Ambur."));

            arrayListBloodBanks.add(new BloodBanks("Unit Office, Arakkonam"," 04177-236700",
                    "Rtotn73z@nic.in","631001",
                    "No.5/48-A, Vallalar Street,Jothi Nagar, Arakonam"));

            arrayListBloodBanks.add(new BloodBanks("Unit Office, Thirupathur","04179-227797",
                    "Rtotn83z@nic.in","635601",
                    "Unit Office, Mukundhan Nagar , Housing Board , Tirupattur."));

            BloodBanksAdapter bloodBanksAdapter = new BloodBanksAdapter(this, arrayListBloodBanks);
            recyclerViewTransportOff.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            recyclerViewTransportOff.setAdapter(bloodBanksAdapter);

        }else if (type.equalsIgnoreCase("Registrar Offices")){


            llHospitals.setVisibility(View.GONE);
            llBloodBank.setVisibility(View.GONE);
            llMunicipalities.setVisibility(View.GONE);
            llTransportOffices.setVisibility(View.GONE);
            llRegistratOff.setVisibility(View.VISIBLE);
            llCollegeUniversity.setVisibility(View.GONE);
            llPostOffices.setVisibility(View.GONE);
            llNGOs.setVisibility(View.GONE);

            getSupportActionBar().setTitle("Registrar Offices");

            arrayListBloodBanks.add(new BloodBanks("Sub Registrar Office, Ambur",
                    "04174-243640","sroambur@tnreginet.net","635802",
                    "Post office Road, 11, Railway Station Road"));

            arrayListBloodBanks.add(new BloodBanks("Sub Registrar Office, Gudiyatham",
                    "04171-227445","srokudiyatham@tnreginet.net ","632602",
                    "Taluk office campus, Gudiyatham"));

            arrayListBloodBanks.add(new BloodBanks("Sub Registrar Office, Jolarpettai",
                    "04179-243586","srojollarpettai@tnreginet.net","635 851",
                    "Nethaji Road, Sakkarakuppam, Jolarpet"));

            arrayListBloodBanks.add(new BloodBanks("Sub Registrar Office, Kaniyambadi","0416-2230035",
                    " sroKaniyampadi@tnreginet.net","632 102",
                    "60,Old Labbai street, Kaniyambadi."));

            arrayListBloodBanks.add(new BloodBanks("Sub Registrar Office, Katpadi","0416-2297005",
                    "srokatpadi@tnreginet.net","632 007",
                    "46, Vellore Road, Tharapadavedu Village, Katpadi."));

            arrayListBloodBanks.add(new BloodBanks("Sub Registrar Office, Natrampalli","04179-242345",
                    "sroNatrampalli@tnreginet.net","635 852",
                    "151/69 RCS Main Road, Sandai Pananthoppu, Natrampalli."));

            BloodBanksAdapter bloodBanksAdapter = new BloodBanksAdapter(this, arrayListBloodBanks);
            recyclerViewRegistrarOff.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            recyclerViewRegistrarOff.setAdapter(bloodBanksAdapter);

        }else if (type.equalsIgnoreCase("Colleges/Universities")){

            llHospitals.setVisibility(View.GONE);
            llBloodBank.setVisibility(View.GONE);
            llMunicipalities.setVisibility(View.GONE);
            llTransportOffices.setVisibility(View.GONE);
            llRegistratOff.setVisibility(View.GONE);
            llCollegeUniversity.setVisibility(View.VISIBLE);
            llPostOffices.setVisibility(View.GONE);
            llNGOs.setVisibility(View.GONE);

            getSupportActionBar().setTitle("Colleges/Universities");

            arrayListCollegeUniv.add(new CollegeUniv("Government College of Education, Vellore",
                    "0416-2249703","gtevlr@gmail.com","632 006",
                    "Government College of Education, Vellore.","GOVERNMENT COLLEGES"));

            arrayListCollegeUniv.add(new CollegeUniv("Auxilium College (Autonomous),Katpadi",
                    "0416-2241774","auxiliumcollege9@gmail.com","632 006",
                    "Gandhi Nagar, Katpadi, Vellore.","GOVERNMENT AIDED COLLEGE"));

            arrayListCollegeUniv.add(new CollegeUniv("C. Abdul Hakeem College , Melvisharam",
                    "04172-266487","hakeemcollege@rediffmail.com","632 509",
                    "Hakeem Nagar, Melvisharam Vellore District.","GOVERNMENT AIDED COLLEGE"));

            arrayListCollegeUniv.add(new CollegeUniv("D.K.M. College for Women (Autonomous), Sainathapuram",
                    "0416-2266051","nfo@dkmcollege.org","632 001",
                    "College Road ,Sainathapuram, Vellore.","GOVERNMENT AIDED COLLEGE"));

            arrayListCollegeUniv.add(new CollegeUniv("Sacred Heart College (Autonomous) Tirupattur",
                    "04179-220553","office@shctpt.edu","635 601",
                    "Tirupattur","GOVERNMENT AIDED COLLEGE"));

            arrayListCollegeUniv.add(new CollegeUniv("Islamiah College (Autonomous),Vaniyambadi",
                    "04174-235206","principal@islamiahcollege.edu.in","635 752",
                    "New Town, Vaniyambadi.","GOVERNMENT AIDED COLLEGE"));

            CollegeUnivAdapter collegeUnivAdapter = new CollegeUnivAdapter(this, arrayListCollegeUniv);
            recyclerViewCollUniv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            recyclerViewCollUniv.setAdapter(collegeUnivAdapter);

        }else if (type.equalsIgnoreCase("Post Offices")){

            llHospitals.setVisibility(View.GONE);
            llBloodBank.setVisibility(View.GONE);
            llMunicipalities.setVisibility(View.GONE);
            llTransportOffices.setVisibility(View.GONE);
            llRegistratOff.setVisibility(View.GONE);
            llCollegeUniversity.setVisibility(View.GONE);
            llPostOffices.setVisibility(View.VISIBLE);
            llNGOs.setVisibility(View.GONE);

            getSupportActionBar().setTitle("Post Offices");

            arrayListPostOffices.add(new PostOffice("Arakkonam H.O","Arakkonam taluk of Vellore district",
                    "631001","04177230520"));

            arrayListPostOffices.add(new PostOffice("Gudiyattam H.O","Head Post Office, Gudiyattam.",
                    "632602","9443685733"));

            arrayListPostOffices.add(new PostOffice("Ranipet H.O","Head Post Office , Ranipet.",
                    "632401","04172272244"));

            arrayListPostOffices.add(new PostOffice("Tirupattur H.O","Head Post Office, Vellore district.",
                    "635601","9442191346"));

            arrayListPostOffices.add(new PostOffice("Vellore H.O","Head Post Office, Vellore district.",
                    "632001","04162223908"));

            PostOfficeAdapter postOfficeAdapter = new PostOfficeAdapter(this, arrayListPostOffices);
            recyclerViewPostOffices.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            recyclerViewPostOffices.setAdapter(postOfficeAdapter);

        }else if (type.equalsIgnoreCase("NGOs")){

            llHospitals.setVisibility(View.GONE);
            llBloodBank.setVisibility(View.GONE);
            llMunicipalities.setVisibility(View.GONE);
            llTransportOffices.setVisibility(View.GONE);
            llRegistratOff.setVisibility(View.GONE);
            llCollegeUniversity.setVisibility(View.GONE);
            llPostOffices.setVisibility(View.GONE);
            llNGOs.setVisibility(View.VISIBLE);

            getSupportActionBar().setTitle("NGOs");

            arrayListBloodBanks.add(new BloodBanks("Indian Red Cross Society","9443320955",
                    "ircsvlr@gmail.com","632001",
                    "Anna Salai, (Near Old Bus Stand),Vellore."));

            arrayListBloodBanks.add(new BloodBanks("Organisation for Rural Development",
                    "9443627238",
                    "ord_vellore@yahoo.com","632055",
                    "1/272, Golden Temple Road, Ariyur Post. Vellore."));

            arrayListBloodBanks.add(new BloodBanks("Saranalayam Trust, Karunai illam","9443293689",
                    "berakha@yahoo.com","635751",
                    "124/J4 Alangayam Cross Road, Perumalept, Vaniyambadi."));

            arrayListBloodBanks.add(new BloodBanks("Society for Rural Development Promotion Services (SRDPS)",
                    "9443437647",
                    "srdps@hotmail.com","635602",
                    "437, Pasumai Nagar, (Near Pachal Railway Gate),Pachal Post."));

            arrayListBloodBanks.add(new BloodBanks("Premnikathan (Home for Cancer Affected People)",
                    "9600023629",
                    "premavasam1999@gmail.com","631001",
                    "Arkilapadi, Arakkonam, Vellore."));

            arrayListBloodBanks.add(new BloodBanks("Mudhiyor Balar Kudumba Grama Pannai","9843462100",
                    "mbkpdirector@gmail.com","632007",
                    "Kasam,Katpadi, Vellore."));

            BloodBanksAdapter bloodBanksAdapter = new BloodBanksAdapter(this, arrayListBloodBanks);
            recyclerViewNGOs.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            recyclerViewNGOs.setAdapter(bloodBanksAdapter);


        }
    }
}
