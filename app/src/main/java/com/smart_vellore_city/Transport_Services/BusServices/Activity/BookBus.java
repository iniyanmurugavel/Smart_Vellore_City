package com.smart_vellore_city.Transport_Services.BusServices.Activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.smart_vellore_city.R;
import com.smart_vellore_city.Transport_Services.BusServices.Model.Item;

import java.util.ArrayList;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class BookBus extends AppCompatActivity implements AdapterView.OnItemClickListener,View.OnClickListener{
    GridView gridView;
    ArrayList<Item> gridArray = new ArrayList<Item>();
    CustomGridViewAdapter customGridAdapter;
    public Bitmap seatIcon;
    public Bitmap seatSelect;
    TextView seatNumbers,amount;
    ArrayList<Integer> selectedSeatNumbers = new ArrayList<>();
    int amountPay = 0;
    Button btn_book;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookbus);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Select Seats");

        // set grid view item
        seatIcon = getBitmapFromVectorDrawable(this, R.drawable.ic_seat_available);
        seatSelect = getBitmapFromVectorDrawable(this, R.drawable.ic_seat_selected);
        totalSeat(16);

        gridView =  findViewById(R.id.gridView1);
        customGridAdapter = new CustomGridViewAdapter(this, R.layout.seatrow_grid, gridArray);
        gridView.setAdapter(customGridAdapter);
        gridView.setOnItemClickListener(this);

        seatNumbers = findViewById(R.id.seatNumbers);
        amount =findViewById(R.id.amount);
        btn_book = findViewById(R.id.bookButton);
        btn_book.setOnClickListener(this);
        selectedSeatNumbers.clear();
    }

    public static Bitmap getBitmapFromVectorDrawable(Context context, int drawableId) {
        Drawable drawable = ContextCompat.getDrawable(context, drawableId);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            drawable = (DrawableCompat.wrap(drawable)).mutate();
        }

        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(),
                drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);

        return bitmap;
    }

    public void totalSeat(int n)
    {
        for (int i = 1; i <= n; ++i)
        {
            gridArray.add(new Item(seatIcon, "seat " + i));

        }
    }

    public void seatSelected(int pos)
    {
        gridArray.remove(pos);
        gridArray.add(pos, new Item(seatSelect, "select"));
        customGridAdapter.notifyDataSetChanged();
        selectedSeatNumbers.add(pos+1);
        StringBuilder seatBuilder = new StringBuilder();
        amountPay = amountPay+1000;
        for (Integer details : selectedSeatNumbers) {
            seatBuilder.append(details + ",");

        }

        seatNumbers.setText( seatBuilder.toString());
        amount.setText("Rs. "+amountPay);

        seatNumbers.setVisibility(View.VISIBLE);
        amount.setVisibility(View.VISIBLE);
    }

    public void seatDeselcted(int pos)
    {

        gridArray.remove(pos);
        int i = pos + 1;
        gridArray.add(pos, new Item(seatIcon, "seat" + i));
        customGridAdapter.notifyDataSetChanged();

        int index = selectedSeatNumbers.indexOf(pos + 1);
        selectedSeatNumbers.remove(index);
        amountPay = amountPay-1000;

        StringBuilder builder = new StringBuilder();
        for (Integer details : selectedSeatNumbers) {
            builder.append(details + ",  ");

        }

        seatNumbers.setText( builder.toString());
        amount.setText("Rs. "+amountPay);

        seatNumbers.setVisibility(View.VISIBLE);
        amount.setVisibility(View.VISIBLE);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {

        Item item = gridArray.get(position);
        Bitmap seatcompare = item.getSeatSelect();
        if (seatcompare == seatIcon)
        {
            seatSelected(position);
        }
        else
        {
            seatDeselcted(position);

        }

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.bookButton){
            askConfirmation();
        }
    }

    private void askConfirmation() {
       SweetAlertDialog dialog =  new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE);
        dialog.setTitleText("Are you sure?");
        dialog.setContentText("Do You want to pay ?");
        dialog.setConfirmText("Proceed");
         dialog.setCancelable(false);
        dialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        SweetAlertDialog sdialog =sDialog;
                        sdialog.setTitleText("Success!");
                        sdialog.setContentText("Your booking has been completed!");
                        sdialog.setConfirmText("OK");
                        sdialog.setCancelClickListener(null);
                        sdialog.setCancelable(false);
                        sdialog .changeAlertType(SweetAlertDialog.SUCCESS_TYPE);
                        sdialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                BookBus.this.finish();
                            }
                        });

                    }
                })
                .show();
    }

    public static class CustomGridViewAdapter extends ArrayAdapter<Item>
    {

        Context context;
        int layoutResourceId;
        ArrayList<Item> data = new ArrayList<Item>();

        public CustomGridViewAdapter(Context context, int layoutResourceId, ArrayList<Item> data)
        {
            super(context, layoutResourceId, data);
            this.layoutResourceId = layoutResourceId;
            this.context = context;
            this.data = data;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            View row = convertView;
            RecordHolder holder = null;

            if (row == null)
            {
                LayoutInflater inflater = ((Activity) context).getLayoutInflater();
                row = inflater.inflate(layoutResourceId, parent, false);

                holder = new RecordHolder();
                holder.txtTitle = (TextView) row.findViewById(R.id.item_text);
                holder.imageItem = (ImageView) row.findViewById(R.id.item_image);
                row.setTag(holder);
            }
            else
            {
                holder = (RecordHolder) row.getTag();
            }

            Item item = data.get(position);
            holder.txtTitle.setText(item.getSelect());
            holder.imageItem.setImageBitmap(item.getSeatSelect());

            return row;
        }

        public static class RecordHolder
        {
            public TextView txtTitle;
            public ImageView imageItem;

        }
    }

}

