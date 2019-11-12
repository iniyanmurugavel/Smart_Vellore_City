package com.smart_vellore_city.dashboard;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;

import com.merhold.extensiblepageindicator.ExtensiblePageIndicator;
import com.smart_vellore_city.Activity.About;
import com.smart_vellore_city.Activity.AboutHistoryDashboard;
import com.smart_vellore_city.Activity.FeedbackForm;
import com.smart_vellore_city.Activity.PrivacyPolicy;
import com.smart_vellore_city.Activity.Profile;
import com.smart_vellore_city.Bills.EBBill;
import com.smart_vellore_city.Bills.GasBill;
import com.smart_vellore_city.Bills.Internet;
import com.smart_vellore_city.Bills.Landline;
import com.smart_vellore_city.Bills.WaterBill;
import com.smart_vellore_city.Citizen_Services.activities.CitizenHome;
import com.smart_vellore_city.Digilocker.PatternLock;
import com.smart_vellore_city.E_Market.activity.EMarketActivity;
import com.smart_vellore_city.Emergency_Services.EmergencyDashboardActivity;
import com.smart_vellore_city.Emergency_Services.nearby.activities.NearBy;
import com.smart_vellore_city.Home_Services.Activity.HomeServices;
import com.smart_vellore_city.MarriageHall.activities.MarriageHallActivity;
import com.smart_vellore_city.Movie_Booking.Activity.Home;
import com.smart_vellore_city.R;
import com.smart_vellore_city.Rental.activity.RentalActivity;
import com.smart_vellore_city.SchoolColleges.activities.SchoolCollegeActivity;
import com.smart_vellore_city.Service.LockService;
import com.smart_vellore_city.Service.MyReceiver;
import com.smart_vellore_city.Service.PowerButtonService;
import com.smart_vellore_city.Tourism.activity.TourismHomeActivity;
import com.smart_vellore_city.Tourism.plan_trip.HotelBookingActivity;
import com.smart_vellore_city.Utils.Common;
import com.smart_vellore_city.agri.activity.AgriActivity;
import com.smart_vellore_city.certificates.Dashboard_Certificates;
import com.smart_vellore_city.jobs.JobsMainActivity;
import com.smart_vellore_city.language.LanguageChoose;
import com.smart_vellore_city.language.LocaleHelper;
import com.smart_vellore_city.notification.NotificationActivity;
import com.smart_vellore_city.parking.activities.ParkingDetails;
import com.smart_vellore_city.school.SchoolMainActivity;
import com.smart_vellore_city.wifi.Activity_Wifi;
import com.wangjie.rapidfloatingactionbutton.RapidFloatingActionButton;
import com.wangjie.rapidfloatingactionbutton.RapidFloatingActionHelper;
import com.wangjie.rapidfloatingactionbutton.RapidFloatingActionLayout;
import com.wangjie.rapidfloatingactionbutton.contentimpl.labellist.RFACLabelItem;
import com.wangjie.rapidfloatingactionbutton.contentimpl.labellist.RapidFloatingActionContentLabelList;
import com.wangjie.rapidfloatingactionbutton.util.RFABTextUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

import de.hdodenhof.circleimageview.CircleImageView;

public class NewDashBoard extends AppCompatActivity implements RapidFloatingActionContentLabelList.OnRapidFloatingActionContentLabelListListener {
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private MediaController media_control;
//    SliderLayout sliderLayout;
    ArrayAdapter<String> mAdapter;

    LinearLayout card_menu, llNearby,llCitizen,llTourism,llCityIrrigation,llEBBill,llWaterBill,
            llLandlineBill,llInternetBill,llGasBill,llMovies,llHotelBooking,llTransport,llEvents,
            llParking,llMarriageHalls,llPlumber,llElectrician,llDriver,llCarpenter,llGardener,
            llAirConditionar,llHealthcare,llAgri,llEMarket,llRental,llJobs,llSchoolRegistry,llAbout,
            llNearbyWifi;

    private static final String CALL_PHONE = Manifest.permission.CALL_PHONE;
    private static final int CALL_PERMISSION_REQUEST_CODE = 12345;

    RapidFloatingActionLayout rfaLayout;
    RapidFloatingActionButton rfaButton;

    /** code to post/handler request for permission */
    public final static int REQUEST_CODE = 100; /*(see edit II)*/

    BroadcastReceiver mReceiver;

    TextView textCartItemCount;
    int mCartItemCount = 2;

    ViewPager viewPager;
    ExtensiblePageIndicator indicator;

    CircleImageView profileImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        String language = LocaleHelper.getPersistedData(this, "en");

        Log.e("-----> ", "" + language);

        if (language.equalsIgnoreCase("en")) {
            LocaleHelper.setLocale(this, "en");

        } else if (language.equalsIgnoreCase("ta")) {
            LocaleHelper.setLocale(this, "ta");
        }

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Dashboard");

        card_menu = findViewById(R.id.card_menu);
        llNearby = findViewById(R.id.linear_nearby);
        llCitizen = findViewById(R.id.linear_citizen);
        llTourism = findViewById(R.id.linear_tourism);
        llCityIrrigation = findViewById(R.id.ll_city_irrigation);
        llEBBill = findViewById(R.id.linear_eb_bill);
        llWaterBill = findViewById(R.id.linear_water_bill);
        llLandlineBill = findViewById(R.id.linear_landline_bill);
        llInternetBill = findViewById(R.id.linear_internet_bill);
        llGasBill = findViewById(R.id.linear_gas_bill);
        llMovies = findViewById(R.id.linear_movies);
        llHotelBooking = findViewById(R.id.linear_hotel_booking);
        llTransport = findViewById(R.id.linear_transport);
        llEvents = findViewById(R.id.linear_events);
        llParking = findViewById(R.id.linear_parking);
        llMarriageHalls = findViewById(R.id.linear_marriage_halls);
        llPlumber = findViewById(R.id.linear_plumber);
        llElectrician = findViewById(R.id.linear_electrician);
        llDriver = findViewById(R.id.linear_driver);
        llCarpenter = findViewById(R.id.linear_carpenter);
        llGardener = findViewById(R.id.linear_gardener);
        llAirConditionar = findViewById(R.id.linear_air_conditionar);
        llAgri = findViewById(R.id.linear_agri);
        llEMarket = findViewById(R.id.linear_e_market);
        llRental = findViewById(R.id.linear_rental);
        llHealthcare = findViewById(R.id.linear_health_care);
        llJobs = findViewById(R.id.linear_jobs);
        llSchoolRegistry = findViewById(R.id.linear_school_colleges);
        llAbout = findViewById(R.id.linear_about);
        llNearbyWifi = findViewById(R.id.linear_nearby_wifi);

        profileImage = findViewById(R.id.profile_image);

        init();
        initExpandableFab();
        getLocationPermission();

        mReceiver = new MyReceiver();

        //Home Banner Slider
        viewPager = (ViewPager)findViewById(R.id.bannerSlider);
        HomeSliderAdapter sliderAdapter = new HomeSliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);

        Timer timer = new Timer();
        timer.schedule(new MyTime(),1000,2000);

        indicator = (ExtensiblePageIndicator)findViewById(R.id.indicator);
        indicator.initViewPager(viewPager);


        TextView marque = this.findViewById(R.id.marque_scrolling_text);

        String sourceString = "<br>" + "GOLD" + "</b>" + " 22k 2971 +400" + "<br>" + "Platinum" +
                "</b>" + " 24k 43533 Petrol BLR 77.32 DIESEL BLR 71.94 AUTO LPG 53.77" +
                " NIFTY 10200 BITCOIN 5520";
//        marque.setText(Html.fromHtml(sourceString));


        final SpannableStringBuilder sb = new SpannableStringBuilder("GOLD 22k 2971 +400 Platinum" +
                " 24k 43533 Petrol BLR 77.32 DIESEL BLR 71.94 AUTO LPG 53.77 NIFTY 10200 BITCOIN 5520");

        final StyleSpan bss = new StyleSpan(android.graphics.Typeface.BOLD); // Span to make text bold
        final StyleSpan iss = new StyleSpan(android.graphics.Typeface.ITALIC); //Span to make text italic
        final ForegroundColorSpan isss = new ForegroundColorSpan(getResources().getColor(R.color.colorPrimary)); //Span to make text color
        AbsoluteSizeSpan asspan = new AbsoluteSizeSpan((int) getResources().getDimension(R.dimen.margin_10));
//        sb.setSpan(bss, 0, 4, Spannable.SPAN_INCLUSIVE_INCLUSIVE); // make first 4 characters Bold
//        sb.setSpan(iss, 4, 7, Spannable.SPAN_INCLUSIVE_INCLUSIVE); // make last 2 characters Italic
//        sb.setSpan(isss, 7, 11, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE); // make last 2 characters Italic
//        sb.setSpan(bss, 7, 11, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE); // make last 2 characters Italic
//        sb.setSpan(iss, 7, 11, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE); // make last 2 characters Italic
//        sb.setSpan(asspan,1,4,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//        marque.setText(sb);

        StyleSpan bold = new StyleSpan(Typeface.BOLD);
        StyleSpan bolt_italic = new StyleSpan(Typeface.BOLD_ITALIC);
        StyleSpan italic = new StyleSpan(Typeface.ITALIC);

        ForegroundColorSpan  fcs = new ForegroundColorSpan(getResources().getColor(android.R.color.holo_red_light));

        sb.setSpan(bolt_italic,0,5,Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        sb.setSpan(fcs,0,5,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        sb.setSpan(bolt_italic,19,28,Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        sb.setSpan(fcs,19,28,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        marque.setText(sb);
        marque.setSelected(true);

        initNavigationDrawer();
//        sliderLayout = findViewById(R.id.slider);

        displayImage();
    }

    public class MyTime extends TimerTask {

        @Override
        public void run() {
            NewDashBoard.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager.getCurrentItem() == 0) {
                        viewPager.setCurrentItem(1);
                    } else if (viewPager.getCurrentItem() == 1) {
                        viewPager.setCurrentItem(2);
                    } else if (viewPager.getCurrentItem() == 2) {
                        viewPager.setCurrentItem(0);
                    }
                }
            });
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        final IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        filter.addAction(Intent.ACTION_USER_PRESENT);
        registerReceiver(mReceiver,filter);

    }

    public void getLocationPermission() {
        String[] permissions = {Manifest.permission.CALL_PHONE};

        if (ContextCompat.checkSelfPermission(getApplicationContext(), CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            Common.ISCALLPERMISSIONENABLED = true;

        } else {
            ActivityCompat.requestPermissions(this, permissions, CALL_PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case CALL_PERMISSION_REQUEST_CODE: {

                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    Common.ISCALLPERMISSIONENABLED = true;
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Common.ISCALLPERMISSIONENABLED = false;
                }
                return;
            }
        }
    }

    public void init(){

        llNearby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moveToNearByActivity = new Intent(NewDashBoard.this,NearBy.class);
                startActivity(moveToNearByActivity);

            }
        });

        llCitizen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(),CitizenHome.class);
                startActivity(i);
            }
        });

        llTourism.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(),TourismHomeActivity.class);
                startActivity(i);
            }
        });

        llCityIrrigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(),Dashboard_Certificates.class);
                startActivity(i);
            }
        });

        llEBBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(),EBBill.class);
                startActivity(i);
            }
        });

        llWaterBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(),WaterBill.class);
                startActivity(i);
            }
        });

        llLandlineBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(), Landline.class);
                startActivity(i);
            }
        });

        llInternetBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(),Internet.class);
                startActivity(i);
            }
        });

        llGasBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(),GasBill.class);
                startActivity(i);
            }
        });

        llMovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(),Home.class);
                startActivity(i);
            }
        });

        llHotelBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(),HotelBookingActivity.class);
                startActivity(i);
            }
        });

        llTransport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(),TransportDashboard.class);
                startActivity(i);
            }
        });

        llEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(), com.smart_vellore_city.Event_Booking.Activity.Home.class);
                startActivity(i);
            }
        });


        llParking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(),ParkingDetails.class);
                startActivity(i);
            }
        });

        llMarriageHalls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(),MarriageHallActivity.class);
                startActivity(i);
            }
        });

        llPlumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),HomeServices.class);
                i.putExtra("Type","Plumber");
                startActivity(i);
            }
        });

        llElectrician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),HomeServices.class);
                i.putExtra("Type","Electrician");
                startActivity(i);
            }
        });

        llDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),HomeServices.class);
                i.putExtra("Type","Driver");
                startActivity(i);
            }
        });

        llCarpenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),HomeServices.class);
                i.putExtra("Type","Carpenter");
                startActivity(i);
            }
        });

        llGardener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),HomeServices.class);
                i.putExtra("Type","Gardener");
                startActivity(i);
            }
        });

        llAirConditionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),HomeServices.class);
                i.putExtra("Type","Air Conditioner");
                startActivity(i);
            }
        });

        llAgri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),AgriActivity.class);
                startActivity(i);
            }
        });

        llEMarket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),EMarketActivity.class);
                startActivity(i);
            }
        });

        llRental.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),RentalActivity.class);
                startActivity(i);
            }
        });

        llHealthcare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(getApplicationContext(),EmergencyDashboardActivity.class);
                startActivity(i);
            }
        });

        llJobs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),JobsMainActivity.class);
                startActivity(i);
            }
        });

        llSchoolRegistry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),SchoolMainActivity.class);
                startActivity(i);
            }
        });

        llAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),AboutHistoryDashboard.class);
                startActivity(i);
            }
        });

        llNearbyWifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),Activity_Wifi.class);
                startActivity(i);
            }
        });

    }

    public void checkDrawOverlayPermission() {
        /** check if we already  have permission to draw over other apps */
        if (!Settings.canDrawOverlays(this)) { // WHAT IF THIS EVALUATES TO FALSE.
            /** if not construct intent to request permission */
            Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                    Uri.parse("package:" + getPackageName()));
            /** request permission via start activity for result */
            startActivityForResult(intent, REQUEST_CODE);
        } else { // ADD THIS.
            // Add code to bind and start the service directly.
        }
    }

    private void initExpandableFab() {
        rfaLayout = (RapidFloatingActionLayout) findViewById(R.id.activity_main_rfal);
        rfaButton = (RapidFloatingActionButton) findViewById(R.id.activity_main_rfab);

        RapidFloatingActionContentLabelList rfaContent = new RapidFloatingActionContentLabelList(this);
        rfaContent.setOnRapidFloatingActionContentLabelListListener(this);
        List<RFACLabelItem> items = new ArrayList<>();
        items.add(new RFACLabelItem<Integer>()
                .setLabel("Start SOS")
                .setResId(R.drawable.ic_sos)
                .setIconNormalColor(0xffd84315)
                .setIconPressedColor(0xffbf360c)
                .setLabelColor(0xff283593)
                .setWrapper(0)
        );
        items.add(new RFACLabelItem<Integer>()
                .setLabel("Digi Locker")
                .setResId(R.drawable.ic_digi_locker)
                .setIconNormalColor(0xffd84315)
                .setIconPressedColor(0xffbf360c)
                .setLabelColor(0xffd84315)
                .setWrapper(0)
        );
//        items.add(new RFACLabelItem<Integer>()
//                .setLabel("Marriage Halls")
//                .setResId(R.drawable.ic_marriage)
//                .setIconNormalColor(0xff4e342e)
//                .setIconPressedColor(0xff3e2723)
//                .setLabelColor(Color.WHITE)
//                .setLabelSizeSp(14)
//                .setLabelBackgroundDrawable(RFABShape.generateCornerShapeDrawable(0xaa000000, RFABTextUtil.dip2px(this, 4)))
//                .setWrapper(1)
//        );
        items.add(new RFACLabelItem<Integer>()
                .setLabel("Schools & colleges")
                .setResId(R.drawable.ic_school_white)
                .setIconNormalColor(0xff056f00)
                .setIconPressedColor(0xff0d5302)
                .setLabelColor(0xff056f00)
                .setWrapper(2)
        );
//        items.add(new RFACLabelItem<Integer>()
//                .setLabel("Jobs")
//                .setResId(R.drawable.ic_jobs)
//                .setIconNormalColor(0xff283593)
//                .setIconPressedColor(0xff1a237e)
//                .setLabelColor(0xff283593)
//                .setWrapper(3)
//        );
        items.add(new RFACLabelItem<Integer>()
                .setLabel("Near By")
                .setResId(R.drawable.ic_map_location_white)
                .setIconNormalColor(0xff056f00)
                .setIconPressedColor(0xff0d5302)
                .setLabelColor(0xff056f00)
                .setWrapper(2)
        );
        rfaContent
                .setItems(items)
                .setIconShadowRadius(RFABTextUtil.dip2px(this, 5))
                .setIconShadowColor(0xff888888)
                .setIconShadowDy(RFABTextUtil.dip2px(this, 5))
        ;
        RapidFloatingActionHelper rfabHelper = new RapidFloatingActionHelper(
                this,
                rfaLayout,
                rfaButton,
                rfaContent
        ).build();
    }

    private void displayImage() {
        HashMap<String, String> bannerMap = new HashMap<String, String>();
        bannerMap.put("Vellore Temple", "https://d27k8xmh3cuzik.cloudfront.net/wp-content/uploads/2018/04/Srilakshmi-Golden-temple-kb6592.jpg");
        bannerMap.put("Vellore Fort", "https://d27k8xmh3cuzik.cloudfront.net/wp-content/uploads/2018/04/FotoJetcover-vellore-kb6592.jpg");
    }

    @Override
    protected void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
//        sliderLayout.stopAutoCycle();
        super.onStop();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);

        MenuItem mSearch = menu.findItem(R.id.action_search);

        SearchView mSearchView = (SearchView) mSearch.getActionView();
        mSearchView.setQueryHint("Search");

        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });


        final MenuItem menuItem = menu.findItem(R.id.action_notification);

        View actionView = MenuItemCompat.getActionView(menuItem);
        textCartItemCount = actionView.findViewById(R.id.cart_badge);

        setupBadge();

        actionView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOptionsItemSelected(menuItem);
            }
        });


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.action_notification: {

                Intent i = new Intent(this, NotificationActivity.class);
                startActivity(i);

                // Do something
                return true;
            }
        }

        return super.onOptionsItemSelected(item);
    }

    private void setupBadge() {

        if (textCartItemCount != null) {
            if (mCartItemCount == 0) {
                if (textCartItemCount.getVisibility() != View.GONE) {
                    textCartItemCount.setVisibility(View.GONE);
                }
            } else {
                textCartItemCount.setText(String.valueOf(Math.min(mCartItemCount, 99)));
                if (textCartItemCount.getVisibility() != View.VISIBLE) {
                    textCartItemCount.setVisibility(View.VISIBLE);
                }
            }
        }
    }


    public void initNavigationDrawer() {

        NavigationView navigationView = findViewById(R.id.navigation_view);

        NavigationMenuView navMenuView = (NavigationMenuView) navigationView.getChildAt(0);
        navMenuView.addItemDecoration(new DividerItemDecoration(NewDashBoard.this, DividerItemDecoration.VERTICAL));
        if (navMenuView != null) {
            navMenuView.setVerticalScrollBarEnabled(false);
        }
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id = menuItem.getItemId();

                switch (id) {
                    case R.id.home:
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.profile:

                        Intent intentProfile = new Intent(getApplicationContext(),Profile.class);
                        startActivity(intentProfile);
                        drawerLayout.closeDrawers();

                        break;

                    case R.id.rating:
                        Intent rateIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.prematix.cme&hl=en_GB"+getPackageName()));
                        startActivity(rateIntent);
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.feedback:

                        Intent intentFeedback = new Intent(getApplicationContext(),FeedbackForm.class);
                        startActivity(intentFeedback);
                        drawerLayout.closeDrawers();

                        break;

                    case R.id.about:

                        Intent intentAbout = new Intent(getApplicationContext(),About.class);
                        startActivity(intentAbout);
                        drawerLayout.closeDrawers();

                        break;

                    case R.id.privacy:

                        Intent intentPrivacy = new Intent(getApplicationContext(),PrivacyPolicy.class);
                        startActivity(intentPrivacy);
                        drawerLayout.closeDrawers();

                        break;

                    case R.id.featuresvideo:

                        Intent intentfeatures = new Intent(getApplicationContext(),AppFeatures.class);
                        startActivity(intentfeatures);
                        drawerLayout.closeDrawers();

                        break;
                    case R.id.language:

                        Intent intentlanguage = new Intent(getApplicationContext(), LanguageChoose.class);
                        startActivity(intentlanguage);
                        drawerLayout.closeDrawers();

                        break;

//                    case R.id.logout:
//                        finish();

                }
                return true;
            }
        });
        View header = navigationView.getHeaderView(0);
        TextView tv_email = (TextView) header.findViewById(R.id.tv_email);
        tv_email.setText("Vellore Smart City");
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        navigationView.setItemIconTintList(null);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {

            @Override
            public void onDrawerClosed(View v) {
                super.onDrawerClosed(v);
            }

            @Override
            public void onDrawerOpened(View v) {
                super.onDrawerOpened(v);
            }
        };
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onRFACItemLabelClick(int position, RFACLabelItem item) {
        switch (position){
            case 0:

                try{
                    if (item.getLabel().equalsIgnoreCase("Start SOS")){

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                            if (!Settings.canDrawOverlays(this)) {
                                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                                        Uri.parse("package:" + getPackageName()));
                                /** request permission via start activity for result */
                                startActivityForResult(intent, REQUEST_CODE);

                                startService(new Intent(NewDashBoard.this, LockService.class));

                                startService(new Intent(NewDashBoard.this, PowerButtonService.class));
                            }
                        }

                        final IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_ON);
                        filter.addAction(Intent.ACTION_SCREEN_OFF);
                        filter.addAction(Intent.ACTION_USER_PRESENT);
                        registerReceiver(mReceiver,filter);

                        if (item.getLabel().equalsIgnoreCase("Start SOS")){
                            item.setLabel("Stop SOS");

                            rfaLayout.collapseContent();
                        }


                    }else if (item.getLabel().equalsIgnoreCase("Stop SOS")){

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                            if (!Settings.canDrawOverlays(this)) {
                                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                                        Uri.parse("package:" + getPackageName()));
                                /** request permission via start activity for result */
                                startActivityForResult(intent, REQUEST_CODE);

                                stopService(new Intent(NewDashBoard.this, LockService.class));

                                stopService(new Intent(NewDashBoard.this, PowerButtonService.class));
                            }
                        }

                        unregisterReceiver(mReceiver);

                        if (item.getLabel().equalsIgnoreCase("Stop SOS")){
                            item.setLabel("Start SOS");

                            rfaLayout.collapseContent();

                        }

                    }
                }catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_SHORT).show();
                }

                break;
            case 1:
                Intent moveToDigiLocker = new Intent(NewDashBoard.this,PatternLock.class);
                startActivity(moveToDigiLocker);
                break;
//            case 2:
//                Intent moveToMarriageHallActivity = new Intent(NewDashBoard.this,MarriageHallActivity.class);
//                startActivity(moveToMarriageHallActivity);
//                break;
            case 2:
                Intent moveToSchoolCollegeActivity = new Intent(NewDashBoard.this,SchoolCollegeActivity.class);
                startActivity(moveToSchoolCollegeActivity);
                break;
//            case 4:
//                Intent moveToJobsActivity = new Intent(NewDashBoard.this,JobsMainActivity.class);
//                startActivity(moveToJobsActivity);
//                break;
            case 3:
                Intent moveToNearByActivity = new Intent(NewDashBoard.this,NearBy.class);
                startActivity(moveToNearByActivity);
                break;

        }
    }

    @Override
    public void onRFACItemIconClick(int position, RFACLabelItem item) {
        switch (position){
            case 0:
                try{
                    if (item.getLabel().equalsIgnoreCase("Start SOS")){

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                            if (!Settings.canDrawOverlays(this)) {
                                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                                        Uri.parse("package:" + getPackageName()));
                                /** request permission via start activity for result */
                                startActivityForResult(intent, REQUEST_CODE);

                                startService(new Intent(NewDashBoard.this, LockService.class));

                                startService(new Intent(NewDashBoard.this, PowerButtonService.class));
                            }
                        }

                        final IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_ON);
                        filter.addAction(Intent.ACTION_SCREEN_OFF);
                        filter.addAction(Intent.ACTION_USER_PRESENT);
                        registerReceiver(mReceiver,filter);

                        if (item.getLabel().equalsIgnoreCase("Start SOS")){
                            item.setLabel("Stop SOS");

                            rfaLayout.collapseContent();
                        }

                    }else if (item.getLabel().equalsIgnoreCase("Stop SOS")){

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                            if (!Settings.canDrawOverlays(this)) {
                                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                                        Uri.parse("package:" + getPackageName()));
                                /** request permission via start activity for result */
                                startActivityForResult(intent, REQUEST_CODE);

                                stopService(new Intent(NewDashBoard.this, LockService.class));

                                stopService(new Intent(NewDashBoard.this, PowerButtonService.class));
                            }
                        }

                        unregisterReceiver(mReceiver);

                        if (item.getLabel().equalsIgnoreCase("Stop SOS")){
                            item.setLabel("Start SOS");

                            rfaLayout.collapseContent();
                        }
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_SHORT).show();
                }

                break;
            case 1:
                Intent moveToDigiLocker = new Intent(NewDashBoard.this,PatternLock.class);
                startActivity(moveToDigiLocker);
                break;
//            case 2:
//                Intent moveToMarriageHallActivity = new Intent(NewDashBoard.this,MarriageHallActivity.class);
//                startActivity(moveToMarriageHallActivity);
//                break;
            case 2:
                Intent moveToSchoolCollegeActivity = new Intent(NewDashBoard.this,SchoolCollegeActivity.class);
                startActivity(moveToSchoolCollegeActivity);
                break;
//            case 4:
//                Intent moveToJobsActivity = new Intent(NewDashBoard.this,JobsMainActivity.class);
//                startActivity(moveToJobsActivity);
//                break;
            case 3:
                Intent moveToNearByActivity = new Intent(NewDashBoard.this,NearBy.class);
                startActivity(moveToNearByActivity);
                break;
        }
    }

}


