package com.smart_vellore_city.Emergency_Services.appoinments.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.imanoweb.calendarview.CalendarListener;
import com.imanoweb.calendarview.CustomCalendarView;
import com.sdsmdg.tastytoast.TastyToast;
import com.smart_vellore_city.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.os.Build.VERSION.SDK_INT;

public class DoctorBookingActivity extends AppCompatActivity {
    CustomCalendarView calendarView;
    Calendar currentCalendar;
    String sessionamount;

    String TAG = DoctorBookingActivity.class.getSimpleName();
    @BindView(R.id.tv_date)TextView tv_date;
    @BindView(R.id.dp_toolbar)Toolbar dp_toolbar;
    @BindView(R.id.tv_nine_am)TextView tv_nine_am;
    @BindView(R.id.tv_nine_thirty_am)TextView tv_nine_thirty_am;
    @BindView(R.id.tv_ten_am)TextView tv_ten_am;
    @BindView(R.id.tv_twelve_pm)TextView tv_twelve_pm;
    @BindView(R.id.tv_two_pm)TextView tv_two_pm;
    @BindView(R.id.tv_package)TextView tv_package;
    @BindView(R.id.tv_booknow)TextView tv_booknow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_booking);
        ButterKnife.bind(this);

        setSupportActionBar(dp_toolbar);
        getSupportActionBar().setTitle("Appointment Details");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Initialize CustomCalendarView from layout
        calendarView = (CustomCalendarView) findViewById(R.id.calendar_view);

        sessionamount =getIntent().getStringExtra("sessionamount");
        tv_package.setText(sessionamount);
        //Initialize calendar with date
        currentCalendar = Calendar.getInstance(Locale.getDefault());
        initializeCalendar();
        onClickFunctions();
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        Date d = new Date();
        String dayOfTheWeek = sdf.format(d);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMMM", Locale.getDefault());
        Date date = new Date();

        tv_date.setText(dayOfTheWeek+" "+simpleDateFormat.format(date));

    }

    private void onClickFunctions() {
        tv_nine_am.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    tv_nine_am.setBackground(getResources().getDrawable(R.drawable.doctor_timings_selected));
                    tv_nine_am.setTextColor(getResources().getColor(R.color.white));

                    tv_nine_thirty_am.setBackground(getResources().getDrawable(R.drawable.ic_oval));
                    tv_nine_thirty_am.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

                    tv_ten_am.setBackground(getResources().getDrawable(R.drawable.ic_oval));
                    tv_ten_am.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

                    tv_twelve_pm.setBackground(getResources().getDrawable(R.drawable.ic_oval));
                    tv_twelve_pm.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

                    tv_two_pm.setBackground(getResources().getDrawable(R.drawable.ic_oval));
                    tv_two_pm.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                }
            }
        });
        tv_nine_thirty_am.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                tv_nine_thirty_am.setBackground(getResources().getDrawable(R.drawable.doctor_timings_selected));
                tv_nine_thirty_am.setTextColor(getResources().getColor(R.color.white));

                tv_nine_am.setBackground(getResources().getDrawable(R.drawable.ic_oval));
                tv_nine_am.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

                tv_ten_am.setBackground(getResources().getDrawable(R.drawable.ic_oval));
                tv_ten_am.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

                tv_twelve_pm.setBackground(getResources().getDrawable(R.drawable.ic_oval));
                tv_twelve_pm.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

                tv_two_pm.setBackground(getResources().getDrawable(R.drawable.ic_oval));
                tv_two_pm.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            }
        });
        tv_ten_am.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                tv_ten_am.setBackground(getResources().getDrawable(R.drawable.doctor_timings_selected));
                tv_ten_am.setTextColor(getResources().getColor(R.color.white));

                tv_nine_am.setBackground(getResources().getDrawable(R.drawable.ic_oval));
                tv_nine_am.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

                tv_nine_thirty_am.setBackground(getResources().getDrawable(R.drawable.ic_oval));
                tv_nine_thirty_am.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

                tv_twelve_pm.setBackground(getResources().getDrawable(R.drawable.ic_oval));
                tv_twelve_pm.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

                tv_two_pm.setBackground(getResources().getDrawable(R.drawable.ic_oval));
                tv_two_pm.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            }
        });
        tv_twelve_pm.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                tv_twelve_pm.setBackground(getResources().getDrawable(R.drawable.doctor_timings_selected));
                tv_twelve_pm.setTextColor(getResources().getColor(R.color.white));

                tv_nine_am.setBackground(getResources().getDrawable(R.drawable.ic_oval));
                tv_nine_am.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

                tv_nine_thirty_am.setBackground(getResources().getDrawable(R.drawable.ic_oval));
                tv_nine_thirty_am.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

                tv_ten_am.setBackground(getResources().getDrawable(R.drawable.ic_oval));
                tv_ten_am.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

                tv_two_pm.setBackground(getResources().getDrawable(R.drawable.ic_oval));
                tv_two_pm.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            }
        });
        tv_two_pm.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                tv_two_pm.setBackground(getResources().getDrawable(R.drawable.doctor_timings_selected));
                tv_two_pm.setTextColor(getResources().getColor(R.color.white));

                tv_nine_am.setBackground(getResources().getDrawable(R.drawable.ic_oval));
                tv_nine_am.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

                tv_nine_thirty_am.setBackground(getResources().getDrawable(R.drawable.ic_oval));
                tv_nine_thirty_am.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

                tv_ten_am.setBackground(getResources().getDrawable(R.drawable.ic_oval));
                tv_ten_am.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

                tv_twelve_pm.setBackground(getResources().getDrawable(R.drawable.ic_oval));
                tv_twelve_pm.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            }
        });
        tv_booknow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(DoctorBookingActivity.this, "Your Appoinment has been Booked Successfully!", Toast.LENGTH_SHORT).show();
                TastyToast.makeText(DoctorBookingActivity.this, "Your Appoinment has been Booked Successfully!", TastyToast.LENGTH_LONG, TastyToast.SUCCESS);

            }
        });
    }

    private void initializeCalendar() {
        //Show Monday as first date of week
        calendarView.setFirstDayOfWeek(Calendar.MONDAY);
//Show/hide overflow days of a month
        calendarView.setShowOverflowDate(false);
//call refreshCalendar to update calendar the view
        calendarView.refreshCalendar(currentCalendar);

//Handling custom calendar events
        calendarView.setCalendarListener(new CalendarListener() {
            @Override
            public void onDateSelected(Date date) {
                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                tv_date.setText(getDayFromDateString(df.format(date),"dd-MM-yyyy"));
//                Toast.makeText(DoctorBookingActivity.this, df.format(date), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onMonthChanged(Date date) {
                SimpleDateFormat df = new SimpleDateFormat("MM-yyyy");
//                Toast.makeText(DoctorBookingActivity.this, df.format(date), Toast.LENGTH_SHORT).show();
            }
        });
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
}
