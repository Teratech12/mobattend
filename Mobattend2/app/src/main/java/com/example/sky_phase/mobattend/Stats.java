package com.example.sky_phase.mobattend;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

public class Stats extends AppCompatActivity {
    ArrayList<DataModelForStats> dataModels;
    private static CustomAdapterforStats adapter;
    TextView classname, classcode, classAttendance;
    TextView numberofstudents;
    ListView mylist;
        MobattendDatabase mydb = new MobattendDatabase(this);
    ModifiedSecondTab you = new ModifiedSecondTab();
    ArrayList<BarEntry> entries;
    BarDataSet dataSet;
    ArrayList<String> labels;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stats);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //classname = (TextView)findViewById(R.id.classname);
       // numberofstudents = (TextView)findViewById(R.id.numberofstudents);
       // classcode = (TextView)findViewById(R.id.classcode);
       // classAttendance = (TextView)findViewById(R.id.classAttendance);
        mylist = (ListView)findViewById(R.id.statlist);
        String set = you.gblbalmert;
        String set1 = you.gblbalmert1;
        dataModels = new ArrayList<>();
     //   classname.setText(set);
      // classcode.setText(set1);
      //  int getAttendanceCount = mydb.getAttendanceCount(you.gblbalmert1);
      //  classAttendance.setText(getAttendanceCount);
       int getNumberOfStudentCount = mydb.getCount(you.gblbalmert1);
      // numberofstudents.setText("NUMBER OF STUDENTS : "+getNumberOfStudentCount);
      // int count = mydb.getCount(you.gblbalmert1);
        //numberofstudents.setText(count);
//entries.add(new BarEntry(numb,0))
        String ClassId = you.gblbalmert1;
         entries = new ArrayList<>();
         dataSet = new BarDataSet(entries,"hi");
         labels = new ArrayList<>();
        labels.add("ME");

        Cursor cursor = mydb.getAllStudentsofClass(ClassId);
        HorizontalBarChart me = null;

           int getattendance = mydb.getAttendanceCount(ClassId);
           float getattendance2 = getattendance;
        if (cursor.getCount() == 0){

        }else {
            while (cursor.moveToNext()){
                int count1 = mydb.getNumbOfTimesOfStd(ClassId, cursor.getString(0));
                float count2 = count1;
                float percentageP = (count2/getattendance2)*100;
                float absent = getattendance2 - count2;
                float percentageA = (absent/getattendance2)*100;
                dataModels.add(new DataModelForStats(cursor.getString(1), String.valueOf(count1)+"/"+getattendance, String.valueOf(percentageP),String.valueOf(percentageA)));
                Log.e("tag", String.valueOf(dataSet));
                adapter = new CustomAdapterforStats(dataModels, getApplicationContext());
                mylist.setAdapter(adapter);

            }
        }

    }
    public  boolean onSupportNavigateUp(){
        finish();

        return true;
    }
}
