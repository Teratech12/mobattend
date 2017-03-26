package com.example.sky_phase.mobattend;

//Code to take attendance




import android.annotation.TargetApi;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class Myattendance extends AppCompatActivity {
    ArrayList<DataModel> dataModels;
    ListView listView;
    String date;
    private static CustomAdapter adapter;
    ClasssFragment you = new ClasssFragment();
    // String queryname;
    String myname;
    String getID;
    String getClass;
    ImageButton shakebutton;


    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myattendance);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listView = (ListView) findViewById(R.id.list);
        shakebutton = (ImageButton)findViewById(R.id.shakebutton) ;
        Animation shake = AnimationUtils.loadAnimation(this, R.anim.shakewell);
        shakebutton.startAnimation(shake);


        dataModels = new ArrayList<>();


        Intent intent2 = getIntent();
        final String queryname = intent2.getStringExtra("classidname");

        String fine = you.gblbalmert;
        Toast.makeText(Myattendance.this,fine,Toast.LENGTH_LONG).show();
        final RelativeLayout cordinate = (RelativeLayout) findViewById(R.id.content_myattendance);

        //Toast.makeText(Myattendance.this,"put "+queryname,Toast.LENGTH_LONG).show();

        // Toast.makeText(Myattendance.this,queryname,Toast.LENGTH_LONG).show();
        MobattendDatabase db1 = new MobattendDatabase(getApplicationContext());
        Cursor sky = db1.getListContents2(fine);
        if(sky.getCount() == 0){

        }
        else{
            while (sky.moveToNext()){
                dataModels.add(new DataModel(sky.getString(1),sky.getString(0)));
                adapter = new CustomAdapter(dataModels,getApplicationContext());
                myname = sky.getString(1);
                getID = sky.getString(0);
                getClass = sky.getString(3);
                listView.setAdapter(adapter);
            }
        }
       /* date = new SimpleDateFormat("MMMM d,yyyy").format(new Date());
        dataModels.add(new DataModel("Afred Annor", "22752514"));
        dataModels.add(new DataModel("Obeng Richard", "2275714"));
        dataModels.add(new DataModel( "Jephter Danso", "2248714"));
        dataModels.add(new DataModel("Prince Awuah", "224714"));
        dataModels.add(new DataModel( "Michael Surname", "2275714"));
        dataModels.add(new DataModel( "Andy Surname", "2275714"));
        dataModels.add(new DataModel( "Akua Kobi", "2274554"));
        dataModels.add(new DataModel("Gregory Aidoo", "22415714"));
        dataModels.add(new DataModel("Afred Annor", "22752514"));
        dataModels.add(new DataModel("Obeng Richard", "2275714"));
        dataModels.add(new DataModel( "Jephter Danso", "2248714"));
        dataModels.add(new DataModel("Prince Awuah", "224714"));
        dataModels.add(new DataModel( "Michael Surname", "2275714"));
        dataModels.add(new DataModel( "Andy Surname", "2275714"));
        dataModels.add(new DataModel( "Akua Kobi", "2274554"));
        dataModels.add(new DataModel("Gregory Aidoo", "22415714"));
        dataModels.add(new DataModel("Afred Annor", "22752514"));
        dataModels.add(new DataModel("Obeng Richard", "2275714"));
        dataModels.add(new DataModel( "Jephter Danso", "2248714"));
        dataModels.add(new DataModel("Prince Awuah", "224714"));
        dataModels.add(new DataModel( "Michael Surname", "2275714"));
        dataModels.add(new DataModel( "Andy Surname", "2275714"));
        dataModels.add(new DataModel( "Akua Kobi", "2274554"));
        dataModels.add(new DataModel("Gregory Aidoo", "22415714"));
        dataModels.add(new DataModel("Afred Annor", "22752514"));
        dataModels.add(new DataModel("Obeng Richard", "2275714"));
        dataModels.add(new DataModel( "Jephter Danso", "2248714"));
        dataModels.add(new DataModel("Prince Awuah", "224714"));
        dataModels.add(new DataModel( "Michael Surname", "2275714"));
        dataModels.add(new DataModel( "Andy Surname", "2275714"));
        dataModels.add(new DataModel( "Akua Kobi", "2274554"));
        dataModels.add(new DataModel("Gregory Aidoo", "22415714"));
        dataModels.add(new DataModel("Afred Annor", "22752514"));
        dataModels.add(new DataModel("Obeng Richard", "2275714"));
        dataModels.add(new DataModel( "Jephter Danso", "2248714"));
        dataModels.add(new DataModel("Prince Awuah", "224714"));
        dataModels.add(new DataModel( "Michael Surname", "2275714"));
        dataModels.add(new DataModel( "Andy Surname", "2275714"));
        dataModels.add(new DataModel( "Akua Kobi", "2274554"));
        dataModels.add(new DataModel("Gregory Aidoo", "22415714"));

        adapter = new CustomAdapter(dataModels,Myattendance.this);

        listView.setAdapter(adapter); */

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Snackbar.make(cordinate, "Replace ", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });

    }



    public  boolean onSupportNavigateUp(){
        finish();

        return true;
    }

}
