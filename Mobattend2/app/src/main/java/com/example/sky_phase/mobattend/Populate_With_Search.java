package com.example.sky_phase.mobattend;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class Populate_With_Search extends AppCompatActivity {
    ListView list;
    private static CustomAdapterToPopulate adapter;
    ArrayList<DataModelForDateSearch> dataModels;
    FirstTab frstTab = new FirstTab();
    String myclassid;
    SearchView search;
    static  String gblbalmert;
    static  String gblbalmert1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_populate__with__search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        list = (ListView)findViewById(R.id.list);
        search = (SearchView)findViewById(R.id.search);
         myclassid = frstTab.classid;

        dataModels = new ArrayList<>();
        final MobattendDatabase db = new MobattendDatabase(getApplicationContext());

        Cursor sky = db.getListContents3(myclassid);
        adapter = new CustomAdapterToPopulate(Populate_With_Search.this,sky,0);
        list.setAdapter(adapter);
        /*if (sky.getCount() == 0) {


        } else {
            while (sky.moveToNext()) {
                dataModels.add(new DataModelForDateSearch(sky.getString(1), sky.getString(0)));
                adapter = new CustomAdapterForDateSearch(dataModels, getApplicationContext());
                list.setAdapter(adapter);


            }

        }*/
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {


            Cursor cursor;
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.e("TAG", "onQueryTextSubmit ");
                cursor = db.getListContentsSearch(myclassid,query);
               if(cursor==null){
                   Toast.makeText(Populate_With_Search.this,"no records found",Toast.LENGTH_SHORT).show();
               }else {
                   Toast.makeText(Populate_With_Search.this, "records found",Toast.LENGTH_SHORT).show();
               }

                 adapter.swapCursor(cursor);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                Log.e("TAG", "onQueryTextSubmit ");


                    cursor = db.getListContentsSearch(myclassid,query);
                if (cursor!=null){
                    adapter.swapCursor(cursor);
                }


                return false;
            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Cursor cursor = (Cursor) adapter.getItem(position);
                String mert = cursor.getString(cursor.getColumnIndex("student_name"));
                String mert1 = cursor.getString(cursor.getColumnIndex("student_id"));
                Toast.makeText(Populate_With_Search.this,mert,Toast.LENGTH_SHORT).show();
                gblbalmert = mert;
                gblbalmert1 = mert1;
                Intent intent = new Intent(Populate_With_Search.this,WhenListIsSelected.class);
                startActivity(intent);

            }
        });


    }
/*
    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {

        final MobattendDatabase db = new MobattendDatabase(getApplicationContext());
        final Context context = this;
        // Inflate the menu; this adds items to the action bar if it is present.

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search_for_populate,menu);
        SearchManager manager = (SearchManager)getSystemService(Context.SEARCH_SERVICE);
        SearchView search = (SearchView)menu.findItem(R.id.searchmenu);
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            Cursor cursor;
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.e("TAG", "onQueryTextSubmit ");
                 cursor = db.getListContentsSearch(myclassid, query);
                if (cursor == null){
                    Toast.makeText(Populate_With_Search.this, "No records found", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(Populate_With_Search.this,"record found",Toast.LENGTH_SHORT).show();
                }
                list.setAdapter(adapter);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.e("TAG", "onQueryTextChange ");
                cursor = db.getListContentsSearch(myclassid, newText);
                if(cursor !=null){
                    list.setAdapter(adapter);
                }

                return false;
            }
        });


        return true;
    }*/

}
