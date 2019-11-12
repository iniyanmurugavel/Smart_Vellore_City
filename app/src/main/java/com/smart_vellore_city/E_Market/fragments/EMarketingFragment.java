package com.smart_vellore_city.E_Market.fragments;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.smart_vellore_city.E_Market.model.EMarketPojo;
import com.smart_vellore_city.R;
import com.smart_vellore_city.Tourism.interfaces.RecyclerClickListener;
import com.smart_vellore_city.agri.adapter.AgriAdapter;

import java.util.ArrayList;

/**
 * Created by Priyadharshini on 17-11-2018.
 */

public class EMarketingFragment extends Fragment implements RecyclerClickListener {

    int currentPage;
    RecyclerView recyclerview;
    ArrayList<EMarketPojo> pojo = new ArrayList<>();
    AlertDialog dialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_agri, container, false);

        currentPage = getArguments().getInt("CurrentPage");

        dataList();
        initViews(v);

        return v;

    }

    public void initViews(View view) {
        recyclerview = (RecyclerView) view.findViewById(R.id.agri_rv);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerview.setLayoutManager(layoutManager);
        AgriAdapter adapter = new AgriAdapter(pojo, getActivity(), 1, this);
        recyclerview.setAdapter(adapter);

    }

    public void dataList() {

        pojo.clear();

        if (currentPage == 1) {
            pojo.add(new EMarketPojo("Sree Meenakshi Fruits",
                    "Address: No.36, Katpadi Road, Next to Shanthi Bakery, Katpadi Rd, Thottapalayam," +
                            " Vellore, Tamil Nadu 632004", "0416 420 0764", "4.2"));
            pojo.add(new EMarketPojo("Fresh Market",
                    "Address: 190, Double Road, Phase III, Sathuvachari, Vellore, Tamil Nadu 632009"
                    , "073734 85757", "4.4"));
            pojo.add(new EMarketPojo("Village Fresh",
                    "Address:  No 94, DVS Complex, Double Road, Phase III, Tamil Nadu Housing Board, Vellore, Tamil Nadu 632009",
                    "094890 79205", "4.2"));
            pojo.add(new EMarketPojo("Mkv Veg Shop",
                    "Address: 57 chennai salai, VIT Main Rd, Old Katpadi, Katpadi, Tamil Nadu 632006",
                    "072995 85748", "3.3"));
            pojo.add(new EMarketPojo("vasu shop",
                    "Address: 11, Pillaiyar Koil St, Phase III, Sathuvachari, Vellore, Tamil Nadu 632009",
                    "098423 40204", "4.0"));

        } else if (currentPage == 2) {
            pojo.add(new EMarketPojo("Nikis Natural Fresh",
                    "Address: Bharathi Nagar, Sathuvachari, Vellore, Tamil Nadu 632009",
                    "098949 53840", "4.2"));
            pojo.add(new EMarketPojo("MS FRUIT SHOP",
                    "Address: NH75, Thottapalayam, Vellore, Tamil Nadu 632012"
                    , "073734 85757", "4.4"));
            pojo.add(new EMarketPojo("Pazhamudir Cholai",
                    "Address: 8Th East Main Road, Gandhi Nagar, Vellore, Tamil Nadu 632006",
                    "098949 32437", "4.8"));
            pojo.add(new EMarketPojo("Mango Mundy",
                    "Address: Bangalore Road, Mango Market, Shenbakkam, Modur, Tamil Nadu 632008\n",
                    "072995 85748", "4.3"));

        } else if (currentPage == 3) {
            pojo.add(new EMarketPojo("New Fish Market",
                    "Address:  Kansalpet 2, Thottapalayam, Vellore, Tamil Nadu 632004",
                    "098949 53840", "4.3"));
            pojo.add(new EMarketPojo("P.K Aboo & Sons Fish Shop",
                    "Address: No.354, Main Bazaar Rd, Sripuram, Saidapet, Vellore, Tamil Nadu 632012"
                    , "098941 17060", "4.4"));
            pojo.add(new EMarketPojo("Dolphins Aquarium & Pet Shop",
                    "Address: 46/A, 7th East Main Rd, Next to Don Bosco, Gandhi Nagar, Vellore, Tamil Nadu 632006",
                    "098949 32437", "4.0"));
            pojo.add(new EMarketPojo("P.ABDU BROTHERS FISH MARKET VELLORE",
                    "Address: 57, Arcot Rd, Suthanthira Ponvizha Nagar, Sathuvachari, Vellore, Tamil Nadu 632009",
                    "094433 35786", "4.7"));

        } else if (currentPage == 4) {
            pojo.add(new EMarketPojo("SUN MEDICAL SHOP",
                    "Address: 78, Sripuram Main Road, Periya Allapuram, Vellore, 632002",
                    "98655 53840", "4.7"));
            pojo.add(new EMarketPojo("VASAN MEDICAL HALL",
                    "Address: OPP CMC MAIN GATE, IDA Scudder Rd, Thottapalayam, Vellore, Tamil Nadu 632004"
                    , "0445 17060", "4.4"));
            pojo.add(new EMarketPojo("Vellore Medical",
                    "Address: No. 1, Opposite Sri Arya Bhavan Coffee Shop, Thennamara St, Vellore, Tamil Nadu 632001", "098949 32437", "4.0"));
            pojo.add(new EMarketPojo("A.L.NATHAN MEDICAL SHOP",
                    "Address: No.5, Shop No.3&4 Pudhu Street, Kaghitha Pattarai, Vellore, Tamil Nadu 632012",
                    "094433 35786", "4.7"));

        } else if (currentPage == 5) {
            pojo.add(new EMarketPojo("Sha Automobiles",
                    "Address: Shop No. 36, Arani Road, Vellore, Tamil Nadu 632001",
                    "098416 37127", "4.4"));
            pojo.add(new EMarketPojo("Reliance General Insurance Company Limited",
                    "Address: New Bye-Pass Road, 141/373, M.P Sarathi Nagar, Next to Volkswagen Showroom, Vellore, Tamil Nadu 632012"
                    , "1800 3009", "4.4"));
            pojo.add(new EMarketPojo("Inergy automotive system India (P) Ltd.,",
                    "Address: Phase III, Mukundarayapuram Village, TN India", "9895554544", "3.3"));
            pojo.add(new EMarketPojo("Worth Industries",
                    "Address: B4-B6. Industrial Colony, 632006., Gandhi Nagar, Vellore, Tamil Nadu 632006",
                    "0416 224 4975", "4.2"));

        } else if (currentPage == 6) {
            pojo.add(new EMarketPojo("Grace Flowersflowers & cake Delivery in Vellore",
                    "Address: #4, SLN Plazza, 1st East Main Road, Katpadi, Gandhi Nagar, Vellore, Tamil Nadu 632006",
                    "090256 68877", "4.1"));
            pojo.add(new EMarketPojo("S Dhakshnamoorthy Flower Decorators",
                    "Address: J-6, Nethaji Market, Inside Manikoondu, Vellore, Tamil Nadu 632004",
                    " 098940 17920", "3.3"));
            pojo.add(new EMarketPojo("Aniy Kali Flowers",
                    "Address: 54, Battai, Battai, Vellore, Tamil Nadu 632001", "9895554544", "4.0"));
            pojo.add(new EMarketPojo("SK Flower Shop",
                    "Address: Long Bazzar, Balaji Nagar, Vellore, Tamil Nadu 632004",
                    "098402 29702", "4.2"));

        } else if (currentPage == 8) {
            pojo.add(new EMarketPojo("Vellore Electronics",
                    "Address: Commission Bazaar, Vellore, Tamil Nadu 632001",
                    "094434 30205", "4.4"));
            pojo.add(new EMarketPojo("Module 143",
                    "Address: VIT Main Rd, Vaibhav Nagar, Katpadi, Vellore, Tamil Nadu 632014",
                    "086101 88054", "3.3"));
            pojo.add(new EMarketPojo("Venson Electronics",
                    "Address: no 51, 2nd floor, M.P. Sarathy Mansions, Balaji Nagar, Vellore, Tamil Nadu 632004",
                    "095786 08558", "4.6"));
            pojo.add(new EMarketPojo("Ganesh Radio House",
                    "Address: NH 234, Balaji Nagar, Vellore, Tamil Nadu 632004",
                    "096004 78474", "4.0"));

        } else if (currentPage == 7) {
            pojo.add(new EMarketPojo("AGR Organic Fertilizers",
                    "Address: Arcot Rd, Phase 2, Kagithapatarai, Vellore, Tamil Nadu 632012",
                    "090256 68877", "4.2"));

        }


    }

    @Override
    public void onItemClick() {
        alertConfirmation();
    }

    public void alertConfirmation() {


        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());

        LayoutInflater inflater = getLayoutInflater();

        View v = inflater.inflate(R.layout.alert_emarketing_purchase, null);

        Button alert_btn_submit = (Button) v.findViewById(R.id.alert_btn_submit);
        ImageView iv_close = (ImageView) v.findViewById(R.id.iv_close);


        iv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        alert_btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Order has been Placed", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        builder.setView(v);
        dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.show();

    }

}
