package com.example.sky_phase.mobattend;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Stats extends AppCompatActivity {
    ArrayList<DataModelForStats> dataModels;
    private static CustomAdapterforStats adapter;
    TextView classname;
    TextView numberofstudents;
    ListView mylist;
        MobattendDatabase mydb = new MobattendDatabase(this);
    ModifiedSecondTab you = new ModifiedSecondTab();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stats);
        classname = (TextView)findViewById(R.id.classname);
        numberofstudents = (TextView)findViewById(R.id.numberofstudents);
        mylist = (ListView)findViewById(R.id.statlist);
        String set = you.gblbalmert;

        classname.setText(set);
        int count = mydb.getCount(set);
        //numberofstudents.setText(count);

        String ClassId = you.gblbalmert1;
        Cursor cursor = mydb.getAllStudentsofClass(ClassId);
        if (cursor.getCount() == 0){

        }else {
            while (cursor.moveToNext()){
                int count1 = mydb.getNumbOfTimesOfStd(ClassId, cursor.getString(0));
                dataModels.add(new DataModelForStats(cursor.getString(1), cursor.getString(0) ));
                adapter = new CustomAdapterforStats(dataModels, getBaseContext());
                mylist.setAdapter(adapter);

            }
        }

    }
}
