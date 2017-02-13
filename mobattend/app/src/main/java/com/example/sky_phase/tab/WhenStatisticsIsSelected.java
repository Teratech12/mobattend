package com.example.sky_phase.tab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by SKY-PHASE on 1/31/2017.
 */
public class WhenStatisticsIsSelected extends Fragment  {
    LinearLayout linear;
    ArrayList<DataModel> dataModels;
    ListView listView;
    String date;
    private static CustomAdapter adapter;
    ArrayList<DataModelforScreenTwo> dataModels2;
    ListView listView2;
    String date2;

    private static CustomAdapterforScreenTwo adapter2;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.whenstatisticsisselected, container, false);
        listView = (ListView) rootView.findViewById(R.id.firstList);
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
        adapter = new CustomAdapter(dataModels,getActivity());

        listView2.setAdapter(adapter2);

        listView2 = (ListView) rootView.findViewById(R.id.secondlist);
        dataModels2 = new ArrayList<>();
        date = new SimpleDateFormat("MMMM d,yyyy").format(new Date());
        dataModels2.add(new DataModelforScreenTwo("Linear Electronics", "COE 251","January 23, 2016"));
        dataModels2.add(new DataModelforScreenTwo("Calculus", "MATH 151","March 4, 2015"));
        dataModels2.add(new DataModelforScreenTwo("Embedded System", "COE 351","March 4, 2015"));
        dataModels2.add(new DataModelforScreenTwo("Thermodynamics", "MATH 151","March 4, 2014"));
        dataModels2.add(new DataModelforScreenTwo("Operating System", "COE 151","March 4, 2015"));
        dataModels2.add(new DataModelforScreenTwo("Database", "COE 451","March 4, 2015"));
        dataModels2.add(new DataModelforScreenTwo("Calculus", "MATH 151","March 4, 2015"));
        dataModels2.add(new DataModelforScreenTwo("Calculus", "MATH 151","March 4, 2015"));
        dataModels2.add(new DataModelforScreenTwo("Calculus", "MATH 151","March 4, 2015"));
        dataModels2.add(new DataModelforScreenTwo("Calculus", "MATH 151","March 4, 2015"));
        adapter2 = new CustomAdapterforScreenTwo(dataModels2,getActivity());

        listView2.setAdapter(adapter2);


        return rootView;



    }



}