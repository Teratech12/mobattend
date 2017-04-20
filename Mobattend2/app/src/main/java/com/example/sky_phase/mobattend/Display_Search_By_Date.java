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

public class Display_Search_By_Date extends AppCompatActivity {

    Spinner display_date_spinner;
    String uname;
    //ArrayList<DataModelForDateSearch> dataModels;
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
        display_date_spinner = (Spinner) findViewById(R.id.display_date_spinner);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        click = (Button) findViewById(R.id.click);
        String myclassid = frstTab.classid;
        final MobattendDatabase db = new MobattendDatabase(this);
        Cursor sky3 = db.displayDate1(myclassid);
        final List<String> array1 = new ArrayList<>();

        //  String[] array = new String[sky2.getCount()];
        //  int i =0;
        while (sky3.moveToNext()) {
            uname = sky3.getString(0);
            array1.add("Select A date");
            array1.add(uname);
        }
        final ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, array1);
        display_date_spinner.setAdapter(adapter1);


        //dataModels = new ArrayList<>();
        //date = new SimpleDateFormat("MMMM d,yyyy").format(new Date());
        //MobattendDatabase db3 = new MobattendDatabase(getContext());

        View emptyView = getLayoutInflater().inflate(R.layout.emptydatesearch, null);





        click.setOnClickListener(new View.OnClickListener() {
                ArrayList<DataModelForDateSearch> dataModels;
            @Override
            public void onClick(View v) {
                listView = (ListView) findViewById(R.id.list);
                dataModels = new ArrayList<DataModelForDateSearch>();
                String SpinnerText = display_date_spinner.getSelectedItem().toString();

                String fine1 = frstTab.classid;



                Cursor getstudent = db.checkingRoll(fine1, SpinnerText);
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
