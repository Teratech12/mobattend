package com.example.sky_phase.mobattend;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

public class Stats extends AppCompatActivity {
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

    }
}
