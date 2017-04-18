package com.example.sky_phase.mobattend;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class GetDeleteList extends AppCompatActivity {
    ListView deletelist;
    TextView namedelete, iddelete;
    ArrayList<DataModelForDeleteList> dataModels;
    private static CustomAdapterToDeleteStudent adapter;
    ClasssFragment you = new ClasssFragment();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_delete_list);
        deletelist = (ListView)findViewById(R.id.deletelist);
        namedelete = (TextView) findViewById(R.id.deletename);
        iddelete = (TextView)findViewById(R.id.deleteid);
        dataModels = new ArrayList<>();

        String fine = you.gblbalmert;


        MobattendDatabase db1 = new MobattendDatabase(getApplicationContext());
        Cursor sky = db1.getListContents2(fine);
        if(sky.getCount() == 0){

        }
        else{
            while (sky.moveToNext()){
                dataModels.add(new DataModelForDeleteList(sky.getString(1),sky.getString(0)));
                adapter = new CustomAdapterToDeleteStudent(dataModels,getApplicationContext());

                deletelist.setAdapter(adapter);
            }
        }

    }
}
