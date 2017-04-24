package com.example.sky_phase.mobattend;

import android.database.Cursor;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;

public class Display_Search_By_Students extends AppCompatActivity {
    Spinner spinner;
    AutoCompleteTextView typeDropDown;
    String uname;
    FirstTab you = new FirstTab();
    private static CustomAdapterForStudentSearch adapter;

    FirstTab frstTab = new FirstTab();
    Button click2;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display__search__by__students);
        typeDropDown = (AutoCompleteTextView) findViewById(R.id.ACTV_forStudent);
//        spinner = (Spinner)findViewById(R.id.spinnerforstudent);
        String fine = you.classid;
        click2 =  (Button)findViewById(R.id.click2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final MobattendDatabase db = new MobattendDatabase(this);
        Cursor sky3 = db.getListContents2(fine);
        ArrayList<String> allStudentsOfClass = db.checkingRollbyName_auto(fine);
        ArrayAdapter<String> addAllStudents = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, allStudentsOfClass);
        typeDropDown.setAdapter(addAllStudents);
        List<String> array1 = new ArrayList<>();
        while(sky3.moveToNext()){
            uname = sky3.getString(sky3.getColumnIndex("student_name"));
            array1.add(uname);
        }
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, array1);
        typeDropDown.setAdapter(adapter1);
        typeDropDown.setThreshold(0);
//        spinner.setAdapter(adapter1);


        click2.setOnClickListener(new View.OnClickListener() {
            ArrayList<DataModelForStudentSearch> dataModels;
            @Override
            public void onClick(View v) {

                listView = (ListView) findViewById(R.id.list2);
                dataModels = new ArrayList<>();
                String autoText = typeDropDown.getText().toString();
//                String SpinnerText = spinner.getSelectedItem().toString();

                String fine1 = frstTab.classid;

                Cursor getstudent = db.checkingRollbyName(fine1, autoText);
                if (getstudent.getCount() == 0) {
                    Toast.makeText(Display_Search_By_Students.this, "No Roll For the Selected", Toast.LENGTH_LONG).show();

                } else {
                    while (getstudent.moveToNext()) {
                        dataModels.add(new DataModelForStudentSearch(getstudent.getString(0), getstudent.getString(1)));
                        adapter = new CustomAdapterForStudentSearch(dataModels, getApplicationContext());
                        listView.setAdapter(adapter);


                    }

                }

            }
        });
    }


    public  boolean onSupportNavigateUp(){
        finish();

        return true;
    }
}
