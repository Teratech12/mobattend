package com.example.sky_phase.tab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by SKY-PHASE on 1/31/2017.
 */

public class ThirdTab extends Fragment {
    ArrayList<DataModelForGrid> dataModels;
    GridView listView;
    String date;

    private static CustomAdapterforGrid adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.thirdtab, container, false);

        listView = (GridView) rootView.findViewById(R.id.grid);
        dataModels = new ArrayList<>();
        date = new SimpleDateFormat("MMMM d,yyyy").format(new Date());
        dataModels.add(new DataModelForGrid( "COE 251"));
        dataModels.add(new DataModelForGrid( "COE 251"));dataModels.add(new DataModelForGrid( "COE 251"));
        dataModels.add(new DataModelForGrid( "COE 251"));
        dataModels.add(new DataModelForGrid( "COE 251"));
        dataModels.add(new DataModelForGrid( "COE 251"));dataModels.add(new DataModelForGrid( "COE 251"));dataModels.add(new DataModelForGrid( "COE 251"));
        dataModels.add(new DataModelForGrid( "COE 251"));dataModels.add(new DataModelForGrid( "COE 251"));
        dataModels.add(new DataModelForGrid( "COE 251"));
        dataModels.add(new DataModelForGrid( "COE 251"));
        dataModels.add(new DataModelForGrid( "COE 251"));  dataModels.add(new DataModelForGrid( "COE 251"));  dataModels.add(new DataModelForGrid( "COE 251"));  dataModels.add(new DataModelForGrid( "COE 251"));  dataModels.add(new DataModelForGrid( "COE 251"));dataModels.add(new DataModelForGrid( "COE 251"));
        dataModels.add(new DataModelForGrid( "COE 251"));  dataModels.add(new DataModelForGrid( "COE 251"));  dataModels.add(new DataModelForGrid( "COE 251"));
        dataModels.add(new DataModelForGrid( "COE 251"));  dataModels.add(new DataModelForGrid( "COE 251"));  dataModels.add(new DataModelForGrid( "COE 251"));
        dataModels.add(new DataModelForGrid( "COE 251"));  dataModels.add(new DataModelForGrid( "COE 251"));  dataModels.add(new DataModelForGrid( "COE 251"));
        dataModels.add(new DataModelForGrid( "COE 251"));


        adapter = new CustomAdapterforGrid(dataModels,getActivity());

        listView.setAdapter(adapter);

        return rootView;
    }
}
