package com.example.sky_phase.mobattend;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class Display_Search_By_Students extends AppCompatActivity {
    Spinner spinner;
    String uname;
    FirstTab you = new FirstTab();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display__search__by__students);
        spinner = (Spinner)findViewById(R.id.spinnerforstudent);
        String fine = you.classid;

        MobattendDatabase db = new MobattendDatabase(this);
        Cursor sky3 = db.getListContents2(fine);
        List<String> array1 = new ArrayList<>();
        while(sky3.moveToNext()){
            uname = sky3.getString(sky3.getColumnIndex("student_name"));
            array1.add(uname);
        }
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, array1);
        spinner.setAdapter(adapter1);
    }
}
