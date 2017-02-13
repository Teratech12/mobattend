package com.example.sky_phase.tab;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Myattendance extends AppCompatActivity {
    ArrayList<DataModel> dataModels;
    ListView listView;
    String date;
    private static CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myattendance);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = (ListView) findViewById(R.id.list);
        dataModels = new ArrayList<>();
        date = new SimpleDateFormat("MMMM d,yyyy").format(new Date());
        dataModels.add(new DataModel("Afred Annor", "22752514"));
        dataModels.add(new DataModel("Obeng Richard", "2275714"));
        dataModels.add(new DataModel("Jephter Danso", "2248714"));
        dataModels.add(new DataModel("Prince Awuah", "224714"));
        dataModels.add(new DataModel("Michael Surname", "2275714"));
        dataModels.add(new DataModel("Andy Surname", "2275714"));
        dataModels.add(new DataModel("Akua Kobi", "2274554"));
        dataModels.add(new DataModel("Gregory Aidoo", "22415714"));
        dataModels.add(new DataModel("Obeng Richard", "2275714"));
        dataModels.add(new DataModel("Jephter Danso", "2248714"));
        dataModels.add(new DataModel("Prince Awuah", "224714"));
        dataModels.add(new DataModel("Michael Surname", "2275714"));
        dataModels.add(new DataModel("Andy Surname", "2275714"));
        dataModels.add(new DataModel("Akua Kobi", "2274554"));
        dataModels.add(new DataModel("Gregory Aidoo", "22415714"));
        dataModels.add(new DataModel("Obeng Richard", "2275714"));
        dataModels.add(new DataModel("Jephter Danso", "2248714"));
        dataModels.add(new DataModel("Prince Awuah", "224714"));
        dataModels.add(new DataModel("Michael Surname", "2275714"));
        dataModels.add(new DataModel("Andy Surname", "2275714"));
        dataModels.add(new DataModel("Akua Kobi", "2274554"));
        dataModels.add(new DataModel("Gregory Aidoo", "22415714"));
        dataModels.add(new DataModel("Obeng Richard", "2275714"));
        dataModels.add(new DataModel("Jephter Danso", "2248714"));
        dataModels.add(new DataModel("Prince Awuah", "224714"));
        dataModels.add(new DataModel("Michael Surname", "2275714"));
        dataModels.add(new DataModel("Andy Surname", "2275714"));
        dataModels.add(new DataModel("Akua Kobi", "2274554"));
        dataModels.add(new DataModel("Gregory Aidoo", "22415714"));
        dataModels.add(new DataModel("Obeng Richard", "2275714"));
        dataModels.add(new DataModel("Jephter Danso", "2248714"));
        dataModels.add(new DataModel("Prince Awuah", "224714"));
        dataModels.add(new DataModel("Michael Surname", "2275714"));
        dataModels.add(new DataModel("Andy Surname", "2275714"));
        dataModels.add(new DataModel("Akua Kobi", "2274554"));
        dataModels.add(new DataModel("Gregory Aidoo", "22415714"));
        dataModels.add(new DataModel("Obeng Richard", "2275714"));
        dataModels.add(new DataModel("Jephter Danso", "2248714"));
        dataModels.add(new DataModel("Prince Awuah", "224714"));
        dataModels.add(new DataModel("Michael Surname", "2275714"));
        dataModels.add(new DataModel("Andy Surname", "2275714"));
        dataModels.add(new DataModel("Akua Kobi", "2274554"));
        dataModels.add(new DataModel("Gregory Aidoo", "22415714"));
        dataModels.add(new DataModel("Obeng Richard", "2275714"));
        dataModels.add(new DataModel("Jephter Danso", "2248714"));
        dataModels.add(new DataModel("Prince Awuah", "224714"));
        dataModels.add(new DataModel("Michael Surname", "2275714"));
        dataModels.add(new DataModel("Andy Surname", "2275714"));
        dataModels.add(new DataModel("Akua Kobi", "2274554"));
        dataModels.add(new DataModel("Gregory Aidoo", "22415714"));
        dataModels.add(new DataModel("Obeng Richard", "2275714"));
        dataModels.add(new DataModel("Jephter Danso", "2248714"));
        dataModels.add(new DataModel("Prince Awuah", "224714"));
        dataModels.add(new DataModel("Michael Surname", "2275714"));
        dataModels.add(new DataModel("Andy Surname", "2275714"));
        dataModels.add(new DataModel("Akua Kobi", "2274554"));
        dataModels.add(new DataModel("Gregory Aidoo", "22415714"));

        adapter = new CustomAdapter(dataModels,Myattendance.this);

        listView.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
