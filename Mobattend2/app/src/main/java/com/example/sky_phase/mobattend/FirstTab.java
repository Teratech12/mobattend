package com.example.sky_phase.mobattend;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by SKY-PHASE on 1/31/2017.
 */
public class FirstTab extends Fragment {
    LinearLayout linear;
   static String classid;

    ArrayList<DataModelforScreenTwo> dataModels;
    ListView listView;
    String date;
    private static CustomAdapterforScreenTwo adapter;






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.firsttab, container, false);
    ;
        listView = (ListView) rootView.findViewById(R.id.list);
        dataModels = new ArrayList<>();
        View emptyView = getActivity().getLayoutInflater().inflate(R.layout.emptyclasslist, null);
        ((ViewGroup)listView.getParent()).addView(emptyView);
        MobattendDatabase db = new MobattendDatabase(getActivity());
        Cursor sky2 = db.getListContents();
        if(sky2.getCount() == 0){

        }
        else{
            while (sky2.moveToNext()){
                int count = db.getCount(sky2.getString(0));
                dataModels.add(new DataModelforScreenTwo(sky2.getString(0),sky2.getString(1),String.valueOf(count)));
                adapter = new CustomAdapterforScreenTwo(dataModels,getContext());
                listView.setAdapter(adapter);
                listView.setEmptyView(emptyView);
            }
        }


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                  classid = adapter.getItem(position).getName();

                Intent intent = new Intent(getContext(),ChooseSearch.class);
                startActivity(intent);
            }
        });













        return rootView;



    }



}