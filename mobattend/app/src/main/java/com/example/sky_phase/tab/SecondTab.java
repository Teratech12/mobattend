package com.example.sky_phase.tab;


import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sky_phase.tab.R.id;
import com.example.sky_phase.tab.R.layout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by SKY-PHASE on 1/31/2017.
 */

public class SecondTab extends Fragment {
    ArrayList<DataModelforScreenTwo> dataModels;
    ListView listView;
    String date;
    FloatingActionButton fab;
    Activity myactivity = getActivity();

    private static CustomAdapterforScreenTwo adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(layout.secondtab, container, false);
        runThis();
        this.listView = (ListView) rootView.findViewById(id.listsecond);

        this.dataModels = new ArrayList<>();
        this.date = new SimpleDateFormat("MMMM d,yyyy").format(new Date());
        this.dataModels.add(new DataModelforScreenTwo("Linear Electronics", "COE 251","January 23, 2016"));
        this.dataModels.add(new DataModelforScreenTwo("Calculus", "MATH 151","March 4, 2015"));
        this.dataModels.add(new DataModelforScreenTwo("Embedded System", "COE 351","March 4, 2015"));
        this.dataModels.add(new DataModelforScreenTwo("Thermodynamics", "MATH 151","March 4, 2014"));
        this.dataModels.add(new DataModelforScreenTwo("Operating System", "COE 151","March 4, 2015"));
        this.dataModels.add(new DataModelforScreenTwo("Database", "COE 451","March 4, 2015"));
        this.dataModels.add(new DataModelforScreenTwo("Calculus", "MATH 151","March 4, 2015"));
        this.dataModels.add(new DataModelforScreenTwo("Calculus", "MATH 151","March 4, 2015"));
        this.dataModels.add(new DataModelforScreenTwo("Calculus", "MATH 151","March 4, 2015"));
        this.dataModels.add(new DataModelforScreenTwo("Calculus", "MATH 151","March 4, 2015"));

      /*  listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(myactivity,"yes yes yes",Toast.LENGTH_LONG).show();
            }
        });
        SecondTab.adapter = new CustomAdapterforScreenTwo(this.dataModels, this.getActivity());
*/

        this.listView.setAdapter(SecondTab.adapter);



        this.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TAG","meeJJJJJJJJJJJJJJJeeh");
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



        return rootView;




    }


    @TargetApi(Build.VERSION_CODES.M)
    public void runThis(){

     final Context contex = getContext();
       final Activity activity = getActivity();



        this.fab.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                 Toast.makeText(activity, "here there am a floating bar",Toast.LENGTH_LONG).show();
                //    Toast.makeText(SecondTab.this, "hey", Toast.LENGTH_SHORT).show();
                LayoutInflater factory = LayoutInflater.from(contex);
                final View textEntryView = factory.inflate(layout.text_entry, null);


                final AlertDialog.Builder alert = new AlertDialog.Builder(view.getContext());



                alert.setIcon(R.drawable.user).setTitle("Add new class").setMessage("choose one of these").setView(textEntryView);


                alert .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {



                        TextView one = (TextView) textEntryView.findViewById(id.text1);
                        TextView two = (TextView) textEntryView.findViewById(id.text2);













                    }
                }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       dialog.cancel();

                    }
                });
                AlertDialog alertDialog = alert.create();

                alertDialog.show();

            }
        });



    }
}
