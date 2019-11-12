package com.smart_vellore_city.Activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import com.smart_vellore_city.R;
import com.smart_vellore_city.parking.activities.ParkingMap;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class GetSchemeDetails extends AppCompatActivity {


    EditText userName,dateofBirth,dateOfRetirement,designation,presentAddress,addressAfterRetirement
            ,treasuryName,pensionClass,pensionAmount,pensionPercentage;

    LinearLayout attachmentOne,attachmentTwo,attachmentThree,attachmentFour,attachmentFive
            ,attachsignature,attachPhoto,percentageAmountLayout;
    CheckBox isPresentAddress;
    CheckBox yes,no;
    ImageView signatureDone,photoCopydone;
    Calendar myCalendar= Calendar.getInstance();
    int count=0,photoCount=0;
    boolean isDobSelected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_scheme_details);

        Toolbar toolbar =  findViewById(R.id.pensiontoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Pension scheme ");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        userName=findViewById(R.id.schemeusername);
        dateofBirth=findViewById(R.id.dobscheme);
        dateOfRetirement=findViewById(R.id.dobretirementscheme);
        designation=findViewById(R.id.designationscheme);
        presentAddress=findViewById(R.id.presentaddress);
        addressAfterRetirement=findViewById(R.id.addressafterretirement);
        treasuryName=findViewById(R.id.treasuryname);
        pensionClass=findViewById(R.id.pensionclass);
        pensionAmount=findViewById(R.id.pensionamount);
        pensionPercentage=findViewById(R.id.percentagepensionamount);
        attachsignature=findViewById(R.id.attachsignature);
        attachPhoto=findViewById(R.id.attachphoto);
        attachmentOne=findViewById(R.id.attachlayout1);
        attachmentTwo=findViewById(R.id.attachlayout2);
        attachmentThree=findViewById(R.id.attachmentlayout3);
        attachmentFour=findViewById(R.id.attachmentlayout4);
        attachmentFive=findViewById(R.id.attachmentlayout5);
        isPresentAddress=findViewById(R.id.sameaspresentcheck);
        yes=findViewById(R.id.yes);
        signatureDone=findViewById(R.id.checkcopies);
        photoCopydone=findViewById(R.id.checkcopies2);
        percentageAmountLayout=findViewById(R.id.percentageamountlayout);

        percentageAmountLayout.setVisibility(View.GONE);
        dateofBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(GetSchemeDetails.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                isDobSelected=true;
            }
        });


        dateOfRetirement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(GetSchemeDetails.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                isDobSelected=false;
            }
        });

        isPresentAddress.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    if(!presentAddress.getText().toString().isEmpty()){
                        addressAfterRetirement.setText(presentAddress.getText().toString());
                    }
                    else{
                        Snackbar.make(buttonView,"Please Enter Your address",Snackbar.LENGTH_SHORT);
                    }
                }else{
                    addressAfterRetirement.setText("");
                }
            }
        });


        attachsignature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1);
                count++;
            }
        });
        attachPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 2);
                photoCount++;
            }
        });

        yes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    percentageAmountLayout.setVisibility(View.VISIBLE);
                }else{
                    percentageAmountLayout.setVisibility(View.GONE);

                }
            }
        });



    }

    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            if(view.isEnabled())
            updateLabel();
        }

    };
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == 1) {
            if(count==1){
                attachmentOne.setVisibility(View.VISIBLE);
            }
            if(count==2){
                attachmentTwo.setVisibility(View.VISIBLE);
                signatureDone.setVisibility(View.VISIBLE);
            }
            if(count==3){
                Toast.makeText(this, "More than 2 Signatures not allowed", Toast.LENGTH_SHORT).show();
            }

        }else if(requestCode==2){
            if(photoCount==1){
                attachmentThree.setVisibility(View.VISIBLE);
            }
            if(photoCount==2){
                attachmentFour.setVisibility(View.VISIBLE);

            }
            if(photoCount==3){
                attachmentFive.setVisibility(View.VISIBLE);
                photoCopydone.setVisibility(View.VISIBLE);
            }
            if(photoCount==4){
                Toast.makeText(this, "More than 3 Photos not allowed", Toast.LENGTH_SHORT).show();

            }

        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.pension_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.submitpension:
                // TODO put your code here to respond to the button tap
                Toast.makeText(this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void updateLabel() {
        String myFormat = "MM/dd/yy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        if(isDobSelected){
            dateofBirth.setText(sdf.format(myCalendar.getTime()));
        }else
        {
            dateOfRetirement.setText(sdf.format(myCalendar.getTime()));
        }

    }
}
