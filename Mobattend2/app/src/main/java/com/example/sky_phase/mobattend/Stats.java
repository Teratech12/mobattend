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
    TextView classname, classcode, classAttendance;
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
        classcode = (TextView)findViewById(R.id.classcode);
        classAttendance = (TextView)findViewById(R.id.classAttendance);
        mylist = (ListView)findViewById(R.id.statlist);
        String set = you.gblbalmert;
        String set1 = you.gblbalmert1;
        dataModels = new ArrayList<>();
        classname.setText(set);
       classcode.setText(set1);
      //  int getAttendanceCount = mydb.getAttendanceCount(you.gblbalmert1);
      //  classAttendance.setText(getAttendanceCount);
       int getNumberOfStudentCount = mydb.getCount(you.gblbalmert1);
       numberofstudents.setText("NUMBER OF STUDENTS : "+getNumberOfStudentCount);
      // int count = mydb.getCount(you.gblbalmert1);
        //numberofstudents.setText(count);

        String ClassId = you.gblbalmert1;

        Cursor cursor = mydb.getAllStudentsofClass(ClassId);
        if (cursor.getCount() == 0){

        }else {
            while (cursor.moveToNext()){
                int count1 = mydb.getNumbOfTimesOfStd(ClassId, cursor.getString(0));
                dataModels.add(new DataModelForStats(cursor.getString(1), String.valueOf(count1) ));
                adapter = new CustomAdapterforStats(dataModels, getApplicationContext());
                mylist.setAdapter(adapter);

            }
        }

    }
}
