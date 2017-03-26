package com.example.sky_phase.mobattend;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;

public class HoldSdCard extends AppCompatActivity {
    String str;
    ArrayList<String> al;
    ArrayAdapter<String> adapter;
    ListView lv;
    @SuppressLint("SdCardPath")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hold_sd_card);


        ArrayList<String> arr1=GetFiles(Environment.getExternalStorageDirectory().getPath());
        adapter= new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_expandable_list_item_1,arr1);
        lv = (ListView) findViewById(R.id.holdcard);
        lv.setAdapter(adapter);
    }
    private ArrayList<String> GetFiles(String path) {
        ArrayList<String> arr2=new ArrayList<String>();
        File file=new File(path);
        File[] allfiles=file.listFiles();
        if(allfiles.length==0) {
            return null;
        }
        else {
            for(int i=0;i<allfiles.length;i++) {
                arr2.add(allfiles[i].getName());
            }
        }
        return arr2;
    }
}
