package com.smart_vellore_city.agri.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.smart_vellore_city.agri.adapter.AgriAdapter;
import com.smart_vellore_city.agri.model.AgriPojo;
import com.smart_vellore_city.R;

import java.util.ArrayList;

/**
 * Created by Priyadharshini on 16-11-2018.
 */

public class AgriFragment extends Fragment {

    int currentPage = 0;
    RecyclerView recyclerview;
    ArrayList<AgriPojo> pojo = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_agri, container, false);

        currentPage = getArguments().getInt("current_page");

        dataList();
        initViews(v);

        return v;

    }

    public void initViews(View view) {
        recyclerview = (RecyclerView) view.findViewById(R.id.agri_rv);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerview.setLayoutManager(layoutManager);
        AgriAdapter adapter = new AgriAdapter(pojo, 0,getActivity());
        recyclerview.setAdapter(adapter);

    }

    public void dataList() {

        pojo.clear();

        if (currentPage == 1) {
            pojo.add(new AgriPojo("Flat Beans", "2 Kgs", "\u20B9 30","https://5.imimg.com/data5/IP/LC/MY-35436563/green-peas-500x500.jpg"));
            pojo.add(new AgriPojo("Garlic", "1 Kg", "\u20B9 90", "https://images-blogger-opensocial.googleusercontent.com/gadgets/proxy?url=http%3A%2F%2Fwww.industry.in.th%2Fuploadedimages%2Fknowledge%2Fimages%2Fkm44933_20150825234525_830518473_fullsize.jpg&container=blogger&gadget=a&rewriteMime=image%2F*"));
            pojo.add(new AgriPojo("Beetroot", "1 Kg", "\u20B9 40", "https://cdn0.woolworths.media/content/wowproductimages/medium/185267.jpg"));
            pojo.add(new AgriPojo("Carrot", "1 Kg", "\u20B9 50", "https://tgroenselof.be/wp-content/uploads/2018/09/t_Groenselof-Lokeren-groentebox-jonge-wortelen-db-300x300.png"));
            pojo.add(new AgriPojo("Tomato", "1 Kg", "\u20B9 35", "https://grist.files.wordpress.com/2009/09/tomato.jpg"));
        }
        if (currentPage == 2) {
            pojo.add(new AgriPojo("Robusta Banana", "1 Kg", "\u20B9 30", "https://5.imimg.com/data5/EX/QK/MY-37427162/selection_008-500x500.png"));
            pojo.add(new AgriPojo("Apple", "1 Kg", "\u20B9 110", "https://2.wlimg.com/product_images/bc-full/dir_149/4462477/red-apple-1487845013-2734392.jpeg"));
            pojo.add(new AgriPojo("Orange", "1 Kg", "\u20B9 70", "https://www.siciliaagrumi.it/wp-content/uploads/2018/06/arance-navel-sicilia_01.jpg"));
            pojo.add(new AgriPojo("Papaya", "1 Kg", "\u20B9 30","https://www.fruttaweb.com/8371-large_default/fresh-papaya-ready-to-eat.jpg"));
            pojo.add(new AgriPojo("Pineapple", "1 Kg", "\u20B9 40","http://cdn.nexternal.com/grow/images/pineapple2.jpg"));
        }
        if (currentPage == 3) {
            pojo.add(new AgriPojo("Rose", "1 Kg", "\u20B9 200","https://5.imimg.com/data5/AA/KK/MY-6677193/red-rose-500x500.jpg"));
            pojo.add(new AgriPojo("Malli", "1 Kg", "\u20B9 800","https://www.anushiaflower.com/wp-content/uploads/2017/07/Thailand-Jasmine-600x600.png"));
//            pojo.add(new AgriPojo("Crossandra", "1 Kg", "\u20B9 600", "https://mobileimages.lowes.com/product/converted/738553/738553006292.jpg"));
            pojo.add(new AgriPojo("Crossandra", "1 Kg", "\u20B9 600", "https://envato-shoebox-0.imgix.net/289a/35bc-9265-11e3-9d28-d4ae527ed1fc/Firecracker+flower1.jpg?auto=compress%2Cformat&fit=max&mark=https%3A%2F%2Felements-assets.envato.com%2Fstatic%2Fwatermark2.png&markalign=center%2Cmiddle&markalpha=18&w=700&s=67bc0d2262b6df7abb570b18d9d31dbd"));
            pojo.add(new AgriPojo("Marigold", "1 Kg", "\u20B9 80", "https://4.imimg.com/data4/IA/CC/MY-24569645/marigold-flower-500x500.jpg"));
            pojo.add(new AgriPojo("Tuberosa (Sampangi) ", "1 Kg", "\u20B9 30", "https://cdn.shopify.com/s/files/1/0859/3640/products/SN_Tuberose_1024x1024.jpg?v=1487287859"));
        }

    }
}
