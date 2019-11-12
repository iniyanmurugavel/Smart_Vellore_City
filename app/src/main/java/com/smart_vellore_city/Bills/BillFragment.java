package com.smart_vellore_city.Bills;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smart_vellore_city.Adapter.RecyclerViewAdapter;
import com.smart_vellore_city.Home_Services.Model.DataModel;
import com.smart_vellore_city.R;

import java.util.ArrayList;

import butterknife.ButterKnife;

public class BillFragment extends Fragment implements RecyclerViewAdapter.ItemListener{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_bills,container,false);
        ButterKnife.bind(this,view);

        RecyclerView recyclerView =  view.findViewById(R.id.recyclerView);

        ArrayList arrayList = new ArrayList();
        arrayList.add(new DataModel("Electicity Bill", R.drawable.ic_electricity, "#09A9FF"));
        arrayList.add(new DataModel("Gas Bill", R.drawable.ic_gas, "#3E51B1"));
        arrayList.add(new DataModel("Water Bill", R.drawable.ic_water_bill, "#673BB7"));
        arrayList.add(new DataModel("Internet Bill", R.drawable.ic_internet_bill, "#4BAA50"));
        arrayList.add(new DataModel("Landline Bill", R.drawable.ic_phone_bill, "#F94336"));

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(requireActivity(), arrayList, this);
        recyclerView.setAdapter(adapter);

        GridLayoutManager manager = new GridLayoutManager(requireActivity(), 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);

        return view;
    }

    @Override
    public void onItemClick(DataModel item) {

        if (item.text.equalsIgnoreCase("Electicity Bill")){

            Intent i = new Intent(requireActivity(),EBBill.class);
            startActivity(i);

        }else if (item.text.equalsIgnoreCase("Gas Bill")){

            Intent i = new Intent(requireActivity(),GasBill.class);
            startActivity(i);

        }else if (item.text.equalsIgnoreCase("Water Bill")){

            Intent i = new Intent(requireActivity(),WaterBill.class);
            startActivity(i);

        }else if (item.text.equalsIgnoreCase("Internet Bill")){

            Intent i = new Intent(requireActivity(),Internet.class);
            startActivity(i);

        }else if (item.text.equalsIgnoreCase("Landline Bill")){

            Intent i = new Intent(requireActivity(),Landline.class);
            startActivity(i);
        }


    }
}

