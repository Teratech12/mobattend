package com.example.sky_phase.mobattend;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class WhenListIsSelected extends AppCompatActivity {
    ListView mylist;
    TextView name1, id1;
    FirstTab frstTab = new FirstTab();
    Populate_With_Search me = new Populate_With_Search();
    private static CustomAdapterForDateSearch adapter;
    ArrayList<DataModelForDateSearch> dataModels;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_when_list_is_selected);
        mylist = (ListView)findViewById(R.id.listlist);
        name1 = (TextView)findViewById(R.id.name);
        id1 = (TextView)findViewById(R.id.id);
        final MobattendDatabase db = new MobattendDatabase(this);



        String fine1 = frstTab.classid;
        Toast.makeText(getApplicationContext(),fine1,Toast.LENGTH_SHORT).show();
        String studentName = me.gblbalmert;
        String id = me.gblbalmert1;
        name1.setText(studentName);
        id1.setText(id);


        Cursor getstudent = db.checkingRollbyName(fine1, studentName);
        if (getstudent.getCount() == 0) {


        } else {
            while (getstudent.moveToNext()) {
                dataModels.add(new DataModelForDateSearch(getstudent.getString(0), getstudent.getString(1)));
                adapter = new CustomAdapterForDateSearch(dataModels, getApplicationContext());
                mylist.setAdapter(adapter);


            }

        }

    }
}
