package com.smart_vellore_city.MarriageHall.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;
import com.sdsmdg.tastytoast.TastyToast;
import com.smart_vellore_city.Emergency_Services.appoinments.adapters.SpecialityRecyclerAdapter;
import com.smart_vellore_city.MarriageHall.beans.MhallBean;
import com.smart_vellore_city.MarriageHall.contracts.MhallBookingContract;
import com.smart_vellore_city.MarriageHall.presenters.MhallBookingPresenter;
import com.smart_vellore_city.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MarriageHallBookingActivity extends AppCompatActivity implements MhallBookingContract.view,SpecialityRecyclerAdapter.GetItemCallback {
    private static final String TAG = MarriageHallBookingActivity.class.getSimpleName();
    @BindView(R.id.compactcalendar_view)
    CompactCalendarView compactcalendar_view;
    @BindView(R.id.tv_booking_date_from) TextView tv_booking_date_from;
    @BindView(R.id.tv_day_one) TextView tv_day_one;
    @BindView(R.id.tv_day_two) TextView tv_day_two;
    @BindView(R.id.tv_day_three) TextView tv_day_three;
    @BindView(R.id.tv_day_four) TextView tv_day_four;
    @BindView(R.id.tv_day_five) TextView tv_day_five;
    @BindView(R.id.tv_package) TextView tv_package;
    @BindView(R.id.tv_fun_catagory) TextView tv_fun_catagory;
    @BindView(R.id.tv_booknow) TextView tv_booknow;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    TextView calender_tv_month_year_title, cal_bs_tv_from, cal_bs_tv_to, cal_bs_title_date,
            tv_no_events, tv_no_event_found, tv_day_title, bs_tv_title;

    ImageView calendar_iv_left, calendar_iv_right, calendar_iv_close;

    String sSetDate, sDate;
    long eventCurrentTimeInMillis;
    private SimpleDateFormat dateFormatForMonth = new SimpleDateFormat("MMM yyyy", Locale.getDefault());
    private SimpleDateFormat localDateFormat = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss aa", Locale.getDefault());
    Event eventsPointer1,eventsPointer2,eventsPointer;
    List<Event> events = new ArrayList<>();
    List<Event> events1 = new ArrayList<>();
    List<Event> events2 = new ArrayList<>();
    MhallBean mhallBean;
    int hallrentvalue=0;
    int actualHallrentvalue=0;

    RecyclerView rv_speciality;
    TextView tv_title;
    android.support.v7.app.AlertDialog dialog;

    MhallBookingPresenter mhallBookingPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marriagehall_booking);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Booking Details");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mhallBookingPresenter =new MhallBookingPresenter(this);

        if(getIntent()!=null){
            Intent i = getIntent();
            mhallBean = (MhallBean)i.getSerializableExtra("MhallBean");
            tv_package.setText("₹ "+mhallBean.getmItemBaseRate()+" / Per Day");
            String tempString = mhallBean.getmItemBaseRate().replace(",","");
            actualHallrentvalue = Integer.parseInt(tempString);
            hallrentvalue = actualHallrentvalue*3;
            tv_package.setText("₹ "+hallrentvalue+" / Per Day");
        }


        initViews();

        onClicks();
        getDateTimeInMillis();

        addEvents();
    }

    private void addEvents() {
        try {

            long e = 1544769642000L;
            long e2 = 1545374442000L;
            long e3 = 1545028842000L;
            eventsPointer = new Event(Color.BLUE, e, "Booked");
            compactcalendar_view.addEvent(eventsPointer);
            eventsPointer1 = new Event(Color.BLUE, e2, "Booked");
            compactcalendar_view.addEvent(eventsPointer1);
            eventsPointer2 = new Event(Color.BLUE, e3, "Booked");
            compactcalendar_view.addEvent(eventsPointer2);
            events = compactcalendar_view.getEvents(e);
            events1 = compactcalendar_view.getEvents(e2);
            events2 = compactcalendar_view.getEvents(e3);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void onClicks() {

        tv_fun_catagory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
        calendar_iv_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compactcalendar_view.scrollLeft();

            }
        });
        calendar_iv_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compactcalendar_view.scrollRight();

            }
        });

        compactcalendar_view.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {
                List<Event> events = compactcalendar_view.getEvents(dateClicked);
                if(events.size()>0){
                    if(events.get(0).getData().toString().equalsIgnoreCase("Booked")){
                        TastyToast.makeText(MarriageHallBookingActivity.this, "This date has been Booked Already!", TastyToast.LENGTH_LONG, TastyToast.CONFUSING);
                    }else{
                        long eventTimeInMillis = dateClicked.getTime();


                        String dateParsedString = localDateFormat.format(dateClicked);
                        sDate = parseDate(dateParsedString, "MMM dd, yyyy hh:mm:ss aa", "yyyy-MM-dd");
                        sSetDate = parseDate(sDate, "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss");
                        tv_booking_date_from.setText("Booking Date: "+getDayFromDateString(sSetDate,"yyyy-MM-dd HH:mm:ss"));
                    }
                }else{
                    long eventTimeInMillis = dateClicked.getTime();


                    String dateParsedString = localDateFormat.format(dateClicked);
                    sDate = parseDate(dateParsedString, "MMM dd, yyyy hh:mm:ss aa", "yyyy-MM-dd");
                    sSetDate = parseDate(sDate, "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss");
                    tv_booking_date_from.setText("Booking Date : "+getDayFromDateString(sSetDate,"yyyy-MM-dd HH:mm:ss"));
                }

            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
                calender_tv_month_year_title.setText(dateFormatForMonth.format(compactcalendar_view.getFirstDayOfCurrentMonth()).toUpperCase());
            }
        });

        tv_day_one.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                tv_day_one.setBackground(getResources().getDrawable(R.drawable.doctor_timings_selected));
                tv_day_one.setTextColor(getResources().getColor(R.color.white));

                tv_day_two.setBackground(getResources().getDrawable(R.drawable.ic_oval));
                tv_day_two.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

                tv_day_three.setBackground(getResources().getDrawable(R.drawable.ic_oval));
                tv_day_three.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

                tv_day_four.setBackground(getResources().getDrawable(R.drawable.ic_oval));
                tv_day_four.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

                tv_day_five.setBackground(getResources().getDrawable(R.drawable.ic_oval));
                tv_day_five.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                hallrentvalue = actualHallrentvalue*1;
                tv_package.setText("₹ "+hallrentvalue+" / Per Day");
            }
        });
        tv_day_two.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                tv_day_two.setBackground(getResources().getDrawable(R.drawable.doctor_timings_selected));
                tv_day_two.setTextColor(getResources().getColor(R.color.white));

                tv_day_one.setBackground(getResources().getDrawable(R.drawable.ic_oval));
                tv_day_one.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

                tv_day_three.setBackground(getResources().getDrawable(R.drawable.ic_oval));
                tv_day_three.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

                tv_day_four.setBackground(getResources().getDrawable(R.drawable.ic_oval));
                tv_day_four.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

                tv_day_five.setBackground(getResources().getDrawable(R.drawable.ic_oval));
                tv_day_five.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                hallrentvalue = actualHallrentvalue*2;
                tv_package.setText("₹ "+hallrentvalue+" / Per Day");
            }
        });
        tv_day_three.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                tv_day_three.setBackground(getResources().getDrawable(R.drawable.doctor_timings_selected));
                tv_day_three.setTextColor(getResources().getColor(R.color.white));

                tv_day_one.setBackground(getResources().getDrawable(R.drawable.ic_oval));
                tv_day_one.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

                tv_day_two.setBackground(getResources().getDrawable(R.drawable.ic_oval));
                tv_day_two.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

                tv_day_four.setBackground(getResources().getDrawable(R.drawable.ic_oval));
                tv_day_four.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

                tv_day_five.setBackground(getResources().getDrawable(R.drawable.ic_oval));
                tv_day_five.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                hallrentvalue = actualHallrentvalue*3;
                tv_package.setText("₹ "+hallrentvalue+" / Per Day");
            }
        });
        tv_day_four.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                tv_day_four.setBackground(getResources().getDrawable(R.drawable.doctor_timings_selected));
                tv_day_four.setTextColor(getResources().getColor(R.color.white));

                tv_day_one.setBackground(getResources().getDrawable(R.drawable.ic_oval));
                tv_day_one.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

                tv_day_three.setBackground(getResources().getDrawable(R.drawable.ic_oval));
                tv_day_three.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

                tv_day_two.setBackground(getResources().getDrawable(R.drawable.ic_oval));
                tv_day_two.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

                tv_day_five.setBackground(getResources().getDrawable(R.drawable.ic_oval));
                tv_day_five.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                hallrentvalue = actualHallrentvalue*4;
                tv_package.setText("₹ "+hallrentvalue+" / Per Day");
            }
        });
        tv_day_five.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                tv_day_five.setBackground(getResources().getDrawable(R.drawable.doctor_timings_selected));
                tv_day_five.setTextColor(getResources().getColor(R.color.white));

                tv_day_one.setBackground(getResources().getDrawable(R.drawable.ic_oval));
                tv_day_one.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

                tv_day_three.setBackground(getResources().getDrawable(R.drawable.ic_oval));
                tv_day_three.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

                tv_day_two.setBackground(getResources().getDrawable(R.drawable.ic_oval));
                tv_day_two.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

                tv_day_four.setBackground(getResources().getDrawable(R.drawable.ic_oval));
                tv_day_four.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                hallrentvalue = actualHallrentvalue*5;
                tv_package.setText("₹ "+hallrentvalue+" / Per Day");
            }
        });
        tv_booknow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TastyToast.makeText(MarriageHallBookingActivity.this, "Marriage Hall booked Successfully!", TastyToast.LENGTH_LONG, TastyToast.SUCCESS);
            }
        });

    }

    public void showDialog(){
        final android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(this);

        LayoutInflater li = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        final View dview = li.inflate(R.layout.activity_speciality, null);
        rv_speciality = (RecyclerView) dview.findViewById(R.id.rv_speciality);
        tv_title = (TextView) dview.findViewById(R.id.tv_title);
        tv_title.setText("Select Function Type");
        rv_speciality.setLayoutManager(new LinearLayoutManager(this));
        mhallBookingPresenter.loadFunctionList();
        builder.setView(dview);
        dialog = builder.create();
        dialog.show();
        dialog.setCancelable(false);

    }

    public String parseDate(String date, String givenformat, String resultformat) {

        String result = "";
        SimpleDateFormat sdf;
        SimpleDateFormat sdf1;

        try {
            sdf = new SimpleDateFormat(givenformat);
            sdf1 = new SimpleDateFormat(resultformat);
            result = sdf1.format(sdf.parse(date));

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        } finally {
            sdf = null;
            sdf1 = null;
        }
        return result;
    }

    private void initViews() {
        //textview
        calender_tv_month_year_title = (TextView) findViewById(R.id.calender_tv_month_year_title);
        //image view
        calendar_iv_left = (ImageView) findViewById(R.id.calendar_iv_left);
        calendar_iv_right = (ImageView) findViewById(R.id.calendar_iv_right);
    }

    public void getDateTimeInMillis() {
        //creating Calendar instance
        Calendar calendar = Calendar.getInstance();

        //Returns current time in millis
        long timeMilli2 = calendar.getTimeInMillis();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM yyyy");
        SimpleDateFormat dateFormatAPI = new SimpleDateFormat("yyyy-MM-dd");


        sSetDate = dateFormat.format(calendar.getTime());
        sDate = dateFormatAPI.format(calendar.getTime());
        eventCurrentTimeInMillis = timeMilli2;


        if (!sSetDate.isEmpty()) {
            calender_tv_month_year_title.setText(sSetDate);
        }


        Log.e(TAG, "" + eventCurrentTimeInMillis + "---" + sSetDate + "----" + sDate);

    }

    private String getDayFromDateString(String stringDate,String dateTimeFormat)
    {
        String[] daysArray = new String[] {"Saturday","Sunday","Monday","Tuesday","Wednesday","Thursday","Friday"};
        String[] monthsArray = new String[] {"January","February","March","April","May","June","July","Auguest","September","October","November","December"};
        String day = "";
        String month = "";

        int dayOfWeek =0;
        int monthOfYear=0;
        int dateOfMonth=0;
        //dateTimeFormat = yyyy-MM-dd HH:mm:ss
        SimpleDateFormat formatter = new SimpleDateFormat(dateTimeFormat);
        Date date;
        try {
            date = formatter.parse(stringDate);
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            Log.d(TAG, "getDayFromDateString: "+c.get(Calendar.DAY_OF_WEEK)+" "+c.get(Calendar.MONTH)+" "+c.get(Calendar.DATE));
            if(c.get(Calendar.DAY_OF_WEEK) == 7)
                dayOfWeek = 0;
            else
                dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

            monthOfYear = c.get(Calendar.MONTH);
            dateOfMonth = c.get(Calendar.DATE);
            if (dayOfWeek < 0) {
                dayOfWeek += 7;
            }
            day = daysArray[dayOfWeek];
            month = monthsArray[monthOfYear];
        } catch (Exception e) {
            e.printStackTrace();
        }

        return day+" "+dateOfMonth+" "+month;
    }

    @Override
    public void getFunctionList(List<String> functionList) {
        SpecialityRecyclerAdapter specialityRecyclerAdapter = new SpecialityRecyclerAdapter(this,functionList,this);
        rv_speciality.setAdapter(specialityRecyclerAdapter);
    }

    @Override
    public void getItemValues(String item) {
        tv_fun_catagory.setText(item);
        dialog.dismiss();
    }
}
