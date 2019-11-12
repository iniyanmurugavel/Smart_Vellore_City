package com.smart_vellore_city.school;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.smart_vellore_city.R;

import java.util.ArrayList;

public class SchoolMainActivity extends AppCompatActivity {

    ArrayList<String> schoolList;
    CardView studentDetailsCard;
    String item;
    ImageView addStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_main);

        Toolbar toolbar =  findViewById(R.id.schooltoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("School Registration");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        schoolList=new ArrayList<>();
        initListValues();
        studentDetailsCard=findViewById(R.id.studentdetails);
        studentDetailsCard.setVisibility(View.GONE);
        addStudent=findViewById(R.id.addstudent);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        Button submit=findViewById(R.id.submit);
        final EditText studentID=findViewById(R.id.studentid);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                item = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter dataAdapter = new ArrayAdapter (this, android.R.layout.simple_spinner_item, schoolList);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(studentID.getText().toString().equalsIgnoreCase("100")&&item.equalsIgnoreCase("Brainy Stars International School")){
                    studentDetailsCard.setVisibility(View.VISIBLE);
                }else
                {
                    studentDetailsCard.setVisibility(View.GONE);
                    Toast.makeText(SchoolMainActivity.this, "No details Found", Toast.LENGTH_SHORT).show();
                }
            }
        });
//        studentDetailsCard.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(SchoolMainActivity.this,TeacherReports.class);
//                startActivity(intent);
//            }
//        });
        addStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addStudent.setImageResource(R.drawable.ic_check_black_24dp);
                Toast.makeText(SchoolMainActivity.this, "Student Added Successfully", Toast.LENGTH_SHORT).show();
                Snackbar.make(v,"Student Added Successfully",Snackbar.LENGTH_SHORT);
            }
        });

    }

    private void initListValues() {
        schoolList.add("Bala Bhavan Matric school");
        schoolList.add("Seven Hills School");
        schoolList.add("Bharathidhasanar Matriculation School");
        schoolList.add("Brainy Stars International School");
        schoolList.add("Abdul Wahib Matric higher secondary school");

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.viewstud:
                // TODO put your code here to respond to the button tap
                startActivity(new Intent(this, ListOfMyChildrens.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.studentmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }


}
