package com.example.sky_phase.mobattend;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class Display_Search_By_Students extends AppCompatActivity {
    Spinner spinner;
    String uname;
    FirstTab you = new FirstTab();
    private static CustomAdapterForDateSearch adapter;

    FirstTab frstTab = new FirstTab();
    Button click2;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display__search__by__students);
        spinner = (Spinner)findViewById(R.id.spinnerforstudent);
        String fine = you.classid;
        click2 =  (Button)findViewById(R.id.click2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final MobattendDatabase db = new MobattendDatabase(this);
        Cursor sky3 = db.getListContents2(fine);
        List<String> array1 = new ArrayList<>();
        while(sky3.moveToNext()){
            uname = sky3.getString(sky3.getColumnIndex("student_name"));
            array1.add(uname);
        }
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, array1);
        spinner.setAdapter(adapter1);


        click2.setOnClickListener(new View.OnClickListener() {
            ArrayList<DataModelForDateSearch> dataModels;
            @Override
            public void onClick(View v) {

                listView = (ListView) findViewById(R.id.list2);
                dataModels = new ArrayList<>();

                String SpinnerText = spinner.getSelectedItem().toString();

                String fine1 = frstTab.classid;

                Cursor getstudent = db.checkingRollbyName(fine1, SpinnerText);
                if (getstudent.getCount() == 0) {


                } else {
                    while (getstudent.moveToNext()) {
                        dataModels.add(new DataModelForDateSearch(getstudent.getString(0), getstudent.getString(1)));
                        adapter = new CustomAdapterForDateSearch(dataModels, getApplicationContext());
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
