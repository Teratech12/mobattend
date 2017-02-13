package com.example.sky_phase.tab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by SKY-PHASE on 1/31/2017.
 */

public class newme extends Fragment {
    ArrayList<DataModelforScreenTwo> dataModels;
    ListView listView;
    String date;
    private static CustomAdapterforScreenTwo adapter;
       Activity myactivity = this.getActivity();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.secondtab, container, false);
        listView = (ListView) rootView.findViewById(R.id.listsecond);
        dataModels = new ArrayList<>();
        date = new SimpleDateFormat("MMMM d,yyyy").format(new Date());
        dataModels.add(new DataModelforScreenTwo("Linear Electronics", "COE 251","January 23, 2016"));
        dataModels.add(new DataModelforScreenTwo("Calculus", "MATH 151","March 4, 2015"));
        dataModels.add(new DataModelforScreenTwo("Embedded System", "COE 351","March 4, 2015"));
        dataModels.add(new DataModelforScreenTwo("Thermodynamics", "MATH 151","March 4, 2014"));
        dataModels.add(new DataModelforScreenTwo("Operating System", "COE 151","March 4, 2015"));
        dataModels.add(new DataModelforScreenTwo("Database", "COE 451","March 4, 2015"));
        dataModels.add(new DataModelforScreenTwo("Calculus", "MATH 151","March 4, 2015"));
        dataModels.add(new DataModelforScreenTwo("Calculus", "MATH 151","March 4, 2015"));
        dataModels.add(new DataModelforScreenTwo("Calculus", "MATH 151","March 4, 2015"));
        dataModels.add(new DataModelforScreenTwo("Calculus", "MATH 151","March 4, 2015"));
        dataModels.add(new DataModelforScreenTwo("Linear Electronics", "COE 251","January 23, 2016"));
        dataModels.add(new DataModelforScreenTwo("Calculus", "MATH 151","March 4, 2015"));
        dataModels.add(new DataModelforScreenTwo("Embedded System", "COE 351","March 4, 2015"));
        dataModels.add(new DataModelforScreenTwo("Thermodynamics", "MATH 151","March 4, 2014"));
        dataModels.add(new DataModelforScreenTwo("Operating System", "COE 151","March 4, 2015"));
        dataModels.add(new DataModelforScreenTwo("Database", "COE 451","March 4, 2015"));
        dataModels.add(new DataModelforScreenTwo("Calculus", "MATH 151","March 4, 2015"));
        dataModels.add(new DataModelforScreenTwo("Calculus", "MATH 151","March 4, 2015"));
        dataModels.add(new DataModelforScreenTwo("Calculus", "MATH 151","March 4, 2015"));
        dataModels.add(new DataModelforScreenTwo("Calculus", "MATH 151","March 4, 2015"));
        dataModels.add(new DataModelforScreenTwo("Linear Electronics", "COE 251","January 23, 2016"));
        dataModels.add(new DataModelforScreenTwo("Calculus", "MATH 151","March 4, 2015"));
        dataModels.add(new DataModelforScreenTwo("Embedded System", "COE 351","March 4, 2015"));
        dataModels.add(new DataModelforScreenTwo("Thermodynamics", "MATH 151","March 4, 2014"));
        dataModels.add(new DataModelforScreenTwo("Operating System", "COE 151","March 4, 2015"));
        dataModels.add(new DataModelforScreenTwo("Database", "COE 451","March 4, 2015"));
        dataModels.add(new DataModelforScreenTwo("Calculus", "MATH 151","March 4, 2015"));
        dataModels.add(new DataModelforScreenTwo("Calculus", "MATH 151","March 4, 2015"));
        dataModels.add(new DataModelforScreenTwo("Calculus", "MATH 151","March 4, 2015"));
        dataModels.add(new DataModelforScreenTwo("Calculus", "MATH 151","March 4, 2015"));
        dataModels.add(new DataModelforScreenTwo("Linear Electronics", "COE 251","January 23, 2016"));
        dataModels.add(new DataModelforScreenTwo("Calculus", "MATH 151","March 4, 2015"));
        dataModels.add(new DataModelforScreenTwo("Embedded System", "COE 351","March 4, 2015"));
        dataModels.add(new DataModelforScreenTwo("Thermodynamics", "MATH 151","March 4, 2014"));
        dataModels.add(new DataModelforScreenTwo("Operating System", "COE 151","March 4, 2015"));
        dataModels.add(new DataModelforScreenTwo("Database", "COE 451","March 4, 2015"));
        dataModels.add(new DataModelforScreenTwo("Calculus", "MATH 151","March 4, 2015"));
        dataModels.add(new DataModelforScreenTwo("Calculus", "MATH 151","March 4, 2015"));
        dataModels.add(new DataModelforScreenTwo("Calculus", "MATH 151","March 4, 2015"));
        dataModels.add(new DataModelforScreenTwo("Calculus", "MATH 151","March 4, 2015"));
        dataModels.add(new DataModelforScreenTwo("Linear Electronics", "COE 251","January 23, 2016"));
        dataModels.add(new DataModelforScreenTwo("Calculus", "MATH 151","March 4, 2015"));
        dataModels.add(new DataModelforScreenTwo("Embedded System", "COE 351","March 4, 2015"));
        dataModels.add(new DataModelforScreenTwo("Thermodynamics", "MATH 151","March 4, 2014"));
        dataModels.add(new DataModelforScreenTwo("Operating System", "COE 151","March 4, 2015"));
        dataModels.add(new DataModelforScreenTwo("Database", "COE 451","March 4, 2015"));
        dataModels.add(new DataModelforScreenTwo("Calculus", "MATH 151","March 4, 2015"));
        dataModels.add(new DataModelforScreenTwo("Calculus", "MATH 151","March 4, 2015"));
        dataModels.add(new DataModelforScreenTwo("Calculus", "MATH 151","March 4, 2015"));
        dataModels.add(new DataModelforScreenTwo("Calculus", "MATH 151","March 4, 2015"));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getContext(),"yes yes yes",Toast.LENGTH_LONG).show();

               /* FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.content_fragment, new fragmentActivityFragment());
                ft.commit();*/
                Intent intent = new Intent(getContext(),Myattendance.class);
                startActivity(intent);
            }
        });
        adapter = new CustomAdapterforScreenTwo(this.dataModels, this.getActivity());
        listView.setAdapter(adapter);

        return rootView;

    }
}
