package com.example.sky_phase.mobattend;

import android.annotation.TargetApi;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

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
    TextView status;


    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myattendance);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

<<<<<<< HEAD
        listView = (ListView) findViewById(R.id.listmylist);
        status = (TextView)findViewById(R.id.myststusfinal);
        //shakebutton = (ImageButton)findViewById(R.id.shakebutton) ;
        //Animation shake = AnimationUtils.loadAnimation(this, R.anim.shakewell);
        //shakebutton.startAnimation(shake);
=======
        listView = (ListView) findViewById(R.id.list);
>>>>>>> dae4a18e0f604a8f6f6fa568fdfa72f30898567a


        dataModels = new ArrayList<>();


        Intent intent2 = getIntent();
     final String queryname = intent2.getStringExtra("classidname");

        String fine = you.gblbalmert;

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
                Parcelable state = listView.onSaveInstanceState();

                listView.onRestoreInstanceState(state);

            }
<<<<<<< HEAD
        } listView.setAdapter(adapter);
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
=======
        }
>>>>>>> dae4a18e0f604a8f6f6fa568fdfa72f30898567a

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Myattendance.this,MainActivity.class);
                startActivity(intent);
                finish();

            }
        });


    }



    public  boolean onSupportNavigateUp(){
        finish();

        return true;
    }

}
