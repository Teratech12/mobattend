package com.example.sky_phase.mobattend;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

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
        View rootView = inflater.inflate(R.layout.secondtab, container, false);

        this.listView = (ListView) rootView.findViewById(R.id.listsecond);

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







}
