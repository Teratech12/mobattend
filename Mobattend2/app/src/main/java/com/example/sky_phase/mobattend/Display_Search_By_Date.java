package com.example.sky_phase.mobattend;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Display_Search_By_Date extends AppCompatActivity {

    Spinner display_date_spinner;
    String uname;
    ArrayList<DataModelForDateSearch> dataModels;
    ListView listView;
    String date;
    private static CustomAdapterForDateSearch adapter;
    ClasssFragment you = new ClasssFragment();
    FirstTab frstTab = new FirstTab();
    Button click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display__search__by__date);
        display_date_spinner = (Spinner)findViewById(R.id.display_date_spinner);
        listView = (ListView)findViewById(R.id.list);

        click = (Button)findViewById(R.id.click);


        dataModels = new ArrayList<>();
        date = new SimpleDateFormat("MMMM d,yyyy").format(new Date());
        //MobattendDatabase db3 = new MobattendDatabase(getContext());

        View emptyView = getLayoutInflater().inflate(R.layout.emptydatesearch, null);
        ((ViewGroup)listView.getParent()).addView(emptyView);
        listView.setEmptyView(emptyView);
        final String fine = frstTab.classid;
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String SpinnerText = display_date_spinner.getSelectedItem().toString();


                MobattendDatabase db = new MobattendDatabase(getApplicationContext());
                Cursor sky2 = db.checkingRoll("coe 124",SpinnerText);
                if(sky2.getCount() == 0){

                }
                else{
                    while (sky2.moveToNext()){
                        //int count = db.getCount(sky2.getString(0));
                        dataModels.add(new DataModelForDateSearch(sky2.getString(0),sky2.getString(1)));
                        adapter = new CustomAdapterForDateSearch(dataModels,getApplicationContext());
                        listView.setAdapter(adapter);

                    }
                }


            }
        });


/*
        String fine = you.gblbalmert;

        View emptyView = getLayoutInflater().inflate(R.layout.emptydatesearch, null);
        ((ViewGroup)listView.getParent()).addView(emptyView);
        MobattendDatabase db = new MobattendDatabase(this);
        Cursor sky2 = db.checkingRoll(fine,SpinnerText);
        if(sky2.getCount() == 0){

        }
        else{
            while (sky2.moveToNext()){
                //int count = db.getCount(sky2.getString(0));
                dataModels.add(new DataModelForDateSearch(sky2.getString(0),sky2.getString(1)));
                adapter = new CustomAdapterForDateSearch(dataModels, (View.OnClickListener) this);
                listView.setAdapter(adapter);
                listView.setEmptyView(emptyView);
            }
        }*/

        MobattendDatabase db = new MobattendDatabase(this);
        Cursor sky3 = db.displayDate();
        List<String> array1 = new ArrayList<>();

      //  String[] array = new String[sky2.getCount()];
      //  int i =0;
         while(sky3.moveToNext()){
              uname = sky3.getString(sky3.getColumnIndex("attendance_name"));
            array1.add(uname);
         }
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, array1);
        display_date_spinner.setAdapter(adapter1);

    }
}
